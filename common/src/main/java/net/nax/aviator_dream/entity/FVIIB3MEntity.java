package net.nax.aviator_dream.entity;

import immersive_aircraft.entity.AircraftEntity;
import immersive_aircraft.entity.AirplaneEntity;
import immersive_aircraft.entity.misc.Trail;
import net.minecraft.sounds.SoundEvents;
import net.nax.aviator_dream.AviatorDreams;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.level.Level;
import net.nax.aviator_dream.Sounds;
import org.joml.Matrix3f;
import org.joml.Matrix4f;
import org.joml.Vector4f;

import java.util.List;

public class FVIIB3MEntity extends AirplaneEntity
{
    public FVIIB3MEntity(EntityType<? extends AircraftEntity> entityType, Level world) {
        super(entityType, world, true);
    }

    public boolean shuttingDown = false;
    public byte durationHigh = 0,durationLow = 0;

    @Override
    protected SoundEvent getEngineSound() {
        return SoundEvents.EMPTY;
    }

    @Override
    protected SoundEvent getEngineStartSound() {
        return Sounds.LYNX_START.get();
    }

    private float reactionSpeed = 180.0f;

    @Override
    protected float getEngineReactionSpeed() {
        return reactionSpeed;
    }

    @Override
    public Item asItem() {
        return AviatorDreams.FVIIB3M_ITEM.get();
    }

    private final List<Trail> trails = List.of(new Trail(30), new Trail(30));

    @Override
    public List<Trail> getTrails() {
        return trails;
    }

    @Override
    public void tick() {
        super.tick();

        if(getEngineTarget() == 0){
            reactionSpeed = 5.0f;
        }
        else {
            reactionSpeed = 180.0f;
        }

        if (getEngineTarget() == 0 && shuttingDown == true) {
            level().playLocalSound(getX(), getY() + getBbHeight() * 0.5, getZ(), Sounds.LYNX_STOP.get(), getSoundSource(), 1.0f, 1.0f, false);
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
                level().playLocalSound(getX(), getY() + getBbHeight() * 0.5, getZ(), Sounds.LYNX_IDLE.get(), getSoundSource(), 1, 1, false);
                durationLow = 59;
            }
        }

        if (level().isClientSide) {
            if (durationHigh > 0) {
                durationHigh--;
            }
            else if(durationHigh == 0 && getEngineTarget() > 0.25 && getEngineTarget() != 0 &&getFuelUtilization() != 0){
                level().playLocalSound(getX(), getY() + getBbHeight() * 0.5, getZ(), Sounds.LYNX_HIGH.get(), getSoundSource(), 1, 1, false);
                durationHigh = 37;
            }
        }

        engineSpinUpStrength = Math.max(0.0f, engineSpinUpStrength + enginePower.getDiff() - 0.1f);

    }

    @Override
    public double getZoom() {
        return 18.0;
    }

    @Override
    public int getDefaultDyeColor() {
        return 0xEF2323;
    }
}
