package com.saita.nightsoulsmod.obj.items;

import java.util.List;

import com.saita.nightsoulsmod.init.ItemInit;

import net.minecraft.client.gui.screen.Screen;
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

public class ChlorophyteArmor extends ArmorItem {

	public ChlorophyteArmor(IArmorMaterial materialIn, EquipmentSlotType slot, Properties builderIn) {
		super(materialIn, slot, builderIn);

	}
	

	@Override
    public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn)
    {
    
	tooltip.set(0, new StringTextComponent("§2"+tooltip.get(0).getString()+"§r"));
	
	 if(Screen.hasShiftDown())
   	 {
   		 	tooltip.add(new StringTextComponent("§2Full set bonus : §7Infinite Haste II, Strength III and Resistance I. Greatly restores health overtime. Immunity to a bunch of debuffs. Automatically repairs itself."));	
   	 }
   	 else
   	 {
   		 	tooltip.add(new StringTextComponent("§7An armor literally made of a metal that's ALIVE. Press §eSHIFT§7 for more info."));
   	 }

	super.addInformation(stack, worldIn, tooltip, flagIn);
	
    }
	
	@Override
	public void onArmorTick(ItemStack stack, World world, PlayerEntity player) {
		
		if(player.getItemStackFromSlot(EquipmentSlotType.HEAD).getItem() == ItemInit.CHLOROPHYTE_HELMET.get() && 
		   player.getItemStackFromSlot(EquipmentSlotType.LEGS).getItem() == ItemInit.CHLOROPHYTE_LEGGINGS.get() &&  
		   player.getItemStackFromSlot(EquipmentSlotType.LEGS).getItem() == ItemInit.CHLOROPHYTE_LEGGINGS.get() && 
		   player.getItemStackFromSlot(EquipmentSlotType.FEET).getItem() == ItemInit.CHLOROPHYTE_BOOTS.get())	
			
		{
			 player.addPotionEffect(new EffectInstance(Effects.HASTE, 5, 1, false, false));
			 player.addPotionEffect(new EffectInstance(Effects.STRENGTH, 5, 2, false, false));
			 player.addPotionEffect(new EffectInstance(Effects.RESISTANCE, 5, 0, false, false));
			 
			 player.removePotionEffect(Effects.POISON);
			 player.removePotionEffect(Effects.WITHER);
			 player.removePotionEffect(Effects.NAUSEA);
			 player.removePotionEffect(Effects.SLOWNESS);
			 player.removePotionEffect(Effects.MINING_FATIGUE);
			 player.removePotionEffect(Effects.HUNGER);
			
			 if(world.getGameTime() % 50 == 0)
				{
				   int randomHealChance = random.nextInt(3);
						    
				   if(randomHealChance == 0)
				   	 {
				   		player.heal(1.0F);
				   	 }
				}	 
		
			if(world.getGameTime() % 300 == 0)
			  {
				stack.damageItem(-1, player, null);
			  }
		
		}
		
		super.onArmorTick(stack, world, player);
	}
	

}
