package com.saita.legendsawaken.obj.blocks.petrified;

import com.saita.legendsawaken.init.BlockInit;
import com.saita.legendsawaken.util.HardmodeRequiemFunctions;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

public class PetrifiedTitaniteOre extends Block {
	
	BlockState hardmodeBlock = BlockInit.TITANITE_ORE.get().defaultBlockState();

	public PetrifiedTitaniteOre(Properties p_49795_) {
		super(p_49795_);
	
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource source) {
		
		if(!level.isClientSide() && HardmodeRequiemFunctions.isHardmode(level)) {
			
			level.setBlockAndUpdate(pos, hardmodeBlock);		
		}	
			
		super.randomTick(state, level, pos, source);
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public void onRemove(BlockState state, Level level, BlockPos pos, BlockState state2,
			boolean bool) {
		
		if(!level.isClientSide() && HardmodeRequiemFunctions.isHardmode((ServerLevel)level)) {
			
			level.setBlockAndUpdate(pos, hardmodeBlock);		
		}	
	
		super.onRemove(state, level, pos, state2, bool);
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public void attack(BlockState state, Level level, BlockPos pos, Player player) {
		
		if(!level.isClientSide() && HardmodeRequiemFunctions.isHardmode((ServerLevel)level)) {
			
			level.setBlockAndUpdate(pos, hardmodeBlock);		
		}	

		super.attack(state, level, pos, player);
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player,
			InteractionHand p_60507_, BlockHitResult p_60508_) {
		
		if(!level.isClientSide() && HardmodeRequiemFunctions.isHardmode((ServerLevel)level)) {
			
			level.setBlockAndUpdate(pos, hardmodeBlock);		
		}	

		return super.use(state, level, pos, player, p_60507_, p_60508_);
	}
	

}
