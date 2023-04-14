package com.saita.nightsoulsmod.obj.items;

import java.util.List;

import com.saita.nightsoulsmod.init.ItemInit;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.Rarity;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;

public class BinaryArmor extends ArmorItem {

	public BinaryArmor(IArmorMaterial materialIn, EquipmentSlotType slot, Properties builder) {
		super(materialIn, slot, builder);

	}
	
	@Override
	public Rarity getRarity(ItemStack stack) {
		
		return Rarity.EPIC;
	}
	
	@Override
    public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn)
    {

	tooltip.set(0, new StringTextComponent("§a"+tooltip.get(0).getString()+"§r"));
    
    if(Screen.hasShiftDown())
   	{
   		 tooltip.add(new StringTextComponent("§aFull set bonus : §7Infinite Haste IV, Strength I, Speed II, Fire Resistance, Hero of The Village, Conduit Power and Dolphin's Grace. Automatically repairs itself. Hold sneak for Regeneration II, Saturation and Resistance II. Automatically gives you nightsouls emeralds overtime."));	
   	}
   	else
   	{
   		tooltip.add(new StringTextComponent("§7A perfect armor created by the §kReality Warper§7. It has no known limits to its power. Press §eSHIFT§7 for more info."));
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
		 
	if(player.getItemStackFromSlot(EquipmentSlotType.HEAD).getItem() == ItemInit.BINARY_HELMET.get() && 
	   (player.getItemStackFromSlot(EquipmentSlotType.CHEST).getItem() == ItemInit.BINARY_CHESTPLATE.get() || player.getItemStackFromSlot(EquipmentSlotType.CHEST).getItem() == Items.ELYTRA) && 
	   player.getItemStackFromSlot(EquipmentSlotType.LEGS).getItem() == ItemInit.BINARY_LEGGINGS.get() && 
	   player.getItemStackFromSlot(EquipmentSlotType.FEET).getItem() == ItemInit.BINARY_BOOTS.get())
													    	 
	   {
		
		//Particle Maker
		
		double particleChance = random.nextInt(5);
		if(particleChance == 0)
		{	
			boolean negX = random.nextBoolean();
			boolean negY = random.nextBoolean();
			boolean negZ = random.nextBoolean();
			
			double randX = random.nextDouble() * 0.5D;
			double randY = random.nextDouble() * 0.5D;
			double randZ = random.nextDouble() * 0.5D;
			double randHeight = random.nextDouble();
			
			if(negX)
			{
				randX = -randX;
			}
			if(negY)
			{
				randY = -randY;
			}
			if(negZ)
			{
				randZ = -randZ;
			}
			
		    world.addParticle(ParticleTypes.TOTEM_OF_UNDYING, player.getPosX(), player.getPosY() + randHeight, player.getPosZ(), randX, randY, randZ);
		}
		 		 		 		 
		player.removePotionEffect(Effects.POISON);
		player.removePotionEffect(Effects.WITHER);
		player.removePotionEffect(Effects.NAUSEA);
				 
		player.addPotionEffect(new EffectInstance(Effects.HASTE, 5, 3, false, false));
		player.addPotionEffect(new EffectInstance(Effects.STRENGTH, 5, 0, false, false));
		player.addPotionEffect(new EffectInstance(Effects.SPEED, 5, 1, false, false));
		player.addPotionEffect(new EffectInstance(Effects.FIRE_RESISTANCE, 5, 0, false, false));
		player.addPotionEffect(new EffectInstance(Effects.HERO_OF_THE_VILLAGE, 20, 0, false, false));
		player.addPotionEffect(new EffectInstance(Effects.CONDUIT_POWER, 5, 0, false, false));	
		player.addPotionEffect(new EffectInstance(Effects.DOLPHINS_GRACE, 5, 0, false, false));	
				 	
		if(world.getGameTime() % 200 == 0)
		  {
			stack.damageItem(-1, player, null);
		  }
				 	
		  if(player.isSneaking())
			{	
			    if(world.getGameTime() % 60 == 0)
				 {
					player.addPotionEffect(new EffectInstance(Effects.REGENERATION, 80, 1));						 
				 }
			    
			player.addPotionEffect(new EffectInstance(Effects.RESISTANCE, 5, 1));	
			player.addPotionEffect(new EffectInstance(Effects.SATURATION, 5, 0));	
			
		  }
		  
	   }
 
		super.onArmorTick(stack, world, player);
	  
    }

}
