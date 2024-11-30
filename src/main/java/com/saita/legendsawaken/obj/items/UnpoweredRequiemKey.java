package com.saita.legendsawaken.obj.items;

import java.util.List;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

public class UnpoweredRequiemKey extends Item {

	public UnpoweredRequiemKey(Properties p_41383_) {
		super(p_41383_);

	}
	
	@Override
	public void appendHoverText(ItemStack stack, Level level, List<Component> components, TooltipFlag flag) {
		
		components.add(Component.translatable("unpowered_requiem_key.tooltip").withStyle(ChatFormatting.GRAY));
		
		super.appendHoverText(stack, level, components, flag);
	}

}
