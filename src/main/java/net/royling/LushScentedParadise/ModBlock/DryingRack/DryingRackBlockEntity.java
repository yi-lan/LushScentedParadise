package net.royling.LushScentedParadise.ModBlock.DryingRack;

import net.minecraft.core.BlockPos;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.royling.LushScentedParadise.Registry.ModBlockEntities;
import net.royling.LushScentedParadise.Registry.ModRecipeTypes;

import java.util.Arrays;


public class DryingRackBlockEntity extends BlockEntity {
    public static final int SLOT_COUNT=9;
    public final NonNullList<ItemStack> items = NonNullList.withSize(SLOT_COUNT,ItemStack.EMPTY);
    public int[] dryingProgress = new int[SLOT_COUNT];

    public DryingRackBlockEntity(BlockPos pPos, BlockState pBlockState) {
        super(ModBlockEntities.DRYING_RACK.get(), pPos, pBlockState);
    }

    public boolean addItem(ItemStack stack){
        for(int i =0;i<items.size();i++){
            if(items.get(i).isEmpty()){
                items.set(i,new ItemStack(stack.getItem(),1));
                dryingProgress[i] =0;
                setChanged();
                return true;
            }
        }
        return false;
    }
    public void ejectAllItems(Level level, BlockPos pos){
        for(int i=0;i<items.size();i++){
            if(!items.get(i).isEmpty()){
                ItemEntity entity = new ItemEntity(level,
                        pos.getX()+0.5,
                        pos.getY()+0.7,
                        pos.getZ()+0.5
                        ,items.get(i));
                level.addFreshEntity(entity);
                items.set(i,ItemStack.EMPTY);
                dryingProgress[i]=0;
            }
        }
    }
    public void ejectLastItem(Level level,BlockPos pos){
        for (int i = items.size()-1;i>=0;i--){
            ItemStack stack = items.get(i);
            if(!stack.isEmpty()){
                ItemEntity entity = new ItemEntity(level,pos.getX()+0.5,
                        pos.getY()+0.7,
                        pos.getZ()+0.5,
                        stack.copy());
                level.addFreshEntity(entity);
                items.set(i,ItemStack.EMPTY);
                dryingProgress[i]=0;
                setChanged();
                return;
            }
        }
    }
    public void tick(){
        for(int i = 0;i<SLOT_COUNT;i++){
            ItemStack stack = items.get(i);
            if(!stack.isEmpty()){
                SimpleContainer container = new SimpleContainer(stack);
                int finalI = i;
                level.getRecipeManager()
                         .getRecipeFor(ModRecipeTypes.DRYING_RECIPE.get(),new SimpleContainer(stack),level)
                         .ifPresent(recipe->{
                             if(dryingProgress[finalI]<recipe.getDryingTime()){
                                 dryingProgress[finalI]++;
                             }else {
                                 items.set(finalI,recipe.assemble(container,level.registryAccess()));
                                 dryingProgress[finalI]=0;
                             }
                             setChanged();
                         });
            }
        }
    }
    @Override
    public void onLoad() {
        super.onLoad();
        if (level != null && !level.isClientSide) {
            level.scheduleTick(worldPosition, getBlockState().getBlock(), 1);
        }
    }

    @Override
    public void load(CompoundTag pTag) {
        super.load(pTag);
        items.clear();
        Arrays.fill(dryingProgress,0);
        ListTag itemList = pTag.getList("Items",10);
        for(int i =0;i<itemList.size();i++){
            CompoundTag itemTag = itemList.getCompound(i);
            int slot = itemTag.getInt("Slot");
            if(slot>=0&&slot<SLOT_COUNT){
                items.set(slot,ItemStack.of(itemTag));
                dryingProgress[slot] = itemTag.getInt("DryingProgress");
            }
        }
    }

    @Override
    protected void saveAdditional(CompoundTag pTag) {
        super.saveAdditional(pTag);
        ListTag itemList = new ListTag();
        for(int i=0;i<items.size();i++){
            if(!items.get(i).isEmpty()){
                CompoundTag itemTag = new CompoundTag();
                itemTag.putInt("Slot",i);
                items.get(i).save(itemTag);
                itemTag.putInt("DryingProgress",dryingProgress[i]);
                itemList.add(itemTag);
            }
        }
        pTag.put("Items",itemList);
    }
    @Override
    public CompoundTag getUpdateTag() {
        CompoundTag tag = new CompoundTag();
        saveAdditional(tag);
        return tag;
    }
    @Override
    public void handleUpdateTag(CompoundTag tag) {
        load(tag);
    }
    public void sync() {
        if (this.level != null && !this.level.isClientSide) {
            level.sendBlockUpdated(this.worldPosition, this.getBlockState(), this.getBlockState(), 3);
        }
    }

}
