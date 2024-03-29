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

public class DivineSanction extends SwordItem {

	public DivineSanction(IItemTier tier, int attackDamageIn, float attackSpeedIn, Properties builder) {
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
    	
	tooltip.set(0, new StringTextComponent("§e"+tooltip.get(0).getString()+"§r"));	
    tooltip.add(new StringTextComponent("§7Shall purge the unholy and the unworthy. Sometimes grants you regeneration and strength."));
    tooltip.add(new StringTextComponent("§9+0.5 Knockback"));
	super.addInformation(stack, worldIn, tooltip, flagIn);
    }
	
	 @Override
	 public boolean hitEntity(ItemStack stack, LivingEntity target, LivingEntity attacker) {
		 
	    Vector3d look = attacker.getLookVec().normalize();  
	    double knockback = 0.5;
	    target.addVelocity(look.x*knockback, look.y*knockback, look.z*knockback);
		 
		target.playSound(SoundInit.DIVINE_SANCTION.get(), 1.0F, 1.0F);

		int special = random.nextInt(7);
		if(special == 0)
		{
	    	attacker.addPotionEffect(new EffectInstance(Effects.REGENERATION, 160, 1));
	    	attacker.addPotionEffect(new EffectInstance(Effects.STRENGTH, 160, 2));
		}
		 
	    return super.hitEntity(stack, target, attacker);
	 }

}
