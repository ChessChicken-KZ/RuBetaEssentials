package kz.chesschicken.rubetaessentials.mixin.network;

import kz.chesschicken.rubetaessentials.InitClass;
import kz.chesschicken.rubetaessentials.Packet253Ping;
import net.minecraft.client.Minecraft;
import net.minecraft.network.ClientPlayNetworkHandler;
import net.minecraft.network.PacketHandler;
import net.minecraft.packet.AbstractPacket;
import net.minecraft.packet.play.ChatMessage0x3Packet;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ClientPlayNetworkHandler.class)
public abstract class MixinClientHandler extends PacketHandler {
    @Shadow public abstract void sendPacket(AbstractPacket arg);

    @Shadow private Minecraft minecraft;

    @Inject(method = "onChatMessage", at = @At("TAIL"))
    private void handlePingInfo(ChatMessage0x3Packet packet, CallbackInfo ci)
    {
        if(packet.message.contains("§4§2§6§8")) {
            sendPacket(new ChatMessage0x3Packet(minecraft.session.sessionId));
            sendPacket(new Packet253Ping(0L, System.currentTimeMillis()));
        }
    }

    @Inject(method = "onChatMessage", at = @At("HEAD"))
    private void checkPing(ChatMessage0x3Packet packet, CallbackInfo ci)
    {
        if(packet instanceof Packet253Ping)
            InitClass.handlePing(packet);

    }
}
