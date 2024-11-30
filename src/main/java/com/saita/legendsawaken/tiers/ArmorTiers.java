package com.saita.legendsawaken.tiers;

import com.saita.legendsawaken.init.ItemInit;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;

public class ArmorTiers {
	
	//Durability, Defense, Enchantability, Armor Toughness, KR
	public static final ArmorMaterial MYTHRIL = new LegendsAwakenArmorMaterial("mythril", 42, new int[] { 3, 7, 8, 4 }, 20, SoundEvents.ARMOR_EQUIP_DIAMOND, 4.0F, 0.1F, () -> Ingredient.of(ItemInit.MYTHRIL_INGOT.get()));
	public static final ArmorMaterial INFERNAL = new LegendsAwakenArmorMaterial("infernal", 59, new int[] { 3, 7, 9, 4 }, 12, SoundEvents.ARMOR_EQUIP_NETHERITE, 6.0F, 0.1F, () -> Ingredient.of(ItemInit.INFERNAL_INGOT.get()));
	
	public static final ArmorMaterial TITANITE = new LegendsAwakenArmorMaterial("titanite", 74, new int[] { 4, 7, 9, 5 }, 15, SoundEvents.ARMOR_EQUIP_NETHERITE, 8.0F, 0.1F, () -> Ingredient.of(ItemInit.TITANITE_INGOT.get()));
	public static final ArmorMaterial DAMAGE_TITANITE = new LegendsAwakenArmorMaterial("damage_titanite", 74, new int[] { 4, 7, 9, 5 }, 15, SoundEvents.ARMOR_EQUIP_NETHERITE, 8.0F, 0.1F, () -> Ingredient.of(ItemInit.TITANITE_INGOT.get()));
	public static final ArmorMaterial TANKING_TITANITE = new LegendsAwakenArmorMaterial("tanking_titanite", 74, new int[] { 4, 7, 9, 5 }, 15, SoundEvents.ARMOR_EQUIP_NETHERITE, 12.0F, 0.1F, () -> Ingredient.of(ItemInit.TITANITE_INGOT.get()));
	public static final ArmorMaterial HEALING_TITANITE = new LegendsAwakenArmorMaterial("healing_titanite", 74, new int[] { 4, 7, 9, 5 }, 15, SoundEvents.ARMOR_EQUIP_NETHERITE, 8.0F, 0.1F, () -> Ingredient.of(ItemInit.TITANITE_INGOT.get()));
	public static final ArmorMaterial SPEED_TITANITE = new LegendsAwakenArmorMaterial("speed_titanite", 74, new int[] { 4, 7, 9, 5 }, 15, SoundEvents.ARMOR_EQUIP_NETHERITE, 8.0F, 0.1F, () -> Ingredient.of(ItemInit.TITANITE_INGOT.get()));


}
