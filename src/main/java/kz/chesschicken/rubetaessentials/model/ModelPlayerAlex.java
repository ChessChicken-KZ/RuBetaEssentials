package kz.chesschicken.rubetaessentials.model;

import kz.chesschicken.rubetaessentials.CuboidScalable;

public class ModelPlayerAlex extends ModelPlayer {

    public ModelPlayerAlex(float f) {
        this(f, 0f);
    }

    public ModelPlayerAlex(float f, float f1){
        super(f, f1);
        field_178734_a = new CuboidScalable(48, 48, 64, 64);
        field_178734_a.method_1818(-1.0F, -2.0F, -2.0F, 3, 12, 4, f + 0.25F);
        field_178734_a.setRotationPoint(5.0F, 2.5F, 0.0F);
        field_178732_b = new CuboidScalable(40, 32, 64, 64);
        field_178732_b.method_1818(-2.0F, -2.0F, -2.0F, 3, 12, 4, f + 0.25F);
        field_178732_b.setRotationPoint(-5.0F, 2.5F, 10.0F);
        field_623 = new CuboidScalable(32, 48, 64, 64);
        field_623.method_1818(-1.0F, -2.0F, -2.0F, 3, 12, 4, f);
        field_623.setRotationPoint(5.0F, 2.5F, 0.0F);
        field_622 = new CuboidScalable(40, 16, 64, 64);
        field_622.method_1818(-2F, -2F, -2F, 3, 12, 4, f);
        field_622.setRotationPoint(-5F, 2.5F + f1, 0.0F);
    }
}
