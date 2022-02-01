package com.saita.nightsoulsmod.obj.special;

import java.util.List;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.EntityType;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.fml.RegistryObject;

public class RequiemSpawnEggItem extends ModSpawnEggItem {

	public RequiemSpawnEggItem(RegistryObject<? extends EntityType<?>> entityTypeSupplier, int primaryColorIn,
			int secondaryColorIn, Properties builder) {
		super(entityTypeSupplier, primaryColorIn, secondaryColorIn, builder);
	
	}
	
	@Override
	public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn)
	{
	    	
		tooltip.add(new StringTextComponent("§7Only spawns naturally if the world is a Requiem World."));
		super.addInformation(stack, worldIn, tooltip, flagIn);
	}  



}
