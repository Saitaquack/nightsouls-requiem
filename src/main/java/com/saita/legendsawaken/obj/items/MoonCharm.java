package com.saita.legendsawaken.obj.items;

import java.util.List;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

public class MoonCharm extends Item {

	public MoonCharm(Properties p_41383_) {
		super(p_41383_);
	
	}
	
	@Override
	public Rarity getRarity(ItemStack p_41461_) {
		
		return Rarity.UNCOMMON;
	}
	
	@Override
	public void appendHoverText(ItemStack stack, Level level, List<Component> components, TooltipFlag flag) {
		
		components.add(Component.translatable("moon_charm.tooltip").withStyle(ChatFormatting.GRAY));
		
		super.appendHoverText(stack, level, components, flag);
	}
	
	@Override
	public void inventoryTick(ItemStack stack, Level level, Entity entity, int slot, boolean bool) {
		
		if(entity instanceof LivingEntity && level.isNight() && !level.isClientSide()) {
			
			LivingEntity livingEntity = ((LivingEntity)entity);
			
			livingEntity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 20, 1, false, false));
			livingEntity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 20, 0, false, false));		
			livingEntity.addEffect(new MobEffectInstance(MobEffects.DIG_SPEED, 20, 0, false, false));
		}

		super.inventoryTick(stack, level, entity, slot, bool);
	}

}
