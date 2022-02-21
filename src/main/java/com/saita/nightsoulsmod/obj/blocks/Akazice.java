package com.saita.nightsoulsmod.obj.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.server.ServerWorld;

public class Akazice extends Block {

	public Akazice(Properties properties) {
		super(properties);

	}
	
	@Override
	public int getLightValue(BlockState state, IBlockReader world, BlockPos pos) {
		
		return 15;
	}
	
	@Override
	public boolean ticksRandomly(BlockState state) {
		
		return true;
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public void randomTick(BlockState state, ServerWorld worldIn, BlockPos pos, Random random) {

		worldIn.setBlockState(pos, Blocks.AIR.getDefaultState());
		
		super.randomTick(state, worldIn, pos, random);
	}

}
