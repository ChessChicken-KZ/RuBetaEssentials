package kz.chesschicken.rubetaessentials.mixin.model;

import net.minecraft.entity.Living;
import net.minecraft.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Living.class)
public class MixinLiving {
    @Shadow protected String texture;

    @Inject(method = "<init>", at = @At("TAIL"))
    private void initCharForLiving(Level arg, CallbackInfo ci) {
        this.texture = "/assets/rubetaessentials/textures/char.png";
    }
}
