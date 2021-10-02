package kz.chesschicken.rubetaessentials.mixin.speedmining;

import net.minecraft.client.MultiPlayerClientInteractionManager;
import org.objectweb.asm.Opcodes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(MultiPlayerClientInteractionManager.class)
public class MixinMultiPlayerClientInteractionManager {
    @Redirect(method = "method_1721", at = @At(
            value = "FIELD",
            target = "Lnet/minecraft/client/MultiPlayerClientInteractionManager;field_2614:I",
            opcode = Opcodes.PUTFIELD
    ))
    private void redirectToZero1(MultiPlayerClientInteractionManager long_name, int value) {
        ((AccessorMultiPlayerClientInteractionManager)long_name).set_field_2614(0);
    }
}
