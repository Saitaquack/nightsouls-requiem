package com.saita.nightsoulsmod.obj.items;

import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.ItemStack;

public class WoodenArmor extends ArmorItem {

	public WoodenArmor(IArmorMaterial materialIn, EquipmentSlotType slot, Properties builder) {
		super(materialIn, slot, builder);

	}
	
	@Override
	public int getBurnTime(ItemStack itemStack) {

		return 400;
	}

}
