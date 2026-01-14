package net.dice7000.proeritia.registry;

import moze_intel.projecte.PECore;
import moze_intel.projecte.gameObjs.PETags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.common.TierSortingRegistry;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Collections;
import java.util.List;

public enum PERMatterType implements StringRepresentable, Tier {
    KSE("klein_star",                      8.0F,    18.0F,   20,     6,      8, PETags.Blocks.NEEDS_RED_MATTER_TOOL, Tiers.NETHERITE, null, MapColor.COLOR_YELLOW    ),
    IFP("inf_proest",                     30.0F,    30.0F,   50,    10,     30, PETags.Blocks.NEEDS_RED_MATTER_TOOL, Tiers.NETHERITE, null, MapColor.COLOR_RED       ),
    GCS("gravitional_collapsed_star",     60.0F,    50.0F,  100,    20,     60, PETags.Blocks.NEEDS_RED_MATTER_TOOL, Tiers.NETHERITE, null, MapColor.COLOR_BLACK     ),
    INF("infinite_star",              100000.0F, 50000.0F, 1000,   100, 100000, PETags.Blocks.NEEDS_RED_MATTER_TOOL, Tiers.NETHERITE, null, MapColor.TERRACOTTA_WHITE);

    private final String name;
    private final float attackDamage;
    private final float efficiency;
    private final int damageOnregistry;
    private final int chargeModifier;
    private final int harvestLevel;
    private final TagKey<Block> neededTag;
    private final MapColor mapColor;

    PERMatterType(String name, float attackDamage, float efficiency,
                  int damageOnregistry, int chargeModifier, int harvestLevel,
                  @Nullable TagKey<Block> neededTag, Tier previous, ResourceLocation next, MapColor mapColor) {
        this.name = name;
        this.attackDamage = attackDamage;
        this.efficiency = efficiency;
        this.damageOnregistry = damageOnregistry;
        this.chargeModifier = chargeModifier;
        this.harvestLevel = harvestLevel;
        this.neededTag = neededTag;
        this.mapColor = mapColor;
        TierSortingRegistry.registerTier(this, PECore.rl(name), List.of(previous), next == null ? Collections.emptyList() : List.of(next));
    }

    public @NotNull String getSerializedName() {
        return this.name;
    }
    public String toString() {
        return this.getSerializedName();
    }
    public int getUses() {
        return 0;
    }
    public int getChargeModifier() {
        return this.chargeModifier;
    }
    public float getSpeed() {
        return this.efficiency;
    }
    public float getAttackDamageBonus() {
        return this.attackDamage;
    }
    public int getLevel() {
        return this.harvestLevel;
    }
    public int getEnchantmentValue() {
        return 0;
    }
    public @NotNull Ingredient getRepairIngredient() {
        return Ingredient.EMPTY;
    }
    public MapColor getMapColor() {
        return this.mapColor;
    }
    public int getMatterTier() {
        return this.ordinal();
    }
    public @NotNull TagKey<Block> getTag() {
        return this.neededTag;
    }
    public int getDamageOnregistry() {
        return damageOnregistry;
    }
}
