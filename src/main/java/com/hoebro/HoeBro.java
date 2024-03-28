package com.hoebro;

import com.hoebro.entity.HoeBroEntities;
import com.hoebro.entity.entity.*;
import com.hoebro.item.HoeBroItemGroups;
import com.hoebro.item.HoeBroItems;
import com.hoebro.particle.HoeBroParticles;
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
		registerParticles();
		FabricDefaultAttributeRegistry.register(HoeBroEntities.WOODENHOE, WoodenHoe.createAttributes());
		FabricDefaultAttributeRegistry.register(HoeBroEntities.STONEHOE, StoneHoe.createAttributes());
		FabricDefaultAttributeRegistry.register(HoeBroEntities.IRONHOE, IronHoe.createAttributes());
		FabricDefaultAttributeRegistry.register(HoeBroEntities.GOLDENHOE, GoldenHoe.createAttributes());
		FabricDefaultAttributeRegistry.register(HoeBroEntities.DIAMONDHOE, DiamondHoe.createAttributes());
		FabricDefaultAttributeRegistry.register(HoeBroEntities.NETHERITEHOE, NetheriteHoe.createAttributes());
		FabricDefaultAttributeRegistry.register(HoeBroEntities.ULTIMATEHOE, UltimateHoe.createAttributes());
	}

	private void registerParticles()
	{
		Class<HoeBroParticles> particlesClass = HoeBroParticles.class;
	}
}