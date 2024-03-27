package com.hoebro.entity.client.renderer;

import com.hoebro.HoeBro;
import com.hoebro.entity.client.HoeBroModelLayers;
import com.hoebro.entity.client.model.IronHoeModel;
import com.hoebro.entity.entity.IronHoe;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class IronHoeRenderer extends MobEntityRenderer<IronHoe, IronHoeModel<IronHoe>>
{
    private static final Identifier TEXTURE = new Identifier(HoeBro.MOD_ID, "textures/entity/iron_hoe.png");

    public IronHoeRenderer(EntityRendererFactory.Context context)
    {
        super(context, new IronHoeModel<>(context.getPart(HoeBroModelLayers.IRONHOE)), 0.6f);
    }

    @Override
    public Identifier getTexture(IronHoe entity) { return TEXTURE; }

    @Override
    public void render(IronHoe mobEntity, float f, float g, MatrixStack matrixStack,
                       VertexConsumerProvider vertexConsumerProvider, int i)
    {

        matrixStack.scale(0.5f, 0.5f, 0.5f);
        super.render(mobEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }
}