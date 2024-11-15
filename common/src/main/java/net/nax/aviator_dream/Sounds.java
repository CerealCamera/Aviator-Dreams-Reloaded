package net.nax.aviator_dream;

import immersive_aircraft.cobalt.registration.Registration;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;

import java.util.function.Supplier;

public class Sounds {
    public static Supplier<SoundEvent> R_START;
    public static Supplier<SoundEvent> R_REV;
    public static Supplier<SoundEvent> R_IDLE;
    public static Supplier<SoundEvent> R1820_START;
    public static Supplier<SoundEvent> R1820_PROP;
    public static Supplier<SoundEvent> R1820_IDLE;
    public static Supplier<SoundEvent> R1830_IDLE;
    public static Supplier<SoundEvent> R1830_START;
    public static Supplier<SoundEvent> R3350_HIGH;
    public static Supplier<SoundEvent> R3350_LOW;
    public static Supplier<SoundEvent> R3350_MID;
    public static Supplier<SoundEvent> R3350_PROP;
    public static Supplier<SoundEvent> R3350_START;
    public static Supplier<SoundEvent> R3350_STOP;
    public static Supplier<SoundEvent> GHOST_START;
    public static Supplier<SoundEvent> GHOST_STOP;
    public static Supplier<SoundEvent> GHOST_IDLE;
    public static Supplier<SoundEvent> GHOST_HIGH;
    public static Supplier<SoundEvent> LYNX_START;
    public static Supplier<SoundEvent> LYNX_STOP;
    public static Supplier<SoundEvent> LYNX_IDLE;
    public static Supplier<SoundEvent> LYNX_HIGH;

    public static void init(){
        R_START = register("r_start");
        R_REV = register("r_rev");
        R_IDLE = register("r_idle");
        R1820_START = register("r1820_start");
        R1820_PROP = register("r1820_prop");
        R1820_IDLE = register("r1820_idle");
        R1830_START = register("r1830_start");
        R1830_IDLE = register("r1830_idle");
        R3350_HIGH = register("r3350_high");
        R3350_LOW = register("r3350_low");
        R3350_MID = register("r3350_mid");
        R3350_PROP = register("r3350_prop");
        R3350_START = register("r3350_start");
        R3350_STOP = register("r3350_stop");
        GHOST_START = register("ghost_start");
        GHOST_STOP = register("ghost_stop");
        GHOST_IDLE = register("ghost_idle");
        GHOST_HIGH = register("ghost_high");
        LYNX_START = register("lynx_start");
        LYNX_STOP = register("lynx_stop");
        LYNX_IDLE = register("lynx_idle");
        LYNX_HIGH = register("lynx_high");
    }

    static void bootstrap() {
        // nop
    }

    static Supplier<SoundEvent> register(String name) {
        ResourceLocation id = AviatorDreams.locate(name);
        return Registration.register(BuiltInRegistries.SOUND_EVENT, id, () -> SoundEvent.createVariableRangeEvent(id));
    }
}