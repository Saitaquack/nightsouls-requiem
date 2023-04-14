package com.saita.nightsoulsmod.obj.items;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

public class MandelaCatalogue extends Item {

	public MandelaCatalogue(Properties properties) {
		super(properties);

	}
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
		
		 if(worldIn.isRemote)
    	 {
			 playerIn.sendMessage(new TranslationTextComponent("§0https://www.youtube.com/watch?v=C8d12w6pMos"), null);
    	 }
		
		return super.onItemRightClick(worldIn, playerIn, handIn);
	}

}
