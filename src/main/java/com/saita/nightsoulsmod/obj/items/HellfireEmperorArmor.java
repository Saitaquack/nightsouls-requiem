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
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;

public class HellfireEmperorArmor extends ArmorItem {

	public HellfireEmperorArmor(IArmorMaterial materialIn, EquipmentSlotType slot, Properties builder) {
		super(materialIn, slot, builder);

	}
	
	
	@Override
	public Rarity getRarity(ItemStack stack) {
		
		return Rarity.EPIC;
	}
	
	@Override
    public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn)
    {

	tooltip.set(0, new StringTextComponent("§4"+tooltip.get(0).getString()+"§r"));
    tooltip.add(new StringTextComponent("§4Full set bonus : §7Infinite Fire Resistance, Strength I, Speed II, Haste I and Resistance I. Increased movement in the Nether or during nighttime. Your strength, regeneration, resistance and haste increases if you are on fire, in the Nether or in lava. Fire also removes most bad potion effects. Automatically gives you nightsouls emeralds overtime. Long live the emperor !"));
	super.addInformation(stack, worldIn, tooltip, flagIn);
    }  
	
	@Override
	public void onCreated(ItemStack stack, World worldIn, PlayerEntity playerIn) {
		
		if(!stack.isEnchanted())		
		 {
			 stack.addEnchantment(Enchantments.PROTECTION, 4);
		 }
		
		super.onCreated(stack, worldIn, playerIn);
	}
	
	@Override
	public void inventoryTick(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
		
		 if(entityIn instanceof PlayerEntity)
	    	{
	    		 PlayerEntity playerIn = (PlayerEntity)entityIn;	
	    		 if(!stack.isEnchanted() && playerIn.isCreative())
			
	    		 {
	    			 stack.addEnchantment(Enchantments.PROTECTION, 4);
	    		 }
		
	    		 super.inventoryTick(stack, worldIn, entityIn, itemSlot, isSelected);
	    	}
     }
	
	 @Override
	 public void onArmorTick(ItemStack stack, World world, PlayerEntity player) {	
		 
		 if(world.getGameTime() % 3000 == 0)
		    {
			 	ItemStack nsEmerald = new ItemStack(ItemInit.NIGHTSOULS_EMERALD.get(), 1);
			 	player.dropItem(nsEmerald, false).setNoPickupDelay();
			 	world.playSound(player, player.getPosition(), SoundEvents.ENTITY_EXPERIENCE_ORB_PICKUP, SoundCategory.MASTER, 0.5F, 1.0F);
            }
		 
	if(player.getItemStackFromSlot(EquipmentSlotType.HEAD).getItem() == ItemInit.HELLFIRE_EMPEROR_HELMET.get() && 
	   player.getItemStackFromSlot(EquipmentSlotType.CHEST).getItem() == ItemInit.HELLFIRE_EMPEROR_CHESTPLATE.get() && 
	   player.getItemStackFromSlot(EquipmentSlotType.LEGS).getItem() == ItemInit.HELLFIRE_EMPEROR_LEGGINGS.get() && 
	   player.getItemStackFromSlot(EquipmentSlotType.FEET).getItem() == ItemInit.HELLFIRE_EMPEROR_BOOTS.get())
							    	 
		{		 

				 
        //Global debuffs removals
		player.removePotionEffect(Effects.POISON);
		player.removePotionEffect(Effects.WITHER);
		player.removePotionEffect(Effects.NAUSEA);			    
				  
		player.addPotionEffect(new EffectInstance(Effects.FIRE_RESISTANCE, 5, 0, false, false));
		player.addPotionEffect(new EffectInstance(Effects.STRENGTH, 5, 0, false, false));
		player.addPotionEffect(new EffectInstance(Effects.SPEED, 5, 1, false, false));	
		player.addPotionEffect(new EffectInstance(Effects.HASTE, 5, 0, false, false));
		player.addPotionEffect(new EffectInstance(Effects.RESISTANCE, 5, 0, false, false));
				 	
		//Speed Buffs in the Nether and at night.
		if(player.world.getDimensionKey().getLocation().getPath() == "the_nether" || world.isNightTime())
		  {
			 player.addPotionEffect(new EffectInstance(Effects.SPEED, 5, 2, false, false));	
			 player.addPotionEffect(new EffectInstance(Effects.JUMP_BOOST, 5, 2, false, false));	
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
					    
			  player.addPotionEffect(new EffectInstance(Effects.STRENGTH, 5, 3, false, false));
			  player.addPotionEffect(new EffectInstance(Effects.RESISTANCE, 5, 2, false, false));
			  player.addPotionEffect(new EffectInstance(Effects.HASTE, 5, 3, false, false));

			  if(world.getGameTime() % 60 == 0)
			   {
				  player.addPotionEffect(new EffectInstance(Effects.REGENERATION, 100, 3));
			    }
				 		
			}
			else if(player.world.getDimensionKey().getLocation().getPath() == "the_nether" || world.isNightTime())
			{
				player.addPotionEffect(new EffectInstance(Effects.STRENGTH, 5, 2, false, false));
				player.addPotionEffect(new EffectInstance(Effects.RESISTANCE, 5, 1, false, false));
				player.addPotionEffect(new EffectInstance(Effects.HASTE, 5, 1, false, false));	
				if(world.getGameTime() % 60 == 0)
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
					    
				player.addPotionEffect(new EffectInstance(Effects.STRENGTH, 5, 2, false, false));
				player.addPotionEffect(new EffectInstance(Effects.RESISTANCE, 5, 1, false, false));
				player.addPotionEffect(new EffectInstance(Effects.HASTE, 5, 1, false, false));
				if(world.getGameTime() % 60 == 0)
					{
				 		player.addPotionEffect(new EffectInstance(Effects.REGENERATION, 100, 2));
					}
			}
		 
		}

		super.onArmorTick(stack, world, player);
	  
    }

}
