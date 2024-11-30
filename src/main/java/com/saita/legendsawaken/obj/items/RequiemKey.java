package com.saita.legendsawaken.obj.items;

import java.util.List;

import com.saita.legendsawaken.init.ItemInit;
import com.saita.legendsawaken.init.SoundInit;
import com.saita.legendsawaken.util.HardmodeRequiemFunctions;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

public class RequiemKey extends Item {

	public RequiemKey(Properties p_41383_) {
		super(p_41383_);

	}
	
	@Override
	public boolean isFoil(ItemStack p_41453_) {
		
		return true;
	}
	
	@Override
	public void appendHoverText(ItemStack stack, Level level, List<Component> components, TooltipFlag flag) {
		
		components.add(Component.translatable("requiem_key.tooltip").withStyle(ChatFormatting.GRAY));
		
		super.appendHoverText(stack, level, components, flag);
	}
	
	@Override
	public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
		
		ItemStack item = player.getItemInHand(hand);
		item.shrink(1);
		player.getCooldowns().addCooldown(this, 200);
			
		if(!level.isClientSide()) {
			
			if(HardmodeRequiemFunctions.isNotRequiem((ServerLevel)level)) {
			
				HardmodeRequiemFunctions.setRequiem((ServerLevel)level);
				player.displayClientMessage(Component.translatable("requiem_key.requiem_on").withStyle(ChatFormatting.DARK_PURPLE), true);
				
				player.playSound(SoundInit.REQUIEM.get(), 1.0F, 1.0F);
				
				player.playNotifySound(SoundInit.REQUIEM.get(), SoundSource.MASTER, 1.0F, 1.0F);
								
				
			} else {	
				player.displayClientMessage(Component.translatable("requiem_key.already_requiem").withStyle(ChatFormatting.WHITE), true);
				
				player.drop(new ItemStack(ItemInit.COSMOLITE_INGOT.get(), 4), false).setNoPickUpDelay();
				player.drop(new ItemStack(ItemInit.DEMONITE_INGOT.get(), 4), false).setNoPickUpDelay();
				player.drop(new ItemStack(ItemInit.SERAPHITE_INGOT.get(), 4), false).setNoPickUpDelay();
				player.drop(new ItemStack(ItemInit.WARPSTONE_INGOT.get(), 4), false).setNoPickUpDelay();
			}		
		}		
			
		return super.use(level, player, hand);
	}

}
