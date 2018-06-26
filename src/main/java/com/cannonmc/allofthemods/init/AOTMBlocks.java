package com.cannonmc.allofthemods.init;

import com.cannonmc.allofthemods.AllOfTheMods;
import com.cannonmc.allofthemods.Reference;
import com.cannonmc.allofthemods.blocks.TheBlock;
import com.cannonmc.allofthemods.blocks.TheDoor;
import com.cannonmc.allofthemods.blocks.TheDust;
import com.cannonmc.allofthemods.blocks.TheOre;
import com.cannonmc.allofthemods.blocks.TheSkyRock;
import com.cannonmc.allofthemods.blocks.TheStair;
import com.cannonmc.allofthemods.blocks.secret.SecretBlock;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class AOTMBlocks {

	////The Collection
	public static Block the_ore;
	public static Block the_block;
	public static Block the_stair;
	public static Block the_sky_rock;
	//public static Block the_dust;
	//public static Block the_door;
	
	//Secret Blocks
	public static Block secret_stone;
	public static Block secret_wood;

	
	public static void init() {
		
		//The Collection
		the_ore = new TheOre(Material.rock).setUnlocalizedName("the_ore").setCreativeTab(AllOfTheMods.modCreativeTab);
		the_block = new TheBlock(Material.rock).setUnlocalizedName("the_block").setCreativeTab(AllOfTheMods.modCreativeTab);
		the_stair = new TheStair(the_block.getDefaultState()).setUnlocalizedName("the_stair").setCreativeTab(AllOfTheMods.modCreativeTab);
		the_sky_rock = new TheSkyRock(Material.rock).setUnlocalizedName("the_sky_rock").setCreativeTab(AllOfTheMods.modCreativeTab);
		//the_dust = new TheDust().setUnlocalizedName("the_dust").setCreativeTab(AllOfTheMods.WIPTab);
		//the_door = new TheDoor(Material.wood).setUnlocalizedName("the_door").setCreativeTab(AllOfTheMods.WIPTab);
		
		//Secret Blocks
		secret_stone = new SecretBlock(Material.rock).setUnlocalizedName("secret_stone").setCreativeTab(AllOfTheMods.SecretBlocksTab);
		secret_wood = new SecretBlock(Material.wood).setUnlocalizedName("secret_wood").setCreativeTab(AllOfTheMods.SecretBlocksTab);
	}

	public static void register() {
		//The Collection
		GameRegistry.registerBlock(the_ore, the_ore.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(the_block, the_block.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(the_stair, the_stair.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(the_sky_rock, the_sky_rock.getUnlocalizedName().substring(5));
		//GameRegistry.registerBlock(the_dust, the_dust.getUnlocalizedName().substring(5));
		//GameRegistry.registerBlock(the_door, the_door.getUnlocalizedName().substring(5));
		
		//Secret Blocks
		GameRegistry.registerBlock(secret_stone, secret_stone.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(secret_wood, secret_wood.getUnlocalizedName().substring(5));

	}

	public static void registerRenders() {
		
		//The Collection
		registerRender(the_ore);
		registerRender(the_block);
		registerRender(the_stair);
		registerRender(the_sky_rock);
		//registerRender(the_dust);
		//registerRender(the_door);
		
		//Secret Blocks
		registerRender(secret_stone);
		registerRender(secret_wood);
		
	}
	
	//Don't touch this
	public static void registerRender(Block block) {
		Item item = Item.getItemFromBlock(block);
		
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0,
				new ModelResourceLocation(Reference.MODID + ":" + item.getUnlocalizedName().substring(5), "inventory"));
	}

	
}
