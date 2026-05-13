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
    @Unique LivingEntity proEritia$this = ((LivingEntity) (Object) this);

    @Shadow @Final private static EntityDataAccessor<Float> DATA_HEALTH_ID;
    @Shadow public abstract boolean removeAllEffects();
    @Shadow public abstract void remove(Entity.RemovalReason pReason);

    @Override public void proEritia$anotherSetHealth(float value) {
        proEritia$this.getEntityData().set(DATA_HEALTH_ID, value);}
    @Unique private boolean proEritia$forceDeath = false;
    @Override public void proEritia$setForceDeath(boolean forceDeath) {
        proEritia$forceDeath = forceDeath;
    }
    @Override public boolean proEritia$getForceDeath() {
        return proEritia$forceDeath;
    }

    @Inject(method = "baseTick", at = @At("TAIL"))
    public void baseTickInject(CallbackInfo ci) {
        if (proEritia$isEffectCancel) removeAllEffects();
        if (proEritia$forceDeath) proEritia$anotherTickDeath();
    }

    @Override public boolean proEritia$shouldRunDieMethod() {
        return !proEritia$this.isRemoved() || proEritia$anotherGetHealth() <= 0.0F || proEritia$forceDeath;
    }
    @Unique int proEritia$anotherDeathTime = 0;
    @Unique protected void proEritia$anotherTickDeath() {
        ++proEritia$anotherDeathTime;
        if (proEritia$this instanceof LivingEntity &&
                this.proEritia$anotherDeathTime >= 20 &&
                !(proEritia$this.level().isClientSide()) &&
                !(proEritia$this.isRemoved())) {
            proEritia$this.level().broadcastEntityEvent(proEritia$this, (byte)60);
            remove(Entity.RemovalReason.KILLED);
        }
    }

    @Unique private float proEritia$anotherGetHealth() {
        return proEritia$this.getEntityData().get(DATA_HEALTH_ID);
    }
    @Unique private float proEritia$anotherGetMaxHealth() {
        return ((float) proEritia$this.getAttributeValue(Attributes.MAX_HEALTH));
    }

    @Unique private boolean proEritia$isImmuneHurt = false;
    @Unique private boolean proEritia$isImmuneSetHealth = false;
    @Unique private boolean proEritia$isImmuneDirectAccess = false;
    @Unique private boolean proEritia$isEffectCancel = false;
    @Unique private boolean proEritia$isNotPickable = false;
    @Unique private boolean proEritia$isImmuneDirectAccessAbsolutely = false;
    @Override public void proEritia$setImmuneHurt(boolean value) {
        proEritia$isImmuneHurt = value;
    }
    @Override public void proEritia$setImmuneSetHealth(boolean value) {
        proEritia$isImmuneSetHealth = value;
    }
    @Override public void proEritia$setImmuneDirectAccess(boolean value) {
        proEritia$isImmuneDirectAccess = value;
    }
    @Override public void proEritia$setEffectCancel(boolean value) {
        proEritia$isEffectCancel = value;
    }
    @Override public void proEritia$setNotPickable(boolean value) {
        proEritia$isNotPickable = value;
    }
    @Override public void proEritia$setImmuneDirectAccessAbsolutely(boolean value) {
        proEritia$isImmuneDirectAccessAbsolutely = value;
    }

    @Override public boolean proEritia$getImmuneDirectAccess() {
        return proEritia$isImmuneDirectAccess;
    }
    @Override public boolean proEritia$getImmuneDirectAccessAbsolutely() {
        return proEritia$isImmuneDirectAccessAbsolutely;
    }

    @Inject(method = "hurt", at = @At("HEAD"), cancellable = true)
    public void hurtInject(DamageSource pSource, float pAmount, CallbackInfoReturnable<Boolean> cir) {
        if (proEritia$isImmuneHurt) cir.setReturnValue(false);
    }
    @Inject(method = "setHealth", at = @At("HEAD"))
    public void setHealthInject(float pHealth, CallbackInfo ci) {
        if (proEritia$isImmuneSetHealth) proEritia$this.getEntityData().set(DATA_HEALTH_ID, Mth.clamp(proEritia$anotherGetMaxHealth(), 1.0F, Float.MAX_VALUE));
    }

    @Inject(method = "addEffect(Lnet/minecraft/world/effect/MobEffectInstance;Lnet/minecraft/world/entity/Entity;)Z", at = @At("HEAD"), cancellable = true)
    public void addEffectInject(MobEffectInstance pEffectInstance, Entity pEntity, CallbackInfoReturnable<Boolean> cir) {
        if (proEritia$isEffectCancel) cir.setReturnValue(false);
    }
    @Inject(method = "forceAddEffect", at = @At("HEAD"), cancellable = true)
    public void forceAddEffectInject(MobEffectInstance pInstance, Entity pEntity, CallbackInfo ci) {
        if (proEritia$isEffectCancel) ci.cancel();
    }

    @Inject(method = "isPickable", at = @At("HEAD"), cancellable = true)
    public void isPickableInject(CallbackInfoReturnable<Boolean> cir) {
        if (proEritia$isNotPickable) cir.setReturnValue(false);
    }

    @Inject(method = "getHealth", at = @At("HEAD"), cancellable = true)
    public void getHealthInject(CallbackInfoReturnable<Float> cir) {
        if (proEritia$forceDeath) cir.setReturnValue(0.0F);
    }
}
