package net.nax.aviator_dream.client;

import immersive_aircraft.client.render.entity.renderer.AircraftEntityRenderer;
import immersive_aircraft.client.render.entity.renderer.utils.ModelPartRenderHandler;
import immersive_aircraft.entity.AircraftEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.nax.aviator_dream.AviatorDreams;
import net.nax.aviator_dream.entity.Test;

public class testRenderer extends AircraftEntityRenderer<Test> {
    private static final ResourceLocation ID = AviatorDreams.locate("test");

    private final ModelPartRenderHandler<Test> model = new ModelPartRenderHandler<Test>()
            .add("dyed_body", (model, object, vertexConsumerProvider, entity, matrixStack, light, time, modelPartRenderer) ->
                    renderDyed(model, object, vertexConsumerProvider, entity, matrixStack, light, time, false, false))
            .add("dyed_body_highlights", (model, object, vertexConsumerProvider, entity, matrixStack, light, time, modelPartRenderer) ->
                    renderDyed(model, object, vertexConsumerProvider, entity, matrixStack, light, time, true, false));

    @Override
    protected ResourceLocation getModelId() {
        return ID;
    }

    public testRenderer(EntityRendererProvider.Context context) {
        super(context);
    }

    @Override
    protected ModelPartRenderHandler<Test> getModel(AircraftEntity entity) {
        return model;
    }
}
