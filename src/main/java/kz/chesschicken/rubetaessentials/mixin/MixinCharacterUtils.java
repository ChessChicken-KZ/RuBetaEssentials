package kz.chesschicken.rubetaessentials.mixin;

import lombok.SneakyThrows;
import net.minecraft.util.CharacterUtils;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

@Mixin(CharacterUtils.class)
public class MixinCharacterUtils {

    @SneakyThrows
    @ModifyVariable(method = "getValidCharacters", at = @At("STORE"), ordinal = 0)
    private static BufferedReader injectReturnRusFont(BufferedReader bufferedReader) {
        return new BufferedReader(new InputStreamReader(CharacterUtils.class.getResourceAsStream("/assets/rubetaessentials/font/russian.txt"), StandardCharsets.UTF_8));
    }

}
