package net.cerealcamera.aviator_dream.fabric;

import immersive_aircraft.ItemColors;
import net.cerealcamera.aviator_dream.AviatorDreamsClient;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;

public class AviatorDreamsFabricClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        AviatorDreamsClient.registerEntityRenderer();

        ItemColors.ITEM_COLOR_PROVIDERS.forEach((item, itemColor) -> ColorProviderRegistry.ITEM.register(itemColor, item.get()));
    }
}
