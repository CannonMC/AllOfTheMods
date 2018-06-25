package com.cannonmc.allofthemods.init;

import com.cannonmc.allofthemods.AllOfTheMods;
import com.cannonmc.allofthemods.Reference;
import com.cannonmc.allofthemods.blocks.*;
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
	public static Block the_stair;
	public static Block the_dust;
	public static Block the_door;

	
	public static void init() {
		the_ore = new TheOre(Material.rock).setUnlocalizedName("the_ore").setCreativeTab(AllOfTheMods.modCreativeTab);
		the_block = new TheBlock(Material.rock).setUnlocalizedName("the_block").setCreativeTab(AllOfTheMods.modCreativeTab);
		the_stair = new TheStair(the_block.getDefaultState()).setUnlocalizedName("the_stair").setCreativeTab(AllOfTheMods.modCreativeTab);

		
		//WIP
		the_dust = new TheDust().setUnlocalizedName("the_dust").setCreativeTab(AllOfTheMods.WIPTab);
		the_door = new TheDoor(Material.wood).setUnlocalizedName("the_door").setCreativeTab(AllOfTheMods.WIPTab);
		
	}

	public static void register() {
		GameRegistry.registerBlock(the_ore, the_ore.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(the_block, the_block.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(the_stair, the_stair.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(the_dust, the_dust.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(the_door, the_door.getUnlocalizedName().substring(5));

	}

	public static void registerRenders() {
		//Register block
		registerRender(the_ore);
		registerRender(the_block);
		registerRender(the_stair);
		registerRender(the_dust);
		registerRender(the_door);
		
	}
	
	//Don't touch this
	public static void registerRender(Block block) {
		Item item = Item.getItemFromBlock(block);
		
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0,
				new ModelResourceLocation(Reference.MODID + ":" + item.getUnlocalizedName().substring(5), "inventory"));
	}
	
}
