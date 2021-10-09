package kz.chesschicken.rubetaessentials.mixin.skin;

import kz.chesschicken.rubetaessentials.ConfigClass;
import net.minecraft.client.Minecraft;
import net.minecraft.client.util.Session;
import net.minecraft.entity.player.AbstractClientPlayer;
import net.minecraft.entity.player.PlayerBase;
import net.minecraft.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import static kz.chesschicken.rubetaessentials.utils.DynmapChecker.isVisible;

@Mixin(AbstractClientPlayer.class)
public abstract class MixinAbstractClientPlayer extends PlayerBase {
    public MixinAbstractClientPlayer(Level arg) {
        super(arg);
    }

    @Inject(method = "<init>", at = @At("TAIL"))
    private void injectLoadNewSkin1(Minecraft minecraft, Level level, Session session, int dimensionId, CallbackInfo ci) {
        if (session != null && session.username != null && session.username.length() > 0)
            this.skinUrl = "http://assets.rubeta.net/skins/" + session.username + ".png";
        //this.skinUrl = "https://raw.githubusercontent.com/ChessChicken-KZ/AstolfoMod/master/src/main/resources/assets/astolfomod/stationapi/textures/astolfo_maid.png";
    }

    @Unique
    private byte tick = 0;

    @Inject(method = "updateDespawnCounter", at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/entity/player/PlayerBase;updateDespawnCounter()V",
            shift = At.Shift.BEFORE
    ))
    private void tickDynmapChecker(CallbackInfo ci) {
        if(this.level.isClient && ConfigClass.EnumConfigBooleans.DYNAMIC_DYNMAP.getValue()) {
            if(tick < 20)
                tick++;
            else {
                tick = 0;
                if(level.canRainAt((int)x, (int)y, (int)z)) {
                    if(!isVisible) {
                        isVisible = true;
                        AbstractClientPlayer.class.cast(this).sendChatMessage("/dynmap show");
                    }
                    System.out.println("HIT1");
                }else if(isVisible) {
                    isVisible = false;
                    AbstractClientPlayer.class.cast(this).sendChatMessage("/dynmap hide");
                    System.out.println("HIT2");
                }
            }
        }
    }
}
