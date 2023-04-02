package com.redpxnda.respawnobelisks.fabric;

import com.redpxnda.respawnobelisks.registry.ModRegistries;
import com.redpxnda.respawnobelisks.registry.particle.RuneCircleParticle;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;

public class RespawnObelisksClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ParticleFactoryRegistry.getInstance().register(ModRegistries.RUNE_CIRCLE_PARTICLE.get(), RuneCircleParticle.Provider::new);
    }
}