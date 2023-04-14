package com.saita.nightsoulsmod.obj.items;

import java.util.List;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Rarity;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;

public class BloodCharm extends Item {

	public BloodCharm(Properties properties) {
		super(properties);

	}
	
	@Override
    public Rarity getRarity(ItemStack stack) {
    	
    	return Rarity.UNCOMMON;
    }
	
	
	@Override
	public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn)
	{
	    	
	    tooltip.add(new StringTextComponent("§7While in your inventory, you will get a speed and strength buff if you are below 80% HP. The lower your HP, the stronger the effects get."));
		super.addInformation(stack, worldIn, tooltip, flagIn);
	}
	
	 @Override
	 public void inventoryTick(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
	    	
	    if(entityIn instanceof PlayerEntity)
	        {
	    	    PlayerEntity playerIn = (PlayerEntity)entityIn; 
	    	    
	    	    if(playerIn.getHealth() <= playerIn.getMaxHealth() * 0.1)
	    	    {
	    	    	playerIn.addPotionEffect(new EffectInstance(Effects.SPEED, 5, 4, false, false));
	    	    	playerIn.addPotionEffect(new EffectInstance(Effects.STRENGTH, 5, 4, false, false));
	    	    }	    	    
	    	    if(playerIn.getHealth() <= playerIn.getMaxHealth() * 0.2)
	    	    {
	    	    	playerIn.addPotionEffect(new EffectInstance(Effects.SPEED, 5, 3, false, false));
	    	    	playerIn.addPotionEffect(new EffectInstance(Effects.STRENGTH, 5, 3, false, false));
	    	    }
	    	    else if(playerIn.getHealth() <= playerIn.getMaxHealth() * 0.4)
	    	    {
	    	    	playerIn.addPotionEffect(new EffectInstance(Effects.SPEED, 5, 2, false, false));
	    	    	playerIn.addPotionEffect(new EffectInstance(Effects.STRENGTH, 5, 2, false, false));
	    	    }
	    	    else if(playerIn.getHealth() <= playerIn.getMaxHealth() * 0.6)
	    	    {
	    	    	playerIn.addPotionEffect(new EffectInstance(Effects.SPEED, 5, 1, false, false));
	    	    	playerIn.addPotionEffect(new EffectInstance(Effects.STRENGTH, 5, 1, false, false));
	    	    }
	    	    else if(playerIn.getHealth() <= playerIn.getMaxHealth() * 0.8)
	    	    {
	    	    	playerIn.addPotionEffect(new EffectInstance(Effects.SPEED, 5, 0, false, false));
	    	    	playerIn.addPotionEffect(new EffectInstance(Effects.STRENGTH, 5, 0, false, false));
	    	    }	    	    
	    		   	
	        }
	    	super.inventoryTick(stack, worldIn, entityIn, itemSlot, isSelected);
	    }

}
