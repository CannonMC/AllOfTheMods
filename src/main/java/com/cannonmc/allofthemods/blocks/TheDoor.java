package com.cannonmc.allofthemods.blocks;

import net.minecraft.block.BlockDoor;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.IconFlipped;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class TheDoor extends BlockDoor {

    public Item placerItem;
    public Icon topDoorIcon;
    public Icon[] flippedIcons = new Icon[2];


    public TheDoor (Material materialIn) {
        super(materialIn);
        float f = 0.5F;
        float f1 = 1.0F;
        this.setLightOpacity(0);
        this.setBlockBounds(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, f1, 0.5F + f);
    }

    public Icon getBlockTexture(IBlockAccess par1IBlockAccess, int par2,
                                int par3, int par4, int par5) {
        if (par5 == 1 || par5 == 0) {
            return this.blockIcon;
        }
        int meta = getFullMetadata(par1IBlockAccess, par2, par3, par4);
        boolean flag = (meta & 4) != 0;
        int halfMeta = meta & 3;
        boolean flipped = false;

        if (flag) {
            if (halfMeta == 0 && par5 == 2)
                flipped = !flipped;
            else if (halfMeta == 1 && par5 == 5)
                flipped = !flipped;
            else if (halfMeta == 2 && par5 == 3)
                flipped = !flipped;
            else if (halfMeta == 3 && par5 == 4)
                flipped = !flipped;
        } else {
            if (halfMeta == 0 && par5 == 5)
                flipped = !flipped;
            else if (halfMeta == 1 && par5 == 3)
                flipped = !flipped;
            else if (halfMeta == 2 && par5 == 4)
                flipped = !flipped;
            else if (halfMeta == 3 && par5 == 2)
                flipped = !flipped;
            if ((meta & 16) != 0)
                flipped = !flipped;
        }

        if (flipped)
            return flippedIcons[(meta &)  != 0 ? 1 : 0];
        else
            return (meta &)  != 0 ? this.topDoorIcon : this.blockIcon;
    }

    public Icon getIcon(int par1, int par2) {
        return this.blockIcon;
    }

    public void registerIcons(IconRegister iconRegister) {
        this.blockIcon = iconRegister.registerIcon(AdobeInfo.NAME.toLowerCase()
                + ":adobe_door_lower");
        this.topDoorIcon = iconRegister.registerIcon(AdobeInfo.NAME
                .toLowerCase() + ":adobe_door_upper");
        this.flippedIcons[0] = new IconFlipped(blockIcon, true, false);
        this.flippedIcons[1] = new IconFlipped(topDoorIcon, true, false);
    }

    public int idPicked(World par1World, int par2, int par3, int par4) {
        return AdobeBlock.AdobeDoorItem.itemID;
    }

    public int idDropped(int par1, Random par2Random, int par3) {
        return (par1 &) != 0 ? 0 : (AdobeBlock.AdobeDoorItem.itemID);
    }

}
