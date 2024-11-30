package com.saita.legendsawaken;

import org.slf4j.Logger;

import com.mojang.logging.LogUtils;
import com.saita.legendsawaken.init.*;

import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.RangedAttribute;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(LegendsAwakenMod.MOD_ID)

public class LegendsAwakenMod {
	
	 public static final String MOD_ID = "legendsawaken";
	 private static final Logger LOGGER = LogUtils.getLogger();
	 
	 public LegendsAwakenMod() {
		 
		 IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
	     MinecraftForge.EVENT_BUS.register(this);
	     
	     CreativeTabs.register(modEventBus);   
	     ItemInit.register(modEventBus);
	     BlockInit.register(modEventBus);
	     SoundInit.register(modEventBus);
	     EntityInit.register(modEventBus);
	     
	     modEventBus.addListener(this::commonSetup);
		 
	 }
	 
	 private void commonSetup(final FMLCommonSetupEvent event) {
    	LOGGER.info("Legends Awaken successfully launched !");
    	
    	event.enqueueWork(() -> {
			replaceAttributeValue((RangedAttribute) Attributes.MAX_HEALTH, 100000.0);
		});
	 }
	 
	 protected static void replaceAttributeValue(RangedAttribute attribute, double maxValue) {
			attribute.maxValue = maxValue;
	 }

}
