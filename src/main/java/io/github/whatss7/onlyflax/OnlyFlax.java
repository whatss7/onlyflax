package io.github.whatss7.onlyflax;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod("onlyflax")
public class OnlyFlax {
    public static final String MOD_ID = "onlyflax";

    public OnlyFlax() {
        ModItems.register(FMLJavaModLoadingContext.get().getModEventBus());
        ModBlocks.register(FMLJavaModLoadingContext.get().getModEventBus());
    }
}
