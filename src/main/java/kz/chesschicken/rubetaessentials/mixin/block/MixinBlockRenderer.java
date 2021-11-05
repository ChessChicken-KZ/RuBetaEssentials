package kz.chesschicken.rubetaessentials.mixin.block;

import kz.chesschicken.rubetaessentials.utils.render.CustomInventoryRendering;
import kz.chesschicken.rubetaessentials.utils.render.CustomWorldRender;
import net.minecraft.block.BlockBase;
import net.minecraft.client.render.block.BlockRenderer;
import net.minecraft.level.BlockView;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(BlockRenderer.class)
public abstract class MixinBlockRenderer {

    @Shadow private BlockView blockView;

    @Inject(method = "render", at = @At("RETURN"), cancellable = true)
    private void injectRenderIfWood(BlockBase block, int blockX, int blockY, int blockZ, CallbackInfoReturnable<Boolean> cir) {
        if(block instanceof CustomWorldRender) {
            cir.setReturnValue(((CustomWorldRender)block).doWorldRendering(BlockRenderer.class.cast(this), this.blockView, block, blockX, blockY, blockZ));
            cir.cancel();
        }
    }

    @Inject(method = "method_48", at = @At("HEAD"), cancellable = true)
    private void injectRenderWoodInv(BlockBase arg, int i, float f, CallbackInfo ci) {
        if(arg instanceof CustomInventoryRendering) {
            ((CustomInventoryRendering)arg).doInventoryRendering(BlockRenderer.class.cast(this), arg, i, f);
            ci.cancel();
        }
    }


}
