package com.saita.legendsawaken.obj.blocks;

import java.util.Random;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.MagmaBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class InfernalStone extends MagmaBlock {

	public InfernalStone(Properties p_54800_) {
		super(p_54800_);

	}
	
	@Override
	public void playerDestroy(Level level, Player player, BlockPos pos, BlockState state,
			BlockEntity blockEntity, ItemStack stack) {
		
		Random rand = new Random();
		boolean spawnLava = rand.nextBoolean();
		
		if(spawnLava) {
			level.setBlockAndUpdate(pos, Blocks.LAVA.defaultBlockState());
		}

		super.playerDestroy(level, player, pos, state, blockEntity, stack);
	}

}
