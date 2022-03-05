package com.saita.nightsoulsmod.obj.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;

public class MiizealiteBomb extends Block {

	public MiizealiteBomb(Properties properties) {
		super(properties);

	}
	
	@Override
	public void neighborChanged(BlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos, boolean isMoving) {
		 if(worldIn.isBlockPowered(pos))
		  {
			 if(!worldIn.isRemote)
	    	 {
				 worldIn.setBlockState(pos, Blocks.AIR.getDefaultState());
				 worldIn.createExplosion(null, pos.getX(), pos.getY(), pos.getZ(), 60.0F, Explosion.Mode.DESTROY);
	    	 }
		  }	      

	   }
	 
	@Override
	public void onBlockExploded(BlockState state, World world, BlockPos pos, Explosion explosion) {
		 
		 if(!world.isRemote)
    	 {
			 world.setBlockState(pos, Blocks.AIR.getDefaultState());
			 world.createExplosion(null, pos.getX(), pos.getY(), pos.getZ(), 60.0F, Explosion.Mode.DESTROY);
    	 }
		
		super.onBlockExploded(state, world, pos, explosion);
	}
}
