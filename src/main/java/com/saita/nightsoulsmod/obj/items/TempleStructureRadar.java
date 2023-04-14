package com.saita.nightsoulsmod.obj.items;

import java.util.List;

import com.saita.nightsoulsmod.init.StructureInit;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.Rarity;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

public class TempleStructureRadar extends Item {

	public TempleStructureRadar(Properties properties) {
		super(properties);

	}
	
	@Override
	public Rarity getRarity(ItemStack stack) {

		return Rarity.UNCOMMON;
	}
	
	@Override
	public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn)
	{
	    	
	   tooltip.add(new StringTextComponent("§7One time use only. Will locate the nearest NightSouls Temple."));
	   super.addInformation(stack, worldIn, tooltip, flagIn);
	} 
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
		
		 if(playerIn.world.getDimensionKey().getLocation().getPath() == "overworld")	 
	  	    {
		
				ItemStack itemstack = playerIn.getHeldItem(handIn);
		    	playerIn.getCooldownTracker().setCooldown(this, 1200);
		        itemstack.shrink(1);
			
				if(!worldIn.isRemote)
		        {
		            ServerWorld serverworld = (ServerWorld)worldIn;
		            BlockPos structurepos = serverworld.getStructureLocation(StructureInit.NIGHTSOULS_TEMPLE.get(), playerIn.getPosition(), 20000, false);
		            int structureX = structurepos.getX();
		            int structureZ = structurepos.getZ();
		            
		            ItemStack paper = new ItemStack(Items.PAPER);
		            paper.setDisplayName(((ITextComponent)new StringTextComponent("NightSouls temple found at X: "+structureX+" Z: "+structureZ+"")));
				 	playerIn.dropItem(paper, false).setNoPickupDelay();		
					
		        }
	  	    }
			else
			{
				 if(worldIn.isRemote)
		    		{
		  	           playerIn.sendMessage(new TranslationTextComponent("§f"+playerIn.getName().getString()+", you need to be in the Overworld to use a Structure Radar"), null);
		    		} 
			}
	
	   return super.onItemRightClick(worldIn, playerIn, handIn);
        
	}

}
