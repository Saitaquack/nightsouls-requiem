package com.saita.legendsawaken.obj.items;

import com.saita.legendsawaken.init.ItemInit;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class MythrilChestplateSetBonus extends MythrilArmor{

	public MythrilChestplateSetBonus(ArmorMaterial p_40386_, Type p_266831_, Properties p_40388_) {
		super(p_40386_, p_266831_, p_40388_);
		
	}
	
	@Override
	public void onArmorTick(ItemStack stack, Level level, Player player) {
		
		if(player.getItemBySlot(EquipmentSlot.HEAD).getItem() == ItemInit.MYTHRIL_HELMET.get() &&
		   player.getItemBySlot(EquipmentSlot.CHEST).getItem() == ItemInit.MYTHRIL_CHESTPLATE.get() &&
		   player.getItemBySlot(EquipmentSlot.LEGS).getItem() == ItemInit.MYTHRIL_LEGGINGS.get() &&
		   player.getItemBySlot(EquipmentSlot.FEET).getItem() == ItemInit.MYTHRIL_BOOTS.get()) 
		{
			player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 20, 0, false, false));
			player.addEffect(new MobEffectInstance(MobEffects.DIG_SPEED, 20, 0, false, false));	
			player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 20, 0, false, false));	
		}
		
		super.onArmorTick(stack, level, player);
	}

}
