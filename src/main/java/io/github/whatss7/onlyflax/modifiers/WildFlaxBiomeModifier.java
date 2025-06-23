package io.github.whatss7.onlyflax.modifiers;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import io.github.whatss7.onlyflax.OnlyFlaxConfig;
import net.minecraft.core.Holder;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.common.world.ModifiableBiomeInfo;

public class WildFlaxBiomeModifier implements BiomeModifier {
    public static final Codec<WildFlaxBiomeModifier> CODEC = RecordCodecBuilder.create(instance -> instance.group(
            PlacedFeature.CODEC.fieldOf("feature").forGetter(m -> m.feature),
            GenerationStep.Decoration.CODEC.fieldOf("step").forGetter(m -> m.step)
    ).apply(instance, WildFlaxBiomeModifier::new));

    private final Holder<PlacedFeature> feature;
    private final GenerationStep.Decoration step;

    public WildFlaxBiomeModifier(Holder<PlacedFeature> feature, GenerationStep.Decoration step) {
        this.feature = feature;
        this.step = step;
    }

    @Override
    public void modify(Holder<Biome> biome, Phase phase, ModifiableBiomeInfo.BiomeInfo.Builder builder) {
        if (phase != Phase.ADD) return;

        if (!OnlyFlaxConfig.COMMON.genWildFlax.get()) return;

        if (biome.is(BiomeTags.IS_NETHER) || biome.is(BiomeTags.IS_END)) return;

        float temperature = biome.get().getBaseTemperature();

        if (temperature > 0.3f && temperature < 0.85f) {
            builder.getGenerationSettings().addFeature(step, feature);
        }
    }

    @Override
    public Codec<? extends BiomeModifier> codec() {
        return CODEC;
    }
}

