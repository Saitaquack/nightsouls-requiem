package com.saita.nightsoulsmod.init;

import com.saita.nightsoulsmod.NightSoulsMod;
import com.saita.nightsoulsmod.entities.entity.*;

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
	 
	 
	 
	 public static final RegistryObject<EntityType<AkazaEntity>> AKAZA =
	          ENTITY_TYPES.register("akaza", () -> EntityType.Builder
	            	.create(AkazaEntity::new, EntityClassification.MONSTER).size(0.6F, 1.95F)
	            	.immuneToFire()
	                .build(new ResourceLocation(NightSoulsMod.MOD_ID, "akaza").toString()));
	 
	 public static final RegistryObject<EntityType<EyeOfCthulhuEntity>> EYE_OF_CTHULHU =
	          ENTITY_TYPES.register("eye_of_cthulhu", () -> EntityType.Builder
	            	.create(EyeOfCthulhuEntity::new, EntityClassification.MONSTER).size(1.5F, 2.0F)
	                .build(new ResourceLocation(NightSoulsMod.MOD_ID, "eye_of_cthulhu").toString()));
	 
	 

	 
	 
	 public static void register(IEventBus eventBus) {
	        ENTITY_TYPES.register(eventBus);
	    }
}
