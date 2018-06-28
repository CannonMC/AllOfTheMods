package com.cannonmc.allofthemods.init;

import com.cannonmc.allofthemods.AllOfTheMods;
import com.cannonmc.allofthemods.Reference;
import com.cannonmc.allofthemods.item.TheDoorItem;
import com.cannonmc.allofthemods.item.TheTool;

import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class AOTMItems {

	//Items
	//The Collection
	//public static Item the_door_item;
	public static Item the_item;
	public static Item the_tool;
	public static Item the_secret;
	public static Item the_ingot;
	public static Item the_compact_ingot;
	public static Item the_power_arrow;
	
	
	
	//Tool materials
	public static final Item.ToolMaterial theMaterial = EnumHelper.addToolMaterial("theMaterial", 4, 1000, 20.0f, 8.0F, 20);

	
	public static void init() {
		//the_door_item = new TheDoorItem(AOTMBlocks.the_door).setUnlocalizedName("the_door_item").setCreativeTab(AllOfTheMods.WIPTab);
		the_item = new Item().setUnlocalizedName("the_item").setCreativeTab(AllOfTheMods.modCreativeTab);
		the_tool = new TheTool(theMaterial).setUnlocalizedName("the_tool").setCreativeTab(AllOfTheMods.modCreativeTab);
		the_secret = new Item().setUnlocalizedName("the_secret").setCreativeTab(AllOfTheMods.SecretBlocksTab);
		the_ingot = new Item().setUnlocalizedName("the_ingot").setCreativeTab(AllOfTheMods.modCreativeTab);
		the_compact_ingot = new Item().setUnlocalizedName("the_compact_ingot").setCreativeTab(AllOfTheMods.modCreativeTab);
		the_power_arrow = new Item().setUnlocalizedName("the_power_arrow").setCreativeTab(AllOfTheMods.modCreativeTab);
	
	}
	
	public static void register() {
		//Adding items
		//GameRegistry.registerItem(the_door_item, the_door_item.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(the_item, the_item.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(the_tool, the_tool.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(the_secret, the_secret.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(the_ingot, the_ingot.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(the_compact_ingot, the_compact_ingot.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(the_power_arrow, the_power_arrow.getUnlocalizedName().substring(5));

	}

	@SuppressWarnings("Duplicates")
	public static void registerRenders() {
		//Register Items
		//registerRender(the_door_item);
		registerRender(the_item);
		registerRender(the_tool);
		registerRender(the_secret);
		registerRender(the_ingot);
		registerRender(the_compact_ingot);
		registerRender(the_power_arrow);
	}
	
	//Don't touch this
	public static void registerRender(Item item) {
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0,
				new ModelResourceLocation(Reference.MODID + ":" + item.getUnlocalizedName().substring(5), "inventory"));
		
	}
}
