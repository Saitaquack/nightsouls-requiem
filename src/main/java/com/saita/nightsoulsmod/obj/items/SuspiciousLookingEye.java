package com.saita.nightsoulsmod.obj.items;

import java.util.List;
import java.util.Random;

import com.saita.nightsoulsmod.entities.entity.EyeOfCthulhuEntity;
import com.saita.nightsoulsmod.init.NightSoulsEntityTypes;
import com.saita.nightsoulsmod.init.SoundInit;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Rarity;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.Difficulty;
import net.minecraft.world.World;


public class SuspiciousLookingEye extends Item {

	public SuspiciousLookingEye(Properties properties) {
		super(properties);

	}
	
	@Override
	public Rarity getRarity(ItemStack stack) {

		return Rarity.UNCOMMON;
	}
	
	@Override
    public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn)
    {

		tooltip.set(0, new StringTextComponent("§4"+tooltip.get(0).getString()+"§r"));
		tooltip.add(new StringTextComponent("§7Summons Eye of Cthulhu."));
	    
		super.addInformation(stack, worldIn, tooltip, flagIn);
    }  
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
		
		if(worldIn.getDifficulty() != Difficulty.PEACEFUL)
		{
		
			ItemStack itemstack = playerIn.getHeldItem(handIn);
			itemstack.shrink(1);	
			playerIn.getCooldownTracker().setCooldown(this, 600);
			
			worldIn.playSound(playerIn, playerIn.getPosition(), SoundInit.EOC_BOSS.get(), SoundCategory.RECORDS, 1.0F, 1.0F);
	    	worldIn.playSound(playerIn, playerIn.getPosition(), SoundInit.CTHULHU_SCREAM.get(), SoundCategory.MASTER, 1.0F, 1.0F);
	    	
	    	
	    	 if(worldIn.isRemote)
	    	 {
	    		 playerIn.sendMessage(new TranslationTextComponent("§4You feel an evil presence watching you..."), null);
	    	 }
	    	
	    	Random rand = new Random();
	    	
	    	int randX = rand.nextInt(15);
	    	int randZ = rand.nextInt(15);
	    	boolean negX = random.nextBoolean();
	    	boolean negZ = random.nextBoolean();
	    	
	    	if(negX)
	    	{
	    		randX = -randX;
	    	}
	    	if(negZ)
	    	{
	    		randZ = -randZ;
	    	}
	    	
	    	EyeOfCthulhuEntity eoc = new EyeOfCthulhuEntity(NightSoulsEntityTypes.EYE_OF_CTHULHU.get(), worldIn);	
			eoc.setPositionAndUpdate(playerIn.getPosX() + randX, playerIn.getPosY() + 15, playerIn.getPosZ() + randZ);
			worldIn.addEntity(eoc);
		}
		else
		{
			if(worldIn.isRemote)
			{
				playerIn.sendMessage(new TranslationTextComponent("§f"+playerIn.getName().getString()+", you can't summon the Eye of Cthulhu in peaceful mode."), null);
	    	}
		}

		
		return super.onItemRightClick(worldIn, playerIn, handIn);
	}

}
