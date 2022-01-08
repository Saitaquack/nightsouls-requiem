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

public class AmpItUp extends Item {

	public AmpItUp(Properties properties) {
		super(properties);

	}
	
	@Override
	public Rarity getRarity(ItemStack stack) {

	return Rarity.RARE;
	}
	
	 @Override
	 public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn)
	 {
	    	
	   tooltip.add(new StringTextComponent("§7Grants you a big speed buff and regeneration. Cooldown : 16 seconds. Cooldown is 12 seconds with cranite, necro, nightsouls, hallowed paladin or paragonic armor."));
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
			 playerIn.getCooldownTracker().setCooldown(this, 240);
		 }
		 else
		 {
			 playerIn.getCooldownTracker().setCooldown(this, 320);
		 }
	    
	    playerIn.removePotionEffect(Effects.SLOWNESS);
	    
	    playerIn.addPotionEffect(new EffectInstance(Effects.SPEED, 130, 3));
	    playerIn.addPotionEffect(new EffectInstance(Effects.REGENERATION, 100, 2));
	    worldIn.playSound(playerIn, playerIn.getPosition(), SoundInit.AMP_IT_UP.get(), SoundCategory.MASTER, 0.6F, 1.0F);
	    
	    	return super.onItemRightClick(worldIn, playerIn, handIn);
	  }

}
