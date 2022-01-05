package com.saita.nightsoulsmod.obj.items;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Rarity;

public class NightSoulsOrePureIngot extends Item {

	public NightSoulsOrePureIngot(Properties properties) {
		super(properties);
	}
	
	@Override
	public Rarity getRarity(ItemStack stack) {

		return Rarity.RARE;
	}
	

}
