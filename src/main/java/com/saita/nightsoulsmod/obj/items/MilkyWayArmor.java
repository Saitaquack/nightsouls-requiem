package com.saita.nightsoulsmod.obj.items;

import java.util.List;

import com.saita.nightsoulsmod.init.ItemInit;
import com.saita.nightsoulsmod.init.SoundInit;

import net.minecraft.client.gui.screen.Screen;
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

public class MilkyWayArmor extends ArmorItem {

	public MilkyWayArmor(IArmorMaterial materialIn, EquipmentSlotType slot, Properties builder) {
		super(materialIn, slot, builder);

	}
	
	@Override
	public Rarity getRarity(ItemStack stack) {
		
		return Rarity.EPIC;
	}
	
	@Override
    public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn)
    {

	tooltip.set(0, new StringTextComponent("§1"+tooltip.get(0).getString()+"§r"));
    
    if(Screen.hasShiftDown())
	{
		 tooltip.add(new StringTextComponent("§1Full set bonus : §7Infinite Strength III, Speed II, Jump Boost III, Haste I, Resistance I and restores health overtime. Hold sneak to enable slow falling. Automatically gives you star bits and nightsouls emeralds overtime."));	
	}
	else
	{
		tooltip.add(new StringTextComponent("§7It is said that this armor was forged by a single entity after gathering hundreds of stars. You can feel the whole universe just by gazing at it. Press §eSHIFT§7 for more info."));
	}
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
		 
	 if(player.getItemStackFromSlot(EquipmentSlotType.HEAD).getItem() == ItemInit.MILKY_WAY_HELMET.get() && 
		player.getItemStackFromSlot(EquipmentSlotType.CHEST).getItem() == ItemInit.MILKY_WAY_CHESTPLATE.get() && 
		player.getItemStackFromSlot(EquipmentSlotType.LEGS).getItem() == ItemInit.MILKY_WAY_LEGGINGS.get() && 
		player.getItemStackFromSlot(EquipmentSlotType.FEET).getItem() == ItemInit.MILKY_WAY_BOOTS.get())
				    	 
		 {		 

		 player.removePotionEffect(Effects.POISON);
		 player.removePotionEffect(Effects.WITHER);
		 player.removePotionEffect(Effects.NAUSEA);
				 
		 player.addPotionEffect(new EffectInstance(Effects.STRENGTH, 5, 2, false, false));	    
		 player.addPotionEffect(new EffectInstance(Effects.SPEED, 5, 1, false, false));
		 player.addPotionEffect(new EffectInstance(Effects.JUMP_BOOST, 5, 2, false, false));
		 player.addPotionEffect(new EffectInstance(Effects.HASTE, 5, 0, false, false));
		 player.addPotionEffect(new EffectInstance(Effects.RESISTANCE, 5, 0, false, false));
		 
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
			    			    				    	
			 if(world.getGameTime() % 2400 == 0)
			   	{
                    ItemStack starFragment = new ItemStack(ItemInit.STAR_BIT.get(), 1);
          		    player.dropItem(starFragment, false).setNoPickupDelay();
          		    world.playSound(player, player.getPosition(), SoundInit.STAR_BIT.get(), SoundCategory.MASTER, 1.0F, 1.0F);
                 }
			 
			 }
 
		super.onArmorTick(stack, world, player);
	  
    }

}
