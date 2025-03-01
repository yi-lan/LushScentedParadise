package net.royling.LushScentedParadise.ModBlock.DryingRack;

import net.minecraft.core.RegistryAccess;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;
import net.royling.LushScentedParadise.LushScentedParadise;
import net.royling.LushScentedParadise.ModBlock.TeapotBlock.TeapotRecipe;
import net.royling.LushScentedParadise.Registry.ModRecipeSerializers;
import net.royling.LushScentedParadise.Registry.ModRecipeTypes;

public class DryingRecipe implements Recipe<SimpleContainer> {
    private final ResourceLocation id;
    private final Ingredient input;
    private final ItemStack output;
    private final int dryingTime;
    public static final mezz.jei.api.recipe.RecipeType<DryingRecipe> RECIPE_TYPE =
            mezz.jei.api.recipe.RecipeType.create(LushScentedParadise.MODID,"drying",DryingRecipe.class);
    public DryingRecipe(ResourceLocation id,Ingredient input,ItemStack output,int dryingTime){
        this.id = id;
        this.input = input;
        this.output = output;
        this.dryingTime = dryingTime;
    }

    @Override
    public boolean matches(SimpleContainer pContainer, Level pLevel) {
        return input.test(pContainer.getItem(0));
    }

    @Override
    public ItemStack assemble(SimpleContainer pContainer, RegistryAccess pRegistryAccess) {
        return output.copy();
    }

    @Override
    public boolean canCraftInDimensions(int pWidth, int pHeight) {
        return true;
    }

    @Override
    public ItemStack getResultItem(RegistryAccess pRegistryAccess) {
        return output.copy();
    }

    @Override
    public ResourceLocation getId() {
        return id;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return ModRecipeSerializers.DRYING_RECIPE.get();
    }

    @Override
    public RecipeType<?> getType() {
        return ModRecipeTypes.DRYING_RECIPE.get();
    }

    public int getDryingTime() {
        return dryingTime;
    }

    public Ingredient getInput() {
        return input;
    }

    public ItemStack getOutput() {
        return output;
    }

}
