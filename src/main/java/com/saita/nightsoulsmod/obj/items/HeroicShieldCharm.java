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

public class HeroicShieldCharm extends Item {

	public HeroicShieldCharm(Properties properties) {
		super(properties);

	}

	@Override
	public Rarity getRarity(ItemStack stack) {
		
		return Rarity.RARE;
	}
	
	@Override
    public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn)
    {
    	
    tooltip.add(new StringTextComponent("§7Grants you an absorption II shielding effect every 20 seconds for 8 seconds while in your inventory."));
	super.addInformation(stack, worldIn, tooltip, flagIn);
    }  
	

	@Override
	public void inventoryTick(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
		
		 if(entityIn instanceof PlayerEntity)
	    	{
			 	PlayerEntity playerIn = (PlayerEntity)entityIn;	
	    		 	    		 			
			 	 if(worldIn.getDayTime() % 400 == 0)
				  {
			    	 playerIn.addPotionEffect(new EffectInstance(Effects.ABSORPTION, 160, 1, false, false));
				  }  		   	
	         }
		 
	    super.inventoryTick(stack, worldIn, entityIn, itemSlot, isSelected);
	}

}
