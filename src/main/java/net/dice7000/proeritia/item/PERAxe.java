package net.dice7000.proeritia.item;

import moze_intel.projecte.gameObjs.EnumMatterType;
import moze_intel.projecte.gameObjs.items.tools.PEAxe;
import moze_intel.projecte.utils.ToolHelper;
import net.dice7000.proeritia.registry.ProEritiaMatterType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

public class PERAxe extends PEAxe {
    private final ProEritiaMatterType matterType;

    public PERAxe(ProEritiaMatterType proEritiaMatterType, int numCharges, Properties props) {
        super(EnumMatterType.RED_MATTER, numCharges, props);
        this.matterType = proEritiaMatterType;
    }

    public ProEritiaMatterType getMatterType() {
        return matterType;
    }

    @Override
    public float getDestroySpeed(@NotNull ItemStack stack, @NotNull BlockState state) {
        return PERToolHelper.getDestroySpeed(super.getDestroySpeed(stack, state), this.matterType, this.getCharge(stack));
    }
}
