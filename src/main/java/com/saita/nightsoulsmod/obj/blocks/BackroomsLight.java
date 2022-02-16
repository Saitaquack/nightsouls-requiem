package com.saita.nightsoulsmod.obj.blocks;

import java.util.Random;

import com.saita.nightsoulsmod.init.SoundInit;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

public class BackroomsLight extends Block {

	public BackroomsLight(Properties properties) {
		super(properties);

	}
	
	@Override
	public int getLightValue(BlockState state, IBlockReader world, BlockPos pos) {

		return 15;
	}
	
	@Override
	public void animateTick(BlockState stateIn, World worldIn, BlockPos pos, Random rand) {
		
        worldIn.playSound(pos.getX(), pos.getY(), pos.getZ(), SoundInit.BACKROOMS_LIGHT.get(), SoundCategory.BLOCKS, 0.2F, 1.0F, false);
		
		super.animateTick(stateIn, worldIn, pos, rand);
	}

}
