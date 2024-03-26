package com.hoebro.entity.client.renderer;

import com.hoebro.HoeBro;
import com.hoebro.entity.client.HoeBroModelLayers;
import com.hoebro.entity.client.model.StoneHoeModel;
import com.hoebro.entity.entity.StoneHoe;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class StoneHoeRenderer extends MobEntityRenderer<StoneHoe, StoneHoeModel<StoneHoe>>
{
    private static final Identifier TEXTURE = new Identifier(HoeBro.MOD_ID, "textures/entity/stone_hoe.png");

    public StoneHoeRenderer(EntityRendererFactory.Context context)
    {
        super(context, new StoneHoeModel<>(context.getPart(HoeBroModelLayers.STONEHOE)), 0.6f);
    }

    @Override
    public Identifier getTexture(StoneHoe entity) { return TEXTURE; }

    @Override
    public void render(StoneHoe mobEntity, float f, float g, MatrixStack matrixStack,
                       VertexConsumerProvider vertexConsumerProvider, int i)
    {

        matrixStack.scale(0.5f, 0.5f, 0.5f);
        super.render(mobEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }
}