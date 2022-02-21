package com.saita.nightsoulsmod.obj.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

public class Akazice extends Block {

	public Akazice(Properties properties) {
		super(properties);

	}
	
	@Override
	public int getLightValue(BlockState state, IBlockReader world, BlockPos pos) {
		
		return 15;
	}
	
	@Override
	public void animateTick(BlockState stateIn, World worldIn, BlockPos pos, Random rand) {
		
		if(worldIn.getGameTime() % 60 == 0)
		{
			worldIn.setBlockState(pos, Blocks.AIR.getDefaultState());
		}
		
		super.animateTick(stateIn, worldIn, pos, rand);
	}

}
