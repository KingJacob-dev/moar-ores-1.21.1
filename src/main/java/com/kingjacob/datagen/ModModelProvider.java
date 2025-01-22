package com.kingjacob.datagen;

import com.kingjacob.block.ModBlocks;
import com.kingjacob.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.BLOCK_OF_OPAL);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.BLOCK_OF_RUBY);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.BLOCK_OF_ROSE_QUARTZ);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.OPAL_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DEEPSLATE_OPAL_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.NETHER_RUBY_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.ROSE_QUARTZ_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DEEPSLATE_ROSE_QUARTZ_ORE);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.OPAL, Models.GENERATED);
        itemModelGenerator.register(ModItems.RUBY, Models.GENERATED);
        itemModelGenerator.register(ModItems.ROSE_QUARTZ, Models.GENERATED);
        itemModelGenerator.register(ModItems.ROSE_HEART, Models.GENERATED);
    }
}
