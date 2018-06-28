package com.cannonmc.allofthemods.init;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class AOTMRecipe {
	
	public static void init() {
		
		//Shaped crafting recipes
		GameRegistry.addRecipe(new ItemStack(AOTMItems.the_tool), new Object[]{"CCC", " C ", " C ", 'C', AOTMItems.the_compact_ingot});
		GameRegistry.addRecipe(new ItemStack(AOTMItems.the_ingot), new Object[]{"III", "III", "III", 'I', AOTMItems.the_item});
		GameRegistry.addRecipe(new ItemStack(AOTMBlocks.the_block), new Object[]{"III", "III", "III", 'I', AOTMItems.the_ingot});
		GameRegistry.addRecipe(new ItemStack(AOTMBlocks.the_stair, 4), new Object[]{"B  ", "BB ", "BBB", 'B', AOTMBlocks.the_block});
		GameRegistry.addRecipe(new ItemStack(AOTMBlocks.the_stair, 4), new Object[]{"  B", " BB", "BBB", 'B', AOTMBlocks.the_block});
		GameRegistry.addRecipe(new ItemStack(AOTMItems.the_compact_ingot), new Object[]{"BBB", "BBB", "BBB", 'B', AOTMBlocks.the_block});
		
		//Shapeless crafting recipes
		GameRegistry.addShapelessRecipe(new ItemStack(AOTMItems.the_item, 9), new Object[] {new ItemStack(AOTMBlocks.the_block)});
		GameRegistry.addShapelessRecipe(new ItemStack(AOTMItems.the_power_arrow), new Object[] {new ItemStack(AOTMItems.the_item), new ItemStack(Items.arrow)});
		
		GameRegistry.addShapelessRecipe(new ItemStack(AOTMItems.the_secret, 1), new Object[] {new ItemStack(AOTMItems.the_item), new ItemStack(Items.diamond)});
		GameRegistry.addShapelessRecipe(new ItemStack(AOTMBlocks.secret_stone, 2), new Object[] {new ItemStack(AOTMItems.the_secret), new ItemStack(Blocks.stone)});
		GameRegistry.addShapelessRecipe(new ItemStack(AOTMBlocks.secret_wood, 2), new Object[] {new ItemStack(AOTMItems.the_secret), new ItemStack(Blocks.planks)});
		
		
		//Smelting
		GameRegistry.addSmelting(AOTMBlocks.the_ore, new ItemStack(AOTMItems.the_item), 10.0f);
	}
}
