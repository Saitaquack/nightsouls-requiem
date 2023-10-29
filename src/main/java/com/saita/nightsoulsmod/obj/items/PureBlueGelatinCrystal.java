package com.saita.nightsoulsmod.obj.items;

import java.util.List;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Effects;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;

public class PureBlueGelatinCrystal extends Item {

	public PureBlueGelatinCrystal(Properties properties) {
		super(properties);

	}
	
	@Override
    public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn)
    {
    	
    tooltip.add(new StringTextComponent("§7An absolute delicacy that removes most bad effects and heals 6 HP."));
	super.addInformation(stack, worldIn, tooltip, flagIn);
    }
	
	@Override
	public ItemStack onItemUseFinish(ItemStack stack, World worldIn, LivingEntity entityLiving) {
		
		  entityLiving.removePotionEffect(Effects.SLOWNESS);
		  entityLiving.removePotionEffect(Effects.MINING_FATIGUE);
		  entityLiving.removePotionEffect(Effects.WEAKNESS);
		  entityLiving.removePotionEffect(Effects.NAUSEA);
		  entityLiving.removePotionEffect(Effects.BLINDNESS);
		  entityLiving.removePotionEffect(Effects.HUNGER);
		  entityLiving.removePotionEffect(Effects.POISON);
		  entityLiving.removePotionEffect(Effects.WITHER);
		  entityLiving.heal(6);
		  
		return super.onItemUseFinish(stack, worldIn, entityLiving);
	}

}
