package net.dice7000.proeritia.common.event;

import net.dice7000.proeritia.ProEritia;
import net.dice7000.proeritia.mixin.method.LivingEntityMixinMethod;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import static net.dice7000.proeritia.common.registry.PERTags.*;
import static net.minecraft.world.entity.EquipmentSlot.*;

public class PEREvents {
    @Mod.EventBusSubscriber(modid = ProEritia.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ModBusEvent {
        //unused, まだ
    }
    @Mod.EventBusSubscriber(modid = ProEritia.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
    public static class ForgeBusEvent {

        @SubscribeEvent public static void onAllWearing(TickEvent.PlayerTickEvent event) {
            if (event.phase != TickEvent.Phase.END) return;
            Player player = event.player;
            if (player.level().isClientSide) return;

            int typeAsInt = isAllWearing(player); // 0: no, 1:KSE, 2:IFP, 3:GCS, 4:INF

            flying(player, typeAsInt);
            if (typeAsInt >= 1) {
                if (player.isAlive()) player.setHealth(player.getMaxHealth());
            } else {
            }
            if (typeAsInt >= 2) {
                ((LivingEntityMixinMethod) player).proEritia$setImmuneDamage(true);
            } else {
                ((LivingEntityMixinMethod) player).proEritia$setImmuneDamage(false);
            }
            if (typeAsInt >= 3) {
                ((LivingEntityMixinMethod) player).proEritia$replaceEffectMemory(player.getActiveEffectsMap());
                ((LivingEntityMixinMethod) player).proEritia$setEffectCancel(true);
            } else {
                ((LivingEntityMixinMethod) player).proEritia$clearEffectMemory();
                ((LivingEntityMixinMethod) player).proEritia$setEffectCancel(false);
            }
            if (typeAsInt >= 4) {
                //((LivingEntityMixinMethod) player).proEritia$setNotPickable(true);
            } else {
                //((LivingEntityMixinMethod) player).proEritia$setNotPickable(false);
            }
        }

        private static void flying(Player entity, int typeAsInt) {
            if (!(entity instanceof ServerPlayer player)) return;
            if (player.gameMode.isCreative() || player.isSpectator()) return;
            if (typeAsInt >= 2) {
                if (!player.getAbilities().mayfly) {
                    player.getAbilities().mayfly = true;
                    player.onUpdateAbilities();
                }
            } else {
                if (player.getAbilities().mayfly) {
                    player.getAbilities().mayfly = false;
                    player.getAbilities().flying = false;
                    player.onUpdateAbilities();
                }
            }

        }

        private static int isAllWearing(Player player) {
                 if (matchTags(player, ARMOR_INF_TIER))
                return 4;
            else if (matchTags(player, ARMOR_GCS_TIER))
                return 3;
            else if (matchTags(player, ARMOR_IFP_TIER))
                return 2;
            else if (matchTags(player, ARMOR_KSE_TIER))
                return 1;
            else
                return 0;
        }
        private static boolean matchTags(Player player, TagKey<Item> tag) {
            ItemStack h = player.getItemBySlot(HEAD);
            ItemStack c = player.getItemBySlot(CHEST);
            ItemStack l = player.getItemBySlot(LEGS);
            ItemStack f = player.getItemBySlot(FEET);

            return h.is(tag) && c.is(tag) && l.is(tag) && f.is(tag);
        }
    }
}
