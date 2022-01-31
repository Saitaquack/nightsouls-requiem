package com.saita.nightsoulsmod.entities.entity;

import com.saita.nightsoulsmod.init.SoundInit;

import net.minecraft.block.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.monster.PhantomEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;

public class DemonEyeEntity extends PhantomEntity {		
	
	public DemonEyeEntity(EntityType<? extends PhantomEntity> type, World worldIn) {
		super(type, worldIn);

	}
	
	public static AttributeModifierMap.MutableAttribute setCustomAttributes() {
		return MobEntity.func_233666_p_()
				.createMutableAttribute(Attributes.MAX_HEALTH, 35.0D)
				.createMutableAttribute(Attributes.ATTACK_DAMAGE, 7.0D) 
				.createMutableAttribute(Attributes.KNOCKBACK_RESISTANCE, 0.5D) 
				.createMutableAttribute(Attributes.FOLLOW_RANGE, 35.0D); 
	}
	 
	 @Override
	 protected int getExperiencePoints(PlayerEntity player)
	 {
		 return 10;
	 }
	 
	@Override
	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
			
		return SoundInit.EYE_HIT.get();
	}
	
	@Override
	protected SoundEvent getDeathSound() {
		
		return SoundInit.EYE_DEATH.get();
	}
	
	 //Burns at Day
	
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
	


	// Inflicts slowness on attack
	@Override
	public boolean attackEntityAsMob(Entity entityIn) {
		
	     if (!super.attackEntityAsMob(entityIn)) {
	         return false;
	         
	        } else {
	        	
	            if (entityIn instanceof LivingEntity) {
	                ((LivingEntity) entityIn).addPotionEffect(new EffectInstance(Effects.SLOWNESS, 160, 0));
	            }
	            return true;
	        }
	        
	  }
	
	// Only spawns on blocks and with a light level below or equals to 7. Also doesn't spawn in water.
	@Override
	public boolean canSpawn(IWorld worldIn, SpawnReason spawnReasonIn) {

		return 
		(worldIn.getBlockState(new BlockPos(this.getPosX(), this.getPosY() - 1, this.getPosZ())) != Blocks.AIR.getDefaultState() || 
		worldIn.getBlockState(new BlockPos(this.getPosX(), this.getPosY() - 1, this.getPosZ())) != Blocks.CAVE_AIR.getDefaultState()) &&
		
		(worldIn.getBlockState(new BlockPos(this.getPosX(), this.getPosY(), this.getPosZ())) != Blocks.WATER.getDefaultState() || 
		worldIn.getBlockState(new BlockPos(this.getPosX(), this.getPosY() - 1, this.getPosZ())) != Blocks.WATER.getDefaultState()) &&
		
		worldIn.getLight(this.getPosition()) <= 7;
	}
		
}
