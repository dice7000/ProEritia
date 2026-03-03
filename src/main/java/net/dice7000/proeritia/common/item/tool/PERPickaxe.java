package net.dice7000.proeritia.common.item.tool;

import moze_intel.projecte.gameObjs.EnumMatterType;
import moze_intel.projecte.gameObjs.items.tools.PEPickaxe;
import moze_intel.projecte.utils.text.ILangEntry;
import moze_intel.projecte.utils.text.PELang;
import net.dice7000.proeritia.common.item.PERToolHelper;
import net.dice7000.proeritia.common.registry.PERMatterType;
import net.dice7000.proeritia.util.PERUtil;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

public class PERPickaxe extends PEPickaxe implements PERTools {
    private final PERMatterType matterType;
    private final ILangEntry[] modeDesc;

    public PERPickaxe(PERMatterType matterType) {
        super(EnumMatterType.RED_MATTER, 1, new Item.Properties());
        this.matterType = matterType;
        this.modeDesc = new ILangEntry[]{PELang.MODE_PICK_1, PELang.MODE_PICK_2, PELang.MODE_PICK_3, PELang.MODE_PICK_4};
    }

    @Override
    public int getNumCharges(@NotNull ItemStack stack) {
        return getNumChargesLimited(matterType);
    }

    public PERMatterType getMatterType() {
        return matterType;
    }

    @Override
    public float getDestroySpeed(@NotNull ItemStack stack, @NotNull BlockState state) {
        return PERToolHelper.canMatterMine(this.matterType, state.getBlock()) ? 1200000.0F : PERToolHelper.getDestroySpeed(super.getDestroySpeed(stack, state), this.matterType, this.getCharge(stack));
    }

    public ILangEntry[] getModeLangEntries() {
        return modeDesc;
    }

    @Override
    public boolean hurtEnemy(@NotNull ItemStack stack, @NotNull LivingEntity damaged, @NotNull LivingEntity damager) {
        PERToolHelper.attackWithChargeOnPER(stack, damaged, damager, 1.0F);
        return true;
    }
}
