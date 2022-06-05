package com.saita.nightsoulsmod.obj.items;

import java.util.List;
import java.util.Random;

import com.saita.nightsoulsmod.entities.entity.projectiles.LaserProjEntity;
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

public class LaserSprayer extends Item {

	public LaserSprayer(Properties properties) {
		super(properties);

	}
	
	@Override
	public boolean hasEffect(ItemStack stack) {
		
		return true;
	}
	
	@Override
	public Rarity getRarity(ItemStack stack) {
		
		return Rarity.UNCOMMON;
	}
	

	@Override
    public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn)
    {
    
	tooltip.add(new StringTextComponent("§7Shoots lasers ! Can be upgraded to a plasma sprayer."));			
	super.addInformation(stack, worldIn, tooltip, flagIn);
	
    }
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
			
			ItemStack stack = playerIn.getHeldItem(handIn);
		
			if(stack.getMaxDamage() - stack.getDamage() > 0)
			{
			
			Random rand = new Random();
			float pitch = rand.nextFloat() + 0.5F;
				
	    	worldIn.playSound(playerIn, playerIn.getPosition(), SoundInit.LASER.get(), SoundCategory.MASTER, 1.0F, pitch);	
			stack.damageItem(1, playerIn, null);
			playerIn.getCooldownTracker().setCooldown(this, 6);
			
			if(!worldIn.isRemote) {
				
				LaserProjEntity proj = new LaserProjEntity(playerIn, worldIn);
				LaserProjEntity proj2 = new LaserProjEntity(playerIn, worldIn);
				
			    proj.setDirectionAndMovement(playerIn, playerIn.rotationPitch, playerIn.rotationYaw - 2.0F, 0.0F, 2.5F, 0.0F);
			    proj2.setDirectionAndMovement(playerIn, playerIn.rotationPitch, playerIn.rotationYaw + 2.0F, 0.0F, 2.5F, 0.0F);
		    
				worldIn.addEntity(proj);
				worldIn.addEntity(proj2);

			}
		
		}
		
		return ActionResult.resultSuccess(stack);
	}

}
