package net.dice7000.proeritia.registry;

import net.dice7000.proeritia.ProEritia;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ProEritiaCTab {
    public static final DeferredRegister<CreativeModeTab> PROERITIA_CTAB =
            DeferredRegister.create
                    (Registries.CREATIVE_MODE_TAB, ProEritia.MOD_ID);

    public static final RegistryObject<CreativeModeTab> PROERITIA_TAB = PROERITIA_CTAB.register
            ("d7btab", () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(ProEritiaItems.KLEINSTAR_EXTEND.get()))
                    .title(Component.literal("ProEritia"))
                    .displayItems(((pParameters, pOutput) -> {
                        pOutput.accept(ProEritiaItems.KLEINSTAR_EXTEND.get());
                        pOutput.accept(ProEritiaItems.KLEINBINARYSTAR_EXTEND.get());
                        //
                        pOutput.accept(ProEritiaItems.INF_PROEST.get());
                        pOutput.accept(ProEritiaItems.INF_BINARY_PROEST.get());
                        //
                        pOutput.accept(ProEritiaItems.COMPRESS_KLEINSTAR_EXTEND.get());
                        pOutput.accept(ProEritiaItems.COMPRESS_INF_CATALYST.get());
                        pOutput.accept(ProEritiaItems.COMPRESS_INF_PROEST.get());
                        pOutput.accept(ProEritiaItems.COMPRESS_INF_BINARY_PROEST.get());
                        pOutput.accept(ProEritiaItems.ULTRACOMPRESS_KLEINSTAR_EXTEND.get());
                        pOutput.accept(ProEritiaItems.ULTRACOMPRESS_INF_CATALYST.get());
                        pOutput.accept(ProEritiaItems.ULTRACOMPRESS_INF_PROEST.get());
                        pOutput.accept(ProEritiaItems.ULTRACOMPRESS_INF_BINARY_PROEST.get());
                        pOutput.accept(ProEritiaItems.GRAVITATIONAL_COLLAPSED_STAR.get());
                        //
                        pOutput.accept(ProEritiaItems.KLEIN_STAR_CLASTER.get());
                        pOutput.accept(ProEritiaItems.INFINITE_STAR.get());
                        //
                        pOutput.accept(ProEritiaItems.KSE_PICKAXE.get());
                        pOutput.accept(ProEritiaItems.KSE_AXE.get());
                        pOutput.accept(ProEritiaItems.KSE_SHOVEL.get());
                        pOutput.accept(ProEritiaItems.KSE_HOE.get());
                        pOutput.accept(ProEritiaItems.KSE_SHEARS.get());
                        pOutput.accept(ProEritiaItems.KSE_HAMMER.get());
                        pOutput.accept(ProEritiaItems.KSE_SWORD.get());
                        pOutput.accept(ProEritiaItems.KSE_MORNINGSTAR.get());
                        pOutput.accept(ProEritiaItems.KSE_KATAR.get());
                        //
                        pOutput.accept(ProEritiaItems.IFP_PICKAXE.get());
                        pOutput.accept(ProEritiaItems.IFP_AXE.get());
                        pOutput.accept(ProEritiaItems.IFP_SHOVEL.get());
                        pOutput.accept(ProEritiaItems.IFP_HOE.get());
                        pOutput.accept(ProEritiaItems.IFP_SHEARS.get());
                        pOutput.accept(ProEritiaItems.IFP_HAMMER.get());
                        pOutput.accept(ProEritiaItems.IFP_SWORD.get());
                        pOutput.accept(ProEritiaItems.IFP_MORNINGSTAR.get());
                        pOutput.accept(ProEritiaItems.IFP_KATAR.get());
                        //
                        pOutput.accept(ProEritiaItems.GCS_PICKAXE.get());
                        pOutput.accept(ProEritiaItems.GCS_AXE.get());
                        pOutput.accept(ProEritiaItems.GCS_SHOVEL.get());
                        pOutput.accept(ProEritiaItems.GCS_HOE.get());
                        pOutput.accept(ProEritiaItems.GCS_SHEARS.get());
                        pOutput.accept(ProEritiaItems.GCS_HAMMER.get());
                        pOutput.accept(ProEritiaItems.GCS_SWORD.get());
                        pOutput.accept(ProEritiaItems.GCS_MORNINGSTAR.get());
                        pOutput.accept(ProEritiaItems.GCS_KATAR.get());
                        //
                        pOutput.accept(ProEritiaItems.INF_PICKAXE.get());
                        pOutput.accept(ProEritiaItems.INF_AXE.get());
                        pOutput.accept(ProEritiaItems.INF_SHOVEL.get());
                        pOutput.accept(ProEritiaItems.INF_HOE.get());
                        pOutput.accept(ProEritiaItems.INF_SHEARS.get());
                        pOutput.accept(ProEritiaItems.INF_HAMMER.get());
                        pOutput.accept(ProEritiaItems.INF_SWORD.get());
                        pOutput.accept(ProEritiaItems.INF_MORNINGSTAR.get());
                        pOutput.accept(ProEritiaItems.INF_KATAR.get());
                    })).build());

    public static void register(IEventBus eventBus) {
        PROERITIA_CTAB.register(eventBus);
    }
}