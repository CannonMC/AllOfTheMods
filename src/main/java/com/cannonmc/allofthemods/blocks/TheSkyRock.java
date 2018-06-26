package com.cannonmc.allofthemods.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class TheSkyRock extends Block{

	public TheSkyRock(Material materialIn) {
		super(materialIn);
		
		this.setHardness(5.0f);
		this.setHarvestLevel("pickaxe", 3);
		this.setStepSound(this.soundTypeStone);
	}

}
