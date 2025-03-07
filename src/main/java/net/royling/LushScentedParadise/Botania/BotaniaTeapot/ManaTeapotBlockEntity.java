package net.royling.LushScentedParadise.Botania.BotaniaTeapot;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.inventory.SimpleContainerData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.ItemStackHandler;
import net.royling.LushScentedParadise.Botania.LSPBotaniaItems;
import net.royling.LushScentedParadise.Botania.Reg.BotaniaBlockEntities;
import net.royling.LushScentedParadise.Botania.Reg.BotaniaRecipeTypes;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import vazkii.botania.api.BotaniaForgeCapabilities;
import vazkii.botania.api.mana.ManaReceiver;

import java.util.Objects;
import java.util.Optional;

public class ManaTeapotBlockEntity extends BlockEntity implements MenuProvider, ManaReceiver {
    private final ItemStackHandler itemStackHandler = new ItemStackHandler(6){
        @Override
        protected void onContentsChanged(int slot) {
            setChanged();
        }

        @Override
        public boolean isItemValid(int slot, @NotNull ItemStack stack) {
            return slot<5||stack.is(LSPBotaniaItems.MANA_WATER.get());
        }
    };
    private int brewTime = 0;
    private int mana = 0;
    private final int MaxMana = 1000;
    private final ContainerData data = new SimpleContainerData(3);
    public ManaTeapotBlockEntity(BlockPos pos, BlockState blockState){
        super(BotaniaBlockEntities.MANA_TEAPOT.get(),pos,blockState);
    }

    @Override
    public @NotNull Component getDisplayName() {
        return Component.translatable("container.lushscentedparadise.mana_teapot");
    }

    @Override
    public @Nullable AbstractContainerMenu createMenu(int i, @NotNull Inventory inventory, @NotNull Player player) {
        return new ManaTeapotMenu(i,inventory,this,data);
    }
    public void tick(){
        if(Objects.requireNonNull(level).isClientSide)return;
        data.set(2,mana);
        Optional<ManaTeapotRecipe> recipe = getCurrentRecipe();
        if(recipe.isPresent()){
            ItemStack outputSlotStack = itemStackHandler.getStackInSlot(5);
            ItemStack recipeOutput = recipe.get().getResultItem(level.registryAccess());
            int brewTimeMax = recipe.get().getBrewTime();
            int needmana = recipe.get().getMana()/recipe.get().getBrewTime();
            data.set(1,brewTimeMax);
            data.set(0,brewTime);
            if(outputSlotStack.isEmpty()||(ItemStack.isSameItemSameTags(outputSlotStack,recipeOutput)&&outputSlotStack.getCount()+recipeOutput.getCount()<=outputSlotStack.getMaxStackSize())){
                if(mana>=needmana){
                    brewTime++;
                    mana-=needmana;
                    if(brewTime>=recipe.get().getBrewTime()){
                        if(craftItem(recipe.get())){
                            brewTime=0;
                            data.set(0,brewTime);
                        }
                    }
                }
            }else {
                brewTime=0;
                data.set(0,brewTime);
            }
        }else {
            brewTime=0;
            data.set(0,brewTime);
        }
        setChanged();
    }
    private Optional<ManaTeapotRecipe> getCurrentRecipe() {
        SimpleContainer inventory = new SimpleContainer(5);
        for (int i = 0; i < 5; i++) {
            inventory.setItem(i, itemStackHandler.getStackInSlot(i));
        }
        return Objects.requireNonNull(level).getRecipeManager().getRecipeFor(BotaniaRecipeTypes.MANA_TEAPOT.get(), inventory, level);
    }
    private boolean craftItem(ManaTeapotRecipe recipe){
        ItemStack result = recipe.getResultItem(Objects.requireNonNull(level).registryAccess());
        ItemStack outputSlotStack = itemStackHandler.getStackInSlot(5);
        if(outputSlotStack.isEmpty()){
            itemStackHandler.setStackInSlot(5,result.copy());
        }else if(ItemStack.isSameItemSameTags(outputSlotStack,result)&&outputSlotStack.getCount()+result.getCount()<=outputSlotStack.getMaxStackSize()){
            outputSlotStack.grow(result.getCount());
            itemStackHandler.setStackInSlot(5,outputSlotStack);
        }else {
            return false;
        }
        for (int i = 0; i < 5; i++) {
            ItemStack stack = itemStackHandler.getStackInSlot(i);
            if(!stack.isEmpty()){
                stack.shrink(1);
                itemStackHandler.setStackInSlot(i,stack.isEmpty()?ItemStack.EMPTY:stack);
            }
        }
        return true;
    }
    public void load(@NotNull CompoundTag tag) {
        super.load(tag);
        itemStackHandler.deserializeNBT(tag.getCompound("Inventory"));
        mana = tag.getInt("Mana");
        brewTime = tag.getInt("BrewTime");
    }

    @Override
    protected void saveAdditional(@NotNull CompoundTag tag) {
        super.saveAdditional(tag);
        tag.put("Inventory", itemStackHandler.serializeNBT());
        tag.putInt("BrewTime", brewTime);
        tag.putInt("Mana",mana);
    }
    private final LazyOptional<ItemStackHandler> lazyItemHandler = LazyOptional.of(() -> itemStackHandler);
    private final LazyOptional<ManaReceiver> manaReceiverCap = LazyOptional.of(()->this);
    @NotNull
    @Override
    public <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
        if (cap == ForgeCapabilities.ITEM_HANDLER) {
            return lazyItemHandler.cast();
        }
        if(cap== BotaniaForgeCapabilities.MANA_RECEIVER){
            return manaReceiverCap.cast();
        }
        return super.getCapability(cap, side);
    }

    @Override
    public void invalidateCaps() {
        super.invalidateCaps();
        lazyItemHandler.invalidate();
        manaReceiverCap.invalidate();
    }

    public ItemStackHandler getInventory() {
        return itemStackHandler;
    }

    @Override
    public Level getManaReceiverLevel() {
        return this.level;
    }

    @Override
    public BlockPos getManaReceiverPos() {
        return worldPosition;
    }

    @Override
    public int getCurrentMana() {
        return mana;
    }

    @Override
    public boolean isFull() {
        return mana>=MaxMana;
    }

    @Override
    public void receiveMana(int i) {
        mana =  Math.min(mana+i,MaxMana);
    }

    @Override
    public boolean canReceiveManaFromBursts() {
        return !isFull();
    }

}
