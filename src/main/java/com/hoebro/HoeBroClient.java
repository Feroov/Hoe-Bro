package com.hoebro;

import com.hoebro.entity.HoeBroEntities;
import com.hoebro.entity.client.HoeBroModelLayers;
import com.hoebro.entity.client.model.StoneHoeModel;
import com.hoebro.entity.client.model.WoodenHoeModel;
import com.hoebro.entity.client.renderer.StoneHoeRenderer;
import com.hoebro.entity.client.renderer.WoodenHoeRenderer;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;

public class HoeBroClient implements ClientModInitializer
{
    @Override
    public void onInitializeClient()
    {
        EntityRendererRegistry.register(HoeBroEntities.WOODENHOE, WoodenHoeRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(HoeBroModelLayers.WOODENHOE, WoodenHoeModel::getTexturedModelData);

        EntityRendererRegistry.register(HoeBroEntities.STONEHOE, StoneHoeRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(HoeBroModelLayers.STONEHOE, StoneHoeModel::getTexturedModelData);
    }
}
