package net.dice7000.proeritia.registry;

import net.dice7000.proeritia.ProEritia;
import net.dice7000.proeritia.item.*;
import net.dice7000.proeritia.item.tool.*;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import static net.dice7000.proeritia.registry.PERMatterType.KSE;
import static net.dice7000.proeritia.registry.PERMatterType.IFP;
import static net.dice7000.proeritia.registry.PERMatterType.GCS;
import static net.dice7000.proeritia.registry.PERMatterType.INF;

public class PERItems {
    public static final DeferredRegister<Item> PROERITIA_ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, ProEritia.MOD_ID);

    public static final RegistryObject<Item> KLEINSTAR_EXTEND;
    public static final RegistryObject<Item> KLEINBINARYSTAR_EXTEND;
    public static final RegistryObject<Item> INF_PROEST;
    public static final RegistryObject<Item> INF_BINARY_PROEST;

    public static final RegistryObject<Item> KSE_PICKAXE;
    public static final RegistryObject<Item> KSE_AXE;
    public static final RegistryObject<Item> KSE_SHOVEL;
    public static final RegistryObject<Item> KSE_HOE;
    public static final RegistryObject<Item> KSE_SHEARS;
    public static final RegistryObject<Item> KSE_HAMMER;
    public static final RegistryObject<Item> KSE_SWORD;
    public static final RegistryObject<Item> KSE_MORNINGSTAR;
    public static final RegistryObject<Item> KSE_KATAR;
    public static final RegistryObject<Item> IFP_PICKAXE;
    public static final RegistryObject<Item> IFP_AXE;
    public static final RegistryObject<Item> IFP_SHOVEL;
    public static final RegistryObject<Item> IFP_HOE;
    public static final RegistryObject<Item> IFP_SHEARS;
    public static final RegistryObject<Item> IFP_HAMMER;
    public static final RegistryObject<Item> IFP_SWORD;
    public static final RegistryObject<Item> IFP_MORNINGSTAR;
    public static final RegistryObject<Item> IFP_KATAR;
    public static final RegistryObject<Item> GCS_PICKAXE;
    public static final RegistryObject<Item> GCS_AXE;
    public static final RegistryObject<Item> GCS_SHOVEL;
    public static final RegistryObject<Item> GCS_HOE;
    public static final RegistryObject<Item> GCS_SHEARS;
    public static final RegistryObject<Item> GCS_HAMMER;
    public static final RegistryObject<Item> GCS_SWORD;
    public static final RegistryObject<Item> GCS_MORNINGSTAR;
    public static final RegistryObject<Item> GCS_KATAR;
    public static final RegistryObject<Item> INF_PICKAXE;
    public static final RegistryObject<Item> INF_AXE;
    public static final RegistryObject<Item> INF_SHOVEL;
    public static final RegistryObject<Item> INF_HOE;
    public static final RegistryObject<Item> INF_SHEARS;
    public static final RegistryObject<Item> INF_HAMMER;
    public static final RegistryObject<Item> INF_SWORD;
    public static final RegistryObject<Item> INF_MORNINGSTAR;
    public static final RegistryObject<Item> INF_KATAR;

    public static final RegistryObject<Item> COMPRESS_KLEINSTAR_EXTEND;
    public static final RegistryObject<Item> COMPRESS_INF_CATALYST;
    public static final RegistryObject<Item> COMPRESS_INF_PROEST;
    public static final RegistryObject<Item> COMPRESS_INF_BINARY_PROEST;
    public static final RegistryObject<Item> ULTRACOMPRESS_KLEINSTAR_EXTEND;
    public static final RegistryObject<Item> ULTRACOMPRESS_INF_CATALYST;
    public static final RegistryObject<Item> ULTRACOMPRESS_INF_PROEST;
    public static final RegistryObject<Item> ULTRACOMPRESS_INF_BINARY_PROEST;
    public static final RegistryObject<Item> GRAVITATIONAL_COLLAPSED_STAR;

    public static final RegistryObject<Item> KLEIN_STAR_CLASTER;
    public static final RegistryObject<Item> INFINITE_STAR;

    static {
        KLEINSTAR_EXTEND                = PROERITIA_ITEMS.register("klein_star_extend"                 , () -> new PERMaterialItem ("klein_star_extend"                ));
        KLEINBINARYSTAR_EXTEND          = PROERITIA_ITEMS.register("klein_binary_star_extend"          , () -> new PERMaterialItem ("klein_binary_star_extend"         ));
        INF_PROEST                      = PROERITIA_ITEMS.register("inf_proest"                        , () -> new PERMaterialItem ("inf_proest"                       ));
        INF_BINARY_PROEST               = PROERITIA_ITEMS.register("inf_binary_proest"                 , () -> new PERMaterialItem ("inf_binary_proest"                ));
        COMPRESS_KLEINSTAR_EXTEND       = PROERITIA_ITEMS.register("compressed_klein_star_extend"      , () -> new PERMaterialItem ("compressed_klein_star_extend"     ));
        COMPRESS_INF_CATALYST           = PROERITIA_ITEMS.register("compressed_inf_catalyst"           , () -> new PERMaterialItem ("compressed_inf_catalyst"          ));
        COMPRESS_INF_PROEST             = PROERITIA_ITEMS.register("compressed_inf_proest"             , () -> new PERMaterialItem ("compressed_inf_proest"            ));
        COMPRESS_INF_BINARY_PROEST      = PROERITIA_ITEMS.register("compressed_inf_binary_proest"      , () -> new PERMaterialItem ("compressed_inf_binary_proest"     ));
        ULTRACOMPRESS_KLEINSTAR_EXTEND  = PROERITIA_ITEMS.register("ultracompressed_klein_star_extend" , () -> new PERMaterialItem ("ultracompressed_klein_star_extend"));
        ULTRACOMPRESS_INF_CATALYST      = PROERITIA_ITEMS.register("ultracompressed_inf_catalyst"      , () -> new PERMaterialItem ("ultracompressed_inf_catalyst"     ));
        ULTRACOMPRESS_INF_PROEST        = PROERITIA_ITEMS.register("ultracompressed_inf_proest"        , () -> new PERMaterialItem ("ultracompressed_inf_proest"       ));
        ULTRACOMPRESS_INF_BINARY_PROEST = PROERITIA_ITEMS.register("ultracompressed_inf_binary_proest" , () -> new PERMaterialItem ("ultracompressed_inf_binary_proest"));
        GRAVITATIONAL_COLLAPSED_STAR    = PROERITIA_ITEMS.register("gravitational_collapsed_star"      , () -> new PERMaterialItem ("gravitational_collapsed_star"     ));
        KLEIN_STAR_CLASTER              = PROERITIA_ITEMS.register("klein_star_claster"                , () -> new PERMaterialItem ("klein_star_claster"               ));
        INFINITE_STAR                   = PROERITIA_ITEMS.register("infinite_star"                     ,          InfiniteStarItem::new);

        KSE_PICKAXE                     = PROERITIA_ITEMS.register("kse_pickaxe"                       , () -> new PERPickaxe      (KSE));
        KSE_AXE                         = PROERITIA_ITEMS.register("kse_axe"                           , () -> new PERAxe          (KSE));
        KSE_SHOVEL                      = PROERITIA_ITEMS.register("kse_shovel"                        , () -> new PERShovel       (KSE));
        KSE_HOE                         = PROERITIA_ITEMS.register("kse_hoe"                           , () -> new PERHoe          (KSE));
        KSE_SHEARS                      = PROERITIA_ITEMS.register("kse_shears"                        , () -> new PERShears       (KSE));
        KSE_HAMMER                      = PROERITIA_ITEMS.register("kse_hammer"                        , () -> new PERHammer       (KSE));
        KSE_SWORD                       = PROERITIA_ITEMS.register("kse_sword"                         , () -> new PERSword        (KSE));
        KSE_MORNINGSTAR                 = PROERITIA_ITEMS.register("kse_morning_star"                  , () -> new PERMorningStar  (KSE));
        KSE_KATAR                       = PROERITIA_ITEMS.register("kse_katar"                         , () -> new PERKatar        (KSE));
        IFP_PICKAXE                     = PROERITIA_ITEMS.register("ifp_pickaxe"                       , () -> new PERPickaxe      (IFP));
        IFP_AXE                         = PROERITIA_ITEMS.register("ifp_axe"                           , () -> new PERAxe          (IFP));
        IFP_SHOVEL                      = PROERITIA_ITEMS.register("ifp_shovel"                        , () -> new PERShovel       (IFP));
        IFP_HOE                         = PROERITIA_ITEMS.register("ifp_hoe"                           , () -> new PERHoe          (IFP));
        IFP_SHEARS                      = PROERITIA_ITEMS.register("ifp_shears"                        , () -> new PERShears       (IFP));
        IFP_HAMMER                      = PROERITIA_ITEMS.register("ifp_hammer"                        , () -> new PERHammer       (IFP));
        IFP_SWORD                       = PROERITIA_ITEMS.register("ifp_sword"                         , () -> new PERSword        (IFP));
        IFP_MORNINGSTAR                 = PROERITIA_ITEMS.register("ifp_morning_star"                  , () -> new PERMorningStar  (IFP));
        IFP_KATAR                       = PROERITIA_ITEMS.register("ifp_katar"                         , () -> new PERKatar        (IFP));
        GCS_PICKAXE                     = PROERITIA_ITEMS.register("gcs_pickaxe"                       , () -> new PERPickaxe      (GCS));
        GCS_AXE                         = PROERITIA_ITEMS.register("gcs_axe"                           , () -> new PERAxe          (GCS));
        GCS_SHOVEL                      = PROERITIA_ITEMS.register("gcs_shovel"                        , () -> new PERShovel       (GCS));
        GCS_HOE                         = PROERITIA_ITEMS.register("gcs_hoe"                           , () -> new PERHoe          (GCS));
        GCS_SHEARS                      = PROERITIA_ITEMS.register("gcs_shears"                        , () -> new PERShears       (GCS));
        GCS_HAMMER                      = PROERITIA_ITEMS.register("gcs_hammer"                        , () -> new PERHammer       (GCS));
        GCS_SWORD                       = PROERITIA_ITEMS.register("gcs_sword"                         , () -> new PERSword        (GCS));
        GCS_MORNINGSTAR                 = PROERITIA_ITEMS.register("gcs_morning_star"                  , () -> new PERMorningStar  (GCS));
        GCS_KATAR                       = PROERITIA_ITEMS.register("gcs_katar"                         , () -> new PERKatar        (GCS));
        INF_PICKAXE                     = PROERITIA_ITEMS.register("inf_pickaxe"                       , () -> new PERPickaxe      (INF));
        INF_AXE                         = PROERITIA_ITEMS.register("inf_axe"                           , () -> new PERAxe          (INF));
        INF_SHOVEL                      = PROERITIA_ITEMS.register("inf_shovel"                        , () -> new PERShovel       (INF));
        INF_HOE                         = PROERITIA_ITEMS.register("inf_hoe"                           , () -> new PERHoe          (INF));
        INF_SHEARS                      = PROERITIA_ITEMS.register("inf_shears"                        , () -> new PERShears       (INF));
        INF_HAMMER                      = PROERITIA_ITEMS.register("inf_hammer"                        , () -> new PERHammer       (INF));
        INF_SWORD                       = PROERITIA_ITEMS.register("inf_sword"                         , () -> new PERSword        (INF));
        INF_MORNINGSTAR                 = PROERITIA_ITEMS.register("inf_morning_star"                  , () -> new PERMorningStar  (INF));
        INF_KATAR                       = PROERITIA_ITEMS.register("inf_katar"                         , () -> new PERKatar        (INF));
    }

    public static final RegistryObject<Item> TEST = PROERITIA_ITEMS.register("test", () -> new EffectToggleItem(new Item.Properties())); //test item

    public static void register(IEventBus eventBus) {
        PROERITIA_ITEMS.register(eventBus);
    }
}
