package com.saita.legendsawaken.obj.items;

import java.util.List;
import java.util.Random;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

public class DeathScythe extends SwordItem {

	public DeathScythe(Tier p_43269_, int p_43270_, float p_43271_, Properties p_43272_) {
		super(p_43269_, p_43270_, p_43271_, p_43272_);

	}
	
	Random rand = new Random();
	
	@Override
	public Rarity getRarity(ItemStack p_41461_) {
		
		return Rarity.UNCOMMON;
	}
	
	@Override
	public void appendHoverText(ItemStack stack, Level level, List<Component> components, TooltipFlag flag) {
		
		components.add(Component.translatable("death_scythe.tooltip").withStyle(ChatFormatting.GRAY));
		
		super.appendHoverText(stack, level, components, flag);
	}
	
	@Override
	public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {

	int randomHeal = rand.nextInt(2);
		
		if(randomHeal == 0) {
			attacker.heal(1.0F);				
		}
		
		return super.hurtEnemy(stack, target, attacker);
	}

}
