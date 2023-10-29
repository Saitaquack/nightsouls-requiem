package com.saita.nightsoulsmod.obj.items;

import java.util.List;

import com.saita.nightsoulsmod.init.ItemInit;

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

public class MoonCharm extends Item {

	public MoonCharm(Properties properties) {
		super(properties);

	}
	
	@Override
    public Rarity getRarity(ItemStack stack) {
    	
    	return Rarity.UNCOMMON;
    }
	
	
	 @Override
	 public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn)
	 {
	    	
	    tooltip.add(new StringTextComponent("§7While in your inventory, you gain werewolf power during nighttime."));
		super.addInformation(stack, worldIn, tooltip, flagIn);
	 }
	
	 @Override
	 public void inventoryTick(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {

	    if(entityIn instanceof PlayerEntity)
	    	{
	    		 PlayerEntity playerIn = (PlayerEntity)entityIn;
	    		 
	    		 if(!playerIn.inventory.hasItemStack(new ItemStack(ItemInit.UPPER_MOON_CHARM.get())))
	    		 {
	    		 
		    		 if(worldIn.isNightTime())
		    		 {    			
		    		    playerIn.addPotionEffect(new EffectInstance(Effects.STRENGTH, 5, 1, false, false));
		    		    playerIn.addPotionEffect(new EffectInstance(Effects.SPEED, 5, 1, false, false));
		    		    playerIn.addPotionEffect(new EffectInstance(Effects.JUMP_BOOST, 5, 0, false, false));
		    		    
		    		    if(worldIn.getGameTime() % 180 == 0)
						  {
							 playerIn.addPotionEffect(new EffectInstance(Effects.NIGHT_VISION, 400, 0, false, false));
						  }
		    		    
		    		 }
	    		 }
	    		   	
	       }
	    	super.inventoryTick(stack, worldIn, entityIn, itemSlot, isSelected);
	    }

}
