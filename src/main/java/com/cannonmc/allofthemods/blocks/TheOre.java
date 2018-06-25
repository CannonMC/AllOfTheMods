package com.cannonmc.allofthemods.blocks;

import java.util.Random;

import com.cannonmc.allofthemods.init.AOTMItems;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;

public class TheOre extends Block{
	
	public TheOre(Material materialIn) {
		super(materialIn);
		
		//Block attributes
		this.setHardness(2.0f);
		this.setHarvestLevel("pickaxe", 2);
		this.setStepSound(this.soundTypeStone);
	}
	
	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		return AOTMItems.the_item;
	}

}
