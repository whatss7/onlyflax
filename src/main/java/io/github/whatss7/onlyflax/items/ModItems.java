package io.github.whatss7.onlyflax.items;

import io.github.whatss7.onlyflax.OnlyFlax;
import io.github.whatss7.onlyflax.blocks.ModBlocks;
import net.minecraft.world.entity.animal.Chicken;
import net.minecraft.world.entity.animal.Parrot;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.ComposterBlock;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.crafting.CompoundIngredient;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.Arrays;
import java.util.Collections;

public class ModItems {
    public static final DeferredRegister.Items ITEMS =
            DeferredRegister.createItems(OnlyFlax.MOD_ID);

    public static final DeferredItem<Item> FLAX = ITEMS.registerSimpleItem("flax");

    public static final DeferredItem<BlockItem> FLAX_SEEDS =
            ITEMS.register("flax_seeds",
                    () -> new ItemNameBlockItem(ModBlocks.FLAX_CROP.get(), new Item.Properties()));

    public static final DeferredItem<BlockItem> WILD_FLAX =
            ITEMS.registerSimpleBlockItem("wild_flax", ModBlocks.WILD_FLAX);

    public static final DeferredItem<BlockItem> FLAX_BALE =
            ITEMS.registerSimpleBlockItem("flax_bale", ModBlocks.FLAX_BALE);

    private static void setupCompostValue() {
        ComposterBlock.COMPOSTABLES.put(ModItems.FLAX_SEEDS.get(), 0.3F);
        ComposterBlock.COMPOSTABLES.put(ModItems.FLAX.get(), 0.65F);
        ComposterBlock.COMPOSTABLES.put(ModItems.WILD_FLAX.get(), 0.65F);
        ComposterBlock.COMPOSTABLES.put(ModItems.FLAX_BALE.get(), 0.85F);
    }

    private static void setupAnimalFoods() {
        Ingredient newChickenFood = Ingredient.of(ModItems.FLAX_SEEDS.get());
        Chicken.FOOD_ITEMS = new CompoundIngredient(Arrays.asList(Chicken.FOOD_ITEMS, newChickenFood)){};

        Collections.addAll(Parrot.TAME_FOOD, ModItems.FLAX_SEEDS.get());
    }

    public static void register(IEventBus eventBus) {
         ITEMS.register(eventBus);
    }

    public static void setupItemUsages(IEventBus eventBus) {
        eventBus.addListener((FMLCommonSetupEvent event) -> {
            event.enqueueWork(ModItems::setupCompostValue);
            event.enqueueWork(ModItems::setupAnimalFoods);
        });
    }
}
