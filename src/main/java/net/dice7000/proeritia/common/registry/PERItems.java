package net.dice7000.proeritia.common.registry;

import net.dice7000.proeritia.ProEritia;
import net.dice7000.proeritia.common.item.tool.*;
import net.dice7000.proeritia.common.item.*;
import net.dice7000.proeritia.common.item.armor.*;
import net.dice7000.proeritia.common.item.tool.*;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.NotNull;

import java.util.function.Supplier;

import static net.dice7000.proeritia.common.registry.PERMatterType.*;

import static java.lang.Integer.MAX_VALUE;

public class PERItems {
    public static final DeferredRegister<Item> PROERITIA_ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, ProEritia.MOD_ID);

    public static final RegistryObject<Item> KLEINSTAR_EXTEND;
    public static final RegistryObject<Item> KLEINBINARYSTAR_EXTEND;
    public static final RegistryObject<Item> INF_PROEST;
    public static final RegistryObject<Item> INF_BINARY_PROEST;

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

    public static final RegistryObject<Item> KSE_HELMET;
    public static final RegistryObject<Item> KSE_CHEST;
    public static final RegistryObject<Item> KSE_LEGGINGS;
    public static final RegistryObject<Item> KSE_BOOTS;
    public static final RegistryObject<Item> IFP_HELMET;
    public static final RegistryObject<Item> IFP_CHEST;
    public static final RegistryObject<Item> IFP_LEGGINGS;
    public static final RegistryObject<Item> IFP_BOOTS;
    public static final RegistryObject<Item> GCS_HELMET;
    public static final RegistryObject<Item> GCS_CHEST;
    public static final RegistryObject<Item> GCS_LEGGINGS;
    public static final RegistryObject<Item> GCS_BOOTS;
    public static final RegistryObject<Item> INF_HELMET;
    public static final RegistryObject<Item> INF_CHEST;
    public static final RegistryObject<Item> INF_LEGGINGS;
    public static final RegistryObject<Item> INF_BOOTS;

    static {
        //material
        KLEINSTAR_EXTEND                = PROERITIA_ITEMS.register("klein_star_extend"                 , () -> new PERMaterialItem("klein_star_extend"                ));
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
        //tool
        KSE_PICKAXE                     = PROERITIA_ITEMS.register("kse_pickaxe"                       , () -> new PERPickaxe      (KSE));
        KSE_AXE                         = PROERITIA_ITEMS.register("kse_axe"                           , () -> new PERAxe(KSE));
        KSE_SHOVEL                      = PROERITIA_ITEMS.register("kse_shovel"                        , () -> new PERShovel(KSE));
        KSE_HOE                         = PROERITIA_ITEMS.register("kse_hoe"                           , () -> new PERHoe          (KSE));
        KSE_SHEARS                      = PROERITIA_ITEMS.register("kse_shears"                        , () -> new PERShears(KSE));
        KSE_HAMMER                      = PROERITIA_ITEMS.register("kse_hammer"                        , () -> new PERHammer(KSE));
        KSE_SWORD                       = PROERITIA_ITEMS.register("kse_sword"                         , () -> new PERSword(KSE));
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
        //armor
        KSE_HELMET                      = PROERITIA_ITEMS.register("kse_helmet"                        , () -> new PERHelmet(KSE));
        KSE_CHEST                       = PROERITIA_ITEMS.register("kse_chest"                         , () -> new PERChestplate(KSE));
        KSE_LEGGINGS                    = PROERITIA_ITEMS.register("kse_leggings"                      , () -> new PERLeggings(KSE));
        KSE_BOOTS                       = PROERITIA_ITEMS.register("kse_boots"                         , () -> new PERBoots(KSE));
        IFP_HELMET                      = PROERITIA_ITEMS.register("ifp_helmet"                        , () -> new PERHelmet       (IFP));
        IFP_CHEST                       = PROERITIA_ITEMS.register("ifp_chest"                         , () -> new PERChestplate   (IFP));
        IFP_LEGGINGS                    = PROERITIA_ITEMS.register("ifp_leggings"                      , () -> new PERLeggings     (IFP));
        IFP_BOOTS                       = PROERITIA_ITEMS.register("ifp_boots"                         , () -> new PERBoots        (IFP));
        GCS_HELMET                      = PROERITIA_ITEMS.register("gcs_helmet"                        , () -> new PERHelmet       (GCS));
        GCS_CHEST                       = PROERITIA_ITEMS.register("gcs_chest"                         , () -> new PERChestplate   (GCS));
        GCS_LEGGINGS                    = PROERITIA_ITEMS.register("gcs_leggings"                      , () -> new PERLeggings     (GCS));
        GCS_BOOTS                       = PROERITIA_ITEMS.register("gcs_boots"                         , () -> new PERBoots        (GCS));
        INF_HELMET                      = PROERITIA_ITEMS.register("inf_helmet"                        , () -> new PERHelmet       (INF));
        INF_CHEST                       = PROERITIA_ITEMS.register("inf_chest"                         , () -> new PERChestplate   (INF));
        INF_LEGGINGS                    = PROERITIA_ITEMS.register("inf_leggings"                      , () -> new PERLeggings     (INF));
        INF_BOOTS                       = PROERITIA_ITEMS.register("inf_boots"                         , () -> new PERBoots        (INF));
    }

    public static final RegistryObject<Item> TEST = PROERITIA_ITEMS.register("test", () -> new EffectToggleItem(new Item.Properties())); //test item
    public static final RegistryObject<Item> TE = PROERITIA_ITEMS.register("testa", TestArmor::new); //test item

    public static void register(IEventBus eventBus) {
        PROERITIA_ITEMS.register(eventBus);
    }

    public enum PERArmorMaterial implements ArmorMaterial {
        KSE("kse",      1000, new int[]{       10,        13,        15,        13},       150,
                SoundEvents.ARMOR_EQUIP_NETHERITE,     10.0F, 0.5F, () -> Ingredient.of(KLEINSTAR_EXTEND.get())),
        IFP("ifp",     10000, new int[]{      100,       130,       150,       130},      1500,
                SoundEvents.ARMOR_EQUIP_NETHERITE,    100.0F, 1.0F, () -> Ingredient.of(INF_PROEST.get())),
        GCS("gcs",  10000000, new int[]{   100000,    130000,    150000,    130000},   1500000,
                SoundEvents.ARMOR_EQUIP_NETHERITE, 100000.0F, 1.0F, () -> Ingredient.of(GRAVITATIONAL_COLLAPSED_STAR.get())),
        INF("inf", MAX_VALUE, new int[]{MAX_VALUE, MAX_VALUE, MAX_VALUE, MAX_VALUE}, MAX_VALUE,
                SoundEvents.ARMOR_EQUIP_NETHERITE, MAX_VALUE, 1.0F, () -> Ingredient.of(INFINITE_STAR.get()));

        private final String name;
        private final int durabilityMultiplier;
        private final int[] protectionAmount;
        private final int enchantmentValue;
        private final SoundEvent sound;
        private final float toughness;
        private final float knockbackResistance;
        private final Supplier<Ingredient> repairIngredient;
        private static final int[] baseDurability = {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE};

        PERArmorMaterial(String pName, int pDurabilityMultiplier, int[] pProtectionAmount, int pEnchantmentValue, SoundEvent pSound, float pToughness, float pKnockbackResistance, Supplier<Ingredient> pRepairIngredient) {
            this.name = pName;
            this.durabilityMultiplier = pDurabilityMultiplier;
            this.protectionAmount = pProtectionAmount;
            this.enchantmentValue = pEnchantmentValue;
            this.sound = pSound;
            this.toughness = pToughness;
            this.knockbackResistance = pKnockbackResistance;
            this.repairIngredient = pRepairIngredient;
        }

        public static PERArmorMaterial getTypeOnMatterType(PERMatterType matterType) {
            PERArmorMaterial returnValue = null;
            switch (matterType) {
                case KSE -> returnValue = KSE;
                case IFP -> returnValue = IFP;
                case GCS -> returnValue = GCS;
                case INF -> returnValue = INF;
            }
            return returnValue;
        }

        @Override public int getDurabilityForType(ArmorItem.Type pType) {
            return baseDurability[pType.ordinal()] * durabilityMultiplier;
        }
        @Override public int getDefenseForType(ArmorItem.Type pType) {
            return protectionAmount[pType.ordinal()];
        }
        @Override public int getEnchantmentValue() {
            return enchantmentValue;
        }
        @Override public @NotNull SoundEvent getEquipSound() {
            return sound;
        }
        @Override public @NotNull Ingredient getRepairIngredient() {
            return repairIngredient.get();
        }
        @Override public @NotNull String getName() {
            return ProEritia.MOD_ID + ":" + name;
        }
        @Override public float getToughness() {
            return toughness;
        }
        @Override public float getKnockbackResistance() {
            return knockbackResistance;
        }
    }
}
