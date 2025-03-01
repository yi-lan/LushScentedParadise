package net.royling.LushScentedParadise.Registry;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.royling.LushScentedParadise.LushScentedParadise;
import net.royling.LushScentedParadise.ModBlock.DryingRack.DryingRackBlock;
import net.royling.LushScentedParadise.ModBlock.TeapotBlock.TeapotBlock;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, LushScentedParadise.MODID);

    public static final RegistryObject<Block> TEAPOT = BLOCKS.register("teapot",
            () -> new TeapotBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).strength(2.0f)));
    public static final RegistryObject<Block> FLOWER_TABLE = BLOCKS.register("flower_table",
            ()->new Block(BlockBehaviour.Properties.copy(Blocks.CRAFTING_TABLE).strength(1.0f)));
    public static final RegistryObject<Block> DRYING_RACK = BLOCKS.register("drying_rack",
            ()->new DryingRackBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).strength(1.0f)));
    /*public static final RegistryObject<Block> FLOWER_BASKET = BLOCKS.register("flower_basket",
            ()->new FlowerBasket(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).strength(1.0F)));*/





    public static void register(IEventBus eventBus){
        BLOCKS.register(eventBus);
    }
}
