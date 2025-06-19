package io.github.whatss7.onlyflax;

import io.github.whatss7.onlyflax.blocks.ModBlocks;
import io.github.whatss7.onlyflax.items.ModItems;
import net.minecraft.world.level.block.ComposterBlock;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod("onlyflax")
public class OnlyFlax {
    public static final String MOD_ID = "onlyflax";

    public OnlyFlax() {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
        ModItems.register(eventBus);
        ModBlocks.register(eventBus);
        eventBus.addListener(this::commonSetup);
    }

    private void commonSetup(FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            ComposterBlock.COMPOSTABLES.put(ModItems.FLAX_SEEDS.get(), 0.3F);
            ComposterBlock.COMPOSTABLES.put(ModItems.FLAX.get(), 0.5F);
        });
    }
}
