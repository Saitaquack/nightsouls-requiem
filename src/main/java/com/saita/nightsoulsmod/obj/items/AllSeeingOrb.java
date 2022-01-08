package com.saita.nightsoulsmod.obj.items;

import java.util.List;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Rarity;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;

public class AllSeeingOrb extends Item {

	public AllSeeingOrb(Properties properties) {
		super(properties);

	}
	
	@Override
	public boolean hasEffect(ItemStack stack) {
		
		return true;
	}
	
	@Override
	public Rarity getRarity(ItemStack stack) {
		
		return Rarity.RARE;
	}
	
	@Override
    public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn)
    {
    	
    tooltip.add(new StringTextComponent("§7Grants you invisibility when in your inventory with no debuffs. Right-Click to also get a temporary night vision effect."));
	super.addInformation(stack, worldIn, tooltip, flagIn);
    }  
	

	@Override
	public void inventoryTick(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
		
		 if(entityIn instanceof PlayerEntity)
	    	{
			 	PlayerEntity playerIn = (PlayerEntity)entityIn;	
	    		 	    		 			
	    		playerIn.addPotionEffect(new EffectInstance(Effects.INVISIBILITY, 5, 0, false, false));	    		   	
	         }
		 
	    super.inventoryTick(stack, worldIn, entityIn, itemSlot, isSelected);
	}
	
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
		
		playerIn.addPotionEffect(new EffectInstance(Effects.NIGHT_VISION, 300, 0, false, false));	 
		
		return super.onItemRightClick(worldIn, playerIn, handIn);
	}

}
