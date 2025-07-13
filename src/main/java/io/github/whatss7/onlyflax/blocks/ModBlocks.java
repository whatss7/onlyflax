package io.github.whatss7.onlyflax.blocks;

import io.github.whatss7.onlyflax.OnlyFlax;
import net.minecraft.world.level.block.*;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS =
            DeferredRegister.createBlocks(OnlyFlax.MOD_ID);

    public static final DeferredBlock<Block> FLAX_CROP =
            BLOCKS.register("flax", FlaxCropBlock::new);

    public static final DeferredBlock<Block> WILD_FLAX =
            BLOCKS.register("wild_flax", WildFlaxBlock::new);

    public static final DeferredBlock<Block> FLAX_BALE =
            BLOCKS.register("flax_bale", FlaxBaleBlock::new);

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
