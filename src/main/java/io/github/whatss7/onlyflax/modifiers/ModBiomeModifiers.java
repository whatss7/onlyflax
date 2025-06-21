package io.github.whatss7.onlyflax.modifiers;

import com.mojang.serialization.Codec;
import io.github.whatss7.onlyflax.OnlyFlax;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBiomeModifiers {
    public static final DeferredRegister<Codec<? extends BiomeModifier>> BIOME_MODIFIERS =
            DeferredRegister.create(ForgeRegistries.Keys.BIOME_MODIFIER_SERIALIZERS, OnlyFlax.MOD_ID);

    public static final RegistryObject<Codec<WildFlaxBiomeModifier>> WILD_FLAX_BIOME_MODIFIER =
            BIOME_MODIFIERS.register("add_wild_flax_feature", () -> WildFlaxBiomeModifier.CODEC);

    public static void register(IEventBus eventBus) {
        BIOME_MODIFIERS.register(eventBus);
    }
}
