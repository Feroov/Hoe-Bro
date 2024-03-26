package com.hoebro.entity.client;

import com.hoebro.HoeBro;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;

public class HoeBroModelLayers
{
    public static final EntityModelLayer WOODENHOE =
            new EntityModelLayer(new Identifier(HoeBro.MOD_ID, "woodenhoe"), "main");

    public static final EntityModelLayer STONEHOE =
            new EntityModelLayer(new Identifier(HoeBro.MOD_ID, "stonehoe"), "main");
}
