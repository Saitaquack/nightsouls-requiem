package com.saita.nightsoulsmod.events;

import com.saita.nightsoulsmod.entities.entity.ReaperEntity;
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
    }

    @SubscribeEvent
    public static void onRegisterEntities(RegistryEvent.Register<EntityType<?>> event) {
        ModSpawnEggItem.initSpawnEggs();
    }
    
}