package net.dice7000.proeritia.item;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class PERMaterialItem extends Item {
    private final String itemID;
    public PERMaterialItem(String itemID) {
        super(new Properties());
        this.itemID = itemID;
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        String tooltip = "tooltip.proeritia." + itemID + ".tooltip";
        pTooltipComponents.add(Component.translatable(tooltip));

        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
    }
}
