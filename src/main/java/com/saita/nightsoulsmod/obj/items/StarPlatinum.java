package com.saita.nightsoulsmod.obj.items;

import java.util.List;

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
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

public class StarPlatinum extends Item {

	public StarPlatinum(Properties properties) {
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
    	
    tooltip.add(new StringTextComponent("§7Consume it to beat the s*it out of someone using some ora's. 45 seconds cooldown."));
	super.addInformation(stack, worldIn, tooltip, flagIn);
    }  
	
	@Override
	public Rarity getRarity(ItemStack stack) {
		
		return Rarity.EPIC;
	}
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
		
		ItemStack itemstack = playerIn.getHeldItem(handIn);
		playerIn.getCooldownTracker().setCooldown(this, 900);
		itemstack.shrink(1);
		
		if((playerIn.getItemStackFromSlot(EquipmentSlotType.HEAD).getItem() == ItemInit.ROWEQUITE_HELMET.get() && 
    			playerIn.getItemStackFromSlot(EquipmentSlotType.CHEST).getItem() == ItemInit.ROWEQUITE_CHESTPLATE.get() && 
    			playerIn.getItemStackFromSlot(EquipmentSlotType.LEGS).getItem() == ItemInit.ROWEQUITE_LEGGINGS.get() && 
    			playerIn.getItemStackFromSlot(EquipmentSlotType.FEET).getItem() == ItemInit.ROWEQUITE_BOOTS.get()) || 
    				 
    		   (playerIn.getItemStackFromSlot(EquipmentSlotType.HEAD).getItem() == ItemInit.CHAMPION_HELMET.get() && 
    			playerIn.getItemStackFromSlot(EquipmentSlotType.CHEST).getItem() == ItemInit.CHAMPION_CHESTPLATE.get() && 
    			playerIn.getItemStackFromSlot(EquipmentSlotType.LEGS).getItem() == ItemInit.CHAMPION_LEGGINGS.get() && 
    			playerIn.getItemStackFromSlot(EquipmentSlotType.FEET).getItem() == ItemInit.CHAMPION_BOOTS.get()))
    	{
	    	playerIn.getCooldownTracker().setCooldown(ItemInit.SUPER_STAR.get(), 500);
    	}
		else
		{
			playerIn.getCooldownTracker().setCooldown(ItemInit.SUPER_STAR.get(), 900);
		}
		
		if(worldIn.isRemote)
    	{
			playerIn.sendMessage(new TranslationTextComponent("§5Yare Yare Daze..."), null);
    	}
    	
		if(!worldIn.isRemote)
		{
	    	playerIn.addPotionEffect(new EffectInstance(Effects.HASTE, 620, 3));
	    	playerIn.addPotionEffect(new EffectInstance(Effects.STRENGTH, 620, 6));
	    	playerIn.addPotionEffect(new EffectInstance(Effects.RESISTANCE, 620, 1));	
	    	playerIn.addPotionEffect(new EffectInstance(Effects.GLOWING, 620, 0));	
		}
    	
    	worldIn.playSound(playerIn, playerIn.getPosition(), SoundInit.STAR_PLATINUM.get(), SoundCategory.MASTER, 1.0F, 1.0F);
		
		return super.onItemRightClick(worldIn, playerIn, handIn);
	}

}
