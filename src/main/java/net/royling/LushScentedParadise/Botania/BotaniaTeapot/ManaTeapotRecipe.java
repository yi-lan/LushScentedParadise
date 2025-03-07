package net.royling.LushScentedParadise.Botania.BotaniaTeapot;

import net.minecraft.core.NonNullList;
import net.minecraft.core.RegistryAccess;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.Container;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;
import net.royling.LushScentedParadise.Botania.LSPBotaniaItems;
import net.royling.LushScentedParadise.Botania.Reg.BotaniaRecipeSerializers;
import net.royling.LushScentedParadise.Botania.Reg.BotaniaRecipeTypes;
import net.royling.LushScentedParadise.Registry.ModItems;

import java.util.ArrayList;
import java.util.List;

public class ManaTeapotRecipe implements Recipe<Container> {
    private final ResourceLocation id;
    private final List<Ingredient> ingredients;
    private final ItemStack result;
    private final int brewTime;
    private final int mana;
    public ManaTeapotRecipe(ResourceLocation id,List<Ingredient> ingredients,ItemStack result,int brewTime,int mana){
        this.id = id;
        this.ingredients = ingredients;
        this.result = result;
        this.brewTime =  brewTime;
        this.mana =mana;
    }

    @Override
    public boolean matches(Container pContainer, Level pLevel) {
        List<ItemStack> inputs = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            if(!pContainer.getItem(i).isEmpty()) {
                inputs.add(pContainer.getItem(i));
            }
        }

        ItemStack waterBottle = pContainer.getItem(4);
        if (!waterBottle.is(LSPBotaniaItems.MANA_WATER.get())) return false;
        if (inputs.size() != ingredients.size()) {
            return false;
        }

        List<Ingredient> required = new ArrayList<>(ingredients);
        for (ItemStack stack : inputs) {
            required.removeIf(ingredient -> ingredient.test(stack));
        }
        return required.isEmpty();
    }

    @Override
    public ItemStack assemble(Container container, RegistryAccess registryAccess) {
        return result.copy();
    }

    @Override
    public boolean canCraftInDimensions(int i, int i1) {
        return true;
    }

    @Override
    public ItemStack getResultItem(RegistryAccess registryAccess) {
        return result.copy();
    }

    @Override
    public RecipeType<?> getType() {
        return BotaniaRecipeTypes.MANA_TEAPOT.get();
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return BotaniaRecipeSerializers.MANA_TEAPOT_RECIPE.get();
    }

    public int getBrewTime() {
        return brewTime;
    }

    public int getMana() {
        return mana;
    }

    @Override
    public ResourceLocation getId() {
        return id;
    }

    @Override
    public NonNullList<Ingredient> getIngredients() {
        NonNullList<Ingredient> ingredientsList = NonNullList.create();
        ingredientsList.addAll(ingredients);
        return ingredientsList;
    }
    public ItemStack getResult() {
        return result;
    }
    public Ingredient getinputf(){
        return ingredients.get(0);
    }
    public Ingredient getinputs(){
        return ingredients.get(1);
    }
    public Ingredient getinputt(){
        return ingredients.get(2);
    }
    public Ingredient getinputfo(){
        return ingredients.get(3);
    }
    public Ingredient getInputInt(int c){
        return ingredients.get(c);
    }

}
