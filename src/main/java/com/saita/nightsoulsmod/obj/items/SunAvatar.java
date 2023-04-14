package com.saita.nightsoulsmod.obj.items;

import java.util.List;
import java.util.Random;

import com.saita.nightsoulsmod.entities.entity.projectiles.SunProjEntity;
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

public class SunAvatar extends Item {

	public SunAvatar(Properties properties) {
		super(properties);

	}
	
	@Override
	public boolean hasEffect(ItemStack stack) {
		
		return true;
	}
	
	@Override
	public Rarity getRarity(ItemStack stack) {
		
		return Rarity.EPIC;
	}
	

	@Override
    public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn)
    {
    
	tooltip.set(0, new StringTextComponent("§e"+tooltip.get(0).getString()+"§r"));
	tooltip.add(new StringTextComponent("§7Embrace the sun !"));			
	tooltip.add(new StringTextComponent("§924 Damage"));	
	super.addInformation(stack, worldIn, tooltip, flagIn);
	
    }
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
			
			ItemStack stack = playerIn.getHeldItem(handIn);
		
			if(stack.getMaxDamage() - stack.getDamage() > 0)
			{
			
			Random rand = new Random();
			float pitch = rand.nextFloat() + 0.5F;
				
	    	worldIn.playSound(playerIn, playerIn.getPosition(), SoundInit.SUN.get(), SoundCategory.MASTER, 1.0F, pitch);	
			stack.damageItem(1, playerIn, null);
			playerIn.getCooldownTracker().setCooldown(this, 3);
			
			if(!worldIn.isRemote) {
				
				SunProjEntity proj = new SunProjEntity(playerIn, worldIn);
				SunProjEntity proj2 = new SunProjEntity(playerIn, worldIn);
				SunProjEntity proj3 = new SunProjEntity(playerIn, worldIn);
				SunProjEntity proj4 = new SunProjEntity(playerIn, worldIn);
				SunProjEntity proj5 = new SunProjEntity(playerIn, worldIn);
				
			    proj.setDirectionAndMovement(playerIn, playerIn.rotationPitch, playerIn.rotationYaw, 0.0F, 3.0F, 0.0F);
			    proj2.setDirectionAndMovement(playerIn, playerIn.rotationPitch, playerIn.rotationYaw + 2.5F, 0.0F, 3.0F, 0.0F);
			    proj3.setDirectionAndMovement(playerIn, playerIn.rotationPitch, playerIn.rotationYaw - 2.5F, 0.0F, 3.0F, 0.0F);
			    proj4.setDirectionAndMovement(playerIn, playerIn.rotationPitch, playerIn.rotationYaw + 5.0F, 0.0F, 3.0F, 0.0F);
			    proj5.setDirectionAndMovement(playerIn, playerIn.rotationPitch, playerIn.rotationYaw - 5.0F, 0.0F, 3.0F, 0.0F);
		    
				worldIn.addEntity(proj);
				worldIn.addEntity(proj2);
				worldIn.addEntity(proj3);
				worldIn.addEntity(proj4);
				worldIn.addEntity(proj5);

			}
		
		}
		
		return ActionResult.resultSuccess(stack);
	}

}
