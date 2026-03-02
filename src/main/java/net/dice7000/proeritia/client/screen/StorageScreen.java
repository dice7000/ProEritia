package net.dice7000.proeritia.client.screen;

import net.dice7000.proeritia.ProEritia;
import net.dice7000.proeritia.common.menu.PERArmorStorageMenu;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

public class StorageScreen extends AbstractContainerScreen<PERArmorStorageMenu> {
    private static final ResourceLocation BG = ProEritia.PERLocation("textures/gui/per_armor_storage.png");
    public StorageScreen(PERArmorStorageMenu menu, Inventory inv, Component title) {
        super(menu, inv, title);
        this.imageWidth = 176;
        this.imageHeight = 166;
    }

    @Override protected void renderBg(GuiGraphics gfx, float partialTicks, int mouseX, int mouseY) {
        gfx.blit(BG, leftPos, topPos, 0, 0, imageWidth, imageHeight);
    }
}