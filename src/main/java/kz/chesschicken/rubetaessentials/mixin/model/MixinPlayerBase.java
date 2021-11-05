package kz.chesschicken.rubetaessentials.mixin.model;

import kz.chesschicken.rubetaessentials.utils.ISkinProperties;
import net.minecraft.entity.Living;
import net.minecraft.entity.player.PlayerBase;
import net.minecraft.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.net.URL;

@Mixin(PlayerBase.class)
public abstract class MixinPlayerBase extends Living implements ISkinProperties {
    public MixinPlayerBase(Level arg) {
        super(arg);
    }

    @Inject(method = "<init>", at = @At("TAIL"))
    private void injectSetChar(Level arg, CallbackInfo ci) {
        this.texture = "/assets/rubetaessentials/textures/mob/char.png";
    }

    @Override
    public boolean isAlex() {
        if(status == 0)
            checkSkin();

        return status == 2;
    }

    @Unique byte status = 0;

    @Unique void checkSkin() {
        try {
            status = (byte) (ImageIO.read(new URL(this.texture)).getHeight() == 64 ? 2 : 1);
        } catch (IOException e) {
            status = 1;
        }
    }
}
