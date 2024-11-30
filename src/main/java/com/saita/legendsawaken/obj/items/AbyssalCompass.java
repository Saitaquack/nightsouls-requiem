package com.saita.legendsawaken.obj.items;

import com.saita.legendsawaken.init.TagsInit;
import com.saita.legendsawaken.util.HardmodeRequiemFunctions;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class AbyssalCompass extends Item {

	public AbyssalCompass(Properties p_41383_) {
		super(p_41383_);

	}
	
	@Override
	public boolean isFoil(ItemStack p_41453_) {
		
		return true;
	}
	
	@Override
	public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
		
		if(!level.isClientSide()) {
			
			if(HardmodeRequiemFunctions.isHardmode((ServerLevel)level)) {
			
				ItemStack stack = player.getItemInHand(hand);
				stack.shrink(1);
				BlockPos abyssCoords = ((ServerLevel)level).findNearestMapStructure(TagsInit.Structures.THE_ABYSS, player.blockPosition(), 50000, false);
				
				if(abyssCoords != null) {
					int abyssX = abyssCoords.getX();
					int abyssZ = abyssCoords.getZ();
					
					player.sendSystemMessage(Component.translatable("abyssal_compass.abyss_found"));
					player.sendSystemMessage(Component.literal("X: "+abyssX+" Z: "+abyssZ));
				}	
				else {
					player.sendSystemMessage(Component.translatable("abyssal_compass.abyss_not_found"));
				}
				
			} else {
				player.displayClientMessage(Component.translatable("abyssal_compass.not_hardmode"), true);
			}
		
		}
	
		return super.use(level, player, hand);
	}

}
