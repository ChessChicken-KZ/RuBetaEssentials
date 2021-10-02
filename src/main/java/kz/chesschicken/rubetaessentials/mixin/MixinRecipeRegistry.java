package kz.chesschicken.rubetaessentials.mixin;

import net.minecraft.block.BlockBase;
import net.minecraft.item.ItemInstance;
import net.minecraft.recipe.RecipeRegistry;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(RecipeRegistry.class)
public abstract class MixinRecipeRegistry {
    @Shadow abstract void addShapedRecipe(ItemInstance output, Object... objects);

    @Inject(method = "<init>", at = @At("TAIL"))
    private void injectAddCustomRecipes(CallbackInfo ci) {
        this.addShapedRecipe(new ItemInstance(BlockBase.STONE_SLAB, 3, 4), "###", '#', BlockBase.BRICKS);
    }
}
