package com.saita.nightsoulsmod.obj.blockitems;

import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Rarity;
import net.minecraft.util.math.BlockPos;

public class MeteoriteBlock extends BlockItem {
	
	BlockPos requiemBlockPos = new BlockPos(0,0,0);

	public MeteoriteBlock(Block blockIn, Properties builder) {
		super(blockIn, builder);

	}
	
	@Override
	public Rarity getRarity(ItemStack stack) {
		
		return Rarity.RARE;
	}

}
