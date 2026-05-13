package net.dice7000.proeritia;

import net.dice7000.proeritia.client.screen.StorageScreen;
import net.dice7000.proeritia.common.registry.PEREMCHandler;
import net.dice7000.proeritia.common.registry.PERCTab;
import net.dice7000.proeritia.common.registry.PERItems;
import net.dice7000.proeritia.common.registry.PERMenu;
//import net.dice7000.proeritia.compat.tic.PERTiCCompatRegistry;
import net.dice7000.proeritia.sync.PERNetwork;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(ProEritia.MOD_ID)
public class ProEritia {
    public static final String MOD_ID = "proeritia";

    public ProEritia(FMLJavaModLoadingContext context) {
        IEventBus modEventBus = context.getModEventBus();
        modEventBus.addListener(this::commonSetup);
        PERItems.register(modEventBus); PERCTab.register(modEventBus); PERMenu.register(modEventBus);
        this.modCompatRegister(modEventBus);
        modEventBus.addListener(this::addCreative);
        MinecraftForge.EVENT_BUS.register(this);
        context.registerConfig(ModConfig.Type.COMMON, PERConfig.SPEC);
    }

    private void modCompatRegister(IEventBus modEventBus) {
        //if (isModLoaded("tconstruct")) PERTiCCompatRegistry.register(modEventBus);
    }

    public static ResourceLocation PERLocation(String path) {
        return ResourceLocation.fromNamespaceAndPath(MOD_ID, path);
    }

    public static boolean isModLoaded(String modid) {
        return ModList.get().isLoaded(modid);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        PERNetwork.register();
        PEREMCHandler.registerEMC();
    }
    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == PERCTab.PROERITIA_TAB.getKey() && isModLoaded("tconstruct")) {
            //event.accept(PERTiCCompatRegistry.MODIFIABLE_KATAR);
        }
    }
    @SubscribeEvent public void onServerStarting(ServerStartingEvent event) {
    }
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent public static void onClientSetup(FMLClientSetupEvent event) {
            MenuScreens.register(PERMenu.STORAGE_MENU.get(), StorageScreen::new);
        }
    }
}
