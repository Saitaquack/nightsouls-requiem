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

public class BloodyArmor extends ArmorItem {

	public BloodyArmor(IArmorMaterial materialIn, EquipmentSlotType slot, Properties builderIn) {
		super(materialIn, slot, builderIn);
		
	}
	
	@Override
    public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn)
    {
    
	tooltip.set(0, new StringTextComponent("§4"+tooltip.get(0).getString()+"§r"));
	tooltip.add(new StringTextComponent("§4Full set bonus : §7Has the same effects as Saitastone Armor but with stronger healing effects. Below half HP, the lower your HP is, the more healing you will get."));			
	super.addInformation(stack, worldIn, tooltip, flagIn);	
    }
	
	 @Override
	 public void onArmorTick(ItemStack stack, World world, PlayerEntity player) {
		 		 		 
		if(player.getItemStackFromSlot(EquipmentSlotType.HEAD).getItem() == ItemInit.BLOODY_HELMET.get() && 
		   player.getItemStackFromSlot(EquipmentSlotType.CHEST).getItem() == ItemInit.BLOODY_CHESTPLATE.get() && 
		   player.getItemStackFromSlot(EquipmentSlotType.LEGS).getItem() == ItemInit.BLOODY_LEGGINGS.get() && 
		   player.getItemStackFromSlot(EquipmentSlotType.FEET).getItem() == ItemInit.BLOODY_BOOTS.get())
		    	 
			 {		 
	
				 int randomHealChance = 0;
				 if(player.getHealth() <= player.getMaxHealth() * 0.25)			 
				 {
					 if(world.getGameTime() % 10 == 0)
					  {
						 randomHealChance = random.nextInt(3);
					  }
				 }
				 else if(player.getHealth() <= player.getMaxHealth() * 0.5)
				 {
					 if(world.getGameTime() % 25 == 0)
					  {
						 randomHealChance = random.nextInt(3);
					  }
					 
				 }
				 else if(player.getHealth() > player.getMaxHealth() * 0.5)
				 {
					 if(world.getGameTime() % 50 == 0)
					  {
						 randomHealChance = random.nextInt(3);
					  }
				 }
								 				    
				if(randomHealChance == 1)
				  {
				   player.heal(1.0F);
				  }
				  		      
			 }
		 	 
		super.onArmorTick(stack, world, player);
	  
     }

}
