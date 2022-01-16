package com.saita.nightsoulsmod.entities.entity;

import com.saita.nightsoulsmod.init.SoundInit;

import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
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
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class FaceMonsterEntity extends MonsterEntity {

	public FaceMonsterEntity(EntityType<? extends MonsterEntity> type, World worldIn) {
		super(type, worldIn);
	
	}
	
	public static AttributeModifierMap.MutableAttribute setCustomAttributes() {
		return MobEntity.func_233666_p_()
				.createMutableAttribute(Attributes.MAX_HEALTH, 40.0D)
				.createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.36D) 
				.createMutableAttribute(Attributes.ATTACK_DAMAGE, 10.0D) 
				.createMutableAttribute(Attributes.KNOCKBACK_RESISTANCE, 0.0D) 
				.createMutableAttribute(Attributes.FOLLOW_RANGE, 35.0D); 
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
		  
	      this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, PlayerEntity.class, true));
	      this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, AbstractVillagerEntity.class, false));
	      this.targetSelector.addGoal(4, new NearestAttackableTargetGoal<>(this, IronGolemEntity.class, true));
  
	   }
	 
	 @Override
	 protected int getExperiencePoints(PlayerEntity player)
	 {
		 return 8;
	 }
	 
	@Override
	protected SoundEvent getAmbientSound() {
		
		return SoundInit.FACE_MONSTER_AMBIENT.get();
	}
	
	@Override
	protected SoundEvent getDeathSound() {
		
		return SoundInit.FACE_MONSTER_DEATH.get();
	}
	
	@Override
	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		
		return SoundInit.FACE_MONSTER_HIT.get();
	}
	
	@Override
	protected void playStepSound(BlockPos pos, BlockState blockIn) {
		
		this.playSound(SoundEvents.ENTITY_ZOMBIE_STEP, 0.20F, 0.5F);
	}
	
	@Override
	public boolean isEntityUndead() {
		
		return true;
	}
	
	protected boolean shouldBurnInDay() {
	      return true;
	 }
	
	 
	 public void livingTick() {
	      if (this.isAlive()) {
	         boolean flag = this.shouldBurnInDay() && this.isInDaylight();
	         if (flag) {
	            ItemStack itemstack = this.getItemStackFromSlot(EquipmentSlotType.HEAD);
	            if (!itemstack.isEmpty()) {
	               if (itemstack.isDamageable()) {
	                  itemstack.setDamage(itemstack.getDamage() + this.rand.nextInt(2));
	                  if (itemstack.getDamage() >= itemstack.getMaxDamage()) {
	                     this.sendBreakAnimation(EquipmentSlotType.HEAD);
	                     this.setItemStackToSlot(EquipmentSlotType.HEAD, ItemStack.EMPTY);
	                  }
	               }

	               flag = false;
	            }

	            if (flag) {
	               this.setFire(8);
	            }
	         }
	      }

	      super.livingTick();
	   }
	

	// Inflicts weakness on attack
	@Override
	public boolean attackEntityAsMob(Entity entityIn) {
		
	     if (!super.attackEntityAsMob(entityIn)) {
	         return false;
	         
	        } else {
	        	
	            if (entityIn instanceof LivingEntity) {
	                ((LivingEntity) entityIn).addPotionEffect(new EffectInstance(Effects.WEAKNESS, 200, 0));
	            }
	            return true;
	        }
	        
	  }
		
}
