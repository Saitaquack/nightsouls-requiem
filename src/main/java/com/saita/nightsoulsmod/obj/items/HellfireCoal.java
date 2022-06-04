package com.saita.nightsoulsmod.obj.items;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class HellfireCoal extends Item {

	public HellfireCoal(Properties properties) {
		super(properties);

	}
	
	@Override
	public int getBurnTime(ItemStack stack) {
		
		return 3200;
	}

}
