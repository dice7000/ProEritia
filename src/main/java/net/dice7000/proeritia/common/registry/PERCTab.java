package net.dice7000.proeritia.common.registry;

import net.dice7000.proeritia.ProEritia;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import static net.dice7000.proeritia.common.registry.PERItems.*;

public class PERCTab {
    public static final DeferredRegister<CreativeModeTab> PER_CTAB =
            DeferredRegister.create
                    (Registries.CREATIVE_MODE_TAB, ProEritia.MOD_ID);

    public static final RegistryObject<CreativeModeTab> PROERITIA_TAB = PER_CTAB.register
            ("d7btab", () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(KLEINSTAR_EXTEND.get()))
                    .title(Component.literal("ProEritia"))
                    .displayItems(((pParameters, pOutput) -> {
                        pOutput.accept(KLEINSTAR_EXTEND.get());
                        pOutput.accept(KLEINBINARYSTAR_EXTEND.get());
                        pOutput.accept(INF_PROEST.get());
                        pOutput.accept(INF_BINARY_PROEST.get());
                        pOutput.accept(COMPRESS_KLEINSTAR_EXTEND.get());
                        pOutput.accept(COMPRESS_INF_CATALYST.get());
                        pOutput.accept(COMPRESS_INF_PROEST.get());
                        pOutput.accept(COMPRESS_INF_BINARY_PROEST.get());
                        pOutput.accept(ULTRACOMPRESS_KLEINSTAR_EXTEND.get());
                        pOutput.accept(ULTRACOMPRESS_INF_CATALYST.get());
                        pOutput.accept(ULTRACOMPRESS_INF_PROEST.get());
                        pOutput.accept(ULTRACOMPRESS_INF_BINARY_PROEST.get());
                        pOutput.accept(GRAVITATIONAL_COLLAPSED_STAR.get());
                        pOutput.accept(KLEIN_STAR_CLASTER.get());
                        pOutput.accept(INFINITE_STAR.get());
                        //
                        pOutput.accept(KSE_PICKAXE.get());
                        pOutput.accept(KSE_AXE.get());
                        pOutput.accept(KSE_SHOVEL.get());
                        pOutput.accept(KSE_HOE.get());
                        pOutput.accept(KSE_SHEARS.get());
                        pOutput.accept(KSE_HAMMER.get());
                        pOutput.accept(KSE_SWORD.get());
                        pOutput.accept(KSE_MORNINGSTAR.get());
                        pOutput.accept(KSE_KATAR.get());
                        pOutput.accept(IFP_PICKAXE.get());
                        pOutput.accept(IFP_AXE.get());
                        pOutput.accept(IFP_SHOVEL.get());
                        pOutput.accept(IFP_HOE.get());
                        pOutput.accept(IFP_SHEARS.get());
                        pOutput.accept(IFP_HAMMER.get());
                        pOutput.accept(IFP_SWORD.get());
                        pOutput.accept(IFP_MORNINGSTAR.get());
                        pOutput.accept(IFP_KATAR.get());
                        pOutput.accept(GCS_PICKAXE.get());
                        pOutput.accept(GCS_AXE.get());
                        pOutput.accept(GCS_SHOVEL.get());
                        pOutput.accept(GCS_HOE.get());
                        pOutput.accept(GCS_SHEARS.get());
                        pOutput.accept(GCS_HAMMER.get());
                        pOutput.accept(GCS_SWORD.get());
                        pOutput.accept(GCS_MORNINGSTAR.get());
                        pOutput.accept(GCS_KATAR.get());
                        pOutput.accept(INF_PICKAXE.get());
                        pOutput.accept(INF_AXE.get());
                        pOutput.accept(INF_SHOVEL.get());
                        pOutput.accept(INF_HOE.get());
                        pOutput.accept(INF_SHEARS.get());
                        pOutput.accept(INF_HAMMER.get());
                        pOutput.accept(INF_SWORD.get());
                        pOutput.accept(INF_MORNINGSTAR.get());
                        pOutput.accept(INF_KATAR.get());
                        //
                        pOutput.accept(KSE_HELMET.get());
                        pOutput.accept(KSE_CHEST.get());
                        pOutput.accept(KSE_LEGGINGS.get());
                        pOutput.accept(KSE_BOOTS.get());
                        pOutput.accept(IFP_HELMET.get());
                        pOutput.accept(IFP_CHEST.get());
                        pOutput.accept(IFP_LEGGINGS.get());
                        pOutput.accept(IFP_BOOTS.get());
                        pOutput.accept(GCS_HELMET.get());
                        pOutput.accept(GCS_CHEST.get());
                        pOutput.accept(GCS_LEGGINGS.get());
                        pOutput.accept(GCS_BOOTS.get());
                        pOutput.accept(INF_HELMET.get());
                        pOutput.accept(INF_CHEST.get());
                        pOutput.accept(INF_LEGGINGS.get());
                        pOutput.accept(INF_BOOTS.get());

                    })).build());

    public static void register(IEventBus eventBus) {
        PER_CTAB.register(eventBus);
    }
}