package kz.chesschicken.rubetaessentials.mixin.speedmining;

import net.minecraft.client.MultiPlayerClientInteractionManager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(MultiPlayerClientInteractionManager.class)
public interface AccessorMultiPlayerClientInteractionManager {
    @Accessor("field_2614")
    void set_field_2614(int i);
}
