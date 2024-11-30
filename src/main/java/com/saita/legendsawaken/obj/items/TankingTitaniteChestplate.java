package com.saita.legendsawaken.obj.items;

import java.util.List;

import com.saita.legendsawaken.init.ItemInit;

import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

public class TankingTitaniteChestplate extends TitaniteArmor {

	public TankingTitaniteChestplate(ArmorMaterial p_40386_, Type p_266831_, Properties p_40388_) {
		super(p_40386_, p_266831_, p_40388_);

	}
	
	@Override
	public void appendHoverText(ItemStack stack, Level level, List<Component> components, TooltipFlag flag) {
		
		components.add(Component.translatable("titanite_armor.tanking_chestplate"));
		
		super.appendHoverText(stack, level, components, flag);
	}
	
	@Override
	public void onArmorTick(ItemStack stack, Level level, Player player) {
		
		if(player.getItemBySlot(EquipmentSlot.HEAD).getItem() == ItemInit.TITANITE_HELMET.get() &&
		   player.getItemBySlot(EquipmentSlot.CHEST).getItem() == ItemInit.TANKING_TITANITE_CHESTPLATE.get() &&
		   player.getItemBySlot(EquipmentSlot.LEGS).getItem() == ItemInit.TITANITE_LEGGINGS.get() &&
		   player.getItemBySlot(EquipmentSlot.FEET).getItem() == ItemInit.TITANITE_BOOTS.get()) 
		{
			player.addEffect(new MobEffectInstance(MobEffects.DIG_SPEED, 20, 0, false, false));	
			player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 20, 0, false, false));
			player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 20, 0, false, false));
			
			if(level.getDayTime() % 400 == 0) {
				player.addEffect(new MobEffectInstance(MobEffects.ABSORPTION, 180, 1));
			}
		}
		
		super.onArmorTick(stack, level, player);
	}

}
