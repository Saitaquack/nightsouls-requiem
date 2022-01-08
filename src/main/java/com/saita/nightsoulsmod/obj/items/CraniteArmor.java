package com.saita.nightsoulsmod.obj.items;

import java.util.List;

import com.saita.nightsoulsmod.init.ItemInit;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;

public class CraniteArmor extends ArmorItem {

	public CraniteArmor(IArmorMaterial materialIn, EquipmentSlotType slot, Properties builderIn) {
		super(materialIn, slot, builderIn);

	}
	
	@Override
    public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn)
    {
    
	tooltip.add(new StringTextComponent("§fFull set bonus : §7Infinite Speed I. Immunity to Poison and Nausea. Reduced cooldowns to Amp It Up and Adaptive Shield."));			
	super.addInformation(stack, worldIn, tooltip, flagIn);
	
    }
	
	 @Override
	 public void onArmorTick(ItemStack stack, World world, PlayerEntity player) {
		 		 		 
			 if(player.getItemStackFromSlot(EquipmentSlotType.HEAD).getItem() == ItemInit.CRANITE_HELMET.get() && 
			    player.getItemStackFromSlot(EquipmentSlotType.CHEST).getItem() == ItemInit.CRANITE_CHESTPLATE.get() && 
			    player.getItemStackFromSlot(EquipmentSlotType.LEGS).getItem() == ItemInit.CRANITE_LEGGINGS.get() && 
			    player.getItemStackFromSlot(EquipmentSlotType.FEET).getItem() == ItemInit.CRANITE_BOOTS.get())
				 
			 	{			 
				 	player.addPotionEffect(new EffectInstance(Effects.SPEED, 5, 0, false, false));   
				 	player.removePotionEffect(Effects.POISON);
				 	player.removePotionEffect(Effects.NAUSEA);
			 	}
		 	 
		super.onArmorTick(stack, world, player);
	  
     }

}
