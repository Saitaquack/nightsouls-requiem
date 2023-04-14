package com.saita.nightsoulsmod.obj.items;

import java.util.List;

import com.saita.nightsoulsmod.entities.entity.projectiles.CyberShurikenProjEntity;
import com.saita.nightsoulsmod.init.SoundInit;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;

public class CyberShuriken extends Item {

	public CyberShuriken(Properties properties) {
		super(properties);

	}

	@Override
    public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn)
    {
    
	tooltip.add(new StringTextComponent("§7Throws 3 high damage shurikens."));
	tooltip.add(new StringTextComponent("§912 Damage"));	
	super.addInformation(stack, worldIn, tooltip, flagIn);
	
    }
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
		
		ItemStack stack = playerIn.getHeldItem(handIn);

    	worldIn.playSound(playerIn, playerIn.getPosition(), SoundInit.SHURIKEN.get(), SoundCategory.MASTER, 1.0F, 1.0F);	
		playerIn.getCooldownTracker().setCooldown(this, 10);
		stack.shrink(1);
		
		if(!worldIn.isRemote) {
			
			CyberShurikenProjEntity proj = new CyberShurikenProjEntity(playerIn, worldIn);
			CyberShurikenProjEntity proj2 = new CyberShurikenProjEntity(playerIn, worldIn);
			CyberShurikenProjEntity proj3= new CyberShurikenProjEntity(playerIn, worldIn);
			
		    proj.setDirectionAndMovement(playerIn, playerIn.rotationPitch, playerIn.rotationYaw, 0.0F, 4.5F, 0.0F);
		    proj2.setDirectionAndMovement(playerIn, playerIn.rotationPitch, playerIn.rotationYaw, 0.0F, 3.5F, 0.0F);
		    proj3.setDirectionAndMovement(playerIn, playerIn.rotationPitch, playerIn.rotationYaw, 0.0F, 2.5F, 0.0F);
		    
			worldIn.addEntity(proj);
			worldIn.addEntity(proj2);
			worldIn.addEntity(proj3);
			
		}
			
		return ActionResult.resultSuccess(stack);
	}
	
	

}
