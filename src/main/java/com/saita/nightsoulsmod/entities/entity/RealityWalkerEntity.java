package com.saita.nightsoulsmod.entities.entity;

import java.util.Random;

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
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;

public class RealityWalkerEntity extends MonsterEntity {

	public RealityWalkerEntity(EntityType<? extends MonsterEntity> type, World worldIn) {
		super(type, worldIn);
	
	}
	
	public static AttributeModifierMap.MutableAttribute setCustomAttributes() {
		return MobEntity.func_233666_p_()
				.createMutableAttribute(Attributes.MAX_HEALTH, 150.0D)
				.createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.38D) 
				.createMutableAttribute(Attributes.ATTACK_DAMAGE, 20.0D) 
				.createMutableAttribute(Attributes.KNOCKBACK_RESISTANCE, 0.4D) 
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
	      this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, StargazerEntity.class, true));
	      this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, PlayerEntity.class, true));

  
	  }
	 
	 @Override
	 protected int getExperiencePoints(PlayerEntity player)
	 {
		 return 20;
	 }
	 
	@Override
	protected SoundEvent getAmbientSound() {
		
		return SoundInit.REALITY_WALKER_AMBIENT.get();
	}
	
	@Override
	protected SoundEvent getDeathSound() {
		
		return SoundInit.REQUIEM_DEATH.get();
	}
	
	@Override
	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		
		return SoundInit.REALITY_WALKER_HIT.get();
	}
	
	@Override
	protected void playStepSound(BlockPos pos, BlockState blockIn) {
		
		return;
	}
	
	// Inflicts random nasty effects
	@Override
	public boolean attackEntityAsMob(Entity entityIn) {
		
	     if (!super.attackEntityAsMob(entityIn)) {
	         return false;
	         
	        } else {
	        	
	            if (entityIn instanceof LivingEntity) {

	            	Random random = new Random();
	            	int randomEffect = random.nextInt(7);
	            	
	            	switch(randomEffect)
	        		{
	        		case 0:
	        			((LivingEntity) entityIn).addPotionEffect(new EffectInstance(Effects.SLOWNESS, 160, 0));
	        		break;
	        		case 1:
	        			((LivingEntity) entityIn).addPotionEffect(new EffectInstance(Effects.MINING_FATIGUE, 160, 0));
	        		break;
	        		case 2:
	        			((LivingEntity) entityIn).addPotionEffect(new EffectInstance(Effects.WEAKNESS, 160, 0));
	        		break;
	        		case 3:
	        			((LivingEntity) entityIn).addPotionEffect(new EffectInstance(Effects.BLINDNESS, 160, 0));
	        		break;
	        		case 4:
	        			((LivingEntity) entityIn).addPotionEffect(new EffectInstance(Effects.HUNGER, 160, 0));
	        		break;
	        		case 5:
	        			((LivingEntity) entityIn).addPotionEffect(new EffectInstance(Effects.POISON, 160, 0));
	        		break;
	        		case 6:
	        			((LivingEntity) entityIn).addPotionEffect(new EffectInstance(Effects.WITHER, 160, 0));
	        		break;
	        		}
	            	
	            }
	            return true;
	        }
	        
	  }
	
	@Override
	public boolean canSpawn(IWorld worldIn, SpawnReason spawnReasonIn) {

		return this.getStateBelow() != Blocks.AIR.getDefaultState() && 
			   this.getStateBelow() != Blocks.CAVE_AIR.getDefaultState() && 
			   this.getStateBelow() != Blocks.WATER.getDefaultState() && 
			   worldIn.getLight(this.getPosition()) <= 7 && 
			   ((World) worldIn).getDayTime() >= RequiemKey.requiemConstant &&
			   (world.getDimensionKey().getLocation().getPath() == "overworld" || world.getDimensionKey().getLocation().getPath() == "the_nether" || world.getDimensionKey().getLocation().getPath() == "the_end");

	}
		
}
