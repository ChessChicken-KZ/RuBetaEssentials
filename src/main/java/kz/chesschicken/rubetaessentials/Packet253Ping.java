package kz.chesschicken.rubetaessentials;

import lombok.SneakyThrows;
import net.minecraft.network.PacketHandler;
import net.minecraft.packet.play.ChatMessage0x3Packet;

import java.io.DataInputStream;
import java.io.DataOutputStream;

public class Packet253Ping extends ChatMessage0x3Packet {
    public long serverTime = -1L, clientTime = -1L;

    @SuppressWarnings("unused")
    public Packet253Ping() {}

    public Packet253Ping(long serverTime, long clientTime) {
        this.serverTime = serverTime;
        this.clientTime = clientTime;
    }

    @SneakyThrows
    @Override
    public void read(DataInputStream in) {
        this.serverTime = in.readLong();
        this.clientTime = in.readLong();
    }

    @SneakyThrows
    @Override
    public void write(DataOutputStream out) {
        out.writeLong(this.serverTime);
        out.writeLong(this.clientTime);
    }

    @Override
    public void apply(PacketHandler handler) {
        InitClass.handlePing(this);
    }

    @Override
    public int length() {
        return 16;
    }
}
