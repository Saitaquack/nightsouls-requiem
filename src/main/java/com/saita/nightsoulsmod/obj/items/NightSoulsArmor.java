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

public class NightSoulsArmor extends ArmorItem {

	public NightSoulsArmor(IArmorMaterial materialIn, EquipmentSlotType slot, Properties builder) {
		super(materialIn, slot, builder);

	}
	
	@Override
    public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn)
    {
    
	tooltip.set(0, new StringTextComponent("§5"+tooltip.get(0).getString()+"§r"));	
	
	if(Screen.hasShiftDown())
	{
		 tooltip.add(new StringTextComponent("§5Full set bonus : §7Has the effects of Saitastone, Miizealite, Cranite and Bastirite armors at the same time ! Reduced cooldowns of all Overwatch abilities !"));	
	}
	else
	{
		tooltip.add(new StringTextComponent("§7A powerful armor created from the essence of four ancient legends. Press §eSHIFT§7 for more info."));
	}
	
	super.addInformation(stack, worldIn, tooltip, flagIn);	
    }
	
	 @Override
	 public void onArmorTick(ItemStack stack, World world, PlayerEntity player) {
		 		 		 
			 if(player.getItemStackFromSlot(EquipmentSlotType.HEAD).getItem() == ItemInit.NIGHTSOULS_HELMET.get() && 
			    player.getItemStackFromSlot(EquipmentSlotType.CHEST).getItem() == ItemInit.NIGHTSOULS_CHESTPLATE.get() && 
			    player.getItemStackFromSlot(EquipmentSlotType.LEGS).getItem() == ItemInit.NIGHTSOULS_LEGGINGS.get() && 
			    player.getItemStackFromSlot(EquipmentSlotType.FEET).getItem() == ItemInit.NIGHTSOULS_BOOTS.get())
				 
			 	{           
					 player.addPotionEffect(new EffectInstance(Effects.FIRE_RESISTANCE, 5, 0, false, false));
					 player.addPotionEffect(new EffectInstance(Effects.SPEED, 5, 1, false, false));
					 player.addPotionEffect(new EffectInstance(Effects.HASTE, 5, 0, false, false));
					 player.addPotionEffect(new EffectInstance(Effects.WATER_BREATHING, 5, 0, false, false));	
					 
					 player.removePotionEffect(Effects.POISON);
					 player.removePotionEffect(Effects.WITHER);
					 player.removePotionEffect(Effects.NAUSEA);
					 
					 if(world.getGameTime() % 80 == 0)
					  {
						 int randomHealChance = random.nextInt(3);
						    
						   if(randomHealChance == 0)
						   {
						   player.heal(1.0F);
						   }
					   }					 
					 
			 	}
		 	 
		   super.onArmorTick(stack, world, player);
	  
     }

}
