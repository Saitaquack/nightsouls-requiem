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

public class HallowedPaladinArmor extends ArmorItem {

	public HallowedPaladinArmor(IArmorMaterial materialIn, EquipmentSlotType slot, Properties builder) {
		super(materialIn, slot, builder);

	}
	
	@Override
	public Rarity getRarity(ItemStack stack) {
		
		return Rarity.EPIC;
	}
	
	@Override
    public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn)
    {

	tooltip.set(0, new StringTextComponent("§6"+tooltip.get(0).getString()+"§r"));
	
	if(Screen.hasShiftDown())
	{
		 tooltip.add(new StringTextComponent("§6Full set bonus : §7Infinite Speed III, Strength II, Regeneration I and Resistance I. Temporary shield every 20 seconds for 10 seconds that gives Absorption III and Resistance II. Hold sneak to jump super high, to regenerate health faster and to get super speed. Automatically gives you nightsouls emeralds overtime."));	
	}
	else
	{
		tooltip.add(new StringTextComponent("§7A mythical armor forged in the heavens by the most powerful servant of God. Press §eSHIFT§7 for more info."));
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
		 
	 if(player.getItemStackFromSlot(EquipmentSlotType.HEAD).getItem() == ItemInit.HALLOWED_PALADIN_HELMET.get() && 
		(player.getItemStackFromSlot(EquipmentSlotType.CHEST).getItem() == ItemInit.HALLOWED_PALADIN_CHESTPLATE.get() || player.getItemStackFromSlot(EquipmentSlotType.CHEST).getItem() == Items.ELYTRA) && 
		player.getItemStackFromSlot(EquipmentSlotType.LEGS).getItem() == ItemInit.HALLOWED_PALADIN_LEGGINGS.get() && 
	    player.getItemStackFromSlot(EquipmentSlotType.FEET).getItem() == ItemInit.HALLOWED_PALADIN_BOOTS.get())
										    	 
		{	
		 
		//Particle Maker

		 world.addParticle(ParticleTypes.END_ROD, player.getPosX(), player.getPosY() + 2.25D, player.getPosZ() + 0.25D, 0.0D, 0.0D, 0.0D);
		 world.addParticle(ParticleTypes.END_ROD, player.getPosX(), player.getPosY() + 2.25D, player.getPosZ() - 0.25D, 0.0D, 0.0D, 0.0D);
		 world.addParticle(ParticleTypes.END_ROD, player.getPosX() + 0.25D, player.getPosY() + 2.25D, player.getPosZ(), 0.0D, 0.0D, 0.0D);
		 world.addParticle(ParticleTypes.END_ROD, player.getPosX() - 0.25F, player.getPosY() + 2.25D, player.getPosZ(), 0.0D, 0.0D, 0.0D);

		double particleChance = random.nextInt(15);
		if(particleChance == 0)
		{	
			boolean negX = random.nextBoolean();
			boolean negY = random.nextBoolean();
			boolean negZ = random.nextBoolean();
			
			double randX = random.nextDouble() * 0.25D;
			double randY = random.nextDouble() * 0.25D;
			double randZ = random.nextDouble() * 0.25D;
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
			
		    world.addParticle(ParticleTypes.END_ROD, player.getPosX(), player.getPosY() + randHeight, player.getPosZ(), randX, randY, randZ);
		}
		 			 
		player.removePotionEffect(Effects.POISON);
		player.removePotionEffect(Effects.WITHER);
		player.removePotionEffect(Effects.NAUSEA);
				    			    
		player.addPotionEffect(new EffectInstance(Effects.SPEED, 5, 2, false, false));
		player.addPotionEffect(new EffectInstance(Effects.STRENGTH, 5, 1, false, false));
		player.addPotionEffect(new EffectInstance(Effects.RESISTANCE, 5, 0, false, false));
				 
		if(world.getGameTime() % 100 == 0)
		{
			player.addPotionEffect(new EffectInstance(Effects.REGENERATION, 200, 0, false, false));
		}
				 
		if(world.getGameTime() % 400 == 0)
		   {
			  player.addPotionEffect(new EffectInstance(Effects.ABSORPTION, 200, 2, false, false));
			  player.addPotionEffect(new EffectInstance(Effects.RESISTANCE, 200, 1, false, false));
			  player.addPotionEffect(new EffectInstance(Effects.GLOWING, 200, 0, false, false));
		  }
				 
		if(player.isSneaking())
			{	
			  player.addPotionEffect(new EffectInstance(Effects.JUMP_BOOST, 20, 5, false, false));	
			  player.addPotionEffect(new EffectInstance(Effects.SPEED, 130, 4, false, false));	
			  
			   if(world.getGameTime() % 60 == 0)
				 {
					player.addPotionEffect(new EffectInstance(Effects.REGENERATION, 80, 1));						 
				 }
		   }
		
		}
   
		super.onArmorTick(stack, world, player);
	  
    }

}
