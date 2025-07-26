package net.cerealcamera.aviator_dream.neoforge;

import net.cerealcamera.aviator_dream.AviatorDreams;
import net.cerealcamera.aviator_dream.Sounds;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.registries.RegisterEvent;

@Mod(AviatorDreams.MOD_ID)
@EventBusSubscriber(modid = AviatorDreams.MOD_ID)
public class AviatorDreamsNeoForge {
    private static boolean registered = false;

    @SubscribeEvent
    public static void onRegistryEvent(RegisterEvent event) {
        if (!registered) {
            registered = true;
            AviatorDreams.init();
            Sounds.init();
        }
    }
}