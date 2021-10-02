package kz.chesschicken.rubetaessentials.mixin.model;

import kz.chesschicken.rubetaessentials.ISkinProperties;
import net.minecraft.entity.Living;
import net.minecraft.entity.player.PlayerBase;
import net.minecraft.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PlayerBase.class)
public abstract class MixinPlayerBase extends Living implements ISkinProperties {
    public MixinPlayerBase(Level arg) {
        super(arg);
    }

    @Inject(method = "<init>", at = @At("TAIL"))
    private void injectSetChar(Level arg, CallbackInfo ci) {
        this.texture = "/assets/rubetaessentials/textures/char.png";
    }

    @Override
    public boolean isAlex() {
        return true;
    }
}
