package net.dice7000.proeritia.compat.tic.item;
/*
import net.dice7000.proeritia.compat.tic.PERTiCCompatRegistry;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;
import slimeknights.tconstruct.library.tools.item.ModifiableItem;
*/
/*
public class ModifiablePERKatar extends PERKatar implements IModifiableDisplay {
    private ItemStack toolForRendering;

    public ModifiablePERKatar() {
        super(PERMatterType.KSE);
    }

    @Override public ToolDefinition getToolDefinition() {
        return PERTiCCompatRegistry.KATAR;
    }
    @Override public ItemStack getRenderTool() {
        if (this.toolForRendering == null) {
            this.toolForRendering = ToolBuildHandler.buildToolForRendering(this, this.getToolDefinition());
        }
        return this.toolForRendering;
    }

    @Override
    public int getNumCharges(@NotNull ItemStack stack) {
        return getNumChargesModifiable();
    }

    private int getNumChargesModifiable() {
        return 10;
    }
}

 */

public class ModifiablePERKatar /*extends ModifiableItem {
    public ModifiablePERKatar() {
        super(new Properties(), PERTiCCompatRegistry.KATAR);
    }

    public int getNumCharges(@NotNull ItemStack stack) {
        return getNumChargesModifiable();
    }

    private int getNumChargesModifiable() */{
        //return 10;
    }
//}
