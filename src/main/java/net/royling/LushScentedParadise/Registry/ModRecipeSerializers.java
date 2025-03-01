package net.royling.LushScentedParadise.Registry;

import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.royling.LushScentedParadise.LushScentedParadise;
import net.royling.LushScentedParadise.ModBlock.DryingRack.DryingRecipe;
import net.royling.LushScentedParadise.ModBlock.DryingRack.DryingSerializer;
import net.royling.LushScentedParadise.ModBlock.TeapotBlock.TeapotRecipe;
import net.royling.LushScentedParadise.ModBlock.TeapotBlock.TeapotRecipeSerializer;

public class ModRecipeSerializers {
    public static final DeferredRegister<RecipeSerializer<?>> SERIALIZERS =
            DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, LushScentedParadise.MODID);

    public static final RegistryObject<RecipeSerializer<TeapotRecipe>> TEAPOT_RECIPE =
            SERIALIZERS.register("teapot", TeapotRecipeSerializer::new);
    public static final RegistryObject<RecipeSerializer<DryingRecipe>> DRYING_RECIPE =
            SERIALIZERS.register("drying", DryingSerializer::new);

    public static void register(IEventBus eventBus){
        SERIALIZERS.register(eventBus);
    }
}
