package com.saita.nightsoulsmod.entities.entity;

import java.util.EnumSet;

import javax.annotation.Nullable;

import com.saita.nightsoulsmod.entities.entity.projectiles.SpazmatismProjEntity;
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

public class SpazmatismEntity extends MonsterEntity{
	
	 protected static final DataParameter<Byte> EOC_FLAGS = EntityDataManager.createKey(SpazmatismEntity.class, DataSerializers.BYTE);
	 @Nullable
	 private BlockPos boundOrigin;

	public SpazmatismEntity(EntityType<? extends MonsterEntity> type, World worldIn) {
		super(type, worldIn);
	     this.moveController = new SpazmatismEntity.MoveHelperController(this);

	}
	
 	private final ServerBossInfo bossInfo = (ServerBossInfo)(new ServerBossInfo(this.getDisplayName(), BossInfo.Color.GREEN, BossInfo.Overlay.PROGRESS));

	
	public static AttributeModifierMap.MutableAttribute setCustomAttributes() {
        return MobEntity.func_233666_p_()
                .createMutableAttribute(Attributes.MAX_HEALTH, 1200.0D)
                .createMutableAttribute(Attributes.ATTACK_DAMAGE, 26.0D) 
                .createMutableAttribute(Attributes.KNOCKBACK_RESISTANCE, 1.0D) 
                .createMutableAttribute(Attributes.FOLLOW_RANGE, 70.0D);
    }


    @Override
    protected int getExperiencePoints(PlayerEntity player)
    {
        return 1250;
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
	      this.goalSelector.addGoal(4, new SpazmatismEntity.ChargeAttackGoal());
	      this.goalSelector.addGoal(8, new SpazmatismEntity.MoveRandomGoal());
	      this.goalSelector.addGoal(9, new LookAtGoal(this, PlayerEntity.class, 3.0F, 1.0F));
	      this.goalSelector.addGoal(10, new LookAtGoal(this, MobEntity.class, 8.0F));
	      this.targetSelector.addGoal(2, new SpazmatismEntity.CopyOwnerTargetGoal(this));
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
		   
		entityIn.attackEntityFrom(DamageSource.causeMobDamage(this), 18);
		
		super.onCollideWithPlayer(entityIn);	
	   }  
	   
	   @Override
       public void livingTick() {
		   
		   if(this.getAttackTarget() != null)
		   {
			   int attackChance = 0;
			   
			   if(SpazmatismEntity.this.getHealth() < SpazmatismEntity.this.getMaxHealth() / 2)
			   {
				   attackChance = rand.nextInt(13);
			   }
			   else
			   {
				   attackChance = rand.nextInt(20);
			   }
			   
		       if(attackChance == 0)
		       {
		        	this.playSound(SoundInit.SPAZMATISM_SHOT.get(), 1.0F, 1.0F);
		
		        	SpazmatismProjEntity proj = new SpazmatismProjEntity(this, world);
		        	SpazmatismProjEntity proj2 = new SpazmatismProjEntity(this, world);
		        	SpazmatismProjEntity proj3 = new SpazmatismProjEntity(this, world);
		        	
		            proj.setDirectionAndMovement(this, this.rotationPitch, this.rotationYaw, 0.0F, 1.5F, 0.0F);
		            proj2.setDirectionAndMovement(this, this.rotationPitch, this.rotationYaw + 3.0F, 0.0F, 1.5F, 0.0F);
		            proj3.setDirectionAndMovement(this, this.rotationPitch, this.rotationYaw - 3.0F, 0.0F, 1.5F, 0.0F);
		            
		            proj.setPosition(this.getPosX(), this.getPosY() + 1, this.getPosZ());
		            proj2.setPosition(this.getPosX(), this.getPosY() + 1, this.getPosZ());
		            proj3.setPosition(this.getPosX(), this.getPosY() + 1, this.getPosZ());
		            
		            world.addEntity(proj);
		            world.addEntity(proj2);
		            world.addEntity(proj3);
		       }
		  }       

        super.livingTick();
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
	         if (SpazmatismEntity.this.getAttackTarget() != null && !SpazmatismEntity.this.getMoveHelper().isUpdating() && SpazmatismEntity.this.rand.nextInt(7) == 0) {
	            return SpazmatismEntity.this.getDistanceSq(SpazmatismEntity.this.getAttackTarget()) > 4.0D;
	         } else {
	            return false;
	         }
	      }

	      /**
	       * Returns whether an in-progress EntityAIBase should continue executing
	       */
	      public boolean shouldContinueExecuting() {
	         return SpazmatismEntity.this.getMoveHelper().isUpdating() && SpazmatismEntity.this.isCharging() && SpazmatismEntity.this.getAttackTarget() != null && SpazmatismEntity.this.getAttackTarget().isAlive();
	      }

	      /**
	       * Execute a one shot task or start executing a continuous task
	       */
	      public void startExecuting() {
	         LivingEntity livingentity = SpazmatismEntity.this.getAttackTarget();
	         Vector3d vector3d = livingentity.getEyePosition(1.0F);
	         SpazmatismEntity.this.moveController.setMoveTo(vector3d.x, vector3d.y, vector3d.z, 1.0D);
	         SpazmatismEntity.this.setCharging(true);
	      }

	      /**
	       * Reset the task's internal state. Called when this task is interrupted by another one
	       */
	      public void resetTask() {
	         SpazmatismEntity.this.setCharging(false);
	      }

	      /**
	       * Keep ticking a continuous task that has already been started
	       */
	      public void tick() {
	         LivingEntity livingentity = SpazmatismEntity.this.getAttackTarget();
	         if (SpazmatismEntity.this.getBoundingBox().intersects(livingentity.getBoundingBox())) {
	            SpazmatismEntity.this.attackEntityAsMob(livingentity);
	            SpazmatismEntity.this.setCharging(false);
	         } else {
	            double d0 = SpazmatismEntity.this.getDistanceSq(livingentity);
	            if (d0 < 9.0D) { //9.0D de base
	               Vector3d vector3d = livingentity.getEyePosition(1.0F);
	               SpazmatismEntity.this.moveController.setMoveTo(vector3d.x, vector3d.y, vector3d.z, 1.0D);
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
	         return SpazmatismEntity.this != null && SpazmatismEntity.this.getAttackTarget() != null && this.isSuitableTarget(SpazmatismEntity.this.getAttackTarget(), this.field_220803_b);
	      }

	      /**
	       * Execute a one shot task or start executing a continuous task
	       */
	      public void startExecuting() {
	         SpazmatismEntity.this.setAttackTarget(SpazmatismEntity.this.getAttackTarget());
	         super.startExecuting();
	      }
	   }

	   class MoveHelperController extends MovementController {
	      public MoveHelperController(SpazmatismEntity eoc) {
	         super(eoc);
	      }

	      public void tick() {	  
			
	         if (this.action == MovementController.Action.MOVE_TO) {
	            Vector3d vector3d = new Vector3d(this.posX - SpazmatismEntity.this.getPosX(), this.posY - SpazmatismEntity.this.getPosY(), this.posZ - SpazmatismEntity.this.getPosZ());
	            double d0 = vector3d.length();
	            if (d0 < SpazmatismEntity.this.getBoundingBox().getAverageEdgeLength()) {
	               this.action = MovementController.Action.WAIT;
	               SpazmatismEntity.this.setMotion(SpazmatismEntity.this.getMotion().scale(0.5D));
	            } else {
	            	
	            	if(SpazmatismEntity.this.getHealth() < SpazmatismEntity.this.getMaxHealth() / 2)
	            	{
	            		SpazmatismEntity.this.setMotion(SpazmatismEntity.this.getMotion().add(vector3d.scale(this.speed * 0.30D / d0))); //0.05 de base, 6x plus rapide
	            	}
	            	else
	            	{
	            		SpazmatismEntity.this.setMotion(SpazmatismEntity.this.getMotion().add(vector3d.scale(this.speed * 0.20D / d0))); //0.05 de base, 4x plus rapide
	            	}
	            	  
	              if (SpazmatismEntity.this.getAttackTarget() == null) {
	                  Vector3d vector3d1 = SpazmatismEntity.this.getMotion();
	                  SpazmatismEntity.this.rotationYaw = -((float)MathHelper.atan2(vector3d1.x, vector3d1.z)) * (180F / (float)Math.PI);
	                  SpazmatismEntity.this.renderYawOffset = SpazmatismEntity.this.rotationYaw;
	               } else {
	                  double d2 = SpazmatismEntity.this.getAttackTarget().getPosX() - SpazmatismEntity.this.getPosX();
	                  double d1 = SpazmatismEntity.this.getAttackTarget().getPosZ() - SpazmatismEntity.this.getPosZ();
	                  SpazmatismEntity.this.rotationYaw = -((float)MathHelper.atan2(d2, d1)) * (180F / (float)Math.PI);
	                  SpazmatismEntity.this.renderYawOffset = SpazmatismEntity.this.rotationYaw;
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
	         return !SpazmatismEntity.this.getMoveHelper().isUpdating() && SpazmatismEntity.this.rand.nextInt(2) == 0; // 7 de base
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
	         BlockPos blockpos = SpazmatismEntity.this.getBoundOrigin();
	         if (blockpos == null) {
	            blockpos = SpazmatismEntity.this.getPosition();
	         }

	         for(int i = 0; i < 3; ++i) {
	            BlockPos blockpos1 = blockpos.add(SpazmatismEntity.this.rand.nextInt(8) - 7, SpazmatismEntity.this.rand.nextInt(11) - 5, SpazmatismEntity.this.rand.nextInt(8) - 7);  //NextInts changed
	            if (SpazmatismEntity.this.world.isAirBlock(blockpos1)) {
	               SpazmatismEntity.this.moveController.setMoveTo((double)blockpos1.getX() + 0.5D, (double)blockpos1.getY() + 0.5D, (double)blockpos1.getZ() + 0.5D, 0.25D);
	               if (SpazmatismEntity.this.getAttackTarget() == null) {
	                  SpazmatismEntity.this.getLookController().setLookPosition((double)blockpos1.getX() + 0.5D, (double)blockpos1.getY() + 0.5D, (double)blockpos1.getZ() + 0.5D, 180.0F, 20.0F);
	               }
	               break;
	            }
	         }

	      }
	   }

}
