package io.github.whatss7.onlyflax.items;

import io.github.whatss7.onlyflax.OnlyFlax;
import io.github.whatss7.onlyflax.blocks.ModBlocks;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.storage.loot.providers.number.ints.ContextIntProviders;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.jetbrains.annotations.NotNull;

public final class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(OnlyFlax.MOD_ID);

    public static final DeferredItem<@NotNull Item> FLAX = ITEMS.registerSimpleItem(
            "flax", prop -> prop.compostable(ContextIntProviders.COMPOSTABLE_MEDIUM));

    public static final DeferredItem<@NotNull BlockItem> FLAX_SEEDS = ITEMS.registerItem(
            "flax_seeds", props -> new BlockItem(ModBlocks.FLAX_CROP.get(), props),
            () -> new Item.Properties().overrideDescription("item.onlyflax.flax_seeds")
                    .compostable(ContextIntProviders.COMPOSTABLE_LOW));

    public static final DeferredItem<@NotNull BlockItem> WILD_FLAX = ITEMS.registerSimpleBlockItem(
            "wild_flax", ModBlocks.WILD_FLAX,
            props -> props.compostable(ContextIntProviders.COMPOSTABLE_MEDIUM));

    public static final DeferredItem<@NotNull BlockItem> FLAX_BALE = ITEMS.registerSimpleBlockItem(
            "flax_bale", ModBlocks.FLAX_BALE,
            props -> props.compostable(ContextIntProviders.COMPOSTABLE_MEDIUM_HIGH));

    public static final DeferredItem<@NotNull BlockItem> FLAX_STRAW_BED = ITEMS.registerSimpleBlockItem(
            "flax_straw_bed", ModBlocks.FLAX_STRAW_BED,
            props -> props.compostable(ContextIntProviders.COMPOSTABLE_MEDIUM_HIGH));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
