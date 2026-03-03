package net.dice7000.proeritia.util;

import com.mojang.logging.LogUtils;
import net.dice7000.proeritia.common.item.armor.PERArmor;
import net.dice7000.proeritia.common.registry.PERMatterType;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.capabilities.ForgeCapabilities;

public class PERUtil {
    public static ItemStack getSlot(ItemStack storageItem, int slot) {
        if (!(storageItem.getItem() instanceof PERArmor armor && armor.getMatterType() == PERMatterType.INF)) return ItemStack.EMPTY;
        return storageItem.getCapability(ForgeCapabilities.ITEM_HANDLER).map(handler -> handler.getStackInSlot(slot)).orElse(ItemStack.EMPTY);
    }


}
