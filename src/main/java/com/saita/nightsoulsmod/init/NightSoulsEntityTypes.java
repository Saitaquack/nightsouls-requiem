package com.saita.nightsoulsmod.init;

import com.saita.nightsoulsmod.NightSoulsMod;
import com.saita.nightsoulsmod.entities.entity.ReaperEntity;

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

	 
	 
	 public static void register(IEventBus eventBus) {
	        ENTITY_TYPES.register(eventBus);
	    }
}
