package com.hoebro.entity.client.model;

import com.hoebro.entity.animation.HoeBroAnimations;
import com.hoebro.entity.entity.WoodenHoe;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;

public class WoodenHoeModel<T extends WoodenHoe> extends SinglePartEntityModel<T>
{
    private final ModelPart woodenhoe;
    private final ModelPart upperbody;

    public WoodenHoeModel(ModelPart root)
    {
        this.woodenhoe = root.getChild("woodenhoe");
        this.upperbody = woodenhoe.getChild("body").getChild("upperbody");
    }
    public static TexturedModelData getTexturedModelData()
    {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData woodenhoe = modelPartData.addChild("woodenhoe", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

        ModelPartData body = woodenhoe.addChild("body", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData leftleg = body.addChild("leftleg", ModelPartBuilder.create().uv(24, 12).cuboid(-1.5633F, -0.0432F, -4.3161F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(24, 8).cuboid(-3.5633F, -0.0432F, -2.3161F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(24, 4).cuboid(-3.5633F, -0.0432F, -4.3161F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(24, 8).cuboid(-5.5633F, -0.0432F, -4.3161F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(24, 12).cuboid(-3.5633F, -0.0432F, -6.3161F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(16, 4).cuboid(-5.5633F, -0.0432F, -6.3161F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(24, 8).cuboid(-7.5633F, -0.0432F, -6.3161F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(24, 12).cuboid(-5.5633F, -0.0432F, -8.3161F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(24, 4).cuboid(-7.5633F, -0.0432F, -8.3161F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(24, 8).cuboid(-9.5633F, -0.0432F, -8.3161F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(24, 12).cuboid(-7.5633F, -0.0432F, -10.3161F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(16, 4).cuboid(-9.5633F, -0.0432F, -10.3161F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(24, 12).cuboid(-9.5633F, -0.0432F, -12.3161F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(24, 8).cuboid(-11.5633F, -0.0432F, -10.3161F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(24, 8).cuboid(-13.5633F, -0.0432F, -12.3161F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(24, 4).cuboid(-11.5633F, -0.0432F, -12.3161F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(24, 12).cuboid(-11.5633F, -0.0432F, -14.3161F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(24, 12).cuboid(-13.5633F, -0.0432F, -14.3161F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(2.0F, -17.5147F, 0.2426F, -3.0369F, -0.8493F, -1.9275F));

        ModelPartData rightleg = body.addChild("rightleg", ModelPartBuilder.create().uv(24, 12).cuboid(-1.655F, -2.1283F, -4.2017F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(24, 8).cuboid(-3.655F, -2.1283F, -2.2017F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(24, 4).cuboid(-3.655F, -2.1283F, -4.2017F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(24, 8).cuboid(-5.655F, -2.1283F, -4.2017F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(24, 12).cuboid(-3.655F, -2.1283F, -6.2017F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(16, 4).cuboid(-5.655F, -2.1283F, -6.2017F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(24, 8).cuboid(-7.655F, -2.1283F, -6.2017F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(24, 12).cuboid(-5.655F, -2.1283F, -8.2017F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(24, 4).cuboid(-7.655F, -2.1283F, -8.2017F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(24, 8).cuboid(-9.655F, -2.1283F, -8.2017F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(24, 12).cuboid(-7.655F, -2.1283F, -10.2017F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(16, 4).cuboid(-9.655F, -2.1283F, -10.2017F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(24, 12).cuboid(-9.655F, -2.1283F, -12.2017F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(24, 8).cuboid(-11.655F, -2.1283F, -10.2017F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(24, 8).cuboid(-13.655F, -2.1283F, -12.2017F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(24, 4).cuboid(-11.655F, -2.1283F, -12.2017F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(24, 12).cuboid(-11.655F, -2.1283F, -14.2017F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(24, 12).cuboid(-13.655F, -2.1283F, -14.2017F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(-2.0F, -17.5147F, 0.2426F, -3.0369F, -0.8493F, -1.347F));

        ModelPartData upperbody = body.addChild("upperbody", ModelPartBuilder.create().uv(24, 12).cuboid(-3.8076F, -1.0F, -3.8027F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(24, 12).cuboid(-1.8076F, -1.0F, -3.8027F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(24, 12).cuboid(0.1924F, -1.0F, -1.8027F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(24, 12).cuboid(2.1924F, -1.0F, 0.1973F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(24, 12).cuboid(6.1924F, -1.0F, 4.1973F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(24, 12).cuboid(4.1924F, -1.0F, 2.1973F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(24, 12).cuboid(14.1924F, -1.0F, 12.1973F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(24, 12).cuboid(16.1924F, -1.0F, 12.1973F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(24, 12).cuboid(18.1924F, -1.0F, 14.1973F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(24, 12).cuboid(18.1924F, -1.0F, 16.1973F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(24, 4).cuboid(18.1924F, -1.0F, 18.1973F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(24, 8).cuboid(16.1924F, -1.0F, 18.1973F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(24, 8).cuboid(14.1924F, -1.0F, 18.1973F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(24, 8).cuboid(12.1924F, -1.0F, 20.1973F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(24, 8).cuboid(10.1924F, -1.0F, 22.1973F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(24, 8).cuboid(8.1924F, -1.0F, 22.1973F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(24, 8).cuboid(6.1924F, -1.0F, 22.1973F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(24, 8).cuboid(4.1924F, -1.0F, 20.1973F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(24, 4).cuboid(6.1924F, -1.0F, 20.1973F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(16, 4).cuboid(8.1924F, -1.0F, 20.1973F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(16, 4).cuboid(10.1924F, -1.0F, 20.1973F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(16, 4).cuboid(12.1924F, -1.0F, 18.1973F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(16, 8).cuboid(10.1924F, -1.0F, 18.1973F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(16, 8).cuboid(12.1924F, -1.0F, 16.1973F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(16, 8).cuboid(14.1924F, -1.0F, 16.1973F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(16, 8).cuboid(16.1924F, -1.0F, 14.1973F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(16, 4).cuboid(16.1924F, -1.0F, 16.1973F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(16, 4).cuboid(14.1924F, -1.0F, 14.1973F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(16, 4).cuboid(12.1924F, -1.0F, 12.1973F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(16, 4).cuboid(8.1924F, -1.0F, 8.1973F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(16, 4).cuboid(0.1924F, -1.0F, 0.1973F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(16, 4).cuboid(4.1924F, -1.0F, 4.1973F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(24, 12).cuboid(6.1924F, -1.0F, 18.1973F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(24, 12).cuboid(8.1924F, -1.0F, 18.1973F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(24, 12).cuboid(10.1924F, -1.0F, 16.1973F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(24, 12).cuboid(12.1924F, -1.0F, 10.1973F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(24, 12).cuboid(10.1924F, -1.0F, 8.1973F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(24, 12).cuboid(8.1924F, -1.0F, 6.1973F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(24, 4).cuboid(-1.8076F, -1.0F, -1.8027F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(24, 4).cuboid(2.1924F, -1.0F, 2.1973F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(24, 4).cuboid(6.1924F, -1.0F, 6.1973F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(24, 4).cuboid(10.1924F, -1.0F, 10.1973F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(24, 8).cuboid(-3.8076F, -1.0F, -1.8027F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(24, 8).cuboid(-1.8076F, -1.0F, 0.1973F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(24, 8).cuboid(0.1924F, -1.0F, 2.1973F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(24, 8).cuboid(2.1924F, -1.0F, 4.1973F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(24, 8).cuboid(8.1924F, -1.0F, 10.1973F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(24, 8).cuboid(6.1924F, -1.0F, 8.1973F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(24, 8).cuboid(12.1924F, -1.0F, 14.1973F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(24, 8).cuboid(10.1924F, -1.0F, 12.1973F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(24, 8).cuboid(4.1924F, -1.0F, 6.1973F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -13.0F, -0.1765F, -3.1416F, -0.7854F, -1.5708F));
        return TexturedModelData.of(modelData, 32, 16);
    }

    @Override
    public void setAngles(WoodenHoe entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch)
    {
        this.getPart().traverse().forEach(ModelPart::resetTransform);

        this.animateMovement(HoeBroAnimations.WOOD_WALK, limbSwing, limbSwingAmount, 2f, 2.5f);
        this.updateAnimation(entity.idleAnimationState, HoeBroAnimations.IDLE, ageInTicks, 1f);
    }

    @Override
    public ModelPart getPart() { return woodenhoe; }

    @Override
    public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha)
    {
        woodenhoe.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
    }
}