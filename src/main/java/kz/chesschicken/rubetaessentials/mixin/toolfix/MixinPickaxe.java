package kz.chesschicken.rubetaessentials.mixin.toolfix;

import kz.chesschicken.rubetaessentials.ConfigClass;
import net.minecraft.block.BlockBase;
import net.minecraft.item.tool.Pickaxe;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Pickaxe.class)
public class MixinPickaxe {
    @Shadow private static BlockBase[] effectiveBlocks;

    @SuppressWarnings("UnresolvedMixinReference")
    @Inject(method = "<clinit>", at = @At("TAIL"))
    private static void setOther(CallbackInfo ci) {
        if(ConfigClass.EnumConfigBooleans.STAIRS_MINING_FIX.getValue())
            effectiveBlocks = new BlockBase[] {
                    BlockBase.COBBLESTONE_STAIRS,
                    BlockBase.COBBLESTONE,
                    BlockBase.DOUBLE_STONE_SLAB,
                    BlockBase.STONE_SLAB,
                    BlockBase.STONE,
                    BlockBase.SANDSTONE,
                    BlockBase.MOSSY_COBBLESTONE,
                    BlockBase.IRON_ORE,
                    BlockBase.IRON_BLOCK,
                    BlockBase.COAL_ORE,
                    BlockBase.GOLD_BLOCK,
                    BlockBase.GOLD_ORE,
                    BlockBase.DIAMOND_ORE,
                    BlockBase.DIAMOND_BLOCK,
                    BlockBase.ICE,
                    BlockBase.NETHERRACK,
                    BlockBase.LAPIS_LAZULI_ORE,
                    BlockBase.LAPIS_LAZULI_BLOCK
        };
    }
}
