package com.saita.legendsawaken.obj.items;

import java.util.List;

import com.saita.legendsawaken.init.ItemInit;
import com.saita.legendsawaken.util.HardmodeRequiemFunctions;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

public class DemonCore extends Item {

	public DemonCore(Properties p_41383_) {
		super(p_41383_);

	}
	
	@Override
	public boolean isFoil(ItemStack p_41453_) {
		
		return true;
	}
	
	@Override
	public void appendHoverText(ItemStack stack, Level level, List<Component> components, TooltipFlag flag) {
		
		components.add(Component.translatable("demon_core.tooltip").withStyle(ChatFormatting.GRAY));
		
		super.appendHoverText(stack, level, components, flag);
	}
	
	@Override
	public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
		
		ItemStack item = player.getItemInHand(hand);
		item.shrink(1);
		player.getCooldowns().addCooldown(this, 200);
		player.drop(new ItemStack(ItemInit.SHADOW_ESSENCE.get(), 8), false).setNoPickUpDelay();
			
		if(!level.isClientSide()) {
			
			if(HardmodeRequiemFunctions.isNotHardmode((ServerLevel)level)) {
			
				HardmodeRequiemFunctions.setHardmode((ServerLevel)level);
				player.displayClientMessage(Component.translatable("demon_core.hardmode_on").withStyle(ChatFormatting.DARK_PURPLE), true);
				
				player.playSound(SoundEvents.WITHER_DEATH, 1.0F, 0.1F);
				player.playSound(SoundEvents.WARDEN_ROAR, 1.0F, 0.5F);
				
				player.playNotifySound(SoundEvents.WITHER_DEATH, SoundSource.MASTER, 1.0F, 0.1F);
				player.playNotifySound(SoundEvents.WARDEN_ROAR, SoundSource.MASTER, 1.0F, 0.5F);
								
				
			} else {	
				player.displayClientMessage(Component.translatable("demon_core.already_hardmode").withStyle(ChatFormatting.WHITE), true);
			}		
		}		
			
		return super.use(level, player, hand);
	}

}
