package com.saita.legendsawaken.entities.projectiles;

import java.util.Random;

import com.saita.legendsawaken.init.EntityInit;
import com.saita.legendsawaken.init.ItemInit;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;

public class HellfireBulletProjectileEntity extends ThrowableItemProjectile {
	
	private final LivingEntity shooter;
	int timeLiving = 0;

	public HellfireBulletProjectileEntity(EntityType<? extends ThrowableItemProjectile> p_37442_, Level p_37443_) {
		super(p_37442_, p_37443_);
		this.shooter = null;
	}
	
	 public HellfireBulletProjectileEntity(Level level, LivingEntity entity) {
	     super(EntityInit.HELLFIRE_BULLET_PROJECTILE.get(), entity, level);
	     this.shooter = entity;
	 }

	@Override
	protected Item getDefaultItem() {
	
		return ItemInit.HELLFIRE_BULLETS.get();
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
		int randomHeal = rand.nextInt(7);
		
		float baseDamage = 32.0F;
		float minimumDamage = 10.0F;
		float finalDamage = baseDamage - ((float)timeLiving * 2);
			
		if(finalDamage < minimumDamage) {
			finalDamage = minimumDamage;
		}
		
		Entity target = result.getEntity();	
		target.hurt(this.damageSources().thrown(this, this.getOwner()), finalDamage);
		
		if(this.shooter != null && this.shooter instanceof Player && randomHeal == 0) {
			this.shooter.heal(1.0F);
		}
		
	
		super.onHitEntity(result);
	}
	
	@Override
	public void tick() {
		
		timeLiving++;
		super.tick();
	}

}
