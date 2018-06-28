package com.cannonmc.allofthemods.init;

import java.util.Random;

import com.cannonmc.allofthemods.structures.TestStructure;

import net.minecraft.block.Block;
import net.minecraft.block.state.pattern.BlockHelper;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class AOTMGeneration implements IWorldGenerator {

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator,
			IChunkProvider chunkProvider) {
		
		int blockX = chunkX * 16;
		int blockZ = chunkZ * 16;
		
		switch (world.provider.getDimensionId()) {
		case 0:
			generateOverworld(world, random, chunkX, chunkZ);
			generateStructureOverworld(world, random, blockX, blockZ);
			
			break;
		case 1:
			generateEnd(world, random, chunkX, chunkZ);
			break;
		case -1:
			generateNether(world, random, chunkX, chunkZ);
			break;

		}

	} 
	
	public static void init() {
		GameRegistry.registerWorldGenerator(new AOTMGeneration(), 0);
	}
	
	public void generateEnd(World world, Random rand, int x, int z) {

	}

	public void generateOverworld(World world, Random rand, int x, int z) {
		generateOre(AOTMBlocks.the_ore, world, rand, x, z, 3, 8, 10, 5, 40, Blocks.stone);
		generateOre(AOTMBlocks.the_sky_rock, world, rand, x, z, 1, 4, 1, 240, 250, Blocks.air);
		
	}
	
	public void generateStructureOverworld(World world, Random rand, int x, int z) {
		WorldGenerator genCabin = new TestStructure();
		// 25% of chunks can have a cabin
		final int CABIN_CHANCE = 25;
		if(rand.nextInt(100) < CABIN_CHANCE)
		{
			// get a random position in the chunk
			int randX = x + rand.nextInt(16);
			int randZ = z + rand.nextInt(16);
			// use our custom function to get the ground height
			int groundY = getGroundFromAbove(world, randX, randZ);
			genCabin.generate(world, rand, new BlockPos(randX, groundY + 1, randZ));
		}
		
	}

	public void generateNether(World world, Random rand, int x, int z) {

	}
	
	public void generateOre(Block block, World world, Random random, int chunkX, int chunkZ, 
			int minVienSize, int maxVienSize, int chance, int minY, int maxY, Block generateIn) {
		int vienSize = minVienSize + random.nextInt(maxVienSize - minVienSize);
		int heightRange = maxY - minY;
		WorldGenMinable gen = new WorldGenMinable(block.getDefaultState(), vienSize, BlockHelper.forBlock(generateIn));
		for(int i = 0; i < chance; i++) {
			int xRand = chunkX * 16 + random.nextInt(16);
			int yRand = random.nextInt(heightRange) + minY;
			int zRand = chunkZ * 16 + random.nextInt(16);
			BlockPos blockPos = new BlockPos(xRand, yRand, zRand);
			gen.generate(world, random, blockPos);
		}
	}
	
	
	public static int getGroundFromAbove(World world, int x, int z)
	{
		int y = 255;
		boolean foundGround = false;
		while(!foundGround && y-- >= 0)
		{
			Block blockAt = world.getBlockState(new BlockPos(x,y,z)).getBlock();
			// "ground" for our bush is grass or dirt
			foundGround = blockAt == Blocks.dirt || blockAt == Blocks.grass;
		}

		return y;
	}
	

}
