package net.cerealcamera.aviator_dream.forge;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.cerealcamera.aviator_dream.AviatorDreams;
import net.cerealcamera.aviator_dream.AviatorDreamsClient;

@Mod.EventBusSubscriber(modid = AviatorDreams.MOD_ID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class AviatorDreamsForgeClient {
    @SubscribeEvent
    public static void setup(EntityRenderersEvent.RegisterRenderers event) {
        AviatorDreamsClient.registerEntityRenderer();
    }
}