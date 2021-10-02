package kz.chesschicken.rubetaessentials.mixin;

import kz.chesschicken.rubetaessentials.utils.gui.GuiModConfig;
import net.minecraft.client.gui.screen.ScreenBase;
import net.minecraft.client.gui.screen.ingame.Pause;
import net.minecraft.client.gui.widgets.Button;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Pause.class)
public class MixinPause extends ScreenBase {
    @Inject(method = "init", at = @At("TAIL"))
    private void injectAddButton(CallbackInfo ci) {
        this.buttons.add(new Button(12, this.width / 2 - 122, this.height / 4 + 80, 20, 20, "RE"));
    }

    @Inject(method = "buttonClicked", at = @At("HEAD"), cancellable = true)
    private void injectClickedButton(Button button, CallbackInfo ci) {
        if(button.active && button.id == 12) {
            minecraft.openScreen(new GuiModConfig(this));
            ci.cancel();
        }
    }
}
