package net.royling.LushScentedParadise.ModBlock.DryingRack;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.common.crafting.CraftingHelper;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.Nullable;

public class DryingSerializer implements RecipeSerializer<DryingRecipe> {
    @Override
    public DryingRecipe fromJson(ResourceLocation pRecipeId, JsonObject pSerializedRecipe) {
        Ingredient ingredient = Ingredient.fromJson(pSerializedRecipe.get("input"));

        JsonElement outputElement = pSerializedRecipe.get("output");
        ItemStack output;
        if(outputElement.isJsonObject()){
            output = CraftingHelper.getItemStack(outputElement.getAsJsonObject(),true);
        }else {
            String itemID = outputElement.getAsString();
            Item item = ForgeRegistries.ITEMS.getValue(new ResourceLocation(itemID));
            if(item == null){
                throw new JsonParseException("Unknown item: " + itemID);
            }
            output=new ItemStack(item);
        }
        int dryingTime = GsonHelper.getAsInt(pSerializedRecipe,"dryingTime",200);
        return new DryingRecipe(pRecipeId,ingredient,output,dryingTime);
    }

    @Override
    public @Nullable DryingRecipe fromNetwork(ResourceLocation pRecipeId, FriendlyByteBuf pBuffer) {
        Ingredient ingredient =Ingredient.fromNetwork(pBuffer);
        ItemStack output = pBuffer.readItem();
        int dryingTime = pBuffer.readVarInt();
        return new DryingRecipe(pRecipeId,ingredient,output,dryingTime);
    }

    @Override
    public void toNetwork(FriendlyByteBuf pBuffer, DryingRecipe pRecipe) {
        pRecipe.getInput().toNetwork(pBuffer);
        pBuffer.writeItem(pRecipe.getOutput());
        pBuffer.writeVarInt(pRecipe.getDryingTime());
    }
}

