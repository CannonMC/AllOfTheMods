package com.cannonmc.allofthemods.init;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class AOTMRecipe {
	
	public static void init() {
		
		//Shaped crafting recipes
		GameRegistry.addRecipe(new ItemStack(AOTMItems.the_tool), new Object[]{"III", " I ", " I ", 'I', AOTMItems.the_item});
		GameRegistry.addRecipe(new ItemStack(AOTMBlocks.the_block), new Object[]{"III", "III", "III", 'I', AOTMItems.the_item});
		
		GameRegistry.addRecipe(new ItemStack(AOTMBlocks.the_stair, 4), new Object[]{"B  ", "BB ", "BBB", 'B', AOTMBlocks.the_block});
		GameRegistry.addRecipe(new ItemStack(AOTMBlocks.the_stair, 4), new Object[]{"  B", " BB", "BBB", 'B', AOTMBlocks.the_block});
		
		//Shapeless crafting recipes
		GameRegistry.addShapelessRecipe(new ItemStack(AOTMItems.the_item, 9), new Object[] {new ItemStack(AOTMBlocks.the_block)});
		
		//Smelting
		GameRegistry.addSmelting(AOTMBlocks.the_ore, new ItemStack(AOTMItems.the_item), 10.0f);
	}
}
