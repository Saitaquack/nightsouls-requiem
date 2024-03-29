package com.saita.nightsoulsmod.obj.items;

import java.util.List;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;

public class ChlorophyteSword extends SwordItem {

	public ChlorophyteSword(IItemTier tier, int attackDamageIn, float attackSpeedIn, Properties builderIn) {
		super(tier, attackDamageIn, attackSpeedIn, builderIn);

	}
	
	@Override
    public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn)
    {
    
	tooltip.set(0, new StringTextComponent("§2"+tooltip.get(0).getString()+"§r"));
	tooltip.add(new StringTextComponent("§7Automatically repairs itself."));	
	super.addInformation(stack, worldIn, tooltip, flagIn);
	
    }
	
	@Override
	public void inventoryTick(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
		
		if(worldIn.getGameTime() % 300 == 0)
		  {
			stack.damageItem(-1, (PlayerEntity) entityIn, null);
		  }
		
		super.inventoryTick(stack, worldIn, entityIn, itemSlot, isSelected);
	}

}
