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
import net.minecraft.world.entity.monster.Spider;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;

public class CorruptSpiderEntity extends Spider {	
	
	public CorruptSpiderEntity(EntityType<? extends Spider> p_33786_, Level p_33787_) {
		super(p_33786_, p_33787_);
		
		this.xpReward = 12;

	}
	
	public static AttributeSupplier.Builder createAttributes() {
	      return Monster.createMonsterAttributes()
	    		  .add(Attributes.MAX_HEALTH, 40.0D)
	    		  .add(Attributes.MOVEMENT_SPEED, 0.34D)	  
	    		  .add(Attributes.ATTACK_DAMAGE, 8.0D)
	    		  .add(Attributes.KNOCKBACK_RESISTANCE, 0.2D) 
	    		  .add(Attributes.FOLLOW_RANGE, 40.0D);	    			    		  
	   }
		
		
	 public static boolean canSpawn(EntityType<CorruptSpiderEntity> entityType, LevelAccessor level, MobSpawnType spawnType, BlockPos position, RandomSource random) {
	        return HardmodeRequiemFunctions.isHardmode((ServerLevel)level);
	 }

}
