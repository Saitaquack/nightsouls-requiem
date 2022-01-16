package com.saita.nightsoulsmod.obj.items;

import net.minecraft.entity.LivingEntity;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;

public class PoisonMiizealiteDagger extends SwordItem {

	public PoisonMiizealiteDagger(IItemTier tier, int attackDamageIn, float attackSpeedIn, Properties builderIn) {
		super(tier, attackDamageIn, attackSpeedIn, builderIn);
	
	}
	
	@Override
	public boolean hitEntity(ItemStack stack, LivingEntity target, LivingEntity attacker) {

		target.addPotionEffect(new EffectInstance(Effects.POISON, 240, 0));
		
		return super.hitEntity(stack, target, attacker);
	}

}
