package com.saita.legendsawaken.entities.projectiles;

import java.util.Random;

import com.saita.legendsawaken.init.EntityInit;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;

public class AmethystProjectileEntity extends ThrowableItemProjectile {

	public AmethystProjectileEntity(EntityType<? extends ThrowableItemProjectile> p_37442_, Level p_37443_) {
		super(p_37442_, p_37443_);
	}
	
	 public AmethystProjectileEntity(Level level, LivingEntity entity) {
	      super(EntityInit.AMETHYST_PROJECTILE.get(), entity, level);
	 }

	@Override
	protected Item getDefaultItem() {
	
		return Items.AMETHYST_CLUSTER;
	}
	
	@SuppressWarnings("resource")
	@Override
	public void onHit(HitResult result) {	
		
		if(!this.level().isClientSide) {
	         this.discard();
	     }
		
		super.onHit(result);
	}
	
	@Override
	public void onHitEntity(EntityHitResult result) {
		
		Random rand = new Random();
		
		Entity target = result.getEntity();	
		target.hurt(this.damageSources().thrown(this, this.getOwner()), 18.0F);
		
		this.playSound(SoundEvents.LARGE_AMETHYST_BUD_BREAK, 1.0F, rand.nextFloat() + 0.5F);
	
		super.onHitEntity(result);
	}
	
	@Override
	public void onHitBlock(BlockHitResult p_37258_) {
		
		Random rand = new Random();
		
		this.playSound(SoundEvents.GLASS_BREAK, 1.0F, rand.nextFloat() + 0.5F);
		
		ItemEntity amethyst = EntityType.ITEM.create(this.level());
		amethyst.setItem(new ItemStack(Items.AMETHYST_SHARD));
		amethyst.moveTo(this.getX(), this.getY(), this.getZ(), this.getYRot(), 0.0F);
		this.level().addFreshEntity(amethyst);

		super.onHitBlock(p_37258_);
	}

}
