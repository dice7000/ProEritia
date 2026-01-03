package net.dice7000.proeritia.item;

import moze_intel.projecte.gameObjs.EnumMatterType;
import moze_intel.projecte.gameObjs.PETags;
import moze_intel.projecte.gameObjs.items.tools.PEAxe;
import moze_intel.projecte.gameObjs.items.tools.PESword;
import moze_intel.projecte.utils.ToolHelper;
import net.dice7000.proeritia.registry.ProEritiaMatterType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

public class PERSword extends PESword implements PERTools{
    private final ProEritiaMatterType matterType;
    private final int numCharges;

    public PERSword(ProEritiaMatterType proEritiaMatterType, int numCharges, int damage, Properties props) {
        super(EnumMatterType.RED_MATTER, numCharges, damage, props);
        this.matterType = proEritiaMatterType;
        this.numCharges = numCharges;
    }

    public ProEritiaMatterType getMatterType() {
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
        return numCharges;
    }

    @Override
    public boolean hurtEnemy(@NotNull ItemStack stack, @NotNull LivingEntity damaged, @NotNull LivingEntity damager) {
        PERToolHelper.attackWithChargeOnPER(stack, damaged, damager, 1.0F);
        return true;
    }
}
