package io.github.whatss7.onlyflax.blocks;

import io.github.whatss7.onlyflax.OnlyFlax;
import net.minecraft.world.level.block.Block;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.jetbrains.annotations.NotNull;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(OnlyFlax.MOD_ID);

    public static final DeferredBlock<@NotNull Block> FLAX_CROP = BLOCKS.register("flax",
            location -> new FlaxCropBlock(FlaxCropBlock.getProperties(location)));

    public static final DeferredBlock<@NotNull Block> WILD_FLAX = BLOCKS.register("wild_flax",
            location -> new WildFlaxBlock(WildFlaxBlock.getProperties(location)));

    public static final DeferredBlock<@NotNull Block> FLAX_BALE = BLOCKS.register("flax_bale",
            location -> new FlaxBaleBlock(FlaxBaleBlock.getProperties(location)));

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
