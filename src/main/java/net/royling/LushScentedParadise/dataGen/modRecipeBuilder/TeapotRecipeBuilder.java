package net.royling.LushScentedParadise.dataGen.modRecipeBuilder;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;

import java.util.List;
import java.util.function.Consumer;

public class TeapotRecipeBuilder {
    private final List<Ingredient> ingredients;
    private final ItemStack result;
    private final int brewTime;
    private final RecipeSerializer<?> serializer;
    public TeapotRecipeBuilder(RecipeSerializer<?> serializer, List<Ingredient> ingredients, ItemStack result, int brewTime) {
        this.serializer = serializer;
        this.ingredients = ingredients;
        this.result = result;
        this.brewTime = brewTime;
    }
    public static TeapotRecipeBuilder teapot(RecipeSerializer<?> serializer, List<Ingredient> ingredients, ItemStack result, int brewTime) {
        return new TeapotRecipeBuilder(serializer, ingredients, result, brewTime);
    }
    public void save(Consumer<FinishedRecipe> consumer, ResourceLocation id) {
        consumer.accept(new FinishedRecipe() {
            @Override
            public void serializeRecipeData(JsonObject json) {
                json.addProperty("type", "lushscentedparadise:teapot");

                JsonArray ingredientsArray = new JsonArray();
                for (Ingredient ingredient : ingredients) {
                    ingredientsArray.add(ingredient.toJson());
                }
                json.add("ingredients", ingredientsArray);

                JsonObject resultJson = new JsonObject();
                resultJson.addProperty("item", BuiltInRegistries.ITEM.getKey(result.getItem()).toString());
                json.add("result", resultJson);

                json.addProperty("brew_time", brewTime);
            }

            @Override
            public ResourceLocation getId() {
                return id;
            }

            @Override
            public RecipeSerializer<?> getType() {
                return serializer;
            }

            @Override
            public JsonObject serializeAdvancement() {
                return null;
            }

            @Override
            public ResourceLocation getAdvancementId() {
                return null;
            }
        });
    }
}
