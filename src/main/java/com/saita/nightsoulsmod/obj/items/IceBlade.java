package com.saita.nightsoulsmod.obj.items;

import net.minecraft.entity.LivingEntity;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;

public class IceBlade extends SwordItem {

	public IceBlade(IItemTier tier, int attackDamageIn, float attackSpeedIn, Properties builder) {
		super(tier, attackDamageIn, attackSpeedIn, builder);

	}
	
	@Override
	public boolean hitEntity(ItemStack stack, LivingEntity target, LivingEntity attacker) {
    	target.addPotionEffect(new EffectInstance(Effects.SLOWNESS, 120, 1));
		return super.hitEntity(stack, target, attacker);
	}

}
