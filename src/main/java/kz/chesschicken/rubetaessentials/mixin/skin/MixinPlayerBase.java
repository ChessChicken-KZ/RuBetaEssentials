package kz.chesschicken.rubetaessentials.mixin.skin;

import net.minecraft.entity.Living;
import net.minecraft.entity.player.PlayerBase;
import net.minecraft.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PlayerBase.class)
public abstract class MixinPlayerBase extends Living {
    @Shadow public String playerCloakUrl;

    @Shadow public String name;

    public MixinPlayerBase(Level arg) {
        super(arg);
    }

    @Inject(method = "initCloak", at = @At("TAIL"), cancellable = true)
    private void injectLoadNewCloak1(CallbackInfo ci) {
        this.playerCloakUrl = "http://assets.rubeta.net/cloaks/" + this.name + ".png";
        this.cloakUrl = this.playerCloakUrl;
    }
}
