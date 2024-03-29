package com.saita.nightsoulsmod.obj.items;

import java.util.List;

import com.saita.nightsoulsmod.init.SoundInit;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Rarity;
import net.minecraft.item.SwordItem;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;

public class CrimsonArm extends SwordItem {

	public CrimsonArm(IItemTier tier, int attackDamageIn, float attackSpeedIn, Properties builderIn) {
		super(tier, attackDamageIn, attackSpeedIn, builderIn);

	}
	
	@Override
	public Rarity getRarity(ItemStack stack) {

		return Rarity.UNCOMMON;
	}
	
	@Override
    public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn)
    {

		tooltip.set(0, new StringTextComponent("§4"+tooltip.get(0).getString()+"§r"));	    
		super.addInformation(stack, worldIn, tooltip, flagIn);
    }  
	
	@Override
	public boolean hitEntity(ItemStack stack, LivingEntity target, LivingEntity attacker) {

    	target.playSound(SoundInit.CRISMON_PUNCH.get(), 1.0F, 1.0F);
		return super.hitEntity(stack, target, attacker);
	}

}
