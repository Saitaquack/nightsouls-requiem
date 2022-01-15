package com.saita.nightsoulsmod.obj.items;

import java.util.List;

import com.saita.nightsoulsmod.init.ItemInit;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;

public class SaitastoneArmor extends ArmorItem {

	public SaitastoneArmor(IArmorMaterial materialIn, EquipmentSlotType slot, Properties builderIn) {
		super(materialIn, slot, builderIn);

	}
	
	@Override
    public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn)
    {
    
	tooltip.add(new StringTextComponent("§cFull set bonus : §7Slowly restores health overtime. Reduced cooldowns to Take a Breather and Fade."));			
	super.addInformation(stack, worldIn, tooltip, flagIn);
	
    }
	
	 @Override
	 public void onArmorTick(ItemStack stack, World world, PlayerEntity player) {
		 		 		 
		if(player.getItemStackFromSlot(EquipmentSlotType.HEAD).getItem() == ItemInit.SAITASTONE_HELMET.get() && 
		   player.getItemStackFromSlot(EquipmentSlotType.CHEST).getItem() == ItemInit.SAITASTONE_CHESTPLATE.get() && 
		   player.getItemStackFromSlot(EquipmentSlotType.LEGS).getItem() == ItemInit.SAITASTONE_LEGGINGS.get() && 
		   player.getItemStackFromSlot(EquipmentSlotType.FEET).getItem() == ItemInit.SAITASTONE_BOOTS.get())
		    	 
			 {		 
				 if(world.getGameTime() % 70 == 0)
				  {
					 int randomHealChance = random.nextInt(3);
					    
					   if(randomHealChance == 1)
					   {
					   player.heal(1.0F);
					   }
				   }
			      
			 }
		 	 
		super.onArmorTick(stack, world, player);
	  
     }

}
