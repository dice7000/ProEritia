package net.dice7000.proeritia.common.item.tool;

import moze_intel.projecte.gameObjs.EnumMatterType;
import moze_intel.projecte.gameObjs.items.tools.PEAxe;
import net.dice7000.proeritia.common.item.PERToolHelper;
import net.dice7000.proeritia.common.registry.PERMatterType;
import net.dice7000.proeritia.util.PERUtil;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

public class PERAxe extends PEAxe implements PERTools {
    private final PERMatterType matterType;

    public PERAxe(PERMatterType matterType) {
        super(EnumMatterType.RED_MATTER, 1, new Item.Properties());
        this.matterType = matterType;
    }

    @Override public int getNumCharges(@NotNull ItemStack stack) {
        return getNumChargesLimited(matterType);
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
}
