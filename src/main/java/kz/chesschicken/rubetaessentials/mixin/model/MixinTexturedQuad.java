package kz.chesschicken.rubetaessentials.mixin.model;

import net.minecraft.client.render.QuadPoint;
import net.minecraft.client.render.TexturedQuad;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(TexturedQuad.class)
public class MixinTexturedQuad {
    @Inject(method = "<init>([Lnet/minecraft/client/render/QuadPoint;IIII)V", at = @At("TAIL"))
    private void set64Type(QuadPoint[] args, int i, int j, int k, int i1, CallbackInfo ci) {
        k = 64;
        i1 = 64;
    }
}
