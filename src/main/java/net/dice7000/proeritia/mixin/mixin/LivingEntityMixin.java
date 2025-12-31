package net.dice7000.proeritia.mixin.mixin;

import net.dice7000.proeritia.mixin.method.LivingEntityMixinMethod;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.world.entity.LivingEntity;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin implements LivingEntityMixinMethod {
    @Shadow @Final private static EntityDataAccessor<Float> DATA_HEALTH_ID;
    @Shadow protected abstract void tickDeath();
    @Override public void proEritia$anotherSetHealth(float value) { ((LivingEntity) (Object) this).getEntityData().set(DATA_HEALTH_ID, value);}
    @Unique private boolean proEritia$forceDeath = false;
    @Inject(method = "baseTick", at = @At("TAIL")) public void baseTickInject(CallbackInfo ci) {if (proEritia$forceDeath) tickDeath();}
    @Override public void proEritia$setForceDeath(boolean forceDeath) {
        proEritia$forceDeath = forceDeath;
    }
}
