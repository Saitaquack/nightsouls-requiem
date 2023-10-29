package com.saita.nightsoulsmod.obj.items;

import java.util.List;

import com.saita.nightsoulsmod.entities.entity.projectiles.CrystalProjEntity;
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

public class CrystalStorm extends Item {

	public CrystalStorm(Properties properties) {
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
    
	tooltip.add(new StringTextComponent("§7Rapidly shoots a lot of crystals."));	
	tooltip.add(new StringTextComponent("§97 Damage"));	
	super.addInformation(stack, worldIn, tooltip, flagIn);
	
    }
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
		
		ItemStack stack = playerIn.getHeldItem(handIn);
		
		if(stack.getMaxDamage() - stack.getDamage() > 0)
		{			
	    	worldIn.playSound(playerIn, playerIn.getPosition(), SoundInit.MAGIC.get(), SoundCategory.MASTER, 1.0F, 1.0F);	
	    	stack.damageItem(1, playerIn, null);
			
			if(!worldIn.isRemote)
			{
				
				CrystalProjEntity proj = new CrystalProjEntity(playerIn, worldIn);
				CrystalProjEntity proj2 = new CrystalProjEntity(playerIn, worldIn);
				
			    proj.setDirectionAndMovement(playerIn, playerIn.rotationPitch, playerIn.rotationYaw - 1.0F, 0.0F, 3.0F, 0.0F);
			    proj2.setDirectionAndMovement(playerIn, playerIn.rotationPitch, playerIn.rotationYaw + 1.0F, 0.0F, 3.0F, 0.0F);
		    
				worldIn.addEntity(proj);
				worldIn.addEntity(proj2);
			}

		}
				
		
		return ActionResult.resultSuccess(stack);
	}

}
