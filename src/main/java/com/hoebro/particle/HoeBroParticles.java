package com.hoebro.particle;

import com.hoebro.HoeBro;
import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.minecraft.particle.DefaultParticleType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class HoeBroParticles
{
    public static final DefaultParticleType CHEST = registerParticle("chest_particle", true);
    public static final DefaultParticleType PLAYER = registerParticle("player_particle", true);
    public static final DefaultParticleType STICK = registerParticle("stick_particle", true);

    private static DefaultParticleType registerParticle(String path, boolean alwaysShow)
    {
        return Registry.register(Registries.PARTICLE_TYPE,
                new Identifier(HoeBro.MOD_ID, path),
                FabricParticleTypes.simple(alwaysShow)
        );
    }
}
