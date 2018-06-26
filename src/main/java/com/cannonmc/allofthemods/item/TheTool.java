package com.cannonmc.allofthemods.item;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class TheTool extends ItemPickaxe {

	public TheTool(ToolMaterial material) {
		super(material);

	}
	
	public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer entity){
		float var4 = 1.0F;
		int i = (int)(entity.prevPosX + (entity.posX - entity.prevPosX) * (double)var4);
		int j = (int)(entity.prevPosY + (entity.posY - entity.prevPosY) * (double)var4 + 1.62D - (double)entity.getYOffset());
		int k = (int)(entity.prevPosZ + (entity.posZ - entity.prevPosZ) * (double)var4);

		if(true){
			EntityArrow entityarrow = new EntityArrow(world, (EntityLivingBase)entity, 6 * 2.0F);
			entityarrow.setDamage(6*2.0F);
			entityarrow.setKnockbackStrength(1);
			world.playSoundAtEntity(entity, "random.bow", 1.0F, 1.0F / (0.5F * 0.4F + 1.2F) + 6 * 0.5F);
		if (!world.isRemote) world.spawnEntityInWorld(entityarrow);
		}
			return itemstack;
		}

}
