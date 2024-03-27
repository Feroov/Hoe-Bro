package com.hoebro.entity.client;

import com.hoebro.HoeBro;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.render.entity.model.EntityModelLayers;
import net.minecraft.util.Identifier;

public class HoeBroModelLayers
{
    public static final EntityModelLayer WOODENHOE =
            new EntityModelLayer(new Identifier(HoeBro.MOD_ID, "woodenhoe"), "main");

    public static final EntityModelLayer STONEHOE =
            new EntityModelLayer(new Identifier(HoeBro.MOD_ID, "stonehoe"), "main");

    public static final EntityModelLayer IRONHOE =
            new EntityModelLayer(new Identifier(HoeBro.MOD_ID, "ironhoe"), "main");

    public static final EntityModelLayer GOLDENHOE =
            new EntityModelLayer(new Identifier(HoeBro.MOD_ID, "goldenhoe"), "main");

    public static final EntityModelLayer DIAMONDHOE =
            new EntityModelLayer(new Identifier(HoeBro.MOD_ID, "diamondhoe"), "main");

    public static final EntityModelLayer NETHERITEHOE =
            new EntityModelLayer(new Identifier(HoeBro.MOD_ID, "netheritehoe"), "main");

    public static final EntityModelLayer ULTIMATEHOE =
            new EntityModelLayer(new Identifier(HoeBro.MOD_ID, "ultimatehoe"), "main");

    public static final EntityModelLayer HOE_CHARGE =
            new EntityModelLayer(new Identifier(HoeBro.MOD_ID, "hoecharge"), "armor");
}
