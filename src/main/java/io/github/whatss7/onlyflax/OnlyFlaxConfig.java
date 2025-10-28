package io.github.whatss7.onlyflax;

import net.neoforged.neoforge.common.ModConfigSpec;

public class OnlyFlaxConfig {

    public static final ModConfigSpec COMMON_SPEC;
    public static final Common COMMON;

    static {
        ModConfigSpec.Builder builder = new ModConfigSpec.Builder();
        COMMON = new Common(builder);
        COMMON_SPEC = builder.build();
    }

    public static class Common {

        public final ModConfigSpec.BooleanValue genWildFlax;

        public Common(ModConfigSpec.Builder builder) {
            String wildFlaxGenerationComment = """
                Starting in Minecraft 1.19.3, Only Flax uses JSON files to control the generation of wild flax.
                To customize world generation, please use a data pack to override the default behavior.""";
            builder.comment(wildFlaxGenerationComment).push("worldgen");

            genWildFlax = builder.comment("Should wild flax generate naturally?").define("genWildFlax", true);

            builder.pop();
        }
    }
}
