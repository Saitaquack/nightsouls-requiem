package com.saita.nightsoulsmod.world;

import net.minecraft.util.RegistryKey;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.StructureFeature;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.event.world.BiomeLoadingEvent;

import java.util.List;
import java.util.Set;
import java.util.function.Supplier;

import com.saita.nightsoulsmod.init.StructureInit;

public class StructureGen {
	
	 public static void generateStructures(final BiomeLoadingEvent event) {
	        RegistryKey<Biome> key = RegistryKey.getOrCreateKey(Registry.BIOME_KEY, event.getName());
	        Set<BiomeDictionary.Type> types = BiomeDictionary.getTypes(key);
	        
	        //Partout, sauf Océan

	        if(types.contains(BiomeDictionary.Type.OVERWORLD) && !types.contains(BiomeDictionary.Type.OCEAN)) {
	            List<Supplier<StructureFeature<?, ?>>> structures = event.getGeneration().getStructures();

	            structures.add(() -> StructureInit.NIGHTSOULS_CAMP.get().withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG));
	            structures.add(() -> StructureInit.NIGHTSOULS_HOUSE.get().withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG));
	            structures.add(() -> StructureInit.CRANE_BATTLE_TOWER.get().withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG));
	            structures.add(() -> StructureInit.DRAGON_FOSSIL.get().withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG));
	            structures.add(() -> StructureInit.CRANE_FORGE.get().withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG));
	            structures.add(() -> StructureInit.DRAGON_FORGE.get().withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG));
	            structures.add(() -> StructureInit.MIIZEAL_ALTAR.get().withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG));
	            structures.add(() -> StructureInit.NIGHTSOULS_TEMPLE.get().withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG));
	            structures.add(() -> StructureInit.NIGHTSOULS_BARN.get().withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG));
	            structures.add(() -> StructureInit.NIGHTSOULS_MANSION.get().withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG));
	            structures.add(() -> StructureInit.A_NORMAL_CHURCH.get().withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG));
	            structures.add(() -> StructureInit.GRAVEYARD.get().withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG));
	            structures.add(() -> StructureInit.BASTI_LAB.get().withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG));
	            structures.add(() -> StructureInit.BASTI_FARM.get().withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG));
	            structures.add(() -> StructureInit.FREDDY_FAZBEAR_PIZZA.get().withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG));
	            structures.add(() -> StructureInit.WEREWOLF_CAVE.get().withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG));
	            structures.add(() -> StructureInit.MELDYA_LAKE.get().withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG));
	            structures.add(() -> StructureInit.ROCKET.get().withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG));
	            structures.add(() -> StructureInit.DECUBE_HOUSE.get().withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG));
	            structures.add(() -> StructureInit.DECUBE_HOUSE2.get().withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG));
	            structures.add(() -> StructureInit.DRAGON_STATUE_BOTTOM.get().withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG));
	            structures.add(() -> StructureInit.DRAGON_STATUE_TOP.get().withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG));
	            structures.add(() -> StructureInit.BACKROOMS.get().withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG));
	            structures.add(() -> StructureInit.PALADIN_HILL.get().withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG));

	            structures.add(() -> StructureInit.PARAGONIC_CORE.get().withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG));
	            structures.add(() -> StructureInit.LUCKY_BLOCK.get().withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG));
	            structures.add(() -> StructureInit.CELESTIAL_EMERALD.get().withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG));
	            structures.add(() -> StructureInit.POWER_MOON.get().withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG));
	            structures.add(() -> StructureInit.AKAZA_ARENA.get().withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG));

	        }
	        
	        //Partout
	        
	        if(types.contains(BiomeDictionary.Type.OVERWORLD)) {
	            List<Supplier<StructureFeature<?, ?>>> structures = event.getGeneration().getStructures();

	            structures.add(() -> StructureInit.SAITA_FLOATING_ISLAND.get().withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG));
	            structures.add(() -> StructureInit.NIGHTSOULS_FINAL_CASTLE.get().withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG));
	            structures.add(() -> StructureInit.NIGHTSOULS_FINAL_CASTLE_ISLAND.get().withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG));
	            structures.add(() -> StructureInit.SKY_BASE.get().withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG));
	            structures.add(() -> StructureInit.NIGHTSOULS_ISLANDS.get().withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG));
	            structures.add(() -> StructureInit.ODYSSEY_BOTTOM.get().withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG));
	            structures.add(() -> StructureInit.ODYSSEY_TOP.get().withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG));
	            
	            structures.add(() -> StructureInit.SAITA_LOOT_ROOM.get().withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG));
	            structures.add(() -> StructureInit.MIIZEAL_LOOT_ROOM.get().withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG));
	            structures.add(() -> StructureInit.CRANE_LOOT_ROOM.get().withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG));
	            structures.add(() -> StructureInit.BASTI_LOOT_ROOM.get().withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG));
	        }
	        
	        //Plaines
	        
	        if(types.contains(BiomeDictionary.Type.PLAINS)) {
	            List<Supplier<StructureFeature<?, ?>>> structures = event.getGeneration().getStructures();

	            structures.add(() -> StructureInit.A_NORMAL_VILLAGE.get().withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG));
	
	        }
	        
	        if(types.contains(BiomeDictionary.Type.PLAINS) || types.contains(BiomeDictionary.Type.FOREST) || types.contains(BiomeDictionary.Type.SNOWY)) {
	            List<Supplier<StructureFeature<?, ?>>> structures = event.getGeneration().getStructures();

	            structures.add(() -> StructureInit.UNDERGROUND_CITY.get().withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG));
	
	        }
	        
	    }

}
