package com.saita.legendsawaken.entities.projectiles;

import com.saita.legendsawaken.init.EntityInit;
import com.saita.legendsawaken.init.ItemInit;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class TitaniteArrowProjectileEntity extends AbstractArrow {
	
	private final Item referenceItem;

	public TitaniteArrowProjectileEntity(EntityType<? extends AbstractArrow> type, Level level) {
		super(type, level);
		this.referenceItem = ItemInit.TITANITE_ARROW.get();

	}

	public TitaniteArrowProjectileEntity(LivingEntity shooter, Level level, Item referenceItem) {
		super(EntityInit.TITANITE_ARROW.get(), shooter, level);
		this.referenceItem = ItemInit.TITANITE_ARROW.get();

	}

	@Override
	public ItemStack getPickupItem() {
		
		return new ItemStack(this.referenceItem);
	}


}
