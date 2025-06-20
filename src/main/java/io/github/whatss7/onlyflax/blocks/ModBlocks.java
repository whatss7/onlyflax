package io.github.whatss7.onlyflax.blocks;

import io.github.whatss7.onlyflax.OnlyFlax;
import net.minecraft.world.level.block.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, OnlyFlax.MOD_ID);

    public static final RegistryObject<Block> FLAX_CROP =
            BLOCKS.register("flax", FlaxCropBlock::new);

    public static final RegistryObject<Block> WILD_FLAX =
            BLOCKS.register("wild_flax", WildFlaxBlock::new);

    public static final RegistryObject<Block> FLAX_BALE =
            BLOCKS.register("flax_bale", FlaxBaleBlock::new);

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
