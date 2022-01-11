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
	                .build(new ResourceLocation(NightSoulsMod.MOD_ID, "hellborn").toString()));

	 
	 
	 public static void register(IEventBus eventBus) {
	        ENTITY_TYPES.register(eventBus);
	    }
}
