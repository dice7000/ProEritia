package net.dice7000.proeritia.mixin.method;

import net.minecraft.world.entity.LivingEntity;
import org.spongepowered.asm.mixin.Unique;

public interface DataItemMixinMethod {
    @Unique void proEritia$setEntity(LivingEntity entity);
}
