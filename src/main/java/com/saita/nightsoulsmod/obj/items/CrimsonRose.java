package com.saita.nightsoulsmod.obj.items;

import java.util.List;

import com.saita.nightsoulsmod.entities.entity.KingCrimsonEntity;
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


public class CrimsonRose extends Item {

	public CrimsonRose(Properties properties) {
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
		tooltip.add(new StringTextComponent("§7Summons King Crimson."));
	    
		super.addInformation(stack, worldIn, tooltip, flagIn);
    }  
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
		
		if(worldIn.getDifficulty() != Difficulty.PEACEFUL)
		{
		
			ItemStack itemstack = playerIn.getHeldItem(handIn);
			itemstack.shrink(1);	
			playerIn.getCooldownTracker().setCooldown(this, 1200);
			
	    	worldIn.playSound(playerIn, playerIn.getPosition(), SoundInit.KC_BOSS.get(), SoundCategory.RECORDS, 1.0F, 1.0F);
	    	worldIn.playSound(playerIn, playerIn.getPosition(), SoundInit.KING_CRIMSON_AMBIENT.get(), SoundCategory.MASTER, 1.0F, 1.0F);
	    	
	    	if(worldIn.isRemote)
			{
	    		 playerIn.sendMessage(new TranslationTextComponent("§4Anyone who opposes me will be eliminated."), null);
	    	}
	    	
	    	KingCrimsonEntity kc = new KingCrimsonEntity(NightSoulsEntityTypes.KING_CRIMSON.get(), worldIn);	
			kc.setPositionAndUpdate(playerIn.getPosX(), playerIn.getPosY() + 2, playerIn.getPosZ());
			worldIn.addEntity(kc);
		}
		else
		{
			if(worldIn.isRemote)
			{
				playerIn.sendMessage(new TranslationTextComponent("§f"+playerIn.getName().getString()+", you can't summon King Crimson in peaceful mode."), null);
	    	}
		}

		
		return super.onItemRightClick(worldIn, playerIn, handIn);
	}

}
