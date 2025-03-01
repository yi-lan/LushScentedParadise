package net.royling.LushScentedParadise.Item.StorageBagItem;

import net.minecraft.world.item.ItemStack;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;
import org.jetbrains.annotations.NotNull;

public class RestrictedSlotItemHandler extends SlotItemHandler {
    private final ItemStack bagStack;
    public RestrictedSlotItemHandler(IItemHandler itemHandler, int index, int xPosition, int yPosition,ItemStack bagStack) {
        super(itemHandler, index, xPosition, yPosition);
        this.bagStack=bagStack;
    }

    @Override
    public boolean mayPlace(@NotNull ItemStack stack) {
        return StorageBagItem.canStoreItem(bagStack,stack);
    }
}
