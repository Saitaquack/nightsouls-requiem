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


public class ParagonicNightSoulsHelmet extends ParagonicNightSoulsArmor {

	public ParagonicNightSoulsHelmet(IArmorMaterial materialIn, EquipmentSlotType slot, Properties builderIn) {
		super(materialIn, slot, builderIn);

	}
	
	@Override
    public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn)
    {
    
	tooltip.set(0, new StringTextComponent("§5"+tooltip.get(0).getString()+"§r"));	
	tooltip.add(new StringTextComponent("§6Let my power and God's might bless you, Warrior."));			
	super.addInformation(stack, worldIn, tooltip, flagIn);
    }
	
	@Override
	public void onArmorTick(ItemStack stack, World world, PlayerEntity player) {
		
		 if(player.getItemStackFromSlot(EquipmentSlotType.HEAD).getItem() == ItemInit.PARAGONIC_NIGHTSOULS_HELMET.get())
		 {
			 player.removePotionEffect(Effects.POISON);
			 player.removePotionEffect(Effects.WITHER);
			 player.removePotionEffect(Effects.NAUSEA);
			 
			 player.addPotionEffect(new EffectInstance(Effects.SPEED, 5, 2, false, false));
			 player.addPotionEffect(new EffectInstance(Effects.RESISTANCE, 5, 1, false, false));
			 
			 if(world.getDayTime() % 100 == 0)
				{
					player.addPotionEffect(new EffectInstance(Effects.REGENERATION, 200, 0, false, false));
				}
						 
			if(world.getDayTime() % 400 == 0)
				{
					player.addPotionEffect(new EffectInstance(Effects.ABSORPTION, 200, 3, false, false));
					player.addPotionEffect(new EffectInstance(Effects.RESISTANCE, 200, 1, false, false));
					player.addPotionEffect(new EffectInstance(Effects.GLOWING, 200, 0, false, false));
				}
			
			 
			if(player.isSneaking())
				{	
				  player.addPotionEffect(new EffectInstance(Effects.JUMP_BOOST, 20, 5, false, false));	
				}
		 }

		super.onArmorTick(stack, world, player);
	}

}
