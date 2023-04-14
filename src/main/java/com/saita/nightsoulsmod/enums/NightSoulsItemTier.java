package com.saita.nightsoulsmod.enums;

import java.util.function.Supplier;

import com.saita.nightsoulsmod.init.ItemInit;

import net.minecraft.item.IItemTier;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.LazyValue;

public enum NightSoulsItemTier implements IItemTier
{
	SAITASTONE(6, 2031, 11.0F, 4.0F, 22, ()-> // Good damage, efficiency, enchant and armor. Average durability
	{ 
		return Ingredient.fromItems( ItemInit.SAITASTONE_INGOT.get()); 
	}),
	SAITASTONE_KATANA(6, 2031, 11.0F, 4.5F, 22, ()->  
	{ 
		return Ingredient.fromItems( ItemInit.SAITASTONE_INGOT.get()); 
	}),
	MIIZEALITE(6, 2031, 12.0F, 5.0F, 15, ()-> // Best damage and efficiency, average armor, durability and enchant.
	{ 
		return Ingredient.fromItems( ItemInit.MIIZEALITE_INGOT.get()); 
	}),
	CRANITE(6, 2131, 10.0F, 3.5F, 30, ()-> //Better durability and amazing enchant, average damage and efficiency, best armor.
	{ 
		return Ingredient.fromItems( ItemInit.CRANITE_INGOT.get()); 
	}),
	CRANITE_WARAXE(6, 2131, 10.0F, 4.0F, 30, ()-> 
	{ 
		return Ingredient.fromItems( ItemInit.CRANITE_INGOT.get()); 
	}),
	BASTIRITE(6, 2400, 11.0F, 3.0F, 15, ()-> //Best durability, better efficiency, average stats.
	{ 
		return Ingredient.fromItems( ItemInit.BASTIRITE_INGOT.get()); 
	}),
	NIGHTSOULPICK(5, 2031, 9.0F, 3.0F, 20, ()->
	{ 
		return Ingredient.fromItems( ItemInit.NIGHT_SOUL.get()); 
	}),
	BLOODZEAL(6, 2666, 12.0F, 11.0F, 22, ()->
	{ 
		return Ingredient.fromItems( ItemInit.NIGHT_SOUL.get()); 
	}),
	INSTAPICK(6, 4800, 40.0F, 5.0F, 15, ()-> 
	{ 
		return Ingredient.fromItems( ItemInit.NIGHT_SOUL.get()); 
	}),
	REINHARDT_HAMMER(6, 2800, 16.0F, 12.0F, 30, ()-> 
	{ 
		return Ingredient.fromItems( ItemInit.NIGHT_SOUL.get()); 
	}),
	PYRO_BARBARIAN_WARAXE(6, 2800, 16.0F, 12.0F, 30, ()-> 
	{ 
		return Ingredient.fromItems( ItemInit.NIGHT_SOUL.get()); 
	}),	
	WEALTH_DIGGER(6, 2400, 11.0F, 5.0F, 22, ()-> 
	{ 
		return Ingredient.fromItems( ItemInit.NIGHT_SOUL.get()); 
	}),
	DRAGON(6, 5000, 20.0F, 16.0F, 30, ()-> 
	{ 
		return Ingredient.fromItems( ItemInit.ENDER_DRAGON_ESSENCE.get()); 
	}),
	COOLFIRE(6, 2666, 12.0F, 9.5F, 30, ()-> 
	{ 
		return Ingredient.fromItems( ItemInit.NIGHT_SOUL.get()); 
	}),
	DEATH_SCYTHE(6, 2031, 12.0F, 10.0F, 15, ()->
	{ 
		return Ingredient.fromItems( ItemInit.MIIZEALITE_INGOT.get()); 
	}),
	CAT(6, 2031, 12.0F, 6.5F, 22, ()->
	{ 
		return Ingredient.fromItems( ItemInit.MIIZEALITE_INGOT.get()); 
	}),
	PSYCHO_KNIFE(6, 2031, 12.0F, 9.0F, 15, ()->
	{ 
		return Ingredient.fromItems( ItemInit.VILLAGER_BLOOD.get()); 
	}),
	BIOTIC_BLADE(6, 2400, 11.0F, -2.0F, 15, ()-> 
	{ 
		return Ingredient.fromItems( ItemInit.BASTIRITE_INGOT.get()); 
	}),
	WITHER(6, 4444, 20.0F, 14.5F, 30, ()-> 
	{ 
		return Ingredient.fromItems( ItemInit.WITHER_ESSENCE.get()); 
	}),
	CRAZY_DIAMOND(6, 2500, 12.0F, 6.5F, 30, ()->
	{ 
		return Ingredient.fromItems( ItemInit.CRAZY_DIAMOND.get()); 
	}),
	PRIMIUM(6, 2031, 12.0F, 4.0F, 22, ()->   // Good damage, enchant Average durability. Great efficiency
	{ 
		return Ingredient.fromItems( ItemInit.PRIMIUM_INGOT.get()); 
	}),
	ROWEQUITE(6, 2400, 10.0F, 3.5F, 20, ()-> // Great durability and average enchant, average damage and efficiency.
	{ 
		return Ingredient.fromItems( ItemInit.ROWEQUITE_INGOT.get()); 
	}),
	THERENITE(6, 2031, 11.0F, 4.0F, 30, ()-> // Good damage, efficiency. Average durability. Amazing enchant.
	{ 
		return Ingredient.fromItems( ItemInit.THERENITE_INGOT.get()); 
	}),
	CRIMSON_ARM(6, 6666, 14.0F, 24.0F, 22, ()-> 
	{ 
		return Ingredient.fromItems( Items.DIAMOND); 
	}),
	CARNAGE(6, 3000, 18.0F, 13.0F, 30, ()-> 
	{ 
		return Ingredient.fromItems( ItemInit.BLOOD_SAMPLE.get()); 
	}),
	
	//Dragonblade and Nanoblade
	DRAGONBLADE(6, 3000, 16.0F, 13.5F, 22, ()->
	{ 
		return Ingredient.fromItems( ItemInit.PRIMIUM_INGOT.get()); 
	}),
	NANOBLADE(6, 7200, 20.0F, 24.0F, 32, ()->
	{ 
		return Ingredient.fromItems( ItemInit.TRUE_NIGHT_SOUL.get()); 
	}),
	
	//True combos
	
	GOLDEN_REINHARDT_HAMMER(6, 7200, 20.0F, 25.0F, 30, ()->
	{ 
		return Ingredient.fromItems( ItemInit.TRUE_NIGHT_SOUL.get()); 
	}),
	RANCOR(6, 7200, 20.0F, 25.0F, 30, ()-> 
	{ 
		return Ingredient.fromItems( ItemInit.TRUE_NIGHT_SOUL.get()); 
	}),
	BLOOD_EDGE(6, 7200, 20.0F, 24.0F, 30, ()->
	{ 
		return Ingredient.fromItems( ItemInit.TRUE_NIGHT_SOUL.get()); 
	}),
	FRACTAL_BLADE(6, 7200, 20.0F, 22.0F, 30, ()->
	{ 
		return Ingredient.fromItems( ItemInit.TRUE_NIGHT_SOUL.get()); 
	}),
	
	//Chlorophyte
	
	CHLOROPHYTE(6, 7500, 30.0F, 20.0F, 35, ()-> 
	{ 
		return Ingredient.fromItems( ItemInit.CHLOROPHYTE_INGOT.get()); 
	}),
	
	
	//End game weapons
	
	HELLFIRE_EMPEROR_TRIDENT(6, 24000, 32.0F, 38.0F, 25, ()->  
	{ 
		return Ingredient.fromItems( ItemInit.TRUE_NIGHT_SOUL.get()); 
	}),
	SOUL_STEALER(6, 24000, 32.0F, 28.0F, 25, ()-> //Same for all the other end game weapons
	{ 
		return Ingredient.fromItems( ItemInit.TRUE_NIGHT_SOUL.get()); 
	}),
	FROSTBURN(6, 24000, 32.0F, 35.0F, 30, ()->  
	{ 
		return Ingredient.fromItems( ItemInit.TRUE_NIGHT_SOUL.get()); 
	}),
	DIVINE_SANCTION(6, 24000, 32.0F, 39.0F, 30, ()->  
	{ 
		return Ingredient.fromItems( ItemInit.TRUE_NIGHT_SOUL.get()); 
	}),
	GALACTIC_SLAYER(6, 24000, 32.0F, 42.0F, 30, ()->  
	{ 
		return Ingredient.fromItems( ItemInit.TRUE_NIGHT_SOUL.get()); 
	}),
	JAVA_FURY(6, 24000, 32.0F, 31.0F, 30, ()->  
	{ 
		return Ingredient.fromItems( ItemInit.TRUE_NIGHT_SOUL.get()); 
	}),
	SUPERNOVA(6, 24000, 32.0F, 35.0F, 30, ()->  
	{ 
		return Ingredient.fromItems( ItemInit.TRUE_NIGHT_SOUL.get()); 
	}),
	HEXADECIMATOR(6, 24000, 32.0F, 36.0F, 30, ()->  
	{ 
		return Ingredient.fromItems( ItemInit.TRUE_NIGHT_SOUL.get()); 
	}),
	
	//Paragonic Zenith
	
	PARAGONIC_ZENITH(6, 240000, 64.0F, 86.0F, 45, ()->  
	{ 
		return Ingredient.fromItems( ItemInit.PARAGONIC_BLOCK.get()); 
	});
    
	   private final int harvestLevel;
	   private final int maxUses;
	   private final float efficiency;
	   private final float attackDamage;
	   private final int enchantability;
	   private final LazyValue<Ingredient> repairMaterial;

	   private NightSoulsItemTier(int harvestLevelIn, int maxUsesIn, float efficiencyIn, float attackDamageIn, int enchantabilityIn,
	                    Supplier<Ingredient> repairMaterialIn)
	   {
	      this.harvestLevel = harvestLevelIn;
	      this.maxUses = maxUsesIn;
	      this.efficiency = efficiencyIn;
	      this.attackDamage = attackDamageIn;
	      this.enchantability = enchantabilityIn;
	      this.repairMaterial = new LazyValue<>(repairMaterialIn);
	   }

	   @Override
	   public int getMaxUses() {
	      return this.maxUses;
	   }

	   @Override
	   public float getEfficiency() {
	      return this.efficiency;
	   }

	   @Override
	   public float getAttackDamage() {
	      return this.attackDamage;
	   }

	   @Override
	   public int getHarvestLevel() {
	      return this.harvestLevel;
	   }

	   @Override
	   public int getEnchantability() {
	      return this.enchantability;
	   }

	   @Override
	   public Ingredient getRepairMaterial() {
	      return this.repairMaterial.getValue();
	   }
}
