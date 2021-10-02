package kz.chesschicken.rubetaessentials.mixin;

import lombok.SneakyThrows;
import net.minecraft.client.util.ThreadDownloadResources;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

import java.net.URL;

@Mixin(ThreadDownloadResources.class)
public class MixinThreadDownloadResources {

    @SneakyThrows
    @ModifyVariable(method = "run", at = @At("STORE"), ordinal = 0)
    private URL injectReturnFixed(URL url) {
        return new URL("http://client.rubeta.net/resources/");
    }

}
