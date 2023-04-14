package com.saita.nightsoulsmod.obj.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorldReader;

public class TrappedTrueNightSoul extends Block {

	public TrappedTrueNightSoul(Properties properties) {
		super(properties);

	}
	
	@Override
	public int getLightValue(BlockState state, IBlockReader world, BlockPos pos) {
		
		return 15;
	}
	
	@Override
    public int getExpDrop(BlockState state, IWorldReader world, BlockPos pos, int fortune, int silktouch) {
	
	return MathHelper.nextInt(RANDOM, 21, 28);
	
     }

}
