package com.hoebro.particle;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.particle.*;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.particle.DefaultParticleType;

public class HoeStickParticle extends SpriteBillboardParticle
{
    protected HoeStickParticle(ClientWorld clientWorld, double x, double y, double z, SpriteProvider spriteProvider, double dx, double dy, double dz) {
        super(clientWorld, x, y, z);
        this.setSprite(spriteProvider);

        this.red = 1.0f;
        this.green = 1.0f;
        this.blue = 1.0f;

        this.setBoundingBoxSpacing(0.02f, 0.02f);
        this.scale *= this.random.nextFloat() * 1.6f + 0.5f;

        // Initial gentle motion
        this.velocityX = dx * 0.1 + this.random.nextGaussian() * 0.01;
        this.velocityY = dy * 0.1 + this.random.nextGaussian() * 0.01;
        this.velocityZ = dz * 0.1 + this.random.nextGaussian() * 0.01;

        this.maxAge = 40 + this.random.nextInt(20);

        // Gravity strength for falling effect
        this.gravityStrength = 0.02f;
    }

    @Override
    public int getBrightness(float tint) { return 15728880; }

    @Override
    public void tick() {
        if (this.age++ >= this.maxAge) { this.markDead(); }
        else
        {
            this.prevPosX = this.x;
            this.prevPosY = this.y;
            this.prevPosZ = this.z;

            // Apply gravity each tick
            this.velocityY -= this.gravityStrength; // Gravity pulls down

            this.move(this.velocityX, this.velocityY, this.velocityZ);

            // Drag to slow down the particle movement
            this.velocityX *= 0.95;
            this.velocityY *= 0.95;
            this.velocityZ *= 0.95;

            if (this.onGround) { // Reduce speed significantly on ground contact
                this.velocityX *= 0.7;
                this.velocityZ *= 0.7;
            }
        }
        fadeOut();
    }

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
            HoeStickParticle particle = new HoeStickParticle(clientWorld, x, y, z, this.spriteProvider, dx, dy, dz);
            particle.setSprite(spriteProvider);
            return particle;
        }
    }
}
