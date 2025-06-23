package io.github.whatss7.onlyflax.events;


import io.github.whatss7.onlyflax.OnlyFlax;
import io.github.whatss7.onlyflax.items.ModItems;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = OnlyFlax.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModCreativeModeTabEvent {
    @SubscribeEvent
    public static void buildCreativeTabContents(CreativeModeTabEvent.BuildContents event) {
        if (event.getTab() == CreativeModeTabs.NATURAL_BLOCKS) {
            event.accept(ModItems.FLAX_SEEDS.get());
            event.accept(ModItems.WILD_FLAX.get());
        }
        if (event.getTab() == CreativeModeTabs.INGREDIENTS) {
            event.accept(ModItems.FLAX.get());
        }
        if (event.getTab() == CreativeModeTabs.BUILDING_BLOCKS) {
            event.accept(ModItems.FLAX_BALE.get());
        }
    }
}
