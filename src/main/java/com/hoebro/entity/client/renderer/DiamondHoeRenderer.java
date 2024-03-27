package com.hoebro.entity.client.renderer;

import com.hoebro.HoeBro;
import com.hoebro.entity.client.HoeBroModelLayers;
import com.hoebro.entity.client.model.DiamondHoeModel;
import com.hoebro.entity.entity.DiamondHoe;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class DiamondHoeRenderer extends MobEntityRenderer<DiamondHoe, DiamondHoeModel<DiamondHoe>>
{
    private static final Identifier TEXTURE = new Identifier(HoeBro.MOD_ID, "textures/entity/diamond_hoe.png");

    public DiamondHoeRenderer(EntityRendererFactory.Context context)
    {
        super(context, new DiamondHoeModel<>(context.getPart(HoeBroModelLayers.DIAMONDHOE)), 0.6f);
    }

    @Override
    public Identifier getTexture(DiamondHoe entity) { return TEXTURE; }

    @Override
    public void render(DiamondHoe mobEntity, float f, float g, MatrixStack matrixStack,
                       VertexConsumerProvider vertexConsumerProvider, int i)
    {

        matrixStack.scale(0.5f, 0.5f, 0.5f);
        super.render(mobEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }
}