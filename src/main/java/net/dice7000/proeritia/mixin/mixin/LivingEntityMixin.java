package net.dice7000.proeritia.mixin.mixin;

import net.dice7000.proeritia.mixin.method.LivingEntityMixinMethod;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attributes;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin implements LivingEntityMixinMethod {
    LivingEntity targetClass = ((LivingEntity) (Object) this);

    @Shadow @Final private static EntityDataAccessor<Float> DATA_HEALTH_ID;
    @Shadow public abstract void remove(Entity.RemovalReason pReason);
    @Override public void proEritia$anotherSetHealth(float value) {targetClass.getEntityData().set(DATA_HEALTH_ID, value);}
    //@Unique private boolean proEritia$moveDeathTime = false;
    @Unique private boolean proEritia$forceDeath = false;

    @Inject(method = "baseTick", at = @At("TAIL"))
    public void baseTickInject(CallbackInfo ci) {
        if (proEritia$forceDeath) {
            proEritia$anotherTickDeath();
            //proEritia$moveDeathTime = true;
        } //else {
            //proEritia$moveDeathTime = false;
        //}
    }

    @Override public boolean proEritia$shouldRunDieMethod() {
        return !targetClass.isRemoved() || proEritia$anotherGetHealth() <= 0.0F || proEritia$forceDeath;
    }

    @Override public void proEritia$setForceDeath(boolean forceDeath) {
        proEritia$forceDeath = forceDeath;
    }
    @Unique int proEritia$anotherDeathTime = 0;
    @Unique protected void proEritia$anotherTickDeath() {
        ++proEritia$anotherDeathTime;
        if (targetClass instanceof LivingEntity &&
                             this.proEritia$anotherDeathTime >= 20 &&
          !(targetClass.level().isClientSide()) &&
                    !(targetClass.isRemoved())) {
            targetClass.level().broadcastEntityEvent(targetClass, (byte)60);
            remove(Entity.RemovalReason.KILLED);
        }
    }

    @Unique private float proEritia$anotherGetHealth() {
        return targetClass.getEntityData().get(DATA_HEALTH_ID);
    }
    @Unique private float proEritia$anotherGetMaxHealth() {
        return ((float) targetClass.getAttributeValue(Attributes.MAX_HEALTH));
    }

    @Unique private boolean proEritia$isImmuneDamage = false;
    @Unique private boolean proEritia$isEffectCancel = false;
    @Unique private boolean proEritia$isNotPickable = false;
    @Override public void proEritia$setImmuneDamage(boolean value) {
        proEritia$isImmuneDamage = value;
    }
    @Override public void proEritia$setEffectCancel(boolean value) {
        proEritia$isEffectCancel = value;
    }
    @Override public void proEritia$setNotPickable(boolean value) {
        proEritia$isNotPickable = value;
    }

    @Inject(method = "hurt", at = @At("HEAD"), cancellable = true)
    public void hurtInject(DamageSource pSource, float pAmount, CallbackInfoReturnable<Boolean> cir) {
        if (proEritia$isImmuneDamage) cir.setReturnValue(false);
    }
    @Inject(method = "setHealth", at = @At("HEAD"))
    public void setHealthInject(float pHealth, CallbackInfo ci) {
        if (proEritia$isImmuneDamage) {
            targetClass.getEntityData().set(DATA_HEALTH_ID, Mth.clamp(proEritia$anotherGetMaxHealth(), 1.0F, Float.MAX_VALUE));
        }
    }
    @Inject(method = "addEffect(Lnet/minecraft/world/effect/MobEffectInstance;Lnet/minecraft/world/entity/Entity;)Z", at = @At("HEAD"), cancellable = true)
    public void addEffectInject(MobEffectInstance pEffectInstance, Entity pEntity, CallbackInfoReturnable<Boolean> cir) {
        if (proEritia$isEffectCancel) cir.setReturnValue(false);
    }

    @Inject(method = "isPickable", at = @At("HEAD"), cancellable = true)
    public void isPickableInject(CallbackInfoReturnable<Boolean> cir) {
        if (proEritia$isNotPickable) cir.setReturnValue(false);
    }
}
