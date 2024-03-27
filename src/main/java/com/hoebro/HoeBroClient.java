package com.hoebro;

import com.hoebro.entity.HoeBroEntities;
import com.hoebro.entity.client.HoeBroModelLayers;
import com.hoebro.entity.client.model.*;
import com.hoebro.entity.client.renderer.*;
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

        EntityRendererRegistry.register(HoeBroEntities.IRONHOE, IronHoeRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(HoeBroModelLayers.IRONHOE, IronHoeModel::getTexturedModelData);

        EntityRendererRegistry.register(HoeBroEntities.GOLDENHOE, GoldenHoeRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(HoeBroModelLayers.GOLDENHOE, GoldenHoeModel::getTexturedModelData);

        EntityRendererRegistry.register(HoeBroEntities.DIAMONDHOE, DiamondHoeRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(HoeBroModelLayers.DIAMONDHOE, DiamondHoeModel::getTexturedModelData);

        EntityRendererRegistry.register(HoeBroEntities.NETHERITEHOE, NetheriteHoeRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(HoeBroModelLayers.NETHERITEHOE, NetheriteHoeModel::getTexturedModelData);

        EntityRendererRegistry.register(HoeBroEntities.ULTIMATEHOE, UltimateHoeRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(HoeBroModelLayers.ULTIMATEHOE, UltimateHoeModel::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(HoeBroModelLayers.HOE_CHARGE, UltimateHoeModel::getTexturedModelData);
    }
}
