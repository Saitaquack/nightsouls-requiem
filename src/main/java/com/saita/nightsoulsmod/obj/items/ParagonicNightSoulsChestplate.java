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


public class ParagonicNightSoulsChestplate extends ParagonicNightSoulsArmor {

	public ParagonicNightSoulsChestplate(IArmorMaterial materialIn, EquipmentSlotType slot, Properties builderIn) {
		super(materialIn, slot, builderIn);

	}
	
	@Override
    public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn)
    {

	tooltip.set(0, new StringTextComponent("§5"+tooltip.get(0).getString()+"§r"));
    tooltip.add(new StringTextComponent("§4Let them taste my true demonic wrath."));
	super.addInformation(stack, worldIn, tooltip, flagIn);
    }  
	
	@Override
	public void onArmorTick(ItemStack stack, World world, PlayerEntity player) {
		
		 if(player.getItemStackFromSlot(EquipmentSlotType.CHEST).getItem() == ItemInit.PARAGONIC_NIGHTSOULS_CHESTPLATE.get())
		 {
			 player.addPotionEffect(new EffectInstance(Effects.FIRE_RESISTANCE, 5, 0, false, false));

			 if(player.world.getDimensionKey().getLocation().getPath() == "the_nether" || world.isNightTime())
				{
				  player.addPotionEffect(new EffectInstance(Effects.SPEED, 5, 3, false, false));	
				  player.addPotionEffect(new EffectInstance(Effects.JUMP_BOOST, 5, 3, false, false));	
				}
			 
			 if(player.isInLava())
				{
				  player.removePotionEffect(Effects.SLOWNESS);
				  player.removePotionEffect(Effects.MINING_FATIGUE);
				  player.removePotionEffect(Effects.WEAKNESS);
				  player.removePotionEffect(Effects.NAUSEA);
				  player.removePotionEffect(Effects.BLINDNESS);
				  player.removePotionEffect(Effects.HUNGER);
				  player.removePotionEffect(Effects.POISON);
				  player.removePotionEffect(Effects.WITHER);
						    
				  player.addPotionEffect(new EffectInstance(Effects.STRENGTH, 5, 4, false, false));
				  player.addPotionEffect(new EffectInstance(Effects.RESISTANCE, 5, 2, false, false));
				  player.addPotionEffect(new EffectInstance(Effects.HASTE, 5, 3, false, false));

				  if(world.getDayTime() % 60 == 0)
				   {
					  player.addPotionEffect(new EffectInstance(Effects.REGENERATION, 100, 3));
				    }
					 		
				}
				else if(player.world.getDimensionKey().getLocation().getPath() == "the_nether" || world.isNightTime())
				{
					player.addPotionEffect(new EffectInstance(Effects.STRENGTH, 5, 3, false, false));
					player.addPotionEffect(new EffectInstance(Effects.RESISTANCE, 5, 2, false, false));
					player.addPotionEffect(new EffectInstance(Effects.HASTE, 5, 1, false, false));	
					if(world.getDayTime() % 60 == 0)
					  {
					 	if(player.isBurning())
					 	  {
					 			player.addPotionEffect(new EffectInstance(Effects.REGENERATION, 100, 2));
					 	  }
					 	  else
					 	  {
						 		player.addPotionEffect(new EffectInstance(Effects.REGENERATION, 100, 1));
					 	  }
					  }
					 		
				 }
				 else if(player.isBurning())
				 {
					player.removePotionEffect(Effects.SLOWNESS);
					player.removePotionEffect(Effects.MINING_FATIGUE);
					player.removePotionEffect(Effects.WEAKNESS);
					player.removePotionEffect(Effects.NAUSEA);
					player.removePotionEffect(Effects.BLINDNESS);
					player.removePotionEffect(Effects.HUNGER);
					player.removePotionEffect(Effects.POISON);
					player.removePotionEffect(Effects.WITHER);
						    
					player.addPotionEffect(new EffectInstance(Effects.STRENGTH, 5, 3, false, false));
					player.addPotionEffect(new EffectInstance(Effects.RESISTANCE, 5, 2, false, false));
					player.addPotionEffect(new EffectInstance(Effects.HASTE, 5, 1, false, false));
					if(world.getDayTime() % 60 == 0)
						{
					 		player.addPotionEffect(new EffectInstance(Effects.REGENERATION, 100, 2));
						}
				}
		 }

		super.onArmorTick(stack, world, player);
	}

}
