package com.saita.nightsoulsmod.obj.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorldReader;

public class HellfireCoalOre extends Block {

	public HellfireCoalOre(Properties properties) {
		super(properties);
		
	}
	
	@Override
	public int getExpDrop(BlockState state, IWorldReader world, BlockPos pos, int fortune, int silktouch) {
		
		return silktouch == 0 ? MathHelper.nextInt(RANDOM, 0, 2) : 0;
	}
	
	@Override
	public int getLightValue(BlockState state, IBlockReader world, BlockPos pos) {

		return 10;
	}
	
}
