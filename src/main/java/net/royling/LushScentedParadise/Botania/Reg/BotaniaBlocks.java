package net.royling.LushScentedParadise.Botania.Reg;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.royling.LushScentedParadise.Botania.BotaniaTeapot.ManaTeapotBlock;
import net.royling.LushScentedParadise.LushScentedParadise;


public class BotaniaBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, LushScentedParadise.MODID);

    public static final RegistryObject<Block> MANA_TEAPOT = BLOCKS.register("mana_teapot",
            () -> new ManaTeapotBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).strength(2.0f)));

}
