package com.hoebro.entity.ai;

import com.hoebro.entity.entity.WoodenHoe;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.CropBlock;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.List;

public class HarvestAndDeliverCropGoal extends Goal
{
    private final WoodenHoe hoeEntity;
    private PlayerEntity nearestPlayer;
    private BlockPos targetCropPos;
    private final World world;
    private final double speed;
    private boolean isDelivering = false;
    private final List<ItemStack> itemsToDeliver = new ArrayList<>();

    public HarvestAndDeliverCropGoal(WoodenHoe hoeEntity, double speed)
    {
        this.hoeEntity = hoeEntity;
        this.world = hoeEntity.getWorld();
        this.speed = speed;
    }

    @Override
    public boolean canStart()
    {
        if (this.hoeEntity.isBusy() || this.isDelivering) return false;
        this.nearestPlayer = this.world.getClosestPlayer(this.hoeEntity, 10);
        if (this.nearestPlayer == null) return false;

        this.targetCropPos = findFullyGrownCrop();
        return this.targetCropPos != null;
    }

    private BlockPos findFullyGrownCrop() {
        BlockPos entityPos = this.hoeEntity.getBlockPos();
        for (int x = -5; x <= 5; x++)
        {
            for (int y = -2; y <= 2; y++)
            {
                for (int z = -5; z <= 5; z++)
                {
                    BlockPos blockPos = entityPos.add(x, y, z);
                    BlockState state = this.world.getBlockState(blockPos);
                    if (state.getBlock() instanceof CropBlock crop)
                    {
                        if (crop.isMature(state)) { return blockPos; }
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
        this.hoeEntity.getNavigation().startMovingTo(this.targetCropPos.getX(), this.targetCropPos.getY(), this.targetCropPos.getZ(), this.speed);
    }

    @Override
    public void tick()
    {
        if (this.targetCropPos != null && this.targetCropPos.isWithinDistance(this.hoeEntity.getPos(), 2) && !this.isDelivering)
        {
            harvestCrop(this.targetCropPos);
        }
        else if (this.isDelivering) {deliverToPlayer(this.nearestPlayer);}
    }

    private void harvestCrop(BlockPos cropPos)
    {
        if (this.world instanceof ServerWorld)
        {
            BlockState cropState = this.world.getBlockState(cropPos);
            if (cropState.getBlock() instanceof CropBlock && ((CropBlock) cropState.getBlock()).isMature(cropState)) {
                boolean blockRemoved = this.world.breakBlock(cropPos, false);
                if (blockRemoved)
                {
                    List<ItemStack> drops = determineCropDrops(cropState);
                    itemsToDeliver.addAll(drops);

                    this.targetCropPos = null;
                    this.isDelivering = true;
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
        this.hoeEntity.getNavigation().startMovingTo(player, this.speed);
        if (this.hoeEntity.squaredDistanceTo(player) < 2.0 && !itemsToDeliver.isEmpty())
        {
            if (!this.world.isClient)
            { // Make sure we are on the server side
                itemsToDeliver.forEach(stack ->
                {
                    ItemEntity itemEntity = new ItemEntity(this.world, this.hoeEntity.getX(), this.hoeEntity.getY(), this.hoeEntity.getZ(), stack);

                    // Calculate direction to throw the item towards the player
                    double dx = player.getX() - this.hoeEntity.getX();
                    double dy = player.getY() - this.hoeEntity.getY();
                    double dz = player.getZ() - this.hoeEntity.getZ();
                    double distance = Math.sqrt(dx * dx + dy * dy + dz * dz);

                    // Set motion to "throw" the item towards the player
                    itemEntity.setVelocity(dx * 0.1 / distance, dy * 0.1 / distance + 0.3, dz * 0.1 / distance);

                    this.world.spawnEntity(itemEntity); // Spawn the item entity in the world

                    // Play the item pick-up sound to all nearby players
                    this.world.playSound(null, player.getX(), player.getY(), player.getZ(), SoundEvents.ENTITY_ITEM_PICKUP, player.getSoundCategory(), 1.0F, 1.0F);
                });
                itemsToDeliver.clear();
                this.isDelivering = false;
            }
        }
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
