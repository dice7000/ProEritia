package net.dice7000.proeritia.item;

import moze_intel.projecte.api.capabilities.PECapabilities;
import moze_intel.projecte.gameObjs.EnumMatterType;
import moze_intel.projecte.gameObjs.blocks.IMatterBlock;
import moze_intel.projecte.gameObjs.items.ItemPE;
import moze_intel.projecte.gameObjs.registries.PEDamageTypes;
import moze_intel.projecte.gameObjs.registries.PESoundEvents;
import moze_intel.projecte.utils.MathUtils;
import moze_intel.projecte.utils.PlayerHelper;
import moze_intel.projecte.utils.ToolHelper;
import moze_intel.projecte.utils.WorldHelper;
import net.dice7000.proeritia.mixin.method.LivingEntityMixinMethod;
import net.dice7000.proeritia.registry.ProEritiaMatterType;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.animal.Sheep;
import net.minecraft.world.entity.monster.Enemy;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraftforge.common.IForgeShearable;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class PERToolHelper extends ToolHelper {
    private static final Predicate<? super Entity> SLAY_MOB = (entity) -> !entity.isSpectator() && entity instanceof Enemy;
    private static final Predicate<? super Entity> SLAY_ALL = (entity) -> !entity.isSpectator() && (entity instanceof Enemy || entity instanceof LivingEntity);
    private static final Predicate<? super Entity> SHEARABLE = (entity) -> !entity.isSpectator() && entity instanceof IForgeShearable;;

    public static float getDestroySpeed(float parentDestroySpeed, ProEritiaMatterType matterType, int charge) {
        return parentDestroySpeed == 1.0F ? parentDestroySpeed : parentDestroySpeed + matterType.getChargeModifier() * (float)charge;
    }

    public static boolean canMatterMine(ProEritiaMatterType matterType, Block block) {
        boolean var10000;
        if (block instanceof IMatterBlock matterBlock) {
            if (matterBlock.getMatterType().getMatterTier() <= matterType.getMatterTier()) {
                var10000 = true;
                return var10000;
            }
        }
        var10000 = false;
        return var10000;
    }

    public static void attackWithChargeOnPER(ItemStack stack, LivingEntity damaged, LivingEntity damager, float baseDmg) {
        if (damager instanceof Player player) {
            if (!damager.level().isClientSide) {
                int charge = getPERCharge(stack);
                float totalDmg = baseDmg;
                DamageSource dmg;
                if (charge > 0) {
                    dmg = PEDamageTypes.BYPASS_ARMOR_PLAYER_ATTACK.source(player);
                    totalDmg = baseDmg + (float)charge;
                } else {
                    dmg = damager.damageSources().playerAttack(player);
                }
                //damaged.hurt(dmg, totalDmg);

                ProEritiaMatterType matterType = null;

                if (stack.getItem() instanceof PERKatar katar) matterType = katar.getMatterType();
                if (matterType == null) return;
                switch (matterType) {
                    case  KSE -> damaged.hurt(player.damageSources().playerAttack(player), 2000000000);
                    case  IFP -> damaged.setHealth(0);
                    case  GCS -> ((LivingEntityMixinMethod) damaged).proEritia$anotherSetHealth(0);
                    case  INF -> {
                        ((LivingEntityMixinMethod) damaged).proEritia$anotherSetHealth(0);
                        if (!(damaged instanceof Player)) ((LivingEntityMixinMethod) damaged).proEritia$setForceDeath(true);
                    }
                }
                damaged.hurt(player.damageSources().genericKill(), 0);
                return;
            }
        }

    }

    public static void attackAOEonPER(ItemStack stack, Player player, boolean slayAll,  long emcCost, InteractionHand hand) {
        Level level = player.level();
        if (!level.isClientSide) {
            int charge = getPERCharge(stack);
            List<Entity> toAttack = level.getEntities(player, player.getBoundingBox().inflate((double)(2.5F * (float)charge)), slayAll ? SLAY_ALL : SLAY_MOB);
            DamageSource src = PEDamageTypes.BYPASS_ARMOR_PLAYER_ATTACK.source(player);
            boolean hasAction = false;

            for(Entity entity : toAttack) {
                if (!ItemPE.consumeFuel(player, stack, emcCost, true)) {
                    break;
                }

                if (stack.getItem() instanceof PERKatar katar && entity instanceof LivingEntity target) {
                    ProEritiaMatterType matterType = katar.getMatterType();
                    switch (matterType) {
                        case KSE -> target.hurt(src, 2000000000);
                        case IFP -> target.setHealth(0);
                        case GCS -> ((LivingEntityMixinMethod) target).proEritia$anotherSetHealth(0);
                        case INF -> {
                            ((LivingEntityMixinMethod) target).proEritia$anotherSetHealth(0);
                            if (!(target instanceof Player)) ((LivingEntityMixinMethod) target).proEritia$setForceDeath(true);
                        }
                    }
                    target.hurt(player.damageSources().genericKill(), 0);
                }

                hasAction = true;
            }

            if (hasAction) {
                level.playSound((Player)null, player.getX(), player.getY(), player.getZ(), (SoundEvent) PESoundEvents.CHARGE.get(), SoundSource.PLAYERS, 1.0F, 1.0F);
                PlayerHelper.swingItem(player, hand);
            }

        }
    }

    private static int getPERCharge(ItemStack stack) {
        return (Integer) stack.getCapability(PECapabilities.CHARGE_ITEM_CAPABILITY).map((itemCharge) -> itemCharge.getCharge(stack)).orElse(0);
    }

    public static InteractionResult shearEntityAOEonPER(Player player, InteractionHand hand, long emcCost) {
        Level level = player.level();
        ItemStack stack = player.getItemInHand(hand);
        int fortune = stack.getEnchantmentLevel(Enchantments.BLOCK_FORTUNE);
        int offset = Mth.clamp((int) Math.pow((double) 2.0F, (double) (2 + getPERCharge(stack))), 0, 10000);
        List<Entity> list = level.getEntitiesOfClass(Entity.class, player.getBoundingBox().inflate((double) offset, (double)offset / (double)2.0F, (double) offset), SHEARABLE);
        boolean hasAction = false;
        List<ItemStack> drops = new ArrayList();

        for(Entity ent : list) {
            BlockPos entityPosition = ent.blockPosition();
            IForgeShearable target = (IForgeShearable)ent;
            if (target.isShearable(stack, level, entityPosition)) {
                if (level.isClientSide) {
                    return InteractionResult.SUCCESS;
                }

                if (!ItemPE.consumeFuel(player, stack, emcCost, true)) {
                    break;
                }

                List<ItemStack> entDrops = target.onSheared(player, stack, level, entityPosition, fortune);
                ent.gameEvent(GameEvent.SHEAR, player);
                if (!entDrops.isEmpty()) {
                    drops.addAll(entDrops);
                    drops.addAll(entDrops);
                }

                hasAction = true;
            }

            if (!level.isClientSide && Math.random() < 0.01) {
                Entity e = ent.getType().create(level);
                if (e != null) {
                    e.setPos(ent.getX(), ent.getY(), ent.getZ());
                    if (e instanceof Mob) {
                        Mob mob = (Mob)e;
                        mob.finalizeSpawn((ServerLevel)level, level.getCurrentDifficultyAt(entityPosition), MobSpawnType.EVENT, (SpawnGroupData)null, (CompoundTag)null);
                    }

                    if (e instanceof Sheep) {
                        Sheep sheep = (Sheep)e;
                        sheep.setColor(DyeColor.byId(MathUtils.randomIntInRange(0, 15)));
                    }

                    if (e instanceof AgeableMob) {
                        AgeableMob mob = (AgeableMob)e;
                        mob.setAge(-24000);
                    }

                    level.addFreshEntity(e);
                }
            }
        }

        if (hasAction) {
            WorldHelper.createLootDrop(drops, level, player.getX(), player.getY(), player.getZ());
            return InteractionResult.SUCCESS;
        } else {
            return InteractionResult.PASS;
        }
    }

}
