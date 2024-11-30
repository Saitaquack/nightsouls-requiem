package com.saita.legendsawaken.obj.items;

import com.saita.legendsawaken.init.SoundInit;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class InstantAbsorptionPotion extends Item {

	public InstantAbsorptionPotion(Properties p_41383_) {
		super(p_41383_);
	
	}
	
	@Override
	public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
		
		ItemStack itemstack = player.getItemInHand(hand);
			
		itemstack.shrink(1);
		player.getCooldowns().addCooldown(this, 260);
		player.playSound(SoundInit.INSTANT_POTION.get(), 1.0F, 1.0F);
		
		if(!level.isClientSide()) {	
			player.addEffect(new MobEffectInstance(MobEffects.ABSORPTION, 200, 1));
		}
		

		return super.use(level, player, hand);
	}

}
