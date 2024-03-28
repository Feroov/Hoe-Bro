package com.hoebro.datagen;

import com.hoebro.item.HoeBroItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Model;
import net.minecraft.data.client.Models;
import net.minecraft.util.Identifier;

import java.util.Optional;

public class HoeBroModelProvider extends FabricModelProvider
{
    public HoeBroModelProvider(FabricDataOutput output) { super(output); }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {}

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator)
    {
        itemModelGenerator.register(HoeBroItems.WOODEN_HOE_SPAWN_EGG, new Model(Optional.of(new Identifier("item/template_spawn_egg")), Optional.empty()));
        itemModelGenerator.register(HoeBroItems.STONE_HOE_SPAWN_EGG, new Model(Optional.of(new Identifier("item/template_spawn_egg")), Optional.empty()));
        itemModelGenerator.register(HoeBroItems.IRON_HOE_SPAWN_EGG, new Model(Optional.of(new Identifier("item/template_spawn_egg")), Optional.empty()));
        itemModelGenerator.register(HoeBroItems.GOLDEN_HOE_SPAWN_EGG, new Model(Optional.of(new Identifier("item/template_spawn_egg")), Optional.empty()));
        itemModelGenerator.register(HoeBroItems.DIAMOND_HOE_SPAWN_EGG, new Model(Optional.of(new Identifier("item/template_spawn_egg")), Optional.empty()));
        itemModelGenerator.register(HoeBroItems.NETHETIRE_HOE_SPAWN_EGG, new Model(Optional.of(new Identifier("item/template_spawn_egg")), Optional.empty()));
        itemModelGenerator.register(HoeBroItems.ULTIMATE_HOE_SPAWN_EGG, new Model(Optional.of(new Identifier("item/template_spawn_egg")), Optional.empty()));

        itemModelGenerator.register(HoeBroItems.HOEBRO_ICON, Models.GENERATED);
        itemModelGenerator.register(HoeBroItems.HOEBRO_GUIDE, Models.GENERATED);
    }
}
