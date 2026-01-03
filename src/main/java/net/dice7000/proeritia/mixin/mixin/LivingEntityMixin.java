package net.dice7000.proeritia.mixin.mixin;

import net.dice7000.proeritia.mixin.method.LivingEntityMixinMethod;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
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
    @Shadow @Final private static EntityDataAccessor<Float> DATA_HEALTH_ID;
    @Shadow public abstract void remove(Entity.RemovalReason pReason);
    @Override public void proEritia$anotherSetHealth(float value) { ((LivingEntity) (Object) this).getEntityData().set(DATA_HEALTH_ID, value);}
    @Unique private boolean proEritia$moveDeathTime = false;
    @Unique private boolean proEritia$forceDeath = false;
    @Inject(method = "baseTick", at = @At("TAIL"))
    public void baseTickInject(CallbackInfo ci) {
        if (proEritia$forceDeath) {
            proEritia$anotherTickDeath();
            proEritia$moveDeathTime = true;
        } else {
            proEritia$moveDeathTime = false;
        }
    }

    @Override public void proEritia$setForceDeath(boolean forceDeath) {
        proEritia$forceDeath = forceDeath;
    }

    @Unique int proEritia$anotherDeathTime = 0;
    @Unique protected void proEritia$anotherTickDeath() {
        ++proEritia$anotherDeathTime;
        if (this.proEritia$anotherDeathTime >= 20 && !(((LivingEntity) (Object) this).level().isClientSide()) && !(((LivingEntity) (Object) this).isRemoved())) {
            ((LivingEntity) (Object) this).level().broadcastEntityEvent(((LivingEntity) (Object) this), (byte)60);
            remove(Entity.RemovalReason.KILLED);
        }

    }

}
