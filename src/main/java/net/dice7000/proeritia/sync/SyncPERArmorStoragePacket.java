package net.dice7000.proeritia.sync;

import net.dice7000.proeritia.common.menu.PERArmorStorageMenu;
import net.minecraft.client.Minecraft;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public class SyncPERArmorStoragePacket {
    private final int containerId;
    private final CompoundTag nbt;
    public SyncPERArmorStoragePacket(int containerId, CompoundTag nbt) {
        this.containerId = containerId; this.nbt = nbt;
    }

    public static void encode(SyncPERArmorStoragePacket msg, FriendlyByteBuf buf) {
        buf.writeInt(msg.containerId);
        buf.writeNbt(msg.nbt);
    }
    public static SyncPERArmorStoragePacket decode(FriendlyByteBuf buf) {
        return new SyncPERArmorStoragePacket(buf.readInt(), buf.readNbt());
    }

    public static void handle(SyncPERArmorStoragePacket msg, Supplier<NetworkEvent.Context> ctx) {
        ctx.get().enqueueWork(() -> {
            Player player = Minecraft.getInstance().player;
            if (player.containerMenu.containerId == msg.containerId && player.containerMenu instanceof PERArmorStorageMenu menu) {
                menu.handler.deserializeNBT(msg.nbt);
            }

            ctx.get().setPacketHandled(true);
        });
    }
}