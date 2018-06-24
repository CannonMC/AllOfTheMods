package com.cannonmc.allofthemods;

import com.cannonmc.allofthemods.init.AOTMItems;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ModCreativeTab extends CreativeTabs{

	public ModCreativeTab(String label) {
		super(label);
		this.setBackgroundImageName("creativebg.png");

	}

	@Override
	public Item getTabIconItem() {
		return AOTMItems.the_item;
	}

}
