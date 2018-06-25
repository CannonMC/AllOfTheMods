package com.cannonmc.allofthemods.init;

import com.cannonmc.allofthemods.AllOfTheMods;
import com.cannonmc.allofthemods.Reference;
import com.cannonmc.allofthemods.blocks.TheOre;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class AOTMBlocks {
	
	//Blocks
	public static Block the_ore;

	
	public static void init() {
		the_ore = new TheOre(Material.rock).setUnlocalizedName("the_ore").setCreativeTab(AllOfTheMods.modCreativeTab);;
		
	}

	public static void register() {
		GameRegistry.registerBlock(the_ore, the_ore.getUnlocalizedName().substring(5));
	}

	public static void registerRenders() {
		//Register block
		registerRender(the_ore);
		
	}

	public static void registerRender(Block block) {
		Item item = Item.getItemFromBlock(block);
		
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0,
				new ModelResourceLocation(Reference.MODID + ":" + item.getUnlocalizedName().substring(5), "inventory"));
	}
	
}
