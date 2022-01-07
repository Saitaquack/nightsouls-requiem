package com.saita.nightsoulsmod.obj.items;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.saita.nightsoulsmod.init.ItemInit;
import com.saita.nightsoulsmod.init.SoundInit;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Rarity;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

public class NightSoulsKey extends Item {
	
	public static long requiemConstant = 240000000L;

	
	public static final Logger LOGGER = LogManager.getLogger();
	BlockPos requiemBlockPos = new BlockPos(0,0,0);

	public NightSoulsKey(Properties properties) {
		super(properties);

	}
	
	@Override
    public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn)
    {

	tooltip.add(new StringTextComponent("§7Right Click to consume it and convert this world into a \"§5NightSouls Requiem World§7\". In a Requiem World, you can increase your health to 20 hearts of HP, meteorites will spawn underground, and you will be able to obtain Paragonic blocks around the world."));
	super.addInformation(stack, worldIn, tooltip, flagIn);
    }
	
	@Override
	public boolean hasEffect(ItemStack stack) {
		
		return true;
	}
	
	@Override
	public Rarity getRarity(ItemStack stack) {
		
		return Rarity.EPIC;
	}
	
	 @Override
	 public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
	    	
		 if(playerIn.world.getDimensionKey().getLocation().getPath() == "overworld")
	  	    {
		    	ItemStack itemstack = playerIn.getHeldItem(handIn);
			    itemstack.shrink(1);	
	    
			    if(!playerIn.isCreative())
			    {
				    playerIn.getCooldownTracker().setCooldown(this, 2400);
			    }
			    else
			    {
			    	playerIn.getCooldownTracker().setCooldown(this, 200);
			    }
			    
			    if(worldIn.getDayTime() < NightSoulsKey.requiemConstant)
			    {
			    	
			    	if(!worldIn.isRemote) 
					{
						long getCurrentDayTime = worldIn.getDayTime();
						((ServerWorld) worldIn).setDayTime(getCurrentDayTime + NightSoulsKey.requiemConstant);	
					}
				    
				    ItemStack NSEmeralds = new ItemStack(ItemInit.NIGHTSOULS_EMERALD.get(), 64); 
				    ItemStack medallion = new ItemStack(ItemInit.REQUIEM_MEDALLION.get(), 1); 
		
				    
			    	worldIn.playSound(playerIn, playerIn.getPosition(), SoundInit.REQUIEM.get(), SoundCategory.MASTER, 1.0F, 1.0F);
			    	playerIn.dropItem(NSEmeralds, false).setNoPickupDelay();
			    	playerIn.dropItem(medallion, false).setNoPickupDelay();
		
		
				    if(worldIn.isRemote)
				    {			  
				    	LOGGER.info(""+playerIn.getName().getString()+" a consommé une NightSouls Key et a converti le monde en Requiem.");      	
				    	playerIn.sendMessage(new TranslationTextComponent("§5YOU CONVERTED THIS WORLD INTO A NIGHTSOULS REQUIEM WORLD !"), null);
				    }
				    
			    }
			    else
			    {	 	     
			 	     ItemStack hellstone = new ItemStack(ItemInit.HELLSTONE.get(), 4);  
			 	     ItemStack spacestone = new ItemStack(ItemInit.SPACESTONE.get(), 4);
			 	     ItemStack heavenstone = new ItemStack(ItemInit.HEAVENSTONE.get(), 4);
			 	     ItemStack antistone = new ItemStack(ItemInit.ANTISTONE.get(), 4);
					 playerIn.dropItem(hellstone, false).setNoPickupDelay();
					 playerIn.dropItem(spacestone, false).setNoPickupDelay();
					 playerIn.dropItem(heavenstone, false).setNoPickupDelay();
					 playerIn.dropItem(antistone, false).setNoPickupDelay();
					 
			    	 if(worldIn.isRemote)
			 	     {
			 	 	     playerIn.sendMessage(new TranslationTextComponent("This world is already a NightSouls Requiem World. Take these instead."), null);
			 	     }
			    }
			    
		    }
		    else
	    	{
	    	    if(worldIn.isRemote)
	    		{
	  	           playerIn.sendMessage(new TranslationTextComponent("§f"+playerIn.getName().getString()+", you need to be in the Overworld to use a NightSouls Key"), null);
	    		}
	    	}
	    	    	
	    return super.onItemRightClick(worldIn, playerIn, handIn);
	   }

}
