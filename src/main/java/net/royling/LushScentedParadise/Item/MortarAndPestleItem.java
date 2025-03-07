package net.royling.LushScentedParadise.Item;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class MortarAndPestleItem extends Item {

    public MortarAndPestleItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public boolean isEnchantable(ItemStack pStack) {
        return false;
    }

    @Override
    public boolean isRepairable(ItemStack stack) {
        return false;
    }

    @Override
    public ItemStack getCraftingRemainingItem(ItemStack itemStack) {
        if(itemStack.isDamageableItem()&&itemStack.getDamageValue()<itemStack.getMaxDamage()-1){
            ItemStack newStack = itemStack.copy();
            newStack.setDamageValue(itemStack.getDamageValue()+1);
            return newStack;
        }
        return ItemStack.EMPTY;
    }
    @Override
    public boolean hasCraftingRemainingItem(ItemStack stack) {
        return true;
    }
}
