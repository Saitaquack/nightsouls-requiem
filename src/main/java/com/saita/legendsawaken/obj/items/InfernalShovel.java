package com.saita.legendsawaken.obj.items;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.item.Tier;

public class InfernalShovel extends ShovelItem {

	public InfernalShovel(Tier p_43114_, float p_43115_, float p_43116_, Properties p_43117_) {
		super(p_43114_, p_43115_, p_43116_, p_43117_);
	
	}
	
	@Override
	public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {

		target.setSecondsOnFire(6);
		
		return super.hurtEnemy(stack, target, attacker);
	}

}
