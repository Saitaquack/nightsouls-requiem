package com.saita.nightsoulsmod.obj.items;

import java.util.List;

import com.saita.nightsoulsmod.init.SoundInit;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;

public class FantaGlasses extends ArmorItem {

	public FantaGlasses(IArmorMaterial materialIn, EquipmentSlotType slot, Properties builderIn) {
		super(materialIn, slot, builderIn);

	}
	
	    @Override
	    public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn)
	    {
	    	
	    tooltip.add(new StringTextComponent("§7SALUT"));
		super.addInformation(stack, worldIn, tooltip, flagIn);
	    }  
	    
	    @Override
	    public void onArmorTick(ItemStack stack, World world, PlayerEntity player) {
	    	
	    	if(player.isSneaking())
	    	{
	    		int randomSalut = random.nextInt(29);
	    		if(randomSalut == 0)
	    		{
	             	world.playSound(player, player.getPosition(), SoundInit.SALUT.get(), SoundCategory.MASTER, 0.6F, 1.0F);
	    		}

	    	}
	    	
	    	super.onArmorTick(stack, world, player);
	    }

}
