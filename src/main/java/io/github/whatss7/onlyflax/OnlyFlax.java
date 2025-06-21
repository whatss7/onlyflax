package io.github.whatss7.onlyflax;

import io.github.whatss7.onlyflax.blocks.ModBlocks;
import io.github.whatss7.onlyflax.modifiers.ModBiomeModifiers;
import io.github.whatss7.onlyflax.features.ModFeatures;
import io.github.whatss7.onlyflax.items.ModItems;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(OnlyFlax.MOD_ID)
public class OnlyFlax {
    public static final String MOD_ID = "onlyflax";

    public OnlyFlax(FMLJavaModLoadingContext context) {
        // Load config
        context.registerConfig(ModConfig.Type.COMMON, OnlyFlaxConfig.COMMON_SPEC);

        // Get eventBus
        IEventBus eventBus = context.getModEventBus();

        // Register items & blocks
        ModItems.register(eventBus);
        ModBlocks.register(eventBus);
        ModBiomeModifiers.register(eventBus);

        // Register wild flax features
        eventBus.addListener(ModFeatures::registerFeatures);
    }
}
