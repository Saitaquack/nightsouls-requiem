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
	
	//33 -> Valeur du diamant
	//38 - > Valeur Netherite
	
	 SAITASTONE("nightsouls:saitastone", 40, new int[] {3,6,8,4}, 22, //21 Defense
            SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 1.0F, 0.0F, () -> { return Ingredient.fromItems(ItemInit.SAITASTONE_INGOT.get());
     }),
	
	 MIIZEALITE("nightsouls:miizealite", 40, new int [] {3,6,8,3}, 15, //20 Defense
		     SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE, 1.0F, 0.0F, ()-> { return Ingredient.fromItems(ItemInit.MIIZEALITE_INGOT.get());
	 }),
	
	 CRANITE("nightsouls:cranite", 45, new int [] {3,7,8,4}, 30, //22 Defense
		     SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE , 1.0F, 0.0F, ()-> { return Ingredient.fromItems(ItemInit.CRANITE_INGOT.get());
	 }),
	
     BASTIRITE("nightsouls:bastirite", 55, new int [] {3,6,8,3}, 15, // 20 Defense 
		     SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND , 1.0F, 0.0F, ()-> { return Ingredient.fromItems(ItemInit.BASTIRITE_INGOT.get());
	 }),
     
	 FANTA_GLASSES("nightsouls:fanta_glasses", 8, new int [] {1,1,2,1}, 15, 
		     SoundEvents.ITEM_ARMOR_EQUIP_TURTLE , 0.0F, 0.0F, ()-> { return Ingredient.fromItems(Items.GLASS_PANE);
	 }),
	 
	 NIGHTSOULS_ESSENCE("nightsouls:nightsouls", 110, new int [] {4,7,9,5}, 30, // 25 Defense
		     SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND , 5.0F, 0.1F, ()-> { return Ingredient.fromItems(ItemInit.NIGHTSOULS_ESSENCE.get());
	 }),
	 
	 NECRO("nightsouls:necro", 80, new int [] {4,7,8,4}, 30, // 23 Defense
		     SoundEvents.ITEM_ARMOR_EQUIP_IRON , 2.0F, 0.0F, ()-> { return Ingredient.fromItems(ItemInit.NECROMANTIC_BONE.get());
	 }),
	  
	 DRAGON("nightsouls:dragon", 160, new int [] {5,8,9,5}, 30, // 27 Defense
		     SoundEvents.ITEM_ARMOR_EQUIP_LEATHER , 8.0F, 0.1F, ()-> { return Ingredient.fromItems(ItemInit.ENDER_DRAGON_ESSENCE.get());
	 }),
	 
	 WOODEN("nightsouls:wooden", 4, new int [] {1,2,2,1}, 15,  //  6 Defense
		     SoundEvents.ITEM_ARMOR_EQUIP_TURTLE , 0.0F, 0.0F, ()-> { return null;
	 }),
	 
	 VAMPIRE_MASK("nightsouls:vampire_mask", 6666, new int [] {1,1,1,1}, 6,  
		     SoundEvents.ENTITY_EVOKER_PREPARE_SUMMON , 0.0F, 0.4F, ()-> { return Ingredient.fromItems(Items.STONE);
	 }),
	 
	 PRIMIUM("nightsouls:primium", 40, new int [] {3,6,8,4}, 22, // 21 Defense
		     SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND , 1.0F, 0.0F, ()-> { return Ingredient.fromItems(ItemInit.PRIMIUM_INGOT.get());
	 }),
	 
	 ROWEQUITE("nightsouls:rowequite", 55, new int [] {3,7,8,4}, 30, // 22 Defense
		     SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND , 1.0F, 0.0F, ()-> { return Ingredient.fromItems(ItemInit.ROWEQUITE_INGOT.get());
	 }),
	 
	 THERENITE("nightsouls:therenite", 40, new int [] {3,6,8,4}, 22, // 21 Defense
		     SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND , 1.0F, 0.0F, ()-> { return Ingredient.fromItems(ItemInit.THERENITE_INGOT.get());
	 }),
	 
	 CHAMPION("nightsouls:champion", 90, new int [] {4,7,8,5}, 30, // 24 Defense
		     SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND , 3.0F, 0.1F, ()-> { return Ingredient.fromItems(ItemInit.ROWEQUITE_INGOT.get());
	 }),
	 
	 JASON_MASK("nightsouls:jason", 40, new int [] {2,3,4,2}, 15,
		     SoundEvents.ITEM_ARMOR_EQUIP_TURTLE, 0.0F, 0.2F, ()-> { return Ingredient.fromItems(ItemInit.VILLAGER_BLOOD.get());
	 }),
	 
	 BLOODY("nightsouls:bloody", 70, new int[] {3,7,8,4}, 22, // 22 Defense
	         SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 2.0F, 0.0F, () -> { return Ingredient.fromItems(ItemInit.BLOOD_SAMPLE.get());
	 }),
	 
	 ALTERNATE("nightsouls:alternate", 70, new int [] {3,7,8,4}, 15, // 22 Defense 
		     SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND , 2.0F, 0.0F, ()-> { return Ingredient.fromItems(ItemInit.ALTERNATE_INGOT.get());
	 }),
	 
	 CHLOROPHYTE("nightsouls:chlorophyte", 180, new int [] {5,8,9,5}, 30, // 27 Defense
		     SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND , 8.0F, 0.1F, ()-> { return Ingredient.fromItems(ItemInit.CHLOROPHYTE_INGOT.get());
	 }),
	 
	 //End game armors
	
	 HALLOWED_PALADIN("nightsouls:hallowed_paladin", 1000, new int [] {7,10,11,7}, 30,  // 35 Defense points
		     SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND , 18.0F, 0.1F, ()-> { return Ingredient.fromItems(ItemInit.TRUE_NIGHT_SOUL.get());
	 }),
	 HELLFIRE_EMPEROR("nightsouls:hellfire_emperor", 1000, new int [] {6,9,10,7}, 30, // 32 Defense points
		     SoundEvents.ITEM_ARMOR_EQUIP_CHAIN , 12.0F, 0.1F, ()-> { return Ingredient.fromItems(ItemInit.TRUE_NIGHT_SOUL.get());
	 }),
	 HELLFIRE_EMPEROR_CROWN("nightsouls:hellfire_emperor_crown", 1000, new int [] {6,9,10,7}, 30, // 32 Defense points
		     SoundEvents.ITEM_ARMOR_EQUIP_GOLD , 12.0F, 0.1F, ()-> { return Ingredient.fromItems(ItemInit.TRUE_NIGHT_SOUL.get());
	 }),
	 MILKY_WAY("nightsouls:milky_way", 1000, new int [] {6,9,10,7}, 30, // 32 Defense points
		     SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND , 12.0F, 0.1F, ()-> { return Ingredient.fromItems(ItemInit.TRUE_NIGHT_SOUL.get());
	 }),
	 BINARY("nightsouls:binary", 1000, new int [] {6,9,10,7}, 30, // 32 Defense points
		     SoundEvents.ITEM_ARMOR_EQUIP_IRON , 12.0F, 0.1F, ()-> { return Ingredient.fromItems(ItemInit.TRUE_NIGHT_SOUL.get());
	 }),
	
	//Paragonic NightSouls Armor
	
	 PARAGONIC_NIGHTSOULS("nightsouls:paragonic_nightsouls", 8000, new int [] {10,12,16,10}, 60,  // 48 Defense points
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