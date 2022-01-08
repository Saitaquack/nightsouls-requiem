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

public class PrimiumArmor extends ArmorItem {

	public PrimiumArmor(IArmorMaterial materialIn, EquipmentSlotType slot, Properties builder) {
		super(materialIn, slot, builder);

	}
	

	@Override
    public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn)
    {
    
	tooltip.add(new StringTextComponent("§aFull set bonus : §7Infinite Hero of the Village. Reduced Molten Core cooldown, and you have a chance to not consume it."));			
	super.addInformation(stack, worldIn, tooltip, flagIn);
	
    }
	
	 @Override
	 public void onArmorTick(ItemStack stack, World world, PlayerEntity player) {
		 		 		 
			 if(player.getItemStackFromSlot(EquipmentSlotType.HEAD).getItem() == ItemInit.PRIMIUM_HELMET.get() && 
			    player.getItemStackFromSlot(EquipmentSlotType.CHEST).getItem() == ItemInit.PRIMIUM_CHESTPLATE.get() && 
			    player.getItemStackFromSlot(EquipmentSlotType.LEGS).getItem() == ItemInit.PRIMIUM_LEGGINGS.get() && 
			    player.getItemStackFromSlot(EquipmentSlotType.FEET).getItem() == ItemInit.PRIMIUM_BOOTS.get())
				 
			 	{			
					 player.addPotionEffect(new EffectInstance(Effects.HERO_OF_THE_VILLAGE, 5, 0, false, false));			
			 	}
		 	 
		super.onArmorTick(stack, world, player);
	  
     }

}
