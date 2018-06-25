package com.cannonmc.allofthemods;

import com.cannonmc.allofthemods.init.AOTMBlocks;
import com.cannonmc.allofthemods.init.AOTMItems;
import com.cannonmc.allofthemods.proxy.CommonProxy;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Reference.MODID, version = Reference.VERSION)
public class AllOfTheMods {
    //Test 3
    
    @SidedProxy(serverSide = Reference.SERVER_PROXY_CLASS, clientSide = Reference.CLIENT_PROXY_CLASS)
    public static CommonProxy proxy;
    
    public static final ModCreativeTab modCreativeTab = new ModCreativeTab("modCreativeTab");
    
    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
    	//Loads mod items
    	AOTMItems.init();
    	AOTMItems.register();
    	//Loads mod blocks
    	AOTMBlocks.init();
    	AOTMBlocks.register();
    }
    
    @EventHandler
    public void init(FMLInitializationEvent event) {
    	proxy.registerRenders();
    	
    }
    
    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
    	
    }
    
}
