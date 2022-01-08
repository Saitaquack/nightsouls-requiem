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
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;

public class HellFireEmperorTrident extends SwordItem {

	public HellFireEmperorTrident(IItemTier tier, int attackDamageIn, float attackSpeedIn, Properties builder) {
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

	tooltip.set(0, new StringTextComponent("§4"+tooltip.get(0).getString()+"§r"));
    tooltip.add(new StringTextComponent("§7Feel the wrath of the Hellfire Emperor ! Sometimes grants you a very powerful strength effect"));
	super.addInformation(stack, worldIn, tooltip, flagIn);
    }  
	
	@Override
	public boolean hitEntity(ItemStack stack, LivingEntity target, LivingEntity attacker) {
		
		int randomStrength = random.nextInt(7);
		if(randomStrength == 0)
		{
	    	attacker.addPotionEffect(new EffectInstance(Effects.STRENGTH, 40, 5));
		}
		
		target.setFire(14);
		target.playSound(SoundInit.HELLFIRE_EMPEROR_TRIDENT.get(), 1.0F, 1.0F);
		return super.hitEntity(stack, target, attacker);
	}
}
