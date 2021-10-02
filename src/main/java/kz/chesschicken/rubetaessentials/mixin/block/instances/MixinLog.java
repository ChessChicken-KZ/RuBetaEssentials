package kz.chesschicken.rubetaessentials.mixin.block.instances;

import kz.chesschicken.rubetaessentials.mixin.block.AccessorBlockRenderer;
import kz.chesschicken.rubetaessentials.utils.CustomInventoryRendering;
import kz.chesschicken.rubetaessentials.utils.CustomWorldRender;
import net.minecraft.block.BlockBase;
import net.minecraft.block.Log;
import net.minecraft.block.material.Material;
import net.minecraft.client.render.Tessellator;
import net.minecraft.client.render.block.BlockRenderer;
import net.minecraft.level.BlockView;
import net.minecraft.level.Level;
import org.lwjgl.opengl.GL11;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Log.class)
public abstract class MixinLog extends BlockBase implements CustomWorldRender, CustomInventoryRendering {
    protected MixinLog(int id, Material material) {
        super(id, material);
    }

    @Inject(method = "getTextureForSide", at = @At("HEAD"), cancellable = true)
    private void injectSet13Style(int side, int meta, CallbackInfoReturnable<Integer> cir) {
        int var3 = meta & 0xC;
        int var4 = meta & 0x3;
        cir.setReturnValue((var3 == 0 && (side == 1 || side == 0)) ? 21 : ((var3 == 4 && (side == 5 || side == 4)) ? 21 : ((var3 == 8 && (side == 2 || side == 3)) ? 21 : ((var4 == 1) ? 116 : ((var4 == 2) ? 117 : ((var4 == 3) ? 153 : 20))))));
        cir.cancel();
    }

    @Inject(method = "droppedMeta", at = @At("HEAD"), cancellable = true)
    private void injectDropFix(int meta, CallbackInfoReturnable<Integer> cir) {
        cir.setReturnValue(meta & 0x3);
        cir.cancel();
    }

    @Override
    public void onBlockPlaced(Level var1, int x, int y, int z, int facing) {
        byte b = 0;
        switch (facing) {
            case 0:
            case 1:
                b = 0;
                break;
            case 2:
            case 3:
                b = 8;
                break;
            case 4:
            case 5:
                b = 4;
                break;
        }
        var1.setTileMeta(x, y, z, ( (var1.getTileMeta(x, y, z) & 0x3) & 0x3) | b);
    }

    @Override
    public boolean doWorldRendering(BlockRenderer renderer, BlockView blockView, BlockBase blockBase, int x, int y, int z) {
        int var6 = blockView.getTileMeta(x, y, z) & 0xC;
        if (var6 == 4) {
            ((AccessorBlockRenderer)renderer).set_eastFaceRotation(1);
            ((AccessorBlockRenderer)renderer).set_westFaceRotation(1);
            ((AccessorBlockRenderer)renderer).set_topFaceRotation(1);
            ((AccessorBlockRenderer)renderer).set_bottomFaceRotation(1);
        } else if (var6 == 8) {
            ((AccessorBlockRenderer)renderer).set_southFaceRotation(1);
            ((AccessorBlockRenderer)renderer).set_northFaceRotation(1);
        }
        boolean r = renderer.renderStandardBlock(blockBase, x, y, z);
        ((AccessorBlockRenderer)renderer).set_eastFaceRotation(0);
        ((AccessorBlockRenderer)renderer).set_westFaceRotation(0);
        ((AccessorBlockRenderer)renderer).set_topFaceRotation(0);
        ((AccessorBlockRenderer)renderer).set_bottomFaceRotation(0);
        ((AccessorBlockRenderer)renderer).set_southFaceRotation(0);
        ((AccessorBlockRenderer)renderer).set_northFaceRotation(0);
        return r;
    }

    @Override
    public void doInventoryRendering(BlockRenderer blockRenderer, BlockBase blockBase, int i, float f) {
        Tessellator tessellator = Tessellator.INSTANCE;
        if (blockRenderer.field_81) {
            int colour = blockBase.getBaseColour(i);
            float r = (float) (colour >> 16 & 255) / 255.0F;
            float g = (float) (colour >> 8 & 255) / 255.0F;
            float b = (float) (colour & 255) / 255.0F;
            GL11.glColor4f(r * f, g * f, b * f, 1.0F);
        }
        blockBase.method_1605();
        GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
        tessellator.start();
        tessellator.setNormal(0.0F, -1.0F, 0.0F);
        blockRenderer.renderBottomFace(blockBase, 0.0D, 0.0D, 0.0D, blockBase.getTextureForSide(0, i));
        tessellator.draw();
        tessellator.start();
        tessellator.setNormal(0.0F, 1.0F, 0.0F);
        blockRenderer.renderTopFace(blockBase, 0.0D, 0.0D, 0.0D, blockBase.getTextureForSide(1, i));
        tessellator.draw();
        tessellator.start();
        tessellator.setNormal(0.0F, 0.0F, -1.0F);
        blockRenderer.renderEastFace(blockBase, 0.0D, 0.0D, 0.0D, blockBase.getTextureForSide(2, i));
        tessellator.draw();
        tessellator.start();
        tessellator.setNormal(0.0F, 0.0F, 1.0F);
        blockRenderer.renderWestFace(blockBase, 0.0D, 0.0D, 0.0D, blockBase.getTextureForSide(3, i));
        tessellator.draw();
        tessellator.start();
        tessellator.setNormal(-1.0F, 0.0F, 0.0F);
        blockRenderer.renderNorthFace(blockBase, 0.0D, 0.0D, 0.0D, blockBase.getTextureForSide(4, i));
        tessellator.draw();
        tessellator.start();
        tessellator.setNormal(1.0F, 0.0F, 0.0F);
        blockRenderer.renderSouthFace(blockBase, 0.0D, 0.0D, 0.0D, blockBase.getTextureForSide(5, i));
        tessellator.draw();
        GL11.glTranslatef(0.5F, 0.5F, 0.5F);
    }
}
