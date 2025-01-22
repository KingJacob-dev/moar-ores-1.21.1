package com.kingjacob.item;

import com.kingjacob.MoarOres;
import com.kingjacob.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {

    public static final ItemGroup OAM_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(MoarOres.MOD_ID, "moar_ores_items"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.OPAL))
                    .displayName(Text.translatable("itemgroup.kjgemstones.moar_ores_items"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.OPAL);
                        entries.add(ModBlocks.BLOCK_OF_OPAL);
                        entries.add(ModBlocks.OPAL_ORE);
                        entries.add(ModBlocks.DEEPSLATE_OPAL_ORE);
                        entries.add(ModItems.RUBY);
                        entries.add(ModBlocks.BLOCK_OF_RUBY);
                        entries.add(ModBlocks.NETHER_RUBY_ORE);
                        entries.add(ModItems.ROSE_QUARTZ);
                        entries.add(ModBlocks.BLOCK_OF_ROSE_QUARTZ);
                        entries.add(ModBlocks.ROSE_QUARTZ_ORE);
                        entries.add(ModBlocks.DEEPSLATE_ROSE_QUARTZ_ORE);
                        entries.add(ModItems.ROSE_HEART);

                    }).build());

    public static void registerItemGroups() {
        MoarOres.LOGGER.info("Registering Item Groups for " + MoarOres.MOD_ID);
    }
}