package com.saita.nightsoulsmod.obj.items;

import java.util.List;

import com.saita.nightsoulsmod.entities.entity.projectiles.GiantFrozenPeaProjEntity;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;

public class GiantFrozenPea extends Item {

	public GiantFrozenPea(Properties properties) {
		super(properties);

	}
	
	@Override
    public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn)
    {
    
	tooltip.add(new StringTextComponent("§96 Damage"));	
	super.addInformation(stack, worldIn, tooltip, flagIn);
	
    }
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
		
		ItemStack stack = playerIn.getHeldItem(handIn);

    	worldIn.playSound(playerIn, playerIn.getPosition(), SoundEvents.ENTITY_SNOWBALL_THROW, SoundCategory.MASTER, 1.0F, 1.0F);	
		stack.shrink(1);
		
		if(!worldIn.isRemote) {
			
			GiantFrozenPeaProjEntity proj = new GiantFrozenPeaProjEntity(playerIn, worldIn);		
		    proj.setDirectionAndMovement(playerIn, playerIn.rotationPitch, playerIn.rotationYaw, 0.0F, 2.0F, 0.0F);
		    worldIn.addEntity(proj);
			
		}
			
		return ActionResult.resultSuccess(stack);
	}
	
	

}
