package net.cerealcamera.aviator_dream.neoforge;

import net.cerealcamera.aviator_dream.AviatorDreams;
import net.cerealcamera.aviator_dream.AviatorDreamsClient;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;

@EventBusSubscriber(modid = AviatorDreams.MOD_ID, value = Dist.CLIENT)
public class AviatorDreamsNeoForgeClient {
    @SubscribeEvent
    public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
        AviatorDreamsClient.registerEntityRenderer();
    }
}
