package com.saita.nightsoulsmod.obj.items;

import java.util.List;
import java.util.Random;

import com.saita.nightsoulsmod.entities.entity.RetinazerEntity;
import com.saita.nightsoulsmod.entities.entity.SpazmatismEntity;
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


public class MechanicalEye extends Item {

	public MechanicalEye(Properties properties) {
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
		tooltip.add(new StringTextComponent("§7Summons The Twins."));
	    
		super.addInformation(stack, worldIn, tooltip, flagIn);
    }  
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
		
	
		if(worldIn.getDayTime() >= RequiemKey.requiemConstant)
		{	
			if(worldIn.getDifficulty() != Difficulty.PEACEFUL)
			{
			
				ItemStack itemstack = playerIn.getHeldItem(handIn);
				itemstack.shrink(1);	
				playerIn.getCooldownTracker().setCooldown(this, 600);
				
				worldIn.playSound(playerIn, playerIn.getPosition(), SoundInit.TWINS_BOSS.get(), SoundCategory.RECORDS, 1.0F, 1.0F);
		    	worldIn.playSound(playerIn, playerIn.getPosition(), SoundInit.CTHULHU_SCREAM.get(), SoundCategory.MASTER, 1.0F, 1.0F);
		    	
		    	
		    	 if(worldIn.isRemote)
		    	 {
		    		 playerIn.sendMessage(new TranslationTextComponent("§4This is honestly a terrible idea..."), null);
		    	 }
		    	
		    	Random rand = new Random();
		    	
		    	int randX1 = rand.nextInt(15);
		    	int randZ1 = rand.nextInt(15);
		    	int randX2 = rand.nextInt(15);
		    	int randZ2 = rand.nextInt(15);
		    	boolean negX1 = random.nextBoolean();
		    	boolean negZ1 = random.nextBoolean();
		    	boolean negX2 = random.nextBoolean();
		    	boolean negZ2 = random.nextBoolean();
		    	
		    	if(negX1)
		    	{
		    		randX1 = -randX1;
		    	}
		    	if(negZ1)
		    	{
		    		randZ1 = -randZ1;
		    	}
		    	if(negX2)
		    	{
		    		randX2 = -randX2;
		    	}
		    	if(negZ2)
		    	{
		    		randZ2 = -randZ2;
		    	}
		    	
		    	SpazmatismEntity spazmatism = new SpazmatismEntity(NightSoulsEntityTypes.SPAZMATISM.get(), worldIn);	
		    	RetinazerEntity retinazer = new RetinazerEntity(NightSoulsEntityTypes.RETINAZER.get(), worldIn);
		    	
		    	spazmatism.setPositionAndUpdate(playerIn.getPosX() + randX1, playerIn.getPosY() + 15, playerIn.getPosZ() + randZ1);
		    	retinazer.setPositionAndUpdate(playerIn.getPosX() + randX2, playerIn.getPosY() + 15, playerIn.getPosZ() + randZ2);
		    	
				worldIn.addEntity(spazmatism);
				worldIn.addEntity(retinazer);
			}
			else
			{
				if(worldIn.isRemote)
				{
					playerIn.sendMessage(new TranslationTextComponent("§f"+playerIn.getName().getString()+", you can't summon the Twins in peaceful mode."), null);
		    	}
			}
		
		}
		else
		{
			 if(worldIn.isRemote)
	    	 {
				 playerIn.sendMessage(new TranslationTextComponent("§f"+playerIn.getName().getString()+", you can only summon the Twins in a Requiem World"), null);
	    	 }
		}

		
		return super.onItemRightClick(worldIn, playerIn, handIn);
	}

}
