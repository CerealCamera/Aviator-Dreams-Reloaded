package net.cerealcamera.aviator_dream.entity;

import immersive_aircraft.entity.AircraftEntity;
import immersive_aircraft.entity.Rotorcraft;
import immersive_aircraft.item.upgrade.VehicleStat;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.cerealcamera.aviator_dream.AviatorDreams;
import org.joml.Vector3f;

public class Test extends Rotorcraft {
    public float x = 0.0f, oldX = 0.0f, oldZ = 0.0f, z = 0.0f, speed = 0.0f, throttle = 0.0f;

    public Test(EntityType<? extends AircraftEntity> entityType, Level world) {
        super(entityType, world, false);
    }

    @Override
    public float maxUpStep() {
        return 1.2f;
    }

    @Override
    protected float getEngineReactionSpeed() {
        return 50.0f;
    }

    @Override
    public Item asItem() {
        return AviatorDreams.TEST_ITEM.get();
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
            if (getEngineTarget() > 1) {
                setEngineTarget(1f);
            }
        }
        //speed = (float)(Math.sqrt(Math.pow(vec.x , 2) + Math.pow(vec.y, 2) + Math.pow(vec.z, 2)) * 20);

        this.x = (float) this.getX();
        this.z = (float) this.getZ();
        this.speed = (float)(Math.sqrt(Math.pow(x - oldX , 2) + Math.pow(z - oldZ, 2)) * 20);
        if (this.speed < 0) {
            this.speed = this.speed * (-1.0f);
        }

        if (this.speed != 0 && this.pressingInterpolatedZ.getSmooth() > 0) {
            setYRot(getYRot() - (this.speed * (0.6f - ((this.speed / 3.6f) * 0.01f)) * this.pressingInterpolatedX.getSmooth()));
        } else if (this.speed != 0 && this.pressingInterpolatedZ.getSmooth() < 0) {
            setYRot(getYRot() + (this.speed * 0.8f) * this.pressingInterpolatedX.getSmooth());
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