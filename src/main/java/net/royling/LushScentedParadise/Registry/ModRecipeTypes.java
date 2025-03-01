package net.royling.LushScentedParadise.Registry;

import net.minecraft.world.item.crafting.RecipeType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.royling.LushScentedParadise.LushScentedParadise;
import net.royling.LushScentedParadise.ModBlock.DryingRack.DryingRecipe;
import net.royling.LushScentedParadise.ModBlock.TeapotBlock.TeapotRecipe;

public class ModRecipeTypes {
    public static final DeferredRegister<RecipeType<?>> RECIPE_TYPES =
            DeferredRegister.create(ForgeRegistries.RECIPE_TYPES, LushScentedParadise.MODID);

    public static final RegistryObject<RecipeType<TeapotRecipe>> TEAPOT_RECIPE =
            RECIPE_TYPES.register("teapot", () -> new RecipeType<>() {});
    public static final RegistryObject<RecipeType<DryingRecipe>> DRYING_RECIPE =
            RECIPE_TYPES.register("drying",()-> new RecipeType<>() {});

    public static void register(IEventBus eventBus){
        RECIPE_TYPES.register(eventBus);
    }
}
