package com.saita.nightsoulsmod.obj.items;

import java.util.List;
import java.util.Random;

import com.saita.nightsoulsmod.entities.entity.projectiles.EmeraldProjEntity;
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

public class EmeraldSplash extends Item {

	public EmeraldSplash(Properties properties) {
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
    
	tooltip.set(0, new StringTextComponent("§a"+tooltip.get(0).getString()+"§r"));
	tooltip.add(new StringTextComponent("§7Shoots a barage of emeralds at your foes."));	
	tooltip.add(new StringTextComponent("§96 Damage"));	
	super.addInformation(stack, worldIn, tooltip, flagIn);
	
    }
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
			
			ItemStack stack = playerIn.getHeldItem(handIn);
		
			if(stack.getMaxDamage() - stack.getDamage() > 0)
			{
			
			Random rand = new Random();
			float pitch = rand.nextFloat() + 0.5F;
				
	    	worldIn.playSound(playerIn, playerIn.getPosition(), SoundInit.EMERALD_SPLASH.get(), SoundCategory.MASTER, 1.0F, pitch);	
			stack.damageItem(1, playerIn, null);
			playerIn.getCooldownTracker().setCooldown(this, 10);
			
			if(!worldIn.isRemote) {
				
				EmeraldProjEntity proj = new EmeraldProjEntity(playerIn, worldIn);
				EmeraldProjEntity proj2 = new EmeraldProjEntity(playerIn, worldIn);
				EmeraldProjEntity proj3= new EmeraldProjEntity(playerIn, worldIn);
				EmeraldProjEntity proj4 = new EmeraldProjEntity(playerIn, worldIn);
				EmeraldProjEntity proj5 = new EmeraldProjEntity(playerIn, worldIn);
				EmeraldProjEntity proj6 = new EmeraldProjEntity(playerIn, worldIn);
				EmeraldProjEntity proj7 = new EmeraldProjEntity(playerIn, worldIn);
				EmeraldProjEntity proj8 = new EmeraldProjEntity(playerIn, worldIn);
				EmeraldProjEntity proj9 = new EmeraldProjEntity(playerIn, worldIn);
				EmeraldProjEntity proj10 = new EmeraldProjEntity(playerIn, worldIn);
				EmeraldProjEntity proj11 = new EmeraldProjEntity(playerIn, worldIn);
				
			    proj.setDirectionAndMovement(playerIn, playerIn.rotationPitch, playerIn.rotationYaw, 0.0F, 2.0F, 0.0F);
			    proj2.setDirectionAndMovement(playerIn, playerIn.rotationPitch, playerIn.rotationYaw + 7.5F, 0.0F, 2.0F, 0.0F);
			    proj3.setDirectionAndMovement(playerIn, playerIn.rotationPitch, playerIn.rotationYaw - 7.5F, 0.0F, 2.0F, 0.0F);
			    proj4.setDirectionAndMovement(playerIn, playerIn.rotationPitch + 7.5F, playerIn.rotationYaw + 7.5F, 0.0F, 2.0F, 0.0F);
			    proj5.setDirectionAndMovement(playerIn, playerIn.rotationPitch + 7.5F, playerIn.rotationYaw - 7.5F, 0.0F, 2.0F, 0.0F);
			    proj6.setDirectionAndMovement(playerIn, playerIn.rotationPitch + 7.5F, playerIn.rotationYaw, 0.0F, 2.0F, 0.0F);
			    proj7.setDirectionAndMovement(playerIn, playerIn.rotationPitch - 7.5F, playerIn.rotationYaw, 0.0F, 2.0F, 0.0F);
			    proj8.setDirectionAndMovement(playerIn, playerIn.rotationPitch - 7.5F, playerIn.rotationYaw - 7.5F, 0.0F, 2.0F, 0.0F);
			    proj9.setDirectionAndMovement(playerIn, playerIn.rotationPitch - 7.5F, playerIn.rotationYaw + 7.5F, 0.0F, 2.0F, 0.0F);
			    proj10.setDirectionAndMovement(playerIn, playerIn.rotationPitch, playerIn.rotationYaw + 17.5F, 0.0F, 2.0F, 0.0F);
			    proj11.setDirectionAndMovement(playerIn, playerIn.rotationPitch, playerIn.rotationYaw - 17.5F, 0.0F, 2.0F, 0.0F);
			    
				worldIn.addEntity(proj);
				worldIn.addEntity(proj2);
				worldIn.addEntity(proj3);
				worldIn.addEntity(proj4);
				worldIn.addEntity(proj5);
				worldIn.addEntity(proj6);
				worldIn.addEntity(proj7);
				worldIn.addEntity(proj8);
				worldIn.addEntity(proj9);
				worldIn.addEntity(proj10);
				worldIn.addEntity(proj11);
			}
		
		}
		
		return ActionResult.resultSuccess(stack);
	}

}
