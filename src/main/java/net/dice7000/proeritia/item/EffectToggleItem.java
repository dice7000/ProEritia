package net.dice7000.proeritia.item;

import net.dice7000.proeritia.mixin.method.LivingEntityMixinMethod;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class EffectToggleItem extends Item {
    public EffectToggleItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        if (!pPlayer.level().isClientSide) {
            ((LivingEntityMixinMethod) pPlayer).proEritia$toggleEffectCancel();
            System.out.println("toggled");
        }

        return super.use(pLevel, pPlayer, pUsedHand);
    }
}
