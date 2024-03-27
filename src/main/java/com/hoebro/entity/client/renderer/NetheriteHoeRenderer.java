package com.hoebro.entity.client.renderer;

import com.hoebro.HoeBro;
import com.hoebro.entity.client.HoeBroModelLayers;
import com.hoebro.entity.client.model.NetheriteHoeModel;
import com.hoebro.entity.entity.NetheriteHoe;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class NetheriteHoeRenderer extends MobEntityRenderer<NetheriteHoe, NetheriteHoeModel<NetheriteHoe>>
{
    private static final Identifier TEXTURE = new Identifier(HoeBro.MOD_ID, "textures/entity/netherite_hoe.png");

    public NetheriteHoeRenderer(EntityRendererFactory.Context context)
    {
        super(context, new NetheriteHoeModel<>(context.getPart(HoeBroModelLayers.NETHERITEHOE)), 0.6f);
    }

    @Override
    public Identifier getTexture(NetheriteHoe entity) { return TEXTURE; }

    @Override
    public void render(NetheriteHoe mobEntity, float f, float g, MatrixStack matrixStack,
                       VertexConsumerProvider vertexConsumerProvider, int i)
    {

        matrixStack.scale(0.5f, 0.5f, 0.5f);
        super.render(mobEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }
}