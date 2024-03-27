package com.hoebro.entity.client.renderer;

import com.hoebro.HoeBro;
import com.hoebro.entity.client.HoeBroModelLayers;
import com.hoebro.entity.client.model.NetheriteHoeModel;
import com.hoebro.entity.client.model.UltimateHoeModel;
import com.hoebro.entity.entity.NetheriteHoe;
import com.hoebro.entity.entity.UltimateHoe;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.feature.CreeperChargeFeatureRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class UltimateHoeRenderer extends MobEntityRenderer<UltimateHoe, UltimateHoeModel<UltimateHoe>>
{
    private static final Identifier TEXTURE = new Identifier(HoeBro.MOD_ID, "textures/entity/ultimate_hoe.png");

    public UltimateHoeRenderer(EntityRendererFactory.Context context)
    {
        super(context, new UltimateHoeModel<>(context.getPart(HoeBroModelLayers.ULTIMATEHOE)), 0.6f);
        this.addFeature(new HoeChargeFeatureRenderer(this, context.getModelLoader()));
    }

    @Override
    public Identifier getTexture(UltimateHoe entity) { return TEXTURE; }

    @Override
    public void render(UltimateHoe mobEntity, float f, float g, MatrixStack matrixStack,
                       VertexConsumerProvider vertexConsumerProvider, int i)
    {

        matrixStack.scale(0.5f, 0.5f, 0.5f);
        super.render(mobEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }
}