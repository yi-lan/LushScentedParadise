package net.royling.LushScentedParadise.ModBlock.TeapotBlock;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.inventory.SimpleContainerData;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;
import net.royling.LushScentedParadise.Registry.ModItems;
import net.royling.LushScentedParadise.Registry.ModMenuTypes;
import org.jetbrains.annotations.NotNull;

public class TeapotMenu extends AbstractContainerMenu {
    private final IItemHandler inventory;
    private final ContainerData data;
    public static final int SLOT_INPUT_START = 0;
    public static final int INPUT_SLOT_COUNT = 4;
    public static final int WATER_SLOT_INDEX = 4;
    public static final int OUTPUT_SLOT_INDEX = 5;
    public static final int PLAYER_INVENTORY_START = 6;
    public static final int PLAYER_INVENTORY_COUNT = 36;

    public TeapotMenu(int id, Inventory playerInventory, FriendlyByteBuf extraData) {
        this(id, playerInventory,
                (TeapotBlockEntity) playerInventory.player.level().getBlockEntity(extraData.readBlockPos()),
                new SimpleContainerData(2));
    }

    public TeapotMenu(int id, Inventory playerInventory, TeapotBlockEntity teapotBlockEntity, ContainerData data) {
        super(ModMenuTypes.TEAPOT_MENU.get(), id);
        this.inventory = teapotBlockEntity.getInventory();
        this.data = data;

        for (int i = 0; i < 4; i++) {
            this.addSlot(new SlotItemHandler(inventory, i, 30 + i * 18, 17){
                @Override
                public boolean mayPickup(Player playerIn) {
                    return true;
                }

                @Override
                public boolean mayPlace(@NotNull ItemStack stack) {
                    return true;
                }
            });
        }
        this.addSlot(new SlotItemHandler(inventory, 4, 30, 53) {

            @Override
            public boolean mayPlace(ItemStack stack) {
                return stack.is(ModItems.CLEAN_WATER.get());
            }

            @Override
            public boolean mayPickup(Player playerIn) {
                return true;
            }

        });
        this.addSlot(new SlotItemHandler(inventory, 5, 124, 35) {
            @Override
            public boolean mayPlace(ItemStack stack) {
                return false;
            }

        });

        for (int row = 0; row < 3; ++row) {
            for (int col = 0; col < 9; ++col) {
                this.addSlot(new Slot(playerInventory, col + row * 9 + 9, 8 + col * 18, 84 + row * 18));
            }
        }
        for (int col = 0; col < 9; ++col) {
            this.addSlot(new Slot(playerInventory, col, 8 + col * 18, 142));
        }

        this.addDataSlots(data);
    }

    @Override
    public boolean stillValid(Player pPlayer) {
        return true;
    }


    public int getBrewProgress() {
        int brewTime = data.get(0);
        int maxBrewTime = data.get(1);
        if(maxBrewTime <= 0){
            return 0;
        }else return (brewTime*24)/maxBrewTime;
    }
    @Override
    public ItemStack quickMoveStack(Player player, int index) {
        Slot slot = this.slots.get(index);

        if (!slot.hasItem()) {
            return ItemStack.EMPTY;
        }

        ItemStack stack = slot.getItem();
        ItemStack copy = stack.copy();

        if (index == WATER_SLOT_INDEX) {
            if (!this.moveItemStackTo(stack, PLAYER_INVENTORY_START, PLAYER_INVENTORY_START + PLAYER_INVENTORY_COUNT, false)) {
                return ItemStack.EMPTY;
            }
        }
        else if (stack.is(ModItems.CLEAN_WATER.get())) {
            if (!this.moveItemStackTo(stack, WATER_SLOT_INDEX, WATER_SLOT_INDEX + 1, false)) {
                return ItemStack.EMPTY;
            }
        }
        else if (index == OUTPUT_SLOT_INDEX) {
            if (!this.moveItemStackTo(stack, PLAYER_INVENTORY_START, PLAYER_INVENTORY_START + PLAYER_INVENTORY_COUNT, true)) {
                return ItemStack.EMPTY;
            }
        }
        else if (index < PLAYER_INVENTORY_START) {
            if (!this.moveItemStackTo(stack, PLAYER_INVENTORY_START, PLAYER_INVENTORY_START + PLAYER_INVENTORY_COUNT, true)) {
                return ItemStack.EMPTY;
            }
        }
        else {
            if (!this.moveItemStackTo(stack, SLOT_INPUT_START, SLOT_INPUT_START + INPUT_SLOT_COUNT, false)) {
                return ItemStack.EMPTY;
            }
        }

        if (stack.isEmpty()) {
            slot.set(ItemStack.EMPTY);
        } else {
            slot.setChanged();
        }

        return copy;
    }
}
