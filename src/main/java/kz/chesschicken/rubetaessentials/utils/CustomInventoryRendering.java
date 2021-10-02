package kz.chesschicken.rubetaessentials.utils;

import net.minecraft.block.BlockBase;
import net.minecraft.client.render.block.BlockRenderer;

public interface CustomInventoryRendering {
    void doInventoryRendering(BlockRenderer blockRenderer, BlockBase blockBase, int i, float f);
}
