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

public class SoulStealer extends SwordItem {

	public SoulStealer(IItemTier tier, int attackDamageIn, float attackSpeedIn, Properties builder) {
		super(tier, attackDamageIn, attackSpeedIn, builder);
	
	}
	
	@Override
	public boolean hasEffect(ItemStack stack) {
	
		return true;
	}
	
	@Override
    public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn)
    {

	tooltip.set(0, new StringTextComponent("§5"+tooltip.get(0).getString()+"§r"));
    tooltip.add(new StringTextComponent("§7Restore your health by reaping the souls of living beings."));
	super.addInformation(stack, worldIn, tooltip, flagIn);
    }  
	
	@Override
	public Rarity getRarity(ItemStack stack) {
		
		return Rarity.EPIC;
	}
	
	@Override
	public boolean hitEntity(ItemStack stack, LivingEntity target, LivingEntity attacker) {
		
		target.playSound(SoundInit.SOUL_STEALER.get(), 1.0F, 1.0F);
		
		int healAmmount = random.nextInt(2);
		int rareHealing = random.nextInt(9);
		
		if(rareHealing == 0)
		{
			attacker.heal(6);
		}
		else
		{
			attacker.heal(1 + healAmmount);	
		}
		return super.hitEntity(stack, target, attacker);
	}

}
