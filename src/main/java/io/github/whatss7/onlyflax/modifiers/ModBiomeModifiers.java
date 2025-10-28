package io.github.whatss7.onlyflax.modifiers;

import com.mojang.serialization.Codec;
import io.github.whatss7.onlyflax.OnlyFlax;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.common.world.BiomeModifier;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

public class ModBiomeModifiers {
    public static final DeferredRegister<Codec<? extends BiomeModifier>> BIOME_MODIFIERS = DeferredRegister
            .create(NeoForgeRegistries.Keys.BIOME_MODIFIER_SERIALIZERS, OnlyFlax.MOD_ID);

    public static final DeferredHolder<Codec<? extends BiomeModifier>, Codec<WildFlaxBiomeModifier>> WILD_FLAX_BIOME_MODIFIER = BIOME_MODIFIERS
            .register("add_wild_flax_feature", () -> WildFlaxBiomeModifier.CODEC);

    public static void register(IEventBus eventBus) {
        BIOME_MODIFIERS.register(eventBus);
    }
}
