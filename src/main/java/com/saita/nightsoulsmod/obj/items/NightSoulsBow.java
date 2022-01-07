package com.saita.nightsoulsmod.obj.items;

import java.util.List;
import java.util.function.Predicate;

import com.saita.nightsoulsmod.init.ItemInit;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.enchantment.IVanishable;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.item.ArrowItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.ShootableItem;
import net.minecraft.item.UseAction;
import net.minecraft.stats.Stats;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;

public class NightSoulsBow extends ShootableItem implements IVanishable {
	   public NightSoulsBow(Item.Properties builder) {
		      super(builder);
	}

		   /**
		    * Called when the player stops using an Item (stops holding the right mouse button).
		    */
		   public void onPlayerStoppedUsing(ItemStack stack, World worldIn, LivingEntity entityLiving, int timeLeft) {
		      if (entityLiving instanceof PlayerEntity) {
		         PlayerEntity playerentity = (PlayerEntity)entityLiving;
		         boolean flag = playerentity.abilities.isCreativeMode || EnchantmentHelper.getEnchantmentLevel(Enchantments.INFINITY, stack) > 0;
		         ItemStack itemstack = playerentity.findAmmo(stack);

		         int i = this.getUseDuration(stack) - timeLeft;
		         i = net.minecraftforge.event.ForgeEventFactory.onArrowLoose(stack, worldIn, playerentity, i, !itemstack.isEmpty() || flag);
		         if (i < 0) return;

		         if (!itemstack.isEmpty() || flag) {
		            if (itemstack.isEmpty()) {
		               itemstack = new ItemStack(Items.ARROW);
		            }

		            float f = getArrowVelocity(i);
		            if (!((double)f < 0.1D)) {
		               boolean flag1 = playerentity.abilities.isCreativeMode || (itemstack.getItem() instanceof ArrowItem && ((ArrowItem)itemstack.getItem()).isInfinite(itemstack, stack, playerentity));
		               if (!worldIn.isRemote) {
		                  ArrowItem arrowitem = (ArrowItem)(itemstack.getItem() instanceof ArrowItem ? itemstack.getItem() : Items.ARROW);
		                  AbstractArrowEntity abstractarrowentity = arrowitem.createArrow(worldIn, itemstack, playerentity);
		                  abstractarrowentity = customArrow(abstractarrowentity);
		                  abstractarrowentity.setDirectionAndMovement(playerentity, playerentity.rotationPitch, playerentity.rotationYaw, 0.0F, f * 3.0F, 1.0F);
		                  
		                  abstractarrowentity.setDamage(6.0D); //Raw Damage Here
		                  if (f == 1.0F) {
		                     abstractarrowentity.setIsCritical(true);
		                  }

		                  int j = EnchantmentHelper.getEnchantmentLevel(Enchantments.POWER, stack);
		                  if (j > 0) {
		                     abstractarrowentity.setDamage(abstractarrowentity.getDamage() + (double)j * 0.75D + 0.5D); //Power Damage Here
		                  }

		                  int k = EnchantmentHelper.getEnchantmentLevel(Enchantments.PUNCH, stack);
		                  if (k > 0) {
		                     abstractarrowentity.setKnockbackStrength(k + 1); //Knockback strength
		                  }

		                  if (EnchantmentHelper.getEnchantmentLevel(Enchantments.FLAME, stack) > 0) {
		                     abstractarrowentity.setFire(100);
		                  }

		                  stack.damageItem(1, playerentity, (player) -> {
		                     player.sendBreakAnimation(playerentity.getActiveHand());
		                  });
		                  if (flag1 || playerentity.abilities.isCreativeMode && (itemstack.getItem() == Items.SPECTRAL_ARROW || itemstack.getItem() == Items.TIPPED_ARROW)) {
		                     abstractarrowentity.pickupStatus = AbstractArrowEntity.PickupStatus.CREATIVE_ONLY;
		                  }

		                  worldIn.addEntity(abstractarrowentity);
		               }

		               worldIn.playSound((PlayerEntity)null, playerentity.getPosX(), playerentity.getPosY(), playerentity.getPosZ(), SoundEvents.ENTITY_ARROW_SHOOT, SoundCategory.PLAYERS, 1.0F, 1.0F / (random.nextFloat() * 0.4F + 1.2F) + f * 0.5F);
		               if (!flag1 && !playerentity.abilities.isCreativeMode) {
		                  itemstack.shrink(1);
		                  if (itemstack.isEmpty()) {
		                     playerentity.inventory.deleteStack(itemstack);
		                  }
		               }

		               playerentity.addStat(Stats.ITEM_USED.get(this));
		            }
		         }
		      }
		   }

		   /**
		    * Gets the velocity of the arrow entity from the bow's charge
		    */
		   public static float getArrowVelocity(int charge) {
		      float f = (float)charge / 16.0F;  //Speed here. Default Bow is 20.
		      f = (f * f + f * 2.0F) / 3.0F;
		      if (f > 1.0F) {
		         f = 1.0F;
		      }

		      return f;
		   }

		   /**
		    * How long it takes to use or consume an item
		    */
		   public int getUseDuration(ItemStack stack) {
		      return 72000;
		   }

		   /**
		    * returns the action that specifies what animation to play when the items is being used
		    */
		   public UseAction getUseAction(ItemStack stack) {
		      return UseAction.BOW;
		   }

		   /**
		    * Called to trigger the item's "innate" right click behavior. To handle when this item is used on a Block, see
		    * {@link #onItemUse}.
		    */
		   public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
		      ItemStack itemstack = playerIn.getHeldItem(handIn);
		      boolean flag = !playerIn.findAmmo(itemstack).isEmpty();

		      ActionResult<ItemStack> ret = net.minecraftforge.event.ForgeEventFactory.onArrowNock(itemstack, worldIn, playerIn, handIn, flag);
		      if (ret != null) return ret;

		      if (!playerIn.abilities.isCreativeMode && !flag) {
		         return ActionResult.resultFail(itemstack);
		      } else {
		         playerIn.setActiveHand(handIn);
		         return ActionResult.resultConsume(itemstack);
		      }
		   }

		   /**
		    * Get the predicate to match ammunition when searching the player's inventory, not their main/offhand
		    */
		   public Predicate<ItemStack> getInventoryAmmoPredicate() {
		      return ARROWS;
		   }

		   public AbstractArrowEntity customArrow(AbstractArrowEntity arrow) {
		      return arrow;
		   }

		   public int func_230305_d_() {
		      return 15;
		   }
		   
		   
		   /* Primary Stats */
		   
		   @Override
		   public boolean isEnchantable(ItemStack stack) {
			
			   return true;
		   }
		   

		   @Override
		   public boolean isRepairable(ItemStack stack) {
			    		
			   return true;
		   }
		   
		   @Override
			public boolean canApplyAtEnchantingTable(ItemStack stack, net.minecraft.enchantment.Enchantment enchantment ) {
				EnchantmentType type = enchantment.type;
		        return type == EnchantmentType.BOW || type == EnchantmentType.BREAKABLE;
		    }
		    

		    @Override
		    public boolean isBookEnchantable(ItemStack stack, ItemStack book) {
		      if (EnchantmentHelper.getEnchantments(book).containsKey(Enchantments.MENDING) || 
		    	  EnchantmentHelper.getEnchantments(book).containsKey(Enchantments.POWER) ||
		    	  EnchantmentHelper.getEnchantments(book).containsKey(Enchantments.PUNCH) ||
		    	  EnchantmentHelper.getEnchantments(book).containsKey(Enchantments.FLAME) ||
		    	  EnchantmentHelper.getEnchantments(book).containsKey(Enchantments.INFINITY) ||
		    	  EnchantmentHelper.getEnchantments(book).containsKey(Enchantments.UNBREAKING) ||
		          EnchantmentHelper.getEnchantments(book).containsKey(Enchantments.VANISHING_CURSE)) {
		        return true;
		      }
		      return super.isBookEnchantable(stack, book);
		    }

		   /* Bow repair Item */
		   @Override
		    public boolean getIsRepairable(ItemStack toRepair, ItemStack repair) {
			    			
			   return repair.getItem() == ItemInit.NIGHTSOULS_ESSENCE.get();		   
		   }
		   
		   /* Bow Enchantability */
		   
		   @Override
		   public int getItemEnchantability() {
			    		
			   return 33;
		   }	
		   
		   @Override
		   public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn)
		   {
			
				tooltip.set(0, new StringTextComponent("§5"+tooltip.get(0).getString()+"§r"));			
				super.addInformation(stack, worldIn, tooltip, flagIn);
			
		   }
		   		   
}