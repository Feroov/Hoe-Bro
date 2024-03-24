package com.hoebro.entity.ai;

import com.hoebro.entity.entity.WoodenHoe;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.ChestBlock;
import net.minecraft.block.CropBlock;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.ChestBlockEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.damage.DamageSources;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.List;

public class WoodenHoeHarvestAndDeliverCropGoal extends Goal
{
    private final WoodenHoe hoeEntity;
    private PlayerEntity nearestPlayer;
    private BlockPos targetCropPos;
    private final World world;
    private final double speed;
    private boolean isDelivering = false;
    private final List<ItemStack> itemsToDeliver = new ArrayList<>();
    private final int sightRange;
    private int harvestedCrops = 0;
    private final int maxHarvestBeforeDeath = 30; // Maximum number of crops to harvest before "death"
    private enum State
    {
        SEARCHING,
        MOVING_TO_CHEST,
        DEPOSITING_IN_CHEST,
        MOVING_TO_PLAYER
    }
    private State currentState = State.SEARCHING;
    private BlockPos nearestChestPos = null;

    public WoodenHoeHarvestAndDeliverCropGoal(WoodenHoe hoeEntity, double speed, int sightRange)
    {
        this.hoeEntity = hoeEntity;
        this.world = hoeEntity.getWorld();
        this.speed = speed;
        this.sightRange = sightRange;
    }

    @Override
    public boolean canStart()
    {
        if (this.hoeEntity.isBusy() || this.isDelivering) return false;

        this.nearestPlayer = this.world.getClosestPlayer(this.hoeEntity, 10);
        this.targetCropPos = findFullyGrownCrop();

        return this.targetCropPos != null;
    }

    private BlockPos findFullyGrownCrop()
    {
        // Search in a grid for mature crops
        BlockPos entityPos = this.hoeEntity.getBlockPos();
        for (int x = -sightRange; x <= sightRange; x++)
        {
            for (int y = -2; y <= 2; y++) // Vertical range -2 to 2 blocks
            {
                for (int z = -sightRange; z <= sightRange; z++)
                {
                    BlockPos blockPos = entityPos.add(x, y, z);
                    BlockState state = this.world.getBlockState(blockPos);
                    if (state.getBlock() instanceof CropBlock crop)
                    {
                        if (crop.isMature(state)) { return blockPos; } // Return the position of the first found mature crop
                    }
                }
            }
        }
        return null;
    }

    @Override
    public void start()
    {
        super.start();
        this.hoeEntity.getNavigation().startMovingTo(this.targetCropPos.getX(),
                this.targetCropPos.getY(), this.targetCropPos.getZ(), this.speed);
    }

    @Override
    public void tick()
    {
        // Perform actions based on the current state
        switch (currentState)
        {
            case SEARCHING:
                searchForTasks();
                break;
            case MOVING_TO_CHEST:
                moveToChest();
                break;
            case DEPOSITING_IN_CHEST:
                depositItemsInChest();
                break;
            case MOVING_TO_PLAYER:
                moveToPlayer();
                break;
        }
    }

    private void moveToPlayer()
    {
        // Ensure there is a nearest player to deliver items to.
        if (nearestPlayer != null)
        {
            // Move towards the player.
            this.hoeEntity.getNavigation().startMovingTo(nearestPlayer, this.speed);

            // Check if the WoodenHoe entity is close enough to the player to deliver the items.
            if (this.hoeEntity.squaredDistanceTo(nearestPlayer) < 4.0)
            {
                // Deliver items to player.
                deliverToPlayer(nearestPlayer);

                // Reset state to searching after delivering items.
                this.currentState = State.SEARCHING;
                this.isDelivering = false; // Ensure the delivering flag is reset.
            }
        }
    }

    private void searchForTasks()
    {
        if (!this.hoeEntity.isBusy() && !this.isDelivering)
        {
            this.targetCropPos = findFullyGrownCrop();
            if (this.targetCropPos != null)
            {
                // Immediately harvest and switch to delivering state to avoid harvesting multiple crops
                harvestCrop(this.targetCropPos);
                this.isDelivering = true; // Make sure this flag is used to prevent immediate re-harvesting
                prepareForDelivery();
            }
        }
    }

    private void prepareForDelivery()
    {
        // Determine the delivery mode (to player or chest) and set the currentState accordingly
        if (!itemsToDeliver.isEmpty())
        {
            if (this.hoeEntity.isDeliverToChestMode())
            {
                BlockPos chestPos = findNearestChest();
                if (chestPos != null)
                {
                    nearestChestPos = chestPos;
                    currentState = State.MOVING_TO_CHEST;
                }
            }
            else
            {
                this.nearestPlayer = this.world.getClosestPlayer(this.hoeEntity, 15);
                if (this.nearestPlayer != null)
                {
                    currentState = State.MOVING_TO_PLAYER;
                }
            }
        }
    }

    private void moveToChest()
    {
        if (nearestChestPos.isWithinDistance(this.hoeEntity.getPos(), 2))
        {
            currentState = State.DEPOSITING_IN_CHEST;
        }
        else
        {
            this.hoeEntity.getNavigation().startMovingTo(nearestChestPos.getX(), nearestChestPos.getY(), nearestChestPos.getZ(), this.speed);
        }
    }

    private void depositItemsInChest()
    {
        BlockEntity chestEntity = this.world.getBlockEntity(nearestChestPos);
        if (chestEntity instanceof ChestBlockEntity)
        {
            ChestBlockEntity chest = (ChestBlockEntity) chestEntity;

            for (ItemStack stack : itemsToDeliver)
            {
                boolean itemDeposited = false;

                // Try to stack with existing items first
                for (int i = 0; i < chest.size(); i++)
                {
                    ItemStack existingStack = chest.getStack(i);
                    if (ItemStack.canCombine(existingStack, stack))
                    {
                        int transferAmount = Math.min(stack.getCount(), existingStack.getMaxCount() - existingStack.getCount());
                        existingStack.increment(transferAmount);
                        stack.decrement(transferAmount);
                        itemDeposited = true;

                        if (stack.isEmpty()) { break; }
                    }
                }

                // If stack is not empty, try to place it in an empty slot
                if (!stack.isEmpty())
                {
                    for (int i = 0; i < chest.size(); i++)
                    {
                        if (chest.getStack(i).isEmpty())
                        {
                            chest.setStack(i, stack.copy());
                            stack.setCount(0);
                            itemDeposited = true;
                            break;
                        }
                    }
                }

                // If item could not be deposited (chest is full), drop the item
                if (!itemDeposited)
                {
                    ItemEntity itemEntity = new ItemEntity(this.world, nearestChestPos.getX() + 0.5,
                            nearestChestPos.getY() + 1, nearestChestPos.getZ() + 0.5, stack);
                    this.world.spawnEntity(itemEntity);
                }
            }

            itemsToDeliver.clear();
            this.isDelivering = false;
            this.currentState = State.SEARCHING;
        }
    }

    private void harvestCrop(BlockPos cropPos)
    {
        if (this.world instanceof ServerWorld)
        {
            BlockState cropState = this.world.getBlockState(cropPos);
            if (cropState.getBlock() instanceof CropBlock && ((CropBlock) cropState.getBlock()).isMature(cropState))
            {
                boolean blockRemoved = this.world.breakBlock(cropPos, false);
                if (blockRemoved)
                {
                    List<ItemStack> drops = determineCropDrops(cropState);
                    itemsToDeliver.addAll(drops);

                    this.targetCropPos = null;
                    this.isDelivering = true;

                    harvestedCrops++;
                    if (harvestedCrops >= maxHarvestBeforeDeath)
                    {
                        DamageSources damageSources = this.world.getDamageSources();
                        DamageSource genericDamage = damageSources.generic();
                        this.hoeEntity.damage(genericDamage, Float.MAX_VALUE);
                    }
                }
            }
        }
    }

    private List<ItemStack> determineCropDrops(BlockState cropState)
    {
        List<ItemStack> drops = new ArrayList<>();

        if (cropState.isOf(Blocks.WHEAT))
        {
            drops.add(new ItemStack(Items.WHEAT, 1));
            int seedDropChance = this.world.random.nextInt(4);
            if (seedDropChance > 0)
            {
                drops.add(new ItemStack(Items.WHEAT_SEEDS, seedDropChance));
            }
        }
        else if (cropState.isOf(Blocks.CARROTS))
        {
            int carrotDropChance = 1 + this.world.random.nextInt(4);
            drops.add(new ItemStack(Items.CARROT, carrotDropChance));
        }
        else if (cropState.isOf(Blocks.POTATOES))
        {
            int potatoDropChance = 1 + this.world.random.nextInt(4);
            drops.add(new ItemStack(Items.POTATO, potatoDropChance));
        }
        else if (cropState.isOf(Blocks.BEETROOTS))
        {
            drops.add(new ItemStack(Items.BEETROOT, 1));
            int seedDropChance = this.world.random.nextInt(4);
            if (seedDropChance > 0)
            {
                drops.add(new ItemStack(Items.BEETROOT_SEEDS, seedDropChance));
            }
        }
        return drops;
    }

    private void deliverToPlayer(PlayerEntity player)
    {
        if (!this.world.isClient)
        {
            // Loop through each item in the itemsToDeliver list.
            for (ItemStack stack : new ArrayList<>(itemsToDeliver))
            {
                // Create a new ItemEntity at the WoodenHoe entity's location with the item stack.
                ItemEntity itemEntity = new ItemEntity(this.world, this.hoeEntity.getX(), this.hoeEntity.getY(), this.hoeEntity.getZ(), stack);

                // Calculate the direction vector to throw the item towards the player.
                double dx = player.getX() - this.hoeEntity.getX();
                double dy = player.getBodyY(0.5) - itemEntity.getY(); // Aim towards the middle of the player's body to ensure better visibility.
                double dz = player.getZ() - this.hoeEntity.getZ();
                double distance = Math.sqrt(dx * dx + dy * dy + dz * dz);

                // Normalize the direction vector and apply a speed factor to "throw" the item towards the player.
                itemEntity.setVelocity(dx / distance * 0.1, dy / distance * 0.1 + 0.3, dz / distance * 0.1);

                // Spawn the item entity in the world, effectively "throwing" it towards the player.
                this.world.spawnEntity(itemEntity);

                // Optionally, play a sound effect to signal the delivery (e.g., item pickup sound).
                this.world.playSound(null, player.getX(), player.getY(), player.getZ(), SoundEvents.ENTITY_ITEM_PICKUP, player.getSoundCategory(), 1.0F, 1.0F);
            }
            // Clear the itemsToDeliver list after all items have been "thrown" towards the player.
            itemsToDeliver.clear();
            // Reset the isDelivering flag to allow for new deliveries.
            this.isDelivering = false;
        }
    }

    private BlockPos findNearestChest()
    {
        BlockPos entityPos = this.hoeEntity.getBlockPos();
        // A 15-block range check for chests
        for (int x = -15; x <= 15; x++)
        {
            for (int y = -15; y <= 15; y++)
            {
                for (int z = -15; z <= 15; z++)
                {
                    BlockPos blockPos = entityPos.add(x, y, z);
                    BlockState state = this.world.getBlockState(blockPos);
                    if (state.getBlock() instanceof ChestBlock) { return blockPos; }
                }
            }
        }
        return null;
    }

    @Override
    public boolean shouldContinue()
    {
        // Continue if not yet delivering and crop target is set, or if in delivery process.
        return (this.targetCropPos != null || this.isDelivering) && this.nearestPlayer != null;
    }

    @Override
    public void stop()
    {
        // Reset variables to ensure clean start for next run
        this.targetCropPos = null;
        this.isDelivering = false;
        super.stop();
    }
}
