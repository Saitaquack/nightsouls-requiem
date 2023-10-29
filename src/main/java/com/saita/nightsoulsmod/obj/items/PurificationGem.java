package com.saita.nightsoulsmod.obj.items;

import java.util.List;

import com.saita.nightsoulsmod.init.ItemInit;
import com.saita.nightsoulsmod.init.SoundInit;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Rarity;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

public class PurificationGem extends Item {

	public PurificationGem(Properties properties) {
		super(properties);

	}
	
	@Override
	public Rarity getRarity(ItemStack stack) {

		return Rarity.RARE;
	}
	
	@Override
	public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn)
	{
	    	
	   tooltip.add(new StringTextComponent("§7Allows you to destroy the vampire mask if you wear one. Right Click to use it and consume it."));
	   super.addInformation(stack, worldIn, tooltip, flagIn);
	} 
	
	 
	 @Override
	 public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
		 
		 if(playerIn.getItemStackFromSlot(EquipmentSlotType.HEAD).getItem() == ItemInit.VAMPIRE_MASK.get())
		 {
			 ItemStack itemstack = playerIn.getHeldItem(handIn);
			 itemstack.shrink(1);
			 playerIn.getItemStackFromSlot(EquipmentSlotType.HEAD).shrink(1);
			 
	 	     worldIn.playSound(playerIn, playerIn.getPosition(), SoundInit.LIFE_CRYSTAL.get(), SoundCategory.MASTER, 1.0F, 1.0F);
	 	     worldIn.playSound(playerIn, playerIn.getPosition(), SoundInit.PALADIN_AMBIENT.get(), SoundCategory.MASTER, 1.0F, 1.0F); 
	 	     worldIn.playSound(playerIn, playerIn.getPosition(), SoundEvents.ITEM_SHIELD_BREAK, SoundCategory.MASTER, 1.0F, 1.0F); 
	 	     
	 	     if(worldIn.isRemote)
	 	      {
				 playerIn.sendMessage(new TranslationTextComponent("The vampire mask has been shattered."), null);
	 	      } 
		 }
		 else
		 {
			 if(worldIn.isRemote)
	    	 {
				 playerIn.sendMessage(new TranslationTextComponent("You are not wearing a vampire mask."), null);
	    	 } 
		 }
		
	    
	    
	    return super.onItemRightClick(worldIn, playerIn, handIn);
	    
	  }

}
