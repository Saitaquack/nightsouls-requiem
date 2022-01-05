package com.saita.nightsoulsmod.obj.items;

import java.util.List;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Rarity;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;

public class RequiemMedallion extends Item {

	public RequiemMedallion(Properties properties) {
		super(properties);

	}
	
	@Override
	public Rarity getRarity(ItemStack stack) {
		
		return Rarity.EPIC;
	}
	
	@Override
    public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn)
    {
    
	tooltip.set(0, new StringTextComponent("§5"+tooltip.get(0).getString()+"§r"));	
	tooltip.add(new StringTextComponent("§7Having this in your inventory means you are the very first player to enable §5NightSouls Requiem§7 in this world. Congratulations !"));			
	super.addInformation(stack, worldIn, tooltip, flagIn);
	
    }

}
