package com.kingjacob.datagen;

import com.kingjacob.block.ModBlocks;
import com.kingjacob.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
    public ModLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.BLOCK_OF_ROSE_QUARTZ);
        addDrop(ModBlocks.BLOCK_OF_OPAL);
        addDrop(ModBlocks.BLOCK_OF_RUBY);

        addDrop(ModBlocks.OPAL_ORE, oreDrops(ModBlocks.OPAL_ORE, ModItems.OPAL));
        addDrop(ModBlocks.DEEPSLATE_OPAL_ORE, oreDrops(ModBlocks.DEEPSLATE_OPAL_ORE, ModItems.OPAL));
        addDrop(ModBlocks.NETHER_RUBY_ORE, oreDrops(ModBlocks.NETHER_RUBY_ORE, ModItems.RUBY));
        addDrop(ModBlocks.ROSE_QUARTZ_ORE, oreDrops(ModBlocks.ROSE_QUARTZ_ORE, ModItems.ROSE_QUARTZ));
        addDrop(ModBlocks.DEEPSLATE_ROSE_QUARTZ_ORE, oreDrops(ModBlocks.DEEPSLATE_ROSE_QUARTZ_ORE, ModItems.ROSE_QUARTZ));

    }
}
