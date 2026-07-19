package net.dice7000.proeritia.common.event;

import net.dice7000.proeritia.ProEritia;
import net.dice7000.proeritia.mixin.method.LivingEntityMixinMethod;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.player.Abilities;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

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
            if (event.player.level().isClientSide && !(event.player instanceof ServerPlayer)) return;
            ServerPlayer player = (ServerPlayer) event.player;
            int typeAsInt = isAllWearing(player); // 0: no, 1:KSE, 2:IFP, 3:GCS, 4:INF

            LivingEntityMixinMethod mixedPlayer = (LivingEntityMixinMethod) player;
            if (typeAsInt >= 1) {
                if (player.isAlive()) player.setHealth(player.getMaxHealth());
                mixedPlayer.proEritia$setImmuneHurt(true);
            } else {
                mixedPlayer.proEritia$setImmuneHurt(false);
            }
            if (typeAsInt >= 2) {
                mixedPlayer.proEritia$setImmuneSetHealth(true);
            } else {
                mixedPlayer.proEritia$setImmuneSetHealth(false);
            }
            if (typeAsInt >= 3) {
                mixedPlayer.proEritia$setImmuneDirectAccess(true);
                mixedPlayer.proEritia$setEffectCancel(true);
            } else {
                mixedPlayer.proEritia$setImmuneDirectAccess(false);
                mixedPlayer.proEritia$setEffectCancel(false);
            }
            if (typeAsInt >= 4) {
                mixedPlayer.proEritia$setImmuneDirectAccessAbsolutely(true);
                //mixedPlayer.proEritia$setNotPickable(true);
            } else {
                mixedPlayer.proEritia$setImmuneDirectAccessAbsolutely(false);
                //mixedPlayer.proEritia$setNotPickable(false);
            }

            flying(player, typeAsInt);

            updateType(player, typeAsInt);
        }

        private static void flying(ServerPlayer player, int typeAsInt) {
            if (player.gameMode.isCreative() || player.isSpectator()) return;
            Abilities ab = player.getAbilities();
            if (typeAsInt >= 2) {
                if (!ab.mayfly) ab.mayfly = true;
            } else if (hasChangedType(player, typeAsInt)) {
                if (ab.mayfly) {ab.mayfly = false; ab.flying = false;}
            }
            player.onUpdateAbilities();
        }

        private static final Map<UUID, AtomicInteger> flyingMap = new HashMap<>();
        private static boolean hasChangedType(Player player, int typeAsInt) {
            if (!player.level().isClientSide) {
                UUID uuid = player.getUUID();
                if (!flyingMap.containsKey(uuid)) flyingMap.put(uuid, new AtomicInteger(0));
                return flyingMap.get(uuid).get() != typeAsInt;
            } else return false;
        }
        private static void updateType(Player player, int typeAsInt) {
            if (!player.level().isClientSide) {
                UUID uuid = player.getUUID();
                if (!flyingMap.containsKey(uuid)) flyingMap.put(uuid, new AtomicInteger(0));
                flyingMap.get(uuid).set(typeAsInt);
            }
        }

        private static int isAllWearing(Player player) {
                 if (matches(player, ARMOR_INF_TIER)) return 4;
            else if (matches(player, ARMOR_GCS_TIER)) return 3;
            else if (matches(player, ARMOR_IFP_TIER)) return 2;
            else if (matches(player, ARMOR_KSE_TIER)) return 1;
            else                                        return 0;
        }
        private static boolean matches(Player player, TagKey<Item> tag) {
            ItemStack h = player.getItemBySlot(HEAD);
            ItemStack c = player.getItemBySlot(CHEST);
            ItemStack l = player.getItemBySlot(LEGS);
            ItemStack f = player.getItemBySlot(FEET);

            return h.is(tag) && c.is(tag) && l.is(tag) && f.is(tag);
        }
    }
}
