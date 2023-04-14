package com.saita.nightsoulsmod.entities.entity;

import com.saita.nightsoulsmod.init.SoundInit;
import com.saita.nightsoulsmod.obj.items.RequiemKey;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityType;
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
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;

public class TitanEntity extends MonsterEntity {

	public TitanEntity(EntityType<? extends MonsterEntity> type, World worldIn) {
		super(type, worldIn);
		
		this.stepHeight = 5.0F;
	
	}
	
	public static AttributeModifierMap.MutableAttribute setCustomAttributes() {
		return MobEntity.func_233666_p_()
				.createMutableAttribute(Attributes.MAX_HEALTH, 380.0D)
				.createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.28D) 
				.createMutableAttribute(Attributes.ATTACK_DAMAGE, 23.0D) 
				.createMutableAttribute(Attributes.KNOCKBACK_RESISTANCE, 0.5D) 
				.createMutableAttribute(Attributes.FOLLOW_RANGE, 45.0D)
				.createMutableAttribute(Attributes.ATTACK_KNOCKBACK, 4.0D); 
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
	      this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, AbstractVillagerEntity.class, false));
	      this.targetSelector.addGoal(4, new NearestAttackableTargetGoal<>(this, IronGolemEntity.class, true));
  
  
	  }
	 
	 @Override
	 protected int getExperiencePoints(PlayerEntity player)
	 {
		 return 100;
	 }
	 
	@Override
	protected SoundEvent getAmbientSound() {
		
		return SoundInit.TITAN_AMBIENT.get();
	}
	
	@Override
	protected SoundEvent getDeathSound() {
		
		return SoundInit.TITAN_DEATH.get();
	}
	
	@Override
	protected void playStepSound(BlockPos pos, BlockState blockIn) {
		
		this.playSound(SoundInit.TITAN_STEP.get(), 0.50F, 1.0F);
	}
	
	//Negates fall damage
	@Override
	protected int calculateFallDamage(float p_225508_1_, float p_225508_2_) {
				
		return 0;
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
