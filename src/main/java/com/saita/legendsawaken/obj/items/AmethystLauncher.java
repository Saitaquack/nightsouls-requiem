package com.saita.legendsawaken.obj.items;

import java.util.List;

import com.saita.legendsawaken.entities.projectiles.AmethystProjectileEntity;
import com.saita.legendsawaken.init.SoundInit;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

public class AmethystLauncher extends Item {

	public AmethystLauncher(Properties p_41383_) {
		super(p_41383_);

	}
	
	@Override
	public void appendHoverText(ItemStack stack, Level level, List<Component> components, TooltipFlag flag) {
		
		components.add(Component.translatable("amethyst_launcher.tooltip").withStyle(ChatFormatting.GRAY));
		components.add(Component.translatable("amethyst_launcher.damage_tooltip").withStyle(ChatFormatting.BLUE));
		
		super.appendHoverText(stack, level, components, flag);
	}
	
	
	@Override
	public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
		
		ItemStack itemstack = player.getItemInHand(hand);
		ItemStack ammo = new ItemStack(Items.AMETHYST_SHARD);

		if(player.getInventory().contains(ammo) || player.isCreative()) {
			
			player.playSound(SoundInit.LAUNCHER_USED.get(), 1.0F, 1.0F);
			player.getCooldowns().addCooldown(this, 10);
			
			if(!player.isCreative()) {
				
				int ammoSlot = player.getInventory().findSlotMatchingItem(ammo);
				if(ammoSlot == -1) {
					player.getOffhandItem().shrink(1);			
				}
				else {
					player.getInventory().removeItem(ammoSlot, 1);	
				}
							
			}
					
			if(!level.isClientSide()) {	
				
				AmethystProjectileEntity proj = new AmethystProjectileEntity(level, player);
				proj.shootFromRotation(player, player.getXRot(), player.getYRot(), 0.0F, 3.0F, 1.0F);
		        level.addFreshEntity(proj);
		        
			}
		}
		
		return InteractionResultHolder.sidedSuccess(itemstack, level.isClientSide());
	}

}
