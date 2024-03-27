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
    public static final Item HOEBRO_ICON = registerItem("hoebro_icon", new Item(new FabricItemSettings()));

    public static final Item WOODEN_HOE_SPAWN_EGG = registerItem("wooden_hoe_spawn_egg",
            new SpawnEggItem(HoeBroEntities.WOODENHOE, 0x6b511f, 0x20180a, new FabricItemSettings()));

    public static final Item STONE_HOE_SPAWN_EGG = registerItem("stone_hoe_spawn_egg",
            new SpawnEggItem(HoeBroEntities.STONEHOE, 0x9a9a9a, 0x494949, new FabricItemSettings()));

    public static final Item IRON_HOE_SPAWN_EGG = registerItem("iron_hoe_spawn_egg",
            new SpawnEggItem(HoeBroEntities.IRONHOE, 0xffffff, 0xd8d8d8, new FabricItemSettings()));

    public static final Item GOLDEN_HOE_SPAWN_EGG = registerItem("golden_hoe_spawn_egg",
            new SpawnEggItem(HoeBroEntities.GOLDENHOE, 0xeaee57, 0xe9b115, new FabricItemSettings()));

    public static final Item DIAMOND_HOE_SPAWN_EGG = registerItem("diamond_hoe_spawn_egg",
            new SpawnEggItem(HoeBroEntities.DIAMONDHOE, 0x33ebcb, 0x27b29a, new FabricItemSettings()));

    public static final Item NETHETIRE_HOE_SPAWN_EGG = registerItem("netherite_hoe_spawn_egg",
            new SpawnEggItem(HoeBroEntities.NETHERITEHOE, 0x867b86, 0x5d565d, new FabricItemSettings()));

    public static final Item ULTIMATE_HOE_SPAWN_EGG = registerItem("ultimate_hoe_spawn_egg",
            new SpawnEggItem(HoeBroEntities.ULTIMATEHOE, 0xff1f45, 0xd90025, new FabricItemSettings()));

    private static Item registerItem(String name, Item item)
    {
        return Registry.register(Registries.ITEM, new Identifier(HoeBro.MOD_ID, name), item);
    }

    public static void registerHoeBroItems() { HoeBro.LOGGER.info("Registering Mod Items for " + HoeBro.MOD_ID); }
}
