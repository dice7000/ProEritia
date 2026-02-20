package net.dice7000.proeritia.sync;

import net.dice7000.proeritia.ProEritia;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.PacketDistributor;
import net.minecraftforge.network.simple.SimpleChannel;

public class PERNetwork {
    private static final String PROTOCOL = "1";
    private static int packetId = 0;
    public static SimpleChannel CHANNEL;

    public static void register() {
        CHANNEL = NetworkRegistry.newSimpleChannel(
                ProEritia.PERLocation("main"),
                () -> PROTOCOL,
                PROTOCOL::equals,
                PROTOCOL::equals
        );
        CHANNEL.registerMessage(
                nextId(),
                SyncPERArmorStoragePacket.class,
                SyncPERArmorStoragePacket::encode,
                SyncPERArmorStoragePacket::decode,
                SyncPERArmorStoragePacket::handle
        );
    }

    private static int nextId() {
        return packetId++;
    }

    public static void sendToPlayer(Object msg, ServerPlayer player) {
        CHANNEL.send(PacketDistributor.PLAYER.with(() -> player), msg);
    }
    public static void sendToServer(Object msg) {
        CHANNEL.sendToServer(msg);
    }
}