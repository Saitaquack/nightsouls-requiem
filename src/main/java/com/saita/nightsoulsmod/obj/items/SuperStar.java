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
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

public class SuperStar extends Item {

	public SuperStar(Properties properties) {
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
    	
    tooltip.add(new StringTextComponent("§7Will make you invincible and incredibly powerful for a short time ! 45 seconds cooldown. Cooldown is 25 seconds and you have a 1/3 chance to not consume the item if you are wearing full rowequite or champion armor."));
	super.addInformation(stack, worldIn, tooltip, flagIn);
    }  
    
    @Override
    public Rarity getRarity(ItemStack stack) {
    	
    	return Rarity.RARE;
    }
    
    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
    	
    	ItemStack itemstack = playerIn.getHeldItem(handIn);
    	
    	if((playerIn.getItemStackFromSlot(EquipmentSlotType.HEAD).getItem() == ItemInit.ROWEQUITE_HELMET.get() && 
    			playerIn.getItemStackFromSlot(EquipmentSlotType.CHEST).getItem() == ItemInit.ROWEQUITE_CHESTPLATE.get() && 
    			playerIn.getItemStackFromSlot(EquipmentSlotType.LEGS).getItem() == ItemInit.ROWEQUITE_LEGGINGS.get() && 
    			playerIn.getItemStackFromSlot(EquipmentSlotType.FEET).getItem() == ItemInit.ROWEQUITE_BOOTS.get()) || 
    				 
    		   (playerIn.getItemStackFromSlot(EquipmentSlotType.HEAD).getItem() == ItemInit.CHAMPION_HELMET.get() && 
    			playerIn.getItemStackFromSlot(EquipmentSlotType.CHEST).getItem() == ItemInit.CHAMPION_CHESTPLATE.get() && 
    			playerIn.getItemStackFromSlot(EquipmentSlotType.LEGS).getItem() == ItemInit.CHAMPION_LEGGINGS.get() && 
    			playerIn.getItemStackFromSlot(EquipmentSlotType.FEET).getItem() == ItemInit.CHAMPION_BOOTS.get()))
    	{
    		playerIn.getCooldownTracker().setCooldown(this, 500);
    		Random ran = new Random();
    		int randomUse = ran.nextInt(2);
    		if(randomUse != 0)
    		{
    			itemstack.shrink(1);
    		}
    	}
    	else
    	{
    		playerIn.getCooldownTracker().setCooldown(this, 900);
        	itemstack.shrink(1);
    	} 	
    	
    	 if(worldIn.isRemote)
    	 {
 	     playerIn.sendMessage(new TranslationTextComponent("§dTATATATATATATATA TATATATATATATATA TATATATATATATATA !"), null);
    	 }
    	 
    	playerIn.addPotionEffect(new EffectInstance(Effects.RESISTANCE, 240, 4));
    	playerIn.addPotionEffect(new EffectInstance(Effects.SPEED, 240, 3));
    	playerIn.addPotionEffect(new EffectInstance(Effects.JUMP_BOOST, 240, 2));
    	playerIn.addPotionEffect(new EffectInstance(Effects.STRENGTH, 240, 2));
    	playerIn.addPotionEffect(new EffectInstance(Effects.HASTE, 240, 2));
    	playerIn.addPotionEffect(new EffectInstance(Effects.NIGHT_VISION, 240, 0));
    	playerIn.addPotionEffect(new EffectInstance(Effects.GLOWING, 240, 0));
    	worldIn.playSound(playerIn, playerIn.getPosition(), SoundInit.SUPER_STAR.get(), SoundCategory.MASTER, 1.0F, 1.0F);
    	
    	return super.onItemRightClick(worldIn, playerIn, handIn);
    }

}
