package io.github.whatss7.onlyflax.blocks;

import com.mojang.serialization.MapCodec;
import io.github.whatss7.onlyflax.OnlyFlax;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(OnlyFlax.MOD_ID);

    public static final DeferredBlock<Block> FLAX_CROP = BLOCKS.register("flax",
            location -> new FlaxCropBlock(FlaxCropBlock.getProperties(location)));

    public static final DeferredBlock<Block> WILD_FLAX = BLOCKS.register("wild_flax",
            location -> new WildFlaxBlock(WildFlaxBlock.getProperties(location)));

    public static final DeferredBlock<Block> FLAX_BALE = BLOCKS.register("flax_bale",
            location -> new FlaxBaleBlock(FlaxBaleBlock.getProperties(location)));

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }

    public static final DeferredRegister<MapCodec<? extends Block>> REGISTRAR =
            DeferredRegister.create(BuiltInRegistries.BLOCK_TYPE, OnlyFlax.MOD_ID);

    public static final Supplier<MapCodec<WildFlaxBlock>> WILD_FLAX_CODEC = REGISTRAR.register(
            "wild_flax",
            () -> BlockBehaviour.simpleCodec(WildFlaxBlock::new)
    );
}
