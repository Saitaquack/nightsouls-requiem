package com.saita.nightsoulsmod.obj.items;

import java.util.List;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Rarity;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;

public class RedPowerMoon extends Item {

	public RedPowerMoon(Properties properties) {
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

	tooltip.set(0, new StringTextComponent("§c"+tooltip.get(0).getString()+"§r"));
	super.addInformation(stack, worldIn, tooltip, flagIn);
    }

}
