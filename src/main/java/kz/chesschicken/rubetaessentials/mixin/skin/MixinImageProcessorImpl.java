package kz.chesschicken.rubetaessentials.mixin.skin;

import net.minecraft.client.ImageProcessorImpl;
import org.objectweb.asm.Opcodes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(ImageProcessorImpl.class)
public class MixinImageProcessorImpl {
    @Redirect(method = "process", at = @At(
            value = "FIELD",
            target = "Lnet/minecraft/client/ImageProcessorImpl;field_2447:I",
            opcode = Opcodes.PUTFIELD
    ))
    private void get64NormalSize(ImageProcessorImpl imageProcessor, int value) {
        ((AccessorImageProcessorImpl) imageProcessor).sed_field_2447(64);
    }
}
