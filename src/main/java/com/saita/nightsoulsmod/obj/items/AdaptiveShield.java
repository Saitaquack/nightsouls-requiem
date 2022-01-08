package com.saita.nightsoulsmod.obj.items;

import java.util.List;

import com.saita.nightsoulsmod.init.ItemInit;
import com.saita.nightsoulsmod.init.SoundInit;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Rarity;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;

public class AdaptiveShield extends Item {

	public AdaptiveShield(Properties properties) {
		super(properties);

	}
	
	@Override
	public Rarity getRarity(ItemStack stack) {

	return Rarity.RARE;
	}
	
	 @Override
	 public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn)
	 {
	    	
	   tooltip.add(new StringTextComponent("§7Grants you absorption. Effect gets stronger if you are at low HP. Cooldown : 20 seconds. Cooldown is 14 seconds with cranite, necro, nightsouls, hallowed paladin or paragonic armor."));
	   super.addInformation(stack, worldIn, tooltip, flagIn);
	 }
	 
	 @Override
	    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
	    	
		 if((playerIn.getItemStackFromSlot(EquipmentSlotType.HEAD).getItem() == ItemInit.CRANITE_HELMET.get() && 
	    			playerIn.getItemStackFromSlot(EquipmentSlotType.CHEST).getItem() == ItemInit.CRANITE_CHESTPLATE.get() && 
	    			playerIn.getItemStackFromSlot(EquipmentSlotType.LEGS).getItem() == ItemInit.CRANITE_LEGGINGS.get() && 
	    			playerIn.getItemStackFromSlot(EquipmentSlotType.FEET).getItem() == ItemInit.CRANITE_BOOTS.get()) || 
				 
				 	(playerIn.getItemStackFromSlot(EquipmentSlotType.HEAD).getItem() == ItemInit.NECRO_HELMET.get() && 
	    			playerIn.getItemStackFromSlot(EquipmentSlotType.CHEST).getItem() == ItemInit.NECRO_CHESTPLATE.get() && 
	    			playerIn.getItemStackFromSlot(EquipmentSlotType.LEGS).getItem() == ItemInit.NECRO_LEGGINGS.get() && 
	    			playerIn.getItemStackFromSlot(EquipmentSlotType.FEET).getItem() == ItemInit.NECRO_BOOTS.get()) ||
	    				 			
					(playerIn.getItemStackFromSlot(EquipmentSlotType.HEAD).getItem() == ItemInit.NIGHTSOULS_HELMET.get() && 
					playerIn.getItemStackFromSlot(EquipmentSlotType.CHEST).getItem() == ItemInit.NIGHTSOULS_CHESTPLATE.get() && 
					playerIn.getItemStackFromSlot(EquipmentSlotType.LEGS).getItem() == ItemInit.NIGHTSOULS_LEGGINGS.get() && 
					playerIn.getItemStackFromSlot(EquipmentSlotType.FEET).getItem() == ItemInit.NIGHTSOULS_BOOTS.get()) || 
					
					(playerIn.getItemStackFromSlot(EquipmentSlotType.HEAD).getItem() == ItemInit.HALLOWED_PALADIN_HELMET.get() && 
	    			playerIn.getItemStackFromSlot(EquipmentSlotType.CHEST).getItem() == ItemInit.HALLOWED_PALADIN_CHESTPLATE.get() && 
	    			playerIn.getItemStackFromSlot(EquipmentSlotType.LEGS).getItem() == ItemInit.HALLOWED_PALADIN_LEGGINGS.get() && 
	    			playerIn.getItemStackFromSlot(EquipmentSlotType.FEET).getItem() == ItemInit.HALLOWED_PALADIN_BOOTS.get()) ||
			
			       (playerIn.getItemStackFromSlot(EquipmentSlotType.HEAD).getItem() == ItemInit.PARAGONIC_NIGHTSOULS_HELMET.get()))
		 {
			 playerIn.getCooldownTracker().setCooldown(this, 280);
		 }
		 else
		 {
			 playerIn.getCooldownTracker().setCooldown(this, 400);
		 }
		 
	    int level = 0;
	    
	    if(playerIn.getHealth() > playerIn.getMaxHealth() * 0.8)
	    {
	    	level = 0;
	    }
	    else if(playerIn.getHealth() > playerIn.getMaxHealth() * 0.6)
	    {
	    	level = 1;
	    }
	    else if(playerIn.getHealth() > playerIn.getMaxHealth() * 0.4)
	    {
	    	level = 2;
	    }
	    else if(playerIn.getHealth() > playerIn.getMaxHealth() * 0.2)
	    {
	    	level = 3;
	    }
	    else if(playerIn.getHealth() > playerIn.getMaxHealth() * 0.1)
	    {
	    	level = 4;
	    }
	    else
	    {
	    	level = 5;
	    }
	    
	    
	    playerIn.addPotionEffect(new EffectInstance(Effects.ABSORPTION, 160, level));

	    worldIn.playSound(playerIn, playerIn.getPosition(), SoundInit.ADAPTIVE_SHIELD.get(), SoundCategory.MASTER, 1.0F, 1.0F);
	    
	    	return super.onItemRightClick(worldIn, playerIn, handIn);
	   }

}
