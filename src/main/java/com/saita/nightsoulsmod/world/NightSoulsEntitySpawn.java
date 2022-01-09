package com.saita.nightsoulsmod.world;

import net.minecraft.entity.EntityType;
import net.minecraft.world.biome.MobSpawnInfo;
import net.minecraftforge.common.world.MobSpawnInfoBuilder;
import net.minecraftforge.event.world.BiomeLoadingEvent;

import java.util.List;

import com.saita.nightsoulsmod.init.NightSoulsEntityTypes;

public class NightSoulsEntitySpawn {
	
	  public static void onEntitySpawn(final BiomeLoadingEvent event) {
	        addEntityToAllBiomes(event.getSpawns(), NightSoulsEntityTypes.REAPER.get(), 8, 1, 5);
	    }

	    private static void addEntityToAllBiomes(MobSpawnInfoBuilder spawns, EntityType<?> type,
	                                             int weight, int minCount, int maxCount) {
	        List<MobSpawnInfo.Spawners> base = spawns.getSpawner(type.getClassification());
	        base.add(new MobSpawnInfo.Spawners(type,weight, minCount, maxCount));
	    }

}
