package com.saita.nightsoulsmod.obj.items;

import java.util.List;

import com.saita.nightsoulsmod.init.ItemInit;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;


public class ParagonicNightSoulsBoots extends ParagonicNightSoulsArmor {

	public ParagonicNightSoulsBoots(IArmorMaterial materialIn, EquipmentSlotType slot, Properties builderIn) {
		super(materialIn, slot, builderIn);

	}
	
	@Override
    public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn)
    {

	tooltip.set(0, new StringTextComponent("§5"+tooltip.get(0).getString()+"§r"));
    tooltip.add(new StringTextComponent("§aYou truly are the master of this world now."));
	super.addInformation(stack, worldIn, tooltip, flagIn);
    }
	
	@Override
	public void onArmorTick(ItemStack stack, World world, PlayerEntity player) {
		
		 if(player.getItemStackFromSlot(EquipmentSlotType.FEET).getItem() == ItemInit.PARAGONIC_NIGHTSOULS_BOOTS.get())
		 {
				player.addPotionEffect(new EffectInstance(Effects.HASTE, 5, 3, false, false));
				player.addPotionEffect(new EffectInstance(Effects.HERO_OF_THE_VILLAGE, 20, 0, false, false));
				player.addPotionEffect(new EffectInstance(Effects.CONDUIT_POWER, 5, 0, false, false));	
				player.addPotionEffect(new EffectInstance(Effects.DOLPHINS_GRACE, 5, 0, false, false));	
		 }
				 	
		  if(player.isSneaking())
			{	
			    if(world.getGameTime() % 60 == 0)
				 {
					player.addPotionEffect(new EffectInstance(Effects.REGENERATION, 80, 2));						 
				 }
			    
			player.addPotionEffect(new EffectInstance(Effects.RESISTANCE, 5, 1));	
			player.addPotionEffect(new EffectInstance(Effects.SATURATION, 5, 0));	
			
		  }
		
		super.onArmorTick(stack, world, player);
	}

}
