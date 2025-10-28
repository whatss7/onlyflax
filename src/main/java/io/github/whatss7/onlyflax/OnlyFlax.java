package io.github.whatss7.onlyflax;

import io.github.whatss7.onlyflax.blocks.ModBlocks;
import io.github.whatss7.onlyflax.modifiers.ModBiomeModifiers;
import io.github.whatss7.onlyflax.items.ModItems;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.ModLoadingContext;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;

@Mod(OnlyFlax.MOD_ID)
public class OnlyFlax {
    public static final String MOD_ID = "onlyflax";

    public OnlyFlax(ModContainer container, IEventBus modBus) {
        // Load config
        container.registerConfig(ModConfig.Type.COMMON, OnlyFlaxConfig.COMMON_SPEC);

        // Register items & blocks
        ModBlocks.register(modBus);
        ModItems.register(modBus);

        // Register wild flax features
        ModBiomeModifiers.register(modBus);
    }
}
