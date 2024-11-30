package com.saita.legendsawaken.entities.projectiles;

import com.saita.legendsawaken.init.EntityInit;
import com.saita.legendsawaken.init.ItemInit;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class MythrilArrowProjectileEntity extends AbstractArrow {
	
	private final Item referenceItem;

	public MythrilArrowProjectileEntity(EntityType<? extends AbstractArrow> type, Level level) {
		super(type, level);
		this.referenceItem = ItemInit.MYTHRIL_ARROW.get();

	}

	public MythrilArrowProjectileEntity(LivingEntity shooter, Level level, Item referenceItem) {
		super(EntityInit.MYTHRIL_ARROW.get(), shooter, level);
		this.referenceItem = ItemInit.MYTHRIL_ARROW.get();

	}

	@Override
	public ItemStack getPickupItem() {
		
		return new ItemStack(this.referenceItem);
	}


}
