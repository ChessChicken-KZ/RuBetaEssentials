package kz.chesschicken.rubetaessentials.mixin;

import kz.chesschicken.rubetaessentials.Packet253Ping;
import net.minecraft.packet.AbstractPacket;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(AbstractPacket.class)
public abstract class MixinAbstractPacket {
    private static boolean sw = false;
    @Shadow
    static void register(int id, boolean flag, boolean flag1, Class arg) {
    }

    @Inject(method = "<init>", at = @At("TAIL"))
    private void register(CallbackInfo ci)
    {
        if(!sw)
        {
            register(253, true ,true, Packet253Ping.class);
            sw = true;
        }
    }
}
