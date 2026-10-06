package io.github.whatss7.onlyflax.blocks;

import io.github.whatss7.onlyflax.OnlyFlax;
import net.minecraft.world.level.block.Block;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.jetbrains.annotations.NotNull;

public final class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(OnlyFlax.MOD_ID);

    public static final DeferredBlock<@NotNull Block> FLAX_CROP = BLOCKS.register("flax",
            id -> new FlaxCropBlock(FlaxCropBlock.getProperties(id)));

    public static final DeferredBlock<@NotNull Block> WILD_FLAX = BLOCKS.register("wild_flax",
            id -> new WildFlaxBlock(WildFlaxBlock.getProperties(id)));

    public static final DeferredBlock<@NotNull Block> FLAX_BALE = BLOCKS.register("flax_bale",
            id -> new FlaxBaleBlock(FlaxBaleBlock.getProperties(id)));

    public static final DeferredBlock<@NotNull Block> FLAX_STRAW_BED = BLOCKS.register("flax_straw_bed",
            id -> new FlaxStrawBedBlock(FlaxStrawBedBlock.getProperties(id)));

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
