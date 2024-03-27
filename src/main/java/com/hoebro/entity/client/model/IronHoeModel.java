package com.hoebro.entity.client.model;

import com.hoebro.entity.animation.HoeBroAnimations;
import com.hoebro.entity.entity.IronHoe;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;

public class IronHoeModel<T extends IronHoe> extends SinglePartEntityModel<T>
{
    private final ModelPart stonehoe;
    private final ModelPart upperbody;

    public IronHoeModel(ModelPart root)
    {
        this.stonehoe = root.getChild("stonehoe");
        this.upperbody = stonehoe.getChild("upperbody");
    }

    public static TexturedModelData getTexturedModelData()
    {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData stonehoe = modelPartData.addChild("stonehoe", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 24.6F, 0.0F));

        ModelPartData upperbody = stonehoe.addChild("upperbody", ModelPartBuilder.create().uv(14, 8).cuboid(-1.6863F, -1.0F, -1.6814F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(14, 8).cuboid(0.3137F, -1.0F, -1.6814F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(14, 8).cuboid(2.3137F, -1.0F, 0.3186F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(14, 8).cuboid(4.3137F, -1.0F, 2.3186F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(14, 8).cuboid(8.3137F, -1.0F, 6.3186F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(14, 8).cuboid(6.3137F, -1.0F, 4.3186F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(14, 8).cuboid(12.3137F, -1.0F, 10.3186F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(14, 8).cuboid(10.3137F, -1.0F, 8.3186F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(14, 8).cuboid(16.3137F, -1.0F, 14.3186F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(14, 8).cuboid(18.3137F, -1.0F, 14.3186F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(14, 8).cuboid(20.3137F, -1.0F, 16.3186F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(14, 8).cuboid(20.3137F, -1.0F, 18.3186F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(14, 4).cuboid(20.3137F, -1.0F, 20.3186F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(14, 4).cuboid(14.3137F, -1.0F, 14.3186F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(30, 12).cuboid(18.3137F, -1.0F, 20.3186F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(30, 12).cuboid(14.3137F, -1.0F, 16.3186F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(30, 8).cuboid(12.3137F, -1.0F, 18.3186F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(30, 8).cuboid(10.3137F, -1.0F, 20.3186F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(30, 8).cuboid(8.3137F, -1.0F, 20.3186F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(30, 4).cuboid(6.3137F, -1.0F, 22.3186F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(22, 12).cuboid(8.3137F, -1.0F, 22.3186F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(22, 4).cuboid(10.3137F, -1.0F, 22.3186F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(22, 4).cuboid(12.3137F, -1.0F, 22.3186F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(22, 4).cuboid(14.3137F, -1.0F, 20.3186F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(22, 4).cuboid(16.3137F, -1.0F, 16.3186F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(22, 8).cuboid(18.3137F, -1.0F, 16.3186F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(22, 8).cuboid(16.3137F, -1.0F, 18.3186F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(22, 8).cuboid(14.3137F, -1.0F, 18.3186F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(22, 8).cuboid(12.3137F, -1.0F, 20.3186F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(30, 4).cuboid(8.3137F, -1.0F, 24.3186F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(30, 4).cuboid(10.3137F, -1.0F, 24.3186F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(30, 4).cuboid(12.3137F, -1.0F, 24.3186F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(30, 4).cuboid(14.3137F, -1.0F, 22.3186F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(30, 4).cuboid(16.3137F, -1.0F, 20.3186F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(30, 12).cuboid(12.3137F, -1.0F, 14.3186F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(30, 12).cuboid(8.3137F, -1.0F, 10.3186F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(30, 12).cuboid(10.3137F, -1.0F, 12.3186F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(30, 12).cuboid(4.3137F, -1.0F, 6.3186F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(30, 12).cuboid(6.3137F, -1.0F, 8.3186F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(30, 12).cuboid(2.3137F, -1.0F, 4.3186F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(30, 12).cuboid(0.3137F, -1.0F, 2.3186F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(30, 12).cuboid(-1.6863F, -1.0F, 0.3186F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(14, 12).cuboid(18.3137F, -1.0F, 18.3186F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(14, 12).cuboid(12.3137F, -1.0F, 12.3186F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(14, 12).cuboid(8.3137F, -1.0F, 8.3186F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(14, 4).cuboid(10.3137F, -1.0F, 10.3186F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(14, 12).cuboid(4.3137F, -1.0F, 4.3186F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(14, 12).cuboid(0.3137F, -1.0F, 0.3186F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(14, 4).cuboid(6.3137F, -1.0F, 6.3186F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(14, 4).cuboid(2.3137F, -1.0F, 2.3186F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(14, 8).cuboid(14.3137F, -1.0F, 12.3186F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -11.0F, -0.1765F, 3.1416F, -0.7854F, -1.5708F));

        ModelPartData rightleg = stonehoe.addChild("rightleg", ModelPartBuilder.create().uv(14, 8).cuboid(-0.6025F, -1.7857F, -2.7616F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(30, 12).cuboid(-2.6025F, -1.7857F, -0.7616F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(14, 12).cuboid(-2.6025F, -1.7857F, -2.7616F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(14, 8).cuboid(-2.6025F, -1.7857F, -4.7616F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(30, 12).cuboid(-4.6025F, -1.7857F, -2.7616F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(14, 4).cuboid(-4.6025F, -1.7857F, -4.7616F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(30, 12).cuboid(-6.6025F, -1.7857F, -4.7616F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(14, 8).cuboid(-4.6025F, -1.7857F, -6.7616F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(14, 12).cuboid(-6.6025F, -1.7857F, -6.7616F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(30, 12).cuboid(-8.6025F, -1.7857F, -6.7616F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(14, 8).cuboid(-6.6025F, -1.7857F, -8.7616F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(14, 4).cuboid(-8.6025F, -1.7857F, -8.7616F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(30, 12).cuboid(-10.6025F, -1.7857F, -8.7616F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(14, 8).cuboid(-8.6025F, -1.7857F, -10.7616F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(14, 12).cuboid(-10.6025F, -1.7857F, -10.7616F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(30, 12).cuboid(-12.6025F, -1.7857F, -10.7616F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(14, 8).cuboid(-10.6025F, -1.7857F, -12.7616F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(14, 8).cuboid(-12.6025F, -1.7857F, -12.7616F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(-1.1333F, -17.0F, -0.3333F, 0.0684F, 0.8018F, -1.255F));

        ModelPartData leftleg = stonehoe.addChild("leftleg", ModelPartBuilder.create().uv(14, 8).mirrored().cuboid(-1.3975F, -1.7857F, -2.7616F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F)).mirrored(false)
                .uv(30, 12).mirrored().cuboid(0.6025F, -1.7857F, -0.7616F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F)).mirrored(false)
                .uv(14, 12).mirrored().cuboid(0.6025F, -1.7857F, -2.7616F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F)).mirrored(false)
                .uv(14, 8).mirrored().cuboid(0.6025F, -1.7857F, -4.7616F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F)).mirrored(false)
                .uv(30, 12).mirrored().cuboid(2.6025F, -1.7857F, -2.7616F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F)).mirrored(false)
                .uv(14, 4).mirrored().cuboid(2.6025F, -1.7857F, -4.7616F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F)).mirrored(false)
                .uv(30, 12).mirrored().cuboid(4.6025F, -1.7857F, -4.7616F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F)).mirrored(false)
                .uv(14, 8).mirrored().cuboid(2.6025F, -1.7857F, -6.7616F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F)).mirrored(false)
                .uv(14, 12).mirrored().cuboid(4.6025F, -1.7857F, -6.7616F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F)).mirrored(false)
                .uv(30, 12).mirrored().cuboid(6.6025F, -1.7857F, -6.7616F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F)).mirrored(false)
                .uv(14, 8).mirrored().cuboid(4.6025F, -1.7857F, -8.7616F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F)).mirrored(false)
                .uv(14, 4).mirrored().cuboid(6.6025F, -1.7857F, -8.7616F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F)).mirrored(false)
                .uv(30, 12).mirrored().cuboid(8.6025F, -1.7857F, -8.7616F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F)).mirrored(false)
                .uv(14, 8).mirrored().cuboid(6.6025F, -1.7857F, -10.7616F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F)).mirrored(false)
                .uv(14, 12).mirrored().cuboid(8.6025F, -1.7857F, -10.7616F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F)).mirrored(false)
                .uv(30, 12).mirrored().cuboid(10.6025F, -1.7857F, -10.7616F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F)).mirrored(false)
                .uv(14, 8).mirrored().cuboid(8.6025F, -1.7857F, -12.7616F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F)).mirrored(false)
                .uv(14, 8).mirrored().cuboid(10.6025F, -1.7857F, -12.7616F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(1.1333F, -17.0F, -0.3333F, 0.0684F, -0.8018F, 1.255F));
        return TexturedModelData.of(modelData, 38, 16);
    }

    @Override
    public void setAngles(IronHoe entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch)
    {
        this.getPart().traverse().forEach(ModelPart::resetTransform);

        this.animateMovement(HoeBroAnimations.GENERIC_WALK, limbSwing, limbSwingAmount, 2f, 2.5f);
        this.updateAnimation(entity.idleAnimationState, HoeBroAnimations.IDLE, ageInTicks, 1f);
    }

    @Override
    public ModelPart getPart() { return stonehoe; }

    @Override
    public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha)
    {
        stonehoe.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
    }
}