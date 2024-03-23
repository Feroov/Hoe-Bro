package com.hoebro.entity.animation;

import net.minecraft.client.render.entity.animation.Animation;
import net.minecraft.client.render.entity.animation.AnimationHelper;
import net.minecraft.client.render.entity.animation.Keyframe;
import net.minecraft.client.render.entity.animation.Transformation;

public class HoeBroAnimations
{

    public static final Animation HOES_IDLE = Animation.Builder.create(0f).build();
    public static final Animation HOES_WALK = Animation.Builder.create(1f).looping().addBoneAnimation("woodenhoe", new Transformation(Transformation.Targets.TRANSLATE, new Keyframe(0f, AnimationHelper.createTranslationalVector(0f, 0f, 0f), Transformation.Interpolations.LINEAR), new Keyframe(0.5f, AnimationHelper.createTranslationalVector(0f, 0f, 0f), Transformation.Interpolations.CUBIC), new Keyframe(1f, AnimationHelper.createTranslationalVector(0f, 0f, 0f), Transformation.Interpolations.CUBIC))).addBoneAnimation("woodenhoe", new Transformation(Transformation.Targets.ROTATE, new Keyframe(0f, AnimationHelper.createRotationalVector(0f, 10f, 0f), Transformation.Interpolations.LINEAR), new Keyframe(0.25f, AnimationHelper.createRotationalVector(0f, -10f, 0f), Transformation.Interpolations.CUBIC), new Keyframe(0.5f, AnimationHelper.createRotationalVector(0f, 10f, 0f), Transformation.Interpolations.CUBIC), new Keyframe(0.75f, AnimationHelper.createRotationalVector(0f, -10f, 0f), Transformation.Interpolations.CUBIC), new Keyframe(1f, AnimationHelper.createRotationalVector(0f, 10f, 0f), Transformation.Interpolations.CUBIC))).addBoneAnimation("leftleg", new Transformation(Transformation.Targets.TRANSLATE, new Keyframe(0f, AnimationHelper.createTranslationalVector(-5f, 0f, 3f), Transformation.Interpolations.LINEAR), new Keyframe(0.5f, AnimationHelper.createTranslationalVector(3f, 0f, -5f), Transformation.Interpolations.CUBIC), new Keyframe(1f, AnimationHelper.createTranslationalVector(-5f, 0f, 3f), Transformation.Interpolations.CUBIC))).addBoneAnimation("leftleg", new Transformation(Transformation.Targets.ROTATE, new Keyframe(0f, AnimationHelper.createRotationalVector(0f, 35f, 0f), Transformation.Interpolations.LINEAR), new Keyframe(0.5f, AnimationHelper.createRotationalVector(0f, -35f, 0f), Transformation.Interpolations.CUBIC), new Keyframe(1f, AnimationHelper.createRotationalVector(0f, 35f, 0f), Transformation.Interpolations.CUBIC))).addBoneAnimation("rightleg", new Transformation(Transformation.Targets.TRANSLATE, new Keyframe(0f, AnimationHelper.createTranslationalVector(3f, 0f, -5f), Transformation.Interpolations.LINEAR), new Keyframe(0.5f, AnimationHelper.createTranslationalVector(-5f, 0f, 3f), Transformation.Interpolations.CUBIC), new Keyframe(1f, AnimationHelper.createTranslationalVector(3f, 0f, -5f), Transformation.Interpolations.CUBIC))).addBoneAnimation("rightleg", new Transformation(Transformation.Targets.ROTATE, new Keyframe(0f, AnimationHelper.createRotationalVector(0f, -35f, 0f), Transformation.Interpolations.LINEAR), new Keyframe(0.5f, AnimationHelper.createRotationalVector(0f, 35f, 0f), Transformation.Interpolations.CUBIC), new Keyframe(1f, AnimationHelper.createRotationalVector(0f, -35f, 0f), Transformation.Interpolations.CUBIC))).build();
}
