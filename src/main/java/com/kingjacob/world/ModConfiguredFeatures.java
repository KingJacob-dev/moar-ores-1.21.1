package com.kingjacob.world;

import com.kingjacob.MoarOres;
import com.kingjacob.block.ModBlocks;
import net.minecraft.block.Blocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.structure.rule.BlockMatchRuleTest;
import net.minecraft.structure.rule.RuleTest;
import net.minecraft.structure.rule.TagMatchRuleTest;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.feature.OreFeatureConfig;

import java.util.List;

public class ModConfiguredFeatures {
    public static final RegistryKey<ConfiguredFeature<?,?>> OPAL_ORE_KEY = registerKey("opal_ore");
    public static final RegistryKey<ConfiguredFeature<?,?>> NETHER_RUBY_ORE_KEY = registerKey("nether_ruby_ore");
    public static final RegistryKey<ConfiguredFeature<?,?>> ROSE_QUARTZ_ORE_KEY = registerKey("rose_quartz_ore");

    public static void bootstrap(Registerable<ConfiguredFeature<?,?>> context) {
        RuleTest stoneReplaceables = new TagMatchRuleTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslateReplaceables = new TagMatchRuleTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);
        RuleTest netherReplaceables = new TagMatchRuleTest(BlockTags.BASE_STONE_NETHER);
        RuleTest endReplaceables = new BlockMatchRuleTest(Blocks.END_STONE);

        List<OreFeatureConfig.Target> overworldOpalOres =
                List.of(OreFeatureConfig.createTarget(stoneReplaceables, ModBlocks.OPAL_ORE.getDefaultState()),
                        OreFeatureConfig.createTarget(deepslateReplaceables, ModBlocks.DEEPSLATE_OPAL_ORE.getDefaultState()));

        List<OreFeatureConfig.Target> overworldRoseQuartzOres =
                List.of(OreFeatureConfig.createTarget(stoneReplaceables, ModBlocks.ROSE_QUARTZ_ORE.getDefaultState()),
                        OreFeatureConfig.createTarget(deepslateReplaceables, ModBlocks.DEEPSLATE_ROSE_QUARTZ_ORE.getDefaultState()));

        List<OreFeatureConfig.Target> netherRubyOres =
                List.of(OreFeatureConfig.createTarget(netherReplaceables, ModBlocks.NETHER_RUBY_ORE.getDefaultState()));

        // USE FOR 1.1 UPDATE
        //List<OreFeatureConfig.Target> endOnyxOres =
                //List.of(OreFeatureConfig.createTarget(endReplaceables, ModBlocks.END_ONYX_ORE.getDefaultState()));

        register(context, OPAL_ORE_KEY, Feature.ORE, new OreFeatureConfig(overworldOpalOres, 12));
        register(context, ROSE_QUARTZ_ORE_KEY, Feature.ORE, new OreFeatureConfig(overworldRoseQuartzOres, 12));
        register(context, NETHER_RUBY_ORE_KEY, Feature.ORE, new OreFeatureConfig(netherRubyOres, 9));
    }

    public static RegistryKey<ConfiguredFeature<?,?>> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, Identifier.of(MoarOres.MOD_ID, name));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<ConfiguredFeature<?, ?>> context,
                                                                                   RegistryKey<ConfiguredFeature<?,?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
