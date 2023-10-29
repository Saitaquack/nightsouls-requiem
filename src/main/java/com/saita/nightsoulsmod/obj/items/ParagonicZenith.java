package com.saita.nightsoulsmod.obj.items;

import java.util.List;

import com.saita.nightsoulsmod.entities.entity.projectiles.ParagonicProjEntity;
import com.saita.nightsoulsmod.init.SoundInit;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Rarity;
import net.minecraft.item.SwordItem;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;

public class ParagonicZenith extends SwordItem {

	public ParagonicZenith(IItemTier tier, int attackDamageIn, float attackSpeedIn, Properties builder) {
		super(tier, attackDamageIn, attackSpeedIn, builder);

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
	
	tooltip.add(new StringTextComponent("§5Do NOT disappoint us, Warrior."));
	tooltip.set(0, new StringTextComponent("§5"+tooltip.get(0).getString()+"§r"));			
	super.addInformation(stack, worldIn, tooltip, flagIn);
	
    }
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
		
		ItemStack stack = playerIn.getHeldItem(handIn);
		
		stack.damageItem(1, playerIn, null);
		playerIn.getCooldownTracker().setCooldown(this, 20);
		
		ParagonicProjEntity proj = new ParagonicProjEntity(playerIn, worldIn);	
	    proj.setDirectionAndMovement(playerIn, playerIn.rotationPitch, playerIn.rotationYaw, 0.0F, 3.5F, 0.0F);
		worldIn.addEntity(proj);
		
		playerIn.playSound(SoundInit.HELLFIRE_EMPEROR_TRIDENT.get(), 1.0F, 1.0F);
		playerIn.playSound(SoundInit.GALACTIC_SLAYER.get(), 1.0F, 1.0F);
		playerIn.playSound(SoundInit.DIVINE_SANCTION.get(), 1.0F, 1.0F);
		playerIn.playSound(SoundInit.JAVA_FURY.get(), 1.0F, 1.0F);

		return super.onItemRightClick(worldIn, playerIn, handIn);
	}
	
	@Override
	public boolean hitEntity(ItemStack stack, LivingEntity target, LivingEntity attacker) {
		
		Vector3d look = attacker.getLookVec().normalize();  
		double knockback = 0.5;
		target.addVelocity(look.x*knockback, look.y*knockback, look.z*knockback);
		
		target.playSound(SoundInit.HELLFIRE_EMPEROR_TRIDENT.get(), 1.0F, 1.0F);
		target.playSound(SoundInit.GALACTIC_SLAYER.get(), 1.0F, 1.0F);
		target.playSound(SoundInit.DIVINE_SANCTION.get(), 1.0F, 1.0F);
		target.playSound(SoundInit.JAVA_FURY.get(), 1.0F, 1.0F);

		
		int jr = random.nextInt(9);
		int amplifier = random.nextInt(2);	
		int ds = random.nextInt(7);
		
		if(ds == 0)
		{
	    	attacker.addPotionEffect(new EffectInstance(Effects.REGENERATION, 160, 1));
	    	attacker.addPotionEffect(new EffectInstance(Effects.STRENGTH, 160, 2));
		}
		
		switch(jr)
		{
		case 0:
			attacker.addPotionEffect(new EffectInstance(Effects.SPEED, 160, amplifier));
		break;
		case 1:
			attacker.addPotionEffect(new EffectInstance(Effects.HASTE, 160, amplifier));
		break;
		case 2:
			attacker.addPotionEffect(new EffectInstance(Effects.STRENGTH, 160, amplifier));
		break;
		case 3:
			attacker.addPotionEffect(new EffectInstance(Effects.JUMP_BOOST, 160, amplifier));
		break;
		case 4:
			attacker.addPotionEffect(new EffectInstance(Effects.REGENERATION, 160, amplifier));
		break;
		case 5:
			attacker.addPotionEffect(new EffectInstance(Effects.RESISTANCE, 160, amplifier));
		break;
		case 6:
			attacker.addPotionEffect(new EffectInstance(Effects.FIRE_RESISTANCE, 160, 0));
		break;
		case 7:
			attacker.addPotionEffect(new EffectInstance(Effects.HEALTH_BOOST, 160, amplifier));
		break;
		case 8:
			attacker.addPotionEffect(new EffectInstance(Effects.ABSORPTION, 160, amplifier));
		break;
		}
		
		return super.hitEntity(stack, target, attacker);
	}

}
