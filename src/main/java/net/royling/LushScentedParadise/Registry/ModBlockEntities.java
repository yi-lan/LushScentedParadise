package net.royling.LushScentedParadise.Registry;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.royling.LushScentedParadise.LushScentedParadise;
import net.royling.LushScentedParadise.ModBlock.DryingRack.DryingRackBlockEntity;
import net.royling.LushScentedParadise.ModBlock.TeapotBlock.TeapotBlockEntity;


public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, LushScentedParadise.MODID);

    public static final RegistryObject<BlockEntityType<TeapotBlockEntity>> TEAPOT =
            BLOCK_ENTITIES.register("teapot",
                    () -> BlockEntityType.Builder.of(TeapotBlockEntity::new, ModBlocks.TEAPOT.get()).build(null));

    public static final RegistryObject<BlockEntityType<DryingRackBlockEntity>> DRYING_RACK  =
            BLOCK_ENTITIES.register("drying_rack",
                    ()-> BlockEntityType.Builder.of(DryingRackBlockEntity::new, ModBlocks.DRYING_RACK.get()).build(null));



    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}
