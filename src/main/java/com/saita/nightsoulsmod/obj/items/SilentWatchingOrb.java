package com.saita.nightsoulsmod.obj.items;

import java.util.List;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;

public class SilentWatchingOrb extends Item {

	public SilentWatchingOrb(Properties properties) {
		super(properties);

	}
	
	@Override
    public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn)
    {
    	
    tooltip.add(new StringTextComponent("§7Grants you invisibility when in your inventory, at the cost of making you weaker and slower."));
	super.addInformation(stack, worldIn, tooltip, flagIn);
    }  

	
	@Override
	public void inventoryTick(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
		
		 if(entityIn instanceof PlayerEntity)
	    	{
			 	PlayerEntity playerIn = (PlayerEntity)entityIn;	
	    		 	    		 			
	    		playerIn.addPotionEffect(new EffectInstance(Effects.INVISIBILITY, 5, 0, false, false));
	    		playerIn.addPotionEffect(new EffectInstance(Effects.SLOWNESS, 5, 1, false, false));
	    		playerIn.addPotionEffect(new EffectInstance(Effects.WEAKNESS, 5, 0, false, false));
	    		   	
	         }
		 
	    super.inventoryTick(stack, worldIn, entityIn, itemSlot, isSelected);
	}

}
