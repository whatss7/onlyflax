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
        public final ForgeConfigSpec.IntValue flaxPatchCount;

        public Common(ForgeConfigSpec.Builder builder) {
            builder.push("worldgen");

            genWildFlax = builder
                    .comment("Should wild flax generate naturally?")
                    .define("genWildFlax", true);

            flaxPatchCount = builder
                    .comment("How dense should wild flax patches generate")
                    .defineInRange("density", 2, 0, 16);

            builder.pop();
        }
    }
}
