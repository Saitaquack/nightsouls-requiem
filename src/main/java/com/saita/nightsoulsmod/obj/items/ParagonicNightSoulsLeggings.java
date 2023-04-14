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


public class ParagonicNightSoulsLeggings extends ParagonicNightSoulsArmor {

	public ParagonicNightSoulsLeggings(IArmorMaterial materialIn, EquipmentSlotType slot, Properties builderIn) {
		super(materialIn, slot, builderIn);

	}
	
	@Override
    public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn)
    {

	tooltip.set(0, new StringTextComponent("§5"+tooltip.get(0).getString()+"§r"));
    tooltip.add(new StringTextComponent("§1Use my power to dominate the universe."));
	super.addInformation(stack, worldIn, tooltip, flagIn);
    } 
	
	@Override
	public void onArmorTick(ItemStack stack, World world, PlayerEntity player) {
		
		
		if(player.getItemStackFromSlot(EquipmentSlotType.LEGS).getItem() == ItemInit.PARAGONIC_NIGHTSOULS_LEGGINGS.get())
		 {
			 player.addPotionEffect(new EffectInstance(Effects.STRENGTH, 5, 2, false, false));	  
			 player.addPotionEffect(new EffectInstance(Effects.JUMP_BOOST, 5, 2, false, false));	
			 if(world.getGameTime() % 60 == 0)
				{
				   int randomHealChance = random.nextInt(3);
						    
				   if(randomHealChance == 0)
				   	 {
				   		player.heal(1.0F);
				   	 }
				}
			 if(player.isSneaking())
			   {	
			    	player.addPotionEffect(new EffectInstance(Effects.SLOW_FALLING, 100, 0, false, false));						 
			   }
			    			    				    	
		 }
		super.onArmorTick(stack, world, player);
	}

}
