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

public class Fade extends Item {

	public Fade(Properties properties) {
		super(properties);

	}
	

	@Override
	public Rarity getRarity(ItemStack stack) {

	return Rarity.RARE;
	}
	
	 @Override
	 public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn)
	 {
	    	
	   tooltip.add(new StringTextComponent("§7Gives you a quick speed buff and makes you invisible and invulnerable. Cooldown : 12 seconds. Cooldown is 8 seconds with saitastone, bloody, nightsouls, milky way or paragonic armor."));
	   super.addInformation(stack, worldIn, tooltip, flagIn);
	 }
	 
	 @Override
	    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
	    	
		 if((playerIn.getItemStackFromSlot(EquipmentSlotType.HEAD).getItem() == ItemInit.SAITASTONE_HELMET.get() && 
	    			playerIn.getItemStackFromSlot(EquipmentSlotType.CHEST).getItem() == ItemInit.SAITASTONE_CHESTPLATE.get() && 
	    			playerIn.getItemStackFromSlot(EquipmentSlotType.LEGS).getItem() == ItemInit.SAITASTONE_LEGGINGS.get() && 
	    			playerIn.getItemStackFromSlot(EquipmentSlotType.FEET).getItem() == ItemInit.SAITASTONE_BOOTS.get()) || 
				 
				 (playerIn.getItemStackFromSlot(EquipmentSlotType.HEAD).getItem() == ItemInit.BLOODY_HELMET.get() && 
					playerIn.getItemStackFromSlot(EquipmentSlotType.CHEST).getItem() == ItemInit.BLOODY_CHESTPLATE.get() && 
					playerIn.getItemStackFromSlot(EquipmentSlotType.LEGS).getItem() == ItemInit.BLOODY_LEGGINGS.get() && 
					playerIn.getItemStackFromSlot(EquipmentSlotType.FEET).getItem() == ItemInit.BLOODY_BOOTS.get()) || 
	    				 			
					(playerIn.getItemStackFromSlot(EquipmentSlotType.HEAD).getItem() == ItemInit.NIGHTSOULS_HELMET.get() && 
					playerIn.getItemStackFromSlot(EquipmentSlotType.CHEST).getItem() == ItemInit.NIGHTSOULS_CHESTPLATE.get() && 
					playerIn.getItemStackFromSlot(EquipmentSlotType.LEGS).getItem() == ItemInit.NIGHTSOULS_LEGGINGS.get() && 
					playerIn.getItemStackFromSlot(EquipmentSlotType.FEET).getItem() == ItemInit.NIGHTSOULS_BOOTS.get()) || 
					
					(playerIn.getItemStackFromSlot(EquipmentSlotType.HEAD).getItem() == ItemInit.MILKY_WAY_HELMET.get() && 
	    			playerIn.getItemStackFromSlot(EquipmentSlotType.CHEST).getItem() == ItemInit.MILKY_WAY_CHESTPLATE.get() && 
	    			playerIn.getItemStackFromSlot(EquipmentSlotType.LEGS).getItem() == ItemInit.MILKY_WAY_LEGGINGS.get() && 
	    			playerIn.getItemStackFromSlot(EquipmentSlotType.FEET).getItem() == ItemInit.MILKY_WAY_BOOTS.get()) ||
			
			       (playerIn.getItemStackFromSlot(EquipmentSlotType.LEGS).getItem() == ItemInit.PARAGONIC_NIGHTSOULS_LEGGINGS.get()))
		 {
			 playerIn.getCooldownTracker().setCooldown(this, 160);
		 }
		 else
		 {
			 playerIn.getCooldownTracker().setCooldown(this, 240);
		 }
  	 
		if(!worldIn.isRemote)
		{
		    playerIn.removePotionEffect(Effects.SLOWNESS);
			playerIn.removePotionEffect(Effects.NAUSEA);
			playerIn.removePotionEffect(Effects.BLINDNESS);
			playerIn.removePotionEffect(Effects.HUNGER);
			playerIn.removePotionEffect(Effects.POISON);
			playerIn.removePotionEffect(Effects.WITHER);
			playerIn.extinguish();
		    
		    playerIn.addPotionEffect(new EffectInstance(Effects.RESISTANCE, 20, 4));
		    playerIn.addPotionEffect(new EffectInstance(Effects.SPEED, 20, 7));
		    playerIn.addPotionEffect(new EffectInstance(Effects.JUMP_BOOST, 20, 3));
		    playerIn.addPotionEffect(new EffectInstance(Effects.WEAKNESS, 20, 4));
		    playerIn.addPotionEffect(new EffectInstance(Effects.MINING_FATIGUE, 20, 4));
		    playerIn.addPotionEffect(new EffectInstance(Effects.INVISIBILITY, 20, 0));
		}
		
		    worldIn.playSound(playerIn, playerIn.getPosition(), SoundInit.FADE.get(), SoundCategory.MASTER, 1.0F, 1.0F);;
		
	    
	    	return super.onItemRightClick(worldIn, playerIn, handIn);
	   }

}
