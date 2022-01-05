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

public class ChampionArmor extends ArmorItem {

	public ChampionArmor(IArmorMaterial materialIn, EquipmentSlotType slot, Properties builder) {
		super(materialIn, slot, builder);

	}
	
	@Override
    public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn)
    {
    
	tooltip.add(new StringTextComponent("§6Full set bonus : §7Has the effects of Primium, Rowequite and Therenite armors at the same time ! Reduced Molten Core and Super Star cooldowns. Instant Healing Potion has no cooldown and heals more. You have a chance to not consume any of these items."));			
	super.addInformation(stack, worldIn, tooltip, flagIn);
	
    }
	
	 @Override
	 public void onArmorTick(ItemStack stack, World world, PlayerEntity player) {
		 		 		 
			 if(player.getItemStackFromSlot(EquipmentSlotType.HEAD).getItem() == ItemInit.CHAMPION_HELMET.get() && 
			    player.getItemStackFromSlot(EquipmentSlotType.CHEST).getItem() == ItemInit.CHAMPION_CHESTPLATE.get() && 
			    player.getItemStackFromSlot(EquipmentSlotType.LEGS).getItem() == ItemInit.CHAMPION_LEGGINGS.get() && 
			    player.getItemStackFromSlot(EquipmentSlotType.FEET).getItem() == ItemInit.CHAMPION_BOOTS.get())	
			    {
				 
				 player.addPotionEffect(new EffectInstance(Effects.HERO_OF_THE_VILLAGE, 5, 0, false, false));
				 player.addPotionEffect(new EffectInstance(Effects.STRENGTH, 5, 0, false, false));			

				 
				 if(world.getDayTime() % 200 == 0)
				 	{
				 	   player.addPotionEffect(new EffectInstance(Effects.RESISTANCE, 100, 0, false, false));					
				 	}					 
				 	
			 	}	 	 
			 
		  super.onArmorTick(stack, world, player);
	  
     }

}
