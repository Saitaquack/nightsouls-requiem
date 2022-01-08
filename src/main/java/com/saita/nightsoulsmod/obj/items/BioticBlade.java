package com.saita.nightsoulsmod.obj.items;

import java.util.List;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;

public class BioticBlade extends SwordItem {

	public BioticBlade(IItemTier tier, int attackDamageIn, float attackSpeedIn, Properties builder) {
		super(tier, attackDamageIn, attackSpeedIn, builder);

	}
	
	@Override
    public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn)
    {

	tooltip.set(0, new StringTextComponent("§2"+tooltip.get(0).getString()+"§r"));	
    tooltip.add(new StringTextComponent("§7Heals your target and gives them random buffs."));
	super.addInformation(stack, worldIn, tooltip, flagIn);
    }  
	
	@Override
	public boolean hitEntity(ItemStack stack, LivingEntity target, LivingEntity attacker) {
		
		int randomHeal = random.nextInt(3);
		boolean givesEffect = random.nextBoolean();

		target.heal(randomHeal + 1);

		if(givesEffect)
		{
			int randomBuff = random.nextInt(6);
			
			switch(randomBuff)
			{
			case 0:
				target.addPotionEffect(new EffectInstance(Effects.SPEED, 100, 0));
			break;
			case 1:
				target.addPotionEffect(new EffectInstance(Effects.HASTE, 100, 0));
			break;
			case 2:
				target.addPotionEffect(new EffectInstance(Effects.STRENGTH, 100, 0));
			break;
			case 3:
				target.addPotionEffect(new EffectInstance(Effects.JUMP_BOOST, 100, 0));
			break;
			case 4:
				target.addPotionEffect(new EffectInstance(Effects.RESISTANCE, 100, 0));
			break;
			case 5:
				target.addPotionEffect(new EffectInstance(Effects.FIRE_RESISTANCE, 100, 0));
			break;
			}
		}
    	
		return super.hitEntity(stack, target, attacker);
	}

}
