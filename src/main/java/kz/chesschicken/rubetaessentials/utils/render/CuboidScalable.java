package kz.chesschicken.rubetaessentials.utils.render;

import kz.chesschicken.rubetaessentials.mixin.model.AccessorCuboid;
import net.minecraft.client.model.Cuboid;
import net.minecraft.client.render.QuadPoint;
import net.minecraft.client.render.TexturedQuad;

public class CuboidScalable extends Cuboid {
    public int scalex;
    public int scaley;

    public CuboidScalable(int i, int j, int x, int y) {
        super(i, j);
        this.scalex = x;
        this.scaley = y;
    }

    public void method_1818(float f, float f1, float f2, int i, int j, int k, float f3) {
        ((AccessorCuboid)this).setCorners(new QuadPoint[8]);
        ((AccessorCuboid)this).setFaces(new TexturedQuad[6]);
        float f4 = f + (float) i;
        float f5 = f1 + (float) j;
        float f6 = f2 + (float) k;
        f -= f3;
        f1 -= f3;
        f2 -= f3;
        f4 += f3;
        f5 += f3;
        f6 += f3;
        if (mirror) {
            float f7 = f4;
            f4 = f;
            f = f7;
        }
        QuadPoint qp0 = new QuadPoint(f, f1, f2, 0.0F, 0.0F);
        QuadPoint qp1 = new QuadPoint(f4, f1, f2, 0.0F, 8F);
        QuadPoint qp2 = new QuadPoint(f4, f5, f2, 8F, 8F);
        QuadPoint qp3 = new QuadPoint(f, f5, f2, 8F, 0.0F);
        QuadPoint qp4 = new QuadPoint(f, f1, f6, 0.0F, 0.0F);
        QuadPoint qp5 = new QuadPoint(f4, f1, f6, 0.0F, 8F);
        QuadPoint qp6 = new QuadPoint(f4, f5, f6, 8F, 8F);
        QuadPoint qp7 = new QuadPoint(f, f5, f6, 8F, 0.0F);
        ((AccessorCuboid)this).getCorners()[0] = qp0;
        ((AccessorCuboid)this).getCorners()[1] = qp1;
        ((AccessorCuboid)this).getCorners()[2] = qp2;
        ((AccessorCuboid)this).getCorners()[3] = qp3;
        ((AccessorCuboid)this).getCorners()[4] = qp4;
        ((AccessorCuboid)this).getCorners()[5] = qp5;
        ((AccessorCuboid)this).getCorners()[6] = qp6;
        ((AccessorCuboid)this).getCorners()[7] = qp7;

        ((AccessorCuboid)this).getFaces()[0] = new TexturedQuadScalable(new QuadPoint[] {qp5, qp1, qp2, qp6 },  ((AccessorCuboid)this).getTextureOffsetX() + k + i,  ((AccessorCuboid)this).getTextureOffsetY()  + k,  ((AccessorCuboid)this).getTextureOffsetX()  + k + i + k, ((AccessorCuboid)this).getTextureOffsetY() + k + j, scalex, scaley);
        ((AccessorCuboid)this).getFaces()[1] = new TexturedQuadScalable(new QuadPoint[] {qp0, qp4, qp7, qp3 },  ((AccessorCuboid)this).getTextureOffsetX()  + 0, ((AccessorCuboid)this).getTextureOffsetY() + k,  ((AccessorCuboid)this).getTextureOffsetX()  + k, ((AccessorCuboid)this).getTextureOffsetY() + k + j, scalex, scaley);
        ((AccessorCuboid)this).getFaces()[2] = new TexturedQuadScalable(new QuadPoint[] {qp5, qp4, qp0, qp1 },  ((AccessorCuboid)this).getTextureOffsetX()  + k, ((AccessorCuboid)this).getTextureOffsetY() + 0,  ((AccessorCuboid)this).getTextureOffsetX()  + k + i, ((AccessorCuboid)this).getTextureOffsetY() + k, scalex, scaley);
        ((AccessorCuboid)this).getFaces()[3] = new TexturedQuadScalable(new QuadPoint[] {qp7, qp6, qp2, qp3 },  ((AccessorCuboid)this).getTextureOffsetX()  + k + i, ((AccessorCuboid)this).getTextureOffsetY() + 0,  ((AccessorCuboid)this).getTextureOffsetX()  + k + i + i, ((AccessorCuboid)this).getTextureOffsetY() + k, scalex, scaley);
        ((AccessorCuboid)this).getFaces()[4] = new TexturedQuadScalable(new QuadPoint[] {qp1, qp0, qp3, qp2 },  ((AccessorCuboid)this).getTextureOffsetX()  + k, ((AccessorCuboid)this).getTextureOffsetY() + k,  ((AccessorCuboid)this).getTextureOffsetX()  + k + i, ((AccessorCuboid)this).getTextureOffsetY() + k + j, scalex, scaley);
        ((AccessorCuboid)this).getFaces()[5] = new TexturedQuadScalable(new QuadPoint[] {qp4, qp5, qp6, qp7 },  ((AccessorCuboid)this).getTextureOffsetX()  + k + i + k, ((AccessorCuboid)this).getTextureOffsetY() + k,  ((AccessorCuboid)this).getTextureOffsetX()  + k + i + k + i, ((AccessorCuboid)this).getTextureOffsetY() + k + j, scalex, scaley);

        if (mirror) {
            for (TexturedQuad face : ((AccessorCuboid)this).getFaces()) {
                face.method_1925();
            }
        }



    }

}
