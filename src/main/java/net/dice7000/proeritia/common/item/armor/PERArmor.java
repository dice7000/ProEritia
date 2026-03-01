package net.dice7000.proeritia.common.item.armor;

import moze_intel.projecte.gameObjs.items.armor.PEArmor;
import net.dice7000.proeritia.common.cap.PERArmorCapabilityProvider;
import net.dice7000.proeritia.common.menu.PERArmorStorageMenu;
import net.dice7000.proeritia.common.registry.PERItems;
import net.dice7000.proeritia.common.registry.PERMatterType;
import net.dice7000.proeritia.util.PERUtil;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.SimpleMenuProvider;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.network.NetworkHooks;
import org.jetbrains.annotations.Nullable;

public class PERArmor extends PEArmor {
    private final PERMatterType matterType;
    private final Type armorPiece;

    public PERArmor(PERMatterType matterType, Type armorPiece) {
        super(PERItems.PERArmorMaterial.getTypeOnMatterType(matterType), armorPiece, new Properties());
        this.matterType = matterType;
        this.armorPiece = armorPiece;
    }
    @Override public float getFullSetBaseReduction() {
        return 1.0F;
    }
    @Override public float getMaxDamageAbsorb(Type type, DamageSource damageSource) {
        return Float.MAX_VALUE;
    }
    public PERMatterType getMatterType() {
        return matterType;
    }

    @Override public @Nullable ICapabilityProvider initCapabilities(ItemStack stack, @Nullable CompoundTag nbt) {
        if (matterType == PERMatterType.INF) return new PERArmorCapabilityProvider(stack);
        return super.initCapabilities(stack, nbt);
    }
    @Override public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pHand) {
        if (!(matterType == PERMatterType.INF)) return super.use(pLevel, pPlayer, pHand);
        if (!pPlayer.isShiftKeyDown()) return super.use(pLevel, pPlayer, pHand);
        if (!pLevel.isClientSide) {
            ItemStack stack = pPlayer.getItemInHand(pHand); NetworkHooks.openScreen((ServerPlayer) pPlayer, new SimpleMenuProvider(
                            (id, inv, p) -> new PERArmorStorageMenu(id, inv, stack), Component.literal("PER Armor (WIP)")
                    ), buf -> buf.writeBoolean(pHand == InteractionHand.MAIN_HAND)
            );
        }
        return InteractionResultHolder.sidedSuccess(pPlayer.getItemInHand(pHand), pLevel.isClientSide());
    }

    @Override public void onInventoryTick(ItemStack stack, Level level, Player player, int slotIndex, int selectedIndex) {
        if (level.isClientSide) return;
        if (player.getItemBySlot(armorPiece.getSlot()) == stack) {
            for (int i = 0; i < 3; i++) {
                PERUtil.getSlot(stack, i).inventoryTick(level, player, slotIndex, selectedIndex == slotIndex);
            }
        }
        super.onInventoryTick(stack, level, player, slotIndex, selectedIndex);
    }
}
