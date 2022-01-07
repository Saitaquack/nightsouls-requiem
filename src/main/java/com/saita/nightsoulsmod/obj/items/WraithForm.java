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

public class WraithForm extends Item{

	public WraithForm(Properties properties) {
		super(properties);

	}
	
	@Override
	public Rarity getRarity(ItemStack stack) {

	return Rarity.RARE;
	}
	
	 @Override
	 public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn)
	 {
	    	
	   tooltip.add(new StringTextComponent("§7Become invisible, faster and invulnerable. Cooldown : 12 seconds. Cooldown is 8 seconds with miizealite, necro, nightsouls, hellfire emperor or paragonic armor. Cooldown is 6 seconds with a vampire mask."));
	   super.addInformation(stack, worldIn, tooltip, flagIn);
	 }
	 
	 @Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
		 
		if(playerIn.getItemStackFromSlot(EquipmentSlotType.HEAD).getItem() == ItemInit.VAMPIRE_MASK.get())
		{
		    playerIn.getCooldownTracker().setCooldown(this, 120);
		}
		else if((playerIn.getItemStackFromSlot(EquipmentSlotType.HEAD).getItem() == ItemInit.MIIZEALITE_HELMET.get() && 
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
				playerIn.getItemStackFromSlot(EquipmentSlotType.FEET).getItem() == ItemInit.NIGHTSOULS_BOOTS.get()) || 
				
				(playerIn.getItemStackFromSlot(EquipmentSlotType.HEAD).getItem() == ItemInit.HELLFIRE_EMPEROR_HELMET.get() && 
    			playerIn.getItemStackFromSlot(EquipmentSlotType.CHEST).getItem() == ItemInit.HELLFIRE_EMPEROR_CHESTPLATE.get() && 
    			playerIn.getItemStackFromSlot(EquipmentSlotType.LEGS).getItem() == ItemInit.HELLFIRE_EMPEROR_LEGGINGS.get() && 
    			playerIn.getItemStackFromSlot(EquipmentSlotType.FEET).getItem() == ItemInit.HELLFIRE_EMPEROR_BOOTS.get()) ||
			
				(playerIn.getItemStackFromSlot(EquipmentSlotType.CHEST).getItem() == ItemInit.PARAGONIC_NIGHTSOULS_CHESTPLATE.get()))

		{
			playerIn.getCooldownTracker().setCooldown(this, 160);
		}
		else
		{
		    playerIn.getCooldownTracker().setCooldown(this, 240);
		}  	 
		
	    playerIn.removePotionEffect(Effects.SLOWNESS);
		playerIn.removePotionEffect(Effects.NAUSEA);
		playerIn.removePotionEffect(Effects.BLINDNESS);
		playerIn.removePotionEffect(Effects.HUNGER);
		playerIn.removePotionEffect(Effects.POISON);
		playerIn.removePotionEffect(Effects.WITHER);
		playerIn.extinguish();
	    
	    playerIn.addPotionEffect(new EffectInstance(Effects.RESISTANCE, 60, 4));
	    playerIn.addPotionEffect(new EffectInstance(Effects.SPEED, 60, 2));
	    playerIn.addPotionEffect(new EffectInstance(Effects.WEAKNESS, 60, 4));
	    playerIn.addPotionEffect(new EffectInstance(Effects.MINING_FATIGUE, 60, 4));
	    playerIn.addPotionEffect(new EffectInstance(Effects.INVISIBILITY, 60, 0));
	    worldIn.playSound(playerIn, playerIn.getPosition(), SoundInit.WRAITH_FORM.get(), SoundCategory.MASTER, 1.0F, 1.0F);
	    
	    	return super.onItemRightClick(worldIn, playerIn, handIn);
	   }

}
