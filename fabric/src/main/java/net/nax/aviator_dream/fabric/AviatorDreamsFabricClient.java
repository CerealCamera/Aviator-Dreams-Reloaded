package net.nax.aviator_dream.fabric;

import net.nax.aviator_dream.AviatorDreamsClient;
import net.fabricmc.api.ClientModInitializer;

public class AviatorDreamsFabricClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        AviatorDreamsClient.init();
    }
}
