package net.dice7000.proeritia;

import net.dice7000.proeritia.registry.PEREMCHandler;
import net.dice7000.proeritia.registry.PERCTab;
import net.dice7000.proeritia.registry.PERItems;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
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
        PERItems.register(modEventBus); PERCTab.register(modEventBus);
        MinecraftForge.EVENT_BUS.register(this);
        context.registerConfig(ModConfig.Type.COMMON, Config.SPEC);}

    private void commonSetup(final FMLCommonSetupEvent event) {
        PEREMCHandler.registerEMC();
    }
    @SubscribeEvent public void onServerStarting(ServerStartingEvent event) {
    }
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents { @SubscribeEvent public static void onClientSetup(FMLClientSetupEvent event) {} }
}
