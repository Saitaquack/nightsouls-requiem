package com.saita.nightsoulsmod.obj.blockitems;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Rarity;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;

public class CrazyDiamondBlock extends BlockItem {

	public CrazyDiamondBlock(Block blockIn, Properties builder) {
		super(blockIn, builder);

	}
	
	@Override
	public Rarity getRarity(ItemStack stack) {

		return Rarity.RARE;
	}
	
	@Override
	public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn)
	{
	    	
	   tooltip.add(new StringTextComponent("§7Rapidly heals you and grants you speed if you step on it."));
	   super.addInformation(stack, worldIn, tooltip, flagIn);
	}
	

}
