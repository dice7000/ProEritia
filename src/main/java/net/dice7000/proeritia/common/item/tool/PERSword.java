package net.dice7000.proeritia.common.item.tool;

import moze_intel.projecte.gameObjs.EnumMatterType;
import moze_intel.projecte.gameObjs.PETags;
import moze_intel.projecte.gameObjs.items.tools.PESword;
import net.dice7000.proeritia.common.item.PERToolHelper;
import net.dice7000.proeritia.common.registry.PERMatterType;
import net.dice7000.proeritia.util.PERUtil;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

public class PERSword extends PESword implements PERTools {
    private final PERMatterType matterType;

    public PERSword(PERMatterType matterType) {
        super(EnumMatterType.RED_MATTER, 1, matterType.getDamageOnregistry(), new Item.Properties());
        this.matterType = matterType;
    }

    public PERMatterType getMatterType() {
        return matterType;
    }

    @Override
    public float getDestroySpeed(@NotNull ItemStack stack, @NotNull BlockState state) {
        float speed = super.getDestroySpeed(stack, state);
        if (speed == 1.0F && state.is(PETags.Blocks.MINEABLE_WITH_PE_SWORD)) {
            speed = this.matterType.getSpeed();
        }
        return PERToolHelper.getDestroySpeed(speed, this.matterType, this.getCharge(stack));
    }

    public int getNumCharges(@NotNull ItemStack stack) {
        return getNumChargesLimited(matterType);
    }

    @Override
    public boolean hurtEnemy(@NotNull ItemStack stack, @NotNull LivingEntity damaged, @NotNull LivingEntity damager) {
        PERToolHelper.attackWithChargeOnPER(stack, damaged, damager, 1.0F);
        return true;
    }
}
