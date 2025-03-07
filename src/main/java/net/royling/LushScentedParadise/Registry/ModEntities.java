package net.royling.LushScentedParadise.Registry;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.royling.LushScentedParadise.LushScentedParadise;
import net.royling.LushScentedParadise.ModEntity.SpectralSteed.SpectralSteed;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, LushScentedParadise.MODID);
    public static final RegistryObject<EntityType<SpectralSteed>> SPECTRAL_STEED = ENTITIES.register("spectral_steed",
            () -> EntityType.Builder.of(SpectralSteed::new, MobCategory.CREATURE)
                    .sized(1.3964844F, 1.6F)
                    .build("spectral_steed"));
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(SPECTRAL_STEED.get(), SpectralSteed.createAttributes().build());
    }


    public static void register(IEventBus eventBus){
        ENTITIES.register(eventBus);
    }
}
