package com.saita.nightsoulsmod.entities.entity;

import java.util.Random;

import com.saita.nightsoulsmod.init.SoundInit;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MobEntity;
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
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.BossInfo;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerBossInfo;
import net.minecraft.world.server.ServerWorld;

public class KingCrimsonEntity extends MonsterEntity {
	
	int blockBreakCounter = 0;

	public KingCrimsonEntity(EntityType<? extends MonsterEntity> type, World worldIn) {
		super(type, worldIn);

		this.stepHeight = 2.0F;
	
	}
	
	private final ServerBossInfo bossInfo = (ServerBossInfo)(new ServerBossInfo(this.getDisplayName(), BossInfo.Color.PURPLE, BossInfo.Overlay.PROGRESS));
	
	public static AttributeModifierMap.MutableAttribute setCustomAttributes() {
		return MobEntity.func_233666_p_()
				.createMutableAttribute(Attributes.MAX_HEALTH, 800.0D)
				.createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.38D) 
				.createMutableAttribute(Attributes.ATTACK_DAMAGE, 16.0D) 
				.createMutableAttribute(Attributes.FOLLOW_RANGE, 60.0D)
				.createMutableAttribute(Attributes.KNOCKBACK_RESISTANCE, 0.3D); 
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
		return 800;
	}
	 
	@Override
	protected float getWaterSlowDown() {
		
		return 1.00F;
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
	 
	@Override
	protected SoundEvent getAmbientSound() {
		
		return SoundInit.KING_CRIMSON_AMBIENT.get();
	}
	
	@Override
	protected SoundEvent getDeathSound() {
		
		return SoundInit.KING_CRIMSON_DEATH.get();
	}
	
	@Override
	public boolean isImmuneToExplosions() {
		
		return true;
	}
	
	
	//Negates fall damage
	@Override
	protected int calculateFallDamage(float p_225508_1_, float p_225508_2_) {
				
		return 0;
	}
	
	public void teleportKC()
	{
		Random rand = new Random();
		int randX = rand.nextInt(8);              	
		int randZ = rand.nextInt(8);
    	
		boolean boolX = rand.nextBoolean();
    	boolean boolZ = rand.nextBoolean();
    	
    	if(boolX)
    	{
    		randX = -randX;
    	}
    	if(boolZ)
    	{
    		 randZ = -randZ;
    	}
    	
    	this.teleportKeepLoaded(this.getPosX() + randX, this.getPosY(), this.getPosZ() + randZ);
	}
	
	@Override
	public boolean attackEntityAsMob(Entity entityIn) {
					
	     if (!super.attackEntityAsMob(entityIn)) {
	         return false;
	         
	        } else {
	        	
	            if (entityIn instanceof LivingEntity) {
	                Random random = new Random();
	                boolean kingCrimsonTp = random.nextBoolean();
	                
	                if(kingCrimsonTp)
	                {
	                	((LivingEntity) entityIn).addPotionEffect(new EffectInstance(Effects.BLINDNESS, 60, 0));
	                	((LivingEntity) entityIn).addPotionEffect(new EffectInstance(Effects.SLOWNESS, 60, 0));
                	
	                	this.playSound(SoundInit.TIME_SKIP.get(), 1.0F, 1.0F);
	                	teleportKC();
	                	long getCurrentDayTime = world.getDayTime();
	    				((ServerWorld) world).setDayTime(getCurrentDayTime + 200);

	                }
	                
	               
	            }
	            return true;
	        }
	        
	  }
	
	@Override
	public void damageEntity(DamageSource damageSrc, float damageAmount) {
		if(this.isAlive())
		{		
		  Random random = new Random();
          int kingCrimsonTp = random.nextInt(4);    
          int randomTPtoPlayer = random.nextInt(24);
          
          if(kingCrimsonTp == 0 && randomTPtoPlayer != 0)
          {    
        	this.playSound(SoundInit.TIME_SKIP.get(), 1.0F, 1.0F);
        	
          	teleportKC();
          	this.addPotionEffect(new EffectInstance(Effects.INVISIBILITY, 30, 0));
          	long getCurrentDayTime = world.getDayTime();
			((ServerWorld) world).setDayTime(getCurrentDayTime + 200);		

          }
          
          if(randomTPtoPlayer == 0 && kingCrimsonTp != 0 && damageSrc.getTrueSource() != null)
          {
        	  this.playSound(SoundInit.TIME_SKIP.get(), 1.0F, 1.0F);	
        	  
          	  this.teleportKeepLoaded(damageSrc.getTrueSource().getPosX(), damageSrc.getTrueSource().getPosY(), damageSrc.getTrueSource().getPosZ());
          	  this.addPotionEffect(new EffectInstance(Effects.INVISIBILITY, 30, 0));
          	  long getCurrentDayTime = world.getDayTime();
			  ((ServerWorld) world).setDayTime(getCurrentDayTime + 200);		
          }
		}
		
		super.damageEntity(damageSrc, damageAmount);
	}
	
	@Override
	public void livingTick() {
		 if(this.isAlive()) {	
			 
			 blockBreakCounter++;
			 
			 if(world.getGameTime() % 150 == 0)
			 {
				 this.addPotionEffect(new EffectInstance(Effects.REGENERATION, 200, 0, false, false));
			 }
			 
			 
			 if(this.isEntityInsideOpaqueBlock())
			 {
				 BlockPos pos1 = new BlockPos(this.getPosition());
				 BlockPos pos2 = new BlockPos(this.getPosX(), this.getPosY() + 1, this.getPosZ());
				 
				 if(blockBreakCounter >= 20)
				 {
					 blockBreakCounter = 0;
					 
					 if(!world.isRemote)
					 {
						 world.destroyBlock(pos1, true);
						 world.destroyBlock(pos2, true);
					 }
					 this.playSound(SoundEvents.ENTITY_WITHER_BREAK_BLOCK, 1.0F, 1.0F);				 
				 }
			 }
		          				 
		 }		
		super.livingTick();
	}
		
}
