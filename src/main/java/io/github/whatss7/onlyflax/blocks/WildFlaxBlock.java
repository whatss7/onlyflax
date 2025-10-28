package io.github.whatss7.onlyflax.blocks;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.BushBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

import javax.annotation.ParametersAreNonnullByDefault;

public class WildFlaxBlock extends BushBlock implements BonemealableBlock {
    public static final MapCodec<WildFlaxBlock> CODEC = MapCodec.unit(WildFlaxBlock::new);

    public WildFlaxBlock() {
        super(BlockBehaviour.Properties.ofFullCopy(Blocks.SHORT_GRASS).noCollission().instabreak().sound(SoundType.GRASS));
    }

    @Override
    @ParametersAreNonnullByDefault
    public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
        return 100;
    }

    @Override
    @ParametersAreNonnullByDefault
    public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
        return 60;
    }

    @Override
    @ParametersAreNonnullByDefault
    public boolean isValidBonemealTarget(LevelReader levelReader, BlockPos blockPos, BlockState blockState) {
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

    @Override
    @NotNull
    protected MapCodec<? extends BushBlock> codec() {
        return CODEC;
    }
}
