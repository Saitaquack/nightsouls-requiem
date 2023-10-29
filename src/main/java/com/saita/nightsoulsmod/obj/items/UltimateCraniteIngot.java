package com.saita.nightsoulsmod.obj.items;

import java.util.List;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Rarity;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;

public class UltimateCraniteIngot extends Item {

	public UltimateCraniteIngot(Properties properties) {
		super(properties);

	}
	
	@Override
	public Rarity getRarity(ItemStack stack) {
		
		return Rarity.EPIC;
	}
	
	@Override
    public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn)
    {

	tooltip.set(0, new StringTextComponent("§6"+tooltip.get(0).getString()+"§r"));
	tooltip.add(new StringTextComponent("§7It has been blessed with the Hallowed Paladin's might. It is extremely dense and heavy."));	
	super.addInformation(stack, worldIn, tooltip, flagIn);
    }

}
