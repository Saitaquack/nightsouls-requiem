package com.saita.nightsoulsmod.obj.items;

import java.util.List;
import java.util.Random;

import com.saita.nightsoulsmod.entities.entity.projectiles.MeteorProjEntity;
import com.saita.nightsoulsmod.init.SoundInit;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Rarity;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;

public class MeteorStaff extends Item {

	public MeteorStaff(Properties properties) {
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
    
	tooltip.set(0, new StringTextComponent("§c"+tooltip.get(0).getString()+"§r"));
	tooltip.add(new StringTextComponent("§7Summons meteorites from the sky !"));			
	super.addInformation(stack, worldIn, tooltip, flagIn);
	
    }
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
			
			ItemStack stack = playerIn.getHeldItem(handIn);
		
			if(stack.getMaxDamage() - stack.getDamage() > 0)
			{
				
		    	worldIn.playSound(playerIn, playerIn.getPosition(), SoundInit.METEOR.get(), SoundCategory.MASTER, 1.0F, 1.0F);	
				stack.damageItem(1, playerIn, null);
				playerIn.getCooldownTracker().setCooldown(this, 10);			
		        
		        int distance = 30;
				int height = 30;
				float playerX = (float) playerIn.getPosX();
			    float playerY = (float) playerIn.getPosY();
			    float playerZ = (float) playerIn.getPosZ();
						
				float f1 = MathHelper.cos(-playerIn.rotationYaw * 0.017453292F - (float)Math.PI);
		        float f2 = MathHelper.sin(-playerIn.rotationYaw * 0.017453292F - (float)Math.PI);
		        float f3 = -MathHelper.cos(-playerIn.rotationPitch * 0.017453292F);
		        		       
		        
		        BlockPos targetPos = new BlockPos(playerX + distance*f2*f3, playerY + height, playerZ + distance*f1*f3);
		        
				
				if(!worldIn.isRemote) {
					
					MeteorProjEntity proj = new MeteorProjEntity(playerIn, worldIn);
					MeteorProjEntity proj2 = new MeteorProjEntity(playerIn, worldIn);	
					MeteorProjEntity proj3 = new MeteorProjEntity(playerIn, worldIn);
					MeteorProjEntity proj4 = new MeteorProjEntity(playerIn, worldIn);
					MeteorProjEntity proj5 = new MeteorProjEntity(playerIn, worldIn);
					
					Random rand = new Random();
					int randomRotation1 = rand.nextInt(25);
					int randomRotation2 = rand.nextInt(25);
					int randomRotation3 = rand.nextInt(25);
					int randomRotation4 = rand.nextInt(25);
					
					boolean isNeg1 = rand.nextBoolean();
					boolean isNeg2 = rand.nextBoolean();
					boolean isNeg3 = rand.nextBoolean();
					boolean isNeg4 = rand.nextBoolean();
					
					if(isNeg1)
					{
						randomRotation1 = -randomRotation1;
					}
					if(isNeg2)
					{
						randomRotation2 = -randomRotation2;
					}
					if(isNeg3)
					{
						randomRotation3 = -randomRotation3;
					}
					if(isNeg4)
					{
						randomRotation4 = -randomRotation4;
					}
					
					proj.setDirectionAndMovement(playerIn, 90.0F + randomRotation1, playerIn.rotationYaw, 0.0F, 3.0F, 0.0F);
				    proj2.setDirectionAndMovement(playerIn, 90.0F + randomRotation2, playerIn.rotationYaw, 0.0F, 3.0F, 0.0F);
				    proj3.setDirectionAndMovement(playerIn, 90.0F + randomRotation3, playerIn.rotationYaw, 0.0F, 2.5F, 0.0F);
				    proj4.setDirectionAndMovement(playerIn, 90.0F + randomRotation4, playerIn.rotationYaw, 0.0F, 2.0F, 0.0F);
				    proj5.setDirectionAndMovement(playerIn, playerIn.rotationPitch, playerIn.rotationYaw, 0.0F, 2.5F, 0.0F);
			    
				    proj.setPositionAndUpdate(targetPos.getX(), targetPos.getY(), targetPos.getZ());
				    proj2.setPositionAndUpdate(targetPos.getX(), targetPos.getY(), targetPos.getZ());
				    proj3.setPositionAndUpdate(targetPos.getX(), targetPos.getY(), targetPos.getZ());
				    proj4.setPositionAndUpdate(targetPos.getX(), targetPos.getY(), targetPos.getZ());

			    
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
