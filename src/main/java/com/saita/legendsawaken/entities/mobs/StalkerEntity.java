package com.saita.legendsawaken.entities.mobs;

import com.saita.legendsawaken.init.SoundInit;
import com.saita.legendsawaken.util.HardmodeRequiemFunctions;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.RandomSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.npc.AbstractVillager;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;

public class StalkerEntity extends Monster {
	
	boolean detected;

	public StalkerEntity(EntityType<StalkerEntity> entityType, Level level) {
		super(entityType, level);
		
		this.xpReward = 20;
		this.setMaxUpStep(1.0F);

	}
	
	@Override
	protected void registerGoals() {
		
		super.registerGoals();
		this.goalSelector.addGoal(0, new FloatGoal(this));
		this.goalSelector.addGoal(7, new WaterAvoidingRandomStrollGoal(this, 1.0D));
		this.goalSelector.addGoal(8, new LookAtPlayerGoal(this, Player.class, 8.0F));
	    this.goalSelector.addGoal(8, new RandomLookAroundGoal(this));
	    this.addBehaviourGoals();
	}
	
	protected void addBehaviourGoals() {
	      this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 1.0D, false));
	      this.targetSelector.addGoal(2, new HurtByTargetGoal(this));
	      this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, Player.class, true));
	      this.targetSelector.addGoal(4, new NearestAttackableTargetGoal<>(this, AbstractVillager.class, false));
	      this.targetSelector.addGoal(5, new NearestAttackableTargetGoal<>(this, IronGolem.class, true));

	   }
	 
	 public static AttributeSupplier.Builder createAttributes() {
		 return Monster.createMonsterAttributes()
				 .add(Attributes.MAX_HEALTH, 70.0D)
	    		 .add(Attributes.MOVEMENT_SPEED, 0.30D)
	    		 .add(Attributes.ATTACK_DAMAGE, 11.0D)
	    		 .add(Attributes.KNOCKBACK_RESISTANCE, 0.5D) 
	    		 .add(Attributes.FOLLOW_RANGE, 100.0D);
	 }
	 
	 public static boolean canSpawn(EntityType<StalkerEntity> entityType, LevelAccessor level, MobSpawnType spawnType, BlockPos position, RandomSource random) {
	        return HardmodeRequiemFunctions.isHardmode((ServerLevel)level);
	 }
	 
	 @Override
	 public void onAddedToWorld() {
		 
		detected = false;
		
		super.onAddedToWorld();
	 }
	
	 public boolean doHurtTarget(Entity entity) {
	      boolean flag = super.doHurtTarget(entity);
	      if (flag && entity instanceof LivingEntity) {
	    	  ((LivingEntity)entity).addEffect(new MobEffectInstance(MobEffects.BLINDNESS, 200, 0));
	    	  this.playSound(SoundInit.ALTERNATE_ATTACK.get());
	    	  detected = true;
	      }

	      return flag;
	 } 
	 
	 @Override
	 public boolean hurt(DamageSource damageSource, float p_21017_) {
		 
		detected = true;
	
		return super.hurt(damageSource, p_21017_);
	 }
	 
	 
	 @Override
	 public void tick() {
		
		if(!detected && this.getTarget() != null) {
			this.addEffect(new MobEffectInstance(MobEffects.INVISIBILITY, 10, 0));
		}
		
		super.tick();
	}
	 
	 
	@Override
	protected SoundEvent getAmbientSound() {
		
		return SoundEvents.AMBIENT_CAVE.get();
	}
	 
	@Override
	protected SoundEvent getDeathSound() {
	
		return SoundEvents.AMBIENT_CAVE.get();
	}
	 
	@Override
	protected SoundEvent getHurtSound(DamageSource p_33034_) {
		 
		return SoundInit.ALTERNATE_HURT.get();
	}
	
	protected float getSoundVolume() {
	      return 4.0F;
	}

}
