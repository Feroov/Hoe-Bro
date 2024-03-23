package com.hoebro.item;

import com.hoebro.HoeBro;
import com.hoebro.entity.HoeBroEntities;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class HoeBroItems
{

    public static final Item WOODEN_HOE_SPAWN_EGG = registerItem("wooden_hoe_spawn_egg",
            new SpawnEggItem(HoeBroEntities.WOODENHOE, 0x6b511f, 0x20180a, new FabricItemSettings()));

    private static Item registerItem(String name, Item item)
    {
        return Registry.register(Registries.ITEM, new Identifier(HoeBro.MOD_ID, name), item);
    }

    public static void registerHoeBroItems() { HoeBro.LOGGER.info("Registering Mod Items for " + HoeBro.MOD_ID); }
}
