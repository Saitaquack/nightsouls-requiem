package com.saita.legendsawaken.obj.items;

import com.saita.legendsawaken.init.SoundInit;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;

public class BarbarianWaraxe extends AxeItem {

	public BarbarianWaraxe(Tier p_40521_, float p_40522_, float p_40523_, Properties p_40524_) {
		super(p_40521_, p_40522_, p_40523_, p_40524_);

	}
	
	@Override
	public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {

		target.playSound(SoundInit.WARAXE.get(), 1.0F, 1.0F);
		
		return super.hurtEnemy(stack, target, attacker);
	}

}
