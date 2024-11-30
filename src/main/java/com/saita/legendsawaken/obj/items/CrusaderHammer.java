package com.saita.legendsawaken.obj.items;

import com.saita.legendsawaken.init.SoundInit;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;

public class CrusaderHammer extends SwordItem {

	public CrusaderHammer(Tier p_43269_, int p_43270_, float p_43271_, Properties p_43272_) {
		super(p_43269_, p_43270_, p_43271_, p_43272_);

	}
	
	@Override
	public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {

		target.playSound(SoundInit.HAMMER.get(), 1.0F, 1.0F);
		
		return super.hurtEnemy(stack, target, attacker);
	}
	
	@Override
	public void inventoryTick(ItemStack stack, Level level, Entity entity, int p_41407_, boolean p_41408_) {
		
		 if(entity instanceof Player)
	    	{
	    		 Player player = (Player)entity;	
	    		 if(!stack.isEnchanted() && player.isCreative())
			
	    		 {
	    			 stack.enchant(Enchantments.SWEEPING_EDGE, 4);
	    		 }
	    	}

		super.inventoryTick(stack, level, entity, p_41407_, p_41408_);
	}
	
	@Override
	public void onCraftedBy(ItemStack stack, Level level, Player player) {
		
		if(!stack.isEnchanted())		
		 {
			 stack.enchant(Enchantments.SWEEPING_EDGE, 4);
		 }
		
		super.onCraftedBy(stack, level, player);
	}

}
