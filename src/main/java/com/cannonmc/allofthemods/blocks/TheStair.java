package com.cannonmc.allofthemods.blocks;

import net.minecraft.block.BlockStairs;
import net.minecraft.block.state.IBlockState;

public class TheStair extends BlockStairs{

	public TheStair(IBlockState modelState) {
		super(modelState);
		
		//Block attributes
		this.setHardness(4.0f);
		this.setHarvestLevel("pickaxe", 3);
		this.setLightLevel(0.5f);
		this.setStepSound(this.soundTypeMetal);
	}

}
