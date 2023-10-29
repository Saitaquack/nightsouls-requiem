package com.saita.nightsoulsmod.obj.items;

import java.util.List;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
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

public class UpperDemonBlood extends Item {

	public UpperDemonBlood(Properties properties) {
		super(properties);

	}
	
	@Override
	public boolean hasEffect(ItemStack stack) {
		
		return true;
	}
	
	@Override
	public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn)
	{
		
	tooltip.add(new StringTextComponent("§7Drink it for a very powerful regeneration and speed effect. Also used to craft perfect paragonic blocks."));	
	tooltip.set(0, new StringTextComponent("§4"+tooltip.get(0).getString()+"§r"));    	
	super.addInformation(stack, worldIn, tooltip, flagIn);
	}  
	
	@Override
	public ItemStack onItemUseFinish(ItemStack stack, World worldIn, LivingEntity entityLiving) {		
	 	
	    if(entityLiving instanceof PlayerEntity)
	    	{
	    	   PlayerEntity playerIn = (PlayerEntity)entityLiving;

			   playerIn.addPotionEffect(new EffectInstance(Effects.REGENERATION, 600, 4));
			   playerIn.addPotionEffect(new EffectInstance(Effects.SPEED, 600, 4));	    		 
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
