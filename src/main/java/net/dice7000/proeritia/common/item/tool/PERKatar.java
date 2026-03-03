package net.dice7000.proeritia.common.item.tool;

import moze_intel.projecte.capability.ModeChangerItemCapabilityWrapper;
import moze_intel.projecte.gameObjs.EnumMatterType;
import moze_intel.projecte.gameObjs.items.tools.PEKatar;
import moze_intel.projecte.utils.ItemHelper;
import moze_intel.projecte.utils.PlayerHelper;
import moze_intel.projecte.utils.text.ILangEntry;
import moze_intel.projecte.utils.text.PELang;
import net.dice7000.proeritia.common.item.PERToolHelper;
import net.dice7000.proeritia.common.registry.PERMatterType;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

public class PERKatar extends PEKatar implements PERTools {
    private final PERMatterType matterType;
    private final ILangEntry[] modeDesc;

    public PERKatar(PERMatterType matterType) {
        super(EnumMatterType.RED_MATTER, 1, new Item.Properties());
        this.matterType = matterType;
        this.modeDesc = new ILangEntry[]{PELang.MODE_MORNING_STAR_1, PELang.MODE_MORNING_STAR_2, PELang.MODE_MORNING_STAR_3, PELang.MODE_MORNING_STAR_4};
        this.addItemCapability(ModeChangerItemCapabilityWrapper::new);
    }

    @Override
    public int getNumCharges(@NotNull ItemStack stack) {
        return getNumChargesLimited(matterType);
    }

    @Override
    public boolean doExtraFunction(@NotNull ItemStack stack, @NotNull Player player, InteractionHand hand) {
        if (player.getAttackStrengthScale(0.0F) == 1.0F) {
            PERToolHelper.attackAOEonPER(stack, player, this.getMode(stack) == 1, 0L, hand);
            PlayerHelper.resetCooldown(player);
            return true;
        } else {
            return false;
        }
    }

    public boolean hurtEnemy(@NotNull ItemStack stack, @NotNull LivingEntity damaged, @NotNull LivingEntity damager) {
        PERToolHelper.attackWithChargeOnPER(stack, damaged, damager, 1.0F);
        return true;
    }

    @Override public @NotNull InteractionResultHolder<ItemStack> use(@NotNull Level level, @NotNull Player player, @NotNull InteractionHand hand) {
        return ItemHelper.actionResultFromType(PERToolHelper.shearEntityAOEonPER(player, hand, 0L), player.getItemInHand(hand));
    }

    public PERMatterType getMatterType() {
        return matterType;
    }

    @Override
    public float getDestroySpeed(@NotNull ItemStack stack, @NotNull BlockState state) {
        return PERToolHelper.getDestroySpeed(this.getShortCutDestroySpeed(stack, state), this.matterType, this.getCharge(stack));
    }

    public ILangEntry[] getModeDesc() {
        return modeDesc;
    }
}
