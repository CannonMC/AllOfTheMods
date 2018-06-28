package com.cannonmc.allofthemods.structures;

import java.util.Random;

import com.cannonmc.allofthemods.init.AOTMBlocks;
import com.google.common.collect.Lists;

import net.minecraft.block.Block;
import net.minecraft.block.BlockDoor;
import net.minecraft.block.BlockPlanks;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.util.BlockPos;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;

public class TestStructure extends WorldGenerator{
	
	/** BLUEPRINTS **/
	// Format: int[][] { {distanceRight, distanceUp, distanceBack} } 
	private final int[][] logsPos = new int[][] 
		{
			// corners (first layer)
			{0,0,0},{0,1,0},	// front-left
			{4,0,0},{4,1,0},	// front-right
			{4,0,4},{4,1,4},	// back-right
			{0,0,4},{0,1,4},	// back-left
			// upper trim (first part of roof)
			{0,2,0},{1,2,0},{2,2,0},{3,2,0},{4,2,0},	// front
			{0,2,4},{1,2,4},{2,2,4},{3,2,4},{4,2,4},	// back
			{0,2,1},{0,2,2},{0,2,3},	// left
			{4,2,1},{4,2,2},{4,2,3},	// right
			// roof
			{1,3,1},{2,3,1},{3,3,1},
			{1,3,2},{2,3,2},{3,3,2},
			{1,3,3},{2,3,3},{3,3,3}
		};
	private final int[][] planksPos = new int[][]
		{
			// floor
			{0,-1,0},{1,-1,0},{2,-1,0},{3,-1,0},{4,-1,0},
			{0,-1,1},{1,-1,1},{2,-1,1},{3,-1,1},{4,-1,1},
			{0,-1,2},{1,-1,2},{2,-1,2},{3,-1,2},{4,-1,2},
			{0,-1,3},{1,-1,3},{2,-1,3},{3,-1,3},{4,-1,3},
			{0,-1,4},{1,-1,4},{2,-1,4},{3,-1,4},{4,-1,4},
			// walls
			//// front
			{1,0,0},{2,0,0},{3,0,0},	
			{1,1,0},{2,1,0},{3,1,0},	
			//// right
			{4,0,1},{4,0,2},{4,0,3},
			{4,1,1},{4,1,2},{4,1,3},
			//// back
			{1,0,4},{2,0,4},{3,0,4},
			{1,1,4},{2,1,4},{3,1,4},
			//// left
			{0,0,1},{0,0,2},{0,0,3},
			{0,1,1},{0,1,2},{0,1,3}
		};
	private final int[] doorBottomPos = new int[] {2,0,0};
	private final int[] doorTopPos = new int[] {2,1,0};
	private final int[] workbenchPos = new int[] {2,0,3};
	private final int[] furnacePos = new int[] {3,0,3};
	private final int[] torchPos = new int[] {2,0,2};
	
	
	

	@Override
	public boolean generate(World worldIn, Random rand, BlockPos corner) {
		if(canSpawnHere(worldIn, corner))
		{
			// figure out each IBlockState we will use
			IBlockState spruceLogs = AOTMBlocks.the_sky_rock.getDefaultState();
			IBlockState sprucePlank = AOTMBlocks.the_block.getDefaultState();
			IBlockState doorLower = Blocks.oak_door.getDefaultState().withProperty(BlockDoor.HALF, BlockDoor.EnumDoorHalf.LOWER);
			IBlockState doorUpper = Blocks.oak_door.getDefaultState().withProperty(BlockDoor.HALF, BlockDoor.EnumDoorHalf.UPPER);
			IBlockState craftingTable = Blocks.crafting_table.getDefaultState();
			IBlockState furnace = Blocks.furnace.getDefaultState();
			IBlockState torch = Blocks.torch.getDefaultState();

			// build the layers using the arrays
			buildLayer(worldIn, corner, logsPos, spruceLogs);
			buildLayer(worldIn, corner, planksPos, sprucePlank);

			// place the other features LAST
			placeBlock(worldIn, corner, doorBottomPos, doorLower);
			placeBlock(worldIn, corner, doorTopPos, doorUpper);
			placeBlock(worldIn, corner, workbenchPos, craftingTable);
			placeBlock(worldIn, corner, furnacePos, furnace);
			placeBlock(worldIn, corner, torchPos, torch);
			// debug:
			System.out.println("Built a structure starting at " + corner + "!");
			return true;
		} else System.out.println("Sorry, can't spawn a structure at " + corner);
		return false;
	}
	
	private boolean canReplace(World world, BlockPos pos)
	{
		Block at = world.getBlockState(pos).getBlock();
		Material material = at.getMaterial();
		// we think it's replaceable if it's air / liquid / snow, plants, or leaves 
		return material.isReplaceable() || material == Material.plants || material == Material.leaves;
	}
	
	private boolean canSpawnHere(World world, BlockPos posAboveGround)
	{
		// check all the corners to see which ones are replaceable
		boolean corner1Air = canReplace(world, posAboveGround);
		boolean corner2Air = canReplace(world, posAboveGround.add(4, 0, 0));
		boolean corner4Air = canReplace(world, posAboveGround.add(0, 0, 4));
		boolean corner3Air = canReplace(world, posAboveGround.add(4, 0, 4));
		
		// if Y > 20 and all corners pass the test, it's okay to spawn the structure
		return posAboveGround.getY() > 20 && corner1Air && corner2Air && corner3Air && corner4Air;
	}

	private void buildLayer(World world, BlockPos frontLeftCorner, int[][] blockPositions, IBlockState toPlace)
	{
		// iterate through the entire int[][]
		for(int[] coord : blockPositions)
		{
			placeBlock(world, frontLeftCorner, coord[0], coord[1], coord[2], toPlace);
		}
	}
	
	/** Helper Method **/
	private void placeBlock(World world, BlockPos frontLeftCorner, int[] offsets, IBlockState toPlace)
	{
		placeBlock(world, frontLeftCorner, offsets[0], offsets[1], offsets[2], toPlace);
	}

	/** Places a block using corner position and offsets **/
	private void placeBlock(World world, BlockPos frontLeftCorner, int offsetX, int offsetY, int offsetZ, IBlockState toPlace)
	{	
		// figure out where that block is relative to the corner
		BlockPos placePos = frontLeftCorner.add(offsetX, offsetY, offsetZ);
		world.setBlockState(placePos, toPlace, 2);
	}
	

}
