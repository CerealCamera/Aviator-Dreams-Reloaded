package net.cerealcamera.aviator_dream.fabric;

import net.cerealcamera.aviator_dream.AviatorDreams;
import net.cerealcamera.aviator_dream.AviatorDreamsClient;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;

import static immersive_aircraft.ItemColors.getDyeColor;

public class AviatorDreamsFabricClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        AviatorDreamsClient.registerEntityRenderer();

        ColorProviderRegistry.ITEM.register(getDyeColor(0xEF2323), AviatorDreams.DEHAVILLANDDH106_ITEM.get());
        ColorProviderRegistry.ITEM.register(getDyeColor(0xEF2323), AviatorDreams.LOCKHEED_L1049G_ITEM.get());
        ColorProviderRegistry.ITEM.register(getDyeColor(0xEF2323), AviatorDreams.DOUGLAS_C47_ITEM.get());
        ColorProviderRegistry.ITEM.register(getDyeColor(0xEF2323), AviatorDreams.DOUGLAS_DC1_ITEM.get());
        ColorProviderRegistry.ITEM.register(getDyeColor(0xEF2323), AviatorDreams.DOUGLAS_DC2_ITEM.get());
        ColorProviderRegistry.ITEM.register(getDyeColor(0xEF2323), AviatorDreams.TEST_ITEM.get());
        ColorProviderRegistry.ITEM.register(getDyeColor(0xEF2323), AviatorDreams.FVIIA_ITEM.get());
        ColorProviderRegistry.ITEM.register(getDyeColor(0xEF2323), AviatorDreams.FVIIB3M_ITEM.get());
        ColorProviderRegistry.ITEM.register(getDyeColor(0xEF2323), AviatorDreams.K100_ITEM.get());
    }
}