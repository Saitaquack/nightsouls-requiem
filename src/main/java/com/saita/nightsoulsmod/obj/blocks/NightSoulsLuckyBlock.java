package com.saita.nightsoulsmod.obj.blocks;

import com.saita.nightsoulsmod.init.BlockInit;
import com.saita.nightsoulsmod.init.ItemInit;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.boss.WitherEntity;
import net.minecraft.entity.merchant.villager.VillagerEntity;
import net.minecraft.entity.monster.CreeperEntity;
import net.minecraft.entity.monster.RavagerEntity;
import net.minecraft.entity.monster.VexEntity;
import net.minecraft.entity.passive.WolfEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;

public class NightSoulsLuckyBlock extends Block {

	public NightSoulsLuckyBlock(Properties properties) {
		super(properties);

	}
	
	@Override
	public void harvestBlock(World worldIn, PlayerEntity player, BlockPos pos, BlockState state, TileEntity te,
			ItemStack stack) {
		
		int randomPrice = RANDOM.nextInt(766);
		
		if(randomPrice < 30)
		{
			int randomBlock = RANDOM.nextInt(5);
			switch(randomBlock)
			{
			 case 0:
				worldIn.setBlockState(pos, BlockInit.MIIZEALITE_BLOCK.get().getDefaultState());
			 break;
			 case 1:
				worldIn.setBlockState(pos, BlockInit.SAITASTONE_BLOCK.get().getDefaultState());
			 break;
			 case 2:
				worldIn.setBlockState(pos, BlockInit.CRANITE_BLOCK.get().getDefaultState());
			 break;
			 case 3:
				worldIn.setBlockState(pos, BlockInit.BASTIRITE_BLOCK.get().getDefaultState());
			 break;
			 case 4:
				worldIn.setBlockState(pos, BlockInit.NIGHTSOULS_EMERALD_BLOCK.get().getDefaultState());
			 break;
			}
		}
		else if(randomPrice < 40)
		{
			worldIn.setBlockState(pos, Blocks.COAL_BLOCK.getDefaultState());
			worldIn.setBlockState(pos.add(0, 1, 0), Blocks.IRON_BLOCK.getDefaultState());
			worldIn.setBlockState(pos.add(0, 2, 0), Blocks.GOLD_BLOCK.getDefaultState());
			worldIn.setBlockState(pos.add(0, 3, 0), Blocks.DIAMOND_BLOCK.getDefaultState());
			worldIn.setBlockState(pos.add(0, 4, 0), Blocks.EMERALD_BLOCK.getDefaultState());
			worldIn.setBlockState(pos.add(0, 5, 0), BlockInit.MIIZEALITE_BLOCK.get().getDefaultState());
			worldIn.setBlockState(pos.add(0, 6, 0), BlockInit.SAITASTONE_BLOCK.get().getDefaultState());
			worldIn.setBlockState(pos.add(0, 7, 0), BlockInit.CRANITE_BLOCK.get().getDefaultState());
			worldIn.setBlockState(pos.add(0, 8, 0), BlockInit.BASTIRITE_BLOCK.get().getDefaultState());	
		}
		else if(randomPrice < 90)
		{
			int randomIngots = RANDOM.nextInt(4);
			switch(randomIngots)
			{
			 case 0:
				 ItemStack saitastoneIngots = new ItemStack(ItemInit.SAITASTONE_INGOT.get(), 3 + RANDOM.nextInt(5));
				 spawnAsEntity(worldIn, pos, saitastoneIngots);
			 break;
			 case 1:
				 ItemStack miizealiteIngots = new ItemStack(ItemInit.MIIZEALITE_INGOT.get(), 3 + RANDOM.nextInt(5));
				 spawnAsEntity(worldIn, pos, miizealiteIngots);
			 break;
			 case 2:
				 ItemStack craniteIngots = new ItemStack(ItemInit.CRANITE_INGOT.get(), 3 + RANDOM.nextInt(5));
				 spawnAsEntity(worldIn, pos, craniteIngots);
			 break;
			 case 3:
				 ItemStack bastiriteIngots = new ItemStack(ItemInit.BASTIRITE_INGOT.get(), 3 + RANDOM.nextInt(5));
				 spawnAsEntity(worldIn, pos, bastiriteIngots);
			 break;
			}	
		}
		else if(randomPrice < 100)
		{
			player.sendMessage(new TranslationTextComponent(":)"), null);
			player.setHealth(1.0F);
		}
		else if(randomPrice < 110)
		{
			ItemStack nightSoulsEmerald = new ItemStack(ItemInit.NIGHTSOULS_EMERALD.get(), RANDOM.nextInt(11) + 6);
			spawnAsEntity(worldIn, pos, nightSoulsEmerald);
			 
		}
		else if(randomPrice < 130)
		{
	        player.sendMessage(new TranslationTextComponent("Get into water before you burn to death !"), null);
	        player.setFire(60);

		}
		else if(randomPrice < 150)
		{
	        player.sendMessage(new TranslationTextComponent("Well that's annoying."), null);
			worldIn.setBlockState(pos, Blocks.OBSIDIAN.getDefaultState());
		}
		else if(randomPrice < 170)
		{
	        player.sendMessage(new TranslationTextComponent("Ughhh you smell so bad. Wash yourself !"), null);
	        ItemStack waterBucket = new ItemStack(Items.WATER_BUCKET, 1);
	        ItemStack sponge = new ItemStack(Items.SPONGE, 1);
			spawnAsEntity(worldIn, pos, waterBucket);
			spawnAsEntity(worldIn, pos, sponge);


		}
		else if(randomPrice < 180)
		{
			boolean isStarItem = RANDOM.nextBoolean();
			if(isStarItem)
			{
				 ItemStack superStar = new ItemStack(ItemInit.SUPER_STAR.get(), 1);
				 spawnAsEntity(worldIn, pos, superStar);

			}
			else
			{
				ItemStack moltenCore = new ItemStack(ItemInit.MOLTEN_CORE.get(), 1);
				spawnAsEntity(worldIn, pos, moltenCore);
			}
			
		}
		else if(randomPrice < 195)
		{
	        player.sendMessage(new TranslationTextComponent("Zzzzzzzzzzzzzz..."), null);
	        player.addPotionEffect(new EffectInstance(Effects.SLOWNESS, 140, 7));
	        player.addPotionEffect(new EffectInstance(Effects.MINING_FATIGUE, 140, 9));
	        player.addPotionEffect(new EffectInstance(Effects.BLINDNESS, 140, 0));
	        player.addPotionEffect(new EffectInstance(Effects.NIGHT_VISION, 140, 0));

		}
		else if(randomPrice < 208)
		{
			int randomOwItem = RANDOM.nextInt(7);
			switch(randomOwItem)
			{
			case 0:			
			   ItemStack wraith = new ItemStack(ItemInit.WRAITH_FORM.get(), 1);
			   spawnAsEntity(worldIn, pos, wraith);
			break;
			case 1:			
				ItemStack breather = new ItemStack(ItemInit.TAKE_A_BREATHER.get(), 1);
				spawnAsEntity(worldIn, pos, breather);
			break;
			case 2:			
				ItemStack amp = new ItemStack(ItemInit.AMP_IT_UP.get(), 1);
				spawnAsEntity(worldIn, pos, amp);
			break;		
			case 3:			
				ItemStack fade = new ItemStack(ItemInit.FADE.get(), 1);
				spawnAsEntity(worldIn, pos, fade);
			break;	
			case 4:			
				ItemStack shield = new ItemStack(ItemInit.ADAPTIVE_SHIELD.get(), 1);
				spawnAsEntity(worldIn, pos, shield);
			break;	
			case 5:			
				ItemStack fortify = new ItemStack(ItemInit.FORTIFY.get(), 1);
				spawnAsEntity(worldIn, pos, fortify);
			break;	
			case 6:			
				ItemStack blink = new ItemStack(ItemInit.BLINK.get(), 1);
				spawnAsEntity(worldIn, pos, blink);
			break;	
			}
		
		}
		else if(randomPrice < 230)
		{
			ItemStack nightSoulPick = new ItemStack(ItemInit.NIGHT_SOUL_PICKAXE.get(), 1);
			spawnAsEntity(worldIn, pos, nightSoulPick);
		}
		else if(randomPrice < 240)
		{
			ItemStack flower = new ItemStack(Items.POPPY, 1);
			spawnAsEntity(worldIn, pos, flower);
	 	    player.sendMessage(new TranslationTextComponent("§d*Flush*. I- I like you a lot, yo- you know..."), null);
		}
		else if(randomPrice < 260)
		{
			ItemStack luckyBlock = new ItemStack(ItemInit.NIGHTSOULS_LUCKY_BLOCK.get(), 1);
			spawnAsEntity(worldIn, pos, luckyBlock);
	 	    player.sendMessage(new TranslationTextComponent("Wow that was garbage. Try again."), null);

		}
		else if(randomPrice < 275)
		{
			worldIn.setBlockState(pos, Blocks.STONE.getDefaultState());
			worldIn.setBlockState(pos.add(0, 1, 0), Blocks.STONE.getDefaultState());
			worldIn.setBlockState(pos.add(0, 2, 0), Blocks.STONE.getDefaultState());			
		}
		else if(randomPrice < 290)
		{
			ItemStack crystalSeeds = new ItemStack(ItemInit.CRYSTAL_SEEDS.get(), 2);
			spawnAsEntity(worldIn, pos, crystalSeeds);
		}
		else if(randomPrice < 310)
		{
			ItemStack healingPotions = new ItemStack(ItemInit.INSTANT_HEALING_POTION.get(), 16);
			spawnAsEntity(worldIn, pos, healingPotions);
		}
		else if(randomPrice < 340)
		{
           player.sendMessage(new TranslationTextComponent("You got jebaited :) Better luck next time."), null);
		}
		else if(randomPrice < 350)
		{
			ItemStack salut = new ItemStack(ItemInit.FANTA_GLASSES.get(), 1);
			spawnAsEntity(worldIn, pos, salut);
		}
		else if(randomPrice < 360)
		{
			worldIn.setBlockState(pos, BlockInit.NIGHTSOULS_LUCKY_BLOCK.get().getDefaultState());
			worldIn.setBlockState(pos.add(1, 0, 0), BlockInit.NIGHTSOULS_LUCKY_BLOCK.get().getDefaultState());
			worldIn.setBlockState(pos.add(0, 0, 1), BlockInit.NIGHTSOULS_LUCKY_BLOCK.get().getDefaultState());
			worldIn.setBlockState(pos.add(1, 0, 1), BlockInit.NIGHTSOULS_LUCKY_BLOCK.get().getDefaultState());
			worldIn.setBlockState(pos.add(-1, 0, 0), BlockInit.NIGHTSOULS_LUCKY_BLOCK.get().getDefaultState());
			worldIn.setBlockState(pos.add(0, 0, -1), BlockInit.NIGHTSOULS_LUCKY_BLOCK.get().getDefaultState());
			worldIn.setBlockState(pos.add(-1, 0, -1), BlockInit.NIGHTSOULS_LUCKY_BLOCK.get().getDefaultState());
			worldIn.setBlockState(pos.add(-1, 0, 1), BlockInit.NIGHTSOULS_LUCKY_BLOCK.get().getDefaultState());
			worldIn.setBlockState(pos.add(1, 0, -1), BlockInit.NIGHTSOULS_LUCKY_BLOCK.get().getDefaultState());
		}
		else if(randomPrice < 370)
		{
			ItemStack craniteWaraxe = new ItemStack(ItemInit.CRANITE_WARAXE.get(), 1);
			spawnAsEntity(worldIn, pos, craniteWaraxe);
		}
		else if(randomPrice < 380)
		{
			ItemStack dirt = new ItemStack(Items.DIRT, 1);
			spawnAsEntity(worldIn, pos, dirt);
		}
		
		else if(randomPrice < 390)
		{
			worldIn.setBlockState(pos, Blocks.REDSTONE_BLOCK.getDefaultState());
			worldIn.setBlockState(pos.add(1, 0, 0), Blocks.TNT.getDefaultState());
			worldIn.setBlockState(pos.add(0, 0, 1), Blocks.TNT.getDefaultState());
			worldIn.setBlockState(pos.add(1, 0, 1), Blocks.TNT.getDefaultState());
			worldIn.setBlockState(pos.add(-1, 0, 0), Blocks.TNT.getDefaultState());
			worldIn.setBlockState(pos.add(0, 0, -1), Blocks.TNT.getDefaultState());
			worldIn.setBlockState(pos.add(-1, 0, -1), Blocks.TNT.getDefaultState());
			worldIn.setBlockState(pos.add(-1, 0, 1), Blocks.TNT.getDefaultState());
			worldIn.setBlockState(pos.add(1, 0, -1), Blocks.TNT.getDefaultState());
			worldIn.setBlockState(pos.add(0, 1, 0), Blocks.TNT.getDefaultState());
			worldIn.setBlockState(pos.add(1, 1, 0), Blocks.TNT.getDefaultState());
			worldIn.setBlockState(pos.add(0, 1, 1), Blocks.TNT.getDefaultState());
			worldIn.setBlockState(pos.add(1, 1, 1), Blocks.TNT.getDefaultState());
			worldIn.setBlockState(pos.add(-1, 1, 0), Blocks.TNT.getDefaultState());
			worldIn.setBlockState(pos.add(0, 1, -1), Blocks.TNT.getDefaultState());
			worldIn.setBlockState(pos.add(-1, 1, -1), Blocks.TNT.getDefaultState());
			worldIn.setBlockState(pos.add(-1, 1, 1), Blocks.TNT.getDefaultState());
			worldIn.setBlockState(pos.add(1, 1, -1), Blocks.TNT.getDefaultState());
		}
		
		else if(randomPrice < 410)
		{
			worldIn.setBlockState(pos, Blocks.FIRE.getDefaultState());
			worldIn.setBlockState(pos.add(1, 0, 0), Blocks.FIRE.getDefaultState());
			worldIn.setBlockState(pos.add(0, 0, 1), Blocks.FIRE.getDefaultState());
			worldIn.setBlockState(pos.add(1, 0, 1), Blocks.FIRE.getDefaultState());
			worldIn.setBlockState(pos.add(-1, 0, 0), Blocks.FIRE.getDefaultState());
			worldIn.setBlockState(pos.add(0, 0, -1), Blocks.FIRE.getDefaultState());
			worldIn.setBlockState(pos.add(-1, 0, -1), Blocks.FIRE.getDefaultState());
			worldIn.setBlockState(pos.add(-1, 0, 1), Blocks.FIRE.getDefaultState());
			worldIn.setBlockState(pos.add(1, 0, -1), Blocks.FIRE.getDefaultState());
		}
		
		else if(randomPrice < 420)
		{
			worldIn.setBlockState(pos.add(0, -1, 0), Blocks.LAVA.getDefaultState());
			worldIn.setBlockState(pos.add(1, -1, 0), Blocks.LAVA.getDefaultState());
			worldIn.setBlockState(pos.add(0, -1, 1), Blocks.LAVA.getDefaultState());
			worldIn.setBlockState(pos.add(1, -1, 1), Blocks.LAVA.getDefaultState());
			worldIn.setBlockState(pos.add(-1, -1, 0), Blocks.LAVA.getDefaultState());
			worldIn.setBlockState(pos.add(0, -1, -1), Blocks.LAVA.getDefaultState());
			worldIn.setBlockState(pos.add(-1, -1, -1), Blocks.LAVA.getDefaultState());
			worldIn.setBlockState(pos.add(-1, -1, 1), Blocks.LAVA.getDefaultState());
			worldIn.setBlockState(pos.add(1, -1, -1), Blocks.LAVA.getDefaultState());
		}
		
		else if(randomPrice < 430)
		{
	         player.sendMessage(new TranslationTextComponent("You look wonderful today. Have a good day !"), null);
	         ItemStack diamond = new ItemStack(Items.DIAMOND, 1);
	         spawnAsEntity(worldIn, pos, diamond);

		}
		
		else if(randomPrice < 450)
		{
			CreeperEntity creeper = new CreeperEntity(EntityType.CREEPER, worldIn);
			creeper.setPositionAndUpdate(pos.getX(), pos.getY(), pos.getZ());
			worldIn.addEntity(creeper);

		}
		
		else if(randomPrice < 460)
		{
			CreeperEntity creeper1 = new CreeperEntity(EntityType.CREEPER, worldIn);
			CreeperEntity creeper2 = new CreeperEntity(EntityType.CREEPER, worldIn);
			CreeperEntity creeper3 = new CreeperEntity(EntityType.CREEPER, worldIn);
			CreeperEntity creeper4 = new CreeperEntity(EntityType.CREEPER, worldIn);
			CreeperEntity creeper5 = new CreeperEntity(EntityType.CREEPER, worldIn);
			creeper1.setPositionAndUpdate(pos.getX(), pos.getY(), pos.getZ());
			creeper2.setPositionAndUpdate(pos.getX(), pos.getY(), pos.getZ());
			creeper3.setPositionAndUpdate(pos.getX(), pos.getY(), pos.getZ());
			creeper4.setPositionAndUpdate(pos.getX(), pos.getY(), pos.getZ());
			creeper5.setPositionAndUpdate(pos.getX(), pos.getY(), pos.getZ());
			worldIn.addEntity(creeper1);
			worldIn.addEntity(creeper2);
			worldIn.addEntity(creeper3);
			worldIn.addEntity(creeper4);
			worldIn.addEntity(creeper5);

		}
		
		else if(randomPrice < 470)
		{
			ItemStack enderpearl = new ItemStack(Items.ENDER_PEARL, RANDOM.nextInt(7) + 2);
			spawnAsEntity(worldIn, pos, enderpearl);
		}
		
		else if(randomPrice < 485)
		{
			worldIn.setBlockState(pos, Blocks.COBBLESTONE.getDefaultState());
			worldIn.setBlockState(pos.add(1, 0, 0), Blocks.COBBLESTONE.getDefaultState());
			worldIn.setBlockState(pos.add(-1, 0, 0), Blocks.COBBLESTONE.getDefaultState());
			worldIn.setBlockState(pos.add(0, 1, 0), Blocks.COBBLESTONE.getDefaultState());
			worldIn.setBlockState(pos.add(0, 2, 0), Blocks.COBBLESTONE.getDefaultState());
			worldIn.setBlockState(pos.add(0, 3, 0), Blocks.COBWEB.getDefaultState());
		}
		else if(randomPrice < 500)
		{
			player.addPotionEffect(new EffectInstance(Effects.POISON, 600, 3));
			player.sendMessage(new TranslationTextComponent("This block was poisoned !"), null);
		}		
		else if(randomPrice < 510)
		{
		    worldIn.createExplosion(null, pos.getX(), pos.getY(), pos.getZ(), 4.0F, Explosion.Mode.BREAK);
		}
		else if(randomPrice < 530)
		{
			player.sendMessage(new TranslationTextComponent("Parce que les Bâtons de Berger sont mieux entre amis. Justin Bridoux, le vrai goût du partage."), null);
			ItemStack bridou = new ItemStack(ItemInit.JUSTIN_BRIDOU.get(), 32);
			spawnAsEntity(worldIn, pos, bridou);
		}
		else if(randomPrice < 540)
		{
		    ItemStack iron = new ItemStack(Items.IRON_INGOT, RANDOM.nextInt(11) + 10);
		    ItemStack gold = new ItemStack(Items.GOLD_INGOT, RANDOM.nextInt(10) + 6);
		    ItemStack diamond = new ItemStack(Items.DIAMOND, RANDOM.nextInt(7) + 3);
		    ItemStack emerald = new ItemStack(Items.EMERALD, RANDOM.nextInt(8) + 3);

		    spawnAsEntity(worldIn, pos, iron);
		    spawnAsEntity(worldIn, pos, gold);
		    spawnAsEntity(worldIn, pos, diamond);
		    spawnAsEntity(worldIn, pos, emerald);
		}
		else if(randomPrice < 550)
		{
			RavagerEntity ravager = new RavagerEntity(EntityType.RAVAGER, worldIn);
			ravager.setPositionAndUpdate(pos.getX(), pos.getY(), pos.getZ());
			worldIn.addEntity(ravager);
		}
		else if(randomPrice < 560)
		{
			VillagerEntity villager1 = new VillagerEntity(EntityType.VILLAGER, worldIn);
			VillagerEntity villager2 = new VillagerEntity(EntityType.VILLAGER, worldIn);
			VillagerEntity villager3 = new VillagerEntity(EntityType.VILLAGER, worldIn);
			VillagerEntity villager4 = new VillagerEntity(EntityType.VILLAGER, worldIn);
			VillagerEntity villager5 = new VillagerEntity(EntityType.VILLAGER, worldIn);
			villager1.setPositionAndUpdate(pos.getX(), pos.getY(), pos.getZ());
			villager2.setPositionAndUpdate(pos.getX(), pos.getY(), pos.getZ());
			villager3.setPositionAndUpdate(pos.getX(), pos.getY(), pos.getZ());
			villager4.setPositionAndUpdate(pos.getX(), pos.getY(), pos.getZ());
			villager5.setPositionAndUpdate(pos.getX(), pos.getY(), pos.getZ());
			worldIn.addEntity(villager1);
			worldIn.addEntity(villager2);
			worldIn.addEntity(villager3);
			worldIn.addEntity(villager4);
			worldIn.addEntity(villager5);
		}
		else if(randomPrice < 570)
		{
			VexEntity vex1 = new VexEntity(EntityType.VEX, worldIn);
			VexEntity vex2 = new VexEntity(EntityType.VEX, worldIn);
			VexEntity vex3 = new VexEntity(EntityType.VEX, worldIn);
			VexEntity vex4 = new VexEntity(EntityType.VEX, worldIn);
			VexEntity vex5 = new VexEntity(EntityType.VEX, worldIn);
			VexEntity vex6 = new VexEntity(EntityType.VEX, worldIn);
			VexEntity vex7 = new VexEntity(EntityType.VEX, worldIn);
			VexEntity vex8 = new VexEntity(EntityType.VEX, worldIn);
			vex1.setPositionAndUpdate(pos.getX(), pos.getY(), pos.getZ());
			vex2.setPositionAndUpdate(pos.getX(), pos.getY(), pos.getZ());
			vex3.setPositionAndUpdate(pos.getX(), pos.getY(), pos.getZ());
			vex4.setPositionAndUpdate(pos.getX(), pos.getY(), pos.getZ());
			vex5.setPositionAndUpdate(pos.getX(), pos.getY(), pos.getZ());
			vex6.setPositionAndUpdate(pos.getX(), pos.getY(), pos.getZ());
			vex7.setPositionAndUpdate(pos.getX(), pos.getY(), pos.getZ());
			vex8.setPositionAndUpdate(pos.getX(), pos.getY(), pos.getZ());
			worldIn.addEntity(vex1);
			worldIn.addEntity(vex2);
			worldIn.addEntity(vex3);
			worldIn.addEntity(vex4);
			worldIn.addEntity(vex5);	
			worldIn.addEntity(vex6);
			worldIn.addEntity(vex7);
			worldIn.addEntity(vex8);
		}
		
		else if(randomPrice < 590)
		{
			ItemStack bones = new ItemStack(Items.BONE, 12);
			spawnAsEntity(worldIn, pos, bones);
			
			WolfEntity wolf = new WolfEntity(EntityType.WOLF, worldIn);
			wolf.setPositionAndUpdate(pos.getX(), pos.getY(), pos.getZ());
			worldIn.addEntity(wolf);
		}
		
		else if(randomPrice < 600)
		{
			worldIn.setBlockState(pos.add(0, 0, 0), BlockInit.UNDERGROUND_HEART_CRYSTAL.get().getDefaultState());
			worldIn.setBlockState(pos.add(0, 1, 0), BlockInit.UNDERGROUND_HEART_CRYSTAL.get().getDefaultState());

		}		
		else if(randomPrice < 615)
		{
			worldIn.setBlockState(pos.add(1, 0, 0), Blocks.RED_CONCRETE.getDefaultState());
			worldIn.setBlockState(pos.add(-1, 0, 0), Blocks.RED_CONCRETE.getDefaultState());
			worldIn.setBlockState(pos.add(1, 1, 0), Blocks.RED_CONCRETE.getDefaultState());
			worldIn.setBlockState(pos.add(0, 1, 0), Blocks.RED_CONCRETE.getDefaultState());
			worldIn.setBlockState(pos.add(-1, 1, 0), Blocks.RED_CONCRETE.getDefaultState());
			worldIn.setBlockState(pos.add(-1, 2, 0), Blocks.RED_CONCRETE.getDefaultState());
			worldIn.setBlockState(pos.add(0, 2, 0), Blocks.RED_CONCRETE.getDefaultState());
			worldIn.setBlockState(pos.add(1, 2, 0), Blocks.RED_CONCRETE.getDefaultState());
			worldIn.setBlockState(pos.add(2, 2, 0), Blocks.RED_CONCRETE.getDefaultState());
			worldIn.setBlockState(pos.add(-1, 3, 0), Blocks.WHITE_CONCRETE.getDefaultState());
			worldIn.setBlockState(pos.add(0, 3, 0), Blocks.WHITE_CONCRETE.getDefaultState());
			worldIn.setBlockState(pos.add(1, 3, 0), Blocks.RED_CONCRETE.getDefaultState());
			worldIn.setBlockState(pos.add(2, 3, 0), Blocks.RED_CONCRETE.getDefaultState());
			worldIn.setBlockState(pos.add(-1, 4, 0), Blocks.RED_CONCRETE.getDefaultState());
			worldIn.setBlockState(pos.add(0, 4, 0), Blocks.RED_CONCRETE.getDefaultState());
			worldIn.setBlockState(pos.add(1, 4, 0), Blocks.RED_CONCRETE.getDefaultState());
		}	
		else if(randomPrice < 625)
		{
		    ItemStack teeth = new ItemStack(ItemInit.BAT_TOOTH.get(), 2);
		    ItemStack blood = new ItemStack(ItemInit.VILLAGER_BLOOD.get(), RANDOM.nextInt(7) + 2);

		    spawnAsEntity(worldIn, pos, teeth);
		    spawnAsEntity(worldIn, pos, blood);
		}
		else if(randomPrice < 639)
		{
			int randomDisc = RANDOM.nextInt(33) + 1;
			int randomDisc2 = RANDOM.nextInt(33) + 1;
			
		    ItemStack disc1 = new ItemStack(ItemInit.HOPES_AND_DREAMS_MUSIC_DISC.get());
		    ItemStack disc2 = new ItemStack(ItemInit.TOTO_AFRICA_MUSIC_DISC.get());
		    ItemStack disc3 = new ItemStack(ItemInit.KIRA_MUSIC_DISC.get());
		    ItemStack disc4 = new ItemStack(ItemInit.NOUNOURS_MUSIC_DISC.get());
		    ItemStack disc5 = new ItemStack(ItemInit.AWAKEN_MUSIC_DISC.get());
		    ItemStack disc6 = new ItemStack(ItemInit.INFOGRAMES_MUSIC_DISC.get());
		    ItemStack disc7 = new ItemStack(ItemInit.PYRO_BARBARIAN_MUSIC_DISC.get());
		    ItemStack disc8 = new ItemStack(ItemInit.FANTA_MUSIC_DISC.get());
		    ItemStack disc9 = new ItemStack(ItemInit.BOWSER_MUSIC_DISC.get());
		    ItemStack disc10 = new ItemStack(ItemInit.OBSERVATORY_MUSIC_DISC.get());
		    ItemStack disc11 = new ItemStack(ItemInit.STARSHIP_MUSIC_DISC.get());
		    ItemStack disc12 = new ItemStack(ItemInit.UNDYNE_MUSIC_DISC.get());
		    ItemStack disc13 = new ItemStack(ItemInit.ASGORE_MUSIC_DISC.get());
		    ItemStack disc14 = new ItemStack(ItemInit.MAMA_LAUDA_MUSIC_DISC.get());
		    ItemStack disc15 = new ItemStack(ItemInit.FANTA_BOB_SHOW_MUSIC_DISC.get());
		    ItemStack disc16 = new ItemStack(ItemInit.MICKIE_KRAUSE_MUSIC_DISC.get());
		    ItemStack disc17 = new ItemStack(ItemInit.JEVIL_MUSIC_DISC.get());
		    ItemStack disc18 = new ItemStack(ItemInit.BURNING_COLOSSEUM_MUSIC_DISC.get());
		    ItemStack disc19 = new ItemStack(ItemInit.AVALON_MUSIC_DISC.get());
		    ItemStack disc20 = new ItemStack(ItemInit.REDACTED_MUSIC_DISC.get());
		    ItemStack disc21 = new ItemStack(ItemInit.GIORNO_MUSIC_DISC.get());
		    ItemStack disc22 = new ItemStack(ItemInit.JOTARO_MUSIC_DISC.get());
		    ItemStack disc23 = new ItemStack(ItemInit.JOSUKE_MUSIC_DISC.get());
		    ItemStack disc24 = new ItemStack(ItemInit.PRIME_MUSIC_DISC.get());
		    ItemStack disc25 = new ItemStack(ItemInit.EQUILA_MUSIC_DISC.get());
		    ItemStack disc26 = new ItemStack(ItemInit.THEROX_MUSIC_DISC.get());
		    ItemStack disc27 = new ItemStack(ItemInit.MAGASIN_MUSIC_DISC.get());
		    ItemStack disc28 = new ItemStack(ItemInit.HELIKOPTER_MUSIC_DISC.get());
		    ItemStack disc29 = new ItemStack(ItemInit.FOSSIL_FALLS_MUSIC_DISC.get());
		    ItemStack disc30 = new ItemStack(ItemInit.TANJIRO_MUSIC_DISC.get());

		    
		    if(randomDisc == 1 || randomDisc2 == 1)
		    {
		    	spawnAsEntity(worldIn, pos, disc1);
		    }
		    
		    if(randomDisc == 2 || randomDisc2 == 2)
		    {
		    	spawnAsEntity(worldIn, pos, disc2);
		    }
		    
		    if(randomDisc == 3 || randomDisc2 == 3)
		    {
		    	spawnAsEntity(worldIn, pos, disc3);
		    }
		    
		    if(randomDisc == 4 || randomDisc2 == 4)
		    {
		    	spawnAsEntity(worldIn, pos, disc4);
		    }
		    
		    if(randomDisc == 5 || randomDisc2 == 5)
		    {
		    	spawnAsEntity(worldIn, pos, disc5);
		    }
		    
		    if(randomDisc == 6 || randomDisc2 == 6)
		    {
		    	spawnAsEntity(worldIn, pos, disc6);
		    }
		    
		    if(randomDisc == 7 || randomDisc2 == 7)
		    {
		    	spawnAsEntity(worldIn, pos, disc7);
		    }
		    
		    if(randomDisc == 8 || randomDisc2 == 8)
		    {
		    	spawnAsEntity(worldIn, pos, disc8);
		    }
		    
		    if(randomDisc == 9 || randomDisc2 == 9)
		    {
		    	spawnAsEntity(worldIn, pos, disc9);
		    }
		    
		    if(randomDisc == 10 || randomDisc2 == 10)
		    {
		    	spawnAsEntity(worldIn, pos, disc10);
		    }
		    
		    if(randomDisc == 11 || randomDisc2 == 11)
		    {
		    	spawnAsEntity(worldIn, pos, disc11);
		    }
		    
		    if(randomDisc == 12 || randomDisc2 == 12)
		    {
		    	spawnAsEntity(worldIn, pos, disc12);
		    }
		    
		    if(randomDisc == 13 || randomDisc2 == 13)
		    {
		    	spawnAsEntity(worldIn, pos, disc13);
		    }
		    
		    if(randomDisc == 14 || randomDisc2 == 14)
		    {
		    	spawnAsEntity(worldIn, pos, disc14);
		    }
		    
		    if(randomDisc == 15 || randomDisc2 == 15)
		    {
		    	spawnAsEntity(worldIn, pos, disc15);
		    }
		    
		    if(randomDisc == 16 || randomDisc2 == 16)
		    {
		    	spawnAsEntity(worldIn, pos, disc16);
		    }
		    
		    if(randomDisc == 17 || randomDisc2 == 17)
		    {
		    	spawnAsEntity(worldIn, pos, disc17);
		    }
		    
		    if(randomDisc == 18 || randomDisc2 == 18)
		    {
		    	spawnAsEntity(worldIn, pos, disc18);
		    }
		    
		    if(randomDisc == 19 || randomDisc2 == 19)
		    {
		    	spawnAsEntity(worldIn, pos, disc19);
		    }
		    
		    if(randomDisc == 20 || randomDisc2 == 20)
		    {
		    	spawnAsEntity(worldIn, pos, disc20);
		    }
		    
		    if(randomDisc == 21 || randomDisc2 == 21)
		    {
		    	spawnAsEntity(worldIn, pos, disc21);
		    }
		    
		    if(randomDisc == 22 || randomDisc2 == 22)
		    {
		    	spawnAsEntity(worldIn, pos, disc22);
		    }
		    
		    if(randomDisc == 23 || randomDisc2 == 23)
		    {
		    	spawnAsEntity(worldIn, pos, disc23);
		    }
		    
		    if(randomDisc == 24 || randomDisc2 == 24)
		    {
		    	spawnAsEntity(worldIn, pos, disc24);
		    }
		    
		    if(randomDisc == 25 || randomDisc2 == 25)
		    {
		    	spawnAsEntity(worldIn, pos, disc25);
		    }
		    
		    if(randomDisc == 26 || randomDisc2 == 26)
		    {
		    	spawnAsEntity(worldIn, pos, disc26);
		    }
		    
		    if(randomDisc == 27 || randomDisc2 == 27)
		    {
		    	spawnAsEntity(worldIn, pos, disc27);
		    }
		    
		    if(randomDisc == 28 || randomDisc2 == 28)
		    {
		    	spawnAsEntity(worldIn, pos, disc28);
		    }
		    
		    if(randomDisc == 29 || randomDisc2 == 29)
		    {
		    	spawnAsEntity(worldIn, pos, disc29);
		    }
		    
		    if(randomDisc == 30 || randomDisc2 == 30)
		    {
		    	spawnAsEntity(worldIn, pos, disc30);
		    }
		    		    
		}
		else if(randomPrice == 640)
		{
			boolean isVeryLucky = RANDOM.nextBoolean();
			if(isVeryLucky)
			{
				player.sendMessage(new TranslationTextComponent("§dYOU HAVE BEEN BLESSED BY THE GODS !"), null);
				int randomOPWeapon = RANDOM.nextInt(3);
				switch(randomOPWeapon)
				{		
				  case 0:
				  ItemStack W1 = new ItemStack(ItemInit.GOLDEN_REINHARDT_HAMMER.get(), 1);
				  spawnAsEntity(worldIn, pos, W1);
				  break;
				  
				  case 1:
				  ItemStack W2 = new ItemStack(ItemInit.LENNON_WRATH.get(), 1);
				  spawnAsEntity(worldIn, pos, W2);
				  break;
				  
				  case 2:
				  ItemStack W3 = new ItemStack(ItemInit.RUMPAQUACK.get(), 1);
				  spawnAsEntity(worldIn, pos, W3);
				  break;
				  
				  case 3:
				  ItemStack W4 = new ItemStack(ItemInit.FRACTAL_BLADE.get(), 1);
				  spawnAsEntity(worldIn, pos, W4);
				  break;
				}

			}
			else
			{
				player.sendMessage(new TranslationTextComponent("§0YOU HAVE BEEN CURSED BY THE GODS !"), null);
				WitherEntity wither = new WitherEntity(EntityType.WITHER, worldIn);
				wither.setPositionAndUpdate(pos.getX(), pos.getY(), pos.getZ());
				worldIn.addEntity(wither);
			}
		}
		else if(randomPrice < 660)
		{
		    ItemStack nightSoulsEmerald = new ItemStack(ItemInit.NIGHTSOULS_EMERALD.get(), RANDOM.nextInt(11) + 6);
		    spawnAsEntity(worldIn, pos, nightSoulsEmerald);
		}
		else if(randomPrice < 680)
		{
		    ItemStack beer = new ItemStack(ItemInit.BEER.get(), RANDOM.nextInt(6) + 5);
		    ItemStack wine = new ItemStack(ItemInit.WINE.get(), RANDOM.nextInt(6) + 5);
		    spawnAsEntity(worldIn, pos, beer);
		    spawnAsEntity(worldIn, pos, wine);
		}
		else if(randomPrice < 700)
		{
		    ItemStack banana = new ItemStack(ItemInit.BANANA.get(), RANDOM.nextInt(15) + 10);
		    spawnAsEntity(worldIn, pos, banana);
		    player.sendMessage(new TranslationTextComponent("MONKE !"), null);
	
		}
		else if(randomPrice < 720)
		{
		    ItemStack pizza = new ItemStack(ItemInit.PIZZA_SLICE.get(), RANDOM.nextInt(11) + 8);
		    spawnAsEntity(worldIn, pos, pizza);
		    player.sendMessage(new TranslationTextComponent("Pizza ?! Save me some !"), null);
	
		}
		else if(randomPrice < 735)
		{
			ItemStack primiumIngots = new ItemStack(ItemInit.PRIMIUM_INGOT.get(), 2 + RANDOM.nextInt(3));
			ItemStack rowequiteIngots = new ItemStack(ItemInit.ROWEQUITE_INGOT.get(), 2 + RANDOM.nextInt(3));
			ItemStack thereniteIngots = new ItemStack(ItemInit.THERENITE_INGOT.get(), 2 + RANDOM.nextInt(3));
			spawnAsEntity(worldIn, pos, primiumIngots);
			spawnAsEntity(worldIn, pos, rowequiteIngots);
			spawnAsEntity(worldIn, pos, thereniteIngots);
	
		}
		else if(randomPrice < 750)
		{
			ItemStack crazy = new ItemStack(ItemInit.CRAZY_DIAMOND.get(), 1 + RANDOM.nextInt(3));
			spawnAsEntity(worldIn, pos, crazy);
	
		}
		else if(randomPrice <= 765)
		{
			worldIn.setBlockState(pos.add(0, 0, 0), BlockInit.CELESTIAL_EMERALD_BLOCK.get().getDefaultState());
	
		}
		
		else if(randomPrice > 765)
		{
	        player.sendMessage(new TranslationTextComponent("You got jebaited :) Better luck next time."), null);
		}
				
		super.harvestBlock(worldIn, player, pos, state, te, stack);
	}

}
