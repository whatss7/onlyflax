package io.github.whatss7.onlyflax.items;

import io.github.whatss7.onlyflax.OnlyFlax;
import io.github.whatss7.onlyflax.blocks.ModBlocks;
import net.minecraft.world.entity.animal.Chicken;
import net.minecraft.world.entity.animal.Parrot;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Item.Properties;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.ComposterBlock;
import net.minecraftforge.common.crafting.CompoundIngredient;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.Arrays;
import java.util.Collections;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, OnlyFlax.MOD_ID);

    public static final RegistryObject<Item> FLAX =
            ITEMS.register("flax",
                    () -> new Item(new Properties()));

    public static final RegistryObject<Item> FLAX_SEEDS =
            ITEMS.register("flax_seeds",
                    () -> new ItemNameBlockItem(ModBlocks.FLAX_CROP.get(), new Properties()));

    public static final RegistryObject<Item> WILD_FLAX =
            ITEMS.register("wild_flax",
                    () -> new ItemNameBlockItem(ModBlocks.WILD_FLAX.get(), new Properties()));

    public static final RegistryObject<Item> FLAX_BALE =
            ITEMS.register("flax_bale",
                    () -> new ItemNameBlockItem(ModBlocks.FLAX_BALE.get(), new Properties()));

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
