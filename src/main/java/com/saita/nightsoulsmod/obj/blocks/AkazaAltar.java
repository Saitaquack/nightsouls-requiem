package com.saita.nightsoulsmod.obj.blocks;

import com.saita.nightsoulsmod.entities.entity.AkazaEntity;
import com.saita.nightsoulsmod.init.NightSoulsEntityTypes;
import com.saita.nightsoulsmod.init.SoundInit;
import com.saita.nightsoulsmod.obj.items.RequiemKey;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.Difficulty;
import net.minecraft.world.Explosion;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

public class AkazaAltar extends Block {

	public AkazaAltar(Properties properties) {
		super(properties);

	}
	
	@Override
	public int getLightValue(BlockState state, IBlockReader world, BlockPos pos) {

		return 15;
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
		
		if(worldIn.getDayTime() >= RequiemKey.requiemConstant)
		{
			if(worldIn.getDifficulty() != Difficulty.PEACEFUL)
			{
				worldIn.setBlockState(pos, Blocks.AIR.getDefaultState());
				worldIn.createExplosion(null, pos.getX(), pos.getY(), pos.getZ(), 4.0F, Explosion.Mode.NONE);
				worldIn.playSound(player, player.getPosition(), SoundInit.AKAZA_BOSS.get(), SoundCategory.RECORDS, 1.0F, 1.0F);
		   
			    AkazaEntity akaza = new AkazaEntity(NightSoulsEntityTypes.AKAZA.get(), worldIn);	
				akaza.setPositionAndUpdate(pos.getX(), pos.getY() + 5, pos.getZ());
				worldIn.addEntity(akaza);
				
				if(worldIn.isRemote)
				{
		    		 player.sendMessage(new TranslationTextComponent("§4You sure look powerful. Fight me !"), null);
		    	}
			}
			else
			{
				if(worldIn.isRemote)
				{
					player.sendMessage(new TranslationTextComponent("§f"+player.getName().getString()+", you can't summon Akaza in peaceful mode."), null);
		    	}
			}
		
		}
		else
		{
			 if(worldIn.isRemote)
	    	 {
				 player.sendMessage(new TranslationTextComponent("§f"+player.getName().getString()+", you can only challenge Akaza in a Requiem World"), null);
	    	 }
		}

		
	   return super.onBlockActivated(state, worldIn, pos, player, handIn, hit);
	}

}
