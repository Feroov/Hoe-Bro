package com.hoebro.entity.client.renderer;

import com.hoebro.HoeBro;
import com.hoebro.entity.client.HoeBroModelLayers;
import com.hoebro.entity.client.model.GoldenHoeModel;
import com.hoebro.entity.entity.GoldenHoe;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class GoldenHoeRenderer extends MobEntityRenderer<GoldenHoe, GoldenHoeModel<GoldenHoe>>
{
    private static final Identifier TEXTURE = new Identifier(HoeBro.MOD_ID, "textures/entity/golden_hoe.png");

    public GoldenHoeRenderer(EntityRendererFactory.Context context)
    {
        super(context, new GoldenHoeModel<>(context.getPart(HoeBroModelLayers.GOLDENHOE)), 0.6f);
    }

    @Override
    public Identifier getTexture(GoldenHoe entity) { return TEXTURE; }

    @Override
    public void render(GoldenHoe mobEntity, float f, float g, MatrixStack matrixStack,
                       VertexConsumerProvider vertexConsumerProvider, int i)
    {

        matrixStack.scale(0.5f, 0.5f, 0.5f);
        super.render(mobEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }
}