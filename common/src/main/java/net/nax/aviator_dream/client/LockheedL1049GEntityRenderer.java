package net.nax.aviator_dream.client;

import immersive_aircraft.client.render.entity.renderer.AircraftEntityRenderer;
import immersive_aircraft.client.render.entity.renderer.utils.ModelPartRenderHandler;
import immersive_aircraft.entity.AircraftEntity;
import net.nax.aviator_dream.AviatorDreams;
import net.nax.aviator_dream.entity.LockheedL1049GEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;

public class LockheedL1049GEntityRenderer extends AircraftEntityRenderer<LockheedL1049GEntity> {
    private static final ResourceLocation ID = AviatorDreams.locate("lockheed_l1049g");

    private final ModelPartRenderHandler<LockheedL1049GEntity> model = new ModelPartRenderHandler<LockheedL1049GEntity>()
            .add("dyed_body", (model, object, vertexConsumerProvider, entity, matrixStack, light, time, modelPartRenderer) ->
                    renderDyed(model, object, vertexConsumerProvider, entity, matrixStack, light, time, false, false))
            .add("dyed_body_highlights", (model, object, vertexConsumerProvider, entity, matrixStack, light, time, modelPartRenderer) ->
                    renderDyed(model, object, vertexConsumerProvider, entity, matrixStack, light, time, true, false));

    @Override
    protected ResourceLocation getModelId() {
        return ID;
    }

    public LockheedL1049GEntityRenderer(EntityRendererProvider.Context context) {
        super(context);
    }

    @Override
    protected ModelPartRenderHandler<LockheedL1049GEntity> getModel(AircraftEntity entity) {
        return model;
    }
}
