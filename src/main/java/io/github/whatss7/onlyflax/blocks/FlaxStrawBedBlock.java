package io.github.whatss7.onlyflax.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.Util;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.StrawBedBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BedPart;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.Map;

public class FlaxStrawBedBlock extends StrawBedBlock {
    public FlaxStrawBedBlock(Properties properties) {
        super(properties);
    }

    public static BlockBehaviour.Properties getProperties(Identifier identifier) {
        return BlockBehaviour.Properties
                // .ofFullCopy(Blocks.STRAW_BED)  // Build from scratch to prevent MC-309755
                .of()
                .mapColor(MapColor.PLANT)
                .sound(SoundType.STRAW_BED)
                .strength(0.2F)
                .ignitedByLava()
                .pushReaction(PushReaction.POPPED)
                .setId(ResourceKey.create(Registries.BLOCK, identifier));
    }

    @Override
    @ParametersAreNonnullByDefault
    public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
        return 60;
    }

    @Override
    @ParametersAreNonnullByDefault
    public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
        return 30;
    }

    private static final VoxelShape BASE_SHAPE = Block.column(16.0, 0.0, 2.0);
    private static final VoxelShape PILLOW_SHAPE = Block.box(0.0, 0.0, 0.0, 16.0, 4.0, 8.0);
    private static final Map<Direction, VoxelShape> FOOT_SHAPES = Util.make(() -> Shapes.rotateHorizontal(BASE_SHAPE));
    private static final Map<Direction, VoxelShape> HEAD_SHAPES = Util.make(() -> Shapes.rotateHorizontal(Shapes.or(BASE_SHAPE, PILLOW_SHAPE)));

    @Override
    @NotNull
    @ParametersAreNonnullByDefault
    protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        Map<Direction, VoxelShape> shapes = state.getValue(PART) == BedPart.HEAD ? HEAD_SHAPES : FOOT_SHAPES;
        return shapes.get(getConnectedDirection(state).getOpposite());
    }
}
