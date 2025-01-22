package com.kingjacob.item;

import com.kingjacob.MoarOres;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item OPAL = registerItem( "opal", new Item(new Item.Settings()));
    public static final Item RUBY = registerItem( "ruby", new Item(new Item.Settings()));
    public static final Item ROSE_QUARTZ = registerItem( "rose_quartz", new Item(new Item.Settings()));
    public static final Item ROSE_HEART = registerItem( "rose_heart", new Item(new Item.Settings().food(ModFoodComponents.ROSE_HEART)));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(MoarOres.MOD_ID, name), item);
    }
    public static void registerModItems() {
        MoarOres.LOGGER.info("Registering Mod Items for " + MoarOres.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(OPAL);
            entries.add(RUBY);
            entries.add(ROSE_QUARTZ);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(entries -> {
            entries.add(ROSE_HEART);
        });
    }
}