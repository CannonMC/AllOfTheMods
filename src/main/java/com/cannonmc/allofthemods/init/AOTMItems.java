package com.cannonmc.allofthemods.init;

import com.cannonmc.allofthemods.AllOfTheMods;
import com.cannonmc.allofthemods.Reference;
import com.cannonmc.allofthemods.item.TheTool;

import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class AOTMItems {

	//Items
	public static Item the_item;
	public static Item the_tool;
	
	//Tool materials
	public static final Item.ToolMaterial theMaterial = EnumHelper.addToolMaterial("theMaterial", 4, 1000, 10.0f, 5.0F, 20);

	
	public static void init() {
		the_item = new Item().setUnlocalizedName("the_item").setCreativeTab(AllOfTheMods.modCreativeTab);
		the_tool = new TheTool(theMaterial).setUnlocalizedName("the_tool").setCreativeTab(AllOfTheMods.modCreativeTab);;
		
	}

	public static void register() {
		//Adding items
		GameRegistry.registerItem(the_item, the_item.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(the_tool, the_tool.getUnlocalizedName().substring(5));
		
		//Crafting recipes
		GameRegistry.addRecipe(new ItemStack(the_tool), new Object[]{"TTT",
				                                                     " T ",
				                                                     " T ", 'T', the_item});
		
	}

	public static void registerRenders() {
		//Register Items
		registerRender(the_item);
		registerRender(the_tool);
		
	}

	public static void registerRender(Item item) {
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0,
				new ModelResourceLocation(Reference.MODID + ":" + item.getUnlocalizedName().substring(5), "inventory"));
		
	}
}
