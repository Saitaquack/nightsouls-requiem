package com.saita.nightsoulsmod.obj.blockitems;

import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemStack;

public class HellfireCoalBlock extends BlockItem {

	public HellfireCoalBlock(Block blockIn, Properties builder) {
		super(blockIn, builder);

	}
	
	@Override
	public int getBurnTime(ItemStack stack) {
		
		return 32000;
	}

}
