package com.saita.nightsoulsmod.obj.items;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

public class PackOfSixteenTorches extends Item {

	public PackOfSixteenTorches(Properties properties) {
		super(properties);
	
	}
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {	
			
	    ItemStack itemstack = playerIn.getHeldItem(handIn);
	    itemstack.shrink(1);
		
	    ItemStack torches = new ItemStack(Items.TORCH, 16);  		   	
		playerIn.dropItem(torches, false).setNoPickupDelay();
	    			
		return super.onItemRightClick(worldIn, playerIn, handIn);
	}

}
