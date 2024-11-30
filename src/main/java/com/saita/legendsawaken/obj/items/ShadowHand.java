package com.saita.legendsawaken.obj.items;

import java.util.List;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

public class ShadowHand extends Item {

	public ShadowHand(Properties p_41383_) {
		super(p_41383_);
		
	}
	
	@Override
	public Rarity getRarity(ItemStack p_41461_) {
		
		return Rarity.UNCOMMON;
	}
	
	@Override
	public void appendHoverText(ItemStack stack, Level level, List<Component> components, TooltipFlag flag) {
		
		components.add(Component.translatable("shadow_hand.tooltip").withStyle(ChatFormatting.GRAY));
		
		super.appendHoverText(stack, level, components, flag);
	}
	
	@Override
	public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
		
		ItemStack itemstack = player.getItemInHand(hand);
		
		itemstack.shrink(1);
		player.getCooldowns().addCooldown(this, 10);
		player.playSound(SoundEvents.ENDERMAN_TELEPORT, 1.0F, 0.2F);
		
		if(!level.isClientSide()) {				
			player.addEffect(new MobEffectInstance(MobEffects.DIG_SPEED, 14400, 3));
		}
				
		return super.use(level, player, hand);
	}

}
