package net.dice7000.proeritia.common.cap;

import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.util.INBTSerializable;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.ItemStackHandler;

public class PERArmorCapabilityProvider implements ICapabilityProvider, INBTSerializable<CompoundTag> {
    private final ItemStackHandler handler/* = new ItemStackHandler(9)*/;
    private final LazyOptional<ItemStackHandler> optional/* = LazyOptional.of(() -> handler)*/;

    public PERArmorCapabilityProvider(ItemStack stack) {
        this.handler = new ArmorItemHandler(3, (ArmorItem) stack.getItem());
        this.optional = LazyOptional.of(() -> handler);
    }

    @Override public <T> LazyOptional<T> getCapability(Capability<T> cap, Direction side) {
        return cap == ForgeCapabilities.ITEM_HANDLER ? optional.cast() : LazyOptional.empty();
    }

    @Override public CompoundTag serializeNBT() {
        return handler.serializeNBT();
    }
    @Override public void deserializeNBT(CompoundTag nbt) {
        handler.deserializeNBT(nbt);
    }
}