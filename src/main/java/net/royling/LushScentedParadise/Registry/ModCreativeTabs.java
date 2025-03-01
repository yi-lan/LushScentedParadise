package net.royling.LushScentedParadise.Registry;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.royling.LushScentedParadise.LushScentedParadise;
import net.royling.LushScentedParadise.Item.Flowertea.ModFoods;
import net.royling.LushScentedParadise.Item.newFlower.ModFlowers;

public class ModCreativeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB_DEFERRED_REGISTER=
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, LushScentedParadise.MODID);
    public static final RegistryObject<CreativeModeTab> NATURE =CREATIVE_MODE_TAB_DEFERRED_REGISTER
            .register("lushscentedparadise_nature",()-> CreativeModeTab.builder()
                    .icon(()->new ItemStack(ModFlowers.OENOTHERA_LINDHEIMERI.get()))
                    .title(Component.translatable("creative.lushscentedparadise.lushscentedparadise_nature"))
                    .displayItems(((pParameters, pOutput) -> {
                        pOutput.accept(ModFlowers.HIBISCUS.get());
                        pOutput.accept(ModFlowers.JASMINE.get());
                        pOutput.accept(ModFlowers.LAVENDER.get());
                        pOutput.accept(ModFlowers.LILY.get());
                        pOutput.accept(ModFlowers.MARIGOLD.get());
                        pOutput.accept(ModFlowers.OENOTHERA_LINDHEIMERI.get());
                        pOutput.accept(ModFlowers.PEONY.get());
                        pOutput.accept(ModFlowers.PERILLA.get());
                        pOutput.accept(ModFlowers.SAFFLOWER.get());
                        pOutput.accept(ModFlowers.SNOW_LOTUS.get());
                        pOutput.accept(ModFlowers.VIOLET.get());
                        pOutput.accept(ModFlowers.HONEYSUCKLE.get());

                        pOutput.accept(ModFlowers.GREEN_TEA_SEED.get());
                        pOutput.accept(ModFlowers.BLACK_TEA_SEED.get());
                        pOutput.accept(ModFlowers.WHITE_TEA_SEED.get());
                        pOutput.accept(ModFlowers.OOLONG_TEA_SEED.get());
                        pOutput.accept(ModFlowers.PUER_TEA_SEED.get());
                        pOutput.accept(ModFlowers.MINT_SEED.get());
                        pOutput.accept(ModFlowers.LICORICE_SEED.get());
                        pOutput.accept(ModFlowers.ASTRAGALUS_SEED.get());
                        pOutput.accept(ModFlowers.VERBENA_SEED.get());

                        pOutput.accept(ModFlowers.GREEN_TEA_LEAVE.get());
                        pOutput.accept(ModFlowers.BLACK_TEA_LEAVE.get());
                        pOutput.accept(ModFlowers.WHITE_TEA_LEAVE.get());
                        pOutput.accept(ModFlowers.OOLONG_TEA_LEAVE.get());
                        pOutput.accept(ModFlowers.PUER_TEA_LEAVE.get());
                        pOutput.accept(ModFlowers.MINT_LEAVE.get());
                        pOutput.accept(ModFlowers.LICORICE_ROOT.get());
                        pOutput.accept(ModFlowers.ASTRAGALUS_ROOT.get());
                        pOutput.accept(ModFlowers.VERBENA_ITEM.get());
                        pOutput.accept(ModFlowers.GINGER_ITEM.get());
                        pOutput.accept(ModFlowers.BURDOCK_ITEM.get());
                        pOutput.accept(ModFlowers.KUDZU_ITEM.get());
                        pOutput.accept(ModFlowers.PORIA_ITEM.get());
                        pOutput.accept(ModFlowers.FLAX_ITEM.get());

                        pOutput.accept(ModFlowers.WILD_TEA_ITEM.get());
                        pOutput.accept(ModFlowers.WILD_MINT_ITEM.get());
                        pOutput.accept(ModFlowers.WILD_LICORICE_ITEM.get());
                        pOutput.accept(ModFlowers.WILD_ASTRAGALUS_ITEM.get());
                        pOutput.accept(ModFlowers.WILD_VERBENA_ITEM.get());
                        pOutput.accept(ModFlowers.WILD_GINGER_ITEM.get());
                        pOutput.accept(ModFlowers.WILD_BURDOCK_ITEM.get());
                        pOutput.accept(ModFlowers.WILD_KUDZU_ITEM.get());
                        pOutput.accept(ModFlowers.WILD_PORIA_ITEM.get());
                        pOutput.accept(ModFlowers.WILD_FLAX_ITEM.get());


                        pOutput.accept(ModFlowers.SILENT_ORCHID_ABYSS.get());


                    }))
                    .build());
    public static final RegistryObject<CreativeModeTab> TEA = CREATIVE_MODE_TAB_DEFERRED_REGISTER
            .register("lushscentedparadise_tea",()-> CreativeModeTab.builder()
                    .icon(()->new ItemStack(ModFoods.DANDELION_TEA.get()))
                    .title(Component.translatable("creative.lushscentedparadise.lushscentedparadise_tea"))
                    .displayItems(((pParameters, pOutput) -> {
                        pOutput.accept(ModFoods.DANDELION_TEA.get());
                        pOutput.accept(ModFoods.POPPY_TEA.get());
                        pOutput.accept(ModFoods.BLUE_OC_TEA.get());
                        pOutput.accept(ModFoods.TULIP_TEA.get());
                        pOutput.accept(ModFoods.OXEYE_DAISY_TEA.get());
                        pOutput.accept(ModFoods.CORNFLOWER_TEA.get());
                        pOutput.accept(ModFoods.LILY_OF_THE_VALLEY_TEA.get());
                        pOutput.accept(ModFoods.LILAC_TEA.get());
                        pOutput.accept(ModFoods.ROSE_TEA.get());
                        pOutput.accept(ModFoods.PEONY_TEA.get());
                        pOutput.accept(ModFoods.WITHER_ROSE_TEA.get());
                        //pOutput.accept(ModFoods.TORCH_FLOWER_TEA.get());
                        pOutput.accept(ModFoods.GLOW_BERRIES_TEA.get());
                        pOutput.accept(ModFoods.SWEET_BERRIES_TEA.get());
                        pOutput.accept(ModFoods.CHORUS_TEA.get());
                        pOutput.accept(ModFoods.FERN_TEA.get());
                        pOutput.accept(ModFoods.SPORE_BLOSSOM_TEA.get());
                        pOutput.accept(ModFoods.CACTUS_TEA.get());
                        pOutput.accept(ModFoods.HOT_COCOA.get());
                        //pOutput.accept(ModFoods.KELP_SOUP.get());
                        pOutput.accept(ModFoods.GREEN_TEA.get());
                        pOutput.accept(ModFoods.BLACK_TEA.get());
                        pOutput.accept(ModFoods.WHITE_TEA.get());
                        pOutput.accept(ModFoods.OOLONG_TEA.get());
                        pOutput.accept(ModFoods.PUER_TEA.get());
                        pOutput.accept(ModFoods.MINT_TEA.get());
                        pOutput.accept(ModFoods.GINGER_SOUP.get());
                        //pOutput.accept(ModFoods.LEAVES_TEA.get());
                        pOutput.accept(ModFoods.HONEYSUCKLE_TEA.get());
                        pOutput.accept(ModFoods.VIOLET_TEA.get());
                        pOutput.accept(ModFoods.HIBISCUS_TEA.get());
                        pOutput.accept(ModFoods.HERBACEOUS_PEONY_TEA.get());
                        pOutput.accept(ModFoods.JASMINE_TEA.get());
                        pOutput.accept(ModFoods.LAVENDER_TEA.get());
                        pOutput.accept(ModFoods.LILY_TEA.get());
                        pOutput.accept(ModFoods.SAFFLOWER_TEA.get());
                        pOutput.accept(ModFoods.SNOW_LOTUS_TEA.get());
                        pOutput.accept(ModFoods.MARIGOLD_TEA.get());
                        pOutput.accept(ModFoods.OENOTHERA_TEA.get());
                        pOutput.accept(ModFoods.PERILLA_TEA.get());
                        pOutput.accept(ModFoods.VERBENA_TEA.get());
                        pOutput.accept(ModFoods.LICORICE_SOUP.get());
                        pOutput.accept(ModFoods.ASTRAGALUS_SOUP.get());
                        pOutput.accept(ModFoods.BURDOCK_SOUP.get());
                        pOutput.accept(ModFoods.KUDZU_SOUP.get());
                        pOutput.accept(ModFoods.PORIA_TEA.get());
                        pOutput.accept(ModFoods.FLAX_TEA.get());

                        pOutput.accept(ModFoods.SPARKLING_MATCHA.get());
                        pOutput.accept(ModFoods.MINT_HONEY_SPECIAL_DRINK.get());
                        pOutput.accept(ModFoods.GINGER_HONEY_BLACK_TEA.get());
                        pOutput.accept(ModFoods.OOLONG_APPLE_HONEY_SPECIAL_DRINK.get());
                        pOutput.accept(ModFoods.NETHER_FLAVOR.get());
                        pOutput.accept(ModFoods.ENDER_FLAVOR.get());
                        pOutput.accept(ModFoods.HORROR_SOUP.get());
                        pOutput.accept(ModFoods.EXPLOSIVE_GINGER_SOUP.get());
                        pOutput.accept(ModFoods.CHOCOLATE_LILY_TEA.get());
                        pOutput.accept(ModFoods.WATERMELON_MINT_SPECIAL_DRINK.get());
                        pOutput.accept(ModFoods.ROSE_APPLE_TEA.get());
                        pOutput.accept(ModFoods.FIRE_HIBISCUS_TEA.get());
                        pOutput.accept(ModFoods.LEGENDARY_CHINESE_MEDICINE.get());
                        pOutput.accept(ModFoods.BAK_KUT_TEH.get());
                        pOutput.accept(ModFoods.BRILLIANT_AMETHYST_DRINK.get());
                        pOutput.accept(ModFoods.GOLDEN_SOUP.get());
                        pOutput.accept(ModFoods.SUPREME_GOLDEN_TEA.get());
                        pOutput.accept(ModFoods.ENCHANTED_SUPREME_GOLDEN_TEA.get());
                        pOutput.accept(ModFoods.OCEAN_JOURNEY.get());
                        pOutput.accept(ModFoods.EXTREMELY_COLD_CONDENSED_MILK_SCENTED_TEA.get());
                        pOutput.accept(ModFoods.AXOLOTL_TEA.get());
                        pOutput.accept(ModFoods.FLOWER_PARTY.get());
                        pOutput.accept(ModFoods.SCARLET_MARGARITA.get());
                        pOutput.accept(ModFoods.STRONG_MOUTH_MUSHROOM_TEA.get());
                        pOutput.accept(ModFoods.LAVA_SPECIAL_DRINK.get());
                        pOutput.accept(ModFoods.CORAL_MINT_SPARKLING_WATER.get());
                        pOutput.accept(ModFoods.MIXED_BERRY_SMOOTHIE.get());
                        pOutput.accept(ModFoods.MILK_MUSHROOM_SOUP.get());
                        pOutput.accept(ModFoods.THE_TIDE_IS_COMING.get());
                        pOutput.accept(ModFoods.OENOTHERA_LINDHEIMERI_PHANTOM.get());
                        pOutput.accept(ModFoods.TURTLE_SHELL_LILY_TEA.get());
                        pOutput.accept(ModFoods.THE_EVOKERS_WRATH.get());
                        pOutput.accept(ModFoods.THE_DEVILS_CALL.get());

                    }))
                    .build());
    public static final RegistryObject<CreativeModeTab> OTHER = CREATIVE_MODE_TAB_DEFERRED_REGISTER
            .register("lushscentedparadise_other",()-> CreativeModeTab.builder()
                    .icon(()->new ItemStack(ModItems.CLEAN_WATER.get()))
                    .title(Component.translatable("creative.lushscentedparadise.lushscentedparadise_other"))
                    .displayItems(((pParameters, pOutput) -> {
                        pOutput.accept(new ItemStack(ModBlocks.TEAPOT.get()));
                        pOutput.accept(new ItemStack(ModBlocks.FLOWER_TABLE.get()));
                        pOutput.accept(new ItemStack(ModBlocks.DRYING_RACK.get()));
                        pOutput.accept(new ItemStack(ModItems.CLEAN_WATER.get()));
                        pOutput.accept(new ItemStack(ModItems.DIRTY_WATER.get()));
                        pOutput.accept(new ItemStack(ModItems.MILK.get()));
                        pOutput.accept(new ItemStack(ModItems.ORIGINAL_FLOWER_SWORD.get()));
                        pOutput.accept(new ItemStack(ModItems.FLOWER_SWORD.get()));
                        pOutput.accept(new ItemStack(ModItems.FLOWER_BAG.get()));
                        pOutput.accept(new ItemStack(ModItems.SEED_BAG.get()));


                        pOutput.accept(new ItemStack(ModItems.DRIED_VIOLET.get()));
                        pOutput.accept(new ItemStack(ModItems.DRIED_HIBISCUS.get()));
                        pOutput.accept(new ItemStack(ModItems.DRIED_HERBACEOUS_PEONY.get()));
                        pOutput.accept(new ItemStack(ModItems.DRIED_JASMINE.get()));
                        pOutput.accept(new ItemStack(ModItems.DRIED_LAVENDER.get()));
                        pOutput.accept(new ItemStack(ModItems.DRIED_LILY.get()));
                        pOutput.accept(new ItemStack(ModItems.DRIED_SAFFLOWER.get()));
                        pOutput.accept(new ItemStack(ModItems.DRIED_SNOW_LOTUS.get()));
                        pOutput.accept(new ItemStack(ModItems.DRIED_MARIGOLD.get()));
                        pOutput.accept(new ItemStack(ModItems.DRIED_OENOTHERA_LINDHEIMERI.get()));
                        pOutput.accept(new ItemStack(ModItems.DRIED_PERILLA.get()));
                        pOutput.accept(new ItemStack(ModItems.DRIED_HONEYSUCKLE.get()));

                        pOutput.accept(new ItemStack(ModItems.DRIED_GREEN_TEA_LEAVE.get()));
                        pOutput.accept(new ItemStack(ModItems.DRIED_BLACK_TEA_LEAVE.get()));
                        pOutput.accept(new ItemStack(ModItems.DRIED_WHITE_TEA_LEAVE.get()));
                        pOutput.accept(new ItemStack(ModItems.DRIED_OOLONG_TEA_LEAVE.get()));
                        pOutput.accept(new ItemStack(ModItems.DRIED_PUER_TEA_LEAVE.get()));
                        pOutput.accept(new ItemStack(ModItems.DRIED_MINT_LEAVE.get()));
                        pOutput.accept(new ItemStack(ModItems.DRIED_LICORICE_ROOT.get()));
                        pOutput.accept(new ItemStack(ModItems.DRIED_ASTRAGALUS_ROOT.get()));
                        pOutput.accept(new ItemStack(ModItems.DRIED_VERBENA_ITEM.get()));
                        pOutput.accept(new ItemStack(ModItems.DRIED_GINGER_ITEM.get()));
                        pOutput.accept(new ItemStack(ModItems.DRIED_BURDOCK_ITEM.get()));
                        pOutput.accept(new ItemStack(ModItems.DRIED_KUDZU_ITEM.get()));
                        pOutput.accept(new ItemStack(ModItems.DRIED_PORIA_ITEM.get()));
                        pOutput.accept(new ItemStack(ModItems.DRIED_FLAX_ITEM.get()));
                        pOutput.accept(new ItemStack(ModItems.DRIED_DANDELION.get()));
                        pOutput.accept(new ItemStack(ModItems.DRIED_POPPY.get()));
                        pOutput.accept(new ItemStack(ModItems.DRIED_ORCHID.get()));
                        pOutput.accept(new ItemStack(ModItems.DRIED_TULIP.get()));
                        pOutput.accept(new ItemStack(ModItems.DRIED_OXEYE_DAISY.get()));
                        pOutput.accept(new ItemStack(ModItems.DRIED_CORNFLOWER.get()));
                        pOutput.accept(new ItemStack(ModItems.DRIED_LILY_OF_THE_VALLEY.get()));
                        pOutput.accept(new ItemStack(ModItems.DRIED_LILAC.get()));
                        pOutput.accept(new ItemStack(ModItems.DRIED_ROSE.get()));
                        pOutput.accept(new ItemStack(ModItems.DRIED_PEONY.get()));
                    }))
                    .build());

    public static void register(IEventBus eventBus){
        CREATIVE_MODE_TAB_DEFERRED_REGISTER.register(eventBus);
    }
}
