package net.nax.aviator_dream;

import immersive_aircraft.ItemColors;
import immersive_aircraft.cobalt.registration.Registration;
import net.nax.aviator_dream.client.*;
import net.nax.aviator_dream.client.testRenderer;

import static immersive_aircraft.ItemColors.getDyeColor;

public class AviatorDreamsClient {
    public static void init() {

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

    static {
        ItemColors.ITEM_COLORS.put(AviatorDreams.DOUGLAS_DC1_ITEM.get(), getDyeColor(0xEF2323));
        ItemColors.ITEM_COLORS.put(AviatorDreams.DOUGLAS_DC2_ITEM.get(), getDyeColor(0xEF2323));
        ItemColors.ITEM_COLORS.put(AviatorDreams.DOUGLAS_C47_ITEM.get(), getDyeColor(0xEF2323));
        ItemColors.ITEM_COLORS.put(AviatorDreams.LOCKHEED_L1049G_ITEM.get(), getDyeColor(0xEF2323));
        ItemColors.ITEM_COLORS.put(AviatorDreams.TEST_ITEM.get(), getDyeColor(0xEF2323));
        ItemColors.ITEM_COLORS.put(AviatorDreams.DEHAVILLANDDH106_ITEM.get(), getDyeColor(0xEF2323));
        ItemColors.ITEM_COLORS.put(AviatorDreams.FVIIB3M_ITEM.get(), getDyeColor(0xEF2323));
        ItemColors.ITEM_COLORS.put(AviatorDreams.FVIIA_ITEM.get(), getDyeColor(0xEF2323));
        ItemColors.ITEM_COLORS.put(AviatorDreams.K100_ITEM.get(), getDyeColor(0xEF2323));
    }
}
