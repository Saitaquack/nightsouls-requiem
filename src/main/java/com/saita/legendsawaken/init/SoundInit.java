package com.saita.legendsawaken.init;

import com.saita.legendsawaken.LegendsAwakenMod;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class SoundInit {
	public static final DeferredRegister<SoundEvent> SOUND_EVENTS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, LegendsAwakenMod.MOD_ID);
	
	public static final RegistryObject<SoundEvent> LAUNCHER_USED = registerSoundEvent("launcher_used");
	public static final RegistryObject<SoundEvent> INSTANT_POTION = registerSoundEvent("instant_potion");
	public static final RegistryObject<SoundEvent> VITAL_CRYSTAL_USED = registerSoundEvent("vital_crystal_used");
	public static final RegistryObject<SoundEvent> WARAXE = registerSoundEvent("waraxe");
	public static final RegistryObject<SoundEvent> HAMMER = registerSoundEvent("hammer");
	public static final RegistryObject<SoundEvent> HELLFIRE_SHOTGUN = registerSoundEvent("hellfire_shotgun");
	public static final RegistryObject<SoundEvent> REQUIEM = registerSoundEvent("requiem");
	
	public static final RegistryObject<SoundEvent> WEREWOLF_AMBIENT = registerSoundEvent("werewolf_ambient");
	public static final RegistryObject<SoundEvent> WEREWOLF_HURT = registerSoundEvent("werewolf_hurt");
	public static final RegistryObject<SoundEvent> WEREWOLF_DEATH = registerSoundEvent("werewolf_death");
	public static final RegistryObject<SoundEvent> REAPER_AMBIENT = registerSoundEvent("reaper_ambient");
	public static final RegistryObject<SoundEvent> REAPER_HURT = registerSoundEvent("reaper_hurt");
	public static final RegistryObject<SoundEvent> REAPER_DEATH = registerSoundEvent("reaper_death");
	public static final RegistryObject<SoundEvent> WENDIGO_AMBIENT = registerSoundEvent("wendigo_ambient");
	public static final RegistryObject<SoundEvent> WENDIGO_HURT = registerSoundEvent("wendigo_hurt");
	public static final RegistryObject<SoundEvent> WENDIGO_DEATH = registerSoundEvent("wendigo_death");
	public static final RegistryObject<SoundEvent> ALTERNATE_AMBIENT = registerSoundEvent("alternate_ambient");
	public static final RegistryObject<SoundEvent> ALTERNATE_HURT = registerSoundEvent("alternate_hurt");
	public static final RegistryObject<SoundEvent> ALTERNATE_DEATH = registerSoundEvent("alternate_death");
	public static final RegistryObject<SoundEvent> ALTERNATE_STEP = registerSoundEvent("alternate_step");
	public static final RegistryObject<SoundEvent> ALTERNATE_ATTACK = registerSoundEvent("alternate_attack");
	public static final RegistryObject<SoundEvent> PARTYGOER_AMBIENT = registerSoundEvent("partygoer_ambient");
	public static final RegistryObject<SoundEvent> PARTYGOER_HURT = registerSoundEvent("partygoer_hurt");
	public static final RegistryObject<SoundEvent> PARTYGOER_DEATH = registerSoundEvent("partygoer_death");
	public static final RegistryObject<SoundEvent> EYE_HURT = registerSoundEvent("eye_hurt");
	public static final RegistryObject<SoundEvent> EYE_DEATH = registerSoundEvent("eye_death");
	public static final RegistryObject<SoundEvent> CTHULHU_SCREAM = registerSoundEvent("cthulhu_scream");
	
	public static final RegistryObject<SoundEvent> BOSS_ONE = registerSoundEvent("boss_one");
	
	
	private static RegistryObject<SoundEvent> registerSoundEvent(String name) {
		ResourceLocation id = new ResourceLocation(LegendsAwakenMod.MOD_ID, name);
		return SOUND_EVENTS.register(name, () -> SoundEvent.createVariableRangeEvent(id));
	}
	
	public static void register(IEventBus eventBus) {
		SOUND_EVENTS.register(eventBus);
	}
}
