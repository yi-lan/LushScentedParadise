package net.royling.LushScentedParadise.dataGen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;
import net.royling.LushScentedParadise.LushScentedParadise;
import net.royling.LushScentedParadise.Item.Flowertea.ModFoods;
import net.royling.LushScentedParadise.Registry.ModItems;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, LushScentedParadise.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleTeaItem(ModFoods.DANDELION_TEA);
        simpleTeaItem(ModFoods.POPPY_TEA);
        simpleTeaItem(ModFoods.BLUE_OC_TEA);
        simpleTeaItem(ModFoods.TULIP_TEA);
        simpleTeaItem(ModFoods.OXEYE_DAISY_TEA);
        simpleTeaItem(ModFoods.CORNFLOWER_TEA);
        simpleTeaItem(ModFoods.LILY_OF_THE_VALLEY_TEA);
        simpleTeaItem(ModFoods.LILAC_TEA);
        simpleTeaItem(ModFoods.ROSE_TEA);
        simpleTeaItem(ModFoods.PEONY_TEA);
        simpleTeaItem(ModFoods.WITHER_ROSE_TEA);
        //simpleTeaItem(ModFoods.TORCH_FLOWER_TEA);
        simpleTeaItem(ModFoods.GLOW_BERRIES_TEA);
        simpleTeaItem(ModFoods.SWEET_BERRIES_TEA);
        simpleTeaItem(ModFoods.CHORUS_TEA);
        simpleTeaItem(ModFoods.FERN_TEA);
        simpleTeaItem(ModFoods.SPORE_BLOSSOM_TEA);
        simpleTeaItem(ModFoods.CACTUS_TEA);
        simpleTeaItem(ModFoods.HOT_COCOA);
        //simpleTeaItem(ModFoods.KELP_SOUP);
        simpleTeaItem(ModFoods.GREEN_TEA);
        simpleTeaItem(ModFoods.BLACK_TEA);
        simpleTeaItem(ModFoods.WHITE_TEA);
        simpleTeaItem(ModFoods.OOLONG_TEA);
        simpleTeaItem(ModFoods.PUER_TEA);
        simpleTeaItem(ModFoods.MINT_TEA);
        simpleTeaItem(ModFoods.GINGER_SOUP);
        //simpleTeaItem(ModFoods.LEAVES_TEA);
        simpleTeaItem(ModFoods.HONEYSUCKLE_TEA);
        simpleTeaItem(ModFoods.VIOLET_TEA);
        simpleTeaItem(ModFoods.HIBISCUS_TEA);
        simpleTeaItem(ModFoods.HERBACEOUS_PEONY_TEA);
        simpleTeaItem(ModFoods.JASMINE_TEA);
        simpleTeaItem(ModFoods.LAVENDER_TEA);
        simpleTeaItem(ModFoods.LILY_TEA);
        simpleTeaItem(ModFoods.SAFFLOWER_TEA);
        simpleTeaItem(ModFoods.SNOW_LOTUS_TEA);
        simpleTeaItem(ModFoods.MARIGOLD_TEA);
        simpleTeaItem(ModFoods.OENOTHERA_TEA);
        simpleTeaItem(ModFoods.PERILLA_TEA);
        simpleTeaItem(ModFoods.VERBENA_TEA);
        simpleTeaItem(ModFoods.LICORICE_SOUP);
        simpleTeaItem(ModFoods.ASTRAGALUS_SOUP);
        simpleTeaItem(ModFoods.BURDOCK_SOUP);
        simpleTeaItem(ModFoods.KUDZU_SOUP);
        simpleTeaItem(ModFoods.PORIA_TEA);
        simpleTeaItem(ModFoods.FLAX_TEA);
        simpleTeaItem(ModFoods.SPARKLING_MATCHA);
        simpleTeaItem(ModFoods.MINT_HONEY_SPECIAL_DRINK);
        simpleTeaItem(ModFoods.GINGER_HONEY_BLACK_TEA);
        simpleTeaItem(ModFoods.OOLONG_APPLE_HONEY_SPECIAL_DRINK);
        simpleTeaItem(ModFoods.NETHER_FLAVOR);
        simpleTeaItem(ModFoods.ENDER_FLAVOR);
        simpleTeaItem(ModFoods.HORROR_SOUP);
        simpleTeaItem(ModFoods.EXPLOSIVE_GINGER_SOUP);
        simpleTeaItem(ModFoods.CHOCOLATE_LILY_TEA);
        simpleTeaItem(ModFoods.WATERMELON_MINT_SPECIAL_DRINK);
        simpleTeaItem(ModFoods.ROSE_APPLE_TEA);
        simpleTeaItem(ModFoods.FIRE_HIBISCUS_TEA);
        simpleTeaItem(ModFoods.LEGENDARY_CHINESE_MEDICINE);
        simpleTeaItem(ModFoods.BAK_KUT_TEH);
        simpleTeaItem(ModFoods.BRILLIANT_AMETHYST_DRINK);
        simpleTeaItem(ModFoods.GOLDEN_SOUP);
        simpleTeaItem(ModFoods.SUPREME_GOLDEN_TEA);
        simpleTeaItem(ModFoods.ENCHANTED_SUPREME_GOLDEN_TEA);
        simpleTeaItem(ModFoods.OCEAN_JOURNEY);
        simpleTeaItem(ModFoods.EXTREMELY_COLD_CONDENSED_MILK_SCENTED_TEA);
        simpleTeaItem(ModFoods.AXOLOTL_TEA);
        simpleTeaItem(ModFoods.FLOWER_PARTY);
        simpleTeaItem(ModFoods.SCARLET_MARGARITA);
        simpleTeaItem(ModFoods.STRONG_MOUTH_MUSHROOM_TEA);
        simpleTeaItem(ModFoods.LAVA_SPECIAL_DRINK);
        simpleTeaItem(ModFoods.CORAL_MINT_SPARKLING_WATER);
        simpleTeaItem(ModFoods.MIXED_BERRY_SMOOTHIE);
        simpleTeaItem(ModFoods.MILK_MUSHROOM_SOUP);
        simpleTeaItem(ModFoods.THE_TIDE_IS_COMING);
        simpleTeaItem(ModFoods.OENOTHERA_LINDHEIMERI_PHANTOM);
        simpleTeaItem(ModFoods.TURTLE_SHELL_LILY_TEA);
        simpleTeaItem(ModFoods.THE_EVOKERS_WRATH);
        simpleTeaItem(ModFoods.THE_DEVILS_CALL);
        simpleItem(ModItems.MILK);
        simpleItem(ModItems.FLOWER_BAG);
        simpleItem(ModItems.SEED_BAG);
        simpleItem(ModItems.ORIGINAL_FLOWER_SWORD);
        simpleItem(ModItems.DRIED_VIOLET);
        simpleItem(ModItems.DRIED_HIBISCUS);
        simpleItem(ModItems.DRIED_HERBACEOUS_PEONY);
        simpleItem(ModItems.DRIED_JASMINE);
        simpleItem(ModItems.DRIED_LAVENDER);
        simpleItem(ModItems.DRIED_LILY);
        simpleItem(ModItems.DRIED_SAFFLOWER);
        simpleItem(ModItems.DRIED_SNOW_LOTUS);
        simpleItem(ModItems.DRIED_MARIGOLD);
        simpleItem(ModItems.DRIED_OENOTHERA_LINDHEIMERI);
        simpleItem(ModItems.DRIED_PERILLA);
        simpleItem(ModItems.DRIED_HONEYSUCKLE);
        simpleItem(ModItems.DRIED_GREEN_TEA_LEAVE);
        simpleItem(ModItems.DRIED_BLACK_TEA_LEAVE);
        simpleItem(ModItems.DRIED_WHITE_TEA_LEAVE);
        simpleItem(ModItems.DRIED_OOLONG_TEA_LEAVE);
        simpleItem(ModItems.DRIED_PUER_TEA_LEAVE);
        simpleItem(ModItems.DRIED_MINT_LEAVE);
        simpleItem(ModItems.DRIED_LICORICE_ROOT);
        simpleItem(ModItems.DRIED_ASTRAGALUS_ROOT);
        simpleItem(ModItems.DRIED_VERBENA_ITEM);
        simpleItem(ModItems.DRIED_GINGER_ITEM);
        simpleItem(ModItems.DRIED_BURDOCK_ITEM);
        simpleItem(ModItems.DRIED_KUDZU_ITEM);
        simpleItem(ModItems.DRIED_PORIA_ITEM);
        simpleItem(ModItems.DRIED_FLAX_ITEM);
        simpleItem(ModItems.DRIED_DANDELION);
        simpleItem(ModItems.DRIED_POPPY);
        simpleItem(ModItems.DRIED_ORCHID);
        simpleItem(ModItems.DRIED_TULIP);
        simpleItem(ModItems.DRIED_OXEYE_DAISY);
        simpleItem(ModItems.DRIED_CORNFLOWER);
        simpleItem(ModItems.DRIED_LILY_OF_THE_VALLEY);
        simpleItem(ModItems.DRIED_LILAC);
        simpleItem(ModItems.DRIED_ROSE);
        simpleItem(ModItems.DRIED_PEONY);


    }
    @SuppressWarnings("removal")
    private ItemModelBuilder simpleItem(RegistryObject<Item> item){
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(LushScentedParadise.MODID,"item/"+item.getId().getPath()));
    }
    @SuppressWarnings("removal")
    private ItemModelBuilder simpleTeaItem(RegistryObject<Item> item){
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(LushScentedParadise.MODID,"item/tea/"+item.getId().getPath()));
    }
}
