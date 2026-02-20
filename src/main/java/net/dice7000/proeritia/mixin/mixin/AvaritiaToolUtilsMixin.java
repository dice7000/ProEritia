package net.dice7000.proeritia.mixin.mixin;

import committee.nova.mods.avaritia.common.item.tools.InfinityArmorItem;
import committee.nova.mods.avaritia.util.ToolUtils;
import net.dice7000.proeritia.common.item.armor.PERArmor;
import net.dice7000.proeritia.util.PERUtil;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value = ToolUtils.class, remap = false)
public class AvaritiaToolUtilsMixin {
    @Inject(method = "isInfinite", at = @At("HEAD"), cancellable = true)
    private static void isInfiniteInject(LivingEntity player, CallbackInfoReturnable<Boolean> cir) {
        for(EquipmentSlot slot : EquipmentSlot.values()) {
            if (slot.getType() == EquipmentSlot.Type.ARMOR) {
                ItemStack stack = player.getItemBySlot(slot);
                if (!stack.isEmpty() && stack.getItem() instanceof PERArmor) {
                    for (int i = 0; i < 3; i++) {
                        if (PERUtil.getSlot(stack, i).getItem() instanceof InfinityArmorItem) cir.setReturnValue(true);
                    }
                }
            }
        }
    }
}
