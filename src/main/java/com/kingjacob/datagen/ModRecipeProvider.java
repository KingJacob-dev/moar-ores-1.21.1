package com.kingjacob.datagen;

import com.kingjacob.block.ModBlocks;
import com.kingjacob.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.block.Block;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter exporter) {
        // OPAL RECIPES
        List<ItemConvertible> OPAL_SMELTABLES = List.of(ModBlocks.OPAL_ORE, ModBlocks.DEEPSLATE_OPAL_ORE);

        offerSmelting(exporter, OPAL_SMELTABLES, RecipeCategory.MISC, ModItems.OPAL, 0.25f, 200, "opal");
        offerBlasting(exporter, OPAL_SMELTABLES, RecipeCategory.MISC, ModItems.OPAL, 0.25f, 100, "opal");

        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.OPAL, RecipeCategory.MISC, ModBlocks.BLOCK_OF_OPAL);
        // RUBY RECIPES
        List<ItemConvertible> RUBY_SMELTABLES = List.of(ModBlocks.NETHER_RUBY_ORE);

        offerSmelting(exporter, RUBY_SMELTABLES, RecipeCategory.MISC, ModItems.RUBY, 0.25f, 200, "ruby");
        offerBlasting(exporter, RUBY_SMELTABLES, RecipeCategory.MISC, ModItems.RUBY, 0.25f, 100, "ruby");

        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.RUBY, RecipeCategory.MISC, ModBlocks.BLOCK_OF_RUBY);
        // ROSE QUARTZ RECIPES
        List<ItemConvertible> ROSE_QUARTZ_SMELTABLES = List.of(ModBlocks.ROSE_QUARTZ_ORE, ModBlocks.DEEPSLATE_ROSE_QUARTZ_ORE);

        offerSmelting(exporter, ROSE_QUARTZ_SMELTABLES, RecipeCategory.MISC, ModItems.ROSE_QUARTZ, 0.25f, 200, "rose_quartz");
        offerBlasting(exporter, ROSE_QUARTZ_SMELTABLES, RecipeCategory.MISC, ModItems.ROSE_QUARTZ, 0.25f, 100, "rose_quartz");

        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.ROSE_QUARTZ, RecipeCategory.MISC, ModBlocks.BLOCK_OF_ROSE_QUARTZ);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.ROSE_HEART)
                .pattern("RRR")
                .pattern("RBR")
                .pattern("RRR")
                .input('R', ModItems.ROSE_QUARTZ)
                .input('B', ModBlocks.BLOCK_OF_ROSE_QUARTZ)
                .criterion(hasItem(ModItems.ROSE_QUARTZ), conditionsFromItem(ModItems.ROSE_QUARTZ))
                .offerTo(exporter);

    }
}
