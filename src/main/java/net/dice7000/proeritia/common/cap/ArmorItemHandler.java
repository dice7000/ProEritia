package net.dice7000.proeritia.common.cap;

import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.items.ItemStackHandler;
import org.jetbrains.annotations.NotNull;

public class ArmorItemHandler extends ItemStackHandler {
    private ArmorItem.Type attachedType;

    public ArmorItemHandler(int size, ArmorItem attachedItem) {
        super(size);
        this.attachedType = attachedItem.getType();
    }
    @Override public boolean isItemValid(int slot, ItemStack stack) {
        return (stack.getItem() instanceof ArmorItem armorItem) && armorItem.getType() == attachedType;
    }
}
