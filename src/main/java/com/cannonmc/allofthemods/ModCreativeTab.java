package com.cannonmc.allofthemods;

import com.cannonmc.allofthemods.init.AOTMBlocks;
import com.cannonmc.allofthemods.init.AOTMItems;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;

public class ModCreativeTab extends CreativeTabs{
	
	public String TabInput; 

	public ModCreativeTab(String label) {
		super(label);
		TabInput = label;
		this.setBackgroundImageName("creativebg.png");

	}

	@Override
	public Item getTabIconItem() {
		
		if (TabInput == "modCreativeTab") {
			return AOTMItems.the_item;
		} else if(TabInput == "WIPTab") {
			return Items.paper;
		}else if(TabInput == "secretBlocksTab") {
			return Item.getItemFromBlock(AOTMBlocks.secret_stone);
		}
		
		return null;
		
	}

}
