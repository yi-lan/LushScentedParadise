package net.royling.LushScentedParadise.dataGen;

import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.SimpleCookingRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import net.minecraftforge.fml.common.Mod;
import net.royling.LushScentedParadise.Item.Flowertea.ModFoods;
import net.royling.LushScentedParadise.Item.newFlower.ModFlowers;
import net.royling.LushScentedParadise.LushScentedParadise;
import net.royling.LushScentedParadise.Registry.ModItems;
import net.royling.LushScentedParadise.Registry.ModRecipeSerializers;
import net.royling.LushScentedParadise.dataGen.modRecipeBuilder.DryingRecipeBuilder;
import net.royling.LushScentedParadise.dataGen.modRecipeBuilder.TeapotRecipeBuilder;
import net.royling.LushScentedParadise.util.ModTags;

import java.util.List;
import java.util.function.Consumer;

@SuppressWarnings("removal")
public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {

    public ModRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> pWriter) {
        addDryingRecipe(pWriter,"dried_dandelion", Items.DANDELION, ModItems.DRIED_DANDELION.get(), 200);
        addDryingRecipe(pWriter,"dried_poppy", Items.POPPY, ModItems.DRIED_POPPY.get(), 200);
        addDryingRecipe(pWriter,"dried_orchid", Items.BLUE_ORCHID, ModItems.DRIED_ORCHID.get(), 200);
        addDryingRecipe(pWriter,"dried_tulipr", Items.RED_TULIP, ModItems.DRIED_TULIP.get(), 200);
        addDryingRecipe(pWriter,"dried_tulipo", Items.ORANGE_TULIP, ModItems.DRIED_TULIP.get(), 200);
        addDryingRecipe(pWriter,"dried_tulipp", Items.PINK_TULIP, ModItems.DRIED_TULIP.get(), 200);
        addDryingRecipe(pWriter,"dried_tulipw", Items.WHITE_TULIP, ModItems.DRIED_TULIP.get(), 200);
        addDryingRecipe(pWriter,"dried_oxeye_daisy", Items.OXEYE_DAISY, ModItems.DRIED_OXEYE_DAISY.get(), 200);
        addDryingRecipe(pWriter,"dried_cornflower", Items.CORNFLOWER, ModItems.DRIED_CORNFLOWER.get(), 200);
        addDryingRecipe(pWriter,"dried_lily_of_the_valley", Items.LILY_OF_THE_VALLEY, ModItems.DRIED_LILY_OF_THE_VALLEY.get(), 200);
        addDryingRecipe(pWriter,"dried_lilac", Items.LILAC, ModItems.DRIED_LILAC.get(), 200);
        addDryingRecipe(pWriter,"dried_rose", Items.ROSE_BUSH, ModItems.DRIED_ROSE.get(), 200);
        addDryingRecipe(pWriter,"dried_peony", Items.PEONY, ModItems.DRIED_PEONY.get(), 200);

        addDryingRecipe(pWriter,"dried_violet", ModFlowers.VIOLET_ITEM.get(), ModItems.DRIED_VIOLET.get(), 200);
        addDryingRecipe(pWriter,"dried_hibiscus", ModFlowers.HIBISCUS_ITEM.get(), ModItems.DRIED_HIBISCUS.get(), 200);
        addDryingRecipe(pWriter,"dried_herbaceous_peony", ModFlowers.PEONY_ITEM.get(), ModItems.DRIED_HERBACEOUS_PEONY.get(), 200);
        addDryingRecipe(pWriter,"dried_jasmine", ModFlowers.JASMINE_ITEM.get(), ModItems.DRIED_JASMINE.get(), 200);
        addDryingRecipe(pWriter,"dried_lavender", ModFlowers.LAVENDER_ITEM.get(), ModItems.DRIED_LAVENDER.get(), 200);
        addDryingRecipe(pWriter,"dried_lily", ModFlowers.LILY_ITEM.get(), ModItems.DRIED_LILY.get(), 200);
        addDryingRecipe(pWriter,"dried_safflower", ModFlowers.SAFFLOWER_ITEM.get(), ModItems.DRIED_SAFFLOWER.get(), 200);
        addDryingRecipe(pWriter,"dried_snow_lotus", ModFlowers.SNOW_LOTUS_ITEM.get(), ModItems.DRIED_SNOW_LOTUS.get(), 200);
        addDryingRecipe(pWriter,"dried_marigold", ModFlowers.MARIGOLD_ITEM.get(), ModItems.DRIED_MARIGOLD.get(), 200);
        addDryingRecipe(pWriter,"dried_oenothera_lindheimeri", ModFlowers.OENOTHERA_LINDHEIMERI_ITEM.get(), ModItems.DRIED_OENOTHERA_LINDHEIMERI.get(), 200);
        addDryingRecipe(pWriter,"dried_perilla", ModFlowers.PERILLA_ITEM.get(), ModItems.DRIED_PERILLA.get(), 200);
        addDryingRecipe(pWriter,"dried_honeysuckle", ModFlowers.HONEYSUCKLE_ITEM.get(), ModItems.DRIED_HONEYSUCKLE.get(), 200);

        addDryingRecipe(pWriter,"dried_green_tea_leave", ModFlowers.GREEN_TEA_LEAVE.get(), ModItems.DRIED_GREEN_TEA_LEAVE.get(), 200);
        addDryingRecipe(pWriter,"dried_black_tea_leave", ModFlowers.BLACK_TEA_LEAVE.get(), ModItems.DRIED_BLACK_TEA_LEAVE.get(), 200);
        addDryingRecipe(pWriter,"dried_ginger", ModFlowers.GINGER_ITEM.get(), ModItems.DRIED_GINGER_ITEM.get(), 200);
        addDryingRecipe(pWriter,"dried_white_tea_leave", ModFlowers.WHITE_TEA_LEAVE.get(), ModItems.DRIED_WHITE_TEA_LEAVE.get(), 200);
        addDryingRecipe(pWriter,"dried_oolong_tea_leave", ModFlowers.OOLONG_TEA_LEAVE.get(), ModItems.DRIED_OOLONG_TEA_LEAVE.get(), 200);
        addDryingRecipe(pWriter,"dried_puer_tea_leave", ModFlowers.PUER_TEA_LEAVE.get(), ModItems.DRIED_PUER_TEA_LEAVE.get(), 200);
        addDryingRecipe(pWriter,"dried_mint_leave", ModFlowers.MINT_LEAVE.get(), ModItems.DRIED_MINT_LEAVE.get(), 200);
        addDryingRecipe(pWriter,"dried_licorice_root", ModFlowers.LICORICE_ROOT.get(), ModItems.DRIED_LICORICE_ROOT.get(), 200);
        addDryingRecipe(pWriter,"dried_astragalus_root", ModFlowers.ASTRAGALUS_ROOT.get(), ModItems.DRIED_ASTRAGALUS_ROOT.get(), 200);
        addDryingRecipe(pWriter,"dried_verbena", ModFlowers.VERBENA_ITEM.get(), ModItems.DRIED_VERBENA_ITEM.get(), 200);
        addDryingRecipe(pWriter,"dried_burdock", ModFlowers.BURDOCK_ITEM.get(), ModItems.DRIED_BURDOCK_ITEM.get(), 200);
        addDryingRecipe(pWriter,"dried_kudzu", ModFlowers.KUDZU_ITEM.get(), ModItems.DRIED_KUDZU_ITEM.get(), 200);
        addDryingRecipe(pWriter,"dried_poria", ModFlowers.PORIA_ITEM.get(), ModItems.DRIED_PORIA_ITEM.get(), 200);
        addDryingRecipe(pWriter,"dried_flax", ModFlowers.FLAX_ITEM.get(), ModItems.DRIED_FLAX_ITEM.get(), 200);

        addTeapotRecipe(pWriter,"dandelion_tea",List.of(
                Ingredient.of(ModItems.DRIED_DANDELION.get()),
                Ingredient.of(Items.SUGAR)
        ),new ItemStack(ModFoods.DANDELION_TEA.get()),100);
        addTeapotRecipe(pWriter,"poppy_tea",List.of(
                Ingredient.of(ModItems.DRIED_POPPY.get()),
                Ingredient.of(Items.SUGAR)
        ),new ItemStack(ModFoods.POPPY_TEA.get()),100);
        addTeapotRecipe(pWriter,"blue_oc_tea",List.of(
                Ingredient.of(ModItems.DRIED_ORCHID.get()),
                Ingredient.of(Items.SUGAR)
        ),new ItemStack(ModFoods.BLUE_OC_TEA.get()),100);
        addTeapotRecipe(pWriter,"tulip_tea",List.of(
                Ingredient.of(ModItems.DRIED_TULIP.get()),
                Ingredient.of(Items.SUGAR)
        ),new ItemStack(ModFoods.TULIP_TEA.get()),100);
        addTeapotRecipe(pWriter,"oxeye_daisy_tea",List.of(
                Ingredient.of(ModItems.DRIED_OXEYE_DAISY.get()),
                Ingredient.of(Items.SUGAR)
        ),new ItemStack(ModFoods.OXEYE_DAISY_TEA.get()),100);
        addTeapotRecipe(pWriter,"cornflower_tea",List.of(
                Ingredient.of(ModItems.DRIED_CORNFLOWER.get()),
                Ingredient.of(Items.SUGAR)
        ),new ItemStack(ModFoods.CORNFLOWER_TEA.get()),100);
        addTeapotRecipe(pWriter,"lily_of_the_valley_tea",List.of(
                Ingredient.of(ModItems.DRIED_LILY_OF_THE_VALLEY.get()),
                Ingredient.of(Items.SUGAR)
        ),new ItemStack(ModFoods.LILY_OF_THE_VALLEY_TEA.get()),100);
        addTeapotRecipe(pWriter,"lilac_tea",List.of(
                Ingredient.of(ModItems.DRIED_LILAC.get()),
                Ingredient.of(Items.SUGAR)
        ),new ItemStack(ModFoods.LILAC_TEA.get()),100);
        addTeapotRecipe(pWriter,"rose_tea",List.of(
                Ingredient.of(ModItems.DRIED_ROSE.get()),
                Ingredient.of(Items.SUGAR)
        ),new ItemStack(ModFoods.ROSE_TEA.get()),100);
        addTeapotRecipe(pWriter,"peony_tea",List.of(
                Ingredient.of(ModItems.DRIED_PEONY.get()),
                Ingredient.of(Items.SUGAR)
        ),new ItemStack(ModFoods.PEONY_TEA.get()),100);

        addTeapotRecipe(pWriter,"wither_rose_tea",List.of(
                Ingredient.of(Items.WITHER_ROSE),
                Ingredient.of(Items.HONEY_BOTTLE)
        ),new ItemStack(ModFoods.WITHER_ROSE_TEA.get()),400);
        addTeapotRecipe(pWriter,"glow_berries_tea",List.of(
                Ingredient.of(Items.GLOW_BERRIES),
                Ingredient.of(Items.GLOW_BERRIES),
                Ingredient.of(ModItems.MILK.get())
        ),new ItemStack(ModFoods.GLOW_BERRIES_TEA.get()),200);
        addTeapotRecipe(pWriter,"sweet_rose_tea",List.of(
                Ingredient.of(Items.SWEET_BERRIES),
                Ingredient.of(Items.SWEET_BERRIES),
                Ingredient.of(Items.SWEET_BERRIES),
                Ingredient.of(Items.SUGAR)
        ),new ItemStack(ModFoods.SWEET_BERRIES_TEA.get()),200);
        addTeapotRecipe(pWriter,"chorus_tea",List.of(
                Ingredient.of(Items.CHORUS_FRUIT),
                Ingredient.of(ModItems.MILK.get())
        ),new ItemStack(ModFoods.CHORUS_TEA.get()),100);
        addTeapotRecipe(pWriter,"fern_tea",List.of(
                Ingredient.of(Items.FERN),
                Ingredient.of(Items.SUGAR),
                Ingredient.of(Items.HONEY_BOTTLE)
        ),new ItemStack(ModFoods.FERN_TEA.get()),50);
        addTeapotRecipe(pWriter,"spore_blossom_tea",List.of(
                Ingredient.of(Items.SPORE_BLOSSOM),
                Ingredient.of(Items.SUGAR)
        ),new ItemStack(ModFoods.SPORE_BLOSSOM_TEA.get()),100);
        addTeapotRecipe(pWriter,"cactus_tea",List.of(
                Ingredient.of(Items.CACTUS),
                Ingredient.of(Items.HONEY_BOTTLE),
                Ingredient.of(Items.SUGAR)
        ),new ItemStack(ModFoods.CACTUS_TEA.get()),200);
        addTeapotRecipe(pWriter,"hot_cocoa",List.of(
                Ingredient.of(Items.COCOA_BEANS),
                Ingredient.of(Items.COCOA_BEANS),
                Ingredient.of(Items.SUGAR),
                Ingredient.of(Items.HONEY_BOTTLE)
        ),new ItemStack(ModFoods.HOT_COCOA.get()),400);



        addTeapotRecipe(pWriter,"green_tea",List.of(
                Ingredient.of(ModItems.DRIED_GREEN_TEA_LEAVE.get()),
                Ingredient.of(ModItems.DRIED_GREEN_TEA_LEAVE.get())
        ),new ItemStack(ModFoods.GREEN_TEA.get()),200);
        addTeapotRecipe(pWriter,"black_tea",List.of(
                Ingredient.of(ModItems.DRIED_BLACK_TEA_LEAVE.get()),
                Ingredient.of(ModItems.DRIED_BLACK_TEA_LEAVE.get())
        ),new ItemStack(ModFoods.BLACK_TEA.get()),200);
        addTeapotRecipe(pWriter,"white_tea",List.of(
                Ingredient.of(ModItems.DRIED_WHITE_TEA_LEAVE.get()),
                Ingredient.of(ModItems.DRIED_WHITE_TEA_LEAVE.get())
        ),new ItemStack(ModFoods.WHITE_TEA.get()),200);
        addTeapotRecipe(pWriter,"oolong_tea",List.of(
                Ingredient.of(ModItems.DRIED_OOLONG_TEA_LEAVE.get()),
                Ingredient.of(ModItems.DRIED_OOLONG_TEA_LEAVE.get())
        ),new ItemStack(ModFoods.OOLONG_TEA.get()),200);
        addTeapotRecipe(pWriter,"puer_tea",List.of(
                Ingredient.of(ModItems.DRIED_PUER_TEA_LEAVE.get()),
                Ingredient.of(ModItems.DRIED_PUER_TEA_LEAVE.get())
        ),new ItemStack(ModFoods.PUER_TEA.get()),200);
        addTeapotRecipe(pWriter,"mint_tea",List.of(
                Ingredient.of(ModItems.DRIED_MINT_LEAVE.get()),
                Ingredient.of(ModItems.DRIED_MINT_LEAVE.get())
        ),new ItemStack(ModFoods.MINT_TEA.get()),150);

        addTeapotRecipe(pWriter,"ginger_tea",List.of(
                Ingredient.of(ModItems.DRIED_GINGER_ITEM.get()),
                Ingredient.of(ModItems.DRIED_GINGER_ITEM.get()),
                Ingredient.of(Items.SUGAR)
        ),new ItemStack(ModFoods.GINGER_SOUP.get()),400);
        addTeapotRecipe(pWriter,"honeysuckle_tea",List.of(
                Ingredient.of(ModItems.DRIED_HONEYSUCKLE.get()),
                Ingredient.of(Items.SUGAR)
        ),new ItemStack(ModFoods.HONEYSUCKLE_TEA.get()),100);
        addTeapotRecipe(pWriter,"violet_tea",List.of(
                Ingredient.of(ModItems.DRIED_VIOLET.get()),
                Ingredient.of(Items.SUGAR)
        ),new ItemStack(ModFoods.VIOLET_TEA.get()),100);
        addTeapotRecipe(pWriter,"hibiscus_tea",List.of(
                Ingredient.of(ModItems.DRIED_HIBISCUS.get()),
                Ingredient.of(Items.SUGAR)
        ),new ItemStack(ModFoods.HIBISCUS_TEA.get()),100);
        addTeapotRecipe(pWriter,"herbaceous_peony_tea",List.of(
                Ingredient.of(ModItems.DRIED_HERBACEOUS_PEONY.get()),
                Ingredient.of(Items.SUGAR)
        ),new ItemStack(ModFoods.HERBACEOUS_PEONY_TEA.get()),100);
        addTeapotRecipe(pWriter,"jasmine_tea",List.of(
                Ingredient.of(ModItems.DRIED_JASMINE.get()),
                Ingredient.of(Items.SUGAR)
        ),new ItemStack(ModFoods.JASMINE_TEA.get()),100);
        addTeapotRecipe(pWriter,"lavender_tea",List.of(
                Ingredient.of(ModItems.DRIED_LAVENDER.get()),
                Ingredient.of(Items.SUGAR)
        ),new ItemStack(ModFoods.LAVENDER_TEA.get()),100);
        addTeapotRecipe(pWriter,"lily_tea",List.of(
                Ingredient.of(ModItems.DRIED_LILY.get()),
                Ingredient.of(Items.SUGAR)
        ),new ItemStack(ModFoods.LILY_TEA.get()),100);
        addTeapotRecipe(pWriter,"safflower_tea",List.of(
                Ingredient.of(ModItems.DRIED_SAFFLOWER.get()),
                Ingredient.of(Items.SUGAR)
        ),new ItemStack(ModFoods.SAFFLOWER_TEA.get()),100);
        addTeapotRecipe(pWriter,"snow_lotus_tea",List.of(
                Ingredient.of(ModItems.DRIED_SNOW_LOTUS.get()),
                Ingredient.of(Items.SUGAR)
        ),new ItemStack(ModFoods.SNOW_LOTUS_TEA.get()),100);
        addTeapotRecipe(pWriter,"marigold_tea",List.of(
                Ingredient.of(ModItems.DRIED_MARIGOLD.get()),
                Ingredient.of(Items.SUGAR)
        ),new ItemStack(ModFoods.MARIGOLD_TEA.get()),100);
        addTeapotRecipe(pWriter,"oenothera_lindheimeri_tea",List.of(
                Ingredient.of(ModItems.DRIED_OENOTHERA_LINDHEIMERI.get()),
                Ingredient.of(Items.SUGAR)
        ),new ItemStack(ModFoods.OENOTHERA_TEA.get()),100);
        addTeapotRecipe(pWriter,"perilla_tea",List.of(
                Ingredient.of(ModItems.DRIED_PERILLA.get()),
                Ingredient.of(Items.SUGAR)
        ),new ItemStack(ModFoods.PERILLA_TEA.get()),100);
        addTeapotRecipe(pWriter,"licorice_root_tea",List.of(
                Ingredient.of(ModItems.DRIED_LICORICE_ROOT.get()),
                Ingredient.of(ModItems.DRIED_LICORICE_ROOT.get()),
                Ingredient.of(Items.SUGAR)
        ),new ItemStack(ModFoods.LICORICE_SOUP.get()),400);
        addTeapotRecipe(pWriter,"astragalus_root_tea",List.of(
                Ingredient.of(ModItems.DRIED_ASTRAGALUS_ROOT.get()),
                Ingredient.of(ModItems.DRIED_ASTRAGALUS_ROOT.get()),
                Ingredient.of(Items.SUGAR)
        ),new ItemStack(ModFoods.ASTRAGALUS_SOUP.get()),400);
        addTeapotRecipe(pWriter,"verbena_tea",List.of(
                Ingredient.of(ModItems.DRIED_VERBENA_ITEM.get()),
                Ingredient.of(ModItems.DRIED_VERBENA_ITEM.get()),
                Ingredient.of(Items.SUGAR)
        ),new ItemStack(ModFoods.VERBENA_TEA.get()),400);
        addTeapotRecipe(pWriter,"burdock_tea",List.of(
                Ingredient.of(ModItems.DRIED_BURDOCK_ITEM.get()),
                Ingredient.of(ModItems.DRIED_BURDOCK_ITEM.get()),
                Ingredient.of(Items.SUGAR)
        ),new ItemStack(ModFoods.BURDOCK_SOUP.get()),400);

        addTeapotRecipe(pWriter,"kudzu_tea",List.of(
                Ingredient.of(ModItems.DRIED_KUDZU_ITEM.get()),
                Ingredient.of(ModItems.DRIED_KUDZU_ITEM.get()),
                Ingredient.of(Items.SUGAR)
        ),new ItemStack(ModFoods.KUDZU_SOUP.get()),400);

        addTeapotRecipe(pWriter,"poria_tea",List.of(
                Ingredient.of(ModItems.DRIED_PORIA_ITEM.get()),
                Ingredient.of(ModItems.DRIED_PORIA_ITEM.get()),
                Ingredient.of(Items.SUGAR)
        ),new ItemStack(ModFoods.PORIA_TEA.get()),400);

        addTeapotRecipe(pWriter,"flax_tea",List.of(
                Ingredient.of(ModItems.DRIED_FLAX_ITEM.get()),
                Ingredient.of(ModItems.DRIED_FLAX_ITEM.get()),
                Ingredient.of(Items.SUGAR)
        ),new ItemStack(ModFoods.FLAX_TEA.get()),400);





        addTeapotRecipe(pWriter,"saprkling_matcha", List.of(
                        Ingredient.of(Items.GLOW_BERRIES),
                        Ingredient.of(Items.GLISTERING_MELON_SLICE),
                        Ingredient.of(Items.GLOW_INK_SAC),
                        Ingredient.of(ModTags.Items.TEA_LEAVES)
                ), new ItemStack(ModFoods.SPARKLING_MATCHA.get()),450);

        addTeapotRecipe(pWriter,"mint_honey_special_drink", List.of(
                Ingredient.of(Items.HONEY_BOTTLE),
                Ingredient.of(ModItems.DRIED_MINT_LEAVE.get()),
                Ingredient.of(ModItems.DRIED_OXEYE_DAISY.get()),
                Ingredient.of(Items.SUGAR)
        ), new ItemStack(ModFoods.MINT_HONEY_SPECIAL_DRINK.get()),200);

        addTeapotRecipe(pWriter,"ginger_honey_black_tea", List.of(
                Ingredient.of(Items.HONEY_BOTTLE),
                Ingredient.of(ModItems.DRIED_BLACK_TEA_LEAVE.get()),
                Ingredient.of(ModItems.DRIED_CORNFLOWER.get()),
                Ingredient.of(ModItems.DRIED_GINGER_ITEM.get())
        ), new ItemStack(ModFoods.GINGER_HONEY_BLACK_TEA.get()),400);

        addTeapotRecipe(pWriter,"oolong_apple_honey_special_drink", List.of(
                Ingredient.of(ModItems.DRIED_OOLONG_TEA_LEAVE.get()),
                Ingredient.of(Items.HONEY_BOTTLE),
                Ingredient.of(ModItems.DRIED_OENOTHERA_LINDHEIMERI.get()),
                Ingredient.of(Items.APPLE)
        ), new ItemStack(ModFoods.OOLONG_APPLE_HONEY_SPECIAL_DRINK.get()),400);

        addTeapotRecipe(pWriter,"nether_flavor", List.of(
                Ingredient.of(Items.NETHER_WART),
                Ingredient.of(Items.GOLD_NUGGET),
                Ingredient.of(Items.CRIMSON_FUNGUS),
                Ingredient.of(Items.WARPED_FUNGUS)
        ), new ItemStack(ModFoods.NETHER_FLAVOR.get()),400);

        addTeapotRecipe(pWriter,"ender_flavor", List.of(
                Ingredient.of(Items.HONEY_BOTTLE),
                Ingredient.of(Items.CHORUS_FRUIT),
                Ingredient.of(ModItems.MILK.get()),
                Ingredient.of(ModItems.DRIED_PERILLA.get())
        ), new ItemStack(ModFoods.ENDER_FLAVOR.get()),400);

        addTeapotRecipe(pWriter,"horror_soup", List.of(
                Ingredient.of(ModFoods.WITHER_ROSE_TEA.get()),
                Ingredient.of(Items.BONE),
                Ingredient.of(Items.ROTTEN_FLESH),
                Ingredient.of(Items.SPIDER_EYE)
        ), new ItemStack(ModFoods.HORROR_SOUP.get()),2000);

        addTeapotRecipe(pWriter,"explosive_ginger_soup", List.of(
                Ingredient.of(ModItems.DRIED_GINGER_ITEM.get()),
                Ingredient.of(Items.FLINT),
                Ingredient.of(Items.GUNPOWDER),
                Ingredient.of(ItemTags.COALS)
        ), new ItemStack(ModFoods.EXPLOSIVE_GINGER_SOUP.get()),600);

        addTeapotRecipe(pWriter,"chocolate_lily_tea", List.of(
                Ingredient.of(ModItems.DRIED_LILY.get()),
                Ingredient.of(Items.HONEY_BOTTLE),
                Ingredient.of(Items.COCOA_BEANS),
                Ingredient.of(ModItems.MILK.get())
        ), new ItemStack(ModFoods.CHOCOLATE_LILY_TEA.get()),1000);

        addTeapotRecipe(pWriter,"watermelon_mint_special_drink", List.of(
                Ingredient.of(Items.MELON_SLICE),
                Ingredient.of(ModItems.DRIED_MINT_LEAVE.get()),
                Ingredient.of(Items.ICE),
                Ingredient.of(Items.SUGAR)
        ), new ItemStack(ModFoods.WATERMELON_MINT_SPECIAL_DRINK.get()),100);

        addTeapotRecipe(pWriter,"rose_apple_tea", List.of(
                Ingredient.of(ModItems.DRIED_ROSE.get()),
                Ingredient.of(ModTags.Items.TEA_LEAVES),
                Ingredient.of(Items.APPLE),
                Ingredient.of(Items.SUGAR)
        ), new ItemStack(ModFoods.ROSE_APPLE_TEA.get()),100);


        addTeapotRecipe(pWriter,"fire_hibiscus_tea", List.of(
                Ingredient.of(Items.BLAZE_POWDER),
                Ingredient.of(ModItems.DRIED_HIBISCUS.get()),
                Ingredient.of(Items.SUGAR),
                Ingredient.of(Items.TORCHFLOWER)
        ), new ItemStack(ModFoods.FIRE_HIBISCUS_TEA.get()),200);

        addTeapotRecipe(pWriter,"legendary_chinese_medicine", List.of(
                Ingredient.of(ModItems.DRIED_LICORICE_ROOT.get()),
                Ingredient.of(ModItems.DRIED_ASTRAGALUS_ROOT.get()),
                Ingredient.of(ModItems.DRIED_KUDZU_ITEM.get()),
                Ingredient.of(ModItems.DRIED_PORIA_ITEM.get())
        ), new ItemStack(ModFoods.LEGENDARY_CHINESE_MEDICINE.get()),600);

        addTeapotRecipe(pWriter,"bak_kut_geh", List.of(
                Ingredient.of(ModFoods.LEGENDARY_CHINESE_MEDICINE.get()),
                Ingredient.of(Items.BONE),
                Ingredient.of(Items.PORKCHOP),
                Ingredient.of(Items.CARROT)
        ), new ItemStack(ModFoods.BAK_KUT_TEH.get()),600);

        addTeapotRecipe(pWriter,"brilliant_amethyst_drink", List.of(
                Ingredient.of(Items.AMETHYST_SHARD),
                Ingredient.of(ModItems.MILK.get()),
                Ingredient.of(ModItems.DRIED_VIOLET.get()),
                Ingredient.of(Items.HONEY_BOTTLE)
        ), new ItemStack(ModFoods.BRILLIANT_AMETHYST_DRINK.get()),200);

        addTeapotRecipe(pWriter,"golden_soup", List.of(
                Ingredient.of(Items.GOLDEN_CARROT),
                Ingredient.of(Items.GLISTERING_MELON_SLICE),
                Ingredient.of(ModItems.DRIED_MARIGOLD.get()),
                Ingredient.of(Items.GOLD_INGOT)
        ), new ItemStack(ModFoods.GOLDEN_SOUP.get()),200);

        addTeapotRecipe(pWriter,"supreme_golden_tea", List.of(
                Ingredient.of(Items.GOLDEN_APPLE),
                Ingredient.of(Items.HONEY_BOTTLE),
                Ingredient.of(ModItems.DRIED_SNOW_LOTUS.get()),
                Ingredient.of(Items.GOLD_INGOT)
        ), new ItemStack(ModFoods.SUPREME_GOLDEN_TEA.get()),1000);

        addTeapotRecipe(pWriter,"enchanted_supreme_golden_tea", List.of(
                Ingredient.of(Items.ENCHANTED_GOLDEN_APPLE),
                Ingredient.of(Items.HONEY_BOTTLE),
                Ingredient.of(ModItems.DRIED_SNOW_LOTUS.get()),
                Ingredient.of(Items.GOLD_BLOCK)
        ), new ItemStack(ModFoods.ENCHANTED_SUPREME_GOLDEN_TEA.get()),2000);

        addTeapotRecipe(pWriter,"ocean_journey", List.of(
                Ingredient.of(Items.KELP),
                Ingredient.of(Items.ICE),
                Ingredient.of(Items.NAUTILUS_SHELL),
                Ingredient.of(Items.HONEY_BOTTLE)
        ), new ItemStack(ModFoods.OCEAN_JOURNEY.get()),100);

        addTeapotRecipe(pWriter,"extremely_cold_condensed_milk_scented_tea", List.of(
                Ingredient.of(ModItems.DRIED_SNOW_LOTUS.get()),
                Ingredient.of(ModItems.MILK.get()),
                Ingredient.of(Items.ICE),
                Ingredient.of(Items.HONEY_BOTTLE)
        ), new ItemStack(ModFoods.EXTREMELY_COLD_CONDENSED_MILK_SCENTED_TEA.get()),60);

        addTeapotRecipe(pWriter,"axolotl_tea", List.of(
                Ingredient.of(Items.TROPICAL_FISH),
                Ingredient.of(Items.KELP),
                Ingredient.of(Items.HONEY_BOTTLE),
                Ingredient.of(ModItems.DRIED_LAVENDER.get())
        ), new ItemStack(ModFoods.AXOLOTL_TEA.get()),200);

        addTeapotRecipe(pWriter,"flower_party", List.of(
                Ingredient.of(ModItems.DRIED_HIBISCUS.get()),
                Ingredient.of(ModItems.DRIED_HONEYSUCKLE.get()),
                Ingredient.of(ModItems.DRIED_ROSE.get()),
                Ingredient.of(ModItems.DRIED_LAVENDER.get())
        ), new ItemStack(ModFoods.FLOWER_PARTY.get()),200);

        addTeapotRecipe(pWriter,"scarlet_margarita", List.of(
                Ingredient.of(Items.REDSTONE),
                Ingredient.of(Items.BLAZE_POWDER),
                Ingredient.of(Items.GLOWSTONE_DUST),
                Ingredient.of(ModItems.DRIED_LAVENDER.get())
        ), new ItemStack(ModFoods.SCARLET_MARGARITA.get()),200);

        addTeapotRecipe(pWriter,"strong_mouth_mushroom_tea", List.of(
                Ingredient.of(Items.RED_MUSHROOM),
                Ingredient.of(Items.BLAZE_POWDER),
                Ingredient.of(ModItems.DRIED_GREEN_TEA_LEAVE.get()),
                Ingredient.of(ModItems.DRIED_BLACK_TEA_LEAVE.get())
        ), new ItemStack(ModFoods.STRONG_MOUTH_MUSHROOM_TEA.get()),200);
        addTeapotRecipe(pWriter,"lava_special_drink", List.of(
                Ingredient.of(Items.MAGMA_CREAM),
                Ingredient.of(Items.NETHER_WART),
                Ingredient.of(ModItems.DRIED_SAFFLOWER.get()),
                Ingredient.of(ModItems.DRIED_GINGER_ITEM.get())
        ), new ItemStack(ModFoods.LAVA_SPECIAL_DRINK.get()),200);

        addTeapotRecipe(pWriter,"coral_mint_sparkling_water", List.of(
                Ingredient.of(ModItems.DRIED_MINT_LEAVE.get()),
                Ingredient.of(ModTags.Items.TEA_LEAVES),
                Ingredient.of(Items.SUGAR),
                Ingredient.of(Items.ICE)
        ), new ItemStack(ModFoods.CORAL_MINT_SPARKLING_WATER.get()),200);

        addTeapotRecipe(pWriter,"mixed_berry_smoothie", List.of(
                Ingredient.of(Items.SWEET_BERRIES),
                Ingredient.of(Items.GLOW_BERRIES),
                Ingredient.of(Items.HONEY_BOTTLE),
                Ingredient.of(Items.ICE)
        ), new ItemStack(ModFoods.MIXED_BERRY_SMOOTHIE.get()),200);

        addTeapotRecipe(pWriter,"milk_mushroom_soup", List.of(
                Ingredient.of(Items.BROWN_MUSHROOM),
                Ingredient.of(ModItems.MILK.get()),
                Ingredient.of(Items.CARROT),
                Ingredient.of(Items.BEETROOT)
        ), new ItemStack(ModFoods.MILK_MUSHROOM_SOUP.get()),200);

        addTeapotRecipe(pWriter,"the_tide_is_coming", List.of(
                Ingredient.of(Items.PUFFERFISH),
                Ingredient.of(Items.PRISMARINE_SHARD),
                Ingredient.of(Items.SCUTE),
                Ingredient.of(Items.KELP)
        ), new ItemStack(ModFoods.THE_TIDE_IS_COMING.get()),200);

        addTeapotRecipe(pWriter,"oenothera_lindheimeri_phantom", List.of(
                Ingredient.of(ModItems.DRIED_OENOTHERA_LINDHEIMERI.get()),
                Ingredient.of(Items.SUGAR),
                Ingredient.of(Items.PHANTOM_MEMBRANE),
                Ingredient.of(Items.CHORUS_FRUIT)
        ), new ItemStack(ModFoods.OENOTHERA_LINDHEIMERI_PHANTOM.get()),200);

        addTeapotRecipe(pWriter,"turtle_shell_lily_tea", List.of(
                Ingredient.of(ModItems.DRIED_LILY.get()),
                Ingredient.of(ModItems.DRIED_JASMINE.get()),
                Ingredient.of(ModItems.DRIED_LILY_OF_THE_VALLEY.get()),
                Ingredient.of(Items.SCUTE)
        ), new ItemStack(ModFoods.TURTLE_SHELL_LILY_TEA.get()),200);

        addTeapotRecipe(pWriter,"the_evokers_wrath", List.of(
                Ingredient.of(Items.EMERALD),
                Ingredient.of(Items.IRON_SWORD),
                Ingredient.of(ModItems.DRIED_SAFFLOWER.get()),
                Ingredient.of(ItemTags.WOOL)
        ), new ItemStack(ModFoods.THE_EVOKERS_WRATH.get()),200);

        addTeapotRecipe(pWriter,"the_devils_call", List.of(
                Ingredient.of(Items.WITHER_ROSE),
                Ingredient.of(ModItems.DRIED_LILY_OF_THE_VALLEY.get()),
                Ingredient.of(ModItems.DRIED_HERBACEOUS_PEONY.get()),
                Ingredient.of(Items.PUFFERFISH)
        ), new ItemStack(ModFoods.THE_DEVILS_CALL.get()),200);



    }


    protected static void oreSmelting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTIme, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.SMELTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTIme, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.BLASTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    protected static void oreCooking(Consumer<FinishedRecipe> pFinishedRecipeConsumer, RecipeSerializer<? extends AbstractCookingRecipe> pCookingSerializer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        for(ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult,
                    pExperience, pCookingTime, pCookingSerializer).group(pGroup).unlockedBy(getHasName(itemlike),
                    has(itemlike)).save(pFinishedRecipeConsumer, LushScentedParadise.MODID+ ":" +getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }

    }

    protected void addDryingRecipe(Consumer<FinishedRecipe> consumer, String name, Item input, Item output, int dryingTime){
        DryingRecipeBuilder.drying(ModRecipeSerializers.DRYING_RECIPE.get(),input,output,dryingTime)
                .save(consumer,new ResourceLocation(LushScentedParadise.MODID,name));
    }
    protected void addTeapotRecipe(Consumer<FinishedRecipe> consumer, String name, List<Ingredient> inputs, ItemStack result, int brewTime){
        TeapotRecipeBuilder.teapot(ModRecipeSerializers.TEAPOT_RECIPE.get(), inputs,result,brewTime)
                .save(consumer,new ResourceLocation(LushScentedParadise.MODID,name));
    }
}
