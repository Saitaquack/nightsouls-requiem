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
import net.minecraft.entity.merchant.villager.AbstractVillagerEntity;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.passive.IronGolemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;

public class HellfireServantEntity extends MonsterEntity {

	public HellfireServantEntity(EntityType<? extends MonsterEntity> type, World worldIn) {
		super(type, worldIn);
	
	}
	
	public static AttributeModifierMap.MutableAttribute setCustomAttributes() {
		return MobEntity.func_233666_p_()
				.createMutableAttribute(Attributes.MAX_HEALTH, 160.0D)
				.createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.34D) 
				.createMutableAttribute(Attributes.ATTACK_DAMAGE, 20.0D) 
				.createMutableAttribute(Attributes.KNOCKBACK_RESISTANCE, 0.4D) 
				.createMutableAttribute(Attributes.FOLLOW_RANGE, 40.0D); 
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
	      this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, PlayerEntity.class, true));
	      this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, PaladinEntity.class, true));
	      this.targetSelector.addGoal(4, new NearestAttackableTargetGoal<>(this, AbstractVillagerEntity.class, false));
	      this.targetSelector.addGoal(5, new NearestAttackableTargetGoal<>(this, IronGolemEntity.class, true));
  
  
	  }
	 
	 @Override
	 protected int getExperiencePoints(PlayerEntity player)
	 {
		 return 45;
	 }
	 
	@Override
	protected SoundEvent getAmbientSound() {
		
		return SoundEvents.ENTITY_BLAZE_AMBIENT;
	}
	
	@Override
	protected SoundEvent getDeathSound() {
		
		return SoundInit.REQUIEM_DEATH.get();
	}
	
	@Override
	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		
		return SoundEvents.ENTITY_BLAZE_HURT;
	}
	
	@Override
	protected void playStepSound(BlockPos pos, BlockState blockIn) {
		
		this.playSound(SoundEvents.ENTITY_WITHER_SKELETON_STEP, 0.20F, 0.5F);
	 }
	
	
	// Immediatly dissapears if the world isn't Requiem. Has infinite fire resistance, and has buffs when on fire.
	 public void livingTick() {
	      if (this.isAlive()) {	  
	    	  
	    	this.addPotionEffect(new EffectInstance(Effects.FIRE_RESISTANCE, 20, 0, false, false));
	    	  
	    	if(world.getDayTime() < RequiemKey.requiemConstant)
	    	{
	    		 this.remove();
	    	}	    
	    	
	    	if(this.isBurning())
	    	{
	    		if(world.getGameTime() % 60 == 0)
	    		{
	            	this.addPotionEffect(new EffectInstance(Effects.REGENERATION, 100, 2));
	    		}
	    		
            	this.addPotionEffect(new EffectInstance(Effects.SPEED, 5, 1));
            	this.addPotionEffect(new EffectInstance(Effects.STRENGTH, 5, 1));
	    	}
	      
	      }

	      super.livingTick();
	   }
	
	//Takes damage in water
	@Override
	protected void updateAITasks() {
		if (this.isInWaterRainOrBubbleColumn()) {
		        this.attackEntityFrom(DamageSource.DROWN, 1.0F);
		}
	}
	
	
	//Makes Fire Demon Bright
	@Override
	public float getBrightness() {
			
		return 1.0F;
	}
	

	// Burns victim
	@Override
	public boolean attackEntityAsMob(Entity entityIn) {
		
	     if (!super.attackEntityAsMob(entityIn)) {
	         return false;
	         
	        } else {
	        	
	            if (entityIn instanceof LivingEntity) {
	                ((LivingEntity) entityIn).setFire(8);
	            }
	            return true;
	        }
	        
	  }
	
	// Only spawns on blocks.
	@Override
	public boolean canSpawn(IWorld worldIn, SpawnReason spawnReasonIn) {

		return 
		worldIn.getBlockState(new BlockPos(this.getPosX(), this.getPosY() - 1, this.getPosZ())) != Blocks.AIR.getDefaultState() || 
		worldIn.getBlockState(new BlockPos(this.getPosX(), this.getPosY() - 1, this.getPosZ())) != Blocks.CAVE_AIR.getDefaultState();
	}
		
}
