package net.cerealcamera.aviator_dream.forge;

import net.cerealcamera.aviator_dream.AviatorDreams;
import net.cerealcamera.aviator_dream.Sounds;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.RegisterEvent;

@Mod(AviatorDreams.MOD_ID)
@Mod.EventBusSubscriber(modid = AviatorDreams.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class AviatorDreamsForge {
    private static boolean registered = false;

    public AviatorDreamsForge() {
        Sounds.init();
    }

    @SubscribeEvent
    public static void onRegistryEvent(RegisterEvent event) {
        if (!registered) {
            registered = true;
            AviatorDreams.init();
        }
    }
}