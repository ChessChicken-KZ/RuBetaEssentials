package kz.chesschicken.rubetaessentials.mixin.toolfix;

import kz.chesschicken.rubetaessentials.ConfigClass;
import net.minecraft.block.BlockBase;
import net.minecraft.item.tool.Hatchet;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Hatchet.class)
public class MixinHatchet {
    @Shadow private static BlockBase[] effectiveBlocks;

    @SuppressWarnings("UnresolvedMixinReference")
    @Inject(method = "<clinit>", at = @At("TAIL"))
    private static void setOther(CallbackInfo ci) {
        if(ConfigClass.EnumConfigBooleans.STAIRS_MINING_FIX.getValue())
            effectiveBlocks = new BlockBase[] {
                    BlockBase.STONE_SLAB,
                    BlockBase.WOOD,
                    BlockBase.BOOKSHELF,
                    BlockBase.LOG,
                    BlockBase.CHEST,
                    BlockBase.WOOD_STAIRS,
                    BlockBase.FENCE
        };
    }
}
