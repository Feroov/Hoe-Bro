package com.hoebro.entity;

import com.hoebro.HoeBro;
import com.hoebro.entity.entity.WoodenHoe;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class HoeBroEntities
{
    public static final EntityType<WoodenHoe> WOODENHOE = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(HoeBro.MOD_ID, "woodenhoe"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, WoodenHoe::new)
                    .dimensions(EntityDimensions.fixed(0.8f, 2.7f)).build());

    public static void registerModEntities()
    {
        HoeBro.LOGGER.info("Registering Entities for " + HoeBro.MOD_ID);
    }
}
