package kz.chesschicken.rubetaessentials.mixin;

import kz.chesschicken.rubetaessentials.ConfigClass;
import kz.chesschicken.rubetaessentials.utils.ButtonWeatherClient;
import net.minecraft.client.gui.screen.container.ContainerBase;
import net.minecraft.client.gui.screen.container.PlayerInventory;
import net.minecraft.client.gui.widgets.Button;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PlayerInventory.class)
public abstract class MixinPlayerInventory extends ContainerBase {
    public MixinPlayerInventory(net.minecraft.container.ContainerBase container) {
        super(container);
    }

    @Inject(method = "init", at = @At("TAIL"))
    private void initButtonsIfRuBeta(CallbackInfo ci) {
        if(this.minecraft.level.isClient && ConfigClass.EnumConfigBooleans.INVENTORY_BUTTONS.getValue()) {
            for(int i = 0; i < ButtonWeatherClient.commands.length; i++)
                this.buttons.add(new ButtonWeatherClient(10 + i, (this.width - this.containerWidth) / 2 - 22, (int) ((21 * i) + ((this.height / 2) - (ButtonWeatherClient.commands.length * 10.5))), 0, (20 * i)));
        }
    }

    @Inject(method = "buttonClicked", at = @At("HEAD"), cancellable = true)
    private void eventButtonsIfRuBeta(Button button, CallbackInfo ci) {
        if(button.visible && ConfigClass.EnumConfigBooleans.INVENTORY_BUTTONS.getValue() && button.id >= 10) {
            this.minecraft.player.sendChatMessage(ButtonWeatherClient.commands[button.id - 10]);
            ci.cancel();
        }
    }
}
