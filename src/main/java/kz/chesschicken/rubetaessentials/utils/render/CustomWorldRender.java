package kz.chesschicken.rubetaessentials.utils.render;

import net.minecraft.block.BlockBase;
import net.minecraft.client.render.block.BlockRenderer;
import net.minecraft.level.BlockView;

public interface CustomWorldRender {
    boolean doWorldRendering(BlockRenderer renderer, BlockView blockView, BlockBase blockBase, int x, int y, int z);
}
