package com.saita.legendsawaken.obj.items;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.Tier;

public class InfernalPickaxe extends PickaxeItem {

	public InfernalPickaxe(Tier p_42961_, int p_42962_, float p_42963_, Properties p_42964_) {
		super(p_42961_, p_42962_, p_42963_, p_42964_);

	}
	
	@Override
	public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {

		target.setSecondsOnFire(6);
		
		return super.hurtEnemy(stack, target, attacker);
	}

}
