package net.cerealcamera.aviator_dream.entity;

import immersive_aircraft.entity.AircraftEntity;
import immersive_aircraft.entity.AirplaneEntity;
import immersive_aircraft.entity.misc.TrailDescriptor;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.cerealcamera.aviator_dream.AviatorDreams;
import net.cerealcamera.aviator_dream.Sounds;
import org.joml.Matrix4f;

public class DouglasDC2Entity extends AirplaneEntity {

    public DouglasDC2Entity(EntityType<? extends AircraftEntity> entityType, Level world) {
        super(entityType, world, true);
    }

    private float reactionSpeed = 150.0f;

    public byte durationHigh = 0, durationLow = 0;

    @Override
    protected float getEngineReactionSpeed() {
        return reactionSpeed;
    }

    @Override
    protected SoundEvent getEngineSound() {
        return SoundEvents.EMPTY;
    }

    @Override
    protected SoundEvent getEngineStartSound() {
        return Sounds.R1820_START.get();
    }

    @Override
    public Item asItem() {
        return AviatorDreams.DOUGLAS_DC2_ITEM.get();
    }

    @Override
    public float getBaseTrailWidth(Matrix4f transform, int index, TrailDescriptor trail) {
        return (float) (Math.sqrt(getDeltaMovement().length()) * (0.5f - (pressingInterpolatedX.getSmooth() * trail.x()) * 0.025f) - 0.25f);
    }

    @Override
    public void tick() {
        super.tick();

        if(getEngineTarget() <= getEnginePower()){
            reactionSpeed = 200.0f;
        }
        else {
            reactionSpeed = 150.0f;
        }

        if (level().isClientSide) {
            if (durationLow > 0) {
                durationLow--;
            }
            else if(durationLow == 0 && getEngineTarget() <= 0.25 && getEngineTarget() != 0 &&getFuelUtilization() != 0){
                level().playLocalSound(getX(), getY() + getBbHeight() * 0.5, getZ(), Sounds.R1820_IDLE.get(), getSoundSource(), 1, 1, false);
                durationLow = 67;
            }
            if (durationHigh > 0) {
                durationHigh--;
            }
            else if(durationHigh == 0 && getEngineTarget() > 0.25 && getEngineTarget() != 0 &&getFuelUtilization() != 0){
                level().playLocalSound(getX(), getY() + getBbHeight() * 0.5, getZ(), Sounds.R1820_PROP.get(), getSoundSource(), 1, 1, false);
                durationHigh = 69;
            }
        }

        engineSpinUpStrength = Math.max(0.0f, engineSpinUpStrength + enginePower.getDiff() - 0.1f);
    }

    @Override
    public double getZoom() {
        return 35.0;
    }

    @Override
    public int getDefaultDyeColor() {
        return 0xEF2323;
    }
}
