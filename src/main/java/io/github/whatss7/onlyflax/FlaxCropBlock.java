package io.github.whatss7.onlyflax;

import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.CropBlock;
import org.checkerframework.checker.nullness.qual.NonNull;

public class FlaxCropBlock extends CropBlock {
    public FlaxCropBlock(Properties properties) {
        super(properties);
    }

    @NonNull
    @Override
    protected ItemLike getBaseSeedId() {
        return ModItems.FLAX_SEEDS.get();
    }
}
