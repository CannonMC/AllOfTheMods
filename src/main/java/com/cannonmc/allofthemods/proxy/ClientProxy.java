package com.cannonmc.allofthemods.proxy;

import com.cannonmc.allofthemods.init.AOTMItems;

public class ClientProxy extends CommonProxy {

	@Override
	public void registerRenders() {
		AOTMItems.registerRenders();
	}
}
