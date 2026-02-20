package net.dice7000.proeritia.client.screen;

import net.dice7000.proeritia.common.menu.PERArmorStorageMenu;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;

public class StorageScreen extends AbstractContainerScreen<PERArmorStorageMenu> {
    public StorageScreen(PERArmorStorageMenu menu, Inventory inv, Component title) {
        super(menu, inv, title);
    }

    @Override protected void renderBg(GuiGraphics gfx, float partialTicks, int mouseX, int mouseY) {
        //
    }
}