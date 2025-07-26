package net.cerealcamera.aviator_dream;

import immersive_aircraft.cobalt.registration.Registration;
import net.cerealcamera.aviator_dream.client.*;

public class AviatorDreamsClient {
    public static void registerEntityRenderer() {
        Registration.register(AviatorDreams.DOUGLAS_DC1_ENTITY.get(), DouglasDC1EntityRenderer::new);
        Registration.register(AviatorDreams.DOUGLAS_DC2_ENTITY.get(), DouglasDC2EntityRenderer::new);
        Registration.register(AviatorDreams.DOUGLAS_C47_ENTITY.get(), DouglasC47EntityRenderer::new);
        Registration.register(AviatorDreams.LOCKHEED_L1049G_ENTITY.get(), LockheedL1049GEntityRenderer::new);
        Registration.register(AviatorDreams.TEST_ENTITY.get(), testRenderer::new);
        Registration.register(AviatorDreams.DEHAVILLANDDH106_ENTITY.get(), DehavillandDH106EntityRenderer::new);
        Registration.register(AviatorDreams.FVIIB3M_ENTITY.get(), FVIIB3MEntityRenderer::new);
        Registration.register(AviatorDreams.FVIIA_ENTITY.get(), FVIIAEntityRenderer::new);
        Registration.register(AviatorDreams.K100_ENTITY.get(), K100EntityRenderer::new);
    }
}