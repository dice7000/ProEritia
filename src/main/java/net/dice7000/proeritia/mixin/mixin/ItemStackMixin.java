package net.dice7000.proeritia.mixin.mixin;

import net.dice7000.proeritia.common.item.armor.PERArmor;
import net.dice7000.proeritia.common.registry.PERMatterType;
import net.dice7000.proeritia.util.PERUtil;
import net.minecraft.core.Holder;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.function.Predicate;

@Mixin(ItemStack.class)
public abstract class ItemStackMixin {
    private ItemStack targetClass = ((ItemStack) (Object) this);

    @Shadow public abstract Item getItem();

    @Inject(method = "is(Lnet/minecraft/world/item/Item;)Z", at = @At("HEAD"), cancellable = true)
    public void passItemIsInject(Item pItem, CallbackInfoReturnable<Boolean> cir) {
        if (targetClass.getItem() instanceof PERArmor armor && armor.getMatterType() == PERMatterType.INF) {
            for (int i = 0; i < 3; i++) {
                if (pItem == PERUtil.getSlot(targetClass, i).getItem()) {
                    cir.setReturnValue(true);
                }
            }
            cir.setReturnValue(false);
        }
    }
    @Inject(method = "is(Lnet/minecraft/tags/TagKey;)Z", at = @At("HEAD"), cancellable = true)
    public void passTagKeyIsInject(TagKey<Item> pTag, CallbackInfoReturnable<Boolean> cir) {
        if (targetClass.getItem() instanceof PERArmor armor && armor.getMatterType() == PERMatterType.INF) {
            for (int i = 0; i < 3; i++) {
                if (PERUtil.getSlot(targetClass, i).getItem().builtInRegistryHolder().is(pTag)) {
                    cir.setReturnValue(true);
                }
            }
            cir.setReturnValue(false);
        }
    }
    @Inject(method = "is(Ljava/util/function/Predicate;)Z", at = @At("HEAD"), cancellable = true)
    public void passPredicateIsInject(Predicate<Holder<Item>> pItem, CallbackInfoReturnable<Boolean> cir) {
        if (targetClass.getItem() instanceof PERArmor armor && armor.getMatterType() == PERMatterType.INF) {
            for (int i = 0; i < 3; i++) {
                if (pItem.test(PERUtil.getSlot(targetClass, i).getItem().builtInRegistryHolder())) {
                    cir.setReturnValue(true);
                }
            }
            cir.setReturnValue(false);
        }
    }
    @Inject(method = "is(Lnet/minecraft/core/Holder;)Z", at = @At("HEAD"), cancellable = true)
    public void passHolderIsInject(Holder<Item> pItem, CallbackInfoReturnable<Boolean> cir) {
        if (targetClass.getItem() instanceof PERArmor armor && armor.getMatterType() == PERMatterType.INF) {
            for (int i = 0; i < 3; i++) {
                if (pItem == PERUtil.getSlot(targetClass, i).getItem().builtInRegistryHolder()) {
                    cir.setReturnValue(true);
                }
            }
            cir.setReturnValue(false);
        }
    }
}
