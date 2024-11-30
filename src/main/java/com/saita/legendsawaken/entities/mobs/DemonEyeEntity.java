package com.saita.legendsawaken.entities.mobs;

import com.saita.legendsawaken.init.SoundInit;
import com.saita.legendsawaken.util.HardmodeRequiemFunctions;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
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
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.Phantom;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LightLayer;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.dimension.DimensionType;

public class DemonEyeEntity extends Phantom {

	public DemonEyeEntity(EntityType<? extends Phantom> p_33101_, Level p_33102_) {
		super(p_33101_, p_33102_);
		
		this.xpReward = 12;
	
	}
	
	public static AttributeSupplier.Builder createAttributes() {
		 return Monster.createMonsterAttributes()
				 .add(Attributes.MAX_HEALTH, 45.0D)
	    		 .add(Attributes.ATTACK_DAMAGE, 10.0D)
	    		 .add(Attributes.FOLLOW_RANGE, 30.0D); 
	 }
	
	 public static boolean isDarkEnoughToSpawn(ServerLevelAccessor levelAccessor, BlockPos blockpos, RandomSource random) {
	      if (levelAccessor.getBrightness(LightLayer.SKY, blockpos) > random.nextInt(32)) {
	         return false;
	      } else {
	         DimensionType dimensiontype = levelAccessor.dimensionType();
	         int i = dimensiontype.monsterSpawnBlockLightLimit();
	         if (i < 15 && levelAccessor.getBrightness(LightLayer.BLOCK, blockpos) > i) {
	            return false;
	         } else {
	            int j = levelAccessor.getLevel().isThundering() ? levelAccessor.getMaxLocalRawBrightness(blockpos, 10) : levelAccessor.getMaxLocalRawBrightness(blockpos);
	            return j <= dimensiontype.monsterSpawnLightTest().sample(random);
	         }
	      }
	   }
	 
	 public static boolean canSpawn(EntityType<DemonEyeEntity> entityType, LevelAccessor level, MobSpawnType spawnType, BlockPos position, RandomSource random) {
	        return HardmodeRequiemFunctions.isHardmode((ServerLevel)level) && isDarkEnoughToSpawn(((ServerLevelAccessor)level), position, random);
	 }
	 
	 
	 @Override
	 protected SoundEvent getHurtSound(DamageSource p_33034_) {
		 
		return SoundInit.EYE_HURT.get();
	 }
	 
	 @Override
     protected SoundEvent getDeathSound() {
	
		return SoundInit.EYE_DEATH.get();
     }
	 

	 public boolean doHurtTarget(Entity entity) {
	      boolean flag = super.doHurtTarget(entity);
	      if (flag && entity instanceof LivingEntity) {
	    	  ((LivingEntity)entity).addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 160, 0));
	      }

	      return flag;
	 } 

}
