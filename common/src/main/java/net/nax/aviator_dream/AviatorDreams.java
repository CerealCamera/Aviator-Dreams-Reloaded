package net.nax.aviator_dream;

import immersive_aircraft.Items;
import immersive_aircraft.cobalt.registration.Registration;
import immersive_aircraft.item.DyeableAircraftItem;
import net.nax.aviator_dream.entity.*;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.item.Item;
import java.util.function.Supplier;

import static immersive_aircraft.Items.baseProps;

public class AviatorDreams {
    public static final String MOD_ID = "aviator_dream";

    public static Supplier<Item> DOUGLAS_DC1_ITEM;
    public static Supplier<Item> DOUGLAS_DC2_ITEM;
    public static Supplier<Item> DOUGLAS_C47_ITEM;
    public static Supplier<Item> LOCKHEED_L1049G_ITEM;
    public static Supplier<Item> TEST_ITEM;
    public static Supplier<Item> DEHAVILLANDDH106_ITEM;
    public static Supplier<Item> FVIIB3M_ITEM;
    public static Supplier<Item> FVIIA_ITEM;
    public static Supplier<Item> K100_ITEM;

    public static Supplier<EntityType<DouglasDC1Entity>> DOUGLAS_DC1_ENTITY;
    public static Supplier<EntityType<DouglasDC2Entity>> DOUGLAS_DC2_ENTITY;
    public static Supplier<EntityType<DouglasC47Entity>> DOUGLAS_C47_ENTITY;
    public static Supplier<EntityType<LockheedL1049GEntity>> LOCKHEED_L1049G_ENTITY;
    public static Supplier<EntityType<test>> TEST_ENTITY;
    public static Supplier<EntityType<DehavillandDH106Entity>> DEHAVILLANDDH106_ENTITY;
    public static Supplier<EntityType<FVIIB3MEntity>> FVIIB3M_ENTITY;
    public static Supplier<EntityType<FVIIAEntity>> FVIIA_ENTITY;
    public static Supplier<EntityType<K100Entity>> K100_ENTITY;

    public static void init() {

        Sounds.init();
        // Register items
        DOUGLAS_DC1_ITEM = register("douglas_dc1", () -> new DyeableAircraftItem(baseProps().stacksTo(1), world -> new DouglasDC1Entity(DOUGLAS_DC1_ENTITY.get(), world)));
        DOUGLAS_DC2_ITEM = register("douglas_dc2", () -> new DyeableAircraftItem(baseProps().stacksTo(1), world -> new DouglasDC2Entity(DOUGLAS_DC2_ENTITY.get(), world)));
        DOUGLAS_C47_ITEM = register("douglas_c47", () -> new DyeableAircraftItem(baseProps().stacksTo(1), world -> new DouglasC47Entity(DOUGLAS_C47_ENTITY.get(), world)));
        LOCKHEED_L1049G_ITEM = register("lockheed_l1049g", () -> new DyeableAircraftItem(baseProps().stacksTo(1), world -> new LockheedL1049GEntity(LOCKHEED_L1049G_ENTITY.get(), world)));
        TEST_ITEM = register("test", () -> new DyeableAircraftItem(baseProps().stacksTo(1), world -> new test(TEST_ENTITY.get(), world)));
        DEHAVILLANDDH106_ITEM = register("dehavilland_dh106", () -> new DyeableAircraftItem(baseProps().stacksTo(1), world -> new DehavillandDH106Entity(DEHAVILLANDDH106_ENTITY.get(), world)));
        FVIIB3M_ITEM = register("fokker_fviib3m", () -> new DyeableAircraftItem(baseProps().stacksTo(1), world -> new FVIIB3MEntity(FVIIB3M_ENTITY.get(), world)));
        FVIIA_ITEM = register("fokker_fviia", () -> new DyeableAircraftItem(baseProps().stacksTo(1), world -> new FVIIAEntity(FVIIA_ENTITY.get(), world)));
        K100_ITEM = register("toyota_stout_k100", () -> new DyeableAircraftItem(baseProps().stacksTo(1), world -> new K100Entity(K100_ENTITY.get(), world)));

        // Register entities
        DOUGLAS_DC1_ENTITY = register("douglas_dc1", EntityType.Builder
                .of(DouglasDC1Entity::new, MobCategory.MISC)
                .sized(2.25f, 3.5f)
                .clientTrackingRange(20)
                .fireImmune()
        );
        DOUGLAS_DC2_ENTITY = register("douglas_dc2", EntityType.Builder
                .of(DouglasDC2Entity::new, MobCategory.MISC)
                .sized(2.25f, 3.5f)
                .clientTrackingRange(20)
                .fireImmune()
        );
        DOUGLAS_C47_ENTITY = register("douglas_c47", EntityType.Builder
                .of(DouglasC47Entity::new, MobCategory.MISC)
                .sized(2.25f, 3.5f)
                .clientTrackingRange(20)
                .fireImmune()
        );
        LOCKHEED_L1049G_ENTITY = register("lockheed_l1049g", EntityType.Builder
                .of(LockheedL1049GEntity::new, MobCategory.MISC)
                .sized(5f, 3.5f)
                .clientTrackingRange(20)
                .fireImmune()
        );
        TEST_ENTITY = register("test", EntityType.Builder
                .of(test::new, MobCategory.MISC)
                .sized(5f, 3.0f)
                .clientTrackingRange(20)
                .fireImmune()
        );
        DEHAVILLANDDH106_ENTITY = register("dehavilland_dh106", EntityType.Builder
                .of(DehavillandDH106Entity::new, MobCategory.MISC)
                .sized(5f, 3.0f)
                .clientTrackingRange(20)
                .fireImmune()
        );
        FVIIB3M_ENTITY = register("fokker_fviib3m", EntityType.Builder
                .of(FVIIB3MEntity::new, MobCategory.MISC)
                .sized(5f, 3.0f)
                .clientTrackingRange(20)
                .fireImmune()
        );
        FVIIA_ENTITY = register("fokker_fviia", EntityType.Builder
                .of(FVIIAEntity::new, MobCategory.MISC)
                .sized(5f, 3.0f)
                .clientTrackingRange(20)
                .fireImmune()
        );
        K100_ENTITY = register("toyota_stout_k100", EntityType.Builder
                .of(K100Entity::new, MobCategory.MISC)
                .sized(2f, 2.0f)
                .clientTrackingRange(20)
                .fireImmune()
        );
    }

    static Supplier<Item> register(String name, Supplier<Item> item) {
        Supplier<Item> register = Registration.register(BuiltInRegistries.ITEM, AviatorDreams.locate(name), item);
        Items.items.add(register);
        return register;
    }

    static <T extends Entity> Supplier<EntityType<T>> register(String name, EntityType.Builder<T> builder) {
        ResourceLocation id = AviatorDreams.locate(name);
        return Registration.register(BuiltInRegistries.ENTITY_TYPE, id, () -> builder.build(id.toString()));
    }

    public static ResourceLocation locate(String name) {
        return new ResourceLocation(AviatorDreams.MOD_ID, name);
    }
}
