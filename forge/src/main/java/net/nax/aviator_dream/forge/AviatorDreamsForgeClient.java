package net.nax.aviator_dream.forge;

import net.nax.aviator_dream.AviatorDreams;
import net.nax.aviator_dream.AviatorDreamsClient;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@SuppressWarnings("unused")
@Mod.EventBusSubscriber(modid = AviatorDreams.MOD_ID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class AviatorDreamsForgeClient {
    @SubscribeEvent
    public static void setup(EntityRenderersEvent.RegisterRenderers event) {
        AviatorDreamsClient.init();
    }
}
