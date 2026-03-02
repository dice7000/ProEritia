package net.dice7000.proeritia.mixin.mixin;

import net.dice7000.proeritia.mixin.method.LivingEntityMixinMethod;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attributes;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.HashMap;
import java.util.Map;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin implements LivingEntityMixinMethod {
    @Unique LivingEntity proEritia$targetClass = ((LivingEntity) (Object) this);

    @Shadow @Final private static EntityDataAccessor<Float> DATA_HEALTH_ID;
    @Shadow public abstract void remove(Entity.RemovalReason pReason);

    @Shadow
    public abstract boolean canBeAffected(MobEffectInstance pEffectInstance);

    @Shadow
    protected abstract void onEffectAdded(MobEffectInstance pEffectInstance, @Nullable Entity pEntity);

    @Shadow
    protected abstract void onEffectUpdated(MobEffectInstance pEffectInstance, boolean pForced, @Nullable Entity pEntity);

    @Shadow
    @Final
    private Map<MobEffect, MobEffectInstance> activeEffects;

    @Override public void proEritia$anotherSetHealth(float value) {
        proEritia$targetClass.getEntityData().set(DATA_HEALTH_ID, value);}
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
        return !proEritia$targetClass.isRemoved() || proEritia$anotherGetHealth() <= 0.0F || proEritia$forceDeath;
    }

    @Override public void proEritia$setForceDeath(boolean forceDeath) {
        proEritia$forceDeath = forceDeath;
    }
    @Unique int proEritia$anotherDeathTime = 0;
    @Unique protected void proEritia$anotherTickDeath() {
        ++proEritia$anotherDeathTime;
        if (proEritia$targetClass instanceof LivingEntity &&
                             this.proEritia$anotherDeathTime >= 20 &&
          !(proEritia$targetClass.level().isClientSide()) &&
                    !(proEritia$targetClass.isRemoved())) {
            proEritia$targetClass.level().broadcastEntityEvent(proEritia$targetClass, (byte)60);
            remove(Entity.RemovalReason.KILLED);
        }
    }

    @Unique private float proEritia$anotherGetHealth() {
        return proEritia$targetClass.getEntityData().get(DATA_HEALTH_ID);
    }
    @Unique private float proEritia$anotherGetMaxHealth() {
        return ((float) proEritia$targetClass.getAttributeValue(Attributes.MAX_HEALTH));
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
            proEritia$targetClass.getEntityData().set(DATA_HEALTH_ID, Mth.clamp(proEritia$anotherGetMaxHealth(), 1.0F, Float.MAX_VALUE));
        }
    }

    @Unique private Map<MobEffect, MobEffectInstance> proEritia$effectMemory = new HashMap<>();
    @Override public void proEritia$replaceEffectMemory(Map<MobEffect, MobEffectInstance> map) {
        proEritia$effectMemory = map;
    }
    @Override public void proEritia$clearEffectMemory() {
        proEritia$effectMemory.clear();
    }

    @Inject(method = "addEffect(Lnet/minecraft/world/effect/MobEffectInstance;Lnet/minecraft/world/entity/Entity;)Z", at = @At("HEAD"), cancellable = true)
    public void addEffectInject(MobEffectInstance pEffectInstance, Entity pEntity, CallbackInfoReturnable<Boolean> cir) {
        if (proEritia$isEffectCancel) cir.setReturnValue(false);
    }
    @Inject(method = "forceAddEffect", at = @At("HEAD"), cancellable = true)
    public void forceAddEffectInject(MobEffectInstance pInstance, Entity pEntity, CallbackInfo ci) {
        if (proEritia$isEffectCancel) {
            for (MobEffectInstance alreadyEffectInstance : proEritia$effectMemory.values()) {
                if (canBeAffected(alreadyEffectInstance)) {
                    MobEffectInstance mobEffectInstance = activeEffects.put(alreadyEffectInstance.getEffect(), alreadyEffectInstance);
                    if (mobEffectInstance == null) {
                        onEffectAdded(alreadyEffectInstance, pEntity);
                    } else {
                        onEffectUpdated(alreadyEffectInstance, true, pEntity);
                    }
                }
            }
            ci.cancel();
        }
    }

    @Inject(method = "isPickable", at = @At("HEAD"), cancellable = true)
    public void isPickableInject(CallbackInfoReturnable<Boolean> cir) {
        if (proEritia$isNotPickable) cir.setReturnValue(false);
    }
}
