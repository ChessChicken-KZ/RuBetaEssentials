package kz.chesschicken.rubetaessentials.mixin.skin;

import net.minecraft.client.ImageProcessorImpl;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(ImageProcessorImpl.class)
public interface AccessorImageProcessorImpl {
    @Accessor("field_2446")
    void set_field_2446(int i);

    @Accessor("field_2447")
    void sed_field_2447(int i);
}
