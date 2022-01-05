package com.saita.nightsoulsmod.world;

import com.saita.nightsoulsmod.init.BlockInit;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.feature.template.BlockMatchRuleTest;
import net.minecraft.world.gen.feature.template.RuleTest;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.placement.TopSolidRangeConfig;
import net.minecraftforge.common.world.BiomeGenerationSettingsBuilder;
import net.minecraftforge.event.world.BiomeLoadingEvent;

public class OreGen {
	

	public static void generateOres(final BiomeLoadingEvent event) {
		
			if (!(event.getCategory().equals(Biome.Category.NETHER) || event.getCategory().equals(Biome.Category.THEEND))) {
				generateOre(event.getGeneration(), OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD,
						BlockInit.SAITASTONE_ORE.get().getDefaultState(), 8, 1, 25, 1); // (MaxVeinSize, MinimumHeight, MaximumHeight, Rarity)
				
				generateOre(event.getGeneration(), OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD,
						BlockInit.MIIZEALITE_ORE.get().getDefaultState(), 5, 1, 25, 1); 
				
				generateOre(event.getGeneration(), OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD,
						BlockInit.CRANITE_ORE.get().getDefaultState(), 8, 1, 25, 1);
				
				generateOre(event.getGeneration(), OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD,
						BlockInit.BASTIRITE_ORE.get().getDefaultState(), 8, 1, 25, 1);
				
				generateOre(event.getGeneration(), OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD,
						BlockInit.PRIMIUM_ORE.get().getDefaultState(), 8, 1, 25, 1);
				
				generateOre(event.getGeneration(), OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD,
						BlockInit.ROWEQUITE_ORE.get().getDefaultState(), 8, 1, 25, 1);
				
				generateOre(event.getGeneration(), OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD,
						BlockInit.PRIMIUM_ORE.get().getDefaultState(), 8, 1, 25, 1);
				
				
				generateOre(event.getGeneration(), OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD,
						BlockInit.UNDERGROUND_HEART_CRYSTAL.get().getDefaultState(), 3, 1, 25, 3);
				
				generateOre(event.getGeneration(), OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD,
						BlockInit.NIGHTSOULS_EMERALD_ORE.get().getDefaultState(), 8, 1, 32, 1);
				
				generateOre(event.getGeneration(), OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD,
						BlockInit.CRAZY_DIAMOND_ORE.get().getDefaultState(), 4, 1, 17, 1);
				
				
				generateOre(event.getGeneration(), OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD,
						Blocks.IRON_BLOCK.getDefaultState(), 4, 1, 30, 2);
				
				generateOre(event.getGeneration(), OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD,
						Blocks.GOLD_BLOCK.getDefaultState(), 3, 1, 30, 2);
				
				generateOre(event.getGeneration(), OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD,
						Blocks.DIAMOND_BLOCK.getDefaultState(), 3, 1, 16, 1);
				
				generateOre(event.getGeneration(), OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD,
						Blocks.EMERALD_BLOCK.getDefaultState(), 3, 1, 16, 1);
				
				
				generateOre(event.getGeneration(), OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD,
						BlockInit.PETRIFIED_HELLSTONE.get().getDefaultState(), 5, 1, 48, 1);
				
				generateOre(event.getGeneration(), OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD,
						BlockInit.PETRIFIED_SPACESTONE.get().getDefaultState(), 5, 1, 48, 1);
				
				generateOre(event.getGeneration(), OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD,
						BlockInit.PETRIFIED_HEAVENSTONE.get().getDefaultState(), 5, 1, 48, 1);
				
				generateOre(event.getGeneration(), OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD,
						BlockInit.PETRIFIED_ANTISTONE.get().getDefaultState(), 5, 1, 48, 1);
			}
			
			if (event.getCategory().equals(Biome.Category.NETHER)) {
				
				generateOre(event.getGeneration(), OreFeatureConfig.FillerBlockType.BASE_STONE_NETHER,
						BlockInit.NETHER_MIIZEALITE_ORE.get().getDefaultState(), 8, 1, 128, 3);
			
			}
			
			if (event.getCategory().equals(Biome.Category.THEEND)) {
				
				generateOre(event.getGeneration(), new BlockMatchRuleTest(Blocks.END_STONE),
						BlockInit.TRAPPED_TRUE_NIGHT_SOUL.get().getDefaultState(), 5, 1, 78, 1);
				
				generateOre(event.getGeneration(), new BlockMatchRuleTest(Blocks.END_STONE),
						BlockInit.ENDER_HEART_CRYSTAL.get().getDefaultState(), 4, 1, 78, 3);
			}
		
		
		}

		private static void generateOre(BiomeGenerationSettingsBuilder settings, RuleTest fillerType, BlockState state,
				int veinSize, int minHeight, int maxHeight, int amount) {
			settings.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES,
					Feature.ORE.withConfiguration(new OreFeatureConfig(fillerType, state, veinSize))
							.withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(minHeight, 0, maxHeight)))
							.square().count(amount));
		}
	
}