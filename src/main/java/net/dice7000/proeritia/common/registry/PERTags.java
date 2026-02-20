package net.dice7000.proeritia.common.registry;

import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

import static net.dice7000.proeritia.ProEritia.PERLocation;

public class PERTags {
    /**
     * matter type of armor
     * <p>
     * KSE = above {@code PERMatterType.KSE}
     * <p>
     * IFP = above {@code PERMatterType.IFP}
     * <p>
     * GCS = above {@code PERMatterType.GCS}
     * <p>
     * INF = {@code PERMatterType.INF}
     *
     * @see PERItems
     * @see PERMatterType
     */
    public static final TagKey<Item> ARMOR_KSE_TIER = TagKey.create(Registries.ITEM, PERLocation("armor_kse_tier"));
    public static final TagKey<Item> ARMOR_IFP_TIER = TagKey.create(Registries.ITEM, PERLocation("armor_ifp_tier"));
    public static final TagKey<Item> ARMOR_GCS_TIER = TagKey.create(Registries.ITEM, PERLocation("armor_gcs_tier"));
    public static final TagKey<Item> ARMOR_INF_TIER = TagKey.create(Registries.ITEM, PERLocation("armor_inf_tier"));
}