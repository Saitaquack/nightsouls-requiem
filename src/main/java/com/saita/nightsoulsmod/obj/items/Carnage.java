package com.saita.nightsoulsmod.obj.items;

import java.util.List;

import com.saita.nightsoulsmod.init.SoundInit;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.AxeItem;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Rarity;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;

public class Carnage extends AxeItem {

	public Carnage(IItemTier tier, float attackDamageIn, float attackSpeedIn, Properties builder) {
		super(tier, attackDamageIn, attackSpeedIn, builder);

	}
	
	@Override
	public Rarity getRarity(ItemStack stack) {

		return Rarity.RARE;
	}
	
	@Override
    public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn)
    {

	tooltip.add(new StringTextComponent("§7Brings your enemies closer to you and has a chance to grant you regeneration."));
	tooltip.set(0, new StringTextComponent("§4"+tooltip.get(0).getString()+"§r"));
	super.addInformation(stack, worldIn, tooltip, flagIn);
    }  
	
	@Override
	public boolean hitEntity(ItemStack stack, LivingEntity target, LivingEntity attacker) {
		
		int randomRegen = random.nextInt(2);
		if(randomRegen == 0)
		{
			attacker.addPotionEffect(new EffectInstance(Effects.REGENERATION, 120, 0));
		}	
		
		Vector3d look = attacker.getLookVec().normalize();  
		double knockback = -1;
		target.addVelocity(look.x*knockback, look.y*knockback, look.z*knockback);
		
		target.playSound(SoundInit.WARAXE.get(), 1.0F, 1.0F);
		
		return super.hitEntity(stack, target, attacker);
	}

}
