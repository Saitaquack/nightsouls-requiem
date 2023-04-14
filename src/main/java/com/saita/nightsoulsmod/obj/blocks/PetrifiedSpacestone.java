package com.saita.nightsoulsmod.obj.blocks;

import java.util.Random;

import com.saita.nightsoulsmod.init.BlockInit;
import com.saita.nightsoulsmod.obj.items.RequiemKey;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;


public class PetrifiedSpacestone extends Block {
	
	public PetrifiedSpacestone(Properties properties) {
		super(properties);
	}
	
	@Override
	public boolean ticksRandomly(BlockState state) {

		return true;
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public void randomTick(BlockState state, ServerWorld worldIn, BlockPos pos, Random random) {
		
		if(worldIn.getDayTime() >= RequiemKey.requiemConstant)
		   {	
			  worldIn.setBlockState(pos, BlockInit.SPACESTONE.get().getDefaultState());
   	       }
		
		super.randomTick(state, worldIn, pos, random);
	}
	
	
	@SuppressWarnings("deprecation")
	@Override
	public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player,
			Hand handIn, BlockRayTraceResult hit) {
		
		if(worldIn.getDayTime() >= RequiemKey.requiemConstant)
		   {	
			  worldIn.setBlockState(pos, BlockInit.SPACESTONE.get().getDefaultState());
 	       }

		return super.onBlockActivated(state, worldIn, pos, player, handIn, hit);
	}
	
	@Override
	public void harvestBlock(World worldIn, PlayerEntity player, BlockPos pos, BlockState state, TileEntity te,
			ItemStack stack) {
		
		if(worldIn.getDayTime() >= RequiemKey.requiemConstant)
		   {	
			  worldIn.setBlockState(pos, BlockInit.SPACESTONE.get().getDefaultState());
	        }
		 
		super.harvestBlock(worldIn, player, pos, state, te, stack);
	}

	
	@SuppressWarnings("deprecation")
	@Override
	public void onBlockAdded(BlockState state, World worldIn, BlockPos pos, BlockState oldState, boolean isMoving) {
		
		if(worldIn.getDayTime() >= RequiemKey.requiemConstant)
		   {	
	    	  worldIn.setBlockState(pos, BlockInit.SPACESTONE.get().getDefaultState());
           }

		super.onBlockAdded(state, worldIn, pos, oldState, isMoving);
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public void onBlockClicked(BlockState state, World worldIn, BlockPos pos, PlayerEntity player) {
		
		if(worldIn.getDayTime() >= RequiemKey.requiemConstant)
		   {	
	    	  worldIn.setBlockState(pos, BlockInit.SPACESTONE.get().getDefaultState());
		   }
		
		super.onBlockClicked(state, worldIn, pos, player);
	}
	
}
