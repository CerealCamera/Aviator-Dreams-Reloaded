package net.nax.aviator_dream.fabric;

import immersive_aircraft.fabric.CommonFabric;
import net.fabricmc.api.ModInitializer;
import net.nax.aviator_dream.AviatorDreams;
import net.nax.aviator_dream.Sounds;

public class AviatorDreamsFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        // Force loading the Immersive Aircraft class to have networking and registration loaded
        new CommonFabric();
        AviatorDreams.init();
        Sounds.init();
    }
}