package com.saita.legendsawaken.obj.items;

import java.util.List;

import com.saita.legendsawaken.init.SoundInit;
import com.saita.legendsawaken.util.HardmodeRequiemFunctions;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

public class VitalCrystal extends Item {

	public VitalCrystal(Properties p_41383_) {
		super(p_41383_);

	}
	
	@Override
	public boolean isFoil(ItemStack p_41453_) {
		
		return true;
	}
	
	@Override
	public void appendHoverText(ItemStack stack, Level level, List<Component> components, TooltipFlag flag) {
		
		components.add(Component.translatable("vital_crystal.tooltip").withStyle(ChatFormatting.GRAY));
		
		super.appendHoverText(stack, level, components, flag);
	}
	
	@Override
	public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
		
		player.playSound(SoundInit.VITAL_CRYSTAL_USED.get(), 1.0F, 1.0F);
		player.getCooldowns().addCooldown(this, 10);
		
		if(!level.isClientSide()) {
			
			if(player.getAttribute(Attributes.MAX_HEALTH).getValue() < 30.0D || (player.getAttribute(Attributes.MAX_HEALTH).getValue() < 40.0D && HardmodeRequiemFunctions.isRequiem((ServerLevel)level))) {
				
				ItemStack itemstack = player.getItemInHand(hand);
				
				itemstack.shrink(1);
				player.getAttribute(Attributes.MAX_HEALTH).addPermanentModifier(new AttributeModifier("MaxHealth", 2.0F, AttributeModifier.Operation.ADDITION));
				player.heal(2.0F);		
				
			} else {
	
				player.displayClientMessage(Component.translatable("vital_crystal.full_hp").withStyle(ChatFormatting.WHITE), true);
				
			}
		}
				
		return super.use(level, player, hand);
	}

}
