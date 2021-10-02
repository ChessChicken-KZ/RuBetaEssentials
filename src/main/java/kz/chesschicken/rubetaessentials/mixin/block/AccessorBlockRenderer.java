package kz.chesschicken.rubetaessentials.mixin.block;

import net.minecraft.client.render.block.BlockRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(BlockRenderer.class)
public interface AccessorBlockRenderer {
    @Accessor("eastFaceRotation")
    void set_eastFaceRotation(int i);

    @Accessor("westFaceRotation")
    void set_westFaceRotation(int i);

    @Accessor("topFaceRotation")
    void set_topFaceRotation(int i);

    @Accessor("bottomFaceRotation")
    void set_bottomFaceRotation(int i);

    @Accessor("southFaceRotation")
    void set_southFaceRotation(int i);

    @Accessor("northFaceRotation")
    void set_northFaceRotation(int i);
}
