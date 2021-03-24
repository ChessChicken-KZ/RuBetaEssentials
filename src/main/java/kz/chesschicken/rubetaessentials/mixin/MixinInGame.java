package kz.chesschicken.rubetaessentials.mixin;

import kz.chesschicken.rubetaessentials.ExampleMod;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.InGame;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(InGame.class)
public class MixinInGame {
    @Shadow private Minecraft minecraft;

    @Inject(method = "renderHud", at = @At("TAIL"))
    private void render(float f, boolean flag, int i, int j, CallbackInfo ci)
    {
        if(!minecraft.options.debugHud && !minecraft.options.hideHud)
        {
            minecraft.textRenderer.drawText("Minecraft Beta 1.7.3", 2, 2, 14737632);
            minecraft.textRenderer.drawText("Ping: " + ExampleMod.ping, 115, 2, 14737632);
        }
    }

}
