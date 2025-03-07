package net.royling.LushScentedParadise.Botania.BotaniaTeapot;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import net.minecraft.core.RegistryAccess;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.ShapedRecipe;
import net.royling.LushScentedParadise.ModBlock.TeapotBlock.TeapotRecipe;

import java.util.ArrayList;
import java.util.List;

public class ManaTeapotRecipeSerializer implements RecipeSerializer<ManaTeapotRecipe> {

    @Override
    public ManaTeapotRecipe fromJson(ResourceLocation resourceLocation, JsonObject jsonObject) {
        List<Ingredient> ingredients = new ArrayList<>();
        JsonArray ingredientsArray = GsonHelper.getAsJsonArray(jsonObject, "ingredients");

        for (int i = 0; i < ingredientsArray.size(); i++) {
            ingredients.add(Ingredient.fromJson(ingredientsArray.get(i)));
        }

        ItemStack output = ShapedRecipe.itemStackFromJson(GsonHelper.getAsJsonObject(jsonObject,"result"));
        int brewTime = GsonHelper.getAsInt(jsonObject, "brew_time", 200);
        int mana = GsonHelper.getAsInt(jsonObject,"mana",200);

        return new ManaTeapotRecipe(resourceLocation, ingredients, output, brewTime,mana);
    }
    @Override
    public ManaTeapotRecipe fromNetwork(ResourceLocation recipeId, FriendlyByteBuf buffer) {
        int size = buffer.readInt();
        List<Ingredient> ingredients = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            ingredients.add(Ingredient.fromNetwork(buffer));
        }

        ItemStack output = buffer.readItem();
        int brewTime = buffer.readInt();
        int mana = buffer.readInt();

        return new ManaTeapotRecipe(recipeId, ingredients, output, brewTime, mana);
    }
    @Override
    public void toNetwork(FriendlyByteBuf buffer, ManaTeapotRecipe recipe) {
        buffer.writeInt(recipe.getIngredients().size());
        for (Ingredient ingredient : recipe.getIngredients()) {
            ingredient.toNetwork(buffer);
        }
        buffer.writeItem(recipe.getResultItem(RegistryAccess.EMPTY));
        buffer.writeInt(recipe.getBrewTime());
        buffer.writeInt(recipe.getMana());
    }
}
