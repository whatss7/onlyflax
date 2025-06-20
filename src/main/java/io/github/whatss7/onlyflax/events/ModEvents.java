package io.github.whatss7.onlyflax.events;

import io.github.whatss7.onlyflax.OnlyFlax;
import io.github.whatss7.onlyflax.OnlyFlaxConfig;
import io.github.whatss7.onlyflax.features.ModFeatures;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = OnlyFlax.MOD_ID)
public class ModEvents {
    @SubscribeEvent
    public static void onBiomeLoading(BiomeLoadingEvent event) {
        if (!OnlyFlaxConfig.COMMON.genWildFlax.get()) {
            return;
        }

        Biome.BiomeCategory category = event.getCategory();
        if (category == Biome.BiomeCategory.NETHER || category == Biome.BiomeCategory.THEEND) {
            return;
        }

        float temperature = event.getClimate().temperature;
        if (temperature > 0.3f && temperature < 0.85f) {
            event.getGeneration().addFeature(
                    GenerationStep.Decoration.VEGETAL_DECORATION,
                    ModFeatures.WILD_FLAX_FEATURE
            );
        }
    }
}
