package com.saita.nightsoulsmod.obj.items;

import java.util.List;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
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

public class BinaryWings extends Item {

	public BinaryWings(Properties properties) {
		super(properties);

	}
	
	@Override
	public Rarity getRarity(ItemStack stack) {
		
		return Rarity.EPIC;
	}
	
	@Override
	public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn)
	{
	    	
	   tooltip.add(new StringTextComponent("§7Right click to activate or deactivate fly !"));
	   super.addInformation(stack, worldIn, tooltip, flagIn);
	}  
	
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {	
		
		worldIn.playSound(playerIn, playerIn.getPosition(), SoundEvents.ENTITY_ENDER_DRAGON_FLAP, SoundCategory.MASTER, 1.0F, 1.0F);
		
		if(!playerIn.abilities.isFlying)
		{
			playerIn.abilities.allowFlying = true;
			playerIn.abilities.isFlying = true;
				
			if(worldIn.isRemote)
			{
				playerIn.sendMessage(new TranslationTextComponent("You are now flying."), null);
			}
				
		}
		else
		{
			playerIn.abilities.allowFlying = false;
			playerIn.abilities.isFlying = false;
				
			if(worldIn.isRemote)
			{
				playerIn.sendMessage(new TranslationTextComponent("You are no longer flying."), null);
			}
		}
				
		return super.onItemRightClick(worldIn, playerIn, handIn);
	}

}
