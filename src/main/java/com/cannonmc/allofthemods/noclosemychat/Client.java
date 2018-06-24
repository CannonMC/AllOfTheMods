package com.cannonmc.allofthemods.noclosemychat;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiChat;
import net.minecraft.network.play.INetHandlerPlayClient;
import net.minecraft.network.play.server.S2EPacketCloseWindow;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class Client extends S2EPacketCloseWindow
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
