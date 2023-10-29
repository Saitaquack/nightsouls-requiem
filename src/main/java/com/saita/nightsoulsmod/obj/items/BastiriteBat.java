package com.saita.nightsoulsmod.obj.items;

import java.util.List;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;

public class BastiriteBat extends SwordItem {

	public BastiriteBat(IItemTier tier, int attackDamageIn, float attackSpeedIn, Properties builder) {
		super(tier, attackDamageIn, attackSpeedIn, builder);

	}
	
	@Override
    public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn)
    {

    tooltip.add(new StringTextComponent("§9+0.75 Knockback"));
	super.addInformation(stack, worldIn, tooltip, flagIn);
    }
	
	@Override
	public boolean hitEntity(ItemStack stack, LivingEntity target, LivingEntity attacker) {
		
		 Vector3d look = attacker.getLookVec().normalize();  
		 double knockback = 0.75;
		 target.addVelocity(look.x*knockback, look.y*knockback, look.z*knockback);

		
		return super.hitEntity(stack, target, attacker);
	}

}