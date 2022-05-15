package com.saita.nightsoulsmod.obj.items;

import java.util.List;

import com.saita.nightsoulsmod.entities.entity.projectiles.TechnoProjEntity;
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

public class TechnoGun extends Item {

	public TechnoGun(Properties properties) {
		super(properties);

	}
	
	@Override
	public Rarity getRarity(ItemStack stack) {
		
		return Rarity.RARE;
	}
	

	@Override
    public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn)
    {
    
	tooltip.add(new StringTextComponent("§7Shoots techno projectiles at your foes."));			
	super.addInformation(stack, worldIn, tooltip, flagIn);
	
    }
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
		
		ItemStack stack = playerIn.getHeldItem(handIn);
		stack.damageItem(1, playerIn, null);
    	worldIn.playSound(playerIn, playerIn.getPosition(), SoundInit.TECHNO_GUN.get(), SoundCategory.MASTER, 1.0F, 1.0F);	
		playerIn.getCooldownTracker().setCooldown(this, 15);
		
		if(!worldIn.isRemote) {
			
			TechnoProjEntity proj = new TechnoProjEntity(playerIn, worldIn);
			TechnoProjEntity proj2 = new TechnoProjEntity(playerIn, worldIn);
			TechnoProjEntity proj3= new TechnoProjEntity(playerIn, worldIn);
			TechnoProjEntity proj4 = new TechnoProjEntity(playerIn, worldIn);
			
		    proj.setDirectionAndMovement(playerIn, playerIn.rotationPitch, playerIn.rotationYaw, 0.0F, 4.0F, 0.0F);
		    proj2.setDirectionAndMovement(playerIn, playerIn.rotationPitch, playerIn.rotationYaw, 0.0F, 3.0F, 0.0F);
		    proj3.setDirectionAndMovement(playerIn, playerIn.rotationPitch, playerIn.rotationYaw, 0.0F, 2.0F, 0.0F);
		    proj4.setDirectionAndMovement(playerIn, playerIn.rotationPitch, playerIn.rotationYaw, 0.0F, 1.5F, 0.0F);
		    
			worldIn.addEntity(proj);
			worldIn.addEntity(proj2);
			worldIn.addEntity(proj3);
			worldIn.addEntity(proj4);
		}
		
		return ActionResult.resultSuccess(stack);
	}

}
