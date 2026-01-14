package net.dice7000.proeritia.item.tool;

import moze_intel.projecte.capability.ModeChangerItemCapabilityWrapper;
import moze_intel.projecte.gameObjs.EnumMatterType;
import moze_intel.projecte.gameObjs.items.tools.PEMorningStar;
import moze_intel.projecte.utils.text.ILangEntry;
import moze_intel.projecte.utils.text.PELang;
import net.dice7000.proeritia.item.PERToolHelper;
import net.dice7000.proeritia.registry.PERMatterType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

public class PERMorningStar extends PEMorningStar implements PERTools {
    private final PERMatterType matterType;
    private final ILangEntry[] modeDesc;

    public PERMorningStar(PERMatterType matterType) {
        super(EnumMatterType.RED_MATTER, matterType.getChargeModifier(), new Item.Properties());
        this.matterType = matterType;
        this.modeDesc = new ILangEntry[]{PELang.MODE_MORNING_STAR_1, PELang.MODE_MORNING_STAR_2, PELang.MODE_MORNING_STAR_3, PELang.MODE_MORNING_STAR_4};
        this.addItemCapability(ModeChangerItemCapabilityWrapper::new);

    }

    public PERMatterType getMatterType() {
        return matterType;
    }

    @Override
    public float getDestroySpeed(@NotNull ItemStack stack, @NotNull BlockState state) {
        return PERToolHelper.canMatterMine(this.matterType, state.getBlock()) ? 1200000.0F : super.getDestroySpeed(stack, state) + 48.0F;
    }

    public ILangEntry[] getModeDesc() {
        return modeDesc;
    }

    @Override
    public boolean hurtEnemy(@NotNull ItemStack stack, @NotNull LivingEntity damaged, @NotNull LivingEntity damager) {
        PERToolHelper.attackWithChargeOnPER(stack, damaged, damager, 1.0F);
        return true;
    }
}
