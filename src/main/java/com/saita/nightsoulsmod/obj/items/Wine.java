package com.saita.nightsoulsmod.obj.items;

import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.UseAction;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.world.World;

public class Wine extends Item {

	public Wine(Properties properties) {
		super(properties);

	}
	
	@Override
	public ItemStack onItemUseFinish(ItemStack stack, World worldIn, LivingEntity entityLiving) {	
	 	
	    entityLiving.addPotionEffect(new EffectInstance(Effects.REGENERATION, 300, 0));
	    entityLiving.addPotionEffect(new EffectInstance(Effects.NAUSEA, 300, 0));	
	  
		return super.onItemUseFinish(stack, worldIn, entityLiving);
	}
	
	
	 public UseAction getUseAction(ItemStack stack) {
	      return UseAction.DRINK;
	   }

	   public SoundEvent getDrinkSound() {
	      return SoundEvents.ENTITY_GENERIC_DRINK;
	   }

	   public SoundEvent getEatSound() {
	      return SoundEvents.ENTITY_GENERIC_DRINK;
	   }

}
