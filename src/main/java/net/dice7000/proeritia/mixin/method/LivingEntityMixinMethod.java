package net.dice7000.proeritia.mixin.method;

public interface LivingEntityMixinMethod {
    void proEritia$anotherSetHealth(float value);

    boolean proEritia$shouldRunDieMethod();

    void proEritia$setForceDeath(boolean forceDeath);
    void proEritia$setImmuneDamage(boolean value);
    void proEritia$setEffectCancel(boolean value);
}
