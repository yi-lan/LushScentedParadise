package net.royling.LushScentedParadise.Item.StorageBagItem;

import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.royling.LushScentedParadise.LushScentedParadise;

public class StorageBagScreen extends AbstractContainerScreen<StorageBagMenu> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(LushScentedParadise.MODID,"textures/gui/storage_bag.png");

    public StorageBagScreen(StorageBagMenu menu, Inventory inventory, Component title){
        super(menu,inventory,title);
        this.imageWidth = 176;
        this.imageHeight = 166;
    }

    @Override
    protected void renderBg(GuiGraphics guiGraphics, float v, int i, int i1) {
        guiGraphics.blit(TEXTURE,leftPos,topPos,0,0,imageWidth,imageHeight);
    }

    @Override
    public void render(GuiGraphics pGuiGraphics, int pMouseX, int pMouseY, float pPartialTick) {
        super.render(pGuiGraphics, pMouseX, pMouseY, pPartialTick);
        this.renderTooltip(pGuiGraphics,pMouseX,pMouseY);
    }

    @Override
    protected void containerTick() {
        super.containerTick();
        if(!menu.stillValid(minecraft.player)){
            this.minecraft.player.closeContainer();
        }
    }
}
