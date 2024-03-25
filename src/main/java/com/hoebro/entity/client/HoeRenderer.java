package com.hoebro.entity.client;

import com.hoebro.HoeBro;
import com.hoebro.entity.entity.WoodenHoe;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class HoeRenderer extends MobEntityRenderer<WoodenHoe, HoeModel<WoodenHoe>>
{
    private static final Identifier TEXTURE = new Identifier(HoeBro.MOD_ID, "textures/entity/wooden_hoe.png");

    public HoeRenderer(EntityRendererFactory.Context context)
    {
        super(context, new HoeModel<>(context.getPart(HoeBroModelLayers.WOODENHOE)), 0.6f);
    }

    @Override
    public Identifier getTexture(WoodenHoe entity) { return TEXTURE; }

    @Override
    public void render(WoodenHoe mobEntity, float f, float g, MatrixStack matrixStack,
                       VertexConsumerProvider vertexConsumerProvider, int i)
    {

        matrixStack.scale(0.5f, 0.5f, 0.5f);
        super.render(mobEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }
}