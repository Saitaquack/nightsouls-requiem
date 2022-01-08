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

public class NanoBoost extends Item {

	public NanoBoost(Properties properties) {
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
	    	
	   tooltip.add(new StringTextComponent("§7Makes you very fast, strong and resistant for a while. Cooldown : 120 seconds"));
	   super.addInformation(stack, worldIn, tooltip, flagIn);
	 }
	 
	 @Override
	    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
	    	
	    playerIn.getCooldownTracker().setCooldown(this, 2400);
	    playerIn.getCooldownTracker().setCooldown(ItemInit.SOUND_BARRIER.get(), 2400);
	    playerIn.getCooldownTracker().setCooldown(ItemInit.PRIMAL_RAGE.get(), 2400);
	    
	    playerIn.addPotionEffect(new EffectInstance(Effects.SPEED, 500, 4));
	    playerIn.addPotionEffect(new EffectInstance(Effects.STRENGTH, 500, 3));
	    playerIn.addPotionEffect(new EffectInstance(Effects.RESISTANCE, 500, 2));  
	    playerIn.heal(20);
	    worldIn.playSound(playerIn, playerIn.getPosition(), SoundInit.NANO_BOOST.get(), SoundCategory.MASTER, 1.0F, 1.0F);
	    
	    	return super.onItemRightClick(worldIn, playerIn, handIn);
	   }

}
