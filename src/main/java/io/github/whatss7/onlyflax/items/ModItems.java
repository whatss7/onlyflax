package io.github.whatss7.onlyflax.items;

import io.github.whatss7.onlyflax.OnlyFlax;
import io.github.whatss7.onlyflax.blocks.ModBlocks;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(OnlyFlax.MOD_ID);

    public static final DeferredItem<Item> FLAX = ITEMS.registerSimpleItem("flax");

    public static final DeferredItem<BlockItem> FLAX_SEEDS = ITEMS.register("flax_seeds",
            () -> new ItemNameBlockItem(ModBlocks.FLAX_CROP.get(), new Item.Properties()));

    public static final DeferredItem<BlockItem> WILD_FLAX = ITEMS.registerSimpleBlockItem("wild_flax",
            ModBlocks.WILD_FLAX);

    public static final DeferredItem<BlockItem> FLAX_BALE = ITEMS.registerSimpleBlockItem("flax_bale",
            ModBlocks.FLAX_BALE);


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
