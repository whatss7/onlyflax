package io.github.whatss7.onlyflax;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Item.Properties;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, OnlyFlax.MOD_ID);

    public static final RegistryObject<Item> FLAX =
            ITEMS.register("flax",
                    () -> new Item(new Properties().tab(CreativeModeTab.TAB_MATERIALS)));

    public static final RegistryObject<Item> FLAX_SEEDS =
            ITEMS.register("flax_seeds",
                    () -> new ItemNameBlockItem(ModBlocks.FLAX_CROP.get(),
                            new Properties().tab(CreativeModeTab.TAB_MATERIALS)));

    public static final RegistryObject<Item> WILD_FLAX =
            ITEMS.register("wild_flax",
                    () -> new ItemNameBlockItem(ModBlocks.WILD_FLAX.get(),
                            new Properties().tab(CreativeModeTab.TAB_MATERIALS)));

    public static void register(IEventBus eventBus) {
         ITEMS.register(eventBus);
    }
}
