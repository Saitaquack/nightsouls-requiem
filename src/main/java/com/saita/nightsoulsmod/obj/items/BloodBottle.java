package com.saita.nightsoulsmod.obj.items;

import java.util.List;

import com.saita.nightsoulsmod.init.ItemInit;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.UseAction;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;

public class BloodBottle extends Item {

	public BloodBottle(Properties properties) {
		super(properties);

	}
	
	@Override
	public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn)
	{
	    	
	tooltip.add(new StringTextComponent("§7It tastes a lot better if you are a vampire."));
	super.addInformation(stack, worldIn, tooltip, flagIn);
	}  
	
	@Override
	public ItemStack onItemUseFinish(ItemStack stack, World worldIn, LivingEntity entityLiving) {
		
	 	
	    if(entityLiving instanceof PlayerEntity)
	    	{
	    	   PlayerEntity playerIn = (PlayerEntity)entityLiving;
	    		 if(playerIn.getItemStackFromSlot(EquipmentSlotType.HEAD).getItem() == ItemInit.VAMPIRE_MASK.get())
	    		 {
	    			 playerIn.addPotionEffect(new EffectInstance(Effects.REGENERATION, 500, 3));    			 
	    		 }
	    		 else
	    		 {
	    			 playerIn.addPotionEffect(new EffectInstance(Effects.REGENERATION, 400, 1));
	    			 playerIn.addPotionEffect(new EffectInstance(Effects.NAUSEA, 200, 0));	
	    		 }
	    		 
	    	}
	  
		return super.onItemUseFinish(stack, worldIn, entityLiving);
	}
	
	
	
	 public UseAction getUseAction(ItemStack stack) {
	      return UseAction.DRINK;
	   }

	   public SoundEvent getDrinkSound() {
	      return SoundEvents.ITEM_HONEY_BOTTLE_DRINK;
	   }

	   public SoundEvent getEatSound() {
	      return SoundEvents.ITEM_HONEY_BOTTLE_DRINK;
	   }

}
