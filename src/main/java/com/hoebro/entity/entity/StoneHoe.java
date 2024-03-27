package com.hoebro.entity.entity;

import com.hoebro.entity.ai.StoneHoeAI;
import net.minecraft.entity.AnimationState;
import net.minecraft.entity.EntityPose;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.LookAroundGoal;
import net.minecraft.entity.ai.goal.LookAtEntityGoal;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;


public class StoneHoe extends PathAwareEntity
{
    public final AnimationState idleAnimationState = new AnimationState();
    private int idleAnimationTimeout = 0;
    private boolean deliverToChestMode = false;

    public StoneHoe(EntityType<? extends PathAwareEntity> entityType, World world)
    {
        super(entityType, world);
    }

    private void setupAnimationStates()
    {
        if (this.idleAnimationTimeout <= 0)
        {
            this.idleAnimationTimeout = this.random.nextInt(40) + 80;
            this.idleAnimationState.start(this.age);
        }
        else {--this.idleAnimationTimeout; }
    }

    @Override
    protected void updateLimbs(float posDelta)
    {
        float f = this.getPose() == EntityPose.STANDING ? Math.min(posDelta * 6.0f, 1.0f) : 0.0f;
        this.limbAnimator.updateLimbs(f, 0.2f);
    }

    public boolean isBusy() { return this.getNavigation().isFollowingPath(); }

    public boolean isDeliverToChestMode() { return deliverToChestMode; }

    @Override
    public ActionResult interactMob(PlayerEntity player, Hand hand)
    {
        if (!this.getWorld().isClient)
        {
            // This check ensures we're on the server side.
            this.deliverToChestMode = !this.deliverToChestMode;

            // Spawn the happy villager particle effect around the entity to notify the player
            for (int i = 0; i < 10; i++)
            {
                double d0 = this.random.nextGaussian() * 0.02D;
                double d1 = this.random.nextGaussian() * 0.02D;
                double d2 = this.random.nextGaussian() * 0.02D;
                // This method call should cause particles to appear on the client side.
                ((ServerWorld) this.getWorld()).spawnParticles(ParticleTypes.HAPPY_VILLAGER,
                        this.getX(), this.getBodyY(0.5D), this.getZ(),
                        1, d0, d1, d2, 0.0D);
            }

            // Play the item pick-up sound to notify the player
            this.getWorld().playSound(null, this.getX(), this.getY(), this.getZ(),
                    SoundEvents.ENTITY_ITEM_PICKUP, this.getSoundCategory(), 1.0F, 1.0F);

            // Let the player know the delivery mode has changed with a chat message (optional)
            if (this.deliverToChestMode)
            {
                player.sendMessage(Text.translatable("Deliver to Chest"), true);
            }
            else
            {
                player.sendMessage(Text.translatable("Deliver to Player"), true);
            }
            return ActionResult.SUCCESS;
        }
        return ActionResult.CONSUME;
    }

    @Override
    public void writeCustomDataToNbt(NbtCompound nbt)
    {
        super.writeCustomDataToNbt(nbt);
        // Save the delivery mode to the NBT data
        nbt.putBoolean("DeliverToChestMode", this.deliverToChestMode);
    }

    @Override
    public void readCustomDataFromNbt(NbtCompound nbt)
    {
        super.readCustomDataFromNbt(nbt);
        // Read the delivery mode from the NBT data
        this.deliverToChestMode = nbt.getBoolean("DeliverToChestMode");
    }

    @Override
    public void tick()
    {
        super.tick();
        if(this.getWorld().isClient()) { setupAnimationStates(); }
    }

    @Override
    protected void initGoals()
    {
        super.initGoals();
        this.goalSelector.add(0, new SwimGoal(this));
        this.goalSelector.add(1, new StoneHoeAI(this, 1.25f, 10, 10, 110));
        this.goalSelector.add(2, new LookAtEntityGoal(this, PlayerEntity.class, 4f));
        this.goalSelector.add(3, new LookAroundGoal(this));
    }

    public static DefaultAttributeContainer.Builder createAttributes()
    {
        return MobEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 6)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.2f)
                .add(EntityAttributes.GENERIC_ARMOR, 0.5f);
    }

    @Nullable
    @Override
    protected SoundEvent getAmbientSound()
    {
        this.playSound(SoundEvents.ENTITY_WITHER_SKELETON_AMBIENT, 1.0F, 2.2F);
        return null;
    }

    @Nullable
    @Override
    protected SoundEvent getHurtSound(DamageSource source)
    {
        this.playSound(SoundEvents.BLOCK_BAMBOO_WOOD_BREAK, 1.0F, 1.2F);
        return null;
    }

    @Nullable
    @Override
    protected SoundEvent getDeathSound()
    {
        this.playSound(SoundEvents.ENTITY_WITHER_SKELETON_DEATH, 1.0F, 1.4F);
        return null;
    }
}
