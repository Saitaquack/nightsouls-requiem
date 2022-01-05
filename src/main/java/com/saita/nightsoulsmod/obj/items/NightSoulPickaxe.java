package com.saita.nightsoulsmod.obj.items;

import java.util.List;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.item.PickaxeItem;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;

public class NightSoulPickaxe extends PickaxeItem{

	public NightSoulPickaxe(IItemTier tier, int attackDamageIn, float attackSpeedIn, Properties builder) {
		super(tier, attackDamageIn, attackSpeedIn, builder);

	}
	
	@Override
    public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn)
    {
    
	tooltip.set(0, new StringTextComponent("§5"+tooltip.get(0).getString()+"§r"));		
    tooltip.add(new StringTextComponent("§7Able to mine §cSaitastone§7, §5Miizealite§7, §fCranite§7, §9Bastirite§7, §aPrimium§7, §6Rowequite§7, §bTherenite§7 and §4Heart Crystals§7."));
	super.addInformation(stack, worldIn, tooltip, flagIn);
    }  

}
