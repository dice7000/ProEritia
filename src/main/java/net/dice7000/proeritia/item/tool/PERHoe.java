package net.dice7000.proeritia.item.tool;

import moze_intel.projecte.gameObjs.EnumMatterType;
import moze_intel.projecte.gameObjs.items.tools.PEHoe;
import net.dice7000.proeritia.item.PERToolHelper;
import net.dice7000.proeritia.registry.PERMatterType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

public class PERHoe extends PEHoe implements PERTools {
    private final PERMatterType matterType;
    private final int numCharges;

    public PERHoe(PERMatterType matterType) {
        super(EnumMatterType.RED_MATTER, matterType.getChargeModifier(), new Item.Properties());
        this.matterType = matterType;
        this.numCharges = matterType.getChargeModifier();
    }

    public PERMatterType getMatterType() {
        return matterType;
    }

    @Override
    public float getDestroySpeed(@NotNull ItemStack stack, @NotNull BlockState state) {
        return PERToolHelper.getDestroySpeed(super.getDestroySpeed(stack, state), this.matterType, this.getCharge(stack));
    }

    @Override
    public boolean hurtEnemy(@NotNull ItemStack stack, @NotNull LivingEntity damaged, @NotNull LivingEntity damager) {
        PERToolHelper.attackWithChargeOnPER(stack, damaged, damager, 1.0F);
        return true;
    }
    public int getNumCharges() {
        return numCharges;
    }
}
