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
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.function.Predicate;

@Mixin(ItemStack.class)
public abstract class ItemStackMixin {
    @Unique private final ItemStack proEritia$targetClass = ((ItemStack) (Object) this);

    @Shadow public abstract Item getItem();
    //@Unique private boolean proEritia$initialized = false;
    /*
    @Inject(method = "<init>(Lnet/minecraft/world/level/ItemLike;ILnet/minecraft/nbt/CompoundTag;)V", at = @At("TAIL"))
    public void passItemLikesConstructorInject(ItemLike p_41604_, int p_41605_, CompoundTag p_41606_, CallbackInfo ci) {
        proEritia$initialized = true;
    }
    @Inject(method = "<init>(Ljava/lang/Void;)V", at = @At("TAIL"))
    public void passNothingConstructorInject(CallbackInfo ci) {
        proEritia$initialized = true;
    }
    @Inject(method = "<init>(Lnet/minecraft/nbt/CompoundTag;)V", at = @At("TAIL"))
    public void passCompoundTagConstructorInject(CompoundTag pCompoundTag, CallbackInfo ci) {
        proEritia$initialized = true;
    }

     */

    @Inject(method = "is(Lnet/minecraft/world/item/Item;)Z", at = @At("HEAD"), cancellable = true)
    public void passItemIsInject(Item pItem, CallbackInfoReturnable<Boolean> cir) {
        if (!proEritia$targetClass.initialized) return;
        if (proEritia$targetClass.getItem() instanceof PERArmor armor && armor.getMatterType() == PERMatterType.INF) {
            for (int i = 0; i < 3; i++) {
                if (pItem == PERUtil.getSlot(proEritia$targetClass, i).getItem()) {
                    cir.setReturnValue(true);
                }
            }
        }
    }
    @Inject(method = "is(Lnet/minecraft/tags/TagKey;)Z", at = @At("HEAD"), cancellable = true)
    public void passTagKeyIsInject(TagKey<Item> pTag, CallbackInfoReturnable<Boolean> cir) {
        if (!proEritia$targetClass.initialized) return;
        if (proEritia$targetClass.getItem() instanceof PERArmor armor && armor.getMatterType() == PERMatterType.INF) {
            for (int i = 0; i < 3; i++) {
                if (PERUtil.getSlot(proEritia$targetClass, i).getItem().builtInRegistryHolder().is(pTag)) {
                    cir.setReturnValue(true);
                }
            }
        }
    }
    @Inject(method = "is(Ljava/util/function/Predicate;)Z", at = @At("HEAD"), cancellable = true)
    public void passPredicateIsInject(Predicate<Holder<Item>> pItem, CallbackInfoReturnable<Boolean> cir) {
        if (!proEritia$targetClass.initialized) return;
        if (proEritia$targetClass.getItem() instanceof PERArmor armor && armor.getMatterType() == PERMatterType.INF) {
            for (int i = 0; i < 3; i++) {
                if (pItem.test(PERUtil.getSlot(proEritia$targetClass, i).getItem().builtInRegistryHolder())) {
                    cir.setReturnValue(true);
                }
            }
        }
    }
    @Inject(method = "is(Lnet/minecraft/core/Holder;)Z", at = @At("HEAD"), cancellable = true)
    public void passHolderIsInject(Holder<Item> pItem, CallbackInfoReturnable<Boolean> cir) {
        if (!proEritia$targetClass.initialized) return;
        if (proEritia$targetClass.getItem() instanceof PERArmor armor && armor.getMatterType() == PERMatterType.INF) {
            for (int i = 0; i < 3; i++) {
                if (pItem == PERUtil.getSlot(proEritia$targetClass, i).getItem().builtInRegistryHolder()) {
                    cir.setReturnValue(true);
                }
            }
        }
    }
}
