package com.saita.legendsawaken.tiers;

import java.util.List;

import com.saita.legendsawaken.LegendsAwakenMod;
import com.saita.legendsawaken.init.ItemInit;
import com.saita.legendsawaken.init.TagsInit;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.common.TierSortingRegistry;

public class ToolTiers {
	
	public static Tier MYTHRIL;
	public static Tier INFERNAL;
	public static Tier TITANITE;
	public static Tier DEATH_SCYTHE;
	public static Tier BARBARIAN;
	public static Tier CRUSADER;
	
	// Level, Durability, Speed, Damage, Enchantability, Tag, Ingredient
	
	static {
		
		MYTHRIL = TierSortingRegistry.registerTier(new ForgeTier(5, 2540, 11.0F, 7.0F, 20,
				TagsInit.Blocks.NEEDS_MYTHRIL_TOOL, () -> Ingredient.of(ItemInit.MYTHRIL_INGOT.get())), 
				new ResourceLocation(LegendsAwakenMod.MOD_ID, "mythril"), List.of(Tiers.NETHERITE), List.of());	
		
		INFERNAL = TierSortingRegistry.registerTier(new ForgeTier(6, 3251, 12.5F, 9.0F, 12, 
				TagsInit.Blocks.NEEDS_INFERNAL_TOOL, () -> Ingredient.of(ItemInit.INFERNAL_INGOT.get())), 
				new ResourceLocation(LegendsAwakenMod.MOD_ID, "infernal"), List.of(MYTHRIL), List.of());	
		
		TITANITE = TierSortingRegistry.registerTier(new ForgeTier(7, 4064, 14.0F, 11.0F, 15, 
				TagsInit.Blocks.NEEDS_TITANITE_TOOL, () -> Ingredient.of(ItemInit.TITANITE_INGOT.get())), 
				new ResourceLocation(LegendsAwakenMod.MOD_ID, "titanite"), List.of(INFERNAL), List.of());	
		
		
		DEATH_SCYTHE = TierSortingRegistry.registerTier(new ForgeTier(7, 3666, 14.0F, 10.5F, 10, 
				TagsInit.Blocks.NEEDS_TITANITE_TOOL, () -> Ingredient.of(ItemInit.TITANITE_INGOT.get())), 
				new ResourceLocation(LegendsAwakenMod.MOD_ID, "death_scythe"), List.of(), List.of());		
		
		BARBARIAN = TierSortingRegistry.registerTier(new ForgeTier(7, 4564, 16.0F, 14.0F, 10, 
				TagsInit.Blocks.NEEDS_TITANITE_TOOL, () -> Ingredient.of(ItemInit.NIGHT_SOUL.get())), 
				new ResourceLocation(LegendsAwakenMod.MOD_ID, "barbarian"), List.of(), List.of());	
		
		CRUSADER = TierSortingRegistry.registerTier(new ForgeTier(7, 4564, 16.0F, 14.0F, 10, 
				TagsInit.Blocks.NEEDS_TITANITE_TOOL, () -> Ingredient.of(ItemInit.NIGHT_SOUL.get())), 
				new ResourceLocation(LegendsAwakenMod.MOD_ID, "crusader"), List.of(), List.of());
	}

}
