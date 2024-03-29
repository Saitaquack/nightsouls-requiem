package com.saita.nightsoulsmod.init;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.saita.nightsoulsmod.NightSoulsMod;
import com.saita.nightsoulsmod.world.StructuresConstants;
import com.saita.nightsoulsmod.world.structures.*;

import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.structure.Structure;
import net.minecraft.world.gen.settings.DimensionStructuresSettings;
import net.minecraft.world.gen.settings.StructureSeparationSettings;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.HashMap;
import java.util.Map;

public class StructureInit {
	
	public static final DeferredRegister<Structure<?>> STRUCTURES =
            DeferredRegister.create(ForgeRegistries.STRUCTURE_FEATURES, NightSoulsMod.MOD_ID);

    public static final RegistryObject<Structure<NoFeatureConfig>> NIGHTSOULS_CAMP = STRUCTURES.register("nightsouls_camp", NightSoulsCampStructure::new);
    public static final RegistryObject<Structure<NoFeatureConfig>> NIGHTSOULS_HOUSE = STRUCTURES.register("nightsouls_house", NightSoulsHouseStructure::new);
    public static final RegistryObject<Structure<NoFeatureConfig>> CRANE_BATTLE_TOWER = STRUCTURES.register("crane_battle_tower", CraneBattleTowerStructure::new);
    public static final RegistryObject<Structure<NoFeatureConfig>> DRAGON_FOSSIL = STRUCTURES.register("dragon_fossil", DragonFossilStructure::new);
    public static final RegistryObject<Structure<NoFeatureConfig>> CRANE_FORGE = STRUCTURES.register("crane_forge", CraneForgeStructure::new);
    public static final RegistryObject<Structure<NoFeatureConfig>> DRAGON_FORGE = STRUCTURES.register("dragon_forge", DragonForgeStructure::new);
    public static final RegistryObject<Structure<NoFeatureConfig>> MIIZEAL_ALTAR = STRUCTURES.register("miizeal_altar", MiizealAltarStructure::new);
    public static final RegistryObject<Structure<NoFeatureConfig>> SAITA_FLOATING_ISLAND = STRUCTURES.register("saita_floating_island", SaitaFloatingIslandStructure::new);
    public static final RegistryObject<Structure<NoFeatureConfig>> NIGHTSOULS_TEMPLE = STRUCTURES.register("nightsouls_temple", NightSoulsTempleStructure::new);
    public static final RegistryObject<Structure<NoFeatureConfig>> NIGHTSOULS_TOWER = STRUCTURES.register("nightsouls_tower", NightSoulsTowerStructure::new);
    public static final RegistryObject<Structure<NoFeatureConfig>> NIGHTSOULS_TOWER_ISLAND = STRUCTURES.register("nightsouls_tower_island", NightSoulsTowerIslandStructure::new);
    public static final RegistryObject<Structure<NoFeatureConfig>> NIGHTSOULS_BARN = STRUCTURES.register("nightsouls_barn", NightSoulsBarnStructure::new);
    public static final RegistryObject<Structure<NoFeatureConfig>> NIGHTSOULS_MANSION = STRUCTURES.register("nightsouls_mansion", NightSoulsMansionStructure::new);
    public static final RegistryObject<Structure<NoFeatureConfig>> SKY_BASE = STRUCTURES.register("sky_base", SkyBaseStructure::new);
    public static final RegistryObject<Structure<NoFeatureConfig>> A_NORMAL_CHURCH = STRUCTURES.register("a_normal_church", ANormalChurchStructure::new);
    public static final RegistryObject<Structure<NoFeatureConfig>> A_NORMAL_VILLAGE = STRUCTURES.register("a_normal_village", ANormalVillageStructure::new);
    public static final RegistryObject<Structure<NoFeatureConfig>> NIGHTSOULS_ISLANDS = STRUCTURES.register("nightsouls_islands", NightSoulsIslandsStructure::new);
    public static final RegistryObject<Structure<NoFeatureConfig>> GRAVEYARD = STRUCTURES.register("graveyard", GraveyardStructure::new);
    public static final RegistryObject<Structure<NoFeatureConfig>> BASTI_LAB = STRUCTURES.register("basti_lab", BastiLabStructure::new);
    public static final RegistryObject<Structure<NoFeatureConfig>> FREDDY_FAZBEAR_PIZZA = STRUCTURES.register("freddy_fazbear_pizza", FreddyFazbearPizzaStructure::new);
    public static final RegistryObject<Structure<NoFeatureConfig>> WEREWOLF_CAVE = STRUCTURES.register("werewolf_cave", WerewolfCaveStructure::new);
    public static final RegistryObject<Structure<NoFeatureConfig>> ROCKET = STRUCTURES.register("rocket", RocketStructure::new);
    public static final RegistryObject<Structure<NoFeatureConfig>> DECUBE_HOUSE = STRUCTURES.register("decube_house", DecubeHouseStructure::new);
    public static final RegistryObject<Structure<NoFeatureConfig>> DECUBE_HOUSE2 = STRUCTURES.register("decube_house2", DecubeHouse2Structure::new);
    public static final RegistryObject<Structure<NoFeatureConfig>> ODYSSEY_TOP = STRUCTURES.register("odyssey_top", OdysseyTopStructure::new);
    public static final RegistryObject<Structure<NoFeatureConfig>> ODYSSEY_BOTTOM = STRUCTURES.register("odyssey_bottom", OdysseyBottomStructure::new);
    public static final RegistryObject<Structure<NoFeatureConfig>> DRAGON_STATUE_TOP = STRUCTURES.register("dragon_statue_top", DragonStatueTopStructure::new);
    public static final RegistryObject<Structure<NoFeatureConfig>> DRAGON_STATUE_BOTTOM = STRUCTURES.register("dragon_statue_bottom", DragonStatueBottomStructure::new);
    public static final RegistryObject<Structure<NoFeatureConfig>> BACKROOMS = STRUCTURES.register("backrooms", BackroomsStructure::new);
    public static final RegistryObject<Structure<NoFeatureConfig>> UNDERGROUND_CITY = STRUCTURES.register("underground_city", UndergroundCityStructure::new);
    public static final RegistryObject<Structure<NoFeatureConfig>> PALADIN_HILL = STRUCTURES.register("paladin_hill", PaladinHillStructure::new);
    public static final RegistryObject<Structure<NoFeatureConfig>> NIGHTSOULS_FINAL_CASTLE = STRUCTURES.register("nightsouls_final_castle", NightSoulsFinalCastle::new);
    public static final RegistryObject<Structure<NoFeatureConfig>> RED_BACKROOMS = STRUCTURES.register("red_backrooms", RedBackroomsStructure::new);
    public static final RegistryObject<Structure<NoFeatureConfig>> POOLROOMS = STRUCTURES.register("poolrooms", PoolroomsStructure::new);
    public static final RegistryObject<Structure<NoFeatureConfig>> BREAKING_BAD_VAN = STRUCTURES.register("breaking_bad_van", BreakingBadVanStructure::new);
    
    
    public static final RegistryObject<Structure<NoFeatureConfig>> BACKROOMS_LANDMARK = STRUCTURES.register("backrooms_landmark", BackroomsLandmarkStructure::new);
    public static final RegistryObject<Structure<NoFeatureConfig>> RED_BACKROOMS_LANDMARK = STRUCTURES.register("red_backrooms_landmark", RedBackroomsLandmarkStructure::new);
    public static final RegistryObject<Structure<NoFeatureConfig>> POOLROOMS_LANDMARK = STRUCTURES.register("poolrooms_landmark", PoolroomsLandmarkStructure::new);

  
    public static final RegistryObject<Structure<NoFeatureConfig>> PARAGONIC_CORE = STRUCTURES.register("paraconic_core", ParagonicCoreStructure::new);
    public static final RegistryObject<Structure<NoFeatureConfig>> SAITA_LOOT_ROOM = STRUCTURES.register("saita_loot_room", SaitaLootRoomStructure::new);
    public static final RegistryObject<Structure<NoFeatureConfig>> MIIZEAL_LOOT_ROOM = STRUCTURES.register("miizeal_loot_room", MiizealLootRoomStructure::new);
    public static final RegistryObject<Structure<NoFeatureConfig>> CRANE_LOOT_ROOM = STRUCTURES.register("crane_loot_room", CraneLootRoomStructure::new);
    public static final RegistryObject<Structure<NoFeatureConfig>> BASTI_LOOT_ROOM = STRUCTURES.register("basti_loot_room", BastiLootRoomStructure::new); 
    public static final RegistryObject<Structure<NoFeatureConfig>> CELESTIAL_EMERALD = STRUCTURES.register("celestial_emerald", CelestialEmeraldStructure::new);
    public static final RegistryObject<Structure<NoFeatureConfig>> POWER_MOON = STRUCTURES.register("power_moon", PowerMoonStructure::new);
    public static final RegistryObject<Structure<NoFeatureConfig>> AKAZA_ARENA = STRUCTURES.register("akaza_arena", AkazaArenaStructure::new);



    /* average distance apart in chunks between spawn attempts */
    /* minimum distance apart in chunks between spawn attempts. MUST BE LESS THAN ABOVE VALUE*/
    /* this modifies the seed of the structure so no two structures always spawn over each-other.
    Make this large and unique. */
    public static void setupStructures() {
        setupMapSpacingAndLand(NIGHTSOULS_CAMP.get(), new StructureSeparationSettings(StructuresConstants.commonMax, StructuresConstants.commonMin, 134218728), true);
        setupMapSpacingAndLand(NIGHTSOULS_HOUSE.get(), new StructureSeparationSettings(StructuresConstants.mediumMax, StructuresConstants.mediumMin, 134217728), true);
        setupMapSpacingAndLand(CRANE_BATTLE_TOWER.get(), new StructureSeparationSettings(StructuresConstants.rareMax, StructuresConstants.rareMin, 134217723), true);
        setupMapSpacingAndLand(DRAGON_FOSSIL.get(), new StructureSeparationSettings(StructuresConstants.mediumMax, StructuresConstants.mediumMin, 134217713), false);
        setupMapSpacingAndLand(CRANE_FORGE.get(), new StructureSeparationSettings(StructuresConstants.rareMax, StructuresConstants.rareMin, 1343271914), true);
        setupMapSpacingAndLand(DRAGON_FORGE.get(), new StructureSeparationSettings(StructuresConstants.rareMax, StructuresConstants.rareMin, 1343272014), true);
        setupMapSpacingAndLand(MIIZEAL_ALTAR.get(), new StructureSeparationSettings(StructuresConstants.mediumMax, StructuresConstants.mediumMin, 666666666), true);
        setupMapSpacingAndLand(SAITA_FLOATING_ISLAND.get(), new StructureSeparationSettings(StructuresConstants.mediumMax, StructuresConstants.mediumMin, 134217792), false);
        setupMapSpacingAndLand(NIGHTSOULS_TEMPLE.get(), new StructureSeparationSettings(StructuresConstants.nsMax, StructuresConstants.nsMin, 134327928), false);
        setupMapSpacingAndLand(NIGHTSOULS_TOWER.get(), new StructureSeparationSettings(StructuresConstants.nsMax, StructuresConstants.nsMin, StructuresConstants.castleSeed), false);
        setupMapSpacingAndLand(NIGHTSOULS_TOWER_ISLAND.get(), new StructureSeparationSettings(StructuresConstants.nsMax, StructuresConstants.nsMin, StructuresConstants.castleSeed), false);
        setupMapSpacingAndLand(NIGHTSOULS_BARN.get(), new StructureSeparationSettings(StructuresConstants.mediumMax, StructuresConstants.mediumMin, 1344321928), true);
        setupMapSpacingAndLand(NIGHTSOULS_MANSION.get(), new StructureSeparationSettings(StructuresConstants.rarerMax, StructuresConstants.rarerMin, 143227728), false);
        setupMapSpacingAndLand(SKY_BASE.get(), new StructureSeparationSettings(StructuresConstants.rarerMax, StructuresConstants.rarerMin, 136328728), false);
        setupMapSpacingAndLand(A_NORMAL_CHURCH.get(), new StructureSeparationSettings(StructuresConstants.rarerMax, StructuresConstants.rarerMin, 1445666999), false);
        setupMapSpacingAndLand(A_NORMAL_VILLAGE.get(), new StructureSeparationSettings(StructuresConstants.rarerMax, StructuresConstants.rarerMin, 145109928), false);
        setupMapSpacingAndLand(NIGHTSOULS_ISLANDS.get(), new StructureSeparationSettings(StructuresConstants.nsMax, StructuresConstants.nsMin, 158639571), false);
        setupMapSpacingAndLand(GRAVEYARD.get(), new StructureSeparationSettings(StructuresConstants.rarerMax, StructuresConstants.rarerMin, 1346662014), false);
        setupMapSpacingAndLand(BASTI_LAB.get(), new StructureSeparationSettings(StructuresConstants.rarerMax, StructuresConstants.rarerMin, 134218228), true);
        setupMapSpacingAndLand(FREDDY_FAZBEAR_PIZZA.get(), new StructureSeparationSettings(StructuresConstants.rarerMax, StructuresConstants.rarerMin, 19871987), false);
        setupMapSpacingAndLand(WEREWOLF_CAVE.get(), new StructureSeparationSettings(StructuresConstants.rareMax, StructuresConstants.rareMin, 676717723), true);
        setupMapSpacingAndLand(ROCKET.get(), new StructureSeparationSettings(StructuresConstants.mediumMax, StructuresConstants.mediumMin, 134367777), true);
        setupMapSpacingAndLand(DECUBE_HOUSE.get(), new StructureSeparationSettings(StructuresConstants.mediumMax, StructuresConstants.mediumMin, 934256728), false);
        setupMapSpacingAndLand(DECUBE_HOUSE2.get(), new StructureSeparationSettings(StructuresConstants.rareMax, StructuresConstants.rareMin, 934256722), false);
        setupMapSpacingAndLand(ODYSSEY_TOP.get(), new StructureSeparationSettings(StructuresConstants.rarerMax, StructuresConstants.rarerMin, StructuresConstants.odysseySeed), false);
        setupMapSpacingAndLand(ODYSSEY_BOTTOM.get(), new StructureSeparationSettings(StructuresConstants.rarerMax, StructuresConstants.rarerMin, StructuresConstants.odysseySeed), false);
        setupMapSpacingAndLand(DRAGON_STATUE_TOP.get(), new StructureSeparationSettings(StructuresConstants.rarerMax, StructuresConstants.rarerMin, StructuresConstants.dragonStatueSeed), false);
        setupMapSpacingAndLand(DRAGON_STATUE_BOTTOM.get(), new StructureSeparationSettings(StructuresConstants.rarerMax, StructuresConstants.rarerMin, StructuresConstants.dragonStatueSeed), false);
        setupMapSpacingAndLand(UNDERGROUND_CITY.get(), new StructureSeparationSettings(StructuresConstants.rareMax, StructuresConstants.rareMin, 972366482), false);
        setupMapSpacingAndLand(PALADIN_HILL.get(), new StructureSeparationSettings(StructuresConstants.rarerMax, StructuresConstants.rarerMin, 688386482), true);
        setupMapSpacingAndLand(NIGHTSOULS_FINAL_CASTLE.get(), new StructureSeparationSettings(StructuresConstants.nsMax + 30, StructuresConstants.nsMin + 30, 1237568882), false);   
        setupMapSpacingAndLand(BREAKING_BAD_VAN.get(), new StructureSeparationSettings(StructuresConstants.commonMax, StructuresConstants.commonMin, 218511191 ), true);
        
        setupMapSpacingAndLand(BACKROOMS.get(), new StructureSeparationSettings(StructuresConstants.backroomsMax, StructuresConstants.backroomsMin, StructuresConstants.backroomsSeed), false);
        setupMapSpacingAndLand(BACKROOMS_LANDMARK.get(), new StructureSeparationSettings(StructuresConstants.backroomsMax, StructuresConstants.backroomsMin, StructuresConstants.backroomsSeed), false);
        setupMapSpacingAndLand(RED_BACKROOMS.get(), new StructureSeparationSettings(StructuresConstants.backroomsMax, StructuresConstants.backroomsMin, StructuresConstants.redBackroomsSeed), false);
        setupMapSpacingAndLand(RED_BACKROOMS_LANDMARK.get(), new StructureSeparationSettings(StructuresConstants.backroomsMax, StructuresConstants.backroomsMin, StructuresConstants.redBackroomsSeed), false);
        setupMapSpacingAndLand(POOLROOMS.get(), new StructureSeparationSettings(StructuresConstants.backroomsMax, StructuresConstants.backroomsMin, StructuresConstants.poolroomsSeed), false);
        setupMapSpacingAndLand(POOLROOMS_LANDMARK.get(), new StructureSeparationSettings(StructuresConstants.backroomsMax, StructuresConstants.backroomsMin, StructuresConstants.poolroomsSeed), false);
           
        setupMapSpacingAndLand(PARAGONIC_CORE.get(), new StructureSeparationSettings(StructuresConstants.nsMax + 30, StructuresConstants.nsMin + 30, 122377928), true);
        setupMapSpacingAndLand(SAITA_LOOT_ROOM.get(), new StructureSeparationSettings(16, 8, 166656), false);
        setupMapSpacingAndLand(MIIZEAL_LOOT_ROOM.get(), new StructureSeparationSettings(16, 8, 266656), false);
        setupMapSpacingAndLand(CRANE_LOOT_ROOM.get(), new StructureSeparationSettings(16, 8, 366656), false);
        setupMapSpacingAndLand(BASTI_LOOT_ROOM.get(), new StructureSeparationSettings(16, 8, 466656), false);
        setupMapSpacingAndLand(CELESTIAL_EMERALD.get(), new StructureSeparationSettings(45, 10, 268435446), false);
        setupMapSpacingAndLand(POWER_MOON.get(), new StructureSeparationSettings(14, 4, 178509578), false);
        setupMapSpacingAndLand(AKAZA_ARENA.get(), new StructureSeparationSettings(StructuresConstants.rarerMax + 20, StructuresConstants.rarerMin + 20, 88666666), true);


    }


    public static <F extends Structure<?>> void setupMapSpacingAndLand(F structure, StructureSeparationSettings structureSeparationSettings,
                                                                       boolean transformSurroundingLand) {
    	
        Structure.NAME_STRUCTURE_BIMAP.put(structure.getRegistryName().toString(), structure);

        if (transformSurroundingLand) {
            Structure.field_236384_t_ = ImmutableList.<Structure<?>>builder()
                    .addAll(Structure.field_236384_t_)
                    .add(structure)
                    .build();
        }


        DimensionStructuresSettings.field_236191_b_ =
                ImmutableMap.<Structure<?>, StructureSeparationSettings>builder()
                        .putAll(DimensionStructuresSettings.field_236191_b_)
                        .put(structure, structureSeparationSettings)
                        .build();


        WorldGenRegistries.NOISE_SETTINGS.getEntries().forEach(settings -> {
            Map<Structure<?>, StructureSeparationSettings> structureMap =
                    settings.getValue().getStructures().func_236195_a_();

            if (structureMap instanceof ImmutableMap) {
                Map<Structure<?>, StructureSeparationSettings> tempMap = new HashMap<>(structureMap);
                tempMap.put(structure, structureSeparationSettings);
                settings.getValue().getStructures().func_236195_a_();

            } else {
                structureMap.put(structure, structureSeparationSettings);
            }
        });
    }

    public static void register(IEventBus eventBus) {
        STRUCTURES.register(eventBus);
    }

}
