package com.saita.legendsawaken.events;

import com.saita.legendsawaken.LegendsAwakenMod;
import com.saita.legendsawaken.entities.mobs.*;
import com.saita.legendsawaken.init.EntityInit;

import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.event.entity.SpawnPlacementRegisterEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@Mod.EventBusSubscriber(modid = LegendsAwakenMod.MOD_ID, bus = Bus.MOD)
public class CommonModEvents {
	
	@SubscribeEvent
	public static void registerAttributes(EntityAttributeCreationEvent event) {
		event.put(EntityInit.CORRUPT_ZOMBIE.get(), CorruptZombieEntity.createAttributes().build());
		event.put(EntityInit.CORRUPT_SPIDER.get(), CorruptSpiderEntity.createAttributes().build());
		event.put(EntityInit.WEREWOLF.get(), WerewolfEntity.createAttributes().build());
		event.put(EntityInit.REAPER.get(), ReaperEntity.createAttributes().build());
		event.put(EntityInit.WENDIGO.get(), WendigoEntity.createAttributes().build());
		event.put(EntityInit.ALTERNATE.get(), AlternateEntity.createAttributes().build());
		event.put(EntityInit.PARTYGOER.get(), AlternateEntity.createAttributes().build());
		event.put(EntityInit.DEMON_EYE.get(), DemonEyeEntity.createAttributes().build());
		event.put(EntityInit.STALKER.get(), StalkerEntity.createAttributes().build());
		
		event.put(EntityInit.EYE_OF_CTHULHU.get(), EyeOfCthulhuEntity.createAttributes().build());
	}
	
	@SubscribeEvent
	public static void registerSpawnPlacements(SpawnPlacementRegisterEvent event) {
		event.register(EntityInit.CORRUPT_ZOMBIE.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.WORLD_SURFACE, CorruptZombieEntity::canSpawn, SpawnPlacementRegisterEvent.Operation.OR);
		event.register(EntityInit.CORRUPT_SPIDER.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.WORLD_SURFACE, CorruptSpiderEntity::canSpawn, SpawnPlacementRegisterEvent.Operation.OR);
		event.register(EntityInit.WEREWOLF.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.WORLD_SURFACE, WerewolfEntity::canSpawn, SpawnPlacementRegisterEvent.Operation.OR);
		event.register(EntityInit.REAPER.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.WORLD_SURFACE, ReaperEntity::canSpawn, SpawnPlacementRegisterEvent.Operation.OR);
		event.register(EntityInit.WENDIGO.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.WORLD_SURFACE, WendigoEntity::canSpawn, SpawnPlacementRegisterEvent.Operation.OR);
		event.register(EntityInit.ALTERNATE.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.WORLD_SURFACE, AlternateEntity::canSpawn, SpawnPlacementRegisterEvent.Operation.OR);
		event.register(EntityInit.PARTYGOER.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.WORLD_SURFACE, PartygoerEntity::canSpawn, SpawnPlacementRegisterEvent.Operation.OR);
		event.register(EntityInit.DEMON_EYE.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.WORLD_SURFACE, DemonEyeEntity::canSpawn, SpawnPlacementRegisterEvent.Operation.OR);
		event.register(EntityInit.STALKER.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.WORLD_SURFACE, StalkerEntity::canSpawn, SpawnPlacementRegisterEvent.Operation.OR);

	}

}
