package com.hoebro.entity.entity;

import com.hoebro.entity.ai.HarvestAndDeliverCropGoal;
import net.minecraft.entity.AnimationState;
import net.minecraft.entity.EntityPose;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.LookAroundGoal;
import net.minecraft.entity.ai.goal.LookAtEntityGoal;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.AmbientEntity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class WoodenHoe extends AmbientEntity
{
    public final AnimationState idleAnimationState = new AnimationState();
    private int idleAnimationTimeout = 0;

    public WoodenHoe(EntityType<? extends AmbientEntity> entityType, World world)
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

    @Override
    public void tick()
    {
        super.tick();
        if(this.getWorld().isClient()) { setupAnimationStates(); }
    }

    @Override
    protected void initGoals()
    {
        this.goalSelector.add(0, new SwimGoal(this));
        this.goalSelector.add(1, new HarvestAndDeliverCropGoal(this, 1.0f));
        this.goalSelector.add(5, new LookAtEntityGoal(this, PlayerEntity.class, 4f));
        this.goalSelector.add(6, new LookAroundGoal(this));
    }

    public static DefaultAttributeContainer.Builder createWoodenHoeAttributes()
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
        this.playSound(SoundEvents.BLOCK_WOOD_PLACE, 1.0F, 2.0F);
        return null;
    }

    @Nullable
    @Override
    protected SoundEvent getHurtSound(DamageSource source)
    {
        this.playSound(SoundEvents.BLOCK_BAMBOO_WOOD_BREAK, 1.0F, 2.0F);
        return null;
    }

    @Nullable
    @Override
    protected SoundEvent getDeathSound()
    {
        this.playSound(SoundEvents.ENTITY_WITHER_SKELETON_DEATH, 1.0F, 2.0F);
        return null;
    }
}
