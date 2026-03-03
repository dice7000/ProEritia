package net.dice7000.proeritia;

import com.mojang.logging.LogUtils;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.config.ModConfigEvent;

@Mod.EventBusSubscriber(modid = ProEritia.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class PERConfig {
    public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final GeneralConfig general = new GeneralConfig(BUILDER);
    public static final ForgeConfigSpec SPEC = BUILDER.build();
    public static boolean serverFriendlyMode;
    public static int chargeLimit;

    @SubscribeEvent public static void onLoad(final ModConfigEvent.Loading event) {
        if (event.getConfig().getSpec() == SPEC) {
            LogUtils.getLogger().info("[ProEritia] Loading config...");
            serverFriendlyMode = GeneralConfig.SERVER_FRIENDLY_MODE.get();
            chargeLimit = GeneralConfig.CHARGE_LIMIT.get();
            LogUtils.getLogger().info("[ProEritia] Loaded. serverFriendlyMode: {}, chargeLimit: {}", serverFriendlyMode, chargeLimit);
        }
    }
    @SubscribeEvent public static void onConfigReload(ModConfigEvent.Reloading event) {
        if (event.getConfig().getSpec() == SPEC) {
            LogUtils.getLogger().info("[ProEritia] Reloading config...");
            serverFriendlyMode = GeneralConfig.SERVER_FRIENDLY_MODE.get();
            chargeLimit = GeneralConfig.CHARGE_LIMIT.get();
            LogUtils.getLogger().info("[ProEritia] Reloaded. serverFriendlyMode: {}, chargeLimit: {}", serverFriendlyMode, chargeLimit);
        }
    }

    public static class GeneralConfig {
        public static ForgeConfigSpec.BooleanValue SERVER_FRIENDLY_MODE = null;
        public static ForgeConfigSpec.IntValue CHARGE_LIMIT = null;

        public GeneralConfig(ForgeConfigSpec.Builder builder) {
            builder.push("Server Friendly Mode");
            SERVER_FRIENDLY_MODE = builder
                    .comment("Set Server Friendly Mode. Default: false")
                    .define("ServerFriendlyMode", true);
            CHARGE_LIMIT = builder
                    .comment("Set PER Tools charge limit. Default: 3")
                    .defineInRange("ChargeLimit", 3, 1,1000);
            builder.pop();
        }

        public static boolean getServerFriendlyMode() {
            return SERVER_FRIENDLY_MODE.get();
        }
        public static int getChargeLimit() {
            return CHARGE_LIMIT.get();
        }

        static {
        }
    }
}
