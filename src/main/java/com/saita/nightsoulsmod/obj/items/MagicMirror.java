package com.saita.nightsoulsmod.obj.items;

import java.util.List;
import java.util.Optional;

import com.saita.nightsoulsmod.init.SoundInit;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Rarity;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

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
    	
    tooltip.add(new StringTextComponent("§7Gaze in the mirror to teleport to this world's spawnpoint. Hold §eSHIFT§7 while clicking to teleport to your bed. �f15 seconds cooldown."));
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
    		
	     	  if(!worldIn.isRemote && Screen.hasShiftDown())
	     	  {
		     	  ServerPlayerEntity player = (ServerPlayerEntity) playerIn;
		     	  ServerWorld respawnWorld = player.server.getWorld(player.func_241141_L_());
		     	  BlockPos spawn = player.func_241140_K_();
		     	  float spawnAngle = player.func_242109_L();
		     	  boolean forcedSpawn = false;
		     	  boolean preserveAnchorCharges = true;
		     	  Optional<Vector3d> maybeSpawn = PlayerEntity.func_242374_a(respawnWorld, spawn, spawnAngle, forcedSpawn, preserveAnchorCharges);	
		     	 
		     	  Double bedSpawnX = maybeSpawn.get().getX();
		     	  Double bedSpawnY = maybeSpawn.get().getY();
		     	  Double bedSpawnZ = maybeSpawn.get().getZ();

		     	  playerIn.teleportKeepLoaded(bedSpawnX, bedSpawnY, bedSpawnZ);
     	  		     	 
	     	  }
	     	  else
	     	  {
	     		 double worldSpawnX = worldIn.getWorldInfo().getSpawnX();
		     	 double worldSpawnY = worldIn.getWorldInfo().getSpawnY();
		     	 double worldSpawnZ = worldIn.getWorldInfo().getSpawnZ();

		     	 playerIn.teleportKeepLoaded(worldSpawnX, worldSpawnY, worldSpawnZ);
	     	  }
	     	    	 
	     	  if(!playerIn.isCreative())
	     	  {
	     		   playerIn.addPotionEffect(new EffectInstance(Effects.NAUSEA, 200, 0));
	     		   playerIn.getCooldownTracker().setCooldown(this, 300);
	     	  }
	           	  
	     	  worldIn.playSound(playerIn, playerIn.getPosition(), SoundInit.MAGIC_MIRROR.get(), SoundCategory.MASTER, 1.0F, 1.0F); 	  

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
