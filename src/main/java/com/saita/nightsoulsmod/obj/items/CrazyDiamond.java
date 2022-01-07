package com.saita.nightsoulsmod.obj.items;

import java.util.List;

import com.saita.nightsoulsmod.init.SoundInit;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Rarity;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;

public class CrazyDiamond extends Item {

	public CrazyDiamond(Properties properties) {
		super(properties);

	}
	
	@Override
    public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn)
    {
    	
    tooltip.add(new StringTextComponent("§7Can be converted to normal diamonds and craft even more stuff. Can also be consumed to instantly heal 20 hearts."));
	super.addInformation(stack, worldIn, tooltip, flagIn);
    }  
	
	@Override
	public Rarity getRarity(ItemStack stack) {

		return Rarity.UNCOMMON;
	}
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
	    	
		 if(playerIn.getHealth() != playerIn.getMaxHealth())			
		 {    	
		      ItemStack itemstack = playerIn.getHeldItem(handIn);
		      playerIn.getCooldownTracker().setCooldown(this, 60);
		      itemstack.shrink(1);
		    	
		      playerIn.heal(40);
		      worldIn.playSound(playerIn, playerIn.getPosition(), SoundInit.LIFE_CRYSTAL.get(), SoundCategory.MASTER, 1.0F, 1.0F);    
		 }
			
		  return super.onItemRightClick(worldIn, playerIn, handIn);
		    
	  }
	
}
