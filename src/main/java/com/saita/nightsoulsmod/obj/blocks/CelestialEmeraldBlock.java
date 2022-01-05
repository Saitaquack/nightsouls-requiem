package com.saita.nightsoulsmod.obj.blocks;

import com.saita.nightsoulsmod.init.SoundInit;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;

public class CelestialEmeraldBlock extends Block {

	public CelestialEmeraldBlock(Properties properties) {
		super(properties);

	}
	
	@Override
	public int getLightValue(BlockState state, IBlockReader world, BlockPos pos) {
		
		return 15;
	}
	
	@Override
    public int getExpDrop(BlockState state, IWorldReader world, BlockPos pos, int fortune, int silktouch) {
	
	return MathHelper.nextInt(RANDOM, 11, 18);
	
    }
	
	@Override
	public boolean propagatesSkylightDown(BlockState state, IBlockReader reader, BlockPos pos) {
		
	      return true;
	}
	
	@Override
	public void onBlockHarvested(World worldIn, BlockPos pos, BlockState state, PlayerEntity player) {
		
		worldIn.playSound(player, player.getPosition(), SoundInit.STAR_BIT.get(), SoundCategory.MASTER, 1.0F, 1.0F);
		
		super.onBlockHarvested(worldIn, pos, state, player);
	}
}
