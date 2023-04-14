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

public class AlternateArmor extends ArmorItem {

	public AlternateArmor(IArmorMaterial materialIn, EquipmentSlotType slot, Properties builderIn) {
		super(materialIn, slot, builderIn);

	}
	
	@Override
    public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn)
    {
    
	tooltip.set(0, new StringTextComponent("§0"+tooltip.get(0).getString()+"§r"));	
	tooltip.add(new StringTextComponent("§0Full set bonus : §7Infinite Haste II, Water Breathing, Invisibility and Speed I. Reduced cooldowns to Fortify and Blink."));			
	super.addInformation(stack, worldIn, tooltip, flagIn);
	
    }
	
	 @Override
	 public void onArmorTick(ItemStack stack, World world, PlayerEntity player) {
		 		 		 
			 if(player.getItemStackFromSlot(EquipmentSlotType.HEAD).getItem() == ItemInit.ALTERNATE_HELMET.get() && 
			    player.getItemStackFromSlot(EquipmentSlotType.CHEST).getItem() == ItemInit.ALTERNATE_CHESTPLATE.get() && 
			    player.getItemStackFromSlot(EquipmentSlotType.LEGS).getItem() == ItemInit.ALTERNATE_LEGGINGS.get() && 
			    player.getItemStackFromSlot(EquipmentSlotType.FEET).getItem() == ItemInit.ALTERNATE_BOOTS.get())
				 
			 	 {		 
					  player.addPotionEffect(new EffectInstance(Effects.HASTE, 5, 1, false, false));	      
					  player.addPotionEffect(new EffectInstance(Effects.WATER_BREATHING, 5, 0, false, false));
					  player.addPotionEffect(new EffectInstance(Effects.INVISIBILITY, 5, 0, false, false));	
					  player.addPotionEffect(new EffectInstance(Effects.SPEED, 5, 0, false, false));	
			     }
		 	 
		super.onArmorTick(stack, world, player);
	  
     }

}
