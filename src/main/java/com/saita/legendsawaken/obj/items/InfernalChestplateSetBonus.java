package com.saita.legendsawaken.obj.items;

import com.saita.legendsawaken.init.ItemInit;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class InfernalChestplateSetBonus extends InfernalArmor{

	public InfernalChestplateSetBonus(ArmorMaterial p_40386_, Type p_266831_, Properties p_40388_) {
		super(p_40386_, p_266831_, p_40388_);
		
	}
	
	@Override
	public void onArmorTick(ItemStack stack, Level level, Player player) {
		
		if(player.getItemBySlot(EquipmentSlot.HEAD).getItem() == ItemInit.INFERNAL_HELMET.get() &&
		   player.getItemBySlot(EquipmentSlot.CHEST).getItem() == ItemInit.INFERNAL_CHESTPLATE.get() &&
		   player.getItemBySlot(EquipmentSlot.LEGS).getItem() == ItemInit.INFERNAL_LEGGINGS.get() &&
		   player.getItemBySlot(EquipmentSlot.FEET).getItem() == ItemInit.INFERNAL_BOOTS.get()) 
		{
			
			player.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 20, 0, false, false));
			
			if(player.isInLava()) {
				
				if(level.getDayTime() % 100 == 0) {
					
					player.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 160, 1));
					player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 160, 0));
					player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 160, 1));					
				}
			} 
			else if(player.isOnFire()) {
				
				if(level.getDayTime() % 100 == 0) {
					
					player.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 160, 0));
					player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 160, 0));
					player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 160, 0));					
				}
			}
		}
		
		super.onArmorTick(stack, level, player);
	}

}
