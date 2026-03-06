package io.github.whatss7.onlyflax.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.HayBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;

import javax.annotation.ParametersAreNonnullByDefault;

public class FlaxBaleBlock extends HayBlock {
    public FlaxBaleBlock(BlockBehaviour.Properties properties) {
        super(properties);
    }

    public static BlockBehaviour.Properties getProperties() {
        return BlockBehaviour.Properties.ofFullCopy(Blocks.HAY_BLOCK).strength(0.5f).sound(SoundType.GRASS);
    }

    @Override
    @ParametersAreNonnullByDefault
    public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
        return 20;
    }

    @Override
    @ParametersAreNonnullByDefault
    public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
        return 60;
    }
}
