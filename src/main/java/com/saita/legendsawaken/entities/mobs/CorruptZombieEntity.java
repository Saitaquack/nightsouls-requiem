package com.saita.legendsawaken.entities.mobs;

import com.saita.legendsawaken.util.HardmodeRequiemFunctions;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;

public class CorruptZombieEntity extends Zombie {

	public CorruptZombieEntity(EntityType<? extends Zombie> p_34271_, Level p_34272_) {
		super(p_34271_, p_34272_);
		
		this.xpReward = 12;
	}
	
	public static AttributeSupplier.Builder createAttributes() {
	      return Monster.createMonsterAttributes()
	    		  .add(Attributes.MAX_HEALTH, 45.0D)
	    		  .add(Attributes.MOVEMENT_SPEED, 0.30D)	  
	    		  .add(Attributes.ATTACK_DAMAGE, 9.0D)
	    		  .add(Attributes.KNOCKBACK_RESISTANCE, 0.2D) 
	    		  .add(Attributes.FOLLOW_RANGE, 40.0D)	    			    		  
	    		  .add(Attributes.ARMOR, 2.0D)
	    		  .add(Attributes.SPAWN_REINFORCEMENTS_CHANCE);
	   }
		
		
	 public static boolean canSpawn(EntityType<CorruptZombieEntity> entityType, LevelAccessor level, MobSpawnType spawnType, BlockPos position, RandomSource random) {
	        return HardmodeRequiemFunctions.isHardmode((ServerLevel)level);
	 }

}
