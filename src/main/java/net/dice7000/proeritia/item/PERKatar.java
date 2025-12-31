package net.dice7000.proeritia.item;

import moze_intel.projecte.capability.ModeChangerItemCapabilityWrapper;
import moze_intel.projecte.config.ProjectEConfig;
import moze_intel.projecte.gameObjs.EnumMatterType;
import moze_intel.projecte.gameObjs.items.tools.PEKatar;
import moze_intel.projecte.utils.ItemHelper;
import moze_intel.projecte.utils.PlayerHelper;
import moze_intel.projecte.utils.ToolHelper;
import moze_intel.projecte.utils.text.ILangEntry;
import moze_intel.projecte.utils.text.PELang;
import net.dice7000.proeritia.mixin.method.LivingEntityMixinMethod;
import net.dice7000.proeritia.registry.ProEritiaMatterType;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class PERKatar extends PEKatar {
    private final ProEritiaMatterType matterType;
    private final ILangEntry[] modeDesc;

    public PERKatar(ProEritiaMatterType proEritiaMatterType, int numCharges, Properties props) {
        super(EnumMatterType.RED_MATTER, numCharges, props);
        this.matterType = proEritiaMatterType;
        this.modeDesc = new ILangEntry[]{PELang.MODE_MORNING_STAR_1, PELang.MODE_MORNING_STAR_2, PELang.MODE_MORNING_STAR_3, PELang.MODE_MORNING_STAR_4};
        this.addItemCapability(ModeChangerItemCapabilityWrapper::new);

    }

    @Override
    public boolean doExtraFunction(@NotNull ItemStack stack, @NotNull Player player, InteractionHand hand) {
        /*
        List<Entity> entities = player.level().getEntities(player, player.getBoundingBox().inflate(30.0F));
        for (Entity listedEntity : entities) {
            if (listedEntity instanceof LivingEntity target) {
                switch (matterType) {
                    case KSE -> target.hurt(player.damageSources().playerAttack(player), 2000000000);
                    case IFP -> target.setHealth(0);
                    case GCS -> ((LivingEntityMixinMethod) target).proEritia$anotherSetHealth(0);
                    case INF -> ((LivingEntityMixinMethod) target).proEritia$setForceDeath(true);
                }
                target.hurt(player.damageSources().genericKill(), 0);
            }
        }

         */
        if (player.getAttackStrengthScale(0.0F) == 1.0F) {
            PERToolHelper.attackAOEonPER(stack, player, this.getMode(stack) == 1, 0L, hand);
            PlayerHelper.resetCooldown(player);
            return true;
        } else {
            return false;
        }
    }

    public boolean hurtEnemy(@NotNull ItemStack stack, @NotNull LivingEntity damaged, @NotNull LivingEntity damager) {
        PERToolHelper.attackWithChargeOnPER(stack, damaged, damager, 1.0F);
        return true;
    }

    @Override public @NotNull InteractionResultHolder<ItemStack> use(@NotNull Level level, @NotNull Player player, @NotNull InteractionHand hand) {
        return ItemHelper.actionResultFromType(PERToolHelper.shearEntityAOEonPER(player, hand, 0L), player.getItemInHand(hand));
    }

    public ProEritiaMatterType getMatterType() {
        return matterType;
    }

    @Override
    public float getDestroySpeed(@NotNull ItemStack stack, @NotNull BlockState state) {
        return PERToolHelper.getDestroySpeed(this.getShortCutDestroySpeed(stack, state), this.matterType, this.getCharge(stack));
    }

    public ILangEntry[] getModeDesc() {
        return modeDesc;
    }
}
