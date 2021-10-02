package kz.chesschicken.rubetaessentials.mixin.skin;

import net.minecraft.entity.player.PlayerBase;
import net.minecraft.entity.player.RemoteClientPlayer;
import net.minecraft.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(RemoteClientPlayer.class)
public abstract class MixinRemoteClientPlayer extends PlayerBase {
    public MixinRemoteClientPlayer(Level arg) {
        super(arg);
    }

    @Inject(method = "<init>", at = @At("TAIL"))
    private void inject1(Level arg, String name, CallbackInfo ci) {
        if (name != null && name.length() > 0)
            this.skinUrl = "http://assets.rubeta.net/skins/" + name + ".png";
    }
}
