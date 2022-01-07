package com.saita.nightsoulsmod.obj.items;

import java.util.List;

import com.saita.nightsoulsmod.init.SoundInit;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
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

public class MagicMirror extends Item {

	public MagicMirror(Properties properties) {
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
    	
    tooltip.add(new StringTextComponent("§7Gaze in the mirror to teleport to this world's spawn point. Only works if you are in the Overworld. §f2 minutes cooldown."));
	super.addInformation(stack, worldIn, tooltip, flagIn);
    }  
    
    @Override
    public Rarity getRarity(ItemStack stack) {
    	
    	return Rarity.RARE;
    }
    
    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
    	
    	if(playerIn.world.getDimensionKey().getLocation().getPath() == "overworld")
    	  {
    		
	     	  if(!playerIn.isCreative())
	     	  {
	     		   playerIn.addPotionEffect(new EffectInstance(Effects.NAUSEA, 200, 0));
	     		   playerIn.getCooldownTracker().setCooldown(this, 2400);
	     	  }
	           	  
	     	  worldIn.playSound(playerIn, playerIn.getPosition(), SoundInit.MAGIC_MIRROR.get(), SoundCategory.MASTER, 1.0F, 1.0F);
	   
	     	  int spawnX = worldIn.getWorldInfo().getSpawnX();
	     	  int spawnY = worldIn.getWorldInfo().getSpawnY();
	     	  int spawnZ = worldIn.getWorldInfo().getSpawnZ();
	     	  playerIn.teleportKeepLoaded(spawnX, spawnY, spawnZ);

    	}         
    	else
    	{
    	    if(worldIn.isRemote)
    		{
  	           playerIn.sendMessage(new TranslationTextComponent("§f"+playerIn.getName().getString()+", you need to be in the Overworld to use a Magic Mirror"), null);
    		}
    	}

    	return super.onItemRightClick(worldIn, playerIn, handIn);
    }

}
