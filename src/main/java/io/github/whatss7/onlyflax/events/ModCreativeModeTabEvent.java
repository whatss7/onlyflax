package io.github.whatss7.onlyflax.events;

import io.github.whatss7.onlyflax.OnlyFlax;
import io.github.whatss7.onlyflax.items.ModItems;
import net.minecraft.world.item.CreativeModeTabs;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;

@EventBusSubscriber(modid = OnlyFlax.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
public class ModCreativeModeTabEvent {
    @SubscribeEvent
    public static void buildCreativeTabContents(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == CreativeModeTabs.NATURAL_BLOCKS) {
            event.accept(ModItems.FLAX_SEEDS.get());
            event.accept(ModItems.WILD_FLAX.get());
        }
        if (event.getTabKey() == CreativeModeTabs.INGREDIENTS) {
            event.accept(ModItems.FLAX.get());
        }
        if (event.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS) {
            event.accept(ModItems.FLAX_BALE.get());
        }
    }
}
