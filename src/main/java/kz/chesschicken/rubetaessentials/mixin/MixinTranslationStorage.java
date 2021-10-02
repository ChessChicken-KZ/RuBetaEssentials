package kz.chesschicken.rubetaessentials.mixin;

import lombok.SneakyThrows;
import net.minecraft.client.resource.language.TranslationStorage;
import net.minecraft.util.CharacterUtils;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Properties;

@Mixin(TranslationStorage.class)
public class MixinTranslationStorage {
    @Shadow private Properties translations;

    @SneakyThrows
    @Inject(method = "<init>", at = @At("TAIL"))
    private void injectLoadCustomLang(CallbackInfo ci) {
        this.translations.load(CharacterUtils.class.getResourceAsStream("/assets/rubetaessentials/lang/en_US.lang"));
    }
}
