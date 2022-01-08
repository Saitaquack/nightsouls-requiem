package com.saita.nightsoulsmod.obj.items;

import java.util.List;

import com.saita.nightsoulsmod.init.SoundInit;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Rarity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

public class LifeCrystal extends Item {
	
	BlockPos requiemBlockPos = new BlockPos(0,0,0);

	public LifeCrystal(Properties properties) {
		super(properties);

	}
	
	@Override
	public boolean hasEffect(ItemStack stack) {
		
		return true;
	}
	
	@Override
	public Rarity getRarity(ItemStack stack) {
		
		return Rarity.RARE;
	}
	
	@Override
    public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn)
    {
    
	tooltip.add(new StringTextComponent("§7Increases your maximum life. You can have a maximum of 15 hearts of health (20 hearts in a NightSouls Requiem World), but you will lose your bonus health if you die."));
	super.addInformation(stack, worldIn, tooltip, flagIn);
	
    }
	
	@Override
	public ItemStack onItemUseFinish(ItemStack stack, World worldIn, LivingEntity entityLiving) {
		
		if(entityLiving instanceof PlayerEntity)
		{
			PlayerEntity playerIn = (PlayerEntity)entityLiving;
			
		     if((playerIn.getAttribute(Attributes.MAX_HEALTH).getValue() < 30.0D || (playerIn.getAttribute(Attributes.MAX_HEALTH).getValue() < 40.0D) && (worldIn.getGameTime() >= NightSoulsKey.requiemConstant)))
    	     {
    	       playerIn.getAttribute(Attributes.MAX_HEALTH).applyPersistentModifier(new AttributeModifier("MaxHealth", 2.0F, AttributeModifier.Operation.ADDITION));
    	       playerIn.heal(2);
    	       playerIn.playSound(SoundInit.LIFE_CRYSTAL.get(), 1.0F, 1.0F);    	
         	 }
		     else
		     {
		    	 if(worldIn.isRemote)
		    	 {
		  	     playerIn.sendMessage(new TranslationTextComponent("§fYou are already at max HP!"), null);
		    	 }
		     }
		}
		
		return super.onItemUseFinish(stack, worldIn, entityLiving);
	}

}
