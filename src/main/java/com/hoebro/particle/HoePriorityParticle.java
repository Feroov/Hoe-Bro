package com.hoebro.particle;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.particle.*;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.particle.DefaultParticleType;

public class HoePriorityParticle extends SpriteBillboardParticle
{
    protected HoePriorityParticle(ClientWorld clientWorld, double x, double y, double z, SpriteProvider spriteProvider, double dx, double dy, double dz)
    {
        super(clientWorld, x, y, z, dx, dy, dz);
        this.setSprite(spriteProvider);

        this.red = 1.0f;
        this.green = 1.0f;
        this.blue = 1.0f;

        this.setBoundingBoxSpacing(0.02f, 0.02f);
        this.scale = 0.2f;
        this.velocityX *= (double)0.02f;
        this.velocityY *= (double)0.02f;
        this.velocityZ *= (double)0.02f;
        this.maxAge = 40;
    }

    @Override
    public int getBrightness(float tint) { return 15728880; }

    @Override
    public void tick() { super.tick(); fadeOut(); }

    private void fadeOut()  { this.alpha = (-(1/(float)maxAge) * age + 1); }

    @Override
    public ParticleTextureSheet getType() { return ParticleTextureSheet.PARTICLE_SHEET_OPAQUE; }

    @Environment(EnvType.CLIENT)
    public static class Factory implements ParticleFactory<DefaultParticleType>
    {
        private final SpriteProvider spriteProvider;

        public Factory(SpriteProvider spriteProvider) { this.spriteProvider = spriteProvider; }

        public Particle createParticle(DefaultParticleType defaultParticleType, ClientWorld clientWorld, double x, double y, double z,
                                       double dx, double dy, double dz)
        {
            HoePriorityParticle particle = new HoePriorityParticle(clientWorld, x, y, z, this.spriteProvider, dx, dy, dz);
            particle.setSprite(spriteProvider);
            return particle;
        }
    }
}
