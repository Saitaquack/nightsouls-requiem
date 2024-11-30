package com.saita.legendsawaken.obj.items;

import java.util.List;
import java.util.Random;

import com.saita.legendsawaken.entities.projectiles.HellfireBulletProjectileEntity;
import com.saita.legendsawaken.init.SoundInit;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

public class HellfireShotgun extends Item {
	
	 private static final int NUM_PROJECTILES = 8;
	 private static final float SPREAD = 5.0F;

	public HellfireShotgun(Properties p_41383_) {
		super(p_41383_);

	}
	
	@Override
	public void appendHoverText(ItemStack stack, Level level, List<Component> components, TooltipFlag flag) {
		
		components.add(Component.translatable("hellfire_shotgun.tooltip").withStyle(ChatFormatting.GRAY));
		components.add(Component.translatable("hellfire_shotgun.damage_tooltip").withStyle(ChatFormatting.BLUE));
		
		super.appendHoverText(stack, level, components, flag);
	}
	

	@Override
	public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
		
		ItemStack itemstack = player.getItemInHand(hand);
			
		player.playSound(SoundInit.HELLFIRE_SHOTGUN.get(), 1.0F, 1.0F);
		player.getCooldowns().addCooldown(this, 18);
				
		if(!level.isClientSide()) {	
			
			 Random rand = new Random();
	            for (int i = 0; i < NUM_PROJECTILES; i++) {

	                HellfireBulletProjectileEntity proj = new HellfireBulletProjectileEntity(level, player);

	                float spreadX = (rand.nextFloat() - 0.5F) * SPREAD;
	                float spreadY = (rand.nextFloat() - 0.5F) * SPREAD;
	          
	                proj.shootFromRotation(player, player.getXRot() + spreadX, player.getYRot() + spreadY, 0.0F, 4.0F, 1.0F);
	                level.addFreshEntity(proj);
	            }
		        
			
		}
		
		return InteractionResultHolder.sidedSuccess(itemstack, level.isClientSide());
	}

}
