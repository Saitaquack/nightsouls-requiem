package com.saita.nightsoulsmod.obj.items;

import java.util.List;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Rarity;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;

public class LifeBand extends Item {

	public LifeBand(Properties properties) {
		super(properties);

	}
	
	@Override
	public Rarity getRarity(ItemStack stack) {
		
		return Rarity.UNCOMMON;
	}
	
	@Override
    public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn)
    {
    	
    tooltip.add(new StringTextComponent("§7Heals you half a heart every 5 seconds while in your inventory."));
	super.addInformation(stack, worldIn, tooltip, flagIn);
    }  
	
	@Override
	public void inventoryTick(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
		
		 if(entityIn instanceof PlayerEntity)
	    	{
			 	PlayerEntity playerIn = (PlayerEntity)entityIn;	
		
				 if(worldIn.getGameTime() % 100 == 0)
				  {			    
					   playerIn.heal(1.0F);
				  }
	    	}
		
		super.inventoryTick(stack, worldIn, entityIn, itemSlot, isSelected);
	}

}
