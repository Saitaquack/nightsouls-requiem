package com.saita.nightsoulsmod.entities.entity;

import java.util.EnumSet;

import javax.annotation.Nullable;

import com.saita.nightsoulsmod.init.SoundInit;

import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityPredicate;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.MoverType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.controller.MovementController;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.ai.goal.LookAtGoal;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.ai.goal.TargetGoal;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.BossInfo;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.IServerWorld;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerBossInfo;

public class EyeOfCthulhuEntity extends MonsterEntity{
	
	 protected static final DataParameter<Byte> EOC_FLAGS = EntityDataManager.createKey(EyeOfCthulhuEntity.class, DataSerializers.BYTE);
	 @Nullable
	 private BlockPos boundOrigin;

	public EyeOfCthulhuEntity(EntityType<? extends MonsterEntity> type, World worldIn) {
		super(type, worldIn);
	     this.moveController = new EyeOfCthulhuEntity.MoveHelperController(this);

	}
	
 	private final ServerBossInfo bossInfo = (ServerBossInfo)(new ServerBossInfo(this.getDisplayName(), BossInfo.Color.RED, BossInfo.Overlay.PROGRESS));

	
	public static AttributeModifierMap.MutableAttribute setCustomAttributes() {
        return MobEntity.func_233666_p_()
                .createMutableAttribute(Attributes.MAX_HEALTH, 600.0D)
                .createMutableAttribute(Attributes.ATTACK_DAMAGE, 16.0D) 
                .createMutableAttribute(Attributes.KNOCKBACK_RESISTANCE, 1.0D) 
                .createMutableAttribute(Attributes.FOLLOW_RANGE, 60.0D);
    }


    @Override
    protected int getExperiencePoints(PlayerEntity player)
    {
        return 500;
    }

    @Override
    protected SoundEvent getAmbientSound() {

        return SoundInit.CTHULHU_SCREAM.get();
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {

        return SoundInit.EYE_HIT.get();
    }

    @Override
    protected SoundEvent getDeathSound() {

        return SoundInit.EYE_DEATH.get();
    }


    // Inflicts slowness on attack
    @Override
    public boolean attackEntityAsMob(Entity entityIn) {

         if (!super.attackEntityAsMob(entityIn)) {
             return false;

            } else {

                if (entityIn instanceof LivingEntity) {
                    ((LivingEntity) entityIn).addPotionEffect(new EffectInstance(Effects.SLOWNESS, 200, 1));
                }
                return true;
            }

     }
    
    //Can't despawn	
  	@Override
  	public boolean canDespawn(double distanceToClosestPlayer) {
  		
  	return false;
  	}
      
  	
  	//Boss Info Update
  	protected void updateAITasks() {
      	super.updateAITasks();
      	this.bossInfo.setPercent(this.getHealth() / this.getMaxHealth());
      }
  	
  	//Boss Bar Name
  	public void setCustomName(ITextComponent name) {
  	      super.setCustomName(name);
  	      this.bossInfo.setName(this.getDisplayName());
  	}
  	
  	//Boss Bar Display
  	@Override
  	public void addTrackingPlayer(ServerPlayerEntity player) {
  	      super.addTrackingPlayer(player);
  	      this.bossInfo.addPlayer(player);
  	 }
  	
  	public void removeTrackingPlayer(ServerPlayerEntity player) {
  	      super.removeTrackingPlayer(player);
  	      this.bossInfo.removePlayer(player);
  	 } 
	
    
    
    // Vex Code
	
	 public void move(MoverType typeIn, Vector3d pos) {
	      super.move(typeIn, pos);
	      this.doBlockCollisions();
	   }

	   /**
	    * Called to update the entity's position/logic.
	    */
	   public void tick() {
	      this.noClip = true;
	      super.tick();
	      this.noClip = false;
	      this.setNoGravity(true);

	   }

	   protected void registerGoals() {
	      super.registerGoals();
	      this.goalSelector.addGoal(0, new SwimGoal(this));
	      this.goalSelector.addGoal(4, new EyeOfCthulhuEntity.ChargeAttackGoal());
	      this.goalSelector.addGoal(8, new EyeOfCthulhuEntity.MoveRandomGoal());
	      this.goalSelector.addGoal(9, new LookAtGoal(this, PlayerEntity.class, 3.0F, 1.0F));
	      this.goalSelector.addGoal(10, new LookAtGoal(this, MobEntity.class, 8.0F));
	      this.targetSelector.addGoal(2, new EyeOfCthulhuEntity.CopyOwnerTargetGoal(this));
	      this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, PlayerEntity.class, true));
	   }

	   protected void registerData() {
	      super.registerData();
	      this.dataManager.register(EOC_FLAGS, (byte)0);
	   }

	   /**
	    * (abstract) Protected helper method to read subclass entity data from NBT.
	    */
	   public void readAdditional(CompoundNBT compound) {
	      super.readAdditional(compound);
	      if (compound.contains("BoundX")) {
	         this.boundOrigin = new BlockPos(compound.getInt("BoundX"), compound.getInt("BoundY"), compound.getInt("BoundZ"));
	      }

	   }

	   public void writeAdditional(CompoundNBT compound) {
	      super.writeAdditional(compound);
	      if (this.boundOrigin != null) {
	         compound.putInt("BoundX", this.boundOrigin.getX());
	         compound.putInt("BoundY", this.boundOrigin.getY());
	         compound.putInt("BoundZ", this.boundOrigin.getZ());
	      }

	   }

	   @Nullable
	   public BlockPos getBoundOrigin() {
	      return this.boundOrigin;
	   }

	   public void setBoundOrigin(@Nullable BlockPos boundOriginIn) {
	      this.boundOrigin = boundOriginIn;
	   }

	   private boolean getEoCFlag(int mask) {
	      int i = this.dataManager.get(EOC_FLAGS);
	      return (i & mask) != 0;
	   }

	   private void setEoCFlag(int mask, boolean value) {
	      int i = this.dataManager.get(EOC_FLAGS);
	      if (value) {
	         i = i | mask;
	      } else {
	         i = i & ~mask;
	      }

	      this.dataManager.set(EOC_FLAGS, (byte)(i & 255));
	   }

	   public boolean isCharging() {
	      return this.getEoCFlag(1);
	   }

	   public void setCharging(boolean charging) {
	      this.setEoCFlag(1, charging);
	   }

	   @Nullable
	   public ILivingEntityData onInitialSpawn(IServerWorld worldIn, DifficultyInstance difficultyIn, SpawnReason reason, @Nullable ILivingEntityData spawnDataIn, @Nullable CompoundNBT dataTag) {
	      this.setEquipmentBasedOnDifficulty(difficultyIn);
	      this.setEnchantmentBasedOnDifficulty(difficultyIn);
	      return super.onInitialSpawn(worldIn, difficultyIn, reason, spawnDataIn, dataTag);
	   }
	   
	   /* Constant damage on collision */
	   @Override
	   public void onCollideWithPlayer(PlayerEntity entityIn) {
		   
		entityIn.attackEntityFrom(DamageSource.causeMobDamage(this), 10);
		
		super.onCollideWithPlayer(entityIn);	
	   }  
	  
	   
	   class ChargeAttackGoal extends Goal {
	      public ChargeAttackGoal() {
	         this.setMutexFlags(EnumSet.of(Goal.Flag.MOVE));
	      }

	      /**
	       * Returns whether execution should begin. You can also read and cache any state necessary for execution in this
	       * method as well.
	       */
	      public boolean shouldExecute() {
	         if (EyeOfCthulhuEntity.this.getAttackTarget() != null && !EyeOfCthulhuEntity.this.getMoveHelper().isUpdating() && EyeOfCthulhuEntity.this.rand.nextInt(7) == 0) {
	            return EyeOfCthulhuEntity.this.getDistanceSq(EyeOfCthulhuEntity.this.getAttackTarget()) > 4.0D;
	         } else {
	            return false;
	         }
	      }

	      /**
	       * Returns whether an in-progress EntityAIBase should continue executing
	       */
	      public boolean shouldContinueExecuting() {
	         return EyeOfCthulhuEntity.this.getMoveHelper().isUpdating() && EyeOfCthulhuEntity.this.isCharging() && EyeOfCthulhuEntity.this.getAttackTarget() != null && EyeOfCthulhuEntity.this.getAttackTarget().isAlive();
	      }

	      /**
	       * Execute a one shot task or start executing a continuous task
	       */
	      public void startExecuting() {
	         LivingEntity livingentity = EyeOfCthulhuEntity.this.getAttackTarget();
	         Vector3d vector3d = livingentity.getEyePosition(1.0F);
	         EyeOfCthulhuEntity.this.moveController.setMoveTo(vector3d.x, vector3d.y, vector3d.z, 1.0D);
	         EyeOfCthulhuEntity.this.setCharging(true);
	      }

	      /**
	       * Reset the task's internal state. Called when this task is interrupted by another one
	       */
	      public void resetTask() {
	         EyeOfCthulhuEntity.this.setCharging(false);
	      }

	      /**
	       * Keep ticking a continuous task that has already been started
	       */
	      public void tick() {
	         LivingEntity livingentity = EyeOfCthulhuEntity.this.getAttackTarget();
	         if (EyeOfCthulhuEntity.this.getBoundingBox().intersects(livingentity.getBoundingBox())) {
	            EyeOfCthulhuEntity.this.attackEntityAsMob(livingentity);
	            EyeOfCthulhuEntity.this.setCharging(false);
	         } else {
	            double d0 = EyeOfCthulhuEntity.this.getDistanceSq(livingentity);
	            if (d0 < 9.0D) { //9.0D de base
	               Vector3d vector3d = livingentity.getEyePosition(1.0F);
	               EyeOfCthulhuEntity.this.moveController.setMoveTo(vector3d.x, vector3d.y, vector3d.z, 1.0D);
	            }
	         }

	      }
	   }

	   class CopyOwnerTargetGoal extends TargetGoal {
	      private final EntityPredicate field_220803_b = (new EntityPredicate()).setIgnoresLineOfSight().setUseInvisibilityCheck();

	      public CopyOwnerTargetGoal(CreatureEntity creature) {
	         super(creature, false);
	      }

	      /**
	       * Returns whether execution should begin. You can also read and cache any state necessary for execution in this
	       * method as well.
	       */
	      public boolean shouldExecute() {
	         return EyeOfCthulhuEntity.this != null && EyeOfCthulhuEntity.this.getAttackTarget() != null && this.isSuitableTarget(EyeOfCthulhuEntity.this.getAttackTarget(), this.field_220803_b);
	      }

	      /**
	       * Execute a one shot task or start executing a continuous task
	       */
	      public void startExecuting() {
	         EyeOfCthulhuEntity.this.setAttackTarget(EyeOfCthulhuEntity.this.getAttackTarget());
	         super.startExecuting();
	      }
	   }

	   class MoveHelperController extends MovementController {
	      public MoveHelperController(EyeOfCthulhuEntity eoc) {
	         super(eoc);
	      }

	      public void tick() {	  
			
	         if (this.action == MovementController.Action.MOVE_TO) {
	            Vector3d vector3d = new Vector3d(this.posX - EyeOfCthulhuEntity.this.getPosX(), this.posY - EyeOfCthulhuEntity.this.getPosY(), this.posZ - EyeOfCthulhuEntity.this.getPosZ());
	            double d0 = vector3d.length();
	            if (d0 < EyeOfCthulhuEntity.this.getBoundingBox().getAverageEdgeLength()) {
	               this.action = MovementController.Action.WAIT;
	               EyeOfCthulhuEntity.this.setMotion(EyeOfCthulhuEntity.this.getMotion().scale(0.5D));
	            } else {
	            	
	            	if(EyeOfCthulhuEntity.this.getHealth() < EyeOfCthulhuEntity.this.getMaxHealth() / 2)
	            	{
	            		EyeOfCthulhuEntity.this.setMotion(EyeOfCthulhuEntity.this.getMotion().add(vector3d.scale(this.speed * 0.225D / d0))); //0.05 de base, 4.5x plus rapide
	            	}
	            	else
	            	{
	            		EyeOfCthulhuEntity.this.setMotion(EyeOfCthulhuEntity.this.getMotion().add(vector3d.scale(this.speed * 0.15D / d0))); //0.05 de base, 3x plus rapide
	            	}
	            	  
	              if (EyeOfCthulhuEntity.this.getAttackTarget() == null) {
	                  Vector3d vector3d1 = EyeOfCthulhuEntity.this.getMotion();
	                  EyeOfCthulhuEntity.this.rotationYaw = -((float)MathHelper.atan2(vector3d1.x, vector3d1.z)) * (180F / (float)Math.PI);
	                  EyeOfCthulhuEntity.this.renderYawOffset = EyeOfCthulhuEntity.this.rotationYaw;
	               } else {
	                  double d2 = EyeOfCthulhuEntity.this.getAttackTarget().getPosX() - EyeOfCthulhuEntity.this.getPosX();
	                  double d1 = EyeOfCthulhuEntity.this.getAttackTarget().getPosZ() - EyeOfCthulhuEntity.this.getPosZ();
	                  EyeOfCthulhuEntity.this.rotationYaw = -((float)MathHelper.atan2(d2, d1)) * (180F / (float)Math.PI);
	                  EyeOfCthulhuEntity.this.renderYawOffset = EyeOfCthulhuEntity.this.rotationYaw;
	               }
	            }

	         }
	      }
	   }

	   class MoveRandomGoal extends Goal {
	      public MoveRandomGoal() {
	         this.setMutexFlags(EnumSet.of(Goal.Flag.MOVE));
	      }

	      /**
	       * Returns whether execution should begin. You can also read and cache any state necessary for execution in this
	       * method as well.
	       */
	      public boolean shouldExecute() {
	         return !EyeOfCthulhuEntity.this.getMoveHelper().isUpdating() && EyeOfCthulhuEntity.this.rand.nextInt(2) == 0; // 7 de base
	      }

	      /**
	       * Returns whether an in-progress EntityAIBase should continue executing
	       */
	      public boolean shouldContinueExecuting() {
	         return false;
	      }

	      /**
	       * Keep ticking a continuous task that has already been started
	       */
	      public void tick() {
	         BlockPos blockpos = EyeOfCthulhuEntity.this.getBoundOrigin();
	         if (blockpos == null) {
	            blockpos = EyeOfCthulhuEntity.this.getPosition();
	         }

	         for(int i = 0; i < 3; ++i) {
	            BlockPos blockpos1 = blockpos.add(EyeOfCthulhuEntity.this.rand.nextInt(8) - 7, EyeOfCthulhuEntity.this.rand.nextInt(11) - 5, EyeOfCthulhuEntity.this.rand.nextInt(8) - 7);  //NextInts changed
	            if (EyeOfCthulhuEntity.this.world.isAirBlock(blockpos1)) {
	               EyeOfCthulhuEntity.this.moveController.setMoveTo((double)blockpos1.getX() + 0.5D, (double)blockpos1.getY() + 0.5D, (double)blockpos1.getZ() + 0.5D, 0.25D);
	               if (EyeOfCthulhuEntity.this.getAttackTarget() == null) {
	                  EyeOfCthulhuEntity.this.getLookController().setLookPosition((double)blockpos1.getX() + 0.5D, (double)blockpos1.getY() + 0.5D, (double)blockpos1.getZ() + 0.5D, 180.0F, 20.0F);
	               }
	               break;
	            }
	         }

	      }
	   }

}
