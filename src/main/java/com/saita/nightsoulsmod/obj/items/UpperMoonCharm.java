package com.saita.nightsoulsmod.obj.items;

import java.util.List;

import com.saita.nightsoulsmod.init.ItemInit;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Rarity;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;

public class UpperMoonCharm extends Item {

	public UpperMoonCharm(Properties properties) {
		super(properties);

	}
	
	@Override
	public boolean hasEffect(ItemStack stack) {

		return true;
	}
	
	@Override
	public Rarity getRarity(ItemStack stack) {
		
		return Rarity.EPIC;
	}
	
	 @Override
	 public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn)
	 {
	    	
	    tooltip.add(new StringTextComponent("§7A much stronger version of Moon Charm. Effects are even stronger if you are a vampire."));
		super.addInformation(stack, worldIn, tooltip, flagIn);
	 }
	
	 @Override
	 public void inventoryTick(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
	    	
	    if(entityIn instanceof PlayerEntity)
	    	{
	    	
    		 PlayerEntity playerIn = (PlayerEntity)entityIn;	 
    		 
    		 if(worldIn.isNightTime())
    		 {   
    			if(!(playerIn.getItemStackFromSlot(EquipmentSlotType.HEAD).getItem() == ItemInit.VAMPIRE_MASK.get()))
    			{
	    		    playerIn.addPotionEffect(new EffectInstance(Effects.STRENGTH, 5, 3, false, false));
	    		    playerIn.addPotionEffect(new EffectInstance(Effects.SPEED, 5, 3, false, false));
	    		    playerIn.addPotionEffect(new EffectInstance(Effects.JUMP_BOOST, 5, 1, false, false));
	    		    playerIn.addPotionEffect(new EffectInstance(Effects.RESISTANCE, 5, 2, false, false));
	    		    playerIn.addPotionEffect(new EffectInstance(Effects.HASTE, 5, 1, false, false));	
	    		    
	    		    if(worldIn.getGameTime() % 180 == 0)
					  {
						 playerIn.addPotionEffect(new EffectInstance(Effects.NIGHT_VISION, 400, 0, false, false));
					  }
	    		    
	    		    if(worldIn.getGameTime() % 100 == 0)
	 			   	 {
	 				     playerIn.addPotionEffect(new EffectInstance(Effects.REGENERATION, 200, 2, false, false));
	 			   	 }
    			}
    			else
    			{
    				playerIn.addPotionEffect(new EffectInstance(Effects.STRENGTH, 5, 4, false, false));
	    		    playerIn.addPotionEffect(new EffectInstance(Effects.SPEED, 5, 4, false, false));
	    		    playerIn.addPotionEffect(new EffectInstance(Effects.JUMP_BOOST, 5, 3, false, false));
	    		    playerIn.addPotionEffect(new EffectInstance(Effects.RESISTANCE, 5, 2, false, false));
	    		    playerIn.addPotionEffect(new EffectInstance(Effects.HASTE, 5, 2, false, false));	
	    		    
	    		    if(worldIn.getGameTime() % 180 == 0)
					  {
						 playerIn.addPotionEffect(new EffectInstance(Effects.NIGHT_VISION, 400, 0, false, false));
					  }
	    		    
	    		    if(worldIn.getGameTime() % 100 == 0)
	 			   	 {
	 				     playerIn.addPotionEffect(new EffectInstance(Effects.REGENERATION, 200, 3, false, false));
	 			   	 }
	    		    
    			  }
    		   }
    	   }

	    super.inventoryTick(stack, worldIn, entityIn, itemSlot, isSelected);
	 }

}
