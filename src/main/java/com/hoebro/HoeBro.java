package com.hoebro;

import com.hoebro.entity.HoeBroEntities;
import com.hoebro.entity.entity.GoldenHoe;
import com.hoebro.entity.entity.StoneHoe;
import com.hoebro.entity.entity.WoodenHoe;
import com.hoebro.item.HoeBroItemGroups;
import com.hoebro.item.HoeBroItems;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HoeBro implements ModInitializer
{
	public static final String MOD_ID = "hoebro";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize()
	{
		HoeBroItemGroups.registerItemGroups();
		HoeBroItems.registerHoeBroItems();
		HoeBroEntities.registerModEntities();
		FabricDefaultAttributeRegistry.register(HoeBroEntities.WOODENHOE, WoodenHoe.createAttributes());
		FabricDefaultAttributeRegistry.register(HoeBroEntities.STONEHOE, StoneHoe.createAttributes());
		FabricDefaultAttributeRegistry.register(HoeBroEntities.IRONHOE, StoneHoe.createAttributes());
		FabricDefaultAttributeRegistry.register(HoeBroEntities.GOLDENHOE, GoldenHoe.createAttributes());
	}
}