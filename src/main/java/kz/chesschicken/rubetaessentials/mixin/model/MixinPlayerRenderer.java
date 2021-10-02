package kz.chesschicken.rubetaessentials.mixin.model;

import kz.chesschicken.rubetaessentials.IPRAdditional;
import kz.chesschicken.rubetaessentials.ISkinProperties;
import kz.chesschicken.rubetaessentials.model.ModelPlayer;
import kz.chesschicken.rubetaessentials.model.ModelPlayerAlex;
import net.minecraft.client.render.entity.LivingEntityRenderer;
import net.minecraft.client.render.entity.PlayerRenderer;
import net.minecraft.client.render.entity.model.Biped;
import net.minecraft.client.render.entity.model.EntityModelBase;
import net.minecraft.entity.EntityBase;
import net.minecraft.entity.player.PlayerBase;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PlayerRenderer.class)
public abstract class MixinPlayerRenderer extends LivingEntityRenderer implements IPRAdditional {
    @Shadow private Biped field_294;

    public MixinPlayerRenderer(EntityModelBase arg, float f) {
        super(arg, f);
    }

    @Unique private ModelPlayer modelAlex;
    @Unique private ModelPlayer modelSteve;

    //field_909, field_294
    @Inject(method = "<init>", at = @At("TAIL"))
    private void injectLoadModels(CallbackInfo ci) {
        modelAlex = new ModelPlayerAlex(0.0F);
        modelSteve = new ModelPlayer(0.0F);
    }


    @Inject(method = "render(Lnet/minecraft/entity/player/PlayerBase;DDDFF)V", at = @At("HEAD"))
    private void setCurrentModel(PlayerBase arg, double d, double d1, double d2, float f, float f1, CallbackInfo ci) {
        if(((ISkinProperties)arg).isAlex()) {
            this.field_909 = modelAlex;
            this.field_294 = modelAlex;
        } else {
            this.field_909 = modelSteve;
            this.field_294 = modelSteve;
        }
    }

    public void method_345_mod(EntityBase entityBase) {
        if(((ISkinProperties)entityBase).isAlex()) {
            this.field_909 = modelAlex;
            this.field_294 = modelAlex;
        } else {
            this.field_909 = modelSteve;
            this.field_294 = modelSteve;
        }
        this.field_294.handSwingProgress = 0.0F;
        this.field_294.setAngles(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
        this.field_294.field_622.method_1815(0.0625F);
        ((ModelPlayer)this.field_294).field_178732_b.method_1815(0.0625F);

    }

}
