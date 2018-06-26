package com.cannonmc.allofthemods.blocks.secret;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockBush;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;

public class SecretBlock extends BlockBush{

	public SecretBlock(Material materialIn) {
		super(materialIn);
		this.setBlockBounds(0F, 0F, 0F, 1F, 1F, 1F);
		
		this.setHardness(2.0f);
		this.setStepSound(this.soundTypeStone);
		
	}
	
	@Override
	public boolean canPlaceBlockOn(Block ground) {
		return true;
        
    }
	
	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		return Item.getItemFromBlock(this);
	}
	
}
