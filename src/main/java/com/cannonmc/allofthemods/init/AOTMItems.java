package com.cannonmc.allofthemods.init;

import com.cannonmc.allofthemods.Reference;

import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class AOTMItems {

	public static Item the_item;
	public static Item hello;

	public static void init() {
		the_item = new Item().setUnlocalizedName("the_item");
		hello = new Item().setUnlocalizedName("hello");
	}

	public static void register() {
		GameRegistry.registerItem(the_item, the_item.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(hello, hello.getUnlocalizedName().substring(5));
	}

	public static void registerRenders() {
		registerRender(the_item);
		registerRender(hello);
	}

	public static void registerRender(Item item) {
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0,
				new ModelResourceLocation(Reference.MODID + ":" + item.getUnlocalizedName().substring(5), "inventory"));
	}
}
