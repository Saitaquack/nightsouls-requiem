package com.saita.nightsoulsmod.init;

import com.saita.nightsoulsmod.NightSoulsMod;
import com.saita.nightsoulsmod.entities.entity.*;
import com.saita.nightsoulsmod.entities.entity.projectiles.*;

import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class NightSoulsEntityTypes {
	
	 public static DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITIES ,NightSoulsMod.MOD_ID);
	 

	 public static final RegistryObject<EntityType<ReaperEntity>> REAPER =
	          ENTITY_TYPES.register("reaper", () -> EntityType.Builder
	            	.create(ReaperEntity::new, EntityClassification.MONSTER).size(0.6F, 1.95F)
	            	.immuneToFire()
	                .build(new ResourceLocation(NightSoulsMod.MOD_ID, "reaper").toString()));
	 

	 public static final RegistryObject<EntityType<WerewolfEntity>> WEREWOLF =
	          ENTITY_TYPES.register("werewolf", () -> EntityType.Builder
	            	.create(WerewolfEntity::new, EntityClassification.MONSTER).size(0.6F, 1.95F)
	                .build(new ResourceLocation(NightSoulsMod.MOD_ID, "werewolf").toString()));
	 
	 public static final RegistryObject<EntityType<PsychoEntity>> PSYCHO =
	          ENTITY_TYPES.register("psycho", () -> EntityType.Builder
	            	.create(PsychoEntity::new, EntityClassification.MONSTER).size(0.6F, 1.95F)
	            	.immuneToFire()
	                .build(new ResourceLocation(NightSoulsMod.MOD_ID, "psycho").toString()));
	 
	 public static final RegistryObject<EntityType<FaceMonsterEntity>> FACE_MONSTER =
	          ENTITY_TYPES.register("face_monster", () -> EntityType.Builder
	            	.create(FaceMonsterEntity::new, EntityClassification.MONSTER).size(0.6F, 1.95F)
	                .build(new ResourceLocation(NightSoulsMod.MOD_ID, "face_monster").toString()));
	 
	 public static final RegistryObject<EntityType<HellbornEntity>> HELLBORN =
	          ENTITY_TYPES.register("hellborn", () -> EntityType.Builder
	            	.create(HellbornEntity::new, EntityClassification.MONSTER).size(0.6F, 1.95F)
	            	.immuneToFire()
	                .build(new ResourceLocation(NightSoulsMod.MOD_ID, "hellborn").toString()));
	 
	 public static final RegistryObject<EntityType<DemonEyeEntity>> DEMON_EYE =
	          ENTITY_TYPES.register("demon_eye", () -> EntityType.Builder
	            	.create(DemonEyeEntity::new, EntityClassification.MONSTER).size(0.9F, 1.0F)
	                .build(new ResourceLocation(NightSoulsMod.MOD_ID, "demon_eye").toString()));
	 
	 public static final RegistryObject<EntityType<AlternateEntity>> ALTERNATE =
	          ENTITY_TYPES.register("alternate", () -> EntityType.Builder
	            	.create(AlternateEntity::new, EntityClassification.MONSTER).size(1.2F, 4.95F)
	                .build(new ResourceLocation(NightSoulsMod.MOD_ID, "alternate").toString()));
	 
	 
	 
	 public static final RegistryObject<EntityType<StargazerEntity>> STARGAZER =
	          ENTITY_TYPES.register("stargazer", () -> EntityType.Builder
	            	.create(StargazerEntity::new, EntityClassification.MONSTER).size(0.6F, 1.95F)
	                .build(new ResourceLocation(NightSoulsMod.MOD_ID, "stargazer").toString()));
	 
	 public static final RegistryObject<EntityType<HellfireServantEntity>> HELLFIRE_SERVANT =
	          ENTITY_TYPES.register("hellfire_servant", () -> EntityType.Builder
	            	.create(HellfireServantEntity::new, EntityClassification.MONSTER).size(0.6F, 1.95F)
	                .build(new ResourceLocation(NightSoulsMod.MOD_ID, "hellfire_servant").toString()));
	 
	 public static final RegistryObject<EntityType<PaladinEntity>> PALADIN =
	          ENTITY_TYPES.register("paladin", () -> EntityType.Builder
	            	.create(PaladinEntity::new, EntityClassification.MONSTER).size(0.6F, 1.95F)
	                .build(new ResourceLocation(NightSoulsMod.MOD_ID, "paladin").toString()));
	 
	 public static final RegistryObject<EntityType<RealityWalkerEntity>> REALITY_WALKER =
	          ENTITY_TYPES.register("reality_walker", () -> EntityType.Builder
	            	.create(RealityWalkerEntity::new, EntityClassification.MONSTER).size(0.6F, 1.95F)
	                .build(new ResourceLocation(NightSoulsMod.MOD_ID, "reality_walker").toString()));
	 
	 public static final RegistryObject<EntityType<TitanEntity>> TITAN =
	          ENTITY_TYPES.register("titan", () -> EntityType.Builder
	            	.create(TitanEntity::new, EntityClassification.MONSTER).size(2.2F, 11.7F)
	                .build(new ResourceLocation(NightSoulsMod.MOD_ID, "titan").toString()));
	 
	 
	 
	 public static final RegistryObject<EntityType<AkazaEntity>> AKAZA =
	          ENTITY_TYPES.register("akaza", () -> EntityType.Builder
	            	.create(AkazaEntity::new, EntityClassification.MONSTER).size(0.6F, 1.95F)
	            	.immuneToFire()
	                .build(new ResourceLocation(NightSoulsMod.MOD_ID, "akaza").toString()));
	 
	 public static final RegistryObject<EntityType<EyeOfCthulhuEntity>> EYE_OF_CTHULHU =
	          ENTITY_TYPES.register("eye_of_cthulhu", () -> EntityType.Builder
	            	.create(EyeOfCthulhuEntity::new, EntityClassification.MONSTER).size(1.5F, 2.0F)
	                .build(new ResourceLocation(NightSoulsMod.MOD_ID, "eye_of_cthulhu").toString()));
	 
	 public static final RegistryObject<EntityType<KingCrimsonEntity>> KING_CRIMSON =
	          ENTITY_TYPES.register("king_crimson", () -> EntityType.Builder
	            	.create(KingCrimsonEntity::new, EntityClassification.MONSTER).size(0.6F, 1.95F)
	                .build(new ResourceLocation(NightSoulsMod.MOD_ID, "king_crimson").toString())); 
	 
	 
	 
	 public static final RegistryObject<EntityType<TechnoProjEntity>> TECHNO_PROJ = ENTITY_TYPES.register("techno_proj", 
				() -> EntityType.Builder.<TechnoProjEntity>create(TechnoProjEntity::new, EntityClassification.MISC).size(0.3F, 0.3F).build("techno_proj"));
	 
	 public static final RegistryObject<EntityType<EmeraldProjEntity>> EMERALD_PROJ = ENTITY_TYPES.register("emerald_proj", 
				() -> EntityType.Builder.<EmeraldProjEntity>create(EmeraldProjEntity::new, EntityClassification.MISC).size(0.3F, 0.3F).build("emerald_proj"));
	 
	 public static final RegistryObject<EntityType<LaserProjEntity>> LASER_PROJ = ENTITY_TYPES.register("laser_proj", 
				() -> EntityType.Builder.<LaserProjEntity>create(LaserProjEntity::new, EntityClassification.MISC).size(0.3F, 0.3F).build("laser_proj"));
	 
	 public static final RegistryObject<EntityType<PlasmaProjEntity>> PLASMA_PROJ = ENTITY_TYPES.register("plasma_proj", 
				() -> EntityType.Builder.<PlasmaProjEntity>create(PlasmaProjEntity::new, EntityClassification.MISC).size(0.3F, 0.3F).build("plasma_proj"));
	 
	 public static final RegistryObject<EntityType<SunProjEntity>> SUN_PROJ = ENTITY_TYPES.register("sun_proj", 
				() -> EntityType.Builder.<SunProjEntity>create(SunProjEntity::new, EntityClassification.MISC).size(0.3F, 0.3F).build("sun_proj"));
	 
	 public static final RegistryObject<EntityType<CyberShurikenProjEntity>> CYBER_SHURIKEN_PROJ = ENTITY_TYPES.register("cyber_shuriken_proj", 
				() -> EntityType.Builder.<CyberShurikenProjEntity>create(CyberShurikenProjEntity::new, EntityClassification.MISC).size(0.35F, 0.35F).build("cyber_shuriken_proj"));
	 
	 public static final RegistryObject<EntityType<MeteorProjEntity>> METEOR_PROJ = ENTITY_TYPES.register("meteor_proj", 
				() -> EntityType.Builder.<MeteorProjEntity>create(MeteorProjEntity::new, EntityClassification.MISC).size(2.00F, 2.00F).build("meteor_proj"));
	 
	 public static final RegistryObject<EntityType<ParagonicProjEntity>> PARAGONIC_PROJ = ENTITY_TYPES.register("paragonic_proj", 
				() -> EntityType.Builder.<ParagonicProjEntity>create(ParagonicProjEntity::new, EntityClassification.MISC).size(2.00F, 2.00F).build("paragonic_proj"));
	 
	 public static final RegistryObject<EntityType<GiantPeaProjEntity>> GIANT_PEA_PROJ = ENTITY_TYPES.register("giant_pea_proj", 
				() -> EntityType.Builder.<GiantPeaProjEntity>create(GiantPeaProjEntity::new, EntityClassification.MISC).size(0.3F, 0.3F).build("giant_pea_proj"));
	 
	 public static final RegistryObject<EntityType<GiantFrozenPeaProjEntity>> GIANT_FROZEN_PEA_PROJ = ENTITY_TYPES.register("giant_frozen_pea_proj", 
				() -> EntityType.Builder.<GiantFrozenPeaProjEntity>create(GiantFrozenPeaProjEntity::new, EntityClassification.MISC).size(0.3F, 0.3F).build("giant_frozen_pea_proj"));
	 
	 public static final RegistryObject<EntityType<GiantBurningPeaProjEntity>> GIANT_BURNING_PEA_PROJ = ENTITY_TYPES.register("giant_burning_pea_proj", 
				() -> EntityType.Builder.<GiantBurningPeaProjEntity>create(GiantBurningPeaProjEntity::new, EntityClassification.MISC).size(0.3F, 0.3F).build("giant_burning_pea_proj"));
	 
	 public static final RegistryObject<EntityType<CrystalProjEntity>> CRYSTAL_PROJ = ENTITY_TYPES.register("crystal_proj", 
				() -> EntityType.Builder.<CrystalProjEntity>create(CrystalProjEntity::new, EntityClassification.MISC).size(0.3F, 0.3F).build("crystal_proj"));
	 

	 
	 
	 public static void register(IEventBus eventBus) {
	        ENTITY_TYPES.register(eventBus);
	    }
}
