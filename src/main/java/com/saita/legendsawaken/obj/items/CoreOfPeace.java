package com.saita.legendsawaken.obj.items;

import java.util.List;

import com.saita.legendsawaken.util.HardmodeRequiemFunctions;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

public class CoreOfPeace extends Item {

	public CoreOfPeace(Properties p_41383_) {
		super(p_41383_);

	}
	
	@Override
	public boolean isFoil(ItemStack p_41453_) {
		
		return true;
	}
	
	@Override
	public void appendHoverText(ItemStack stack, Level level, List<Component> components, TooltipFlag flag) {
		
		components.add(Component.translatable("core_of_peace.tooltip").withStyle(ChatFormatting.GRAY));
		
		super.appendHoverText(stack, level, components, flag);
	}
	
	@Override
	public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
		
		ItemStack item = player.getItemInHand(hand);
		item.shrink(1);
		player.getCooldowns().addCooldown(this, 200);
		
		if(!level.isClientSide()) {
			
			if(HardmodeRequiemFunctions.isHardmode((ServerLevel)level)) {
				
				HardmodeRequiemFunctions.removeHardmode((ServerLevel)level);				
				player.displayClientMessage(Component.translatable("core_of_peace.hardmode_off").withStyle(ChatFormatting.AQUA), true);
			
			} else {
				
				player.displayClientMessage(Component.translatable("core_of_peace.not_hardmode").withStyle(ChatFormatting.WHITE), true);
			}	
		}
		
		return super.use(level, player, hand);
	}


}
