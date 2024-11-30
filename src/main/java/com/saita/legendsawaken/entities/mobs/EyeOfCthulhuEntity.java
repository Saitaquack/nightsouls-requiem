package com.saita.legendsawaken.entities.mobs;

import java.util.EnumSet;

import javax.annotation.Nullable;

import com.saita.legendsawaken.init.SoundInit;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerBossEvent;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.Mth;
import net.minecraft.world.BossEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MoverType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.MoveControl;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

public class EyeOfCthulhuEntity extends Monster {
   public static final float FLAP_DEGREES_PER_TICK = 45.836624F;
   public static final int TICKS_PER_FLAP = Mth.ceil(3.9269907F);
   protected static final EntityDataAccessor<Byte> DATA_FLAGS_ID = SynchedEntityData.defineId(EyeOfCthulhuEntity.class, EntityDataSerializers.BYTE);
   @Nullable
   private BlockPos boundOrigin;
   private final ServerBossEvent bossEvent = (ServerBossEvent)(new ServerBossEvent(this.getDisplayName(), BossEvent.BossBarColor.RED, BossEvent.BossBarOverlay.PROGRESS));

   public EyeOfCthulhuEntity(EntityType<? extends EyeOfCthulhuEntity> p_33984_, Level p_33985_) {
      super(p_33984_, p_33985_);
      this.moveControl = new EyeOfCthulhuEntity.EyeMoveControl(this);
      
      this.xpReward = 500;
   }
   
   protected void registerGoals() {
	      super.registerGoals();
	      this.goalSelector.addGoal(0, new FloatGoal(this));
	      this.goalSelector.addGoal(4, new EyeOfCthulhuEntity.EyeOfCthulhuEntityChargeAttackGoal());
	      this.goalSelector.addGoal(8, new EyeOfCthulhuEntity.EyeOfCthulhuEntityRandomMoveGoal());
	      this.goalSelector.addGoal(9, new LookAtPlayerGoal(this, Player.class, 3.0F, 1.0F));
	      this.goalSelector.addGoal(10, new LookAtPlayerGoal(this, Mob.class, 8.0F));
	      this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, Player.class, true));
	   }

   public static AttributeSupplier.Builder createAttributes() {
      return Monster.createMonsterAttributes()
    		  .add(Attributes.MAX_HEALTH, 600.0D)	  
    		  .add(Attributes.ATTACK_DAMAGE, 20.0D)
    		  .add(Attributes.KNOCKBACK_RESISTANCE, 1.0D) 
    		  .add(Attributes.FOLLOW_RANGE, 60.0D);	    			    		  
   }
   
   @Override
   protected SoundEvent getAmbientSound() {
		
	   return SoundInit.CTHULHU_SCREAM.get();
   }
	 
   @Override
   protected SoundEvent getDeathSound() {
	
	  return SoundInit.EYE_DEATH.get();
   }
	 
   @Override
   protected SoundEvent getHurtSound(DamageSource p_33034_) {
		 
	  return SoundInit.EYE_HURT.get();
   }
   
   @Override
   public void playerTouch(Player player) {
		
	   player.hurt(EyeOfCthulhuEntity.this.level().damageSources().mobAttack(this), 12.0F);
	   
	   super.playerTouch(player);
   }
   
   public void setCustomName(@Nullable Component p_31476_) {
	       super.setCustomName(p_31476_);
	       this.bossEvent.setName(this.getDisplayName());
   }
   
   public void startSeenByPlayer(ServerPlayer player) {
	      super.startSeenByPlayer(player);
	      this.bossEvent.addPlayer(player);
   }

   public void stopSeenByPlayer(ServerPlayer player) {
	      super.stopSeenByPlayer(player);
	      this.bossEvent.removePlayer(player);
   }
	   
   	@Override
	protected void customServerAiStep() {
   		
   		this.bossEvent.setProgress(this.getHealth() / this.getMaxHealth());
   		
		super.customServerAiStep();
   	}
   	
   	protected float getSoundVolume() {
	      return 3.0F;
	}
	  
	   
	   // #Vex Code
	   
	   public boolean isFlapping() {
	      return this.tickCount % TICKS_PER_FLAP == 0;
	   }

	   public void move(MoverType p_33997_, Vec3 p_33998_) {
	      super.move(p_33997_, p_33998_);
	      this.checkInsideBlocks();
	   }

	   public void tick() {
	      this.noPhysics = true;
	      super.tick();
	      this.noPhysics = false;
	      this.setNoGravity(true);
	   }
		
	   protected void defineSynchedData() {
	      super.defineSynchedData();
	      this.entityData.define(DATA_FLAGS_ID, (byte)0);
	   }

	   public void readAdditionalSaveData(CompoundTag p_34008_) {
	      super.readAdditionalSaveData(p_34008_);
	      if (p_34008_.contains("BoundX")) {
	         this.boundOrigin = new BlockPos(p_34008_.getInt("BoundX"), p_34008_.getInt("BoundY"), p_34008_.getInt("BoundZ"));
	      }

	   }

	   public void addAdditionalSaveData(CompoundTag p_34015_) {
	      super.addAdditionalSaveData(p_34015_);
	      if (this.boundOrigin != null) {
	         p_34015_.putInt("BoundX", this.boundOrigin.getX());
	         p_34015_.putInt("BoundY", this.boundOrigin.getY());
	         p_34015_.putInt("BoundZ", this.boundOrigin.getZ());
	      }

	   }

	   @Nullable
	   public BlockPos getBoundOrigin() {
	      return this.boundOrigin;
	   }

	   public void setBoundOrigin(@Nullable BlockPos p_34034_) {
	      this.boundOrigin = p_34034_;
	   }

	   private boolean getEyeOfCthulhuEntityFlag(int p_34011_) {
	      int i = this.entityData.get(DATA_FLAGS_ID);
	      return (i & p_34011_) != 0;
	   }

	   private void setEyeOfCthulhuEntityFlag(int p_33990_, boolean p_33991_) {
	      int i = this.entityData.get(DATA_FLAGS_ID);
	      if (p_33991_) {
	         i |= p_33990_;
	      } else {
	         i &= ~p_33990_;
	      }

	      this.entityData.set(DATA_FLAGS_ID, (byte)(i & 255));
	   }

	   public boolean isCharging() {
	      return this.getEyeOfCthulhuEntityFlag(1);
	   }

	   public void setIsCharging(boolean p_34043_) {
	      this.setEyeOfCthulhuEntityFlag(1, p_34043_);
	   }
	  

	   class EyeOfCthulhuEntityChargeAttackGoal extends Goal {
	      public EyeOfCthulhuEntityChargeAttackGoal() {
	         this.setFlags(EnumSet.of(Goal.Flag.MOVE));
	      }

	      public boolean canUse() {
	         LivingEntity livingentity = EyeOfCthulhuEntity.this.getTarget();
	         if (livingentity != null && livingentity.isAlive() && !EyeOfCthulhuEntity.this.getMoveControl().hasWanted() && EyeOfCthulhuEntity.this.random.nextInt(reducedTickDelay(7)) == 0) {
	            return EyeOfCthulhuEntity.this.distanceToSqr(livingentity) > 4.0D;
	         } else {
	            return false;
	         }
	      }

	      public boolean canContinueToUse() {
	         return EyeOfCthulhuEntity.this.getMoveControl().hasWanted() && EyeOfCthulhuEntity.this.isCharging() && EyeOfCthulhuEntity.this.getTarget() != null && EyeOfCthulhuEntity.this.getTarget().isAlive();
	      }

	      public void start() {
	         LivingEntity livingentity = EyeOfCthulhuEntity.this.getTarget();
	         if (livingentity != null) {
	            Vec3 vec3 = livingentity.getEyePosition();
	            EyeOfCthulhuEntity.this.moveControl.setWantedPosition(vec3.x, vec3.y, vec3.z, 1.0D);
	         }

	         EyeOfCthulhuEntity.this.setIsCharging(true);
	         EyeOfCthulhuEntity.this.playSound(SoundInit.CTHULHU_SCREAM.get(), 1.0F, 1.0F);
	      }

	      public void stop() {
	         EyeOfCthulhuEntity.this.setIsCharging(false);
	      }

	      public boolean requiresUpdateEveryTick() {
	         return true;
	      }

	      public void tick() {
	         LivingEntity livingentity = EyeOfCthulhuEntity.this.getTarget();
	         if (livingentity != null) {
	            if (EyeOfCthulhuEntity.this.getBoundingBox().intersects(livingentity.getBoundingBox())) {
	               EyeOfCthulhuEntity.this.doHurtTarget(livingentity);
	               EyeOfCthulhuEntity.this.setIsCharging(false);
	            } else {
	               double d0 = EyeOfCthulhuEntity.this.distanceToSqr(livingentity);
	               if (d0 < 9.0D) {
	                  Vec3 vec3 = livingentity.getEyePosition();
	                  EyeOfCthulhuEntity.this.moveControl.setWantedPosition(vec3.x, vec3.y, vec3.z, 1.0D);
	               }
	            }

	         }
	      }
	   }

	   class EyeMoveControl extends MoveControl {
	      public EyeMoveControl(EyeOfCthulhuEntity p_34062_) {
	         super(p_34062_);
	      }

	      public void tick() {
	         if (this.operation == MoveControl.Operation.MOVE_TO) {
	            Vec3 vec3 = new Vec3(this.wantedX - EyeOfCthulhuEntity.this.getX(), this.wantedY - EyeOfCthulhuEntity.this.getY(), this.wantedZ - EyeOfCthulhuEntity.this.getZ());
	            double d0 = vec3.length();
	            if (d0 < EyeOfCthulhuEntity.this.getBoundingBox().getSize()) {
	               this.operation = MoveControl.Operation.WAIT;
	               EyeOfCthulhuEntity.this.setDeltaMovement(EyeOfCthulhuEntity.this.getDeltaMovement().scale(0.5D));
	            } else {
	               if(EyeOfCthulhuEntity.this.getHealth() > EyeOfCthulhuEntity.this.getMaxHealth() / 2) {
	            	   EyeOfCthulhuEntity.this.setDeltaMovement(EyeOfCthulhuEntity.this.getDeltaMovement().add(vec3.scale(this.speedModifier * 0.15D / d0))); // 0.05 de base, 3x plus rapide
	               } else {
	            	   EyeOfCthulhuEntity.this.setDeltaMovement(EyeOfCthulhuEntity.this.getDeltaMovement().add(vec3.scale(this.speedModifier * 0.2D / d0))); // 0.05 de base, 4x plus rapide
	               }
	               
	               if (EyeOfCthulhuEntity.this.getTarget() == null) {
	                  Vec3 vec31 = EyeOfCthulhuEntity.this.getDeltaMovement();
	                  EyeOfCthulhuEntity.this.setYRot(-((float)Mth.atan2(vec31.x, vec31.z)) * (180F / (float)Math.PI));
	                  EyeOfCthulhuEntity.this.yBodyRot = EyeOfCthulhuEntity.this.getYRot();
	               } else {
	                  double d2 = EyeOfCthulhuEntity.this.getTarget().getX() - EyeOfCthulhuEntity.this.getX();
	                  double d1 = EyeOfCthulhuEntity.this.getTarget().getZ() - EyeOfCthulhuEntity.this.getZ();
	                  EyeOfCthulhuEntity.this.setYRot(-((float)Mth.atan2(d2, d1)) * (180F / (float)Math.PI));
	                  EyeOfCthulhuEntity.this.yBodyRot = EyeOfCthulhuEntity.this.getYRot();
	               }
	            }

	         }
	      }
	   }

	   class EyeOfCthulhuEntityRandomMoveGoal extends Goal {
	      public EyeOfCthulhuEntityRandomMoveGoal() {
	         this.setFlags(EnumSet.of(Goal.Flag.MOVE));
	      }

	      public boolean canUse() {
	         return !EyeOfCthulhuEntity.this.getMoveControl().hasWanted() && EyeOfCthulhuEntity.this.random.nextInt(reducedTickDelay(2)) == 0; // 7 de base, passé à 2
	      }

	      public boolean canContinueToUse() {
	         return false;
	      }

	      public void tick() {
	         BlockPos blockpos = EyeOfCthulhuEntity.this.getBoundOrigin();
	         if (blockpos == null) {
	            blockpos = EyeOfCthulhuEntity.this.blockPosition();
	         }

	         for(int i = 0; i < 3; ++i) {
	            BlockPos blockpos1 = blockpos.offset(EyeOfCthulhuEntity.this.random.nextInt(15) - 7, EyeOfCthulhuEntity.this.random.nextInt(11) - 5, EyeOfCthulhuEntity.this.random.nextInt(15) - 7);
	            if (EyeOfCthulhuEntity.this.level().isEmptyBlock(blockpos1)) {
	               EyeOfCthulhuEntity.this.moveControl.setWantedPosition((double)blockpos1.getX() + 0.5D, (double)blockpos1.getY() + 0.5D, (double)blockpos1.getZ() + 0.5D, 0.25D);
	               if (EyeOfCthulhuEntity.this.getTarget() == null) {
	                  EyeOfCthulhuEntity.this.getLookControl().setLookAt((double)blockpos1.getX() + 0.5D, (double)blockpos1.getY() + 0.5D, (double)blockpos1.getZ() + 0.5D, 180.0F, 20.0F);
	               }
	               break;
	            }
	         }

	      }
	   }
	
	}