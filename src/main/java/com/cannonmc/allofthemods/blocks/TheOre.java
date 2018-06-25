package com.cannonmc.allofthemods.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class TheOre extends Block{
	
	public TheOre(Material materialIn) {
		super(materialIn);
		
		//Block attributes
		this.setHardness(2.0f);
		this.setHarvestLevel("pickaxe", 2);
		this.setStepSound(this.soundTypeStone);
	}

}
