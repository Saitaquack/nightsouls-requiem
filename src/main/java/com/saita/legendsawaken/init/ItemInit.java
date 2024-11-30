package com.saita.legendsawaken.init;

import com.saita.legendsawaken.LegendsAwakenMod;
import com.saita.legendsawaken.obj.items.*;
import com.saita.legendsawaken.tiers.ArmorTiers;
import com.saita.legendsawaken.tiers.ToolTiers;

import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.RecordItem;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.item.SwordItem;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ItemInit {
	
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, LegendsAwakenMod.MOD_ID);
	
	public static final RegistryObject<Item> DEMON_CORE = ITEMS.register("demon_core", () -> new DemonCore(new Item.Properties().stacksTo(1).rarity(Rarity.EPIC)));
	public static final RegistryObject<Item> NIGHT_SOUL = ITEMS.register("night_soul", () -> new Item(new Item.Properties().rarity(Rarity.UNCOMMON)));
	public static final RegistryObject<Item> MYTHRIL_INGOT = ITEMS.register("mythril_ingot", () -> new Item(new Item.Properties()));
	public static final RegistryObject<Item> RAW_MYTHRIL = ITEMS.register("raw_mythril", () -> new Item(new Item.Properties()));
	public static final RegistryObject<SwordItem> MYTHRIL_SWORD = ITEMS.register("mythril_sword", () -> new SwordItem(ToolTiers.MYTHRIL, 3, -2.4F, new Item.Properties()));
    public static final RegistryObject<AxeItem> MYTHRIL_AXE = ITEMS.register("mythril_axe",() -> new AxeItem(ToolTiers.MYTHRIL, 5.0F, -3.0F, new Item.Properties()));
    public static final RegistryObject<PickaxeItem> MYTHRIL_PICKAXE = ITEMS.register("mythril_pickaxe",() -> new MythrilPickaxe(ToolTiers.MYTHRIL, 1, -2.8F, new Item.Properties()));
    public static final RegistryObject<ShovelItem> MYTHRIL_SHOVEL = ITEMS.register("mythril_shovel",() -> new ShovelItem(ToolTiers.MYTHRIL, 1.5F, -3.0F, new Item.Properties()));
    public static final RegistryObject<HoeItem> MYTHRIL_HOE = ITEMS.register("mythril_hoe",() -> new HoeItem(ToolTiers.MYTHRIL, -7, 0.0F, new Item.Properties()));
    public static final RegistryObject<ArmorItem> MYTHRIL_HELMET = ITEMS.register("mythril_helmet", () -> new MythrilArmor(ArmorTiers.MYTHRIL, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<ArmorItem> MYTHRIL_CHESTPLATE = ITEMS.register("mythril_chestplate", () -> new MythrilChestplateSetBonus(ArmorTiers.MYTHRIL, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<ArmorItem> MYTHRIL_LEGGINGS = ITEMS.register("mythril_leggings", () -> new MythrilArmor(ArmorTiers.MYTHRIL, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<ArmorItem> MYTHRIL_BOOTS = ITEMS.register("mythril_boots", () -> new MythrilArmor(ArmorTiers.MYTHRIL, ArmorItem.Type.BOOTS, new Item.Properties()));
	public static final RegistryObject<Item> TITANITE_INGOT = ITEMS.register("titanite_ingot", () -> new Item(new Item.Properties().fireResistant()));
	public static final RegistryObject<Item> RAW_TITANITE = ITEMS.register("raw_titanite", () -> new Item(new Item.Properties().fireResistant()));
	public static final RegistryObject<Item> TITANITE_SCRAP = ITEMS.register("titanite_scrap", () -> new Item(new Item.Properties().fireResistant()));
	public static final RegistryObject<SwordItem> TITANITE_SWORD = ITEMS.register("titanite_sword", () -> new SwordItem(ToolTiers.TITANITE, 3, -2.4F, new Item.Properties().fireResistant()));
    public static final RegistryObject<AxeItem> TITANITE_AXE = ITEMS.register("titanite_axe",() -> new AxeItem(ToolTiers.TITANITE, 5.0F, -3.0F, new Item.Properties().fireResistant()));
    public static final RegistryObject<PickaxeItem> TITANITE_PICKAXE = ITEMS.register("titanite_pickaxe",() -> new TitanitePickaxe(ToolTiers.TITANITE, 1, -2.8F, new Item.Properties().fireResistant()));
    public static final RegistryObject<ShovelItem> TITANITE_SHOVEL = ITEMS.register("titanite_shovel",() -> new ShovelItem(ToolTiers.TITANITE, 1.5F, -3.0F, new Item.Properties().fireResistant()));
    public static final RegistryObject<HoeItem> TITANITE_HOE = ITEMS.register("titanite_hoe",() -> new HoeItem(ToolTiers.TITANITE, -11, 0.0F, new Item.Properties().fireResistant()));
    public static final RegistryObject<ArmorItem> TITANITE_HELMET = ITEMS.register("titanite_helmet", () -> new TitaniteArmor(ArmorTiers.TITANITE, ArmorItem.Type.HELMET, new Item.Properties().fireResistant()));
    public static final RegistryObject<ArmorItem> TITANITE_LEGGINGS = ITEMS.register("titanite_leggings", () -> new TitaniteArmor(ArmorTiers.TITANITE, ArmorItem.Type.LEGGINGS, new Item.Properties().fireResistant()));
    public static final RegistryObject<ArmorItem> TITANITE_BOOTS = ITEMS.register("titanite_boots", () -> new TitaniteArmor(ArmorTiers.TITANITE, ArmorItem.Type.BOOTS, new Item.Properties().fireResistant()));
    public static final RegistryObject<ArmorItem> DAMAGE_TITANITE_CHESTPLATE = ITEMS.register("damage_titanite_chestplate", () -> new DamageTitaniteChestplate(ArmorTiers.DAMAGE_TITANITE, ArmorItem.Type.CHESTPLATE, new Item.Properties().fireResistant()));
    public static final RegistryObject<ArmorItem> TANKING_TITANITE_CHESTPLATE = ITEMS.register("tanking_titanite_chestplate", () -> new TankingTitaniteChestplate(ArmorTiers.TANKING_TITANITE, ArmorItem.Type.CHESTPLATE, new Item.Properties().fireResistant()));
    public static final RegistryObject<ArmorItem> HEALING_TITANITE_CHESTPLATE = ITEMS.register("healing_titanite_chestplate", () -> new HealingTitaniteChestplate(ArmorTiers.HEALING_TITANITE, ArmorItem.Type.CHESTPLATE, new Item.Properties().fireResistant()));
    public static final RegistryObject<ArmorItem> SPEED_TITANITE_CHESTPLATE = ITEMS.register("speed_titanite_chestplate", () -> new SpeedTitaniteChestplate(ArmorTiers.SPEED_TITANITE, ArmorItem.Type.CHESTPLATE, new Item.Properties().fireResistant()));
	public static final RegistryObject<Item> SHADOW_ESSENCE = ITEMS.register("shadow_essence", () -> new Item(new Item.Properties()));
	public static final RegistryObject<Item> AMETHYST_LAUNCHER = ITEMS.register("amethyst_launcher", () -> new AmethystLauncher(new Item.Properties().stacksTo(1).rarity(Rarity.UNCOMMON)));
	public static final RegistryObject<Item> INFERNAL_INGOT = ITEMS.register("infernal_ingot", () -> new Item(new Item.Properties().fireResistant()));
	public static final RegistryObject<Item> INFERNAL_CHUNK = ITEMS.register("infernal_chunk", () -> new Item(new Item.Properties().fireResistant()));
	public static final RegistryObject<Item> INFERNAL_SCRAP = ITEMS.register("infernal_scrap", () -> new Item(new Item.Properties().fireResistant()));
	public static final RegistryObject<SwordItem> INFERNAL_SWORD = ITEMS.register("infernal_sword", () -> new InfernalSword(ToolTiers.INFERNAL, 3, -2.4F, new Item.Properties().fireResistant()));
    public static final RegistryObject<AxeItem> INFERNAL_AXE = ITEMS.register("infernal_axe",() -> new InfernalAxe(ToolTiers.INFERNAL, 5.0F, -3.0F, new Item.Properties().fireResistant()));
    public static final RegistryObject<PickaxeItem> INFERNAL_PICKAXE = ITEMS.register("infernal_pickaxe",() -> new InfernalPickaxe(ToolTiers.INFERNAL, 1, -2.8F, new Item.Properties().fireResistant()));
    public static final RegistryObject<ShovelItem> INFERNAL_SHOVEL = ITEMS.register("infernal_shovel",() -> new InfernalShovel(ToolTiers.INFERNAL, 1.5F, -3.0F, new Item.Properties().fireResistant()));
    public static final RegistryObject<HoeItem> INFERNAL_HOE = ITEMS.register("infernal_hoe",() -> new InfernalHoe(ToolTiers.INFERNAL, -9, 0.0F, new Item.Properties().fireResistant()));
    public static final RegistryObject<ArmorItem> INFERNAL_HELMET = ITEMS.register("infernal_helmet", () -> new InfernalArmor(ArmorTiers.INFERNAL, ArmorItem.Type.HELMET, new Item.Properties().fireResistant()));
    public static final RegistryObject<ArmorItem> INFERNAL_CHESTPLATE = ITEMS.register("infernal_chestplate", () -> new InfernalChestplateSetBonus(ArmorTiers.INFERNAL, ArmorItem.Type.CHESTPLATE, new Item.Properties().fireResistant()));
    public static final RegistryObject<ArmorItem> INFERNAL_LEGGINGS = ITEMS.register("infernal_leggings", () -> new InfernalArmor(ArmorTiers.INFERNAL, ArmorItem.Type.LEGGINGS, new Item.Properties().fireResistant()));
    public static final RegistryObject<ArmorItem> INFERNAL_BOOTS = ITEMS.register("infernal_boots", () -> new InfernalArmor(ArmorTiers.INFERNAL, ArmorItem.Type.BOOTS, new Item.Properties().fireResistant()));
	public static final RegistryObject<Item> ABYSSAL_COMPASS = ITEMS.register("abyssal_compass", () -> new AbyssalCompass(new Item.Properties().stacksTo(1).rarity(Rarity.EPIC)));
	public static final RegistryObject<Item> GELATIN_CRYSTAL = ITEMS.register("gelatin_crystal", () -> new GelatinCrystal(new Item.Properties().food(FoodInit.GELATIN_CRYSTAL)));
	public static final RegistryObject<Item> HARDENED_GELATIN_CRYSTAL = ITEMS.register("hardened_gelatin_crystal", () -> new Item(new Item.Properties()));
	public static final RegistryObject<Item> GELATIN_CRYSTAL_SEEDS = ITEMS.register("gelatin_crystal_seeds", () -> new ItemNameBlockItem(BlockInit.GELATIN_CRYSTAL_CROPS.get(), new Item.Properties()));
	public static final RegistryObject<Item> INSTANT_HEALING_POTION = ITEMS.register("instant_healing_potion", () -> new InstantHealingPotion(new Item.Properties().stacksTo(16)));
	public static final RegistryObject<Item> INSTANT_ABSORPTION_POTION = ITEMS.register("instant_absorption_potion", () -> new InstantAbsorptionPotion(new Item.Properties().stacksTo(16)));
	public static final RegistryObject<Item> MYTHRIL_ARROW = ITEMS.register("mythril_arrow", () -> new MythrilArrow(new Item.Properties()));
	public static final RegistryObject<Item> TITANITE_ARROW = ITEMS.register("titanite_arrow", () -> new TitaniteArrow(new Item.Properties()));
	public static final RegistryObject<SwordItem> DEATH_SCYTHE = ITEMS.register("death_scythe", () -> new DeathScythe(ToolTiers.DEATH_SCYTHE, 3, -2.4F, new Item.Properties().fireResistant()));
	public static final RegistryObject<Item> MOON_CHARM = ITEMS.register("moon_charm", () -> new MoonCharm(new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> VITAL_CRYSTAL = ITEMS.register("vital_crystal", () -> new VitalCrystal(new Item.Properties().stacksTo(16).rarity(Rarity.UNCOMMON)));
	public static final RegistryObject<Item> VITAL_CRYSTAL_SHARD = ITEMS.register("vital_crystal_shard", () -> new Item(new Item.Properties()));
	public static final RegistryObject<Item> SHADOW_HAND = ITEMS.register("shadow_hand", () -> new ShadowHand(new Item.Properties().stacksTo(16)));
	public static final RegistryObject<AxeItem> BARBARIAN_WARAXE = ITEMS.register("barbarian_waraxe",() -> new BarbarianWaraxe(ToolTiers.BARBARIAN, 5.0F, -3.0F, new Item.Properties().fireResistant().rarity(Rarity.UNCOMMON)));
	public static final RegistryObject<SwordItem> CRUSADER_HAMMER = ITEMS.register("crusader_hammer", () -> new CrusaderHammer(ToolTiers.CRUSADER, 3, -2.4F, new Item.Properties().fireResistant().rarity(Rarity.UNCOMMON)));
	public static final RegistryObject<Item> SUSPICIOUS_LOOKING_EYE = ITEMS.register("suspicious_looking_eye", () -> new SuspiciousLookingEye(new Item.Properties().stacksTo(1).rarity(Rarity.UNCOMMON)));
	public static final RegistryObject<Item> REQUIEM_KEY = ITEMS.register("requiem_key", () -> new RequiemKey(new Item.Properties().stacksTo(1).rarity(Rarity.EPIC)));
	public static final RegistryObject<Item> UNPOWERED_REQUIEM_KEY = ITEMS.register("unpowered_requiem_key", () -> new UnpoweredRequiemKey(new Item.Properties().stacksTo(1).rarity(Rarity.RARE)));
	public static final RegistryObject<Item> COSMOLITE_INGOT = ITEMS.register("cosmolite_ingot", () -> new Item(new Item.Properties().rarity(Rarity.RARE).fireResistant()));
	public static final RegistryObject<Item> DEMONITE_INGOT = ITEMS.register("demonite_ingot", () -> new Item(new Item.Properties().rarity(Rarity.RARE).fireResistant()));
	public static final RegistryObject<Item> SERAPHITE_INGOT = ITEMS.register("seraphite_ingot", () -> new Item(new Item.Properties().rarity(Rarity.RARE).fireResistant()));
	public static final RegistryObject<Item> WARPSTONE_INGOT = ITEMS.register("warpstone_ingot", () -> new Item(new Item.Properties().rarity(Rarity.RARE).fireResistant()));
	public static final RegistryObject<Item> RIGHT_HANDED_HELLFIRE_SHOTGUN = ITEMS.register("right_handed_hellfire_shotgun", () -> new HellfireShotgun(new Item.Properties().stacksTo(1).rarity(Rarity.RARE)));
	public static final RegistryObject<Item> LEFT_HANDED_HELLFIRE_SHOTGUN = ITEMS.register("left_handed_hellfire_shotgun", () -> new HellfireShotgun(new Item.Properties().stacksTo(1).rarity(Rarity.RARE)));
	
	public static final RegistryObject<Item> BOSS_ONE_MUSIC_DISC = ITEMS.register("boss_one_music_disc", () -> new RecordItem(15, SoundInit.BOSS_ONE.get(), (new Item.Properties()).stacksTo(1).rarity(Rarity.RARE), 2740));
	
	public static final RegistryObject<Item> CORRUPT_ZOMBIE_SPAWN_EGG = ITEMS.register("corrupt_zombie_spawn_egg", () -> new ForgeSpawnEggItem(EntityInit.CORRUPT_ZOMBIE, 0x005C5C, 0x6E30AA, new Item.Properties()));
	public static final RegistryObject<Item> CORRUPT_SPIDER_SPAWN_EGG = ITEMS.register("corrupt_spider_spawn_egg", () -> new ForgeSpawnEggItem(EntityInit.CORRUPT_SPIDER, 0x3C006F, 0x910707, new Item.Properties()));
	public static final RegistryObject<Item> WEREWOLF_SPAWN_EGG = ITEMS.register("werewolf_spawn_egg", () -> new ForgeSpawnEggItem(EntityInit.WEREWOLF, 0x203248, 0x597CA4, new Item.Properties()));
	public static final RegistryObject<Item> REAPER_SPAWN_EGG = ITEMS.register("reaper_spawn_egg", () -> new ForgeSpawnEggItem(EntityInit.REAPER, 0x0D0D0D, 0xA349A4, new Item.Properties()));
	public static final RegistryObject<Item> WENDIGO_SPAWN_EGG = ITEMS.register("wendigo_spawn_egg", () -> new ForgeSpawnEggItem(EntityInit.WENDIGO, 0x2A211D, 0xA0866F, new Item.Properties()));
	public static final RegistryObject<Item> ALTERNATE_SPAWN_EGG = ITEMS.register("alternate_spawn_egg", () -> new ForgeSpawnEggItem(EntityInit.ALTERNATE, 0x000000, 0xFFFFFF, new Item.Properties()));
	public static final RegistryObject<Item> PARTYGOER_SPAWN_EGG = ITEMS.register("partygoer_spawn_egg", () -> new ForgeSpawnEggItem(EntityInit.PARTYGOER, 0xE9BF2A, 0xBA2711, new Item.Properties()));
	public static final RegistryObject<Item> DEMON_EYE_SPAWN_EGG = ITEMS.register("demon_eye_spawn_egg", () -> new ForgeSpawnEggItem(EntityInit.DEMON_EYE, 0xE7E7E7, 0xD91919, new Item.Properties()));
	public static final RegistryObject<Item> STALKER_SPAWN_EGG = ITEMS.register("stalker_spawn_egg", () -> new ForgeSpawnEggItem(EntityInit.STALKER, 0x2A0505, 0xFFFFFF, new Item.Properties()));

	public static final RegistryObject<Item> CORE_OF_PEACE = ITEMS.register("core_of_peace", () -> new CoreOfPeace(new Item.Properties().stacksTo(1).rarity(Rarity.EPIC)));
	
	public static final RegistryObject<Item> HELLFIRE_BULLETS = ITEMS.register("hellfire_bullets", () -> new Item(new Item.Properties()));
	
	public static final RegistryObject<BlockItem> DEMON_CORE_BLOCK = ITEMS.register("demon_core_block", () -> new BlockItem(BlockInit.DEMON_CORE_BLOCK.get(), new Item.Properties().rarity(Rarity.EPIC)));
	public static final RegistryObject<BlockItem> TITANITE_BLOCK = ITEMS.register("titanite_block", () -> new BlockItem(BlockInit.TITANITE_BLOCK.get(), new Item.Properties().fireResistant()));
	public static final RegistryObject<BlockItem> RAW_TITANITE_BLOCK = ITEMS.register("raw_titanite_block", () -> new BlockItem(BlockInit.RAW_TITANITE_BLOCK.get(), new Item.Properties().fireResistant()));
	public static final RegistryObject<BlockItem> TITANITE_ORE = ITEMS.register("titanite_ore", () -> new BlockItem(BlockInit.TITANITE_ORE.get(), new Item.Properties().fireResistant()));
	public static final RegistryObject<BlockItem> DEEPSLATE_TITANITE_ORE = ITEMS.register("deepslate_titanite_ore", () -> new BlockItem(BlockInit.DEEPSLATE_TITANITE_ORE.get(), new Item.Properties().fireResistant()));
	public static final RegistryObject<BlockItem> TITANITE_BRICKS = ITEMS.register("titanite_bricks", () -> new BlockItem(BlockInit.TITANITE_BRICKS.get(), new Item.Properties().fireResistant()));
	public static final RegistryObject<BlockItem> TITANITE_BRICKS_STAIRS = ITEMS.register("titanite_bricks_stairs", () -> new BlockItem(BlockInit.TITANITE_BRICKS_STAIRS.get(), new Item.Properties().fireResistant()));
	public static final RegistryObject<BlockItem> TITANITE_BRICKS_SLAB = ITEMS.register("titanite_bricks_slab", () -> new BlockItem(BlockInit.TITANITE_BRICKS_SLAB.get(), new Item.Properties().fireResistant()));
	public static final RegistryObject<BlockItem> INFERNAL_STONE = ITEMS.register("infernal_stone", () -> new BlockItem(BlockInit.INFERNAL_STONE.get(), new Item.Properties().fireResistant()));
	public static final RegistryObject<BlockItem> INFERNAL_BLOCK = ITEMS.register("infernal_block", () -> new BlockItem(BlockInit.INFERNAL_BLOCK.get(), new Item.Properties().fireResistant()));
	public static final RegistryObject<BlockItem> INFERNAL_BRICKS = ITEMS.register("infernal_bricks", () -> new BlockItem(BlockInit.INFERNAL_BRICKS.get(), new Item.Properties().fireResistant()));
	public static final RegistryObject<BlockItem> INFERNAL_BRICKS_STAIRS = ITEMS.register("infernal_bricks_stairs", () -> new BlockItem(BlockInit.INFERNAL_BRICKS_STAIRS.get(), new Item.Properties().fireResistant()));
	public static final RegistryObject<BlockItem> INFERNAL_BRICKS_SLAB = ITEMS.register("infernal_bricks_slab", () -> new BlockItem(BlockInit.INFERNAL_BRICKS_SLAB.get(), new Item.Properties().fireResistant()));


	public static void register(IEventBus eventBus) {
		ITEMS.register(eventBus);
	}


}
