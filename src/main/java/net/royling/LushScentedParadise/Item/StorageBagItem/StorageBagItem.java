package net.royling.LushScentedParadise.Item.StorageBagItem;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.*;
import net.minecraft.world.entity.Interaction;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.Tags;
import net.minecraftforge.items.ItemStackHandler;
import net.minecraftforge.network.NetworkHooks;
import net.royling.LushScentedParadise.util.ModTags;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class StorageBagItem extends Item {
    private static final String TAG_AUTO_PICK = "AutoPick";
    private static final String TAG_ITEMS = "Items";

    public StorageBagItem(Properties properties){
        super(properties);
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        boolean autoPickup = isAuto(pStack);
        pTooltipComponents.add(Component.translatable("tooltip.lushscentedparadise.storage_bag.auto_pickup",autoPickup?"✔":"✘"));
        super.appendHoverText(pStack,pLevel,pTooltipComponents,pIsAdvanced);
    }
    public static boolean isAuto(ItemStack itemStack){
        return itemStack.hasTag()&&itemStack.getTag().getBoolean(TAG_AUTO_PICK);
    }
    public static void toggleAutopick(ItemStack stack, Player player){
        CompoundTag tag = stack.getOrCreateTag();
        boolean current = tag.getBoolean(TAG_AUTO_PICK);
        tag.putBoolean(TAG_AUTO_PICK,!current);
        player.displayClientMessage(Component.translatable("message.lushscentedparadise.toggle_auto_pickup", !current ? "✔" : "✘"), true);
    }
    public static ItemStackHandler getInventory(ItemStack stack){
        ItemStackHandler handler = new ItemStackHandler(27);
        if(stack.hasTag()&&stack.getTag().contains(TAG_ITEMS)){
            handler.deserializeNBT(stack.getTag().getCompound(TAG_ITEMS));
        }
        return handler;
    }
    public static void saveInventory(ItemStack stack,ItemStackHandler handler){
        CompoundTag tag = stack.getOrCreateTag();
        tag.put(TAG_ITEMS,handler.serializeNBT());
    }

    @Override
    public boolean isBarVisible(ItemStack pStack) {
        return true;
    }

    @Override
    public int getBarWidth(ItemStack pStack) {
        ItemStackHandler inventory = getInventory(pStack);
        int usedSlots = 0;
        int totalSlots = inventory.getSlots();
        for(int i =0;i<totalSlots;i++){
            if(!inventory.getStackInSlot(i).isEmpty()){
                usedSlots++;
            }
        }
        return (int)((double)usedSlots/totalSlots*13);
    }

    @Override
    public int getBarColor(ItemStack pStack) {
        return 0x00FF00;
    }

    public static boolean canStoreItem(ItemStack bag, ItemStack itemStack){
        return (bag.getItem() instanceof FlowerBagItem && itemStack.is(ItemTags.FLOWERS)||
                bag.getItem() instanceof SeedBagItem && itemStack.is(ModTags.Items.SEEDS));
    }

    public static boolean storeItem(ItemStack bag,ItemStack itemStack){
        if (!(bag.getItem() instanceof StorageBagItem) || !canStoreItem(bag, itemStack)) {
            return false;
        }

        ItemStackHandler inventory = getInventory(bag);

        for(int i =0;i<inventory.getSlots();i++){

            ItemStack slotStack = inventory.getStackInSlot(i);

            if(slotStack.isEmpty()){
                inventory.setStackInSlot(i, itemStack.copy());
                saveInventory(bag,inventory);
                itemStack.setCount(0);
                return true;
            }

            else if(ItemStack.isSameItemSameTags(slotStack,itemStack)&&slotStack.getCount()+itemStack.getCount()<=slotStack.getMaxStackSize()){
                slotStack.grow(itemStack.getCount());
                saveInventory(bag,inventory);
                itemStack.setCount(0);
                return true;
            }
        }
        return false;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        ItemStack stack = pPlayer.getItemInHand(pUsedHand);
        if(pPlayer.isShiftKeyDown()){
            toggleAutopick(stack,pPlayer);
            return InteractionResultHolder.success(stack);
        }
        if(!pLevel.isClientSide&&pPlayer instanceof ServerPlayer serverPlayer){
            ItemStackHandler inventory = getInventory(stack);
            MenuProvider menuProvider = new SimpleMenuProvider(
                    (id,inv,p)->new StorageBagMenu(id,inv,inventory,stack),
                    Component.translatable("container.lushscentedparadise.storage_bag")
            );
            NetworkHooks.openScreen(serverPlayer,menuProvider);
        }
        return InteractionResultHolder.success(stack);
    }

}
