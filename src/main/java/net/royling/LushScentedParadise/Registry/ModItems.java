package net.royling.LushScentedParadise.Registry;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.royling.LushScentedParadise.Item.FlowerFertilizer;
import net.royling.LushScentedParadise.Item.FlowerSword;
import net.royling.LushScentedParadise.Item.Flowertea.tea;
import net.royling.LushScentedParadise.Item.MortarAndPestleItem;
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
    public static final RegistryObject<Item> MUSIC_DISC =
            ITEMS.register("music_disc",()->new RecordItem(6,ModSounds.MUSIC_DISC,
                    new Item.Properties().stacksTo(1).rarity(Rarity.RARE),1020));
    public static final RegistryObject<Item> FLOWER_BOOK = ITEMS.register("flowerbook",()->new Item(new Item.Properties().stacksTo(1)){
        @Override
        public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
            if(!pLevel.isClientSide){
                return InteractionResultHolder.pass(pPlayer.getItemInHand(pUsedHand));
            }
            return InteractionResultHolder.success(pPlayer.getItemInHand(pUsedHand));
        }
    });
    //1.1版本
    public static final RegistryObject<Item> MORTAR_AND_PESTLE = ITEMS.register("mortar_and_pestle", ()->new MortarAndPestleItem(new Item.Properties().stacksTo(1).durability(64)));
    public static final RegistryObject<Item> DRIED_WITHER_ROSE = ITEMS.register("dried_wither_rose",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> DRIED_SPORE_BLOSSOM = ITEMS.register("dried_spore_blossom",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> DRIED_CACTUS = ITEMS.register("dried_cactus",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> DRIED_COCOA_BEANS = ITEMS.register("dried_cocoa_beans",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> COCOA_POWDER = ITEMS.register("cocoa_powder",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> DRIED_GLOW_BERRIES = ITEMS.register("dried_glow_berries",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> DRIED_SWEET_BERRIES = ITEMS.register("dried_sweet_berries",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> FLOWER_FERTILIZER = ITEMS.register("flower_fertilizer",()->new FlowerFertilizer(new Item.Properties().stacksTo(64)));

    public static final RegistryObject<Item> COFFEE_FRUIT = ITEMS.register("coffee_fruit",
            () -> new BlockItem(ModBlocks.COFFEE_TREE.get(),
                    new Item.Properties().stacksTo(64)));
    public static final RegistryObject<Item> COFFEE_BEANS = ITEMS.register("coffee_beans",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> COFFEE_POWDER = ITEMS.register("coffee_powder",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> DRIED_COFFEE_BEANS = ITEMS.register("dried_coffee_beans",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> VANILLA_SEEDS = ITEMS.register("vanilla_seeds",
            () -> new ItemNameBlockItem(ModBlocks.VANILLA_CROP.get(), new Item.Properties()));
    public static final RegistryObject<Item> VANILLA_POD = ITEMS.register("vanilla_pod",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder()
                    .nutrition(1).saturationMod(0.3f).build())));
    public static final RegistryObject<Item> DRIED_VANILLA_POD = ITEMS.register("dried_vanilla_pod",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> MILK_FOAM = ITEMS.register("milk_foam",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> VANILLA_SYRUP = ITEMS.register("vanilla_syrup",
            () -> new tea(new Item.Properties().stacksTo(16).food(new FoodProperties.Builder().nutrition(5).saturationMod(0.3f).build()),60));
    public static final RegistryObject<Item> GINGER_POWDER = ITEMS.register("ginger_powder",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> BUTTER = ITEMS.register("butter",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> CREAM = ITEMS.register("cream",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> GINGERBREAD_MAN = ITEMS.register("gingerbread_man",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> COOKED_GINGERBREAD_MAN = ITEMS.register("cooked_gingerbread_man",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(8).saturationMod(0.6f)
                    .effect(new MobEffectInstance(MobEffects.JUMP,1200,2),1f)
                    .effect(new MobEffectInstance(MobEffects.LUCK,4800,1),1F).build())));
    public static final RegistryObject<Item> CHOCOLATE = ITEMS.register("chocolate",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(6).saturationMod(0.3f)
                    .effect(new MobEffectInstance(MobEffects.REGENERATION,400,0),1f)
                    .effect(new MobEffectInstance(MobEffects.LUCK,2400,0),1F).build())));



    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
