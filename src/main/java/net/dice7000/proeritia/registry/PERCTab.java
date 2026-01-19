package net.dice7000.proeritia.registry;

import net.dice7000.proeritia.ProEritia;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class PERCTab {
    public static final DeferredRegister<CreativeModeTab> PROERITIA_CTAB =
            DeferredRegister.create
                    (Registries.CREATIVE_MODE_TAB, ProEritia.MOD_ID);

    public static final RegistryObject<CreativeModeTab> PROERITIA_TAB = PROERITIA_CTAB.register
            ("d7btab", () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(PERItems.KLEINSTAR_EXTEND.get()))
                    .title(Component.literal("ProEritia"))
                    .displayItems(((pParameters, pOutput) -> {
                        pOutput.accept(PERItems.KLEINSTAR_EXTEND.get());
                        pOutput.accept(PERItems.KLEINBINARYSTAR_EXTEND.get());
                        //
                        pOutput.accept(PERItems.INF_PROEST.get());
                        pOutput.accept(PERItems.INF_BINARY_PROEST.get());
                        //
                        pOutput.accept(PERItems.COMPRESS_KLEINSTAR_EXTEND.get());
                        pOutput.accept(PERItems.COMPRESS_INF_CATALYST.get());
                        pOutput.accept(PERItems.COMPRESS_INF_PROEST.get());
                        pOutput.accept(PERItems.COMPRESS_INF_BINARY_PROEST.get());
                        pOutput.accept(PERItems.ULTRACOMPRESS_KLEINSTAR_EXTEND.get());
                        pOutput.accept(PERItems.ULTRACOMPRESS_INF_CATALYST.get());
                        pOutput.accept(PERItems.ULTRACOMPRESS_INF_PROEST.get());
                        pOutput.accept(PERItems.ULTRACOMPRESS_INF_BINARY_PROEST.get());
                        pOutput.accept(PERItems.GRAVITATIONAL_COLLAPSED_STAR.get());
                        //
                        pOutput.accept(PERItems.KLEIN_STAR_CLASTER.get());
                        pOutput.accept(PERItems.INFINITE_STAR.get());
                        //
                        pOutput.accept(PERItems.KSE_PICKAXE.get());
                        pOutput.accept(PERItems.KSE_AXE.get());
                        pOutput.accept(PERItems.KSE_SHOVEL.get());
                        pOutput.accept(PERItems.KSE_HOE.get());
                        pOutput.accept(PERItems.KSE_SHEARS.get());
                        pOutput.accept(PERItems.KSE_HAMMER.get());
                        pOutput.accept(PERItems.KSE_SWORD.get());
                        pOutput.accept(PERItems.KSE_MORNINGSTAR.get());
                        pOutput.accept(PERItems.KSE_KATAR.get());
                        //
                        pOutput.accept(PERItems.IFP_PICKAXE.get());
                        pOutput.accept(PERItems.IFP_AXE.get());
                        pOutput.accept(PERItems.IFP_SHOVEL.get());
                        pOutput.accept(PERItems.IFP_HOE.get());
                        pOutput.accept(PERItems.IFP_SHEARS.get());
                        pOutput.accept(PERItems.IFP_HAMMER.get());
                        pOutput.accept(PERItems.IFP_SWORD.get());
                        pOutput.accept(PERItems.IFP_MORNINGSTAR.get());
                        pOutput.accept(PERItems.IFP_KATAR.get());
                        //
                        pOutput.accept(PERItems.GCS_PICKAXE.get());
                        pOutput.accept(PERItems.GCS_AXE.get());
                        pOutput.accept(PERItems.GCS_SHOVEL.get());
                        pOutput.accept(PERItems.GCS_HOE.get());
                        pOutput.accept(PERItems.GCS_SHEARS.get());
                        pOutput.accept(PERItems.GCS_HAMMER.get());
                        pOutput.accept(PERItems.GCS_SWORD.get());
                        pOutput.accept(PERItems.GCS_MORNINGSTAR.get());
                        pOutput.accept(PERItems.GCS_KATAR.get());
                        //
                        pOutput.accept(PERItems.INF_PICKAXE.get());
                        pOutput.accept(PERItems.INF_AXE.get());
                        pOutput.accept(PERItems.INF_SHOVEL.get());
                        pOutput.accept(PERItems.INF_HOE.get());
                        pOutput.accept(PERItems.INF_SHEARS.get());
                        pOutput.accept(PERItems.INF_HAMMER.get());
                        pOutput.accept(PERItems.INF_SWORD.get());
                        pOutput.accept(PERItems.INF_MORNINGSTAR.get());
                        pOutput.accept(PERItems.INF_KATAR.get());
                    })).build());

    public static void register(IEventBus eventBus) {
        PROERITIA_CTAB.register(eventBus);
    }
}