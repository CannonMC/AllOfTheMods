package com.cannonmc.allofthemods.item;

import com.cannonmc.allofthemods.init.AOTMItems;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class TheTool extends ItemPickaxe {

	public TheTool(ToolMaterial material) {
		super(material);
		this.isFull3D();

	}
	
	public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer entity){
		float var4 = 1.0F;
		int i = (int)(entity.prevPosX + (entity.posX - entity.prevPosX) * (double)var4);
		int j = (int)(entity.prevPosY + (entity.posY - entity.prevPosY) * (double)var4 + 1.62D - (double)entity.getYOffset());
		int k = (int)(entity.prevPosZ + (entity.posZ - entity.prevPosZ) * (double)var4);

		if(true && entity.inventory.hasItem(AOTMItems.the_power_arrow)){
			EntityArrow entityarrow = new EntityArrow(world, (EntityLivingBase)entity, 10F);
			entityarrow.setDamage(1.8F);
			entityarrow.setKnockbackStrength(2);
			world.playSoundAtEntity(entity, "random.bow", 1.0F, 1.0F / (0.5F * 0.4F + 1.2F) + 6 * 0.5F);
			
			entity.inventory.consumeInventoryItem(AOTMItems.the_power_arrow);
			
		if (!world.isRemote) world.spawnEntityInWorld(entityarrow);
		}
			return itemstack;
		}
	
	public void onCreated(ItemStack itemstack, World world, EntityPlayer entity){
		float var4 = 1.0F;
		int i = (int)(entity.prevPosX + (entity.posX - entity.prevPosX) * (double)var4);
		int j = (int)(entity.prevPosY + (entity.posY - entity.prevPosY) * (double)var4 + 1.62D - (double)entity.getYOffset());
		int k = (int)(entity.prevPosZ + (entity.posZ - entity.prevPosZ) * (double)var4);

		if(true){
			world.spawnEntityInWorld(new EntityLightningBolt(world, i, j, k));
		}		
		
	}
	
}
