package com.saita.nightsoulsmod.events;

import com.saita.nightsoulsmod.entities.entity.*;
import com.saita.nightsoulsmod.init.NightSoulsEntityTypes;
import com.saita.nightsoulsmod.obj.special.ModSpawnEggItem;
import com.saita.nightsoulsmod.NightSoulsMod;

import net.minecraft.entity.EntityType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = NightSoulsMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)

public class ModEventBusEvents {
	
    @SubscribeEvent
    public static void addEntityAttributes(EntityAttributeCreationEvent event) {
        event.put(NightSoulsEntityTypes.REAPER.get(), ReaperEntity.setCustomAttributes().create());
        event.put(NightSoulsEntityTypes.WEREWOLF.get(), WerewolfEntity.setCustomAttributes().create());
        event.put(NightSoulsEntityTypes.PSYCHO.get(), PsychoEntity.setCustomAttributes().create());
        event.put(NightSoulsEntityTypes.FACE_MONSTER.get(), FaceMonsterEntity.setCustomAttributes().create());
        event.put(NightSoulsEntityTypes.HELLBORN.get(), HellbornEntity.setCustomAttributes().create());
        event.put(NightSoulsEntityTypes.DEMON_EYE.get(), DemonEyeEntity.setCustomAttributes().create());
        event.put(NightSoulsEntityTypes.ALTERNATE.get(), AlternateEntity.setCustomAttributes().create());
        
        event.put(NightSoulsEntityTypes.STARGAZER.get(), StargazerEntity.setCustomAttributes().create());
        event.put(NightSoulsEntityTypes.HELLFIRE_SERVANT.get(), HellfireServantEntity.setCustomAttributes().create());
        event.put(NightSoulsEntityTypes.PALADIN.get(), PaladinEntity.setCustomAttributes().create());
        event.put(NightSoulsEntityTypes.REALITY_WALKER.get(), RealityWalkerEntity.setCustomAttributes().create());
        event.put(NightSoulsEntityTypes.TITAN.get(), TitanEntity.setCustomAttributes().create());
        
        event.put(NightSoulsEntityTypes.AKAZA.get(), AkazaEntity.setCustomAttributes().create());
        event.put(NightSoulsEntityTypes.EYE_OF_CTHULHU.get(), EyeOfCthulhuEntity.setCustomAttributes().create());
        event.put(NightSoulsEntityTypes.KING_CRIMSON.get(), KingCrimsonEntity.setCustomAttributes().create());

    }

    @SubscribeEvent
    public static void onRegisterEntities(RegistryEvent.Register<EntityType<?>> event) {
        ModSpawnEggItem.initSpawnEggs();
    }
    
}