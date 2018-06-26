package com.cannonmc.allofthemods.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class TheBlock extends Block{

	public TheBlock(Material materialIn) {
		super(materialIn);
		
		//Block attributes
		this.setHardness(4.0f);
		this.setHarvestLevel("pickaxe", 1);
		this.setLightLevel(0.5f);
		this.setStepSound(this.soundTypeMetal);

	}
	
}
