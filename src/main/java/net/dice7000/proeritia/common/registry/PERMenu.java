package net.dice7000.proeritia.common.registry;

import net.dice7000.proeritia.ProEritia;
import net.dice7000.proeritia.common.menu.PERArmorStorageMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class PERMenu {
    public static final DeferredRegister<MenuType<?>> MENUS = DeferredRegister.create(ForgeRegistries.MENU_TYPES, ProEritia.MOD_ID);
    public static final RegistryObject<MenuType<PERArmorStorageMenu>> STORAGE_MENU = MENUS.register("per_armor_menu", () ->
            IForgeMenuType.create((id, inv, buf) -> {
                boolean mainHand = buf.readBoolean();
                ItemStack stack = mainHand ? inv.player.getMainHandItem() : inv.player.getOffhandItem();
                return new PERArmorStorageMenu(id, inv, stack);
            }));

    public static void register(IEventBus modEventBus) {
        MENUS.register(modEventBus);
    }
}
