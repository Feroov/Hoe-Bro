package com.hoebro.entity.client;

import com.hoebro.entity.animation.HoeBroAnimations;
import com.hoebro.entity.entity.WoodenHoe;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;

public class WoodenHoeModel<T extends WoodenHoe> extends SinglePartEntityModel<T>
{
    private final ModelPart woodenhoe;

    public WoodenHoeModel(ModelPart root) { this.woodenhoe = root.getChild("woodenhoe"); }

    public static TexturedModelData getTexturedModelData()
    {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData woodenhoe = modelPartData.addChild("woodenhoe", ModelPartBuilder.create().uv(24, 8).cuboid(-9.0F, -1.0F, -8.8235F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(24, 12).cuboid(-9.0F, -1.0F, -10.8235F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(24, 12).cuboid(-7.0F, -1.0F, -10.8235F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(24, 4).cuboid(-7.0F, -1.0F, -8.8235F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(24, 8).cuboid(-7.0F, -1.0F, -6.8235F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(16, 8).cuboid(-5.0F, -1.0F, -6.8235F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(24, 12).cuboid(-5.0F, -1.0F, -8.8235F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(24, 12).cuboid(-3.0F, -1.0F, -6.8235F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(24, 12).cuboid(-1.0F, -1.0F, -4.8235F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(24, 4).cuboid(-3.0F, -1.0F, -4.8235F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(24, 8).cuboid(-5.0F, -1.0F, -4.8235F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(24, 8).cuboid(-3.0F, -1.0F, -2.8235F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(16, 8).cuboid(-1.0F, -1.0F, -2.8235F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(24, 12).cuboid(1.0F, -1.0F, -2.8235F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(24, 4).cuboid(1.0F, -1.0F, -0.8235F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(24, 8).cuboid(-1.0F, -1.0F, -0.8235F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(24, 8).cuboid(1.0F, -1.0F, 1.1765F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(16, 8).cuboid(3.0F, -1.0F, 1.1765F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(24, 8).cuboid(3.0F, -1.0F, 3.1765F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(24, 4).cuboid(5.0F, -1.0F, 3.1765F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(24, 12).cuboid(5.0F, -1.0F, 1.1765F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(24, 12).cuboid(7.0F, -1.0F, 3.1765F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(24, 12).cuboid(9.0F, -1.0F, 5.1765F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(24, 12).cuboid(11.0F, -1.0F, 5.1765F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(24, 4).cuboid(9.0F, -1.0F, 7.1765F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(16, 12).cuboid(11.0F, -1.0F, 9.1765F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(16, 4).cuboid(11.0F, -1.0F, 7.1765F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(24, 8).cuboid(11.0F, -1.0F, 11.1765F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(24, 8).cuboid(9.0F, -1.0F, 11.1765F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(24, 8).cuboid(1.0F, -1.0F, 15.1765F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(24, 8).cuboid(3.0F, -1.0F, 15.1765F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(24, 8).cuboid(-1.0F, -1.0F, 13.1765F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(24, 12).cuboid(3.0F, -1.0F, 11.1765F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(24, 12).cuboid(1.0F, -1.0F, 11.1765F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(24, 8).cuboid(5.0F, -1.0F, 15.1765F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(24, 8).cuboid(7.0F, -1.0F, 13.1765F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(16, 4).cuboid(3.0F, -1.0F, 13.1765F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(16, 4).cuboid(5.0F, -1.0F, 13.1765F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(16, 8).cuboid(7.0F, -1.0F, 11.1765F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(16, 12).cuboid(1.0F, -1.0F, 13.1765F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(24, 4).cuboid(5.0F, -1.0F, 11.1765F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(16, 4).cuboid(7.0F, -1.0F, 9.1765F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(16, 4).cuboid(9.0F, -1.0F, 9.1765F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(16, 8).cuboid(13.0F, -1.0F, 11.1765F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(24, 12).cuboid(13.0F, -1.0F, 9.1765F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(24, 12).cuboid(13.0F, -1.0F, 7.1765F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(16, 8).cuboid(7.0F, -1.0F, 5.1765F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(24, 8).cuboid(5.0F, -1.0F, 5.1765F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(24, 8).cuboid(7.0F, -1.0F, 7.1765F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(24, 12).cuboid(5.0F, -1.0F, 9.1765F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(24, 12).cuboid(3.0F, -1.0F, -0.8235F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -7.0F, -1.1765F, -3.1416F, -0.7854F, -1.5708F));

        ModelPartData leftleg = woodenhoe.addChild("leftleg", ModelPartBuilder.create().uv(24, 12).cuboid(-7.0F, -1.0F, -9.0F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(24, 12).cuboid(-9.0F, -1.0F, -9.0F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(24, 8).cuboid(-9.0F, -1.0F, -7.0F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(24, 4).cuboid(-7.0F, -1.0F, -7.0F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(24, 8).cuboid(-7.0F, -1.0F, -5.0F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(24, 12).cuboid(-5.0F, -1.0F, -7.0F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(16, 8).cuboid(-5.0F, -1.0F, -5.0F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(24, 12).cuboid(-3.0F, -1.0F, -5.0F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(24, 8).cuboid(-5.0F, -1.0F, -3.0F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(24, 4).cuboid(-3.0F, -1.0F, -3.0F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(24, 8).cuboid(-3.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(24, 12).cuboid(-1.0F, -1.0F, -3.0F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(16, 8).cuboid(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(24, 12).cuboid(1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(24, 8).cuboid(-1.0F, -1.0F, 1.0F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(24, 4).cuboid(1.0F, -1.0F, 1.0F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(24, 12).cuboid(3.0F, -1.0F, 1.0F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(24, 8).cuboid(1.0F, -1.0F, 3.0F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(16, 8).cuboid(3.0F, -1.0F, 3.0F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(24, 12).cuboid(5.0F, -1.0F, 3.0F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(24, 8).cuboid(3.0F, -1.0F, 5.0F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(24, 4).cuboid(5.0F, -1.0F, 5.0F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(24, 12).cuboid(7.0F, -1.0F, 5.0F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(24, 8).cuboid(5.0F, -1.0F, 7.0F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(16, 8).cuboid(7.0F, -1.0F, 7.0F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(-13.0F, -5.0F, -14.8235F, -0.4363F, 0.0F, 0.0F));

        ModelPartData rightleg = woodenhoe.addChild("rightleg", ModelPartBuilder.create().uv(24, 12).cuboid(-7.0F, -1.0F, -9.0F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(24, 12).cuboid(-9.0F, -1.0F, -9.0F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(24, 8).cuboid(-9.0F, -1.0F, -7.0F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(24, 4).cuboid(-7.0F, -1.0F, -7.0F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(24, 8).cuboid(-7.0F, -1.0F, -5.0F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(24, 12).cuboid(-5.0F, -1.0F, -7.0F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(16, 8).cuboid(-5.0F, -1.0F, -5.0F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(24, 12).cuboid(-3.0F, -1.0F, -5.0F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(24, 8).cuboid(-5.0F, -1.0F, -3.0F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(24, 4).cuboid(-3.0F, -1.0F, -3.0F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(24, 8).cuboid(-3.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(24, 12).cuboid(-1.0F, -1.0F, -3.0F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(16, 8).cuboid(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(24, 12).cuboid(1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(24, 8).cuboid(-1.0F, -1.0F, 1.0F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(24, 4).cuboid(1.0F, -1.0F, 1.0F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(24, 12).cuboid(3.0F, -1.0F, 1.0F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(24, 8).cuboid(1.0F, -1.0F, 3.0F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(16, 8).cuboid(3.0F, -1.0F, 3.0F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(24, 12).cuboid(5.0F, -1.0F, 3.0F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(24, 8).cuboid(3.0F, -1.0F, 5.0F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(24, 4).cuboid(5.0F, -1.0F, 5.0F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(24, 12).cuboid(7.0F, -1.0F, 5.0F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(24, 8).cuboid(5.0F, -1.0F, 7.0F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(16, 8).cuboid(7.0F, -1.0F, 7.0F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(-13.0F, 5.0F, -14.8235F, 0.4363F, 0.0F, 0.0F));
        return TexturedModelData.of(modelData, 32, 16);
    }

    @Override
    public void render(MatrixStack matrices, VertexConsumer vertices, int light, int overlay, float red, float green, float blue, float alpha)
    {
        woodenhoe.render(matrices, vertices, light, overlay, red, green, blue, alpha);
    }

    @Override
    public ModelPart getPart() { return woodenhoe; }

    @Override
    public void setAngles(WoodenHoe entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch)
    {
        this.getPart().traverse().forEach(ModelPart::resetTransform);

        this.animateMovement(HoeBroAnimations.HOES_WALK, limbSwing, limbSwingAmount, 2f, 2.5f);
        this.updateAnimation(entity.idleAnimationState, HoeBroAnimations.HOES_IDLE, ageInTicks, 1f);
    }
}