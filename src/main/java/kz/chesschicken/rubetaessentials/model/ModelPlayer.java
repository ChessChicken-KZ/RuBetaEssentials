package kz.chesschicken.rubetaessentials.model;

import kz.chesschicken.rubetaessentials.CuboidScalable;
import net.minecraft.client.model.Cuboid;
import net.minecraft.client.render.entity.model.Biped;
import org.lwjgl.opengl.GL11;

public class ModelPlayer extends Biped {
    public ModelPlayer(float f){
        this(f, 0.0F);
    }

    public ModelPlayer(float f, float f1){
        field_629 = false;
        field_628 = false;
        field_630 = false;
        field_627 = new CuboidScalable(0, 0, 64, 64);
        field_627.method_1818(-5F, 0.0F, -1F, 10, 16, 1, f);
        field_626 = new CuboidScalable(24, 0, 64, 64);
        field_626.method_1818(-3F, -6F, -1F, 6, 6, 1, f);
        field_178734_a = new CuboidScalable(48, 48, 64, 64);
        field_178734_a.method_1818(-1.0F, -2.0F, -2.0F, 4, 12, 4, f + 0.25F);
        field_178734_a.setRotationPoint(5.0F, 2.0F, 0.0F);
        field_178732_b = new CuboidScalable(40, 32, 64, 64);
        field_178732_b.method_1818(-3.0F, -2.0F, -2.0F, 4, 12, 4, f + 0.25F);
        field_178732_b.setRotationPoint(-5.0F, 2.0F, 10.0F);
        field_178733_c = new CuboidScalable(0, 48, 64, 64);
        field_178733_c.method_1818(-2.0F, 0.0F, -2.0F, 4, 12, 4, f + 0.25F);
        field_178733_c.setRotationPoint(1.9F, 12.0F, 0.0F);
        field_178731_d = new CuboidScalable(0, 32, 64, 64);
        field_178731_d.method_1818(-2.0F, 0.0F, -2.0F, 4, 12, 4, f + 0.25F);
        field_178731_d.setRotationPoint(-1.9F, 12.0F, 0.0F);
        field_178730_v = new CuboidScalable(16, 32, 64, 64);
        field_178730_v.method_1818(-4.0F, 0.0F, -2.0F, 8, 12, 4, f + 0.25F);
        field_178730_v.setRotationPoint(0.0F, 0.0F, 0.0F);
        field_623 = new CuboidScalable(32, 48, 64, 64);
        field_623.method_1818(-1.0F, -2.0F, -2.0F, 4, 12, 4, f);
        field_623.setRotationPoint(5.0F, 2.0F, 0.0F);
        field_625 = new CuboidScalable(16, 48, 64, 64);
        field_625.method_1818(-2.0F, 0.0F, -2.0F, 4, 12, 4, f);
        field_625.setRotationPoint(1.9F, 12.0F, 0.0F);
        field_619 = new CuboidScalable(0, 0, 64, 64);
        field_619.method_1818(-4F, -8F, -4F, 8, 8, 8, f);
        field_619.setRotationPoint(0.0F, 0.0F + f1, 0.0F);
        field_620 = new CuboidScalable(32, 0, 64, 64);
        field_620.method_1818(-4F, -8F, -4F, 8, 8, 8, f + 0.5F);
        field_620.setRotationPoint(0.0F, 0.0F + f1, 0.0F);
        field_621 = new CuboidScalable(16, 16, 64, 64);
        field_621.method_1818(-4F, 0.0F, -2F, 8, 12, 4, f);
        field_621.setRotationPoint(0.0F, 0.0F + f1, 0.0F);
        field_622 = new CuboidScalable(40, 16, 64, 64);
        field_622.method_1818(-3F, -2F, -2F, 4, 12, 4, f);
        field_622.setRotationPoint(-5F, 2.0F + f1, 0.0F);
        field_624 = new CuboidScalable(0, 16, 64, 64);
        field_624.method_1818(-2F, 0.0F, -2F, 4, 12, 4, f);
        field_624.setRotationPoint(-2F, 12F + f1, 0.0F);
    }

    @Override
    public void render(float f, float f1, float f2, float f3, float f4, float f5){
        super.render(f, f1, f2, f3, f4, f5);
        GL11.glPushMatrix();
        field_178734_a.method_1815(f5);
        field_178732_b.method_1815(f5);
        field_178733_c.method_1815(f5);
        field_178731_d.method_1815(f5);
        field_178730_v.method_1815(f5);
        GL11.glPopMatrix();
    }

    @Override
    public void setAngles(float f, float f1, float f2, float f3, float f4, float f5){
        super.setAngles(f, f1, f2, f3, f4, f5);
        applyRotations_Angles(this.field_625, this.field_178733_c);
        applyRotations_Angles(this.field_624, this.field_178731_d);
        applyRotations_Angles(this.field_623, this.field_178734_a);
        applyRotations_Angles(this.field_622, this.field_178732_b);
        applyRotations_Angles(this.field_621, this.field_178730_v);
    }

    public static void applyRotations_Angles(Cuboid CuboidScalable, Cuboid CuboidScalable1)
    {
        CuboidScalable1.pitch = CuboidScalable.pitch;
        CuboidScalable1.yaw = CuboidScalable.yaw;
        CuboidScalable1.roll = CuboidScalable.roll;
        CuboidScalable1.rotationPointX = CuboidScalable.rotationPointX;
        CuboidScalable1.rotationPointY = CuboidScalable.rotationPointY;
        CuboidScalable1.rotationPointZ = CuboidScalable.rotationPointZ;
    }

    @Override
    public void method_606(float f) {
        this.field_627.method_1815(f);
    }

    public CuboidScalable field_178734_a;
    public CuboidScalable field_178732_b;
    public CuboidScalable field_178733_c;
    public CuboidScalable field_178731_d;
    public CuboidScalable field_178730_v;
}
