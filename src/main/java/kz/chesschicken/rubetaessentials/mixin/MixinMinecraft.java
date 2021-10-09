package kz.chesschicken.rubetaessentials.mixin;

import net.minecraft.client.Minecraft;
import net.minecraft.client.options.GameOptions;
import net.minecraft.client.render.TextRenderer;
import net.minecraft.client.texture.TextureManager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Minecraft.class)
public class MixinMinecraft {
    @Shadow public TextureManager textureManager;
    @Shadow public GameOptions options;
    @Shadow public TextRenderer textRenderer;

    @Inject(method = "init", at = @At(
            value = "FIELD",
            target = "Lnet/minecraft/client/Minecraft;textRenderer:Lnet/minecraft/client/render/TextRenderer;",
            shift = At.Shift.AFTER
    ))
    private void injectLoadRussianFontPng(CallbackInfo ci) {
        this.textRenderer = new TextRenderer(this.options, "/assets/rubetaessentials/textures/font/russian.png", this.textureManager);
    }
}
