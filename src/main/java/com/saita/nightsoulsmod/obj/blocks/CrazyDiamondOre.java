package com.saita.nightsoulsmod.obj.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.IWorldReader;

public class CrazyDiamondOre extends Block {

	public CrazyDiamondOre(Properties properties) {
		super(properties);

	}
	
    @Override
    public int getExpDrop(BlockState state, IWorldReader world, BlockPos pos, int fortune, int silktouch) {
    	
    	int xpAmount = 0;
    	
    	if(silktouch == 0)
    	{		
    		xpAmount = MathHelper.nextInt(RANDOM, 7, 11);
    	}
    	else
    	{
    		xpAmount = 0;
    	}
    	
		return xpAmount;
	
     }
	
}