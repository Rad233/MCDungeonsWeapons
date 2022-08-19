package chronosacaria.mcdw.particles;

import chronosacaria.mcdw.Mcdw;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.minecraft.client.particle.SweepAttackParticle;
import net.minecraft.particle.DefaultParticleType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ParticlesInit {

    public static final DefaultParticleType OFFHAND_SWEEP_PARTICLE = FabricParticleTypes.simple(true);

    public static void initializeOnServer() {
        Registry.register(Registry.PARTICLE_TYPE, new Identifier(Mcdw.MOD_ID, "offhand_sweep"), OFFHAND_SWEEP_PARTICLE);
    }

    public static void initializeOnClient() {
        ParticleFactoryRegistry.getInstance().register(OFFHAND_SWEEP_PARTICLE, SweepAttackParticle.Factory::new);
    }
}