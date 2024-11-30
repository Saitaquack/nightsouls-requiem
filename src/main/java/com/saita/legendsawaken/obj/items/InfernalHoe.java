package com.saita.legendsawaken.obj.items;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;

public class InfernalHoe extends HoeItem {

	public InfernalHoe(Tier p_41336_, int p_41337_, float p_41338_, Properties p_41339_) {
		super(p_41336_, p_41337_, p_41338_, p_41339_);
		
	}
	
	@Override
	public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {

		target.setSecondsOnFire(6);
		
		return super.hurtEnemy(stack, target, attacker);
	}

}
