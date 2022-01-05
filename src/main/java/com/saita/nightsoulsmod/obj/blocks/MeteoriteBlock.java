package com.saita.nightsoulsmod.obj.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

public class MeteoriteBlock extends Block {

	public MeteoriteBlock(Properties properties) {
		super(properties);
		
	}
	
	@Override
	public int getLightValue(BlockState state, IBlockReader world, BlockPos pos) {

		return 10;
	}
	
	@Override
	public void onEntityWalk(World worldIn, BlockPos pos, Entity entityIn) {
		
		if (!entityIn.isImmuneToFire() && entityIn instanceof LivingEntity 
			&& !EnchantmentHelper.hasFrostWalker((LivingEntity)entityIn) && !entityIn.isInWater()) {
			
	         entityIn.attackEntityFrom(DamageSource.HOT_FLOOR, 1.0F);
	         entityIn.setFire(5);
	         
	      }
		
		super.onEntityWalk(worldIn, pos, entityIn);
	}
	
}
