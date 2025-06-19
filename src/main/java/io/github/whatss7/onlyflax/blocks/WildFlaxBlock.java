package io.github.whatss7.onlyflax.blocks;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.BushBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class WildFlaxBlock extends BushBlock {
    public WildFlaxBlock() {
        super(BlockBehaviour.Properties.copy(Blocks.GRASS)
                .noCollission()
                .instabreak()
                .sound(SoundType.GRASS));
    }
}
