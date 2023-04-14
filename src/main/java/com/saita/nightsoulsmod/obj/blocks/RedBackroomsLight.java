package com.saita.nightsoulsmod.obj.blocks;

import java.util.Random;

import com.saita.nightsoulsmod.init.SoundInit;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

public class RedBackroomsLight extends Block {

	public RedBackroomsLight(Properties properties) {
		super(properties);

	}
	
	@Override
	public int getLightValue(BlockState state, IBlockReader world, BlockPos pos) {
		
		return 7;
	}
	
	@Override
	public void animateTick(BlockState stateIn, World worldIn, BlockPos pos, Random rand) {

		int alarm = rand.nextInt(10);
		
		if(alarm == 0)
		{
			worldIn.playSound(pos.getX(), pos.getY(), pos.getZ(), SoundInit.RUN.get(), SoundCategory.BLOCKS, 0.5F, 1.0F, false);
		}
		
		super.animateTick(stateIn, worldIn, pos, rand);
	}

}
