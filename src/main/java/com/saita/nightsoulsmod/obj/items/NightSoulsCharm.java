package com.saita.nightsoulsmod.obj.items;

import java.util.List;

import com.saita.nightsoulsmod.init.SoundInit;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Rarity;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;

public class NightSoulsCharm extends Item {

	public NightSoulsCharm(Properties properties) {
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
    	
    tooltip.add(new StringTextComponent("§7While in your inventory, if you are below 2 hearts, you will get temporary invincibility, regeneration and speed. If you fall into the void, you will get teleported back to safety and gain the same buffs. The item gets consumed once it has saved you once."));
	super.addInformation(stack, worldIn, tooltip, flagIn);
    }  
	
	@Override
	public void inventoryTick(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {	
	 	
	    if(entityIn instanceof PlayerEntity)
	    	{
	    		 PlayerEntity playerIn = (PlayerEntity)entityIn;	
	    		 
	    		 if(playerIn.getHealth() <= 4.0F)
	    		 {
	    			 playerIn.clearActivePotions();
	    			 playerIn.addPotionEffect(new EffectInstance(Effects.RESISTANCE, 240, 4));
	    			 playerIn.addPotionEffect(new EffectInstance(Effects.REGENERATION, 240, 4));
	    			 playerIn.addPotionEffect(new EffectInstance(Effects.SPEED, 240, 4));	    
	    			 playerIn.addPotionEffect(new EffectInstance(Effects.FIRE_RESISTANCE, 240, 0));	
	    		     worldIn.playSound(playerIn, playerIn.getPosition(), SoundInit.NIGHTSOULS_CHARM.get(), SoundCategory.MASTER, 1.0F, 1.0F);
	    		     stack.shrink(1);
	    		 }
	    		 
    		     if(playerIn.getPosition().getY() < -44)
    		     {
    		    	 playerIn.clearActivePotions();
    		    	 playerIn.teleportKeepLoaded(0, 116, 0);
    		    	 playerIn.addPotionEffect(new EffectInstance(Effects.RESISTANCE, 240, 4));
	    			 playerIn.addPotionEffect(new EffectInstance(Effects.REGENERATION, 240, 4));
	    			 playerIn.addPotionEffect(new EffectInstance(Effects.SPEED, 240, 4));	
	    			 playerIn.addPotionEffect(new EffectInstance(Effects.FIRE_RESISTANCE, 240, 0));	
	    		     worldIn.playSound(playerIn, playerIn.getPosition(), SoundInit.NIGHTSOULS_CHARM.get(), SoundCategory.MASTER, 1.0F, 1.0F);
    		    	 stack.shrink(1);
    		     }
	    	}
		
		super.inventoryTick(stack, worldIn, entityIn, itemSlot, isSelected);
	}

}
