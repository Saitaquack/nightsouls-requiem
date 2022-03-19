package com.saita.nightsoulsmod.obj.items;

import java.util.List;

import com.saita.nightsoulsmod.init.ItemInit;
import com.saita.nightsoulsmod.init.SoundInit;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Rarity;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;

public class SoundBarrier extends Item {

	public SoundBarrier(Properties properties) {
		super(properties);

	}
	
	@Override
	public boolean hasEffect(ItemStack stack) {
		
		return true;
	}	
	
	@Override
	public Rarity getRarity(ItemStack stack) {

	return Rarity.EPIC;
	}
	
	 @Override
	 public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn)
	 {
	    	
	   tooltip.add(new StringTextComponent("§7Grants you a gigantic absorption shield. Cooldown : 120 seconds"));
	   super.addInformation(stack, worldIn, tooltip, flagIn);
	 }
	 
	 @Override
	    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
	    	
	    playerIn.getCooldownTracker().setCooldown(this, 2400);
	    playerIn.getCooldownTracker().setCooldown(ItemInit.NANO_BOOST.get(), 2400);
	    playerIn.getCooldownTracker().setCooldown(ItemInit.PRIMAL_RAGE.get(), 2400);
	    
	    if(!worldIn.isRemote)
	    {
	    	playerIn.addPotionEffect(new EffectInstance(Effects.ABSORPTION, 400, 19));
	    }
	    
	    worldIn.playSound(playerIn, playerIn.getPosition(), SoundInit.SOUND_BARRIER.get(), SoundCategory.MASTER, 1.0F, 1.0F);
	    
	    	return super.onItemRightClick(worldIn, playerIn, handIn);
	   }

}
