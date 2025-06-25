package io.github.whatss7.onlyflax;

import io.github.whatss7.onlyflax.blocks.ModBlocks;
import io.github.whatss7.onlyflax.features.ModFeatures;
import io.github.whatss7.onlyflax.items.ModItems;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod("onlyflax")
public class OnlyFlax {
    public static final String MOD_ID = "onlyflax";

    public OnlyFlax() {
        // Load config
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, OnlyFlaxConfig.COMMON_SPEC);
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        // Register items & blocks
        ModBlocks.register(eventBus);
        ModItems.register(eventBus);
        ModItems.setupItemUsages(eventBus);

        // Register wild flax features
        eventBus.addListener(ModFeatures::registerFeatures);
    }
}
