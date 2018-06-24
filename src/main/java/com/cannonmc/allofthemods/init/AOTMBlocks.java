package com.cannonmc.allofthemods.init;

import com.cannonmc.allofthemods.AllOfTheMods;
import com.cannonmc.allofthemods.Reference;
import com.cannonmc.allofthemods.blocks.TheBlock;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class AOTMBlocks {
	
	public static Block the_block;

	public static void init() {
		the_block = new TheBlock(Material.iron).setUnlocalizedName("the_block").setCreativeTab(AllOfTheMods.modCreativeTab);;
		
	}

	public static void register() {
		GameRegistry.registerBlock(the_block, the_block.getUnlocalizedName().substring(5));
	}

	public static void registerRenders() {
		registerRender(the_block);
		
	}

	public static void registerRender(Block block) {
		Item item = Item.getItemFromBlock(block);
		
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0,
				new ModelResourceLocation(Reference.MODID + ":" + item.getUnlocalizedName().substring(5), "inventory"));
	}
	
}
