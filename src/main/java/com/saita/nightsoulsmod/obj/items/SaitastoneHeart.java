package com.saita.nightsoulsmod.obj.items;

import java.util.List;

import com.saita.nightsoulsmod.init.SoundInit;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Rarity;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;

public class SaitastoneHeart extends Item {

	public SaitastoneHeart(Properties properties) {
		super(properties);

	}
	
	@Override
	public boolean hasEffect(ItemStack stack)
	{
		return true;
	}
	
    @Override
    public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn)
    {
    	
    tooltip.add(new StringTextComponent("§7Grants you Health Boost II and Absorption II for 12 minutes."));
	super.addInformation(stack, worldIn, tooltip, flagIn);
    }  
    
    @Override
    public Rarity getRarity(ItemStack stack) {
    	
    	return Rarity.UNCOMMON;
    }
    
    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
    	
    	ItemStack itemstack = playerIn.getHeldItem(handIn);
        itemstack.shrink(1);
        playerIn.getCooldownTracker().setCooldown(this, 20);
  	 
        if(!worldIn.isRemote)
        {
	    	playerIn.addPotionEffect(new EffectInstance(Effects.HEALTH_BOOST, 14400, 1));
	    	playerIn.addPotionEffect(new EffectInstance(Effects.ABSORPTION, 14400, 1));
        }

    	worldIn.playSound(playerIn, playerIn.getPosition(), SoundInit.LIFE_CRYSTAL.get(), SoundCategory.MASTER, 1.0F, 1.0F);
    	
    	return super.onItemRightClick(worldIn, playerIn, handIn);
    }

}
