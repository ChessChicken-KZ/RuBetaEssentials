package kz.chesschicken.rubetaessentials.mixin.speedmining;

import net.minecraft.client.SinglePlayerClientInteractionManager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(SinglePlayerClientInteractionManager.class)
public interface AccessorSinglePlayerClientInteractionManager {
    @Accessor("hitDelay")
    void set_hitDelay(int i);
}
