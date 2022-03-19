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
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;

public class MoltenCore extends Item {

	public MoltenCore(Properties properties) {
		super(properties);

	}
	
	@Override
	public boolean hasEffect(ItemStack stack)
	{
		return true;
	}
	
    @Override
    public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn)
    {
    	
    tooltip.add(new StringTextComponent("§7If you can't stand the §cHEAT §7stay out of my way. 1 minute cooldown. Cooldown is 30 seconds and you have a 1/3 chance to not consume the item if you are wearing full primium or champion armor."));
	super.addInformation(stack, worldIn, tooltip, flagIn);
    }  
    
    @Override
    public Rarity getRarity(ItemStack stack) {
    	
    	return Rarity.RARE;
    }
    
    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
    	
    	ItemStack itemstack = playerIn.getHeldItem(handIn);
    	
    	if((playerIn.getItemStackFromSlot(EquipmentSlotType.HEAD).getItem() == ItemInit.PRIMIUM_HELMET.get() && 
    			playerIn.getItemStackFromSlot(EquipmentSlotType.CHEST).getItem() == ItemInit.PRIMIUM_CHESTPLATE.get() && 
    			playerIn.getItemStackFromSlot(EquipmentSlotType.LEGS).getItem() == ItemInit.PRIMIUM_LEGGINGS.get() && 
    			playerIn.getItemStackFromSlot(EquipmentSlotType.FEET).getItem() == ItemInit.PRIMIUM_BOOTS.get()) || 
    				 
    		   (playerIn.getItemStackFromSlot(EquipmentSlotType.HEAD).getItem() == ItemInit.CHAMPION_HELMET.get() && 
    			playerIn.getItemStackFromSlot(EquipmentSlotType.CHEST).getItem() == ItemInit.CHAMPION_CHESTPLATE.get() && 
    			playerIn.getItemStackFromSlot(EquipmentSlotType.LEGS).getItem() == ItemInit.CHAMPION_LEGGINGS.get() && 
    			playerIn.getItemStackFromSlot(EquipmentSlotType.FEET).getItem() == ItemInit.CHAMPION_BOOTS.get()))
    		
    	{
    		playerIn.getCooldownTracker().setCooldown(this, 600);
    		Random ran = new Random();
    		int randomUse = ran.nextInt(2);
    		if(randomUse != 0)
    		{
    			itemstack.shrink(1);
    		}
    	}
    	else
    	{
    		playerIn.getCooldownTracker().setCooldown(this, 1200);
        	itemstack.shrink(1);
    	}
    	
    	if(!worldIn.isRemote)
    	{
	    	playerIn.addPotionEffect(new EffectInstance(Effects.ABSORPTION, 600, 9));
	    	playerIn.addPotionEffect(new EffectInstance(Effects.FIRE_RESISTANCE, 600, 0));
	    	playerIn.addPotionEffect(new EffectInstance(Effects.HASTE, 600, 3));
	    	playerIn.addPotionEffect(new EffectInstance(Effects.SPEED, 600, 1));
    	}
    	
    	worldIn.playSound(playerIn, playerIn.getPosition(), SoundInit.MOLTEN_CORE.get(), SoundCategory.MASTER, 0.6F, 1.0F);
    	return super.onItemRightClick(worldIn, playerIn, handIn);
    }

}
