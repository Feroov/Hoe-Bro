package com.hoebro.entity.client.renderer;

import com.hoebro.HoeBro;
import com.hoebro.entity.client.HoeBroModelLayers;
import com.hoebro.entity.client.model.UltimateHoeModel;
import com.hoebro.entity.entity.UltimateHoe;
import net.minecraft.client.render.entity.feature.EnergySwirlOverlayFeatureRenderer;
import net.minecraft.client.render.entity.feature.FeatureRendererContext;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.EntityModelLoader;
import net.minecraft.util.Identifier;

public class HoeChargeFeatureRenderer extends EnergySwirlOverlayFeatureRenderer<UltimateHoe, UltimateHoeModel<UltimateHoe>>
{
    private static final Identifier TEXTURE = new Identifier(HoeBro.MOD_ID, "textures/entity/hoe_charge.png");
    private final UltimateHoeModel<UltimateHoe> model;

    public HoeChargeFeatureRenderer(FeatureRendererContext<UltimateHoe, UltimateHoeModel<UltimateHoe>> context, EntityModelLoader loader)
    {
        super(context);
        this.model = new UltimateHoeModel<>(loader.getModelPart(HoeBroModelLayers.HOE_CHARGE));
    }

    @Override
    protected float getEnergySwirlX(float partialAge) { return partialAge * 0.01f; }

    @Override
    protected Identifier getEnergySwirlTexture() { return TEXTURE; }

    @Override
    protected EntityModel<UltimateHoe> getEnergySwirlModel() { return this.model; }
}