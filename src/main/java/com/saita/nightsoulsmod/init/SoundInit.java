package com.saita.nightsoulsmod.init;

import com.saita.nightsoulsmod.NightSoulsMod;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.common.util.Lazy;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class SoundInit {
	
	public static final DeferredRegister<SoundEvent> SOUNDS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, NightSoulsMod.MOD_ID);
	
	public static final RegistryObject<SoundEvent> SUPER_STAR = SOUNDS.register("super_star", () -> new SoundEvent
			(new ResourceLocation(NightSoulsMod.MOD_ID, "super_star")));
	
	public static final RegistryObject<SoundEvent> WRAITH_FORM = SOUNDS.register("wraith_form", () -> new SoundEvent
			(new ResourceLocation(NightSoulsMod.MOD_ID, "wraith_form")));
	
	public static final RegistryObject<SoundEvent> TAKE_A_BREATHER = SOUNDS.register("take_a_breather", () -> new SoundEvent
			(new ResourceLocation(NightSoulsMod.MOD_ID, "take_a_breather")));
	
	public static final RegistryObject<SoundEvent> AMP_IT_UP = SOUNDS.register("amp_it_up", () -> new SoundEvent
			(new ResourceLocation(NightSoulsMod.MOD_ID, "amp_it_up")));
	
	public static final RegistryObject<SoundEvent> LIFE_CRYSTAL = SOUNDS.register("life_crystal", () -> new SoundEvent
			(new ResourceLocation(NightSoulsMod.MOD_ID, "life_crystal")));
	
	public static final RegistryObject<SoundEvent> SALUT = SOUNDS.register("salut", () -> new SoundEvent
			(new ResourceLocation(NightSoulsMod.MOD_ID, "salut")));
	
	public static final RegistryObject<SoundEvent> MAGIC_MIRROR = SOUNDS.register("magic_mirror", () -> new SoundEvent
			(new ResourceLocation(NightSoulsMod.MOD_ID, "magic_mirror")));
	
	public static final RegistryObject<SoundEvent> STAR_BIT = SOUNDS.register("star_bit", () -> new SoundEvent
			(new ResourceLocation(NightSoulsMod.MOD_ID, "star_bit")));

	public static final RegistryObject<SoundEvent> TIME_SKIP = SOUNDS.register("time_skip", () -> new SoundEvent
			(new ResourceLocation(NightSoulsMod.MOD_ID, "time_skip")));
	
	public static final RegistryObject<SoundEvent> INSTANT_POTION = SOUNDS.register("instant_potion", () -> new SoundEvent
			(new ResourceLocation(NightSoulsMod.MOD_ID, "instant_potion")));
	
	public static final RegistryObject<SoundEvent> FADE = SOUNDS.register("fade", () -> new SoundEvent
			(new ResourceLocation(NightSoulsMod.MOD_ID, "fade")));
	
	public static final RegistryObject<SoundEvent> ADAPTIVE_SHIELD = SOUNDS.register("adaptive_shield", () -> new SoundEvent
			(new ResourceLocation(NightSoulsMod.MOD_ID, "adaptive_shield")));
	
	public static final RegistryObject<SoundEvent> BLINK = SOUNDS.register("blink", () -> new SoundEvent
			(new ResourceLocation(NightSoulsMod.MOD_ID, "blink")));
	
	public static final RegistryObject<SoundEvent> REQUIEM = SOUNDS.register("requiem", () -> new SoundEvent
			(new ResourceLocation(NightSoulsMod.MOD_ID, "requiem")));
	
	public static final RegistryObject<SoundEvent> STAR_PLATINUM = SOUNDS.register("star_platinum", () -> new SoundEvent
			(new ResourceLocation(NightSoulsMod.MOD_ID, "star_platinum")));
	
	public static final RegistryObject<SoundEvent> BACKROOMS_LIGHT = SOUNDS.register("backrooms_light", () -> new SoundEvent
			(new ResourceLocation(NightSoulsMod.MOD_ID, "backrooms_light")));
	
	public static final RegistryObject<SoundEvent> TECHNO_GUN = SOUNDS.register("techno_gun", () -> new SoundEvent
			(new ResourceLocation(NightSoulsMod.MOD_ID, "techno_gun")));
	
	public static final RegistryObject<SoundEvent> EMERALD_SPLASH = SOUNDS.register("emerald_splash", () -> new SoundEvent
			(new ResourceLocation(NightSoulsMod.MOD_ID, "emerald_splash")));
	
	public static final RegistryObject<SoundEvent> LASER = SOUNDS.register("laser", () -> new SoundEvent
			(new ResourceLocation(NightSoulsMod.MOD_ID, "laser")));
	
	public static final RegistryObject<SoundEvent> PLASMA = SOUNDS.register("plasma", () -> new SoundEvent
			(new ResourceLocation(NightSoulsMod.MOD_ID, "plasma")));
	
	public static final RegistryObject<SoundEvent> SUN = SOUNDS.register("sun", () -> new SoundEvent
			(new ResourceLocation(NightSoulsMod.MOD_ID, "sun")));
	
	public static final RegistryObject<SoundEvent> SHURIKEN = SOUNDS.register("shuriken", () -> new SoundEvent
			(new ResourceLocation(NightSoulsMod.MOD_ID, "shuriken")));
	
	public static final RegistryObject<SoundEvent> METEOR = SOUNDS.register("meteor", () -> new SoundEvent
			(new ResourceLocation(NightSoulsMod.MOD_ID, "meteor")));
	
	public static final RegistryObject<SoundEvent> MAGIC = SOUNDS.register("magic", () -> new SoundEvent
			(new ResourceLocation(NightSoulsMod.MOD_ID, "magic")));
	
	public static final RegistryObject<SoundEvent> RUN = SOUNDS.register("run", () -> new SoundEvent
			(new ResourceLocation(NightSoulsMod.MOD_ID, "run")));
	
	public static final RegistryObject<SoundEvent> RETINAZER_SHOT = SOUNDS.register("retinazer_shot", () -> new SoundEvent
			(new ResourceLocation(NightSoulsMod.MOD_ID, "retinazer_shot")));
	
	public static final RegistryObject<SoundEvent> SPAZMATISM_SHOT = SOUNDS.register("spazmatism_shot", () -> new SoundEvent
			(new ResourceLocation(NightSoulsMod.MOD_ID, "spazmatism_shot")));
	
	public static final RegistryObject<SoundEvent> BIOTIC_RIFLE_SHOT = SOUNDS.register("biotic_rifle_shot", () -> new SoundEvent
			(new ResourceLocation(NightSoulsMod.MOD_ID, "biotic_rifle_shot")));
	
	public static final RegistryObject<SoundEvent> BIOTIC_RIFLE_DAMAGE = SOUNDS.register("biotic_rifle_damage", () -> new SoundEvent
			(new ResourceLocation(NightSoulsMod.MOD_ID, "biotic_rifle_damage")));
	
	public static final RegistryObject<SoundEvent> BIOTIC_RIFLE_HEAL = SOUNDS.register("biotic_rifle_heal", () -> new SoundEvent
			(new ResourceLocation(NightSoulsMod.MOD_ID, "biotic_rifle_heal")));
	
	
	//Armes 
	
	public static final RegistryObject<SoundEvent> HAMMER = SOUNDS.register("hammer", () -> new SoundEvent
			(new ResourceLocation(NightSoulsMod.MOD_ID, "hammer")));
	
	public static final RegistryObject<SoundEvent> WARAXE = SOUNDS.register("waraxe", () -> new SoundEvent
			(new ResourceLocation(NightSoulsMod.MOD_ID, "waraxe")));
	
	public static final RegistryObject<SoundEvent> HELLFIRE_EMPEROR_TRIDENT = SOUNDS.register("hellfire_emperor_trident", () -> new SoundEvent
			(new ResourceLocation(NightSoulsMod.MOD_ID, "hellfire_emperor_trident")));
	
	public static final RegistryObject<SoundEvent> SOUL_STEALER = SOUNDS.register("soul_stealer", () -> new SoundEvent
			(new ResourceLocation(NightSoulsMod.MOD_ID, "soul_stealer")));
	
	public static final RegistryObject<SoundEvent> FROSTBURN = SOUNDS.register("frostburn", () -> new SoundEvent
			(new ResourceLocation(NightSoulsMod.MOD_ID, "frostburn")));
	
	public static final RegistryObject<SoundEvent> GALACTIC_SLAYER = SOUNDS.register("galactic_slayer", () -> new SoundEvent
			(new ResourceLocation(NightSoulsMod.MOD_ID, "galactic_slayer")));
	
	public static final RegistryObject<SoundEvent> JAVA_FURY = SOUNDS.register("java_fury", () -> new SoundEvent
			(new ResourceLocation(NightSoulsMod.MOD_ID, "java_fury")));
	
	public static final RegistryObject<SoundEvent> BOW_SER = SOUNDS.register("bow_ser", () -> new SoundEvent
			(new ResourceLocation(NightSoulsMod.MOD_ID, "bow_ser")));
	
	public static final RegistryObject<SoundEvent> BOWSER_LAUGH = SOUNDS.register("bowser_laugh", () -> new SoundEvent
			(new ResourceLocation(NightSoulsMod.MOD_ID, "bowser_laugh")));
	
	public static final RegistryObject<SoundEvent> BLOODZEAL = SOUNDS.register("bloodzeal", () -> new SoundEvent
			(new ResourceLocation(NightSoulsMod.MOD_ID, "bloodzeal")));
	
	public static final RegistryObject<SoundEvent> SUPERNOVA = SOUNDS.register("supernova", () -> new SoundEvent
			(new ResourceLocation(NightSoulsMod.MOD_ID, "supernova")));
	
	public static final RegistryObject<SoundEvent> HEXADECIMATOR = SOUNDS.register("hexadecimator", () -> new SoundEvent
			(new ResourceLocation(NightSoulsMod.MOD_ID, "hexadecimator")));
	
	public static final RegistryObject<SoundEvent> DIVINE_SANCTION = SOUNDS.register("divine_sanction", () -> new SoundEvent
			(new ResourceLocation(NightSoulsMod.MOD_ID, "divine_sanction")));
	
	public static final RegistryObject<SoundEvent> DRAGONBLADE_DASH = SOUNDS.register("dragonblade_dash", () -> new SoundEvent
			(new ResourceLocation(NightSoulsMod.MOD_ID, "dragonblade_dash")));
	
	public static final RegistryObject<SoundEvent> DRAGONBLADE_SLASH = SOUNDS.register("dragonblade_slash", () -> new SoundEvent
			(new ResourceLocation(NightSoulsMod.MOD_ID, "dragonblade_slash")));
	
	public static final RegistryObject<SoundEvent> CRISMON_PUNCH = SOUNDS.register("crimson_punch", () -> new SoundEvent
			(new ResourceLocation(NightSoulsMod.MOD_ID, "crimson_punch")));
	
	//Mobs
	
	public static final RegistryObject<SoundEvent> REAPER_AMBIENT = SOUNDS.register("reaper_ambient", () -> new SoundEvent
			(new ResourceLocation(NightSoulsMod.MOD_ID, "reaper_ambient")));
	
	public static final RegistryObject<SoundEvent> REAPER_HIT = SOUNDS.register("reaper_hit", () -> new SoundEvent
			(new ResourceLocation(NightSoulsMod.MOD_ID, "reaper_hit")));
	
	public static final RegistryObject<SoundEvent> REAPER_DEATH = SOUNDS.register("reaper_death", () -> new SoundEvent
			(new ResourceLocation(NightSoulsMod.MOD_ID, "reaper_death")));
	
	public static final RegistryObject<SoundEvent> WEREWOLF_AMBIENT = SOUNDS.register("werewolf_ambient", () -> new SoundEvent
			(new ResourceLocation(NightSoulsMod.MOD_ID, "werewolf_ambient")));
	
	public static final RegistryObject<SoundEvent> WEREWOLF_HIT = SOUNDS.register("werewolf_hit", () -> new SoundEvent
			(new ResourceLocation(NightSoulsMod.MOD_ID, "werewolf_hit")));
	
	public static final RegistryObject<SoundEvent> WEREWOLF_DEATH = SOUNDS.register("werewolf_death", () -> new SoundEvent
			(new ResourceLocation(NightSoulsMod.MOD_ID, "werewolf_death")));
	
	public static final RegistryObject<SoundEvent> PSYCHO_AMBIENT = SOUNDS.register("psycho_ambient", () -> new SoundEvent
			(new ResourceLocation(NightSoulsMod.MOD_ID, "psycho_ambient")));
	
	public static final RegistryObject<SoundEvent> FACE_MONSTER_AMBIENT = SOUNDS.register("face_monster_ambient", () -> new SoundEvent
			(new ResourceLocation(NightSoulsMod.MOD_ID, "face_monster_ambient")));
	
	public static final RegistryObject<SoundEvent> FACE_MONSTER_HIT = SOUNDS.register("face_monster_hit", () -> new SoundEvent
			(new ResourceLocation(NightSoulsMod.MOD_ID, "face_monster_hit")));
	
	public static final RegistryObject<SoundEvent> FACE_MONSTER_DEATH = SOUNDS.register("face_monster_death", () -> new SoundEvent
			(new ResourceLocation(NightSoulsMod.MOD_ID, "face_monster_death")));
	
	public static final RegistryObject<SoundEvent> EYE_HIT = SOUNDS.register("eye_hit", () -> new SoundEvent
			(new ResourceLocation(NightSoulsMod.MOD_ID, "eye_hit")));
	
	public static final RegistryObject<SoundEvent> EYE_DEATH = SOUNDS.register("eye_death", () -> new SoundEvent
			(new ResourceLocation(NightSoulsMod.MOD_ID, "eye_death")));
	
	public static final RegistryObject<SoundEvent> ALTERNATE_AMBIENT = SOUNDS.register("alternate_ambient", () -> new SoundEvent
			(new ResourceLocation(NightSoulsMod.MOD_ID, "alternate_ambient")));
	
	public static final RegistryObject<SoundEvent> ALTERNATE_HIT = SOUNDS.register("alternate_hit", () -> new SoundEvent
			(new ResourceLocation(NightSoulsMod.MOD_ID, "alternate_hit")));
	
	public static final RegistryObject<SoundEvent> ALTERNATE_DEATH = SOUNDS.register("alternate_death", () -> new SoundEvent
			(new ResourceLocation(NightSoulsMod.MOD_ID, "alternate_death")));
	
	public static final RegistryObject<SoundEvent> ALTERNATE_ATTACK = SOUNDS.register("alternate_attack", () -> new SoundEvent
			(new ResourceLocation(NightSoulsMod.MOD_ID, "alternate_attack")));
	
	public static final RegistryObject<SoundEvent> ALTERNATE_STEP = SOUNDS.register("alternate_step", () -> new SoundEvent
			(new ResourceLocation(NightSoulsMod.MOD_ID, "alternate_step")));
	
	public static final RegistryObject<SoundEvent> REQUIEM_DEATH = SOUNDS.register("requiem_death", () -> new SoundEvent
			(new ResourceLocation(NightSoulsMod.MOD_ID, "requiem_death")));
	
	public static final RegistryObject<SoundEvent> STARGAZER_HIT = SOUNDS.register("stargazer_hit", () -> new SoundEvent
			(new ResourceLocation(NightSoulsMod.MOD_ID, "stargazer_hit")));
	
	public static final RegistryObject<SoundEvent> PALADIN_HIT = SOUNDS.register("paladin_hit", () -> new SoundEvent
			(new ResourceLocation(NightSoulsMod.MOD_ID, "paladin_hit")));
	
	public static final RegistryObject<SoundEvent> PALADIN_AMBIENT = SOUNDS.register("paladin_ambient", () -> new SoundEvent
			(new ResourceLocation(NightSoulsMod.MOD_ID, "paladin_ambient")));
	
	public static final RegistryObject<SoundEvent> REALITY_WALKER_AMBIENT = SOUNDS.register("reality_walker_ambient", () -> new SoundEvent
			(new ResourceLocation(NightSoulsMod.MOD_ID, "reality_walker_ambient")));
	
	public static final RegistryObject<SoundEvent> REALITY_WALKER_HIT = SOUNDS.register("reality_walker_hit", () -> new SoundEvent
			(new ResourceLocation(NightSoulsMod.MOD_ID, "reality_walker_hit")));
	
	public static final RegistryObject<SoundEvent> AKAZA_AMBIENT = SOUNDS.register("akaza_ambient", () -> new SoundEvent
			(new ResourceLocation(NightSoulsMod.MOD_ID, "akaza_ambient")));
	
	public static final RegistryObject<SoundEvent> AKAZA_DEATH = SOUNDS.register("akaza_death", () -> new SoundEvent
			(new ResourceLocation(NightSoulsMod.MOD_ID, "akaza_death")));
	
	public static final RegistryObject<SoundEvent> AKAZA_COMPASS = SOUNDS.register("akaza_compass", () -> new SoundEvent
			(new ResourceLocation(NightSoulsMod.MOD_ID, "akaza_compass")));
	
	public static final RegistryObject<SoundEvent> AKAZA_DOKE = SOUNDS.register("akaza_doke", () -> new SoundEvent
			(new ResourceLocation(NightSoulsMod.MOD_ID, "akaza_doke")));
	
	public static final RegistryObject<SoundEvent> AKAZA_EXCITED = SOUNDS.register("akaza_excited", () -> new SoundEvent
			(new ResourceLocation(NightSoulsMod.MOD_ID, "akaza_excited")));
	
	public static final RegistryObject<SoundEvent> CTHULHU_SCREAM = SOUNDS.register("cthulhu_scream", () -> new SoundEvent
			(new ResourceLocation(NightSoulsMod.MOD_ID, "cthulhu_scream")));
	
	public static final RegistryObject<SoundEvent> KING_CRIMSON_AMBIENT = SOUNDS.register("king_crimson_ambient", () -> new SoundEvent
			(new ResourceLocation(NightSoulsMod.MOD_ID, "king_crimson_ambient")));
	
	public static final RegistryObject<SoundEvent> KING_CRIMSON_DEATH = SOUNDS.register("king_crimson_death", () -> new SoundEvent
			(new ResourceLocation(NightSoulsMod.MOD_ID, "king_crimson_death")));
	
	public static final RegistryObject<SoundEvent> TITAN_AMBIENT = SOUNDS.register("titan_ambient", () -> new SoundEvent
			(new ResourceLocation(NightSoulsMod.MOD_ID, "titan_ambient")));
	
	public static final RegistryObject<SoundEvent> TITAN_DEATH = SOUNDS.register("titan_death", () -> new SoundEvent
			(new ResourceLocation(NightSoulsMod.MOD_ID, "titan_death")));
	
	public static final RegistryObject<SoundEvent> TITAN_STEP = SOUNDS.register("titan_step", () -> new SoundEvent
			(new ResourceLocation(NightSoulsMod.MOD_ID, "titan_step")));
	
	public static final RegistryObject<SoundEvent> PARTYGOER_AMBIENT = SOUNDS.register("partygoer_ambient", () -> new SoundEvent
			(new ResourceLocation(NightSoulsMod.MOD_ID, "partygoer_ambient")));
	
	public static final RegistryObject<SoundEvent> WINDIGO_AMBIENT = SOUNDS.register("windigo_ambient", () -> new SoundEvent
			(new ResourceLocation(NightSoulsMod.MOD_ID, "windigo_ambient")));
	
	public static final RegistryObject<SoundEvent> WINDIGO_HIT = SOUNDS.register("windigo_hit", () -> new SoundEvent
			(new ResourceLocation(NightSoulsMod.MOD_ID, "windigo_hit")));
	
	public static final RegistryObject<SoundEvent> WINDIGO_DEATH = SOUNDS.register("widigo_death", () -> new SoundEvent
			(new ResourceLocation(NightSoulsMod.MOD_ID, "windigo_death")));
	
	
	//Musiques
	
	public static final Lazy<SoundEvent> MARIO_GALAXY_SKY_STATION = Lazy.of(() -> new SoundEvent
			(new ResourceLocation(NightSoulsMod.MOD_ID, "mario_galaxy_sky_station")));
	
	public static final Lazy<SoundEvent> MARIO_GALAXY_CREDITS = Lazy.of(() -> new SoundEvent
			(new ResourceLocation(NightSoulsMod.MOD_ID, "mario_galaxy_credits")));
	
	public static final Lazy<SoundEvent> HOPES_AND_DREAMS = Lazy.of(() -> new SoundEvent
			(new ResourceLocation(NightSoulsMod.MOD_ID, "hopes_and_dreams")));
	
	public static final Lazy<SoundEvent> TOTO_AFRICA = Lazy.of(() -> new SoundEvent
			(new ResourceLocation(NightSoulsMod.MOD_ID, "toto_africa")));
	
	public static final Lazy<SoundEvent> KIRA = Lazy.of(() -> new SoundEvent
			(new ResourceLocation(NightSoulsMod.MOD_ID, "kira")));
	
	public static final Lazy<SoundEvent> AWAKEN = Lazy.of(() -> new SoundEvent
			(new ResourceLocation(NightSoulsMod.MOD_ID, "awaken")));
	
	public static final Lazy<SoundEvent> INFOGRAMES = Lazy.of(() -> new SoundEvent
			(new ResourceLocation(NightSoulsMod.MOD_ID, "infogrames")));
	
	public static final Lazy<SoundEvent> PYRO_BARBARE = Lazy.of(() -> new SoundEvent
			(new ResourceLocation(NightSoulsMod.MOD_ID, "pyro_barbare")));
	
	public static final Lazy<SoundEvent> MINECRAFT = Lazy.of(() -> new SoundEvent
			(new ResourceLocation(NightSoulsMod.MOD_ID, "minecraft")));
	
	public static final Lazy<SoundEvent> BOWSER = Lazy.of(() -> new SoundEvent
			(new ResourceLocation(NightSoulsMod.MOD_ID, "bowser")));
	
	public static final Lazy<SoundEvent> OBSERVATORY = Lazy.of(() -> new SoundEvent
			(new ResourceLocation(NightSoulsMod.MOD_ID, "observatory")));
	
	public static final Lazy<SoundEvent> STARSHIP = Lazy.of(() -> new SoundEvent
			(new ResourceLocation(NightSoulsMod.MOD_ID, "starship")));
	
	public static final Lazy<SoundEvent> GUSTY_GARDEN = Lazy.of(() -> new SoundEvent
			(new ResourceLocation(NightSoulsMod.MOD_ID, "gusty_garden")));
	
	public static final Lazy<SoundEvent> GOOD_EGG_GALAXY = Lazy.of(() -> new SoundEvent
			(new ResourceLocation(NightSoulsMod.MOD_ID, "good_egg_galaxy")));
	
	public static final Lazy<SoundEvent> STAR_GATHERER_FINAL_THEME = Lazy.of(() -> new SoundEvent
			(new ResourceLocation(NightSoulsMod.MOD_ID, "star_gatherer_final_theme")));
	
	public static final Lazy<SoundEvent> HELLFIRE_EMPEROR_FINAL_THEME = Lazy.of(() -> new SoundEvent
			(new ResourceLocation(NightSoulsMod.MOD_ID, "hellfire_emperor_final_theme")));
	
	public static final Lazy<SoundEvent> HALLOWED_PALADIN_FINAL_THEME = Lazy.of(() -> new SoundEvent
			(new ResourceLocation(NightSoulsMod.MOD_ID, "hallowed_paladin_final_theme")));
	
	public static final Lazy<SoundEvent> REALITY_WARPER_FINAL_THEME = Lazy.of(() -> new SoundEvent
			(new ResourceLocation(NightSoulsMod.MOD_ID, "reality_warper_final_theme")));
	
	public static final Lazy<SoundEvent> FNAF_ONE = Lazy.of(() -> new SoundEvent
			(new ResourceLocation(NightSoulsMod.MOD_ID, "fnaf_one")));
	
	public static final Lazy<SoundEvent> FNAF_TWO = Lazy.of(() -> new SoundEvent
			(new ResourceLocation(NightSoulsMod.MOD_ID, "fnaf_two")));
	
	public static final Lazy<SoundEvent> UNDYNE = Lazy.of(() -> new SoundEvent
			(new ResourceLocation(NightSoulsMod.MOD_ID, "undyne")));
	
	public static final Lazy<SoundEvent> ASGORE = Lazy.of(() -> new SoundEvent
			(new ResourceLocation(NightSoulsMod.MOD_ID, "asgore")));
	
	public static final Lazy<SoundEvent> MAMA_LAUDA = Lazy.of(() -> new SoundEvent
			(new ResourceLocation(NightSoulsMod.MOD_ID, "mama_lauda")));
	
	public static final Lazy<SoundEvent> ASHES_ON_THE_FIRE = Lazy.of(() -> new SoundEvent
			(new ResourceLocation(NightSoulsMod.MOD_ID, "ashes_on_the_fire")));
	
	public static final Lazy<SoundEvent> MEGALOVANIA = Lazy.of(() -> new SoundEvent
			(new ResourceLocation(NightSoulsMod.MOD_ID, "megalovania")));
	
	public static final Lazy<SoundEvent> MICKIE_KRAUSE = Lazy.of(() -> new SoundEvent
			(new ResourceLocation(NightSoulsMod.MOD_ID, "mickie_krause")));
	
	public static final Lazy<SoundEvent> REVENGE = Lazy.of(() -> new SoundEvent
			(new ResourceLocation(NightSoulsMod.MOD_ID, "revenge")));
	
	public static final Lazy<SoundEvent> JEVIL = Lazy.of(() -> new SoundEvent
			(new ResourceLocation(NightSoulsMod.MOD_ID, "jevil")));
	
	public static final Lazy<SoundEvent> BURNING_COLOSSEUM = Lazy.of(() -> new SoundEvent
			(new ResourceLocation(NightSoulsMod.MOD_ID, "burning_colosseum")));
	
	public static final Lazy<SoundEvent> DIAVOLO = Lazy.of(() -> new SoundEvent
			(new ResourceLocation(NightSoulsMod.MOD_ID, "diavolo")));
	
	public static final Lazy<SoundEvent> GIORNO = Lazy.of(() -> new SoundEvent
			(new ResourceLocation(NightSoulsMod.MOD_ID, "giorno")));
	
	public static final Lazy<SoundEvent> JOTARO = Lazy.of(() -> new SoundEvent
			(new ResourceLocation(NightSoulsMod.MOD_ID, "jotaro")));
	
	public static final Lazy<SoundEvent> JOSUKE = Lazy.of(() -> new SoundEvent
			(new ResourceLocation(NightSoulsMod.MOD_ID, "josuke")));
	
	public static final Lazy<SoundEvent> UNALTRA = Lazy.of(() -> new SoundEvent
			(new ResourceLocation(NightSoulsMod.MOD_ID, "unaltra")));
	
	public static final Lazy<SoundEvent> NIGHT_TOWN = Lazy.of(() -> new SoundEvent
			(new ResourceLocation(NightSoulsMod.MOD_ID, "night_town")));

	public static final Lazy<SoundEvent> KORO = Lazy.of(() -> new SoundEvent
			(new ResourceLocation(NightSoulsMod.MOD_ID, "koro")));
	
	public static final Lazy<SoundEvent> AKAZA = Lazy.of(() -> new SoundEvent
			(new ResourceLocation(NightSoulsMod.MOD_ID, "akaza")));
	
	public static final Lazy<SoundEvent> YOUSEEBIGGIRL = Lazy.of(() -> new SoundEvent
			(new ResourceLocation(NightSoulsMod.MOD_ID, "youseebiggirl")));
	
	public static final Lazy<SoundEvent> DEATH_NOTE = Lazy.of(() -> new SoundEvent
			(new ResourceLocation(NightSoulsMod.MOD_ID, "death_note")));
	
	public static final Lazy<SoundEvent> HELIKOPTER = Lazy.of(() -> new SoundEvent
			(new ResourceLocation(NightSoulsMod.MOD_ID, "helikopter")));
	
	public static final Lazy<SoundEvent> FOSSIL_FALLS = Lazy.of(() -> new SoundEvent
			(new ResourceLocation(NightSoulsMod.MOD_ID, "fossil_falls")));
	
	public static final Lazy<SoundEvent> TANJIRO = Lazy.of(() -> new SoundEvent
			(new ResourceLocation(NightSoulsMod.MOD_ID, "tanjiro")));
	
	public static final Lazy<SoundEvent> MHWI = Lazy.of(() -> new SoundEvent
			(new ResourceLocation(NightSoulsMod.MOD_ID, "mhwi")));
	
	public static final Lazy<SoundEvent> MUZAN = Lazy.of(() -> new SoundEvent
			(new ResourceLocation(NightSoulsMod.MOD_ID, "muzan")));
	
	public static final Lazy<SoundEvent> DRAGONHEARTED = Lazy.of(() -> new SoundEvent
			(new ResourceLocation(NightSoulsMod.MOD_ID, "dragonhearted")));
	
	public static final Lazy<SoundEvent> BOSS_ONE = Lazy.of(() -> new SoundEvent
			(new ResourceLocation(NightSoulsMod.MOD_ID, "boss_one")));
	
	public static final Lazy<SoundEvent> BOSS_TWO = Lazy.of(() -> new SoundEvent
			(new ResourceLocation(NightSoulsMod.MOD_ID, "boss_two")));
	
	public static final Lazy<SoundEvent> SOUPE_AUX_CHOUX = Lazy.of(() -> new SoundEvent
			(new ResourceLocation(NightSoulsMod.MOD_ID, "soupe_aux_choux")));
	
	public static final Lazy<SoundEvent> BURNING_MEMORY = Lazy.of(() -> new SoundEvent
			(new ResourceLocation(NightSoulsMod.MOD_ID, "burning_memory")));
	
	public static final Lazy<SoundEvent> DOOPLISS = Lazy.of(() -> new SoundEvent
			(new ResourceLocation(NightSoulsMod.MOD_ID, "doopliss")));
	
	public static final Lazy<SoundEvent> KAKYOIN = Lazy.of(() -> new SoundEvent
			(new ResourceLocation(NightSoulsMod.MOD_ID, "kakyoin")));
	
	public static final Lazy<SoundEvent> MALZENO = Lazy.of(() -> new SoundEvent
			(new ResourceLocation(NightSoulsMod.MOD_ID, "malzeno")));
	
	public static final Lazy<SoundEvent> DAVY_JONES = Lazy.of(() -> new SoundEvent
			(new ResourceLocation(NightSoulsMod.MOD_ID, "davy_jones")));
	
	public static final Lazy<SoundEvent> GIGACHAD = Lazy.of(() -> new SoundEvent
			(new ResourceLocation(NightSoulsMod.MOD_ID, "gigachad")));
	
	public static final Lazy<SoundEvent> PLANTERA = Lazy.of(() -> new SoundEvent
			(new ResourceLocation(NightSoulsMod.MOD_ID, "plantera")));
	
	public static final Lazy<SoundEvent> LIGHTER_ATMOSPHERE = Lazy.of(() -> new SoundEvent
			(new ResourceLocation(NightSoulsMod.MOD_ID, "lighter_atmosphere")));
	
	public static final Lazy<SoundEvent> BREAKING_BAD = Lazy.of(() -> new SoundEvent
			(new ResourceLocation(NightSoulsMod.MOD_ID, "breaking_bad")));
	
	public static final Lazy<SoundEvent> LOTTA_FEROCE = Lazy.of(() -> new SoundEvent
			(new ResourceLocation(NightSoulsMod.MOD_ID, "lotta_feroce")));
	
	public static final Lazy<SoundEvent> HERO = Lazy.of(() -> new SoundEvent
			(new ResourceLocation(NightSoulsMod.MOD_ID, "hero")));
	
	public static final Lazy<SoundEvent> AETHER = Lazy.of(() -> new SoundEvent
			(new ResourceLocation(NightSoulsMod.MOD_ID, "aether")));
	
	public static final Lazy<SoundEvent> IMAGINE_DRAGONS = Lazy.of(() -> new SoundEvent
			(new ResourceLocation(NightSoulsMod.MOD_ID, "imagine_dragons")));
	
	public static final Lazy<SoundEvent> PUCCI = Lazy.of(() -> new SoundEvent
			(new ResourceLocation(NightSoulsMod.MOD_ID, "pucci")));
	
	public static final Lazy<SoundEvent> JONATHAN = Lazy.of(() -> new SoundEvent
			(new ResourceLocation(NightSoulsMod.MOD_ID, "jonathan")));
	
	public static final Lazy<SoundEvent> GENDARMES = Lazy.of(() -> new SoundEvent
			(new ResourceLocation(NightSoulsMod.MOD_ID, "gendarmes")));
	
	public static final Lazy<SoundEvent> MADE_IN_ABYSS = Lazy.of(() -> new SoundEvent
			(new ResourceLocation(NightSoulsMod.MOD_ID, "made_in_abyss")));
	
	public static final Lazy<SoundEvent> THE_FIRST_LAYER = Lazy.of(() -> new SoundEvent
			(new ResourceLocation(NightSoulsMod.MOD_ID, "the_first_layer")));
	
	public static final Lazy<SoundEvent> HANEZEVE = Lazy.of(() -> new SoundEvent
			(new ResourceLocation(NightSoulsMod.MOD_ID, "hanezeve")));
	
	public static final Lazy<SoundEvent> PARAGON = Lazy.of(() -> new SoundEvent
			(new ResourceLocation(NightSoulsMod.MOD_ID, "paragon")));
	
	
	public static final Lazy<SoundEvent> AKAZA_BOSS = Lazy.of(() -> new SoundEvent
			(new ResourceLocation(NightSoulsMod.MOD_ID, "akaza_boss")));
	
	public static final Lazy<SoundEvent> EOC_BOSS = Lazy.of(() -> new SoundEvent
			(new ResourceLocation(NightSoulsMod.MOD_ID, "eoc_boss")));
	
	public static final Lazy<SoundEvent> KC_BOSS = Lazy.of(() -> new SoundEvent
			(new ResourceLocation(NightSoulsMod.MOD_ID, "kc_boss")));
	
	public static final Lazy<SoundEvent> TWINS_BOSS = Lazy.of(() -> new SoundEvent
			(new ResourceLocation(NightSoulsMod.MOD_ID, "twins_boss")));
	
	
	public static void register(IEventBus eventBus) {
        SOUNDS.register(eventBus);
    }
	
}
