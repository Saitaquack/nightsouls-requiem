package com.saita.nightsoulsmod;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.saita.nightsoulsmod.init.*;
import com.saita.nightsoulsmod.util.ModelProperties;
import com.saita.nightsoulsmod.world.OreGen;

@Mod(NightSoulsMod.MOD_ID)
public class NightSoulsMod
{
	public static final String MOD_ID = "nightsouls";
    private static final Logger LOGGER = LogManager.getLogger();

    public NightSoulsMod() {
    	
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();   	
        
        ItemInit.register(eventBus);
        BlockInit.register(eventBus);
        SoundInit.register(eventBus);
        StructureInit.register(eventBus);
        eventBus.addListener(this::setup);
        eventBus.addListener(this::doClientStuff);

        MinecraftForge.EVENT_BUS.register(this);
        MinecraftForge.EVENT_BUS.addListener(EventPriority.HIGH, OreGen::generateOres);
    }

    private void setup(final FMLCommonSetupEvent event)
    {
    	LOGGER.info("Hello from NightSouls Mod Requiem 1.1!");
    	LOGGER.info("Loading Star Gatherer's powers...");
    	LOGGER.info("Loading Hellfire Emperor's reign...");
    	LOGGER.info("Loading Hallowed Paladin's might...");
    	LOGGER.info("Loading Reality Warper's script...");
    	
    	event.enqueueWork(() -> {
    		StructureInit.setupStructures();
    	});
    }

    private void doClientStuff(final FMLClientSetupEvent event) {
    	
    	  event.enqueueWork(() -> {
              ModelProperties.makeBow(ItemInit.MIIZEALITE_BOW.get(), 20.0F);
              ModelProperties.makeBow(ItemInit.NIGHTSOULS_BOW.get(), 16.0F);
              ModelProperties.makeBow(ItemInit.BOW_SER.get(), 12.0F);
          });
       
    }
    
    @SubscribeEvent
    public void onServerStarting(FMLServerStartingEvent event) {
        
    }
    
    public static class NightSoulsItemGroup extends ItemGroup
    {
    	public static final NightSoulsItemGroup instance = new NightSoulsItemGroup(ItemGroup.GROUPS.length, "NightSoulsTab");
    	private NightSoulsItemGroup(int index, String label)
    	{
    		super(index, label);
    	}
    	
    	@Override
    	public ItemStack createIcon()
    	{
    		return new ItemStack(ItemInit.NIGHT_SOUL.get());
    	}
    }
    
    public static class NightSoulsFinalsItemGroup extends ItemGroup
    {
    	public static final NightSoulsFinalsItemGroup instance = new NightSoulsFinalsItemGroup(ItemGroup.GROUPS.length, "NightSoulsFinalsTab");
    	private NightSoulsFinalsItemGroup(int index, String label)
    	{
    		super(index, label);
    	}
    	
    	@Override
    	public ItemStack createIcon()
    	{
    		return new ItemStack(ItemInit.GALACTIC_SLAYER.get());
    	}
    }
    
    public static class NightSoulsDiscsItemGroup extends ItemGroup
    {
    	public static final NightSoulsDiscsItemGroup instance = new NightSoulsDiscsItemGroup(ItemGroup.GROUPS.length, "NightSoulsDiscsTab");
    	private NightSoulsDiscsItemGroup(int index, String label)
    	{
    		super(index, label);
    	}
    	
    	@Override
    	public ItemStack createIcon()
    	{
    		return new ItemStack(ItemInit.MARIO_GALAXY_SKY_STATION_MUSIC_DISC.get());
    	}
    }
    
    public static class ParagonItemGroup extends ItemGroup
    {
    	public static final ParagonItemGroup instance = new ParagonItemGroup(ItemGroup.GROUPS.length, "ParagonTab");
    	private ParagonItemGroup(int index, String label)
    	{
    		super(index, label);
    	}
    	
    	@Override
    	public ItemStack createIcon()
    	{
    		return new ItemStack(ItemInit.PARAGONIC_BLOCK.get());
    	}
    }

}
