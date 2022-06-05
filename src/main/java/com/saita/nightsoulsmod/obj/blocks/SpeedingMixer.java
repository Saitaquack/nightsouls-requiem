package com.saita.nightsoulsmod.obj.blocks;

import com.saita.nightsoulsmod.init.SoundInit;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

public class SpeedingMixer extends Block {

	public SpeedingMixer(Properties properties) {
		super(properties);

	}
	
	@Override
	public int getLightValue(BlockState state, IBlockReader world, BlockPos pos) {

		return 8;
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
	    	
		player.addPotionEffect(new EffectInstance(Effects.SPEED, 300, 2));
    	worldIn.playSound(player, player.getPosition(), SoundInit.SPEEDING.get(), SoundCategory.MASTER, 1.0F, 1.0F);
		
	   return super.onBlockActivated(state, worldIn, pos, player, handIn, hit);
	   
	}

}
