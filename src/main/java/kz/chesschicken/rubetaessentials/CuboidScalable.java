package kz.chesschicken.rubetaessentials;

import net.minecraft.client.model.Cuboid;

public class CuboidScalable extends Cuboid {
    public int scalex;
    public int scaley;

    public CuboidScalable(int i, int j) {
        super(i, j);
        this.scalex = 64;
        this.scaley = 32;
    }

    public CuboidScalable(int i, int j, int x, int y) {
        super(i, j);
        this.scalex = x;
        this.scaley = y;
    }


}
