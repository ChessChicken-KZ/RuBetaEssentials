package kz.chesschicken.rubetaessentials.mixin.model;

import kz.chesschicken.rubetaessentials.IPRAdditional;
import net.minecraft.class_556;
import net.minecraft.client.Minecraft;
import net.minecraft.client.render.entity.PlayerRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(class_556.class)
public class Mixinclass_556 {
    @Shadow private Minecraft field_2401;

    @Redirect(method = "method_1860", at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/client/render/entity/PlayerRenderer;method_345()V"
    ))
    private void redirectUseModHand(PlayerRenderer playerRenderer) {
        ((IPRAdditional)playerRenderer).method_345_mod(this.field_2401.player);
    }
}
