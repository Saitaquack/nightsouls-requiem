package com.saita.nightsoulsmod.obj.items;

import com.saita.nightsoulsmod.entities.entity.projectiles.GiantPeaProjEntity;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.world.World;

public class GiantPea extends Item {

	public GiantPea(Properties properties) {
		super(properties);

	}
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
		
		ItemStack stack = playerIn.getHeldItem(handIn);

    	worldIn.playSound(playerIn, playerIn.getPosition(), SoundEvents.ENTITY_SNOWBALL_THROW, SoundCategory.MASTER, 1.0F, 1.0F);	
		stack.shrink(1);
		
		if(!worldIn.isRemote) {
			
			GiantPeaProjEntity proj = new GiantPeaProjEntity(playerIn, worldIn);		
		    proj.setDirectionAndMovement(playerIn, playerIn.rotationPitch, playerIn.rotationYaw, 0.0F, 2.0F, 0.0F);
		    worldIn.addEntity(proj);
			
		}
			
		return ActionResult.resultSuccess(stack);
	}
	
	

}
