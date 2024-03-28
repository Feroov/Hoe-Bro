package com.hoebro.item;

import com.hoebro.HoeBro;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class HoeBroItemGroups
{
    public static final ItemGroup HOEBRO_GROUP = Registry.register(Registries.ITEM_GROUP, new Identifier(HoeBro.MOD_ID,
            "hoebrogroup"), FabricItemGroup.builder().displayName(Text.translatable("itemgroup.hoebro"))
            .icon(() -> new ItemStack(HoeBroItems.HOEBRO_ICON)).entries((displayContext, entries) ->
            {
                entries.add(HoeBroItems.HOEBRO_GUIDE);
                entries.add(HoeBroItems.WOODEN_HOE_SPAWN_EGG);
                entries.add(HoeBroItems.STONE_HOE_SPAWN_EGG);
                entries.add(HoeBroItems.IRON_HOE_SPAWN_EGG);
                entries.add(HoeBroItems.GOLDEN_HOE_SPAWN_EGG);
                entries.add(HoeBroItems.DIAMOND_HOE_SPAWN_EGG);
                entries.add(HoeBroItems.NETHETIRE_HOE_SPAWN_EGG);
                entries.add(HoeBroItems.ULTIMATE_HOE_SPAWN_EGG);
            }).build());

    public static void registerItemGroups() { HoeBro.LOGGER.info("Registering Item Groups for " + HoeBro.MOD_ID); }
}
