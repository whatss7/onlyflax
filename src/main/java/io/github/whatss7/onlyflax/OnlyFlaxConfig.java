package io.github.whatss7.onlyflax;

import net.minecraftforge.common.ForgeConfigSpec;

public class OnlyFlaxConfig {
    public static final ForgeConfigSpec COMMON_SPEC;
    public static final Common COMMON;

    static {
        ForgeConfigSpec.Builder builder = new ForgeConfigSpec.Builder();
        COMMON = new Common(builder);
        COMMON_SPEC = builder.build();
    }

    public static class Common {
        public final ForgeConfigSpec.BooleanValue genWildFlax;

        public Common(ForgeConfigSpec.Builder builder) {

            builder.comment("Starting in Minecraft 1.19.3, Only Flax uses JSON files to control the generation of wild flax.\n" +
                            "To customize world generation, please use a data pack to override the default behavior.")
                    .push("worldgen");

            genWildFlax = builder
                    .comment("Should wild flax generate naturally?")
                    .define("genWildFlax", true);

            builder.pop();
        }
    }
}
