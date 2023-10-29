package com.saita.nightsoulsmod.obj.items;

import java.util.List;

import com.saita.nightsoulsmod.init.SoundInit;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Rarity;
import net.minecraft.item.SwordItem;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;

public class Hexadecimator extends SwordItem {

	public Hexadecimator(IItemTier tier, int attackDamageIn, float attackSpeedIn, Properties builder) {
		super(tier, attackDamageIn, attackSpeedIn, builder);

	}
	
	@Override
	public boolean hasEffect(ItemStack stack) {
	
		return true;
	}
	

	@Override
	public Rarity getRarity(ItemStack stack) {
		
		return Rarity.EPIC;
	}
	
	@Override
    public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn)
    {

	tooltip.set(0, new StringTextComponent("§2"+tooltip.get(0).getString()+"§r"));
    tooltip.add(new StringTextComponent("§7The deadliest weapon of the Reality Warper. Gives your enemies random debuffs."));
    tooltip.add(new StringTextComponent("§9+0.5 Knockback"));
	super.addInformation(stack, worldIn, tooltip, flagIn);
    }  
	
	@Override
	public boolean hitEntity(ItemStack stack, LivingEntity target, LivingEntity attacker) {
		
		Vector3d look = attacker.getLookVec().normalize();  
		double knockback = 0.5;
		target.addVelocity(look.x*knockback, look.y*knockback, look.z*knockback);
		
		int randomAttack = random.nextInt(7);
		int amplifier = random.nextInt(2);
		
		switch(randomAttack)
		{
		case 0:
			target.addPotionEffect(new EffectInstance(Effects.SLOWNESS, 160, amplifier));
		break;
		case 1:
			target.addPotionEffect(new EffectInstance(Effects.MINING_FATIGUE, 160, amplifier));
		break;
		case 2:
			target.addPotionEffect(new EffectInstance(Effects.WEAKNESS, 160, amplifier));
		break;
		case 3:
			target.addPotionEffect(new EffectInstance(Effects.BLINDNESS, 160, 0));
		break;
		case 4:
			target.addPotionEffect(new EffectInstance(Effects.HUNGER, 160, amplifier));
		break;
		case 5:
			target.addPotionEffect(new EffectInstance(Effects.POISON, 160, amplifier));
		break;
		case 6:
			target.addPotionEffect(new EffectInstance(Effects.WITHER, 160, amplifier));
		break;
		}
		
		target.playSound(SoundInit.HEXADECIMATOR.get(), 1.0F, 1.0F);
		
		return super.hitEntity(stack, target, attacker);
	}

}
