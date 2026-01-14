package net.dice7000.proeritia.item.tool;

import moze_intel.projecte.gameObjs.EnumMatterType;
import moze_intel.projecte.gameObjs.items.tools.PEHammer;
import net.dice7000.proeritia.item.PERToolHelper;
import net.dice7000.proeritia.registry.PERMatterType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

public class PERHammer extends PEHammer implements PERTools {
    private final PERMatterType matterType;

    public PERHammer(PERMatterType matterType) {
        super(EnumMatterType.RED_MATTER, matterType.getChargeModifier(), new Item.Properties());
        this.matterType = matterType;
    }

    public PERMatterType getMatterType() {
        return matterType;
    }

    @Override
    public float getDestroySpeed(@NotNull ItemStack stack, @NotNull BlockState state) {
        return PERToolHelper.canMatterMine(this.matterType, state.getBlock()) ? 1200000.0F : super.getDestroySpeed(stack, state);
    }

    @Override
    public boolean hurtEnemy(@NotNull ItemStack stack, @NotNull LivingEntity damaged, @NotNull LivingEntity damager) {
        PERToolHelper.attackWithChargeOnPER(stack, damaged, damager, 1.0F);
        return true;
    }
}
