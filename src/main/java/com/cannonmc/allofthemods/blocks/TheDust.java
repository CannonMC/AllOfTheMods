package com.cannonmc.allofthemods.blocks;

import java.util.Random;

import com.cannonmc.allofthemods.init.AOTMItems;

import net.minecraft.block.BlockRedstoneWire;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;

public class TheDust extends BlockRedstoneWire{
	public void TheDustk() {
		
	}
	
	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		return AOTMItems.the_item;
	}
}
