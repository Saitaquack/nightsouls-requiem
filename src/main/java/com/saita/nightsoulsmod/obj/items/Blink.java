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
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;

public class Blink extends Item {

	public Blink(Properties properties) {
		super(properties);

	}
	
	@Override
	public Rarity getRarity(ItemStack stack) {

	return Rarity.RARE;
	}
	
	@Override
	public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn)
	{
	    	
	   tooltip.add(new StringTextComponent("§7Teleports you in the direction you are looking. Use with caution, you may get yourself suffocated. Cooldown : 5 seconds. Cooldown is 3 seconds with bastirite, alternate, nightsouls, dragon, binary or paragonic armor."));
	   super.addInformation(stack, worldIn, tooltip, flagIn);
	} 
	
	 
	 @Override
	 public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
		 

		 if((playerIn.getItemStackFromSlot(EquipmentSlotType.HEAD).getItem() == ItemInit.BASTIRITE_HELMET.get() && 
	    			playerIn.getItemStackFromSlot(EquipmentSlotType.CHEST).getItem() == ItemInit.BASTIRITE_CHESTPLATE.get() && 
	    			playerIn.getItemStackFromSlot(EquipmentSlotType.LEGS).getItem() == ItemInit.BASTIRITE_LEGGINGS.get() && 
	    			playerIn.getItemStackFromSlot(EquipmentSlotType.FEET).getItem() == ItemInit.BASTIRITE_BOOTS.get()) || 
				 
				 	(playerIn.getItemStackFromSlot(EquipmentSlotType.HEAD).getItem() == ItemInit.ALTERNATE_HELMET.get() && 
					playerIn.getItemStackFromSlot(EquipmentSlotType.CHEST).getItem() == ItemInit.ALTERNATE_CHESTPLATE.get() && 
					playerIn.getItemStackFromSlot(EquipmentSlotType.LEGS).getItem() == ItemInit.ALTERNATE_LEGGINGS.get() && 
					playerIn.getItemStackFromSlot(EquipmentSlotType.FEET).getItem() == ItemInit.ALTERNATE_BOOTS.get()) || 
	    				 			
					(playerIn.getItemStackFromSlot(EquipmentSlotType.HEAD).getItem() == ItemInit.NIGHTSOULS_HELMET.get() && 
					playerIn.getItemStackFromSlot(EquipmentSlotType.CHEST).getItem() == ItemInit.NIGHTSOULS_CHESTPLATE.get() && 
					playerIn.getItemStackFromSlot(EquipmentSlotType.LEGS).getItem() == ItemInit.NIGHTSOULS_LEGGINGS.get() && 
					playerIn.getItemStackFromSlot(EquipmentSlotType.FEET).getItem() == ItemInit.NIGHTSOULS_BOOTS.get()) || 
					
					(playerIn.getItemStackFromSlot(EquipmentSlotType.HEAD).getItem() == ItemInit.DRAGON_HELMET.get() && 
					playerIn.getItemStackFromSlot(EquipmentSlotType.CHEST).getItem() == ItemInit.DRAGON_CHESTPLATE.get() && 
					playerIn.getItemStackFromSlot(EquipmentSlotType.LEGS).getItem() == ItemInit.DRAGON_LEGGINGS.get() && 
					playerIn.getItemStackFromSlot(EquipmentSlotType.FEET).getItem() == ItemInit.DRAGON_BOOTS.get()) || 
					
					(playerIn.getItemStackFromSlot(EquipmentSlotType.HEAD).getItem() == ItemInit.BINARY_HELMET.get() && 
	    			playerIn.getItemStackFromSlot(EquipmentSlotType.CHEST).getItem() == ItemInit.BINARY_CHESTPLATE.get() && 
	    			playerIn.getItemStackFromSlot(EquipmentSlotType.LEGS).getItem() == ItemInit.BINARY_LEGGINGS.get() && 
	    			playerIn.getItemStackFromSlot(EquipmentSlotType.FEET).getItem() == ItemInit.BINARY_BOOTS.get()) ||
			
			       (playerIn.getItemStackFromSlot(EquipmentSlotType.FEET).getItem() == ItemInit.PARAGONIC_NIGHTSOULS_BOOTS.get()))
		 {
			 playerIn.getCooldownTracker().setCooldown(this, 60);
		 }
		 else
		 {
			 playerIn.getCooldownTracker().setCooldown(this, 100);
		 }
		    	    	 
		 int distance = 7;
		 
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
        		 i = 7;
        	 }
         }

		 playerIn.setPositionAndUpdate(playerX + distance*f2*f3, newPlayerY, playerZ + distance*f1*f3);
	     playerIn.setSprinting(true);
 	     worldIn.playSound(playerIn, playerIn.getPosition(), SoundInit.BLINK.get(), SoundCategory.MASTER, 1.0F, 1.0F);
	    
	    
	    return super.onItemRightClick(worldIn, playerIn, handIn);
	    
	  }

}
