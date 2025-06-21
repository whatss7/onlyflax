package io.github.whatss7.onlyflax.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.BushBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.Random;

public class WildFlaxBlock extends BushBlock implements BonemealableBlock {
    public WildFlaxBlock() {
        super(BlockBehaviour.Properties.copy(Blocks.GRASS)
                .noCollission()
                .instabreak()
                .sound(SoundType.GRASS));
    }

    @Override
    public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
        return 100;
    }

    @Override
    public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
        return 60;
    }

    @Override
    @ParametersAreNonnullByDefault
    public boolean isValidBonemealTarget(BlockGetter level, BlockPos pos, BlockState state, boolean isClient) {
        return true;
    }

    @Override
    @ParametersAreNonnullByDefault
    public boolean isBonemealSuccess(Level level, RandomSource randomSource, BlockPos blockPos, BlockState blockState) {
        return randomSource.nextFloat() < 0.2F;
    }

    @Override
    @ParametersAreNonnullByDefault
    public void performBonemeal(ServerLevel level, RandomSource randomSource, BlockPos pos, BlockState state) {
        for (int tries = 0; tries < 5; tries++) {
            int dx = randomSource.nextInt(3) - 1;
            int dy = randomSource.nextInt(3) - 1;
            int dz = randomSource.nextInt(3) - 1;
            BlockPos randomPos = pos.offset(dx, dy, dz);

            if (level.isEmptyBlock(randomPos) && state.canSurvive(level, randomPos)) {
                level.setBlock(randomPos, this.defaultBlockState(), 2);
                break;
            }
        }
    }
}
