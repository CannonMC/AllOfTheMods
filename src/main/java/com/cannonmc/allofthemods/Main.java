package com.cannonmc.allofthemods;

import net.minecraft.client.Minecraft;
import net.minecraft.init.Blocks;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

@Mod(modid = Main.MODID, version = Main.VERSION)
public class Main {
    public static final String MODID = "allofthemods";
    public static final String VERSION = "1.1";
    //new test comment
    //James test
    
    private static Configuration config;
    private static int defaultValue;
    private static int fullbright;
    
    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
    	
    }
    
    public static String getMODID() {
        return "allofthemods";
    }
}
