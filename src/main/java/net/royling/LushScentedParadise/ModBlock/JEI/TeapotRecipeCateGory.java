package net.royling.LushScentedParadise.ModBlock.JEI;

import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.gui.drawable.IDrawableStatic;
import mezz.jei.api.gui.ingredient.IRecipeSlotsView;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.royling.LushScentedParadise.LushScentedParadise;
import net.royling.LushScentedParadise.Registry.ModItems;
import net.royling.LushScentedParadise.ModBlock.TeapotBlock.TeapotRecipe;
import org.jetbrains.annotations.Nullable;
@SuppressWarnings("removal")
public class TeapotRecipeCateGory implements IRecipeCategory<TeapotRecipe> {
    public static final RecipeType<TeapotRecipe> RECIPE_TYPE =
            RecipeType.create(LushScentedParadise.MODID,"teapot",TeapotRecipe.class);
    private final IDrawableStatic background;
    private final IDrawable icon;
    public TeapotRecipeCateGory(IGuiHelper guiHelper){
        this.background = guiHelper.createDrawable(
                new ResourceLocation(LushScentedParadise.MODID,"textures/gui/teapotjei.png"),
                0,0,150,60
        );
        this.icon = guiHelper.createDrawableIngredient(VanillaTypes.ITEM_STACK,
                new ItemStack(ModItems.CLEAN_WATER.get()));
    }
    @Override
    public RecipeType<TeapotRecipe> getRecipeType() {
        return RECIPE_TYPE;
    }

    @Override
    public Component getTitle() {
        return Component.translatable("jei.lushscentedparadise.teapot.recipe");
    }

    @Override
    public @Nullable IDrawable getIcon() {
        return icon;
    }

    @Override
    public @Nullable IDrawableStatic getBackground() {
        return background;
    }

    @Override
    public int getWidth() {
        return background.getWidth();
    }

    @Override
    public int getHeight() {
        return background.getHeight();
    }

    @Override
    public void draw(TeapotRecipe recipe, IRecipeSlotsView recipeSlotsView, GuiGraphics guiGraphics, double mouseX, double mouseY) {
        Component text = Component.translatable("jei.lushscentedparadise.brewtime",recipe.getBrewTime())
                .setStyle(Style.EMPTY.withBold(true).withColor(ChatFormatting.DARK_GREEN));
        int textWidth = Minecraft.getInstance().font.width(text);
        int x = 75-textWidth/2;
        guiGraphics.drawString(Minecraft.getInstance().font, text,x,40,0xFFFFFF,false);
    }

    @Override
    public void setRecipe(IRecipeLayoutBuilder iRecipeLayoutBuilder, TeapotRecipe recipe, IFocusGroup iFocusGroup) {
        int inputCount = recipe.getIngredients().size();
        if(inputCount>=1){
        if(!recipe.getinputf().isEmpty()){
                iRecipeLayoutBuilder.addSlot(RecipeIngredientRole.INPUT,5,5).addIngredients(recipe.getinputf());
            }   else   {
                iRecipeLayoutBuilder.addSlot(RecipeIngredientRole.INPUT,5,5).addItemStack(new ItemStack(Items.AIR));
            }
        }
        if(inputCount>=2) {
            if (!recipe.getinputs().isEmpty()) {
                iRecipeLayoutBuilder.addSlot(RecipeIngredientRole.INPUT, 23, 5).addIngredients(recipe.getinputs());
            } else {
                iRecipeLayoutBuilder.addSlot(RecipeIngredientRole.INPUT, 23, 5).addItemStack(new ItemStack(Items.AIR));
            }
        }
        if(inputCount>=3) {
            if (!recipe.getinputt().isEmpty()) {
                iRecipeLayoutBuilder.addSlot(RecipeIngredientRole.INPUT, 5, 23).addIngredients(recipe.getinputt());
            } else {
                iRecipeLayoutBuilder.addSlot(RecipeIngredientRole.INPUT, 5, 23).addItemStack(new ItemStack(Items.AIR));
            }
        }
        if(inputCount==4) {
            if (!recipe.getinputfo().isEmpty()) {
                iRecipeLayoutBuilder.addSlot(RecipeIngredientRole.INPUT, 23, 23).addIngredients(recipe.getinputfo());
            } else {
                iRecipeLayoutBuilder.addSlot(RecipeIngredientRole.INPUT, 23, 23).addItemStack(new ItemStack(Items.AIR));
            }
        }
        iRecipeLayoutBuilder.addSlot(RecipeIngredientRole.INPUT,41,13).addItemStack(new ItemStack(ModItems.CLEAN_WATER.get()));
        iRecipeLayoutBuilder.addSlot(RecipeIngredientRole.OUTPUT,120,13).addItemStack(recipe.getResultItem(null));

    }
}
