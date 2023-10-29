package com.saita.nightsoulsmod.obj.items;

import java.util.List;

import com.saita.nightsoulsmod.init.SoundInit;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Rarity;
import net.minecraft.item.SwordItem;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;

public class Supernova extends SwordItem {

	public Supernova(IItemTier tier, int attackDamageIn, float attackSpeedIn, Properties builder) {
		super(tier, attackDamageIn, attackSpeedIn, builder);

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

	tooltip.set(0, new StringTextComponent("§e"+tooltip.get(0).getString()+"§r"));
    tooltip.add(new StringTextComponent("§7Has a chance to give the enemy deadly levitation and wither effect. Right Click to get levitation yourself."));
	super.addInformation(stack, worldIn, tooltip, flagIn);
    }
	
	 @Override
	 public boolean hitEntity(ItemStack stack, LivingEntity target, LivingEntity attacker) {
		 
		target.playSound(SoundInit.SUPERNOVA.get(), 1.0F, 1.0F);
		int randomLevitation = random.nextInt(9);
		if(randomLevitation == 0)
		{
			target.addPotionEffect(new EffectInstance(Effects.LEVITATION, 80, 3));
			target.addPotionEffect(new EffectInstance(Effects.WITHER, 80, 2));
		}
	    return super.hitEntity(stack, target, attacker);
	 }
	 
	 @Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
		 
		ItemStack itemstack = playerIn.getHeldItem(handIn);
	    itemstack.setDamage(2);
		 
		playerIn.addPotionEffect(new EffectInstance(Effects.LEVITATION, 80, 5));
		 
		return super.onItemRightClick(worldIn, playerIn, handIn);
	}

}
