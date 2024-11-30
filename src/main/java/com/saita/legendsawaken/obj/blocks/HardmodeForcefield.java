package com.saita.legendsawaken.obj.blocks;

import com.saita.legendsawaken.util.HardmodeRequiemFunctions;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.GlassBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

public class HardmodeForcefield extends GlassBlock {

	public HardmodeForcefield(Properties p_49795_) {
		super(p_49795_);

	}
	
	@SuppressWarnings("deprecation")
	@Override
	public void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource source) {
		
		if(!level.isClientSide() && HardmodeRequiemFunctions.isHardmode(level)) {
					
				level.setBlockAndUpdate(pos, Blocks.AIR.defaultBlockState());		
		}		
		
		super.randomTick(state, level, pos, source);
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player,
			InteractionHand p_60507_, BlockHitResult p_60508_) {
		
		if(!level.isClientSide() && HardmodeRequiemFunctions.isHardmode((ServerLevel)level)) {
			
			level.setBlockAndUpdate(pos, Blocks.AIR.defaultBlockState());		
		}	

		return super.use(state, level, pos, player, p_60507_, p_60508_);
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public void attack(BlockState state, Level level, BlockPos pos, Player player) {	
		
		if(!level.isClientSide() && HardmodeRequiemFunctions.isHardmode((ServerLevel)level)) {
			
			level.setBlockAndUpdate(pos, Blocks.AIR.defaultBlockState());		
		}	

		super.attack(state, level, pos, player);
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public void entityInside(BlockState state, Level level, BlockPos pos, Entity entity) {
		
		if(!level.isClientSide() && HardmodeRequiemFunctions.isNotHardmode((ServerLevel)level)) {
			
			if(entity instanceof LivingEntity) {
				LivingEntity livingEntity = ((LivingEntity)entity);
				
				livingEntity.hurt(level.damageSources().magic(), 15.0F);
				livingEntity.addEffect(new MobEffectInstance(MobEffects.WITHER, 200, 3));
			}		
		}	
		
		super.entityInside(state, level, pos, entity);
	}

}
