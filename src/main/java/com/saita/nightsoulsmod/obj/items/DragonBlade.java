package com.saita.nightsoulsmod.obj.items;

import java.util.List;

import com.saita.nightsoulsmod.init.SoundInit;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Rarity;
import net.minecraft.item.SwordItem;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;

public class DragonBlade extends SwordItem {

	public DragonBlade(IItemTier tier, int attackDamageIn, float attackSpeedIn, Properties builderIn) {
		super(tier, attackDamageIn, attackSpeedIn, builderIn);
		
	}
	
	@Override
	public Rarity getRarity(ItemStack stack) {

		return Rarity.RARE;
	}
	
	@Override
    public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn)
    {

    tooltip.add(new StringTextComponent("§aThe Dragon becomes you! §7Not to be confused with §5Dragon Sword§7. Right Click to gain a short burst of speed !"));
	super.addInformation(stack, worldIn, tooltip, flagIn);
    }  
	
	@Override
	public boolean hitEntity(ItemStack stack, LivingEntity target, LivingEntity attacker) {	
    	target.playSound(SoundInit.DRAGONBLADE_SLASH.get(), 1.0F, 1.0F);
		return super.hitEntity(stack, target, attacker);
	}
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
		
		ItemStack itemstack = playerIn.getHeldItem(handIn);
	    itemstack.setDamage(1);
    	worldIn.playSound(playerIn, playerIn.getPosition(), SoundInit.DRAGONBLADE_DASH.get(), SoundCategory.MASTER, 1.0F, 1.0F);
	    
    	if(!worldIn.isRemote)
    	{
    		playerIn.addPotionEffect(new EffectInstance(Effects.SPEED, 20, 7));
    	}
	    
		return super.onItemRightClick(worldIn, playerIn, handIn);
	}

}
