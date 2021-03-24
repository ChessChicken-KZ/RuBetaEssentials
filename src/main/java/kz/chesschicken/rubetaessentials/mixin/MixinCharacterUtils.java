package kz.chesschicken.rubetaessentials.mixin;

import net.minecraft.util.CharacterUtils;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

@Mixin(CharacterUtils.class)
public class MixinCharacterUtils {
    @Inject(method = "getValidCharacters", at = @At("HEAD"), cancellable = true)
    private static void russian(CallbackInfoReturnable<String> cir)
    {
        String var0 = "";

        try {
            BufferedReader var1 = new BufferedReader(new InputStreamReader(CharacterUtils.class.getResourceAsStream("/assets/rubetaessentials/russian.txt"), StandardCharsets.UTF_8));
            String var2;

            while((var2 = var1.readLine()) != null) {
                if (!var2.startsWith("#")) {
                    var0 = var0 + var2;
                }
            }

            var1.close();
        } catch (Exception e) { e.printStackTrace(); } //Rly?

        cir.setReturnValue(var0);
        cir.cancel();
    }
}
