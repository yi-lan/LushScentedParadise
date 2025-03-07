package net.royling.LushScentedParadise.Botania.Reg;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.royling.LushScentedParadise.Botania.BotaniaTeapot.ManaTeapotBlockEntity;
import net.royling.LushScentedParadise.LushScentedParadise;
import net.royling.LushScentedParadise.ModBlock.TeapotBlock.TeapotBlockEntity;
import net.royling.LushScentedParadise.Registry.ModBlocks;

public class BotaniaBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, LushScentedParadise.MODID);

    public static final RegistryObject<BlockEntityType<ManaTeapotBlockEntity>> MANA_TEAPOT =
            BLOCK_ENTITIES.register("mana_teapot",
                    () -> BlockEntityType.Builder.of(ManaTeapotBlockEntity::new, BotaniaBlocks.MANA_TEAPOT.get()).build(null));


}
