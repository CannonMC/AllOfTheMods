package com.cannonmc.allofthemods.noclosemychat;

import net.minecraft.network.play.server.*;
import net.minecraftforge.fml.relauncher.*;
import net.minecraft.network.play.*;
import net.minecraft.client.gui.*;
import net.minecraft.client.*;
import net.minecraft.network.*;

@SideOnly(Side.CLIENT)
public class temp extends S2EPacketCloseWindow
{
    public void processPacket(final INetHandlerPlayClient handler) {
        handler.handleCloseWindow((S2EPacketCloseWindow)this);
    }
    
    public void thisOnePlease(final INetHandlerPlayClient handler) {
        if (!(Minecraft.getMinecraft().currentScreen instanceof GuiChat)) {
            handler.handleCloseWindow((S2EPacketCloseWindow)this);
        }
    }
    
    public void thisTwoPlease(final INetHandlerPlayClient handler) {
        if (Minecraft.getMinecraft().currentScreen instanceof GuiChat) {
            return;
        }
        handler.handleCloseWindow((S2EPacketCloseWindow)this);
    }
}
