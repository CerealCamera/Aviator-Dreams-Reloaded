package net.cerealcamera.aviator_dream.fabric;

import immersive_aircraft.fabric.CommonFabric;
import net.cerealcamera.aviator_dream.AviatorDreams;
import net.cerealcamera.aviator_dream.Sounds;
import net.fabricmc.api.ModInitializer;

public class AviatorDreamsFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        // Force loading the Immersive Aircraft class to have networking and registration loaded
        new CommonFabric();
        AviatorDreams.init();
        Sounds.init();
    }
}