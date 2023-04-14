package com.saita.nightsoulsmod.obj.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.IWorldReader;

public class NightSoulsEmeraldOre extends Block {

	public NightSoulsEmeraldOre(Properties properties) {
		super(properties);
		
	}
	
	@Override
	public int getExpDrop(BlockState state, IWorldReader world, BlockPos pos, int fortune, int silktouch) {
		
		return silktouch == 0 ? MathHelper.nextInt(RANDOM, 3, 7) : 0;
	}
	
}
