package io.github.whatss7.onlyflax;

import io.github.whatss7.onlyflax.blocks.ModBlocks;
import io.github.whatss7.onlyflax.modifiers.ModBiomeModifiers;
import io.github.whatss7.onlyflax.items.ModItems;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModLoadingContext;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(OnlyFlax.MOD_ID)
public class OnlyFlax {
    public static final String MOD_ID = "onlyflax";

    public OnlyFlax() {
        // Load config
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, OnlyFlaxConfig.COMMON_SPEC);

        // Get eventBus
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        // Register items & blocks
        ModBlocks.register(eventBus);
        ModItems.register(eventBus);
        ModItems.setupItemUsages(eventBus);

        // Register wild flax features
        ModBiomeModifiers.register(eventBus);
    }
}
