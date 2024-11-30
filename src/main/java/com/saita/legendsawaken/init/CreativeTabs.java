package com.saita.legendsawaken.init;

import com.saita.legendsawaken.LegendsAwakenMod;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class CreativeTabs {
	
	public static final DeferredRegister<CreativeModeTab> CREATIVE_TABS =
	            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, LegendsAwakenMod.MOD_ID);

    public static final RegistryObject<CreativeModeTab> LEGENDS_AWAKEN_TAB = CREATIVE_TABS.register("legends_awaken_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ItemInit.DEMON_CORE.get()))
                    .title(Component.translatable("creativetabs.legends_awaken_tab"))
                    .displayItems((pParameters, pOutput) -> {
                    	
                        pOutput.accept(ItemInit.DEMON_CORE.get());    
                        pOutput.accept(ItemInit.NIGHT_SOUL.get());
                        pOutput.accept(ItemInit.MYTHRIL_INGOT.get());
            			pOutput.accept(ItemInit.RAW_MYTHRIL.get());  		
            			pOutput.accept(ItemInit.MYTHRIL_SWORD.get());
            			pOutput.accept(ItemInit.MYTHRIL_AXE.get());
            			pOutput.accept(ItemInit.MYTHRIL_PICKAXE.get());
            			pOutput.accept(ItemInit.MYTHRIL_SHOVEL.get());
            			pOutput.accept(ItemInit.MYTHRIL_HOE.get());
            			pOutput.accept(ItemInit.MYTHRIL_HELMET.get());
            			pOutput.accept(ItemInit.MYTHRIL_CHESTPLATE.get());
            			pOutput.accept(ItemInit.MYTHRIL_LEGGINGS.get());
            			pOutput.accept(ItemInit.MYTHRIL_BOOTS.get());
            			pOutput.accept(ItemInit.TITANITE_INGOT.get());
             			pOutput.accept(ItemInit.RAW_TITANITE.get());
             			pOutput.accept(ItemInit.TITANITE_SCRAP.get());            		       			
             			pOutput.accept(ItemInit.TITANITE_SWORD.get());
            			pOutput.accept(ItemInit.TITANITE_AXE.get());
            			pOutput.accept(ItemInit.TITANITE_PICKAXE.get());
            			pOutput.accept(ItemInit.TITANITE_SHOVEL.get());
            			pOutput.accept(ItemInit.TITANITE_HOE.get());
            			pOutput.accept(ItemInit.TITANITE_HELMET.get());
            			pOutput.accept(ItemInit.TITANITE_LEGGINGS.get());
            			pOutput.accept(ItemInit.TITANITE_BOOTS.get());
            			pOutput.accept(ItemInit.DAMAGE_TITANITE_CHESTPLATE.get());
            			pOutput.accept(ItemInit.TANKING_TITANITE_CHESTPLATE.get());
            			pOutput.accept(ItemInit.HEALING_TITANITE_CHESTPLATE.get());
            			pOutput.accept(ItemInit.SPEED_TITANITE_CHESTPLATE.get());
            			pOutput.accept(ItemInit.SHADOW_ESSENCE.get());
            			pOutput.accept(ItemInit.AMETHYST_LAUNCHER.get());
            			pOutput.accept(ItemInit.INFERNAL_INGOT.get());
            			pOutput.accept(ItemInit.INFERNAL_CHUNK.get());
            			pOutput.accept(ItemInit.INFERNAL_SCRAP.get());
            			pOutput.accept(ItemInit.INFERNAL_SWORD.get());
            			pOutput.accept(ItemInit.INFERNAL_AXE.get());
            			pOutput.accept(ItemInit.INFERNAL_PICKAXE.get());
            			pOutput.accept(ItemInit.INFERNAL_SHOVEL.get());
            			pOutput.accept(ItemInit.INFERNAL_HOE.get());
            			pOutput.accept(ItemInit.INFERNAL_HELMET.get());
            			pOutput.accept(ItemInit.INFERNAL_CHESTPLATE.get());
            			pOutput.accept(ItemInit.INFERNAL_LEGGINGS.get());
            			pOutput.accept(ItemInit.INFERNAL_BOOTS.get());
            			pOutput.accept(ItemInit.ABYSSAL_COMPASS.get());
            			pOutput.accept(ItemInit.GELATIN_CRYSTAL.get());
            			pOutput.accept(ItemInit.HARDENED_GELATIN_CRYSTAL.get());
            			pOutput.accept(ItemInit.GELATIN_CRYSTAL_SEEDS.get());
            			pOutput.accept(ItemInit.INSTANT_HEALING_POTION.get());
            			pOutput.accept(ItemInit.INSTANT_ABSORPTION_POTION.get());
            			pOutput.accept(ItemInit.MYTHRIL_ARROW.get());
            			pOutput.accept(ItemInit.TITANITE_ARROW.get());
            			pOutput.accept(ItemInit.DEATH_SCYTHE.get());
            			pOutput.accept(ItemInit.MOON_CHARM.get());
            			pOutput.accept(ItemInit.VITAL_CRYSTAL.get());
            			pOutput.accept(ItemInit.VITAL_CRYSTAL_SHARD.get());
            			pOutput.accept(ItemInit.SHADOW_HAND.get());
            			pOutput.accept(ItemInit.BARBARIAN_WARAXE.get());
            			pOutput.accept(ItemInit.CRUSADER_HAMMER.get());
            			pOutput.accept(ItemInit.SUSPICIOUS_LOOKING_EYE.get());

            			pOutput.accept(ItemInit.CORE_OF_PEACE.get());
            			         						
             			pOutput.accept(BlockInit.DEMON_CORE_BLOCK.get());
             			pOutput.accept(BlockInit.MYTHRIL_BLOCK.get());
            			pOutput.accept(BlockInit.RAW_MYTHRIL_BLOCK.get());
            			pOutput.accept(BlockInit.MYTHRIL_ORE.get());
            			pOutput.accept(BlockInit.DEEPSLATE_MYTHRIL_ORE.get());
            			pOutput.accept(BlockInit.TITANITE_BLOCK.get());
            			pOutput.accept(BlockInit.RAW_TITANITE_BLOCK.get());
             			pOutput.accept(BlockInit.TITANITE_ORE.get());
             			pOutput.accept(BlockInit.DEEPSLATE_TITANITE_ORE.get());
             			pOutput.accept(BlockInit.MYTHRIL_BRICKS.get());
             			pOutput.accept(BlockInit.MYTHRIL_BRICKS_STAIRS.get());
             			pOutput.accept(BlockInit.MYTHRIL_BRICKS_SLAB.get());
             			pOutput.accept(BlockInit.TITANITE_BRICKS.get());
             			pOutput.accept(BlockInit.TITANITE_BRICKS_STAIRS.get());
             			pOutput.accept(BlockInit.TITANITE_BRICKS_SLAB.get());
             			pOutput.accept(BlockInit.INFERNAL_STONE.get());
             			pOutput.accept(BlockInit.INFERNAL_BLOCK.get());
             			pOutput.accept(BlockInit.INFERNAL_BRICKS.get());
             			pOutput.accept(BlockInit.INFERNAL_BRICKS_STAIRS.get());
             			pOutput.accept(BlockInit.INFERNAL_BRICKS_SLAB.get());
             			pOutput.accept(BlockInit.HARDENED_GELATIN_CRYSTAL_BLOCK.get());
             			pOutput.accept(BlockInit.VITAL_CRYSTAL_ORE.get());
             			pOutput.accept(BlockInit.DEEPSLATE_VITAL_CRYSTAL_ORE.get());
             			
             			pOutput.accept(BlockInit.HARDMODE_FORCEFIELD.get());
             			
             			pOutput.accept(ItemInit.CORRUPT_ZOMBIE_SPAWN_EGG.get());
             			pOutput.accept(ItemInit.CORRUPT_SPIDER_SPAWN_EGG.get());
             			pOutput.accept(ItemInit.WEREWOLF_SPAWN_EGG.get());
             			pOutput.accept(ItemInit.REAPER_SPAWN_EGG.get());
             			pOutput.accept(ItemInit.WENDIGO_SPAWN_EGG.get());
             			pOutput.accept(ItemInit.ALTERNATE_SPAWN_EGG.get());
             			pOutput.accept(ItemInit.PARTYGOER_SPAWN_EGG.get());   
             			pOutput.accept(ItemInit.DEMON_EYE_SPAWN_EGG.get());   
             			pOutput.accept(ItemInit.STALKER_SPAWN_EGG.get());        			

                    }).build());
    
    
    public static final RegistryObject<CreativeModeTab> MUSIC_DISCS_TAB = CREATIVE_TABS.register("music_discs_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ItemInit.BOSS_ONE_MUSIC_DISC.get()))
                    .title(Component.translatable("creativetabs.music_discs_tab"))
                    .displayItems((pParameters, pOutput) -> {
                    	
            			pOutput.accept(ItemInit.BOSS_ONE_MUSIC_DISC.get());
                    	
                    }).build());
    
    public static final RegistryObject<CreativeModeTab> REQUIEM_TAB = CREATIVE_TABS.register("requiem_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ItemInit.REQUIEM_KEY.get()))
                    .title(Component.translatable("creativetabs.requiem_tab"))
                    .displayItems((pParameters, pOutput) -> {
                    	
                    	pOutput.accept(ItemInit.REQUIEM_KEY.get());
                    	pOutput.accept(ItemInit.UNPOWERED_REQUIEM_KEY.get());
            			pOutput.accept(ItemInit.COSMOLITE_INGOT.get());
            			pOutput.accept(ItemInit.DEMONITE_INGOT.get());
            			pOutput.accept(ItemInit.SERAPHITE_INGOT.get());
            			pOutput.accept(ItemInit.WARPSTONE_INGOT.get());
            			pOutput.accept(ItemInit.RIGHT_HANDED_HELLFIRE_SHOTGUN.get());
            			pOutput.accept(ItemInit.LEFT_HANDED_HELLFIRE_SHOTGUN.get());

            			pOutput.accept(BlockInit.COSMOLITE_ORE.get());
            			pOutput.accept(BlockInit.DEEPSLATE_COSMOLITE_ORE.get());
            			pOutput.accept(BlockInit.DEMONITE_ORE.get());
            			pOutput.accept(BlockInit.DEEPSLATE_DEMONITE_ORE.get());
            			pOutput.accept(BlockInit.ABYSSAL_DEMONITE_ORE.get());
            			pOutput.accept(BlockInit.SERAPHITE_ORE.get());
            			pOutput.accept(BlockInit.DEEPSLATE_SERAPHITE_ORE.get());
            			pOutput.accept(BlockInit.WARPSTONE_ORE.get());
            			pOutput.accept(BlockInit.DEEPSLATE_WARPSTONE_ORE.get());
                    	
                    }).build());
    

    public static void register(IEventBus eventBus) {
        CREATIVE_TABS.register(eventBus);
    }

}
