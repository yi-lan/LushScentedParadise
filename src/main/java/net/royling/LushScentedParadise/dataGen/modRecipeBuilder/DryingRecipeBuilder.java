package net.royling.LushScentedParadise.dataGen.modRecipeBuilder;

import com.google.gson.JsonObject;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.RecipeSerializer;
import org.jetbrains.annotations.Nullable;

import java.util.function.Consumer;

public class DryingRecipeBuilder {
    private final Item input;
    private final Item output;
    private final int dryingTime;
    private final RecipeSerializer<?> serializer;

    public DryingRecipeBuilder(RecipeSerializer<?> serializer,Item input,Item output,int dryingTime){
        this.serializer=serializer;
        this.input=input;
        this.output=output;
        this.dryingTime=dryingTime;
    }
    public static DryingRecipeBuilder drying(RecipeSerializer<?> serializer,Item input,Item output,int dryingTime){
        return new DryingRecipeBuilder(serializer,input,output,dryingTime);
    }
    public void save(Consumer<FinishedRecipe> consumer, ResourceLocation id){
        consumer.accept(new FinishedRecipe() {
            @Override
            public void serializeRecipeData(JsonObject pJson) {
                pJson.addProperty("type","lushscentedparadise:drying");
                JsonObject inputJson = new JsonObject();
                inputJson.addProperty("item", BuiltInRegistries.ITEM.getKey(input).toString());
                pJson.add("input",inputJson);
                pJson.addProperty("output",BuiltInRegistries.ITEM.getKey(output).toString());
                pJson.addProperty("dryingTime",dryingTime);
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
            public @Nullable JsonObject serializeAdvancement() {
                return null;
            }

            @Override
            public @Nullable ResourceLocation getAdvancementId() {
                return null;
            }
        });
    }
}
