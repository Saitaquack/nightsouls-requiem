package com.saita.nightsoulsmod.obj.blocks;

import java.util.Random;

import com.saita.nightsoulsmod.entities.entity.AkazaEntity;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

public class DeathEyes extends Block {

	public DeathEyes(Properties properties) {
		super(properties);

	}
	
	@Override
	public boolean isAir(BlockState state, IBlockReader world, BlockPos pos) {
		
		return true;
	}
	
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
	      return VoxelShapes.empty();
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public void onEntityCollision(BlockState state, World worldIn, BlockPos pos, Entity entityIn) {
		
		if(entityIn instanceof LivingEntity && !(entityIn instanceof AkazaEntity))
		{
		
			((LivingEntity) entityIn).addPotionEffect(new EffectInstance(Effects.BLINDNESS, 60, 0));
			((LivingEntity) entityIn).addPotionEffect(new EffectInstance(Effects.SLOWNESS, 60, 1));
			((LivingEntity) entityIn).addPotionEffect(new EffectInstance(Effects.WEAKNESS, 60, 0));
		
		}
		
		super.onEntityCollision(state, worldIn, pos, entityIn);
	}
	
	@Override
	public boolean ticksRandomly(BlockState state) {
		
		return true;
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public void randomTick(BlockState state, ServerWorld worldIn, BlockPos pos, Random random) {

		worldIn.setBlockState(pos, Blocks.AIR.getDefaultState());
		
		super.randomTick(state, worldIn, pos, random);
	}

}
