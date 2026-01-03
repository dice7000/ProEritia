package net.dice7000.proeritia.item;

import moze_intel.projecte.gameObjs.EnumMatterType;
import moze_intel.projecte.gameObjs.items.tools.PEHoe;
import moze_intel.projecte.utils.ToolHelper;
import net.dice7000.proeritia.registry.ProEritiaMatterType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

public class PERHoe extends PEHoe implements PERTools{
    private final ProEritiaMatterType matterType;
    private final int numCharges;

    public PERHoe(ProEritiaMatterType proEritiaMatterType, int numCharges, Properties props) {
        super(EnumMatterType.RED_MATTER, numCharges, props);
        this.matterType = proEritiaMatterType;
        this.numCharges = numCharges;
    }

    public ProEritiaMatterType getMatterType() {
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
