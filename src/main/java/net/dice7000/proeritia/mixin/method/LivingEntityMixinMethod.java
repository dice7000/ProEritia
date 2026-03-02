package net.dice7000.proeritia.mixin.method;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;

import java.util.Map;

public interface LivingEntityMixinMethod {
    void proEritia$anotherSetHealth(float value);
    boolean proEritia$shouldRunDieMethod();
    void proEritia$setForceDeath(boolean forceDeath);
    void proEritia$setImmuneDamage(boolean value);
    void proEritia$setEffectCancel(boolean value);

    void proEritia$setNotPickable(boolean value);

    void proEritia$replaceEffectMemory(Map<MobEffect, MobEffectInstance> map);

    void proEritia$clearEffectMemory();
}
