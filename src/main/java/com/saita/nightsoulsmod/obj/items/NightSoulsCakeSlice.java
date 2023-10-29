package com.saita.nightsoulsmod.obj.items;

import java.util.List;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;

public class NightSoulsCakeSlice extends Item {

	public NightSoulsCakeSlice(Properties properties) {
		super(properties);
	
	}
	
	@Override
    public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn)
    {

    tooltip.add(new StringTextComponent("§7Grants you random good effects for 20 seconds."));
	super.addInformation(stack, worldIn, tooltip, flagIn);
    }  
	
	@Override
	public ItemStack onItemUseFinish(ItemStack stack, World worldIn, LivingEntity entityLiving) {
		
		
		int randomEffect = random.nextInt(12);
		
		if(!worldIn.isRemote)
		{		
			switch(randomEffect)
			{
			case 0:
				entityLiving.addPotionEffect(new EffectInstance(Effects.SPEED, 400, 0));
			break;
			case 1:
				entityLiving.addPotionEffect(new EffectInstance(Effects.HASTE, 400, 0));
			break;
			case 2:
				entityLiving.addPotionEffect(new EffectInstance(Effects.STRENGTH, 400, 0));
			break;
			case 3:
				entityLiving.addPotionEffect(new EffectInstance(Effects.JUMP_BOOST, 400, 0));
			break;
			case 4:
				entityLiving.addPotionEffect(new EffectInstance(Effects.REGENERATION, 400, 0));
			break;
			case 5:
				entityLiving.addPotionEffect(new EffectInstance(Effects.RESISTANCE, 400, 0));
			break;
			case 6:
				entityLiving.addPotionEffect(new EffectInstance(Effects.FIRE_RESISTANCE, 400, 0));
			break;
			case 7:
				entityLiving.addPotionEffect(new EffectInstance(Effects.WATER_BREATHING, 400, 0));
			break;
			case 8:
				entityLiving.addPotionEffect(new EffectInstance(Effects.HEALTH_BOOST, 400, 0));
			break;
			case 9:
				entityLiving.addPotionEffect(new EffectInstance(Effects.ABSORPTION, 400, 0));
			break;
			case 10:
				entityLiving.addPotionEffect(new EffectInstance(Effects.DOLPHINS_GRACE, 400, 0));
			break;
			case 11:
				entityLiving.addPotionEffect(new EffectInstance(Effects.HERO_OF_THE_VILLAGE, 400, 0));
			break;
			}
		
		}
		  
		return super.onItemUseFinish(stack, worldIn, entityLiving);
	}

}
