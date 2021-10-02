package kz.chesschicken.rubetaessentials.mixin.network;

import kz.chesschicken.rubetaessentials.utils.Packet253Ping;
import net.minecraft.packet.AbstractPacket;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(AbstractPacket.class)
public abstract class MixinAbstractPacket {

    @Shadow
    static void register(int id, boolean flag, boolean flag1, Class arg) {
    }

    @SuppressWarnings("UnresolvedMixinReference")
    @Inject(method = "<clinit>", at = @At("TAIL"))
    private static void register(CallbackInfo ci) {
       register(253, true ,true, Packet253Ping.class);
    }

}
