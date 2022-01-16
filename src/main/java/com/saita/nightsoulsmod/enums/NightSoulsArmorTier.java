package com.saita.nightsoulsmod.enums;

import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.LazyValue;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.function.Supplier;

import com.saita.nightsoulsmod.init.ItemInit;

public enum NightSoulsArmorTier implements IArmorMaterial
{
	
	 SAITASTONE("nightsouls:saitastone", 76, new int[] {3,7,8,4}, 22, //33 * 2.3  22 Defense
            SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 5.0F, 0.0F, () -> { return Ingredient.fromItems(ItemInit.SAITASTONE_INGOT.get());
     }),
	
	 MIIZEALITE("nightsouls:miizealite", 76, new int [] {3,6,8,4}, 15, //33 * 2.3  21 Defense
		     SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE, 5.0F, 0.0F, ()-> { return Ingredient.fromItems(ItemInit.MIIZEALITE_INGOT.get());
	 }),
	
	 CRANITE("nightsouls:cranite", 89, new int [] {3,7,9,4}, 30, //33 * 2.7    23 Defense
		     SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE , 6.0F, 0.0F, ()-> { return Ingredient.fromItems(ItemInit.CRANITE_INGOT.get());
	 }),
	
     BASTIRITE("nightsouls:bastirite", 99, new int [] {3,6,8,4}, 15, // 33 * 3   21 Defense 
		     SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND , 4.0F, 0.0F, ()-> { return Ingredient.fromItems(ItemInit.BASTIRITE_INGOT.get());
	 }),
     
	 FANTA_GLASSES("nightsouls:fanta_glasses", 8, new int [] {1,1,2,1}, 15, 
		     SoundEvents.ITEM_ARMOR_EQUIP_TURTLE , 0.0F, 0.0F, ()-> { return Ingredient.fromItems(Items.GLASS_PANE);
	 }),
	 
	 NIGHTSOULS_ESSENCE("nightsouls:nightsouls", 148, new int [] {4,7,9,5}, 30, // 33 * 4.5   25 Defense
		     SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND , 8.0F, 0.1F, ()-> { return Ingredient.fromItems(ItemInit.NIGHTSOULS_ESSENCE.get());
	 }),
	 
	 NECRO("nightsouls:necro", 89, new int [] {3,7,9,4}, 30, // 33 * 2.7   23 Defense
		     SoundEvents.ITEM_ARMOR_EQUIP_IRON , 6.0F, 0.1F, ()-> { return Ingredient.fromItems(ItemInit.NECROMANTIC_BONE.get());
	 }),
	  
	 DRAGON("nightsouls:dragon", 148, new int [] {4,7,9,5}, 30, // 33 * 4.5    25 Defense
		     SoundEvents.ITEM_ARMOR_EQUIP_LEATHER , 8.0F, 0.1F, ()-> { return Ingredient.fromItems(ItemInit.ENDER_DRAGON_ESSENCE.get());
	 }),
	 
	 WOODEN("nightsouls:wooden", 4, new int [] {1,2,2,1}, 15,  //  6 Defense
		     SoundEvents.ITEM_ARMOR_EQUIP_TURTLE , 0.0F, 0.0F, ()-> { return null;
	 }),
	 
	 VAMPIRE_MASK("nightsouls:vampire_mask", 6666, new int [] {1,1,1,1}, 6,  
		     SoundEvents.ENTITY_EVOKER_PREPARE_SUMMON , 0.0F, 0.4F, ()-> { return Ingredient.fromItems(Items.STONE);
	 }),
	 
	 PRIMIUM("nightsouls:primium", 76, new int [] {3,7,8,4}, 22, //33 * 2.3  22 Defense
		     SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND , 5.0F, 0.0F, ()-> { return Ingredient.fromItems(ItemInit.PRIMIUM_INGOT.get());
	 }),
	 
	 ROWEQUITE("nightsouls:rowequite", 89, new int [] {3,7,9,4}, 30, //33 * 2.7    23 Defense
		     SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND , 6.0F, 0.0F, ()-> { return Ingredient.fromItems(ItemInit.ROWEQUITE_INGOT.get());
	 }),
	 
	 THERENITE("nightsouls:therenite", 76, new int [] {3,7,8,4}, 22, //33 * 2.3  22 Defense
		     SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND , 5.0F, 0.0F, ()-> { return Ingredient.fromItems(ItemInit.THERENITE_INGOT.get());
	 }),
	 
	 CHAMPION("nightsouls:champion", 132, new int [] {4,7,9,4}, 30, // 33 * 4   24 Defense
		     SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND , 7.0F, 0.1F, ()-> { return Ingredient.fromItems(ItemInit.ROWEQUITE_INGOT.get());
	 }),
	 
	 JASON_MASK("nightsouls:jason", 49, new int [] {2,3,4,2}, 15, //33 * 1.5
		     SoundEvents.ITEM_ARMOR_EQUIP_TURTLE, 0.0F, 0.2F, ()-> { return Ingredient.fromItems(ItemInit.VILLAGER_BLOOD.get());
	 }),
	 
	 BLOODY("nightsouls:bloody", 106, new int[] {3,7,8,4}, 22, //76 * 1.4  22 Defense
	            SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 6.0F, 0.0F, () -> { return Ingredient.fromItems(ItemInit.BLOOD_SAMPLE.get());
	 }),
	 
	 //End game armors
	
	 HALLOWED_PALADIN("nightsouls:hallowed_paladin", 1000, new int [] {5,8,9,5}, 30,  // 28 Defense points
		     SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND , 15.0F, 0.1F, ()-> { return Ingredient.fromItems(ItemInit.TRUE_NIGHT_SOUL.get());
	 }),
	 HELLFIRE_EMPEROR("nightsouls:hellfire_emperor", 1000, new int [] {4,7,9,5}, 30, // 26 Defense points
		     SoundEvents.ITEM_ARMOR_EQUIP_CHAIN , 12.0F, 0.1F, ()-> { return Ingredient.fromItems(ItemInit.TRUE_NIGHT_SOUL.get());
	 }),
	 HELLFIRE_EMPEROR_CROWN("nightsouls:hellfire_emperor_crown", 1000, new int [] {4,7,9,5}, 30, // 26 Defense points
		     SoundEvents.ITEM_ARMOR_EQUIP_GOLD , 12.0F, 0.1F, ()-> { return Ingredient.fromItems(ItemInit.TRUE_NIGHT_SOUL.get());
	 }),
	 MILKY_WAY("nightsouls:milky_way", 1000, new int [] {4,8,9,5}, 30, // 27 Defense points
		     SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND , 12.0F, 0.1F, ()-> { return Ingredient.fromItems(ItemInit.TRUE_NIGHT_SOUL.get());
	 }),
	 BINARY("nightsouls:binary", 1000, new int [] {4,7,9,5}, 30, // 26 Defense points
		     SoundEvents.ITEM_ARMOR_EQUIP_IRON , 12.0F, 0.1F, ()-> { return Ingredient.fromItems(ItemInit.TRUE_NIGHT_SOUL.get());
	 }),
	
	//Paragonic NightSouls Armor
	
	 PARAGONIC_NIGHTSOULS("nightsouls:paragonic_nightsouls", 5000, new int [] {12,14,17,11}, 60,  // 42 Defense points
		     SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND , 40.0F, 0.2F, ()-> { return Ingredient.fromItems(ItemInit.PARAGONIC_BLOCK.get());
	 });



	 private static final int[] MAX_DAMAGE_ARRAY = new int[] {13, 15, 16, 11};
		private final String name;
		private final int maxDamageFactor;
		private final int[] damageReductionAmountArray;
		private final int enchantability;
		private final SoundEvent soundEvent;
		private final float toughness;
		private final float knockbackResistance;
		private final LazyValue<Ingredient> repairMaterial;
		
		
		private NightSoulsArmorTier(String nameIn, int maxDamageFactorIn, int[] damageReductionAmountIn,
				int enchantabilityIn, SoundEvent soundEventIn, float toughnessIn, float knockbackResistance, Supplier<Ingredient> repairMaterialIn)
		{
			this.name = nameIn;
			this.maxDamageFactor = maxDamageFactorIn;
			this.damageReductionAmountArray = damageReductionAmountIn;
			this.enchantability = enchantabilityIn;
			this.soundEvent = soundEventIn;
			this.toughness = toughnessIn;
			this.knockbackResistance = knockbackResistance;
			this.repairMaterial = new LazyValue<>(repairMaterialIn);
			
		}

		@Override
		public int getDurability(EquipmentSlotType slotIn) {
			
			return MAX_DAMAGE_ARRAY[slotIn.getIndex()] * this.maxDamageFactor;
		}

		@Override
		public int getDamageReductionAmount(EquipmentSlotType slotIn) {
			
			return this.damageReductionAmountArray[slotIn.getIndex()];
		}

		@Override
		public int getEnchantability() {
			
			return this.enchantability;
		}

		@Override
		public SoundEvent getSoundEvent() {
		
			return this.soundEvent;
		}

		@Override
		public Ingredient getRepairMaterial() {
			
			return this.repairMaterial.getValue();
		}
	    
		@OnlyIn(Dist.CLIENT)
		@Override
		public String getName() {
			
			return this.name;
		}

		@Override
		public float getToughness() {
		
			return this.toughness;
		}

		@Override
		public float getKnockbackResistance() {
			
			return this.knockbackResistance;
		}

}  