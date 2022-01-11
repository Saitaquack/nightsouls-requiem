package com.saita.nightsoulsmod.world;

import net.minecraft.entity.EntityType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.MobSpawnInfo;
import net.minecraftforge.common.world.MobSpawnInfoBuilder;
import net.minecraftforge.event.world.BiomeLoadingEvent;

import java.util.List;

import com.saita.nightsoulsmod.init.NightSoulsEntityTypes;

public class NightSoulsEntitySpawn {
	
	  public static void onEntitySpawn(final BiomeLoadingEvent event) {
		  
		  if(!(event.getCategory().equals(Biome.Category.NETHER) || event.getCategory().equals(Biome.Category.THEEND) ||
		     event.getCategory().equals(Biome.Category.OCEAN) || event.getCategory().equals(Biome.Category.MUSHROOM)))
		  {
		  
			  addEntity(event.getSpawns(), NightSoulsEntityTypes.REAPER.get(), 4, 1, 5);
			  addEntity(event.getSpawns(), NightSoulsEntityTypes.WEREWOLF.get(), 4, 1, 5);
			  addEntity(event.getSpawns(), NightSoulsEntityTypes.FACE_MONSTER.get(), 4, 1, 5);
			  
			  addEntity(event.getSpawns(), NightSoulsEntityTypes.PSYCHO.get(), 4, 1, 4);
			  addEntity(event.getSpawns(), NightSoulsEntityTypes.DEMON_EYE.get(), 4, 1, 4);
		  
		  }
		  
		  if(event.getCategory().equals(Biome.Category.NETHER))
		    {
				  
			    addEntity(event.getSpawns(), NightSoulsEntityTypes.HELLBORN.get(), 2, 1, 6);
			    addEntity(event.getSpawns(), NightSoulsEntityTypes.REAPER.get(), 1, 1, 4);
			    addEntity(event.getSpawns(), NightSoulsEntityTypes.PSYCHO.get(), 1, 1, 3);
				  
		    }
		  
	    }		
		
		private static void addEntity(MobSpawnInfoBuilder spawns, EntityType<?> type,
		   int weight, int minCount, int maxCount) {
		List<MobSpawnInfo.Spawners> base = spawns.getSpawner(type.getClassification());
		base.add(new MobSpawnInfo.Spawners(type,weight, minCount, maxCount));
		}
}