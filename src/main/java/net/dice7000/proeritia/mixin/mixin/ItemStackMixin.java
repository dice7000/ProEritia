package net.dice7000.proeritia.mixin.mixin;

import net.dice7000.proeritia.common.item.armor.PERArmor;
import net.dice7000.proeritia.common.registry.PERMatterType;
import net.dice7000.proeritia.util.PERUtil;
import net.minecraft.core.Holder;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.capabilities.CapabilityProvider;
import org.slf4j.Logger;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.lang.reflect.Field;
import java.util.function.Predicate;

@Mixin(ItemStack.class)
public abstract class ItemStackMixin {
    @Unique private final ItemStack proEritia$this = ((ItemStack) (Object) this);
    @Shadow public abstract Item getItem();
    @Shadow @Final private static Logger LOGGER;

    @Inject(method = "is(Lnet/minecraft/world/item/Item;)Z", at = @At("HEAD"), cancellable = true)
    public void passItemIsInject(Item pItem, CallbackInfoReturnable<Boolean> cir) {
        if (proEritia$hasInitialized()) return;
        if (proEritia$this.getItem() instanceof PERArmor armor && armor.getMatterType() == PERMatterType.INF) {
            for (int i = 0; i < 3; i++) {
                if (pItem == PERUtil.getSlot(proEritia$this, i).getItem()) {
                    cir.setReturnValue(true);
                }
            }
        }
    }
    @Inject(method = "is(Lnet/minecraft/tags/TagKey;)Z", at = @At("HEAD"), cancellable = true)
    public void passTagKeyIsInject(TagKey<Item> pTag, CallbackInfoReturnable<Boolean> cir) {
        if (proEritia$hasInitialized()) return;
        if (proEritia$this.getItem() instanceof PERArmor armor && armor.getMatterType() == PERMatterType.INF) {
            for (int i = 0; i < 3; i++) {
                if (PERUtil.getSlot(proEritia$this, i).getItem().builtInRegistryHolder().is(pTag)) {
                    cir.setReturnValue(true);
                }
            }
        }
    }
    @Inject(method = "is(Ljava/util/function/Predicate;)Z", at = @At("HEAD"), cancellable = true)
    public void passPredicateIsInject(Predicate<Holder<Item>> pItem, CallbackInfoReturnable<Boolean> cir) {
        if (proEritia$hasInitialized()) return;
        if (proEritia$this.getItem() instanceof PERArmor armor && armor.getMatterType() == PERMatterType.INF) {
            for (int i = 0; i < 3; i++) {
                if (pItem.test(PERUtil.getSlot(proEritia$this, i).getItem().builtInRegistryHolder())) {
                    cir.setReturnValue(true);
                }
            }
        }
    }
    @Inject(method = "is(Lnet/minecraft/core/Holder;)Z", at = @At("HEAD"), cancellable = true)
    public void passHolderIsInject(Holder<Item> pItem, CallbackInfoReturnable<Boolean> cir) {
        if (proEritia$hasInitialized()) return;
        if (proEritia$this.getItem() instanceof PERArmor armor && armor.getMatterType() == PERMatterType.INF) {
            for (int i = 0; i < 3; i++) {
                if (pItem == PERUtil.getSlot(proEritia$this, i).getItem().builtInRegistryHolder()) {
                    cir.setReturnValue(true);
                }
            }
        }
    }

    @Unique private boolean proEritia$hasInitialized() {
        Field initializedField;
        try {
            initializedField = CapabilityProvider.class.getDeclaredField("initialized");
            initializedField.setAccessible(true);
            return initializedField.getBoolean(proEritia$this);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            LOGGER.warn("Failed to access 'initialized' field in CapabilityProvider. Assuming not initialized.", e);
            return false;
        }
    }
}
