package net.cerealcamera.aviator_dream.entity;

import immersive_aircraft.entity.AircraftEntity;
import immersive_aircraft.entity.AirplaneEntity;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.cerealcamera.aviator_dream.AviatorDreams;
import net.cerealcamera.aviator_dream.Sounds;

public class LockheedL1049GEntity extends AirplaneEntity {
    public LockheedL1049GEntity(EntityType<? extends AircraftEntity> entityType, Level world) {
        super(entityType, world, true);
    }

    public boolean shuttingDown = false;
    public byte durationHigh = 0, durationLow = 0;

    @Override
    protected SoundEvent getEngineSound() {
        return SoundEvents.EMPTY;
    }

    @Override
    protected SoundEvent getEngineStartSound() {
        return Sounds.R3350_START.get();
    }

    private float reactionSpeed = 220.0f;

    @Override
    protected float getEngineReactionSpeed() {
        return reactionSpeed;
    }

    @Override
    public Item asItem() {
        return AviatorDreams.LOCKHEED_L1049G_ITEM.get();
    }

    @Override
    public void tick() {
        super.tick();

        if(getEngineTarget() == 0){
            reactionSpeed = 5.0f;
        }
        else {
            reactionSpeed = 220.0f;
        }

        if (getEngineTarget() == 0 && shuttingDown) {
            level().playLocalSound(getX(), getY() + getBbHeight() * 0.5, getZ(), Sounds.R3350_STOP.get(), getSoundSource(), 1.0f, 1.0f, false);
            shuttingDown = false;
        }

        if(getEngineTarget() > 0){
            shuttingDown = true;
        }

        if (level().isClientSide) {
            if (durationLow > 0) {
                durationLow--;
            }
            else if(durationLow == 0 && getEngineTarget() <= 0.25 && getEngineTarget() != 0 &&getFuelUtilization() != 0){
                level().playLocalSound(getX(), getY() + getBbHeight() * 0.5, getZ(), Sounds.R3350_LOW.get(), getSoundSource(), 1, 1, false);
                durationLow = 59;
            }
            if (durationHigh > 0) {
                durationHigh--;
            }
            else if(durationHigh == 0 && getEngineTarget() > 0.25 && getEngineTarget() != 0 &&getFuelUtilization() != 0){
                level().playLocalSound(getX(), getY() + getBbHeight() * 0.5, getZ(), Sounds.R3350_PROP.get(), getSoundSource(), 1, 1, false);
                durationHigh = 100;
            }
        }

        engineSpinUpStrength = Math.max(0.0f, engineSpinUpStrength + enginePower.getDiff() - 0.1f);

    }

    @Override
    public double getZoom() {
        return 40.0;
    }

    @Override
    public int getDefaultDyeColor() {
        return 0xEF2323;
    }
}
