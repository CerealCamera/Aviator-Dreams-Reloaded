package net.nax.aviator_dream.entity;

import immersive_aircraft.Sounds;
import immersive_aircraft.entity.Rotorcraft;
import immersive_aircraft.entity.AircraftEntity;
import net.nax.aviator_dream.AviatorDreams;
import immersive_aircraft.item.upgrade.VehicleStat;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import org.joml.Vector3f;

import java.util.List;

public class test extends Rotorcraft {
    public test(EntityType<? extends AircraftEntity> entityType, Level world) {
        super(entityType, world, false);
        setMaxUpStep(1.2f);
    }

    public float x = 0.0f ,oldX = 0.0f, oldZ = 0.0f, z = 0.0f, speedd = 0.0f, speed = 0.0f, throttle = 0.0f;


    @Override
    protected float getEngineReactionSpeed() {
        return 25.0f;
    }

    protected SoundEvent getEngineSound() {
        return Sounds.PROPELLER.get();
    }

    @Override
    public Item asItem() {
        return AviatorDreams.TEST_ITEM.get();
    }

    @Override
    protected float getGravity() {
        return wasTouchingWater ? 0.5f : (0.2f * super.getGravity());
    }

    @Override
    protected void updateController() {
        super.updateController();

            if (canTurnOnEngine(getControllingPassenger())) {
                if (pressingInterpolatedZ.getSmooth() < 0) {
                    throttle = pressingInterpolatedZ.getSmooth() * (-1);
                } else {
                    throttle = pressingInterpolatedZ.getSmooth();
                }
                if (!onGround()) {
                    if (pressingInterpolatedZ.getSmooth() > 0) {
                        setEngineTarget(throttle + 0.2f);
                    } else {
                        setEngineTarget(throttle / 2 + 0.2f);
                    }
                } else {
                    if (pressingInterpolatedZ.getSmooth() > 0) {
                        setEngineTarget(throttle * 2.0f + 0.2f);
                    } else {
                        setEngineTarget(throttle * 1.4f + 0.2f);
                    }
                }
            }


        //speed = (float)(Math.sqrt(Math.pow(vec.x , 2) + Math.pow(vec.y, 2) + Math.pow(vec.z, 2)) * 20);

        this.x = (float) this.getX();
        this.z = (float) this.getZ();
        this.speedd = (float)(Math.sqrt(Math.pow(x - oldX , 2) + Math.pow(z - oldZ, 2)) * 20);
        if (this.speedd < 0) {
            this.speedd = this.speedd * (-1.0f);
        }

            if (this.speedd != 0 && this.pressingInterpolatedZ.getSmooth() > 0) {
                setYRot(getYRot() - (this.speedd * (0.6f - ((this.speedd / 3.6f) * 0.01f)) * this.pressingInterpolatedX.getSmooth()));
            } else if (this.speedd != 0 && this.pressingInterpolatedZ.getSmooth() < 0) {
                setYRot(getYRot() + (this.speedd * 0.8f) * this.pressingInterpolatedX.getSmooth());
            }

        this.oldX = this.x;
        this.oldZ = this.z;

        // up and down
        //setDeltaMovement(getDeltaMovement().add(0.0f, getEnginePower() * getProperties().get(VehicleStat.VERTICAL_SPEED) * pressingInterpolatedY.getSmooth(), 0.0f));

        // get pointing direction
        Vector3f direction = getForwardDirection();




        // accelerate
        float thrust = (float) (Math.pow(getEnginePower(), 5.0) * getProperties().get(VehicleStat.ENGINE_SPEED)) * pressingInterpolatedZ.getSmooth();
        Vector3f f = direction.mul(thrust);
        setDeltaMovement(getDeltaMovement().add(f.x, f.y, f.z));
    }



    @Override
    public void tick() {
        super.tick();
    }



    @Override
    public double getZoom() {
        return 5.0;
    }

    @Override
    public float getPropellerSpeed() {
        return super.getPropellerSpeed() * (0.25f + Math.abs(pressingInterpolatedZ.get(0.0f)));
    }
}