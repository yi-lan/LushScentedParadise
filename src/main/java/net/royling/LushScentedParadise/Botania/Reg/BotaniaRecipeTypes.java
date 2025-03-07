package net.royling.LushScentedParadise.Botania.Reg;

import net.minecraft.world.item.crafting.RecipeType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.royling.LushScentedParadise.Botania.BotaniaTeapot.ManaTeapotRecipe;
import net.royling.LushScentedParadise.LushScentedParadise;

public class BotaniaRecipeTypes {
    public static final DeferredRegister<RecipeType<?>> RECIPE_TYPES =
            DeferredRegister.create(ForgeRegistries.RECIPE_TYPES, LushScentedParadise.MODID);

    public static final RegistryObject<RecipeType<ManaTeapotRecipe>> MANA_TEAPOT =
            RECIPE_TYPES.register("mana_teapot",()->new RecipeType<>() {});


}
