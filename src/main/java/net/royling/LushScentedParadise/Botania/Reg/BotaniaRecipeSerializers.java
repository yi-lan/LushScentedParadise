package net.royling.LushScentedParadise.Botania.Reg;

import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.royling.LushScentedParadise.Botania.BotaniaTeapot.ManaTeapotRecipe;
import net.royling.LushScentedParadise.Botania.BotaniaTeapot.ManaTeapotRecipeSerializer;
import net.royling.LushScentedParadise.LushScentedParadise;
import net.royling.LushScentedParadise.ModBlock.TeapotBlock.TeapotRecipe;
import net.royling.LushScentedParadise.ModBlock.TeapotBlock.TeapotRecipeSerializer;

public class BotaniaRecipeSerializers {
    public static final DeferredRegister<RecipeSerializer<?>> SERIALIZERS =
            DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, LushScentedParadise.MODID);

    public static final RegistryObject<RecipeSerializer<ManaTeapotRecipe>> MANA_TEAPOT_RECIPE =
            SERIALIZERS.register("mana_teapot", ManaTeapotRecipeSerializer::new);

}
