package kz.chesschicken.rubetaessentials.mixin.speedmining;

import kz.chesschicken.rubetaessentials.ConfigClass;
import net.minecraft.client.SinglePlayerClientInteractionManager;
import org.objectweb.asm.Opcodes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(SinglePlayerClientInteractionManager.class)
public class MixinSinglePlayerClientInteractionManager {
    @Redirect(method = "method_1721", at = @At(
            value = "FIELD",
            target = "Lnet/minecraft/client/SinglePlayerClientInteractionManager;hitDelay:I",
            opcode = Opcodes.PUTFIELD
    ))
    private void redirectToZero2(SinglePlayerClientInteractionManager long_name, int value) {
        ((AccessorSinglePlayerClientInteractionManager)long_name).set_hitDelay(ConfigClass.EnumConfigBooleans.FAST_BLOCK_MINING_FIX.getValue() ? 0 : value);
    }
}
