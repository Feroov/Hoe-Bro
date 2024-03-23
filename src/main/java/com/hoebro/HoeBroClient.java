package com.hoebro;

import com.hoebro.entity.HoeBroEntities;
import com.hoebro.entity.client.HoeBroModelLayers;
import com.hoebro.entity.client.WoodenHoeModel;
import com.hoebro.entity.client.WoodenHoeRenderer;
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
    }
}
