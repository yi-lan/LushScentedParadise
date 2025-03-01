package net.royling.LushScentedParadise.Registry;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tiers;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.royling.LushScentedParadise.Item.FlowerSword;
import net.royling.LushScentedParadise.Item.StorageBagItem.FlowerBagItem;
import net.royling.LushScentedParadise.Item.StorageBagItem.SeedBagItem;
import net.royling.LushScentedParadise.LushScentedParadise;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, LushScentedParadise.MODID);

    public static final RegistryObject<Item> CLEAN_WATER = ITEMS.register("clean_water",
            ()->new Item(new Item.Properties().stacksTo(64)));
    public static final RegistryObject<Item> DIRTY_WATER = ITEMS.register("dirty_water",
            ()->new Item(new Item.Properties().stacksTo(64)));
    public static final RegistryObject<BlockItem> TEAPOT = ITEMS.register("teapot",
            ()->new BlockItem(ModBlocks.TEAPOT.get(),new Item.Properties()));
    public static final RegistryObject<BlockItem> FLOWER_TABLE = ITEMS.register("flower_table",
            ()->new BlockItem(ModBlocks.FLOWER_TABLE.get(),new Item.Properties()));
    public static final RegistryObject<BlockItem> DRYING_RACK = ITEMS.register("drying_rack",
            ()->new BlockItem(ModBlocks.DRYING_RACK.get(),new Item.Properties()));
    public static final RegistryObject<Item> ORIGINAL_FLOWER_SWORD = ITEMS.register("original_flower_sword",
            ()->new SwordItem(Tiers.IRON,0,-3,new Item.Properties().stacksTo(1).durability(456)));
    public static final RegistryObject<Item> FLOWER_SWORD = ITEMS.register("flower_sword",
            ()->new FlowerSword(Tiers.IRON,2,-2.4f,new Item.Properties().stacksTo(1).durability(1208)));
    public static final RegistryObject<Item> FLOWER_BAG = ITEMS.register("flower_bag",
            ()->new FlowerBagItem(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> SEED_BAG = ITEMS.register("seed_bag",
            ()->new SeedBagItem(new Item.Properties().stacksTo(1)));
    /*public static final RegistryObject<Item> FLOWER_BASKET = ITEMS.register("flower_basket",
            ()->new BlockItem(ModBlocks.FLOWER_BASKET.get(),new Item.Properties().stacksTo(16)));*/
    public static final RegistryObject<Item> DRIED_VIOLET = ITEMS.register("dried_violet",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> DRIED_HIBISCUS = ITEMS.register("dried_hibiscus",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> DRIED_HERBACEOUS_PEONY = ITEMS.register("dried_herbaceous_peony",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> DRIED_JASMINE = ITEMS.register("dried_jasmine",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> DRIED_LAVENDER = ITEMS.register("dried_lavender",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> DRIED_LILY = ITEMS.register("dried_lily",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> DRIED_SAFFLOWER = ITEMS.register("dried_safflower",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> DRIED_SNOW_LOTUS = ITEMS.register("dried_snow_lotus",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> DRIED_MARIGOLD = ITEMS.register("dried_marigold",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> DRIED_OENOTHERA_LINDHEIMERI = ITEMS.register("dried_oenothera_lindheimeri",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> DRIED_PERILLA = ITEMS.register("dried_perilla",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> DRIED_HONEYSUCKLE = ITEMS.register("dried_honeysuckle",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> DRIED_GREEN_TEA_LEAVE = ITEMS.register("dried_green_tea_leave",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> DRIED_BLACK_TEA_LEAVE = ITEMS.register("dried_black_tea_leave",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> DRIED_GINGER_ITEM = ITEMS.register("dried_ginger",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> DRIED_WHITE_TEA_LEAVE = ITEMS.register("dried_white_tea_leave",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> DRIED_OOLONG_TEA_LEAVE = ITEMS.register("dried_oolong_tea_leave",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> DRIED_PUER_TEA_LEAVE = ITEMS.register("dried_puer_tea_leave",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> DRIED_MINT_LEAVE = ITEMS.register("dried_mint_leave",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> DRIED_LICORICE_ROOT = ITEMS.register("dried_licorice_root",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> DRIED_ASTRAGALUS_ROOT = ITEMS.register("dried_astragalus_root",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> DRIED_VERBENA_ITEM = ITEMS.register("dried_verbena",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> DRIED_BURDOCK_ITEM = ITEMS.register("dried_burdock",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> DRIED_KUDZU_ITEM = ITEMS.register("dried_kudzu",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> DRIED_PORIA_ITEM = ITEMS.register("dried_poria",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> DRIED_FLAX_ITEM = ITEMS.register("dried_flax",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> DRIED_DANDELION = ITEMS.register("dried_dandelion",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> DRIED_POPPY = ITEMS.register("dried_poppy",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> DRIED_ORCHID = ITEMS.register("dried_orchid",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> DRIED_TULIP = ITEMS.register("dried_tulip",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> DRIED_OXEYE_DAISY = ITEMS.register("dried_oxeye_daisy",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> DRIED_CORNFLOWER = ITEMS.register("dried_cornflower",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> DRIED_LILY_OF_THE_VALLEY = ITEMS.register("dried_lily_of_the_valley",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> DRIED_LILAC = ITEMS.register("dried_lilac",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> DRIED_ROSE = ITEMS.register("dried_rose",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> DRIED_PEONY = ITEMS.register("dried_peony",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> MILK = ITEMS.register("milk",
            ()->new Item(new Item.Properties().stacksTo(16)));

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
