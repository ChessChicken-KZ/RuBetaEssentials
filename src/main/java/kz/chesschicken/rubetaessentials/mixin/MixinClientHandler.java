package kz.chesschicken.rubetaessentials.mixin;

import kz.chesschicken.rubetaessentials.InitClass;
import kz.chesschicken.rubetaessentials.Packet253Ping;
import net.minecraft.client.Minecraft;
import net.minecraft.network.ClientPlayNetworkHandler;
import net.minecraft.network.PacketHandler;
import net.minecraft.packet.AbstractPacket;
import net.minecraft.packet.play.SendChatMessageC2S;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ClientPlayNetworkHandler.class)
public abstract class MixinClientHandler extends PacketHandler {
    @Shadow public abstract void sendPacket(AbstractPacket arg);

    @Shadow private Minecraft minecraft;

    @Inject(method = "handleChatMessage", at = @At("TAIL"))
    private void handlePingInfo(SendChatMessageC2S packet, CallbackInfo ci)
    {
        if(packet.message.contains("§4§2§6§8")) {
            sendPacket(new SendChatMessageC2S(minecraft.session.sessionId));
            sendPacket(new Packet253Ping(0L, System.currentTimeMillis()));
        }
    }

    @Inject(method = "handleChatMessage", at = @At("HEAD"))
    private void checkPing(SendChatMessageC2S packet, CallbackInfo ci)
    {
        if(packet instanceof Packet253Ping)
            InitClass.handlePing(packet);

    }
}
