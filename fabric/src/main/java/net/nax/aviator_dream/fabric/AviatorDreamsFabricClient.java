package net.nax.aviator_dream.fabric;

import net.fabricmc.api.ClientModInitializer;
import net.nax.aviator_dream.AviatorDreamsClient;

public class AviatorDreamsFabricClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        AviatorDreamsClient.init();
    }
}
