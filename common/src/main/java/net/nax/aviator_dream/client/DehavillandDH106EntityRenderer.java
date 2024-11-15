package net.nax.aviator_dream.client;

import immersive_aircraft.client.render.entity.renderer.AircraftEntityRenderer;
import immersive_aircraft.client.render.entity.renderer.utils.ModelPartRenderHandler;
import immersive_aircraft.entity.AircraftEntity;
import net.nax.aviator_dream.AviatorDreams;
import net.nax.aviator_dream.entity.DehavillandDH106Entity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;

public class DehavillandDH106EntityRenderer extends AircraftEntityRenderer<DehavillandDH106Entity> {
    private static final ResourceLocation ID = AviatorDreams.locate("dehavilland_dh106");

    private final ModelPartRenderHandler<DehavillandDH106Entity> model = new ModelPartRenderHandler<DehavillandDH106Entity>()
            .add("dyed_body", (model, object, vertexConsumerProvider, entity, matrixStack, light, time, modelPartRenderer) ->
                    renderDyed(model, object, vertexConsumerProvider, entity, matrixStack, light, time, false, false))
            .add("dyed_body_highlights", (model, object, vertexConsumerProvider, entity, matrixStack, light, time, modelPartRenderer) ->
                    renderDyed(model, object, vertexConsumerProvider, entity, matrixStack, light, time, true, false));

    @Override
    protected ResourceLocation getModelId() {
        return ID;
    }

    public DehavillandDH106EntityRenderer(EntityRendererProvider.Context context) {
        super(context);
    }

    @Override
    protected ModelPartRenderHandler<DehavillandDH106Entity> getModel(AircraftEntity entity) {
        return model;
    }
}
