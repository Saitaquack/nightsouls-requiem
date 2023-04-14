package com.saita.nightsoulsmod.obj.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;

public class SuperNightSoulsEmeraldBlock extends Block {

	public SuperNightSoulsEmeraldBlock(Properties properties) {
		super(properties);
		
	}
	
	@Override
	public int getLightValue(BlockState state, IBlockReader world, BlockPos pos) {

		return 15;
	}
	
}
