package com.hoebro;

import com.hoebro.entity.HoeBroEntities;
import com.hoebro.entity.client.HoeBroModelLayers;
import com.hoebro.entity.client.HoeModel;
import com.hoebro.entity.client.HoeRenderer;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;

public class HoeBroClient implements ClientModInitializer
{
    @Override
    public void onInitializeClient()
    {
        EntityRendererRegistry.register(HoeBroEntities.WOODENHOE, HoeRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(HoeBroModelLayers.WOODENHOE, HoeModel::getTexturedModelData);
    }
}
