package com.saita.nightsoulsmod.obj.items;

import java.util.List;

import com.saita.nightsoulsmod.init.ItemInit;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Rarity;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;

public class VampireMask extends ArmorItem {

	public VampireMask(IArmorMaterial materialIn, EquipmentSlotType slot, Properties builder) {
		super(materialIn, slot, builder);

	}
	
	@Override
	public Rarity getRarity(ItemStack stack) {
		
		return Rarity.EPIC;
	}
	
	@Override
    public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn)
    {
    
	tooltip.add(new StringTextComponent("§4WARNING : §7Putting this mask on will reject your humanity. You will become a vampire until you die and lose the mask. You will become extremely powerful, but stay away from any form of light !"));			
	super.addInformation(stack, worldIn, tooltip, flagIn);
	
    }
	
	@Override
	public void inventoryTick(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
		
		if(stack.isEnchanted() == false)
			
		  {
		  stack.addEnchantment(Enchantments.BINDING_CURSE, 1);
		  stack.addEnchantment(Enchantments.VANISHING_CURSE, 1);
		  }
		
		super.inventoryTick(stack, worldIn, entityIn, itemSlot, isSelected);
	}
	
	 @Override
	 public void onArmorTick(ItemStack stack, World world, PlayerEntity player) {
		 
		 if(player.getItemStackFromSlot(EquipmentSlotType.HEAD).getItem() == ItemInit.VAMPIRE_MASK.get())
		 {
		 		 		 
			 player.addPotionEffect(new EffectInstance(Effects.STRENGTH, 5, 3, false, false));
			 player.addPotionEffect(new EffectInstance(Effects.RESISTANCE, 5, 1, false, false));
			 player.addPotionEffect(new EffectInstance(Effects.SPEED, 5, 2, false, false));
		 	 player.addPotionEffect(new EffectInstance(Effects.JUMP_BOOST, 5, 1, false, false));	
		 	 player.addPotionEffect(new EffectInstance(Effects.HASTE, 5, 1, false, false));	
		 	 
		 	 if(world.getGameTime() % 180 == 0)
			   {
				  player.addPotionEffect(new EffectInstance(Effects.NIGHT_VISION, 400, 0, false, false));
			   }
		 	 
		 	 if(world.getGameTime() % 100 == 0)
			   {
				  player.addPotionEffect(new EffectInstance(Effects.REGENERATION, 200, 1, false, false));
			   }

		 	 if(world.isDaytime() && !world.isRemote)
		 	 {
		 		 BlockPos playerPos = new BlockPos(player.getPosition().getX(), player.getPosition().getY(), player.getPosition().getZ());
		 		 if((world.getLight(playerPos) > 11 && player.getPosY() > 48) || (player.world.getDimensionKey().getLocation().getPath() == "the_nether" || player.world.getDimensionKey().getLocation().getPath() == "the_end"))
		 		 {
		 			 player.setFire(10);
		 			 player.attackEntityFrom(DamageSource.MAGIC, 5);
		 			 player.removePotionEffect(Effects.STRENGTH);
		 			 player.removePotionEffect(Effects.SPEED);
		 			 player.removePotionEffect(Effects.JUMP_BOOST);
		 			 player.removePotionEffect(Effects.HASTE);
		 			 player.removePotionEffect(Effects.REGENERATION);
		 		  }
	    	
		 	  }
		 }	
		 
	  super.onArmorTick(stack, world, player);
	  
    }

}
