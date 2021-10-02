package kz.chesschicken.rubetaessentials.mixin.model;

import net.minecraft.client.model.Cuboid;
import net.minecraft.client.render.entity.model.Biped;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Biped.class)
public class MixinBiped {
    @Shadow public Cuboid field_620;

    @Shadow public boolean field_630;

    @Inject(method = "setAngles", at = @At("TAIL"))
    private void injectPatch1(float f, float f1, float f2, float f3, float f4, float f5, CallbackInfo ci) {
        if(field_630)
            field_620.rotationPointY = 1.0F;
        else
            field_620.rotationPointY = 0.0F;
    }
}
