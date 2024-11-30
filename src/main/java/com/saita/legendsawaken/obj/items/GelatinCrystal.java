package com.saita.legendsawaken.obj.items;

import java.util.List;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

public class GelatinCrystal extends Item {

	public GelatinCrystal(Properties p_41383_) {
		super(p_41383_);

	}
	
	@Override
	public void appendHoverText(ItemStack stack, Level level, List<Component> components, TooltipFlag flag) {
		
		components.add(Component.translatable("gelatin_crystal.tooltip").withStyle(ChatFormatting.GRAY));
		
		super.appendHoverText(stack, level, components, flag);
	}
	
	@Override
	public ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity entity) {
		
		entity.removeEffect(MobEffects.POISON);
		entity.removeEffect(MobEffects.WITHER);
		entity.removeEffect(MobEffects.HUNGER);
		entity.removeEffect(MobEffects.CONFUSION);
		entity.removeEffect(MobEffects.WEAKNESS);
		entity.removeEffect(MobEffects.MOVEMENT_SLOWDOWN);
		entity.removeEffect(MobEffects.DARKNESS);
		entity.removeEffect(MobEffects.UNLUCK);
		
	
		return super.finishUsingItem(stack, level, entity);
	}

}
