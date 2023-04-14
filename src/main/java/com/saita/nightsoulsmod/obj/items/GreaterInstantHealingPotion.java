package com.saita.nightsoulsmod.obj.items;

import java.util.List;
import java.util.Random;

import com.saita.nightsoulsmod.init.ItemInit;
import com.saita.nightsoulsmod.init.SoundInit;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Rarity;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;

public class GreaterInstantHealingPotion extends Item {

	public GreaterInstantHealingPotion(Properties properties) {
		super(properties);

	}
	
	@Override
	public Rarity getRarity(ItemStack stack) {
		
		return Rarity.RARE;
	}
	
	@Override
    public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn)
    {
    	
    tooltip.add(new StringTextComponent("§7Heals 6 hearts instantly. 3 seconds cooldown. Has no cooldown, heals 8 hearts, and you have a 1/3 chance to not consume the item if you are wearing full therenite or champion armor."));
	super.addInformation(stack, worldIn, tooltip, flagIn);
    }  
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
		
		if(playerIn.getHealth() != playerIn.getMaxHealth())			
		{ 
	        ItemStack itemstack = playerIn.getHeldItem(handIn);
	        
			if((playerIn.getItemStackFromSlot(EquipmentSlotType.HEAD).getItem() == ItemInit.THERENITE_HELMET.get() && 
	    			playerIn.getItemStackFromSlot(EquipmentSlotType.CHEST).getItem() == ItemInit.THERENITE_CHESTPLATE.get() && 
	    			playerIn.getItemStackFromSlot(EquipmentSlotType.LEGS).getItem() == ItemInit.THERENITE_LEGGINGS.get() && 
	    			playerIn.getItemStackFromSlot(EquipmentSlotType.FEET).getItem() == ItemInit.THERENITE_BOOTS.get()) || 
	    				 
	    		   (playerIn.getItemStackFromSlot(EquipmentSlotType.HEAD).getItem() == ItemInit.CHAMPION_HELMET.get() && 
	    			playerIn.getItemStackFromSlot(EquipmentSlotType.CHEST).getItem() == ItemInit.CHAMPION_CHESTPLATE.get() && 
	    			playerIn.getItemStackFromSlot(EquipmentSlotType.LEGS).getItem() == ItemInit.CHAMPION_LEGGINGS.get() && 
	    			playerIn.getItemStackFromSlot(EquipmentSlotType.FEET).getItem() == ItemInit.CHAMPION_BOOTS.get()))
	    	{
				if(!worldIn.isRemote)
				{
					playerIn.heal(16);
				}
	    		Random ran = new Random();
	    		int randomUse = ran.nextInt(2);
	    		if(randomUse != 0)
	    		{
	    			itemstack.shrink(1);
	    		}
	    		
	    	}
	    	else
	    	{
	    		playerIn.getCooldownTracker().setCooldown(this, 60);
	    		itemstack.shrink(1);
	    		
	    		if(!worldIn.isRemote)
	    		{
	    			playerIn.heal(12);
	    		}
	    	} 				
	        
	        worldIn.playSound(playerIn, playerIn.getPosition(), SoundInit.INSTANT_POTION.get(), SoundCategory.MASTER, 1.0F, 1.0F);    
		}
		
	    return super.onItemRightClick(worldIn, playerIn, handIn);
	    
	}

}
