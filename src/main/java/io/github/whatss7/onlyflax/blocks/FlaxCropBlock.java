package io.github.whatss7.onlyflax.blocks;

import io.github.whatss7.onlyflax.items.ModItems;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import org.checkerframework.checker.nullness.qual.NonNull;

public class FlaxCropBlock extends CropBlock {
    public FlaxCropBlock(BlockBehaviour.Properties properties) {
        super(properties);
    }

    public static BlockBehaviour.Properties getProperties() {
        return BlockBehaviour.Properties.ofFullCopy(Blocks.WHEAT);
    }

    @NonNull
    @Override
    protected ItemLike getBaseSeedId() {
        return ModItems.FLAX_SEEDS.get();
    }
}
