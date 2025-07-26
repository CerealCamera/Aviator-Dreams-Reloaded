package net.cerealcamera.aviator_dream.neoforge;

import net.cerealcamera.aviator_dream.AviatorDreams;
import net.cerealcamera.aviator_dream.AviatorDreamsClient;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.event.RegisterColorHandlersEvent;

import static immersive_aircraft.ItemColors.getDyeColor;

@EventBusSubscriber(modid = AviatorDreams.MOD_ID, value = Dist.CLIENT)
public class AviatorDreamsNeoForgeClient {
    @SubscribeEvent
    public static void setup(FMLClientSetupEvent event) {
        AviatorDreamsClient.registerEntityRenderer();
    }

    @SubscribeEvent
    public static void initItemColors(RegisterColorHandlersEvent.Item event) {
        event.register(getDyeColor(0xEF2323), AviatorDreams.DEHAVILLANDDH106_ITEM.get());
        event.register(getDyeColor(0xEF2323), AviatorDreams.LOCKHEED_L1049G_ITEM.get());
        event.register(getDyeColor(0xEF2323), AviatorDreams.DOUGLAS_C47_ITEM.get());
        event.register(getDyeColor(0xEF2323), AviatorDreams.DOUGLAS_DC1_ITEM.get());
        event.register(getDyeColor(0xEF2323), AviatorDreams.DOUGLAS_DC2_ITEM.get());
        event.register(getDyeColor(0xEF2323), AviatorDreams.TEST_ITEM.get());
        event.register(getDyeColor(0xEF2323), AviatorDreams.FVIIA_ITEM.get());
        event.register(getDyeColor(0xEF2323), AviatorDreams.FVIIB3M_ITEM.get());
        event.register(getDyeColor(0xEF2323), AviatorDreams.K100_ITEM.get());
    }
}
