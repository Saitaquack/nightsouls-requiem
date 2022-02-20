package com.saita.nightsoulsmod.entities.entity;

import java.util.Random;

import com.saita.nightsoulsmod.init.NightSoulsEntityTypes;
import com.saita.nightsoulsmod.init.SoundInit;

import net.minecraft.block.Blocks;
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
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.BossInfo;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerBossInfo;

public class AkazaEntity extends MonsterEntity {

	public AkazaEntity(EntityType<? extends MonsterEntity> type, World worldIn) {
		super(type, worldIn);

		this.stepHeight = 3.0F;
	
	}
	
	private final ServerBossInfo bossInfo = (ServerBossInfo)(new ServerBossInfo(this.getDisplayName(), BossInfo.Color.RED, BossInfo.Overlay.PROGRESS));
	
	public static AttributeModifierMap.MutableAttribute setCustomAttributes() {
		return MobEntity.func_233666_p_()
				.createMutableAttribute(Attributes.MAX_HEALTH, 2500.0D)
				.createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.42D) 
				.createMutableAttribute(Attributes.ATTACK_DAMAGE, 24.0D) 
				.createMutableAttribute(Attributes.FOLLOW_RANGE, 80.0D)
				.createMutableAttribute(Attributes.KNOCKBACK_RESISTANCE, 0.5D); 
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
	      this.targetSelector.addGoal(4, new NearestAttackableTargetGoal<>(this, PaladinEntity.class, true));
	      this.targetSelector.addGoal(5, new NearestAttackableTargetGoal<>(this, IronGolemEntity.class, true));
  
	   }
	 
	 @Override
	 protected int getExperiencePoints(PlayerEntity player)
	 {
		 return 2500;
	 }
	 
	@Override
 	public boolean isEntityUndead() {
 		return true;
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
		
		return SoundInit.AKAZA_AMBIENT.get();
	}
	
	@Override
	protected SoundEvent getDeathSound() {
		
		return SoundInit.AKAZA_DEATH.get();
	}
	
	@Override
	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		
		return null;
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
	

	
	@Override
	public boolean attackEntityAsMob(Entity entityIn) {
		
	     if (!super.attackEntityAsMob(entityIn)) {
	         return false;
	         
	        } else {
	        	
	            if (entityIn instanceof LivingEntity) {
	                Random random = new Random();
	                int randomTeleport = random.nextInt(4);
	                int randomDeadlyExplosion = random.nextInt(8);
	                if(randomTeleport == 0)
	                {
	                	((LivingEntity) entityIn).addPotionEffect(new EffectInstance(Effects.BLINDNESS, 60, 0));
	                	int randX = random.nextInt(3);
	                	boolean boolX = random.nextBoolean();
	                	
	                	int randY = random.nextInt(3);
	                	
	                	int randZ = random.nextInt(3);
	                	boolean boolZ = random.nextBoolean();
	                	
	                   	if(boolX)
	                	{
	                		randX = -randX;
	                	}

	                   	if(boolZ)
	                	{
	                		randZ = -randZ;
	                	}
	                	this.teleportKeepLoaded(this.getPosX() + randX, this.getPosY() + randY, this.getPosZ() + randZ);
	                }
	                if(randomDeadlyExplosion == 0)
	                {
	                	 if(!world.isRemote)
						 {
							 world.createExplosion(null, entityIn.getPosX(), entityIn.getPosY(), entityIn.getPosZ(), 5.0F, Explosion.Mode.DESTROY);
							 world.createExplosion(null, this.getPosX(), this.getPosY(), this.getPosZ(), 5.0F, Explosion.Mode.DESTROY);
						 }
	                }
	               
	            }
	            return true;
	        }
	        
	  }
	
	@Override
	public void livingTick() {
		 if (this.isAlive()) {
			 
			 this.addPotionEffect(new EffectInstance(Effects.JUMP_BOOST, 5, 0, false, false));
			 
			 if(world.getGameTime() % 150 == 0)
			 {
				 this.addPotionEffect(new EffectInstance(Effects.REGENERATION, 200, 4, false, false));
				 
				 Random random = new Random();
				 int randomBoom = random.nextInt(2);
				 if(randomBoom == 1)
				 {
					 if(!world.isRemote)
					 {
						 world.createExplosion(null, this.getPosX(), this.getPosY(), this.getPosZ(), 4.0F, Explosion.Mode.DESTROY);
					 }
				 }
			 }
			 
			 if(world.getGameTime() % 975 == 0)
			 {
				HellfireServantEntity servant = new HellfireServantEntity(NightSoulsEntityTypes.HELLFIRE_SERVANT.get(), world);
				HellfireServantEntity servant2 = new HellfireServantEntity(NightSoulsEntityTypes.HELLFIRE_SERVANT.get(), world);
				HellfireServantEntity servant3 = new HellfireServantEntity(NightSoulsEntityTypes.HELLFIRE_SERVANT.get(), world);
				
				servant.setPositionAndUpdate(this.getPosX(), this.getPosY() + 5, this.getPosZ());
				servant2.setPositionAndUpdate(this.getPosX(), this.getPosY() + 5, this.getPosZ());
				servant3.setPositionAndUpdate(this.getPosX(), this.getPosY() + 5, this.getPosZ());
				
				world.addEntity(servant);
				world.addEntity(servant2);
				world.addEntity(servant3);
			 }
			 
			 if(world.getGameTime() % 325 == 0)
			 {
				 Random random = new Random();
				 int randomAttack = random.nextInt(2);
				 
				 if(randomAttack == 0)
				 {
					 this.addPotionEffect(new EffectInstance(Effects.STRENGTH, 180, 3));
					 this.addPotionEffect(new EffectInstance(Effects.SPEED, 180, 3));
					 world.playSound(this.getPosX(), this.getPosY(), this.getPosZ(), SoundInit.AKAZA_COMPASS.get(), SoundCategory.HOSTILE, 1.0F, 1.0F, false);
					 
					 if(!world.isRemote)
					 {
	
						 world.setBlockState(new BlockPos(this.getPosX() + 1 ,this.getPosY() - 1, this.getPosZ()), Blocks.PACKED_ICE.getDefaultState());
						 world.setBlockState(new BlockPos(this.getPosX() + 2 ,this.getPosY() - 1, this.getPosZ()), Blocks.PACKED_ICE.getDefaultState());
						 world.setBlockState(new BlockPos(this.getPosX() + 3 ,this.getPosY() - 1, this.getPosZ()), Blocks.PACKED_ICE.getDefaultState());
						 world.setBlockState(new BlockPos(this.getPosX() + 4 ,this.getPosY() - 1, this.getPosZ()), Blocks.PACKED_ICE.getDefaultState());
						 world.setBlockState(new BlockPos(this.getPosX() + 5 ,this.getPosY() - 1, this.getPosZ()), Blocks.PACKED_ICE.getDefaultState());
						 world.setBlockState(new BlockPos(this.getPosX() - 1 ,this.getPosY() - 1, this.getPosZ()), Blocks.PACKED_ICE.getDefaultState());
						 world.setBlockState(new BlockPos(this.getPosX() - 2 ,this.getPosY() - 1, this.getPosZ()), Blocks.PACKED_ICE.getDefaultState());
						 world.setBlockState(new BlockPos(this.getPosX() - 3 ,this.getPosY() - 1, this.getPosZ()), Blocks.PACKED_ICE.getDefaultState());
						 world.setBlockState(new BlockPos(this.getPosX() - 4 ,this.getPosY() - 1, this.getPosZ()), Blocks.PACKED_ICE.getDefaultState());
						 world.setBlockState(new BlockPos(this.getPosX() - 5 ,this.getPosY() - 1, this.getPosZ()), Blocks.PACKED_ICE.getDefaultState());
						 
						 world.setBlockState(new BlockPos(this.getPosX(), this.getPosY() - 1, this.getPosZ() + 1), Blocks.PACKED_ICE.getDefaultState());
						 world.setBlockState(new BlockPos(this.getPosX(), this.getPosY() - 1, this.getPosZ() + 2), Blocks.PACKED_ICE.getDefaultState());
						 world.setBlockState(new BlockPos(this.getPosX(), this.getPosY() - 1, this.getPosZ() + 3), Blocks.PACKED_ICE.getDefaultState());
						 world.setBlockState(new BlockPos(this.getPosX(), this.getPosY() - 1, this.getPosZ() + 4), Blocks.PACKED_ICE.getDefaultState());
						 world.setBlockState(new BlockPos(this.getPosX(), this.getPosY() - 1, this.getPosZ() + 5), Blocks.PACKED_ICE.getDefaultState());
						 world.setBlockState(new BlockPos(this.getPosX(), this.getPosY() - 1, this.getPosZ() - 1), Blocks.PACKED_ICE.getDefaultState());
						 world.setBlockState(new BlockPos(this.getPosX(), this.getPosY() - 1, this.getPosZ() - 2), Blocks.PACKED_ICE.getDefaultState());
						 world.setBlockState(new BlockPos(this.getPosX(), this.getPosY() - 1, this.getPosZ() - 3), Blocks.PACKED_ICE.getDefaultState());
						 world.setBlockState(new BlockPos(this.getPosX(), this.getPosY() - 1, this.getPosZ() - 4), Blocks.PACKED_ICE.getDefaultState());
						 world.setBlockState(new BlockPos(this.getPosX(), this.getPosY() - 1, this.getPosZ() - 5), Blocks.PACKED_ICE.getDefaultState());
						 
						 world.setBlockState(new BlockPos(this.getPosX() + 4 ,this.getPosY() - 1, this.getPosZ() - 1), Blocks.PACKED_ICE.getDefaultState());
						 world.setBlockState(new BlockPos(this.getPosX() + 4 ,this.getPosY() - 1, this.getPosZ() + 1), Blocks.PACKED_ICE.getDefaultState());
						 world.setBlockState(new BlockPos(this.getPosX() - 4 ,this.getPosY() - 1, this.getPosZ() - 1), Blocks.PACKED_ICE.getDefaultState());
						 world.setBlockState(new BlockPos(this.getPosX() - 4 ,this.getPosY() - 1, this.getPosZ() + 1), Blocks.PACKED_ICE.getDefaultState());
						 world.setBlockState(new BlockPos(this.getPosX() + 1 ,this.getPosY() - 1, this.getPosZ() + 4), Blocks.PACKED_ICE.getDefaultState());
						 world.setBlockState(new BlockPos(this.getPosX() - 1 ,this.getPosY() - 1, this.getPosZ() + 4), Blocks.PACKED_ICE.getDefaultState());
						 world.setBlockState(new BlockPos(this.getPosX() + 1 ,this.getPosY() - 1, this.getPosZ() - 4), Blocks.PACKED_ICE.getDefaultState());
						 world.setBlockState(new BlockPos(this.getPosX() - 1 ,this.getPosY() - 1, this.getPosZ() - 4), Blocks.PACKED_ICE.getDefaultState());
						 
						 world.setBlockState(new BlockPos(this.getPosX() + 1 ,this.getPosY() - 1, this.getPosZ() + 1), Blocks.PACKED_ICE.getDefaultState());
						 world.setBlockState(new BlockPos(this.getPosX() - 1 ,this.getPosY() - 1, this.getPosZ() - 1), Blocks.PACKED_ICE.getDefaultState());
						 world.setBlockState(new BlockPos(this.getPosX() + 1 ,this.getPosY() - 1, this.getPosZ() - 1), Blocks.PACKED_ICE.getDefaultState());
						 world.setBlockState(new BlockPos(this.getPosX() - 1 ,this.getPosY() - 1, this.getPosZ() + 1), Blocks.PACKED_ICE.getDefaultState());
						 world.setBlockState(new BlockPos(this.getPosX() + 2 ,this.getPosY() - 1, this.getPosZ() + 2), Blocks.PACKED_ICE.getDefaultState());
						 world.setBlockState(new BlockPos(this.getPosX() - 2 ,this.getPosY() - 1, this.getPosZ() - 2), Blocks.PACKED_ICE.getDefaultState());
						 world.setBlockState(new BlockPos(this.getPosX() + 2 ,this.getPosY() - 1, this.getPosZ() - 2), Blocks.PACKED_ICE.getDefaultState());
						 world.setBlockState(new BlockPos(this.getPosX() - 2 ,this.getPosY() - 1, this.getPosZ() + 2), Blocks.PACKED_ICE.getDefaultState());
						 world.setBlockState(new BlockPos(this.getPosX() + 3 ,this.getPosY() - 1, this.getPosZ() + 3), Blocks.PACKED_ICE.getDefaultState());
						 world.setBlockState(new BlockPos(this.getPosX() - 3 ,this.getPosY() - 1, this.getPosZ() - 3), Blocks.PACKED_ICE.getDefaultState());
						 world.setBlockState(new BlockPos(this.getPosX() + 3 ,this.getPosY() - 1, this.getPosZ() - 3), Blocks.PACKED_ICE.getDefaultState());
						 world.setBlockState(new BlockPos(this.getPosX() - 3 ,this.getPosY() - 1, this.getPosZ() + 3), Blocks.PACKED_ICE.getDefaultState());
					 
					 }
				 
				 }
				 else
				 {
					 if(!world.isRemote)
					 {
						 world.createExplosion(null, this.getPosX() + 5, this.getPosY(), this.getPosZ(), 4.0F, true, Explosion.Mode.DESTROY);
						 world.createExplosion(null, this.getPosX() - 5, this.getPosY(), this.getPosZ(), 4.0F, true, Explosion.Mode.DESTROY);
						 world.createExplosion(null, this.getPosX(), this.getPosY(), this.getPosZ() + 5, 4.0F, true, Explosion.Mode.DESTROY);
						 world.createExplosion(null, this.getPosX(), this.getPosY(), this.getPosZ() - 5, 4.0F, true, Explosion.Mode.DESTROY);
					 }
				 }
				
			 }	
			 
		 }		
		super.livingTick();
	}
		
}
