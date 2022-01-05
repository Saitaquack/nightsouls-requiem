package com.saita.nightsoulsmod.obj.items;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Rarity;

public class NightSoulsOreIngot extends Item {

	public NightSoulsOreIngot(Properties properties) {
		super(properties);
	}
	
	@Override
	public Rarity getRarity(ItemStack stack) {

		return Rarity.UNCOMMON;
	}
	

}
