package net.dice7000.proeritia.registry;

import net.dice7000.proeritia.ProEritia;
import net.dice7000.proeritia.item.*;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ProEritiaItems {
    public static final DeferredRegister<Item> PROERITIA_ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, ProEritia.MOD_ID);

    public static final RegistryObject<Item> KLEINSTAR_EXTEND = PROERITIA_ITEMS.register
            ("klein_star_extend", () -> new PERMaterialItem("klein_star_extend"));
    public static final RegistryObject<Item> KLEINBINARYSTAR_EXTEND = PROERITIA_ITEMS.register
            ("klein_binary_star_extend", () -> new PERMaterialItem("klein_binary_star_extend"));

    public static final RegistryObject<Item> KSE_PICKAXE = PROERITIA_ITEMS.register
            ("kse_pickaxe", () -> new PERPickaxe(ProEritiaMatterType.KSE, 20, new Item.Properties()));
    public static final RegistryObject<Item> KSE_AXE = PROERITIA_ITEMS.register
            ("kse_axe", () -> new PERAxe(ProEritiaMatterType.KSE, 20, new Item.Properties()));
    public static final RegistryObject<Item> KSE_SHOVEL = PROERITIA_ITEMS.register
            ("kse_shovel", () -> new PERShovel(ProEritiaMatterType.KSE, 20, new Item.Properties()));
    public static final RegistryObject<Item> KSE_HOE = PROERITIA_ITEMS.register
            ("kse_hoe", () -> new PERHoe(ProEritiaMatterType.KSE, 20, new Item.Properties()));
    public static final RegistryObject<Item> KSE_SHEARS = PROERITIA_ITEMS.register
            ("kse_shears", () -> new PERShears(ProEritiaMatterType.KSE, 20, new Item.Properties()));
    public static final RegistryObject<Item> KSE_HAMMER = PROERITIA_ITEMS.register
            ("kse_hammer", () -> new PERHammer(ProEritiaMatterType.KSE, 20, new Item.Properties()));
    public static final RegistryObject<Item> KSE_SWORD = PROERITIA_ITEMS.register
            ("kse_sword", () -> new PERSword(ProEritiaMatterType.KSE, 20, 8, new Item.Properties()));
    public static final RegistryObject<Item> KSE_MORNINGSTAR = PROERITIA_ITEMS.register
            ("kse_morning_star", () -> new PERMorningStar(ProEritiaMatterType.KSE, 20, new Item.Properties()));
    public static final RegistryObject<Item> KSE_KATAR = PROERITIA_ITEMS.register
            ("kse_katar", () -> new PERKatar(ProEritiaMatterType.KSE, 20, new Item.Properties()));

    public static final RegistryObject<Item> INF_PROEST = PROERITIA_ITEMS.register
            ("inf_proest", () -> new PERMaterialItem("inf_proest"));
    public static final RegistryObject<Item> INF_BINARY_PROEST = PROERITIA_ITEMS.register
            ("inf_binary_proest", () -> new PERMaterialItem("inf_binary_proest"));

    public static final RegistryObject<Item> IFP_PICKAXE = PROERITIA_ITEMS.register
            ("ifp_pickaxe", () -> new PERPickaxe(ProEritiaMatterType.IFP, 50, new Item.Properties()));
    public static final RegistryObject<Item> IFP_AXE = PROERITIA_ITEMS.register
            ("ifp_axe", () -> new PERAxe(ProEritiaMatterType.IFP, 50, new Item.Properties()));
    public static final RegistryObject<Item> IFP_SHOVEL = PROERITIA_ITEMS.register
            ("ifp_shovel", () -> new PERShovel(ProEritiaMatterType.IFP, 50, new Item.Properties()));
    public static final RegistryObject<Item> IFP_HOE = PROERITIA_ITEMS.register
            ("ifp_hoe", () -> new PERHoe(ProEritiaMatterType.IFP, 50, new Item.Properties()));
    public static final RegistryObject<Item> IFP_SHEARS = PROERITIA_ITEMS.register
            ("ifp_shears", () -> new PERShears(ProEritiaMatterType.IFP, 50, new Item.Properties()));
    public static final RegistryObject<Item> IFP_HAMMER = PROERITIA_ITEMS.register
            ("ifp_hammer", () -> new PERHammer(ProEritiaMatterType.IFP, 50, new Item.Properties()));
    public static final RegistryObject<Item> IFP_SWORD = PROERITIA_ITEMS.register
            ("ifp_sword", () -> new PERSword(ProEritiaMatterType.IFP, 50, 30, new Item.Properties()));
    public static final RegistryObject<Item> IFP_MORNINGSTAR = PROERITIA_ITEMS.register
            ("ifp_morning_star", () -> new PERMorningStar(ProEritiaMatterType.IFP, 50, new Item.Properties()));
    public static final RegistryObject<Item> IFP_KATAR = PROERITIA_ITEMS.register
            ("ifp_katar", () -> new PERKatar(ProEritiaMatterType.IFP, 50, new Item.Properties()));

    public static final RegistryObject<Item> COMPRESS_KLEINSTAR_EXTEND = PROERITIA_ITEMS.register
            ("compressed_klein_star_extend", () -> new PERMaterialItem("compressed_klein_star_extend"));
    public static final RegistryObject<Item> COMPRESS_INF_CATALYST = PROERITIA_ITEMS.register
            ("compressed_inf_catalyst", () -> new PERMaterialItem("compressed_inf_catalyst"));
    public static final RegistryObject<Item> COMPRESS_INF_PROEST = PROERITIA_ITEMS.register
            ("compressed_inf_proest", () -> new PERMaterialItem("compressed_inf_proest"));
    public static final RegistryObject<Item> COMPRESS_INF_BINARY_PROEST = PROERITIA_ITEMS.register
            ("compressed_inf_binary_proest", () -> new PERMaterialItem("compressed_inf_binary_proest"));
    public static final RegistryObject<Item> ULTRACOMPRESS_KLEINSTAR_EXTEND = PROERITIA_ITEMS.register
            ("ultracompressed_klein_star_extend", () -> new PERMaterialItem("ultracompressed_klein_star_extend"));
    public static final RegistryObject<Item> ULTRACOMPRESS_INF_CATALYST = PROERITIA_ITEMS.register
            ("ultracompressed_inf_catalyst", () -> new PERMaterialItem("ultracompressed_inf_catalyst"));
    public static final RegistryObject<Item> ULTRACOMPRESS_INF_PROEST = PROERITIA_ITEMS.register
            ("ultracompressed_inf_proest", () -> new PERMaterialItem("ultracompressed_inf_proest"));
    public static final RegistryObject<Item> ULTRACOMPRESS_INF_BINARY_PROEST = PROERITIA_ITEMS.register
            ("ultracompressed_inf_binary_proest", () -> new PERMaterialItem("ultracompressed_inf_binary_proest"));
    public static final RegistryObject<Item> GRAVITATIONAL_COLLAPSED_STAR = PROERITIA_ITEMS.register
            ("gravitational_collapsed_star", () -> new PERMaterialItem("gravitational_collapsed_star"));

    public static final RegistryObject<Item> GCS_PICKAXE = PROERITIA_ITEMS.register
            ("gcs_pickaxe", () -> new PERPickaxe(ProEritiaMatterType.GCS, 100, new Item.Properties()));
    public static final RegistryObject<Item> GCS_AXE = PROERITIA_ITEMS.register
            ("gcs_axe", () -> new PERAxe(ProEritiaMatterType.GCS, 100, new Item.Properties()));
    public static final RegistryObject<Item> GCS_SHOVEL = PROERITIA_ITEMS.register
            ("gcs_shovel", () -> new PERShovel(ProEritiaMatterType.GCS, 100, new Item.Properties()));
    public static final RegistryObject<Item> GCS_HOE = PROERITIA_ITEMS.register
            ("gcs_hoe", () -> new PERHoe(ProEritiaMatterType.GCS, 100, new Item.Properties()));
    public static final RegistryObject<Item> GCS_SHEARS = PROERITIA_ITEMS.register
            ("gcs_shears", () -> new PERShears(ProEritiaMatterType.GCS, 100, new Item.Properties()));
    public static final RegistryObject<Item> GCS_HAMMER = PROERITIA_ITEMS.register
            ("gcs_hammer", () -> new PERHammer(ProEritiaMatterType.GCS, 100, new Item.Properties()));
    public static final RegistryObject<Item> GCS_SWORD = PROERITIA_ITEMS.register
            ("gcs_sword", () -> new PERSword(ProEritiaMatterType.GCS, 100, 60, new Item.Properties()));
    public static final RegistryObject<Item> GCS_MORNINGSTAR = PROERITIA_ITEMS.register
            ("gcs_morning_star", () -> new PERMorningStar(ProEritiaMatterType.GCS, 100, new Item.Properties()));
    public static final RegistryObject<Item> GCS_KATAR = PROERITIA_ITEMS.register
            ("gcs_katar", () -> new PERKatar(ProEritiaMatterType.GCS, 100, new Item.Properties()));

    public static final RegistryObject<Item> KLEIN_STAR_CLASTER = PROERITIA_ITEMS.register
            ("klein_star_claster", () -> new PERMaterialItem("klein_star_claster"));
    public static final RegistryObject<Item> INFINITE_STAR = PROERITIA_ITEMS.register
            ("infinite_star", () -> new InfiniteStarItem(new Item.Properties()));

    public static final RegistryObject<Item> INF_PICKAXE = PROERITIA_ITEMS.register
            ("inf_pickaxe", () -> new PERPickaxe(ProEritiaMatterType.INF, 1000, new Item.Properties()));
    public static final RegistryObject<Item> INF_AXE = PROERITIA_ITEMS.register
            ("inf_axe", () -> new PERAxe(ProEritiaMatterType.INF, 1000, new Item.Properties()));
    public static final RegistryObject<Item> INF_SHOVEL = PROERITIA_ITEMS.register
            ("inf_shovel", () -> new PERShovel(ProEritiaMatterType.INF, 1000, new Item.Properties()));
    public static final RegistryObject<Item> INF_HOE = PROERITIA_ITEMS.register
            ("inf_hoe", () -> new PERHoe(ProEritiaMatterType.INF, 1000, new Item.Properties()));
    public static final RegistryObject<Item> INF_SHEARS = PROERITIA_ITEMS.register
            ("inf_shears", () -> new PERShears(ProEritiaMatterType.INF, 1000, new Item.Properties()));
    public static final RegistryObject<Item> INF_HAMMER = PROERITIA_ITEMS.register
            ("inf_hammer", () -> new PERHammer(ProEritiaMatterType.INF, 1000, new Item.Properties()));
    public static final RegistryObject<Item> INF_SWORD = PROERITIA_ITEMS.register
            ("inf_sword", () -> new PERSword(ProEritiaMatterType.INF, 1000, 60000, new Item.Properties()));
    public static final RegistryObject<Item> INF_MORNINGSTAR = PROERITIA_ITEMS.register
            ("inf_morning_star", () -> new PERMorningStar(ProEritiaMatterType.INF, 1000, new Item.Properties()));
    public static final RegistryObject<Item> INF_KATAR = PROERITIA_ITEMS.register
            ("inf_katar", () -> new PERKatar(ProEritiaMatterType.INF, 1000, new Item.Properties()));

    public static void register(IEventBus eventBus) {
        PROERITIA_ITEMS.register(eventBus);
    }
}
