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

public class HellfireCharm extends Item {

	public HellfireCharm(Properties properties) {
		super(properties);

	}
	
	@Override
    public Rarity getRarity(ItemStack stack) {
    	
    	return Rarity.UNCOMMON;
    }
	
	
	 @Override
	 public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn)
	 {
	    	
	    tooltip.add(new StringTextComponent("§7Infinite fire resistance while in your inventory. If you are wearing full miizealite, necro or nightsouls armor, being on fire or in lava will grant you regeneration."));
		super.addInformation(stack, worldIn, tooltip, flagIn);
	 }
	
	 @Override
	 public void inventoryTick(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
	    	
	    if(entityIn instanceof PlayerEntity)
	    	{
	    		 PlayerEntity playerIn = (PlayerEntity)entityIn;	
	    		 playerIn.addPotionEffect(new EffectInstance(Effects.FIRE_RESISTANCE, 5, 0, false, false));
	    		 
	    		 if((playerIn.getItemStackFromSlot(EquipmentSlotType.HEAD).getItem() == ItemInit.MIIZEALITE_HELMET.get() && 
	    			playerIn.getItemStackFromSlot(EquipmentSlotType.CHEST).getItem() == ItemInit.MIIZEALITE_CHESTPLATE.get() && 
	    			playerIn.getItemStackFromSlot(EquipmentSlotType.LEGS).getItem() == ItemInit.MIIZEALITE_LEGGINGS.get() && 
	    			playerIn.getItemStackFromSlot(EquipmentSlotType.FEET).getItem() == ItemInit.MIIZEALITE_BOOTS.get()) || 
	    				 
	    		   (playerIn.getItemStackFromSlot(EquipmentSlotType.HEAD).getItem() == ItemInit.NECRO_HELMET.get() && 
	    			playerIn.getItemStackFromSlot(EquipmentSlotType.CHEST).getItem() == ItemInit.NECRO_CHESTPLATE.get() && 
	    			playerIn.getItemStackFromSlot(EquipmentSlotType.LEGS).getItem() == ItemInit.NECRO_LEGGINGS.get() && 
	    			playerIn.getItemStackFromSlot(EquipmentSlotType.FEET).getItem() == ItemInit.NECRO_BOOTS.get()) ||
	    		   
	    		   (playerIn.getItemStackFromSlot(EquipmentSlotType.HEAD).getItem() == ItemInit.NIGHTSOULS_HELMET.get() && 
	    			playerIn.getItemStackFromSlot(EquipmentSlotType.CHEST).getItem() == ItemInit.NIGHTSOULS_CHESTPLATE.get() && 
	    			playerIn.getItemStackFromSlot(EquipmentSlotType.LEGS).getItem() == ItemInit.NIGHTSOULS_LEGGINGS.get() && 
	    			playerIn.getItemStackFromSlot(EquipmentSlotType.FEET).getItem() == ItemInit.NIGHTSOULS_BOOTS.get()))
	    					 
	    			{
	    			  if(playerIn.isInLava())
	    			  {
	    				  if(worldIn.getGameTime() % 60 == 0)
						  {
				 			playerIn.addPotionEffect(new EffectInstance(Effects.REGENERATION, 100, 1));
						  }
	    			  }
	    			  else if(playerIn.isBurning())
	    			  {
	    				  if(worldIn.getGameTime() % 60 == 0)
						  {
				 			playerIn.addPotionEffect(new EffectInstance(Effects.REGENERATION, 100, 0));
						  }
	    			  }
	    			  
	    		}
	    		   	
	        }
	    	super.inventoryTick(stack, worldIn, entityIn, itemSlot, isSelected);
	    }

}
