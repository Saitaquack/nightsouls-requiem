package com.saita.nightsoulsmod.obj.items;

import java.util.List;

import com.saita.nightsoulsmod.entities.entity.projectiles.BioticProjEntity;
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

public class BioticRifle extends Item {

	public BioticRifle(Properties properties) {
		super(properties);

	}
	
	@Override
	public Rarity getRarity(ItemStack stack) {
		
		return Rarity.RARE;
	}
	

	@Override
    public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn)
    {
    
	tooltip.add(new StringTextComponent("§7Heals players or villagers, and damages other entities."));
    tooltip.add(new StringTextComponent("§924 Damage"));	
	super.addInformation(stack, worldIn, tooltip, flagIn);
	
    }
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
		
		ItemStack stack = playerIn.getHeldItem(handIn);
		
		if(stack.getMaxDamage() - stack.getDamage() > 0)
		{
			stack.damageItem(1, playerIn, null);
	    	worldIn.playSound(playerIn, playerIn.getPosition(), SoundInit.BIOTIC_RIFLE_SHOT.get(), SoundCategory.MASTER, 1.0F, 1.0F);	
			playerIn.getCooldownTracker().setCooldown(this, 15);
			
			if(!worldIn.isRemote) {
				
				BioticProjEntity proj = new BioticProjEntity(playerIn, worldIn);			
			    proj.setDirectionAndMovement(playerIn, playerIn.rotationPitch, playerIn.rotationYaw, 0.0F, 4.0F, 0.0F);		    
				worldIn.addEntity(proj);

			}
		}
		
		
		return ActionResult.resultSuccess(stack);
	}

}
