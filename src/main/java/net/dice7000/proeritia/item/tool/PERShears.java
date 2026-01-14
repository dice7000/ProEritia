package net.dice7000.proeritia.item.tool;

import moze_intel.projecte.gameObjs.EnumMatterType;
import moze_intel.projecte.gameObjs.PETags;
import moze_intel.projecte.gameObjs.items.tools.PEShears;
import moze_intel.projecte.utils.ItemHelper;
import net.dice7000.proeritia.item.PERToolHelper;
import net.dice7000.proeritia.registry.PERMatterType;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.TierSortingRegistry;
import org.jetbrains.annotations.NotNull;

public class PERShears extends PEShears implements PERTools {
    private final PERMatterType matterType;
    private final int numCharges;

    public PERShears(PERMatterType matterType) {
        super(EnumMatterType.RED_MATTER, matterType.getChargeModifier(), new Item.Properties());
        this.matterType = matterType;
        this.numCharges = matterType.getChargeModifier();
    }

    public PERMatterType getMatterType() {
        return matterType;
    }

    @Override
    public int getNumCharges(@NotNull ItemStack stack) {
        return numCharges;
    }

    @Override
    public float getDestroySpeed(@NotNull ItemStack stack, @NotNull BlockState state) {
        float speed = super.getDestroySpeed(stack, state);
        if (speed == 1.0F && state.is(PETags.Blocks.MINEABLE_WITH_PE_SHEARS)) {
            speed = this.matterType.getSpeed();
        }

        return PERToolHelper.getDestroySpeed(speed, this.matterType, this.getCharge(stack));
    }

    @Override
    public @NotNull InteractionResultHolder<ItemStack> use(@NotNull Level level, @NotNull Player player, @NotNull InteractionHand hand) {
        return ItemHelper.actionResultFromType(PERToolHelper.shearEntityAOEonPER(player, hand, 0L), player.getItemInHand(hand));
    }

    @Override
    public boolean isCorrectToolForDrops(@NotNull ItemStack stack, BlockState state) {
        return state.is(PETags.Blocks.MINEABLE_WITH_PE_SHEARS) && TierSortingRegistry.isCorrectTierForDrops(this.matterType, state);
    }
}
