package io.github.whatss7.onlyflax.features;

import io.github.whatss7.onlyflax.OnlyFlax;
import io.github.whatss7.onlyflax.OnlyFlaxConfig;
import io.github.whatss7.onlyflax.blocks.ModBlocks;
import net.minecraft.core.Holder;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.*;
import net.minecraft.world.level.levelgen.feature.configurations.RandomPatchConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.placement.*;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

import java.util.List;

public class ModFeatures {
    public static Holder<ConfiguredFeature<?, ?>> WILD_FLAX_CONFIGURED_FEATURE;
    public static Holder<PlacedFeature> WILD_FLAX_FEATURE;

    public static void registerFeatures(final FMLCommonSetupEvent event) {
        ConfiguredFeature<?, ?> configuredFeature = new ConfiguredFeature<>(
                Feature.RANDOM_PATCH,
                new RandomPatchConfiguration(
                        16, 4, 2,
                        PlacementUtils.onlyWhenEmpty(
                                Feature.SIMPLE_BLOCK,
                                new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.WILD_FLAX.get()))
                        )
                )
        );

        WILD_FLAX_CONFIGURED_FEATURE = BuiltinRegistries.register(
                BuiltinRegistries.CONFIGURED_FEATURE,
                ResourceLocation.fromNamespaceAndPath(OnlyFlax.MOD_ID, "wild_flax_configured_feature"),
                configuredFeature);

        PlacedFeature placedFeature = new PlacedFeature(
                WILD_FLAX_CONFIGURED_FEATURE,
                List.of(
                        InSquarePlacement.spread(),
                        PlacementUtils.HEIGHTMAP,
                        RarityFilter.onAverageOnceEvery(OnlyFlaxConfig.COMMON.wildFlaxRarity.get()),
                        BiomeFilter.biome()
                ));

        WILD_FLAX_FEATURE = BuiltinRegistries.register(
                BuiltinRegistries.PLACED_FEATURE,
                ResourceLocation.fromNamespaceAndPath(OnlyFlax.MOD_ID, "wild_flax_feature"),
                placedFeature);
    }
}
