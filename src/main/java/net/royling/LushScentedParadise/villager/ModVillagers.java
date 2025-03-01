package net.royling.LushScentedParadise.villager;

import com.google.common.collect.ImmutableSet;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.royling.LushScentedParadise.LushScentedParadise;
import net.royling.LushScentedParadise.Registry.ModBlocks;

public class ModVillagers {
    public static final DeferredRegister<PoiType> POI_TYPES=
            DeferredRegister.create(ForgeRegistries.POI_TYPES, LushScentedParadise.MODID);
    public static final DeferredRegister<VillagerProfession> VILLAGER_PROFESSIONS =
            DeferredRegister.create(ForgeRegistries.VILLAGER_PROFESSIONS, LushScentedParadise.MODID);

    public static final RegistryObject<PoiType> FLOWER_POI = POI_TYPES.register("flower_poi",
            ()->new PoiType(ImmutableSet.copyOf(ModBlocks.FLOWER_TABLE.get().getStateDefinition().getPossibleStates()),1,1));

    public static final RegistryObject<VillagerProfession> FLOWER_MASTER =
            VILLAGER_PROFESSIONS.register("flower_master",()->new VillagerProfession("flower_master",
                    holder-> holder.get()==FLOWER_POI.get(),
                    holder-> holder.get()==FLOWER_POI.get(),
                    ImmutableSet.of(),ImmutableSet.of(), SoundEvents.GRASS_BREAK));




    public static void register(IEventBus eventBus){
        POI_TYPES.register(eventBus);
        VILLAGER_PROFESSIONS.register(eventBus);
    }
}
