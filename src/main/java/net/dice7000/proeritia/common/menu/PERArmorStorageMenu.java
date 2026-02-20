package net.dice7000.proeritia.common.menu;

import net.dice7000.proeritia.common.registry.PERMenu;
import net.dice7000.proeritia.sync.PERNetwork;
import net.dice7000.proeritia.sync.SyncPERArmorStoragePacket;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.items.ItemStackHandler;
import net.minecraftforge.items.SlotItemHandler;

public class PERArmorStorageMenu extends AbstractContainerMenu {
    public final ItemStackHandler handler;
    public PERArmorStorageMenu(int id, Inventory playerInv, ItemStack stack) {
        super(PERMenu.STORAGE_MENU.get(), id);
        this.handler = (ItemStackHandler) stack.getCapability(ForgeCapabilities.ITEM_HANDLER).orElseThrow(() -> new IllegalStateException("No handler"));

        if (!playerInv.player.level().isClientSide) {
            PERNetwork.sendToPlayer(new SyncPERArmorStoragePacket(id, handler.serializeNBT()), (ServerPlayer) playerInv.player);
        }

        for (int x = 0; x < 3; x++) {
            this.addSlot(new SlotItemHandler(handler, x, 62 + x * 18, 17 + 18));
        }
        addPlayerInventory(playerInv);
    }
    private void addPlayerInventory(Inventory playerInv) {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 9; col++) {
                this.addSlot(new Slot( playerInv, col + row * 9 + 9, 8 + col * 18, 84 + row * 18 ));
            }
        }
        for (int col = 0; col < 9; col++) {
            this.addSlot(new Slot( playerInv, col, 8 + col * 18, 142 ));
        }
    }

    @Override public ItemStack quickMoveStack(Player player, int index) {
        ItemStack itemstack;
        Slot slot = this.slots.get(index);
        if (!slot.hasItem()) return ItemStack.EMPTY;
        ItemStack stack = slot.getItem();
        itemstack = stack.copy();
        int containerSlots = 3;
        int invStart = containerSlots;
        int invEnd = invStart + 27;
        int hotbarStart = invEnd;
        int hotbarEnd = hotbarStart + 9;

        if (index < containerSlots) {
            if (!this.moveItemStackTo(stack, invStart, hotbarEnd, true)) {
                return ItemStack.EMPTY;
            }
        } else if (index < hotbarStart) {
            if (stack.getItem() instanceof ArmorItem armor) {
                if (!this.moveItemStackTo(stack, 0, 3, false)) {
                    return ItemStack.EMPTY;
                }
            } else if (!this.moveItemStackTo(stack, hotbarStart, hotbarEnd, false)) {
                return ItemStack.EMPTY;
            }
        } else {
            if (stack.getItem() instanceof ArmorItem armor) {
                if (!this.moveItemStackTo(stack, 0, 3, false)) {
                    return ItemStack.EMPTY;
                }
            } else if (!this.moveItemStackTo(stack, invStart, invEnd, false)) {
                return ItemStack.EMPTY;
            }
        }
        if (stack.isEmpty()) {
            slot.set(ItemStack.EMPTY);
        } else {
            slot.setChanged();
        }
        return itemstack;
    }


    @Override public boolean stillValid(Player player) {
        return true;
    }
}