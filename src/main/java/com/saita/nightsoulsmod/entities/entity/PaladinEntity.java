package com.saita.nightsoulsmod.entities.entity;

import com.saita.nightsoulsmod.init.SoundInit;
import com.saita.nightsoulsmod.obj.items.RequiemKey;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.HurtByTargetGoal;
import net.minecraft.entity.ai.goal.LookAtGoal;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.ai.goal.WaterAvoidingRandomWalkingGoal;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;

public class PaladinEntity extends MonsterEntity {

	public PaladinEntity(EntityType<? extends MonsterEntity> type, World worldIn) {
		super(type, worldIn);
	
	}
	
	public static AttributeModifierMap.MutableAttribute setCustomAttributes() {
		return MobEntity.func_233666_p_()
				.createMutableAttribute(Attributes.MAX_HEALTH, 180.0D)
				.createMutableAttribute(Attributes.ARMOR, 4.0D)
				.createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.28D) 
				.createMutableAttribute(Attributes.ATTACK_DAMAGE, 18.0D) 
				.createMutableAttribute(Attributes.KNOCKBACK_RESISTANCE, 0.6D) 
				.createMutableAttribute(Attributes.FOLLOW_RANGE, 30.0D); 
	}
	
	@Override
	protected void registerGoals() {
		 super.registerGoals();   
		 this.goalSelector.addGoal(1, new SwimGoal(this));
		 this.goalSelector.addGoal(2, new WaterAvoidingRandomWalkingGoal(this, 1.0D));
		 this.goalSelector.addGoal(0, new MeleeAttackGoal(this, 1.2D, true));
		 this.goalSelector.addGoal(3, new LookAtGoal(this, PlayerEntity.class, 8.0F));
	     this.goalSelector.addGoal(4, new LookRandomlyGoal(this));
	     this.goalSelector.addGoal(5, new LookAtGoal(this, MobEntity.class, 15.0F));
	     
	     this.applyEntityAI();

		
	}
	
	protected void applyEntityAI() {
		  
		  this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
		  this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, AkazaEntity.class, true));
	      this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, HellfireServantEntity.class, true));
	      
	      
	      this.targetSelector.addGoal(4, new NearestAttackableTargetGoal<>(this, AlternateEntity.class, true));
	      this.targetSelector.addGoal(5, new NearestAttackableTargetGoal<>(this, WerewolfEntity.class, true));
	      this.targetSelector.addGoal(5, new NearestAttackableTargetGoal<>(this, ReaperEntity.class, true));
	      this.targetSelector.addGoal(5, new NearestAttackableTargetGoal<>(this, PsychoEntity.class, true));
	      this.targetSelector.addGoal(5, new NearestAttackableTargetGoal<>(this, HellbornEntity.class, true));
	      this.targetSelector.addGoal(5, new NearestAttackableTargetGoal<>(this, FaceMonsterEntity.class, true));
  
	  }
	 
	 @Override
	 protected int getExperiencePoints(PlayerEntity player)
	 {
		 return 45;
	 }
	 
	@Override
	protected SoundEvent getAmbientSound() {
		
		return SoundInit.PALADIN_AMBIENT.get();
	}
	
	@Override
	protected SoundEvent getDeathSound() {
		
		return SoundInit.REQUIEM_DEATH.get();
	}
	
	@Override
	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		
		return SoundInit.PALADIN_HIT.get();
	}
	
	@Override
	protected void playStepSound(BlockPos pos, BlockState blockIn) {
		
		this.playSound(SoundEvents.ENTITY_IRON_GOLEM_STEP, 0.20F, 0.5F);
	 }
	
	// Paladin gets regeneration on attack
	@Override
	public boolean attackEntityAsMob(Entity entityIn) {
		
	     if (!super.attackEntityAsMob(entityIn)) {
	         return false;
	         
	        } else {
	        	
	            if (entityIn instanceof LivingEntity) {

	            	this.addPotionEffect(new EffectInstance(Effects.REGENERATION, 80, 1));
	            	this.addPotionEffect(new EffectInstance(Effects.GLOWING, 80, 1));
	            	
	            }
	            return true;
	        }
	        
	  }
	
	@Override
	public boolean canSpawn(IWorld worldIn, SpawnReason spawnReasonIn) {

		return this.getStateBelow() != Blocks.AIR.getDefaultState() && this.getStateBelow() != Blocks.CAVE_AIR.getDefaultState() && this.getStateBelow() != Blocks.WATER.getDefaultState() && worldIn.getLight(this.getPosition()) <= 7 && ((World) worldIn).getDayTime() >= RequiemKey.requiemConstant;
	}
		
}
