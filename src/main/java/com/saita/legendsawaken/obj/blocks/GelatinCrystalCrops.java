package com.saita.legendsawaken.obj.blocks;

import com.saita.legendsawaken.init.ItemInit;

import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition.Builder;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;

public class GelatinCrystalCrops extends CropBlock {
	
	public static final int MAX_AGE = 7;
	public static final IntegerProperty AGE = BlockStateProperties.AGE_7;

	public GelatinCrystalCrops(Properties p_52247_) {
		super(p_52247_);

	}
	
	@Override
	protected void createBlockStateDefinition(Builder<Block, BlockState> pBuilder) {
		pBuilder.add(AGE);
	}
	
	@Override
	protected ItemLike getBaseSeedId() {

		return ItemInit.GELATIN_CRYSTAL_SEEDS.get();
	}
	
	@Override
	public int getMaxAge() {

		return MAX_AGE;
	}
	
	@Override
	protected IntegerProperty getAgeProperty() {

		return AGE;
	}
	
}
