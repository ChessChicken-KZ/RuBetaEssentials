package kz.chesschicken.rubetaessentials.mixin.skin;

import net.minecraft.client.ImageProcessorImpl;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

@Mixin(ImageProcessorImpl.class)
public abstract class MixinImageProcessorImpl {
    @Shadow private int field_2446;

    @Shadow private int field_2447;

    @Shadow private int[] field_2445;

    @Shadow protected abstract void method_1899(int i, int j, int k, int i1);

    @Shadow protected abstract void method_1898(int i, int j, int k, int i1);

    @Inject(method = "process", at = @At("HEAD"), cancellable = true)
    private void get32or64Skin(BufferedImage image, CallbackInfoReturnable<BufferedImage> cir) {
        if(image != null) {
            this.field_2446 = 64;
            this.field_2447 = 64;
            BufferedImage bufferedImage = new BufferedImage(this.field_2446, this.field_2447, 2);
            Graphics graphics = bufferedImage.getGraphics();
            graphics.drawImage(image, 0, 0, null);

            if (image.getHeight() == 32) {
                graphics.drawImage(bufferedImage, 24, 48, 20, 52, 4, 16, 8, 20, null);
                graphics.drawImage(bufferedImage, 28, 48, 24, 52, 8, 16, 12, 20, null);
                graphics.drawImage(bufferedImage, 20, 52, 16, 64, 8, 20, 12, 32, null);
                graphics.drawImage(bufferedImage, 24, 52, 20, 64, 4, 20, 8, 32, null);
                graphics.drawImage(bufferedImage, 28, 52, 24, 64, 0, 20, 4, 32, null);
                graphics.drawImage(bufferedImage, 32, 52, 28, 64, 12, 20, 16, 32, null);
                graphics.drawImage(bufferedImage, 40, 48, 36, 52, 44, 16, 48, 20, null);
                graphics.drawImage(bufferedImage, 44, 48, 40, 52, 48, 16, 52, 20, null);
                graphics.drawImage(bufferedImage, 36, 52, 32, 64, 48, 20, 52, 32, null);
                graphics.drawImage(bufferedImage, 40, 52, 36, 64, 44, 20, 48, 32, null);
                graphics.drawImage(bufferedImage, 44, 52, 40, 64, 40, 20, 44, 32, null);
                graphics.drawImage(bufferedImage, 48, 52, 44, 64, 52, 20, 56, 32, null);
            }

            graphics.dispose();
            this.field_2445 = ((DataBufferInt)bufferedImage.getRaster().getDataBuffer()).getData();
            this.method_1899(0, 0, 32, 16);
            this.method_1898(32, 0, 64, 32);
            this.method_1899(0, 16, 64, 32);
            this.method_1898(0, 32, 16, 48);
            this.method_1898(16, 32, 40, 48);
            this.method_1898(40, 32, 56, 48);
            this.method_1898(0, 48, 16, 64);
            this.method_1899(16, 48, 48, 64);
            this.method_1898(48, 48, 64, 64);
            cir.setReturnValue(bufferedImage);
        }else
            cir.setReturnValue(null);
        cir.cancel();
    }
}
