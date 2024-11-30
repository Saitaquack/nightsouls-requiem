package com.saita.legendsawaken.obj.items;

import com.saita.legendsawaken.entities.projectiles.TitaniteArrowProjectileEntity;
import com.saita.legendsawaken.init.ItemInit;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ArrowItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class TitaniteArrow extends ArrowItem {

	public TitaniteArrow(Properties properties) {
		super(properties);
	
	}
	
	@Override
	public AbstractArrow createArrow(Level level, ItemStack stack, LivingEntity shooter) {
	      TitaniteArrowProjectileEntity arrow = new TitaniteArrowProjectileEntity(shooter, level, ItemInit.TITANITE_ARROW.get());
	      arrow.setBaseDamage(9.0D);
	      return arrow;
	}
	
	@Override
	public boolean isInfinite(ItemStack stack, ItemStack bow, Player player) {
	    return false;
	  }

}
