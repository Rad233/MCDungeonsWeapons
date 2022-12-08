package chronosacaria.mcdw.particles;

import chronosacaria.mcdw.Mcdw;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.minecraft.client.particle.SweepAttackParticle;
import net.minecraft.particle.DefaultParticleType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ParticlesInit {

    public static final DefaultParticleType OFFHAND_SWEEP_PARTICLE = FabricParticleTypes.simple(true);

    public static void initializeOnServer() {
        Registry.register(Registries.PARTICLE_TYPE, new Identifier(Mcdw.MOD_ID, "offhand_sweep"), OFFHAND_SWEEP_PARTICLE);
    }

    public static void initializeOnClient() {
        ParticleFactoryRegistry.getInstance().register(OFFHAND_SWEEP_PARTICLE, SweepAttackParticle.Factory::new);
    }
}
