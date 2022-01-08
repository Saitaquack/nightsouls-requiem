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

public class MiizealiteArmor extends ArmorItem {

	public MiizealiteArmor(IArmorMaterial materialIn, EquipmentSlotType slot, Properties builderIn) {
		super(materialIn, slot, builderIn);

	}
	
	@Override
    public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn)
    {
    
	tooltip.add(new StringTextComponent("§5Full set bonus : §7Infinite Fire Resistance and immunity to Wither. Reduced cooldowns to Wraith Form. Hellfire Charm heals you when you are on fire."));			
	super.addInformation(stack, worldIn, tooltip, flagIn);
	
    }
	
	 @Override
	 public void onArmorTick(ItemStack stack, World world, PlayerEntity player) {
		 		 		 
			 if(player.getItemStackFromSlot(EquipmentSlotType.HEAD).getItem() == ItemInit.MIIZEALITE_HELMET.get() && 
			    player.getItemStackFromSlot(EquipmentSlotType.CHEST).getItem() == ItemInit.MIIZEALITE_CHESTPLATE.get() && 
			    player.getItemStackFromSlot(EquipmentSlotType.LEGS).getItem() == ItemInit.MIIZEALITE_LEGGINGS.get() && 
			    player.getItemStackFromSlot(EquipmentSlotType.FEET).getItem() == ItemInit.MIIZEALITE_BOOTS.get())
				 
			 	{			
					 player.addPotionEffect(new EffectInstance(Effects.FIRE_RESISTANCE, 5, 0, false, false));			
					 player.removePotionEffect(Effects.WITHER);
			 	}
		 	 
		super.onArmorTick(stack, world, player);
	  
     }

}
