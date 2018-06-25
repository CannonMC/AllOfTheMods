package com.cannonmc.allofthemods.init;

import com.cannonmc.allofthemods.AllOfTheMods;
import com.cannonmc.allofthemods.Reference;
import com.cannonmc.allofthemods.blocks.TheBlock;
import com.cannonmc.allofthemods.blocks.TheOre;
import com.cannonmc.allofthemods.init.AOTMItems;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class AOTMBlocks {
	
	//Blocks
	public static Block the_ore;
	public static Block the_block;

	
	public static void init() {
		the_ore = new TheOre(Material.rock).setUnlocalizedName("the_ore").setCreativeTab(AllOfTheMods.modCreativeTab);
		the_block = new TheBlock(Material.rock).setUnlocalizedName("the_block").setCreativeTab(AllOfTheMods.modCreativeTab);;
		
	}

	public static void register() {
		GameRegistry.registerBlock(the_ore, the_ore.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(the_block, the_block.getUnlocalizedName().substring(5));

	}

	public static void registerRenders() {
		//Register block
		registerRender(the_ore);
		registerRender(the_block);
		
	}
	
	//Don't touch this
	public static void registerRender(Block block) {
		Item item = Item.getItemFromBlock(block);
		
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0,
				new ModelResourceLocation(Reference.MODID + ":" + item.getUnlocalizedName().substring(5), "inventory"));
	}
	
}
