package com.kingjacob;

import com.kingjacob.block.ModBlocks;
import com.kingjacob.item.ModFoodComponents;
import com.kingjacob.item.ModItemGroups;
import com.kingjacob.item.ModItems;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MoarOres implements ModInitializer {
	public static final String MOD_ID = "kjgemstones";

	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItemGroups.registerItemGroups();
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();

		LOGGER.info("Hello Fabric world!");
	}
}