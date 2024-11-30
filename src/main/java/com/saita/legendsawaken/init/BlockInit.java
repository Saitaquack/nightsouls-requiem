package com.saita.legendsawaken.init;

import java.util.function.Supplier;

import com.saita.legendsawaken.LegendsAwakenMod;
import com.saita.legendsawaken.obj.blocks.*;
import com.saita.legendsawaken.obj.blocks.petrified.*;

import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class BlockInit {
	
	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, LegendsAwakenMod.MOD_ID);
	
	public static final RegistryObject<Block> DEMON_CORE_BLOCK = BLOCKS.register("demon_core_block", () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).mapColor(MapColor.COLOR_PURPLE).strength(1.5F, 6.0F).sound(SoundType.GLASS).lightLevel((p_220867_) -> {
	      return 15;
	   }), UniformInt.of(30, 70)));	
	public static final RegistryObject<Block> MYTHRIL_BLOCK = registerBlock("mythril_block", () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).mapColor(MapColor.COLOR_CYAN).strength(10.0F, 1200.0F).requiresCorrectToolForDrops()));
	public static final RegistryObject<Block> RAW_MYTHRIL_BLOCK = registerBlock("raw_mythril_block", () -> new Block(BlockBehaviour.Properties.copy(Blocks.RAW_IRON_BLOCK).mapColor(MapColor.COLOR_CYAN).strength(10.0F, 1200.0F).requiresCorrectToolForDrops()));
	public static final RegistryObject<Block> MYTHRIL_ORE = registerBlock("mythril_ore", () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.IRON_ORE).mapColor(MapColor.STONE).strength(4.5F, 1200.0F).requiresCorrectToolForDrops()));
	public static final RegistryObject<Block> DEEPSLATE_MYTHRIL_ORE = registerBlock("deepslate_mythril_ore", () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE_IRON_ORE).mapColor(MapColor.DEEPSLATE).strength(6.0F, 1200.0F).sound(SoundType.DEEPSLATE).requiresCorrectToolForDrops()));
	public static final RegistryObject<Block> TITANITE_BLOCK = BLOCKS.register("titanite_block", () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).mapColor(MapColor.COLOR_RED).strength(12.5F, 1200.0F).requiresCorrectToolForDrops()));
	public static final RegistryObject<Block> RAW_TITANITE_BLOCK = BLOCKS.register("raw_titanite_block", () -> new Block(BlockBehaviour.Properties.copy(Blocks.RAW_IRON_BLOCK).mapColor(MapColor.COLOR_RED).strength(12.5F, 1200.0F).requiresCorrectToolForDrops()));
	public static final RegistryObject<Block> TITANITE_ORE = BLOCKS.register("titanite_ore", () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.IRON_ORE).mapColor(MapColor.STONE).strength(6.0F, 1200.0F).requiresCorrectToolForDrops()));
	public static final RegistryObject<Block> DEEPSLATE_TITANITE_ORE = BLOCKS.register("deepslate_titanite_ore", () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE_IRON_ORE).mapColor(MapColor.DEEPSLATE).strength(7.5F, 1200.0F).sound(SoundType.DEEPSLATE).requiresCorrectToolForDrops()));
	public static final RegistryObject<Block> MYTHRIL_BRICKS = registerBlock("mythril_bricks", () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).mapColor(MapColor.COLOR_CYAN).strength(7.5F, 1200.0F).requiresCorrectToolForDrops()));
	public static final RegistryObject<Block> MYTHRIL_BRICKS_STAIRS = registerBlock("mythril_bricks_stairs", () -> new StairBlock(() -> BlockInit.MYTHRIL_BRICKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(BlockInit.MYTHRIL_BRICKS.get())));
	public static final RegistryObject<Block> MYTHRIL_BRICKS_SLAB = registerBlock("mythril_bricks_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(BlockInit.MYTHRIL_BRICKS.get())));
	public static final RegistryObject<Block> TITANITE_BRICKS = BLOCKS.register("titanite_bricks", () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).mapColor(MapColor.COLOR_RED).strength(10.0F, 1200.0F).requiresCorrectToolForDrops()));
	public static final RegistryObject<Block> TITANITE_BRICKS_STAIRS = BLOCKS.register("titanite_bricks_stairs", () -> new StairBlock(() -> BlockInit.TITANITE_BRICKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(BlockInit.TITANITE_BRICKS.get())));
	public static final RegistryObject<Block> TITANITE_BRICKS_SLAB = BLOCKS.register("titanite_bricks_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(BlockInit.TITANITE_BRICKS.get())));
	public static final RegistryObject<Block> INFERNAL_STONE = BLOCKS.register("infernal_stone", () -> new InfernalStone(BlockBehaviour.Properties.copy(Blocks.ANCIENT_DEBRIS).mapColor(MapColor.COLOR_ORANGE).strength(15.0F, 1200.0F).requiresCorrectToolForDrops().lightLevel((p_220867_) -> {
	      return 15;
	})));
	public static final RegistryObject<Block> INFERNAL_BLOCK = BLOCKS.register("infernal_block", () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).mapColor(MapColor.COLOR_ORANGE).strength(15.0F, 1200.0F).requiresCorrectToolForDrops().lightLevel((p_220867_) -> {
	      return 15;
	})));
	public static final RegistryObject<Block> INFERNAL_BRICKS = BLOCKS.register("infernal_bricks", () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).mapColor(MapColor.COLOR_ORANGE).strength(10.0F, 1200.0F).requiresCorrectToolForDrops().lightLevel((p_220867_) -> {
	      return 15;
	})));
	public static final RegistryObject<Block> INFERNAL_BRICKS_STAIRS = BLOCKS.register("infernal_bricks_stairs", () -> new StairBlock(() -> BlockInit.INFERNAL_BRICKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(BlockInit.INFERNAL_BRICKS.get())));
	public static final RegistryObject<Block> INFERNAL_BRICKS_SLAB = BLOCKS.register("infernal_bricks_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(BlockInit.INFERNAL_BRICKS.get())));
	public static final RegistryObject<Block> HARDENED_GELATIN_CRYSTAL_BLOCK = registerBlock("hardened_gelatin_crystal_block", () -> new Block(BlockBehaviour.Properties.copy(Blocks.QUARTZ_BLOCK).mapColor(MapColor.COLOR_PURPLE).strength(2.0F, 4.0F).requiresCorrectToolForDrops().sound(SoundType.GLASS)));
	public static final RegistryObject<Block> GELATIN_CRYSTAL_CROPS = BLOCKS.register("gelatin_crystal_crops", () -> new GelatinCrystalCrops(BlockBehaviour.Properties.copy(Blocks.WHEAT).noOcclusion().noCollission()));
	
	public static final RegistryObject<Block> HARDMODE_FORCEFIELD = registerBlock("hardmode_forcefield", () -> new HardmodeForcefield(BlockBehaviour.Properties.copy(Blocks.BARRIER).mapColor(MapColor.COLOR_PURPLE).strength(-1.0F, 3600000.8F).randomTicks().noLootTable().noOcclusion().noParticlesOnBreak().pushReaction(PushReaction.BLOCK).lightLevel((p_220867_) -> {
	      return 8;
	})));
	public static final RegistryObject<Block> VITAL_CRYSTAL_ORE = registerBlock("vital_crystal_ore", () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.IRON_ORE).mapColor(MapColor.STONE).strength(4.5F, 1200.0F).sound(SoundType.GLASS).requiresCorrectToolForDrops(), UniformInt.of(5, 10)));
	public static final RegistryObject<Block> DEEPSLATE_VITAL_CRYSTAL_ORE = registerBlock("deepslate_vital_crystal_ore", () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE_IRON_ORE).mapColor(MapColor.DEEPSLATE).strength(6.0F, 1200.0F).sound(SoundType.GLASS).requiresCorrectToolForDrops(), UniformInt.of(5, 10)));
	public static final RegistryObject<Block> COSMOLITE_ORE = registerBlock("cosmolite_ore", () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.IRON_ORE).mapColor(MapColor.STONE).strength(6.0F, 1200.0F).requiresCorrectToolForDrops().lightLevel((p_220867_) -> {
	      return 8;
	})));
	public static final RegistryObject<Block> DEEPSLATE_COSMOLITE_ORE = registerBlock("deepslate_cosmolite_ore", () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE_IRON_ORE).mapColor(MapColor.DEEPSLATE).strength(7.5F, 1200.0F).sound(SoundType.DEEPSLATE).requiresCorrectToolForDrops().lightLevel((p_220867_) -> {
	      return 8;
	})));
	public static final RegistryObject<Block> DEMONITE_ORE = registerBlock("demonite_ore", () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.IRON_ORE).mapColor(MapColor.STONE).strength(6.0F, 1200.0F).requiresCorrectToolForDrops().lightLevel((p_220867_) -> {
	      return 8;
	})));
	public static final RegistryObject<Block> DEEPSLATE_DEMONITE_ORE = registerBlock("deepslate_demonite_ore", () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE_IRON_ORE).mapColor(MapColor.DEEPSLATE).strength(7.5F, 1200.0F).sound(SoundType.DEEPSLATE).requiresCorrectToolForDrops().lightLevel((p_220867_) -> {
	      return 8;
	})));
	public static final RegistryObject<Block> ABYSSAL_DEMONITE_ORE = registerBlock("abyssal_demonite_ore", () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.NETHER_QUARTZ_ORE).mapColor(MapColor.NETHER).strength(6.0F, 1200.0F).requiresCorrectToolForDrops().lightLevel((p_220867_) -> {
	      return 8;
	})));
	public static final RegistryObject<Block> SERAPHITE_ORE = registerBlock("seraphite_ore", () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.IRON_ORE).mapColor(MapColor.STONE).strength(6.0F, 1200.0F).requiresCorrectToolForDrops().lightLevel((p_220867_) -> {
	      return 8;
	})));
	public static final RegistryObject<Block> DEEPSLATE_SERAPHITE_ORE = registerBlock("deepslate_seraphite_ore", () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE_IRON_ORE).mapColor(MapColor.DEEPSLATE).strength(7.5F, 1200.0F).sound(SoundType.DEEPSLATE).requiresCorrectToolForDrops().lightLevel((p_220867_) -> {
	      return 8;
	})));
	public static final RegistryObject<Block> WARPSTONE_ORE = registerBlock("warpstone_ore", () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.IRON_ORE).mapColor(MapColor.STONE).strength(6.0F, 1200.0F).requiresCorrectToolForDrops().lightLevel((p_220867_) -> {
	      return 8;
	})));
	public static final RegistryObject<Block> DEEPSLATE_WARPSTONE_ORE = registerBlock("deepslate_warpstone_ore", () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE_IRON_ORE).mapColor(MapColor.DEEPSLATE).strength(7.5F, 1200.0F).sound(SoundType.DEEPSLATE).requiresCorrectToolForDrops().lightLevel((p_220867_) -> {
	      return 8;
	})));

	
	public static final RegistryObject<Block> PETRIFIED_MYTHRIL_ORE = registerBlock("petrified_mythril_ore", () -> new PetrifiedMythrilOre(BlockBehaviour.Properties.copy(Blocks.STONE).randomTicks()));
	public static final RegistryObject<Block> PETRIFIED_DEEPSLATE_MYTHRIL_ORE = registerBlock("petrified_deepslate_mythril_ore", () -> new PetrifiedDeepslateMythrilOre(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE).randomTicks()));
	public static final RegistryObject<Block> PETRIFIED_TITANITE_ORE = registerBlock("petrified_titanite_ore", () -> new PetrifiedTitaniteOre(BlockBehaviour.Properties.copy(Blocks.STONE).randomTicks()));
	public static final RegistryObject<Block> PETRIFIED_DEEPSLATE_TITANITE_ORE = registerBlock("petrified_deepslate_titanite_ore", () -> new PetrifiedDeepslateTitaniteOre(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE).randomTicks()));
	public static final RegistryObject<Block> PETRIFIED_INFERNAL_STONE = registerBlock("petrified_infernal_stone", () -> new PetrifiedInfernalStone(BlockBehaviour.Properties.copy(Blocks.NETHERRACK).randomTicks()));
	public static final RegistryObject<Block> PETRIFIED_VITAL_CRYSTAL_ORE = registerBlock("petrified_vital_crystal_ore", () -> new PetrifiedVitalCrystalOre(BlockBehaviour.Properties.copy(Blocks.STONE).randomTicks()));
	public static final RegistryObject<Block> PETRIFIED_DEEPSLATE_VITAL_CRYSTAL_ORE = registerBlock("petrified_deepslate_vital_crystal_ore", () -> new PetrifiedDeepslateVitalCrystalOre(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE).randomTicks()));
	public static final RegistryObject<Block> PETRIFIED_COSMOLITE_ORE = registerBlock("petrified_cosmolite_ore", () -> new PetrifiedCosmoliteOre(BlockBehaviour.Properties.copy(Blocks.STONE).randomTicks()));
	public static final RegistryObject<Block> PETRIFIED_DEEPSLATE_COSMOLITE_ORE = registerBlock("petrified_deepslate_cosmolite_ore", () -> new PetrifiedDeepslateCosmoliteOre(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE).randomTicks()));
	public static final RegistryObject<Block> PETRIFIED_DEMONITE_ORE = registerBlock("petrified_demonite_ore", () -> new PetrifiedDemoniteOre(BlockBehaviour.Properties.copy(Blocks.STONE).randomTicks()));
	public static final RegistryObject<Block> PETRIFIED_DEEPSLATE_DEMONITE_ORE = registerBlock("petrified_deepslate_demonite_ore", () -> new PetrifiedDeepslateDemoniteOre(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE).randomTicks()));
	public static final RegistryObject<Block> PETRIFIED_ABYSSAL_DEMONITE_ORE = registerBlock("petrified_abyssal_demonite_ore", () -> new PetrifiedAbyssalDemoniteOre(BlockBehaviour.Properties.copy(Blocks.NETHERRACK).randomTicks()));
	public static final RegistryObject<Block> PETRIFIED_SERAPHITE_ORE = registerBlock("petrified_seraphite_ore", () -> new PetrifiedSeraphiteOre(BlockBehaviour.Properties.copy(Blocks.STONE).randomTicks()));
	public static final RegistryObject<Block> PETRIFIED_DEEPSLATE_SERAPHITE_ORE = registerBlock("petrified_deepslate_seraphite_ore", () -> new PetrifiedDeepslateSeraphiteOre(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE).randomTicks()));
	public static final RegistryObject<Block> PETRIFIED_WARPSTONE_ORE = registerBlock("petrified_warpstone_ore", () -> new PetrifiedWarpstoneOre(BlockBehaviour.Properties.copy(Blocks.STONE).randomTicks()));
	public static final RegistryObject<Block> PETRIFIED_DEEPSLATE_WARPSTONE_ORE = registerBlock("petrified_deepslate_warpstone_ore", () -> new PetrifiedDeepslateWarpstoneOre(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE).randomTicks()));
	
	    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
	        RegistryObject<T> toReturn = BLOCKS.register(name, block);
	        registerBlockItem(name, toReturn);
	        return toReturn;
	    }

	    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
	        return ItemInit.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
	    }

	    public static void register(IEventBus eventBus) {
	        BLOCKS.register(eventBus);
	    }
	    
}
