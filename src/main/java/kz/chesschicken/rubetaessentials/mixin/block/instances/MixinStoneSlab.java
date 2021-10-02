package kz.chesschicken.rubetaessentials.mixin.block.instances;

import net.minecraft.block.BlockBase;
import net.minecraft.block.StoneSlab;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(StoneSlab.class)
public abstract class MixinStoneSlab {
    @Final @Mutable @Shadow
    public static String[] field_2323;

    @Inject(method = "getTextureForSide(II)I", at = @At("RETURN"), cancellable = true)
    private void changeIfBrick(int side, int meta, CallbackInfoReturnable<Integer> cir) {
        if(meta == 4) {
            cir.setReturnValue(BlockBase.BRICKS.texture);
            cir.cancel();
        }
    }

    @SuppressWarnings("UnresolvedMixinReference")
    @Inject(method = "<clinit>", at = @At("TAIL"))
    private static void injectAndManipulateArray(CallbackInfo ci) {
        field_2323 = new String[] {
                "stone",
                "sand",
                "wood",
                "cobble",
                "brick"
        };
    }
}
