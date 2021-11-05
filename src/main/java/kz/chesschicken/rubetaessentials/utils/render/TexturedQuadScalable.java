package kz.chesschicken.rubetaessentials.utils.render;

import net.minecraft.client.render.QuadPoint;
import net.minecraft.client.render.TexturedQuad;

public class TexturedQuadScalable extends TexturedQuad {
    public TexturedQuadScalable(QuadPoint[] args, int i, int j, int k, int i1, int x, int y) {
        super(args);
        float var6 = 0.0015625F;
        float var7 = 0.003125F;
        args[0] = args[0].method_983((float)k / (float)x - var6, (float)j / (float)y + var7);
        args[1] = args[1].method_983((float)i / (float)x + var6, (float)j / (float)y + var7);
        args[2] = args[2].method_983((float)i / (float)x + var6, (float)i1 / (float)y - var7);
        args[3] = args[3].method_983((float)k / (float)x - var6, (float)i1/ (float)y - var7);
    }
}
