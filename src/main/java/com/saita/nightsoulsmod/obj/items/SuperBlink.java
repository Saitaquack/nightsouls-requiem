package com.saita.nightsoulsmod.obj.items;

import java.util.List;

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
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;

public class SuperBlink extends Item {

	public SuperBlink(Properties properties) {
		super(properties);

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
	public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn)
	{
	    	
	   tooltip.add(new StringTextComponent("§7Goes twice as far as regular Blink. Cooldown : 3 seconds"));
	   super.addInformation(stack, worldIn, tooltip, flagIn);
	} 
	
	 
	 @Override
	 public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
		
		 playerIn.getCooldownTracker().setCooldown(this, 60);
		 		    	    	 
		 int distance = 14;
		 
         float f1 = MathHelper.cos(-playerIn.rotationYaw * 0.017453292F - (float)Math.PI);
         float f2 = MathHelper.sin(-playerIn.rotationYaw * 0.017453292F - (float)Math.PI);
         float f3 = -MathHelper.cos(-playerIn.rotationPitch * 0.017453292F);
         
         double playerX = playerIn.getPosX();
         double playerY = playerIn.getPosY();
         double playerZ = playerIn.getPosZ();
      
         double newPlayerY = playerIn.getPosY();

         
         for(int i = 0; i < distance; i++)
         {
             BlockPos targetPos = new BlockPos(playerX + distance*f2*f3, playerY + i, playerZ + distance*f1*f3);
             
        	 if(worldIn.getBlockState(targetPos).isSolid())
        	 {
        		 newPlayerY++;
        	 }
        	 else
        	 {
        		 i = 14;
        	 }
         }

		 playerIn.setPositionAndUpdate(playerX + distance*f2*f3, newPlayerY, playerZ + distance*f1*f3);
	     playerIn.setSprinting(true);
 	     worldIn.playSound(playerIn, playerIn.getPosition(), SoundInit.BLINK.get(), SoundCategory.MASTER, 1.0F, 1.0F);
	    
	    
	    return super.onItemRightClick(worldIn, playerIn, handIn);
	    
	  }

}
