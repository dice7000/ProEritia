package net.dice7000.proeritia.mixin.mixin;

import com.llamalad7.mixinextras.sugar.Local;
import com.mojang.logging.LogUtils;
import net.dice7000.proeritia.mixin.method.DataItemMixinMethod;
import net.dice7000.proeritia.mixin.method.LivingEntityMixinMethod;
import net.dice7000.proeritia.mixin.method.SEDMixinMethod;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.gen.Accessor;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import javax.annotation.Nullable;

@Mixin(SynchedEntityData.class)
public abstract class SEDMixin implements SEDMixinMethod {
    @Shadow @Final private Entity entity;

    @Inject(method = "createDataItem", at = @At("TAIL"))
    public <T> void createDataItemInject(EntityDataAccessor<T> pKey, T pValue, CallbackInfo ci, @Local SynchedEntityData.DataItem<T> dataItem) {
        if (entity instanceof LivingEntity livingEntity) ((DataItemMixinMethod) dataItem).proEritia$setEntity(livingEntity);
    }

    @Inject(method = "set(Lnet/minecraft/network/syncher/EntityDataAccessor;Ljava/lang/Object;Z)V", at = @At("HEAD"), cancellable = true)
    public <T> void setInject(EntityDataAccessor<T> pKey, T pValue, boolean pForce, CallbackInfo ci) {
        if (entity instanceof LivingEntity livingEntity &&
                pKey.equals(((LivingEntityAccessor) livingEntity).getHealthID()) &&
                ((LivingEntityMixinMethod) livingEntity).proEritia$getImmuneDirectAccess()) {
            ci.cancel();
        }
    }
    @Inject(method = "get", at = @At("HEAD"), cancellable = true)
    public <T> void getInject(EntityDataAccessor<T> pKey, CallbackInfoReturnable<T> cir) {
        if (entity instanceof LivingEntity livingEntity &&
                pKey.equals(((LivingEntityAccessor) livingEntity).getHealthID()) &&
                ((LivingEntityMixinMethod) livingEntity).proEritia$getImmuneDirectAccess()) {
            try {
                cir.setReturnValue((T) Float.valueOf(livingEntity.getMaxHealth()));
            } catch (ClassCastException e) {
                LogUtils.getLogger().error("Failed to cast health value to the expected type. Returning default value instead.");
            }
        }
    }
    @Mixin(SynchedEntityData.DataItem.class)
    public static class DataItemMixin<T> implements DataItemMixinMethod {
        @Shadow Object value;
        @Shadow @Final EntityDataAccessor<T> accessor;
        @Unique /*自戒*/@Nullable private LivingEntity proEritia$entity = null;

        @Override public void proEritia$setEntity(LivingEntity entity) {
            this.proEritia$entity = entity;
        }

        @Inject(method = "setValue", at = @At("HEAD"), cancellable = true)
        public void setValueInject(Object pValue, CallbackInfo ci) {
            if (value instanceof Float && proEritia$entity != null &&
                    accessor.equals(((LivingEntityAccessor) proEritia$entity).getHealthID()) &&
                    ((LivingEntityMixinMethod) proEritia$entity).proEritia$getImmuneDirectAccessAbsolutely()) {
                ci.cancel();
            }
        }
        @Inject(method = "getValue", at = @At("HEAD"), cancellable = true)
        public void getValueInject(CallbackInfoReturnable<Object> cir) {
            if (value instanceof Float &&  proEritia$entity != null && accessor.equals(((LivingEntityAccessor) proEritia$entity).getHealthID())) {
                if (((LivingEntityMixinMethod) proEritia$entity).proEritia$getImmuneDirectAccessAbsolutely()) cir.setReturnValue(proEritia$entity.getMaxHealth());
                else if (((LivingEntityMixinMethod) proEritia$entity).proEritia$getForceDeath()) cir.setReturnValue(Float.MIN_VALUE);
            }
        }
    }
    @Mixin(LivingEntity.class) public interface LivingEntityAccessor { @Accessor("DATA_HEALTH_ID") EntityDataAccessor<Float> getHealthID();}
}
