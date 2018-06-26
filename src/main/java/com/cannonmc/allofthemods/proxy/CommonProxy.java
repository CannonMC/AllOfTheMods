package com.cannonmc.allofthemods.proxy;

import com.cannonmc.allofthemods.init.AOTMOreGeneration;

import net.minecraftforge.fml.common.registry.GameRegistry;

public class CommonProxy {
	
	public void registerRenders() {
		
	}
	
	public void registerWorldGenerators() {
		GameRegistry.registerWorldGenerator(new AOTMOreGeneration(), 0);
	}
}
