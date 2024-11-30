package com.saita.legendsawaken.obj.items;

import java.util.List;
import java.util.Random;

import com.saita.legendsawaken.entities.mobs.EyeOfCthulhuEntity;
import com.saita.legendsawaken.init.EntityInit;
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

public class SuspiciousLookingEye extends Item {

	public SuspiciousLookingEye(Properties p_41383_) {
		super(p_41383_);

	}
	
	@Override
	public void appendHoverText(ItemStack stack, Level level, List<Component> components, TooltipFlag flag) {
		
		components.add(Component.translatable("suspicious_looking_eye.tooltip").withStyle(ChatFormatting.RED));
		
		super.appendHoverText(stack, level, components, flag);
	}
	
	@Override
	public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
		
		if(!level.isClientSide()) {
			
			if(HardmodeRequiemFunctions.isHardmode((ServerLevel)level)) {
				
				ItemStack item = player.getItemInHand(hand);
				item.shrink(1);
				player.getCooldowns().addCooldown(this, 60);
				player.displayClientMessage(Component.translatable("eye_of_cthulhu.awoken").withStyle(ChatFormatting.RED), true);
				
				player.playSound(SoundInit.CTHULHU_SCREAM.get(), 1.0F, 1.0F);
				player.playSound(SoundInit.BOSS_ONE.get(), 1.0F, 1.0F);
				
				player.playNotifySound(SoundInit.CTHULHU_SCREAM.get(), SoundSource.HOSTILE, 1.0F, 1.0F);
				player.playNotifySound(SoundInit.BOSS_ONE.get(), SoundSource.MASTER, 1.0F, 1.0F);
				
				Random rand = new Random();
				int randX = rand.nextInt(16);
				int randZ = rand.nextInt(16);
				boolean negX = rand.nextBoolean();
		    	boolean negZ = rand.nextBoolean();
		    	
		    	if(negX)
		    	{
		    		randX = -randX;
		    	}
		    	if(negZ)
		    	{
		    		randZ = -randZ;
		    	}
		    	
		    	EyeOfCthulhuEntity eoc = new EyeOfCthulhuEntity(EntityInit.EYE_OF_CTHULHU.get(), level);
		    	eoc.setPos(player.getX() + randX, player.getY(), player.getZ() + randZ);
		    	level.addFreshEntity(eoc);  	
		    	
				
			} else {	
				
				player.displayClientMessage(Component.translatable("eye_of_cthulhu.not_hardmode").withStyle(ChatFormatting.WHITE), true);
			}		
		}		
		
		return super.use(level, player, hand);
	}
}
