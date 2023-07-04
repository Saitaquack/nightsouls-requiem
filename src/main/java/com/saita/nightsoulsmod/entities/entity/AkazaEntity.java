package com.saita.nightsoulsmod.entities.entity;

import java.util.Random;

import com.saita.nightsoulsmod.init.BlockInit;
import com.saita.nightsoulsmod.init.NightSoulsEntityTypes;
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
import net.minecraft.entity.monster.MonsterEntity;
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
import net.minecraft.world.Explosion;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerBossInfo;

public class AkazaEntity extends MonsterEntity {
	
	int blockBreakCounter = 0;

	public AkazaEntity(EntityType<? extends MonsterEntity> type, World worldIn) {
		super(type, worldIn);

		this.stepHeight = 3.0F;
	
	}
	
	private final ServerBossInfo bossInfo = (ServerBossInfo)(new ServerBossInfo(this.getDisplayName(), BossInfo.Color.YELLOW, BossInfo.Overlay.PROGRESS).setDarkenSky(true));
	
	public static AttributeModifierMap.MutableAttribute setCustomAttributes() {
		return MobEntity.func_233666_p_()
				.createMutableAttribute(Attributes.MAX_HEALTH, 3500.0D)
				.createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.42D) 
				.createMutableAttribute(Attributes.ATTACK_DAMAGE, 26.0D) 
				.createMutableAttribute(Attributes.FOLLOW_RANGE, 60.0D)
				.createMutableAttribute(Attributes.KNOCKBACK_RESISTANCE, 0.5D)
				.createMutableAttribute(Attributes.ATTACK_KNOCKBACK, 2.0D); 
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
	      this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, PaladinEntity.class, true));
	      
	      this.targetSelector.addGoal(4, new NearestAttackableTargetGoal<>(this, LivingEntity.class, 5, false, false, (p_234199_0_) -> {
	          return !(p_234199_0_ instanceof HellfireServantEntity) && !(p_234199_0_ instanceof DemonEyeEntity);
	       }));
  
	   }
	 
    @Override
	protected int getExperiencePoints(PlayerEntity player)
	{
		return 4000;
	}
	 
	@Override
	protected float getWaterSlowDown() {
		
		return 1.00F;
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
	public boolean isImmuneToExplosions() {
		
		return true;
	}
	
	
	//Negates fall damage
	@Override
	protected int calculateFallDamage(float p_225508_1_, float p_225508_2_) {
				
		return 0;
	}
	
	public void placeAkazice(int positionX, int positionZ)
	{
		 world.setBlockState(new BlockPos(this.getPosX() + 1 + positionX ,this.getPosY() - 1, this.getPosZ() + positionZ), BlockInit.AKAZICE.get().getDefaultState());
		 world.setBlockState(new BlockPos(this.getPosX() + 2 + positionX ,this.getPosY() - 1, this.getPosZ() + positionZ), BlockInit.AKAZICE.get().getDefaultState());
		 world.setBlockState(new BlockPos(this.getPosX() + 3 + positionX ,this.getPosY() - 1, this.getPosZ() + positionZ), BlockInit.AKAZICE.get().getDefaultState());
		 world.setBlockState(new BlockPos(this.getPosX() + 4 + positionX ,this.getPosY() - 1, this.getPosZ() + positionZ), BlockInit.AKAZICE.get().getDefaultState());
		 world.setBlockState(new BlockPos(this.getPosX() + 5 + positionX ,this.getPosY() - 1, this.getPosZ() + positionZ), BlockInit.AKAZICE.get().getDefaultState());
		 world.setBlockState(new BlockPos(this.getPosX() - 1 + positionX ,this.getPosY() - 1, this.getPosZ() + positionZ), BlockInit.AKAZICE.get().getDefaultState());
		 world.setBlockState(new BlockPos(this.getPosX() - 2 + positionX ,this.getPosY() - 1, this.getPosZ() + positionZ), BlockInit.AKAZICE.get().getDefaultState());
		 world.setBlockState(new BlockPos(this.getPosX() - 3 + positionX ,this.getPosY() - 1, this.getPosZ() + positionZ), BlockInit.AKAZICE.get().getDefaultState());
		 world.setBlockState(new BlockPos(this.getPosX() - 4 + positionX ,this.getPosY() - 1, this.getPosZ() + positionZ), BlockInit.AKAZICE.get().getDefaultState());
		 world.setBlockState(new BlockPos(this.getPosX() - 5 + positionX ,this.getPosY() - 1, this.getPosZ() + positionZ), BlockInit.AKAZICE.get().getDefaultState());
		 
		 world.setBlockState(new BlockPos(this.getPosX() + positionX, this.getPosY() - 1, this.getPosZ() + 1 + positionZ), BlockInit.AKAZICE.get().getDefaultState());
		 world.setBlockState(new BlockPos(this.getPosX() + positionX, this.getPosY() - 1, this.getPosZ() + 2 + positionZ), BlockInit.AKAZICE.get().getDefaultState());
		 world.setBlockState(new BlockPos(this.getPosX() + positionX, this.getPosY() - 1, this.getPosZ() + 3 + positionZ), BlockInit.AKAZICE.get().getDefaultState());
		 world.setBlockState(new BlockPos(this.getPosX() + positionX, this.getPosY() - 1, this.getPosZ() + 4 + positionZ), BlockInit.AKAZICE.get().getDefaultState());
		 world.setBlockState(new BlockPos(this.getPosX() + positionX, this.getPosY() - 1, this.getPosZ() + 5 + positionZ), BlockInit.AKAZICE.get().getDefaultState());
		 world.setBlockState(new BlockPos(this.getPosX() + positionX, this.getPosY() - 1, this.getPosZ() - 1 + positionZ), BlockInit.AKAZICE.get().getDefaultState());
		 world.setBlockState(new BlockPos(this.getPosX() + positionX, this.getPosY() - 1, this.getPosZ() - 2 + positionZ), BlockInit.AKAZICE.get().getDefaultState());
		 world.setBlockState(new BlockPos(this.getPosX() + positionX, this.getPosY() - 1, this.getPosZ() - 3 + positionZ), BlockInit.AKAZICE.get().getDefaultState());
		 world.setBlockState(new BlockPos(this.getPosX() + positionX, this.getPosY() - 1, this.getPosZ() - 4 + positionZ), BlockInit.AKAZICE.get().getDefaultState());
		 world.setBlockState(new BlockPos(this.getPosX() + positionX, this.getPosY() - 1, this.getPosZ() - 5 + positionZ), BlockInit.AKAZICE.get().getDefaultState());
		 
		 world.setBlockState(new BlockPos(this.getPosX() + 4 + positionX ,this.getPosY() - 1, this.getPosZ() - 1 + positionZ), BlockInit.AKAZICE.get().getDefaultState());
		 world.setBlockState(new BlockPos(this.getPosX() + 4 + positionX ,this.getPosY() - 1, this.getPosZ() + 1 + positionZ), BlockInit.AKAZICE.get().getDefaultState());
		 world.setBlockState(new BlockPos(this.getPosX() - 4 + positionX ,this.getPosY() - 1, this.getPosZ() - 1 + positionZ), BlockInit.AKAZICE.get().getDefaultState());
		 world.setBlockState(new BlockPos(this.getPosX() - 4 + positionX ,this.getPosY() - 1, this.getPosZ() + 1 + positionZ), BlockInit.AKAZICE.get().getDefaultState());
		 world.setBlockState(new BlockPos(this.getPosX() + 1 + positionX ,this.getPosY() - 1, this.getPosZ() + 4 + positionZ), BlockInit.AKAZICE.get().getDefaultState());
		 world.setBlockState(new BlockPos(this.getPosX() - 1 + positionX ,this.getPosY() - 1, this.getPosZ() + 4 + positionZ), BlockInit.AKAZICE.get().getDefaultState());
		 world.setBlockState(new BlockPos(this.getPosX() + 1 + positionX ,this.getPosY() - 1, this.getPosZ() - 4 + positionZ), BlockInit.AKAZICE.get().getDefaultState());
		 world.setBlockState(new BlockPos(this.getPosX() - 1 + positionX ,this.getPosY() - 1, this.getPosZ() - 4 + positionZ), BlockInit.AKAZICE.get().getDefaultState());
		 
		 world.setBlockState(new BlockPos(this.getPosX() + 1 + positionX ,this.getPosY() - 1, this.getPosZ() + 1 + positionZ), BlockInit.AKAZICE.get().getDefaultState());
		 world.setBlockState(new BlockPos(this.getPosX() - 1 + positionX ,this.getPosY() - 1, this.getPosZ() - 1 + positionZ), BlockInit.AKAZICE.get().getDefaultState());
		 world.setBlockState(new BlockPos(this.getPosX() + 1 + positionX ,this.getPosY() - 1, this.getPosZ() - 1 + positionZ), BlockInit.AKAZICE.get().getDefaultState());
		 world.setBlockState(new BlockPos(this.getPosX() - 1 + positionX ,this.getPosY() - 1, this.getPosZ() + 1 + positionZ), BlockInit.AKAZICE.get().getDefaultState());
		 world.setBlockState(new BlockPos(this.getPosX() + 2 + positionX ,this.getPosY() - 1, this.getPosZ() + 2 + positionZ), BlockInit.AKAZICE.get().getDefaultState());
		 world.setBlockState(new BlockPos(this.getPosX() - 2 + positionX ,this.getPosY() - 1, this.getPosZ() - 2 + positionZ), BlockInit.AKAZICE.get().getDefaultState());
		 world.setBlockState(new BlockPos(this.getPosX() + 2 + positionX ,this.getPosY() - 1, this.getPosZ() - 2 + positionZ), BlockInit.AKAZICE.get().getDefaultState());
		 world.setBlockState(new BlockPos(this.getPosX() - 2 + positionX ,this.getPosY() - 1, this.getPosZ() + 2 + positionZ), BlockInit.AKAZICE.get().getDefaultState());
		 world.setBlockState(new BlockPos(this.getPosX() + 3 + positionX ,this.getPosY() - 1, this.getPosZ() + 3 + positionZ), BlockInit.AKAZICE.get().getDefaultState());
		 world.setBlockState(new BlockPos(this.getPosX() - 3 + positionX ,this.getPosY() - 1, this.getPosZ() - 3 + positionZ), BlockInit.AKAZICE.get().getDefaultState());
		 world.setBlockState(new BlockPos(this.getPosX() + 3 + positionX ,this.getPosY() - 1, this.getPosZ() - 3 + positionZ), BlockInit.AKAZICE.get().getDefaultState());
		 world.setBlockState(new BlockPos(this.getPosX() - 3 + positionX ,this.getPosY() - 1, this.getPosZ() + 3 + positionZ), BlockInit.AKAZICE.get().getDefaultState());
	}
	
	public void placeEyes()
	{
		this.playSound(SoundEvents.ENTITY_EVOKER_PREPARE_SUMMON, 1.0F, 1.0F);
		Random random = new Random();
		for(int i = 0; i < 15; i++)
		{
			int randX = random.nextInt(3);
			int randZ = random.nextInt(3);
			int randY = random.nextInt(3);
			
			boolean negX = random.nextBoolean();
			boolean negZ = random.nextBoolean();
			if(negX)
			{
				randX = -randX;
			}
			if(negZ)
			{
				randZ = -randZ;
			}

			world.setBlockState(new BlockPos(this.getPosX() + randX ,this.getPosY() + randY, this.getPosZ() + randZ), BlockInit.DEATH_EYES.get().getDefaultState());
		}

	}

	@Override
	public boolean attackEntityAsMob(Entity entityIn) {
		
	     if (!super.attackEntityAsMob(entityIn)) {
	         return false;
	         
	        } else {
	        	
	            if (entityIn instanceof LivingEntity) {
	                Random random = new Random();
	                int randomEyes = random.nextInt(12);
	                int randomDeadlyExplosion = random.nextInt(8);
	                
	                if(randomEyes == 0)
	                {
	                	placeEyes();
	                }
	              

	                if(randomDeadlyExplosion == 0)
	                {
	                	 if(!world.isRemote)
						 {
							 world.createExplosion(null, entityIn.getPosX(), entityIn.getPosY(), entityIn.getPosZ(), 5.0F, Explosion.Mode.NONE);
							 world.createExplosion(null, this.getPosX(), this.getPosY(), this.getPosZ(), 5.0F, Explosion.Mode.NONE);

						 }
	                }	                      
	               
	            }
	            return true;
	        }
	        
	  }
	
	@Override
	public void livingTick() {
		 if (this.isAlive()) {
			 
			 blockBreakCounter++;
			 
			 this.addPotionEffect(new EffectInstance(Effects.JUMP_BOOST, 5, 0, false, false));
			 
			 if(this.getHealth() <= this.getMaxHealth() / 2)
			 {
				 this.addPotionEffect(new EffectInstance(Effects.GLOWING, 5, 0, false, false));
			 }
			 
			 if(this.getAttackTarget() != null)
			 {
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
				 
				 if(world.getGameTime() % 1100 == 0)
				 {
					HellfireServantEntity servant = new HellfireServantEntity(NightSoulsEntityTypes.HELLFIRE_SERVANT.get(), world);
					HellfireServantEntity servant2 = new HellfireServantEntity(NightSoulsEntityTypes.HELLFIRE_SERVANT.get(), world);
					HellfireServantEntity servant3 = new HellfireServantEntity(NightSoulsEntityTypes.HELLFIRE_SERVANT.get(), world);
					
					servant.setPositionAndUpdate(this.getPosX(), this.getPosY(), this.getPosZ());
					servant2.setPositionAndUpdate(this.getPosX(), this.getPosY(), this.getPosZ());
					servant3.setPositionAndUpdate(this.getPosX(), this.getPosY(), this.getPosZ());
					
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
						 
						 if(!world.isRemote)
						 {
							 world.createExplosion(null, this.getPosX(), this.getPosY(), this.getPosZ(), 5.0F, Explosion.Mode.NONE);
						 }
						 
						 this.playSound(SoundInit.AKAZA_COMPASS.get(), 1.0F, 1.0F);
						 this.playSound(SoundEvents.ENTITY_EVOKER_PREPARE_SUMMON, 1.0F, 1.0F);
						 
						 
						 if(!world.isRemote)
						 {
							placeAkazice(0,0);			 
						 }
					 
					 }
					 if(randomAttack == 1)
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
				 
				 if(world.getGameTime() % 1200 == 0 && this.getHealth() <= this.getMaxHealth() / 2) 
				 {
					 if(!world.isRemote)
					 {
						 placeAkazice(0, 0);
						 placeAkazice(10, 0);
						 placeAkazice(-10, 0);
						 placeAkazice(0, 10);
						 placeAkazice(0, -10);
						 world.createExplosion(null, this.getPosX() + 5, this.getPosY(), this.getPosZ(), 4.0F, true, Explosion.Mode.DESTROY);
						 world.createExplosion(null, this.getPosX() - 5, this.getPosY(), this.getPosZ(), 4.0F, true, Explosion.Mode.DESTROY);
						 world.createExplosion(null, this.getPosX(), this.getPosY(), this.getPosZ() + 5, 4.0F, true, Explosion.Mode.DESTROY);
						 world.createExplosion(null, this.getPosX(), this.getPosY(), this.getPosZ() - 5, 4.0F, true, Explosion.Mode.DESTROY);
					 
					 }
					 
					 this.addPotionEffect(new EffectInstance(Effects.STRENGTH, 240, 6));
					 this.addPotionEffect(new EffectInstance(Effects.RESISTANCE, 240, 1));
					 this.addPotionEffect(new EffectInstance(Effects.SPEED, 240, 4));
				 				
					 this.playSound(SoundInit.AKAZA_EXCITED.get(), 1.0F, 1.0F);
					 this.playSound(SoundEvents.ENTITY_EVOKER_PREPARE_SUMMON, 1.0F, 1.0F);
				 } 
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
	
	@Override
	public void damageEntity(DamageSource damageSrc, float damageAmount) 
	{		
		if(this.isAlive())
		{
		  Random random = new Random();
          int randomTP = random.nextInt(24);
          
          if(randomTP == 0 && damageSrc.getTrueSource() != null)
          {
          	  this.teleportKeepLoaded(damageSrc.getTrueSource().getPosX(), damageSrc.getTrueSource().getPosY(), damageSrc.getTrueSource().getPosZ());
			  this.playSound(SoundEvents.ENTITY_ENDERMAN_TELEPORT, 1.0F, 1.0F);				 
          }
          
		  if(this.getHealth() <= this.getMaxHealth() / 2)
		  {
			  
			  int randomSpeed = random.nextInt(5);
	          int eyesAttack = random.nextInt(12);
	          int backOff = random.nextInt(12);
	          if(randomSpeed == 0)
	          {
	        	  this.addPotionEffect(new EffectInstance(Effects.SPEED, 60, 3));
	          }
	          
	          if(eyesAttack == 0)
	          {    
	        	  placeEyes();
	          }
	          
	          if(backOff == 0)
	          {
				 this.playSound(SoundInit.AKAZA_DOKE.get(), 1.0F, 1.0F);
				 
				 if(!world.isRemote)
				 {
					 world.createExplosion(null, this.getPosX(), this.getPosY(), this.getPosZ(), 7.0F, Explosion.Mode.DESTROY); 
				 }
	          }
		   }
		}
		
		super.damageEntity(damageSrc, damageAmount);
	}
		
}
