package kz.chesschicken.rubetaessentials.mixin.skin;

import net.minecraft.client.Minecraft;
import net.minecraft.client.util.Session;
import net.minecraft.entity.player.AbstractClientPlayer;
import net.minecraft.entity.player.PlayerBase;
import net.minecraft.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(AbstractClientPlayer.class)
public abstract class MixinAbstractClientPlayer extends PlayerBase {
    public MixinAbstractClientPlayer(Level arg) {
        super(arg);
    }

    @Inject(method = "<init>", at = @At("TAIL"))
    private void injectLoadNewSkin1(Minecraft minecraft, Level level, Session session, int dimensionId, CallbackInfo ci) {
        if (session != null && session.username != null && session.username.length() > 0)
            this.skinUrl = "http://assets.rubeta.net/skins/" + session.username + ".png";
    }
}
