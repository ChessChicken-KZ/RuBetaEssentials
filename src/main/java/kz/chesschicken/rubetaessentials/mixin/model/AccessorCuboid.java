package kz.chesschicken.rubetaessentials.mixin.model;

import net.minecraft.client.model.Cuboid;
import net.minecraft.client.render.QuadPoint;
import net.minecraft.client.render.TexturedQuad;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(Cuboid.class)
public interface AccessorCuboid {
    @Accessor("corners")
    void setCorners(QuadPoint[] q);

    @Accessor("corners")
    QuadPoint[] getCorners();

    @Accessor("faces")
    void setFaces(TexturedQuad[] q);

    @Accessor("faces")
    TexturedQuad[] getFaces();

    @Accessor("textureOffsetX")
    int getTextureOffsetX();

    @Accessor("testureOffsetY")
    int getTextureOffsetY();
}
