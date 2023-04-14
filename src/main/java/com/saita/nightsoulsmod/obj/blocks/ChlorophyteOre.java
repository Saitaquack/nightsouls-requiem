package com.saita.nightsoulsmod.obj.blocks;

import java.util.Random;

import com.saita.nightsoulsmod.init.BlockInit;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.server.ServerWorld;

public class ChlorophyteOre extends Block{

	public ChlorophyteOre(Properties properties) {
		super(properties);

	}
	
	@Override
	public boolean ticksRandomly(BlockState state) {

		return true;
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public void randomTick(BlockState state, ServerWorld worldIn, BlockPos pos, Random random) {
		
		int randomGrow = random.nextInt(10);
		
		BlockPos pos1 = new BlockPos(pos.getX() + 1, pos.getY(), pos.getZ());
		BlockPos pos2 = new BlockPos(pos.getX(), pos.getY(), pos.getZ() - 1);
		BlockPos pos3 = new BlockPos(pos.getX() + 1, pos.getY(), pos.getZ() - 1);
		BlockPos pos4 = new BlockPos(pos.getX() - 1, pos.getY(), pos.getZ() + 1);
		BlockPos pos5 = new BlockPos(pos.getX(), pos.getY() + 1, pos.getZ());
		BlockPos pos6 = new BlockPos(pos.getX(), pos.getY() - 1, pos.getZ());
		
		if(worldIn.getBlockState(pos1) == BlockInit.CHLOROMUD.get().getDefaultState() && randomGrow == 0)
		{
			worldIn.setBlockState(pos1, BlockInit.CHLOROPHYTE_ORE.get().getDefaultState());
		}
		
		if(worldIn.getBlockState(pos2) == BlockInit.CHLOROMUD.get().getDefaultState() && randomGrow == 1)
		{
			worldIn.setBlockState(pos2, BlockInit.CHLOROPHYTE_ORE.get().getDefaultState());
		}
		
		if(worldIn.getBlockState(pos3) == BlockInit.CHLOROMUD.get().getDefaultState() && randomGrow == 2)
		{
			worldIn.setBlockState(pos3, BlockInit.CHLOROPHYTE_ORE.get().getDefaultState());
		}
		
		if(worldIn.getBlockState(pos4) == BlockInit.CHLOROMUD.get().getDefaultState() && randomGrow == 3)
		{
			worldIn.setBlockState(pos4, BlockInit.CHLOROPHYTE_ORE.get().getDefaultState());
		}
		
		if(worldIn.getBlockState(pos5) == BlockInit.CHLOROMUD.get().getDefaultState() && randomGrow == 4)
		{
			worldIn.setBlockState(pos5, BlockInit.CHLOROPHYTE_ORE.get().getDefaultState());
		}
		
		if(worldIn.getBlockState(pos6) == BlockInit.CHLOROMUD.get().getDefaultState() && randomGrow == 5)
		{
			worldIn.setBlockState(pos6, BlockInit.CHLOROPHYTE_ORE.get().getDefaultState());
		}
		
		super.randomTick(state, worldIn, pos, random);
	}
	
}
