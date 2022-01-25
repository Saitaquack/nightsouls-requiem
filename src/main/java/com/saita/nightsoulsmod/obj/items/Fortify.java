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

public class Fortify extends Item {

	public Fortify(Properties properties) {
		super(properties);

	}
	
	@Override
	public Rarity getRarity(ItemStack stack) {

	return Rarity.RARE;
	}
	
	 @Override
	 public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn)
	 {
	    	
	   tooltip.add(new StringTextComponent("§7Grants you resistance and makes you glow. Cooldown : 16 seconds. Cooldown is 12 seconds with bastirite, alternate, nightsouls, binary or paragonic armor."));
	   super.addInformation(stack, worldIn, tooltip, flagIn);
	 }
	 
	 @Override
	 public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
	    	
		 if((playerIn.getItemStackFromSlot(EquipmentSlotType.HEAD).getItem() == ItemInit.BASTIRITE_HELMET.get() && 
	    			playerIn.getItemStackFromSlot(EquipmentSlotType.CHEST).getItem() == ItemInit.BASTIRITE_CHESTPLATE.get() && 
	    			playerIn.getItemStackFromSlot(EquipmentSlotType.LEGS).getItem() == ItemInit.BASTIRITE_LEGGINGS.get() && 
	    			playerIn.getItemStackFromSlot(EquipmentSlotType.FEET).getItem() == ItemInit.BASTIRITE_BOOTS.get()) || 
				 
				 	(playerIn.getItemStackFromSlot(EquipmentSlotType.HEAD).getItem() == ItemInit.ALTERNATE_HELMET.get() && 
					playerIn.getItemStackFromSlot(EquipmentSlotType.CHEST).getItem() == ItemInit.ALTERNATE_CHESTPLATE.get() && 
					playerIn.getItemStackFromSlot(EquipmentSlotType.LEGS).getItem() == ItemInit.ALTERNATE_LEGGINGS.get() && 
					playerIn.getItemStackFromSlot(EquipmentSlotType.FEET).getItem() == ItemInit.ALTERNATE_BOOTS.get()) || 
	    				 			
					(playerIn.getItemStackFromSlot(EquipmentSlotType.HEAD).getItem() == ItemInit.NIGHTSOULS_HELMET.get() && 
					playerIn.getItemStackFromSlot(EquipmentSlotType.CHEST).getItem() == ItemInit.NIGHTSOULS_CHESTPLATE.get() && 
					playerIn.getItemStackFromSlot(EquipmentSlotType.LEGS).getItem() == ItemInit.NIGHTSOULS_LEGGINGS.get() && 
					playerIn.getItemStackFromSlot(EquipmentSlotType.FEET).getItem() == ItemInit.NIGHTSOULS_BOOTS.get()) || 
					
					(playerIn.getItemStackFromSlot(EquipmentSlotType.HEAD).getItem() == ItemInit.BINARY_HELMET.get() && 
	    			playerIn.getItemStackFromSlot(EquipmentSlotType.CHEST).getItem() == ItemInit.BINARY_CHESTPLATE.get() && 
	    			playerIn.getItemStackFromSlot(EquipmentSlotType.LEGS).getItem() == ItemInit.BINARY_LEGGINGS.get() && 
	    			playerIn.getItemStackFromSlot(EquipmentSlotType.FEET).getItem() == ItemInit.BINARY_BOOTS.get()) ||
			
			       (playerIn.getItemStackFromSlot(EquipmentSlotType.FEET).getItem() == ItemInit.PARAGONIC_NIGHTSOULS_BOOTS.get()))
		 {
			 playerIn.getCooldownTracker().setCooldown(this, 240);
		 }
		 else
		 {
			 playerIn.getCooldownTracker().setCooldown(this, 320);
		 }
  	 
	    playerIn.removePotionEffect(Effects.SLOWNESS);
		playerIn.removePotionEffect(Effects.NAUSEA);
	    
	    playerIn.addPotionEffect(new EffectInstance(Effects.RESISTANCE, 100, 2));
	    playerIn.addPotionEffect(new EffectInstance(Effects.GLOWING, 100, 0));
	    worldIn.playSound(playerIn, playerIn.getPosition(), SoundInit.FORTIFY.get(), SoundCategory.MASTER, 1.0F, 1.0F);
	    
	    	return super.onItemRightClick(worldIn, playerIn, handIn);
	   }

}