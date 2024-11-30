package com.saita.legendsawaken.init;

import com.saita.legendsawaken.LegendsAwakenMod;
import com.saita.legendsawaken.entities.mobs.*;
import com.saita.legendsawaken.entities.projectiles.*;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class EntityInit {
	
	public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, LegendsAwakenMod.MOD_ID);
	
	public static final RegistryObject<EntityType<CorruptZombieEntity>> CORRUPT_ZOMBIE = ENTITIES.register("corrupt_zombie", () -> EntityType.Builder.<CorruptZombieEntity>of(CorruptZombieEntity::new, MobCategory.MONSTER)
			.sized(0.6F, 1.95F)
			.build(new ResourceLocation(LegendsAwakenMod.MOD_ID, "corrupt_zombie").toString())
		);
	
	public static final RegistryObject<EntityType<CorruptSpiderEntity>> CORRUPT_SPIDER = ENTITIES.register("corrupt_spider", () -> EntityType.Builder.<CorruptSpiderEntity>of(CorruptSpiderEntity::new, MobCategory.MONSTER)
			.sized(1.4F, 0.9F)
			.build(new ResourceLocation(LegendsAwakenMod.MOD_ID, "corrupt_spider").toString())
		);
	
	public static final RegistryObject<EntityType<WerewolfEntity>> WEREWOLF = ENTITIES.register("werewolf", () -> EntityType.Builder.<WerewolfEntity>of(WerewolfEntity::new, MobCategory.MONSTER)
			.sized(0.8F, 2.05F)
			.build(new ResourceLocation(LegendsAwakenMod.MOD_ID, "werewolf").toString())
		);
	
	public static final RegistryObject<EntityType<ReaperEntity>> REAPER = ENTITIES.register("reaper", () -> EntityType.Builder.<ReaperEntity>of(ReaperEntity::new, MobCategory.MONSTER)
			.sized(0.6F, 1.95F)
			.build(new ResourceLocation(LegendsAwakenMod.MOD_ID, "reaper").toString())
		);
	
	public static final RegistryObject<EntityType<WendigoEntity>> WENDIGO = ENTITIES.register("wendigo", () -> EntityType.Builder.<WendigoEntity>of(WendigoEntity::new, MobCategory.MONSTER)
			.sized(1.2F, 3.0F)
			.build(new ResourceLocation(LegendsAwakenMod.MOD_ID, "wendigo").toString())
		);
	
	public static final RegistryObject<EntityType<AlternateEntity>> ALTERNATE = ENTITIES.register("alternate", () -> EntityType.Builder.<AlternateEntity>of(AlternateEntity::new, MobCategory.MONSTER)
			.sized(1.2F, 4.95F)
			.build(new ResourceLocation(LegendsAwakenMod.MOD_ID, "alternate").toString())
		);
	
	public static final RegistryObject<EntityType<PartygoerEntity>> PARTYGOER = ENTITIES.register("partygoer", () -> EntityType.Builder.<PartygoerEntity>of(PartygoerEntity::new, MobCategory.MONSTER)
			.sized(0.9F, 3.0F)
			.build(new ResourceLocation(LegendsAwakenMod.MOD_ID, "partygoer").toString())
		);
	
	public static final RegistryObject<EntityType<DemonEyeEntity>> DEMON_EYE = ENTITIES.register("demon_eye", () -> EntityType.Builder.<DemonEyeEntity>of(DemonEyeEntity::new, MobCategory.MONSTER)
			.sized(0.9F, 1.0F)
			.build(new ResourceLocation(LegendsAwakenMod.MOD_ID, "demon_eye").toString())
		);
	
	public static final RegistryObject<EntityType<StalkerEntity>> STALKER = ENTITIES.register("stalker", () -> EntityType.Builder.<StalkerEntity>of(StalkerEntity::new, MobCategory.MONSTER)
			.sized(1.2F, 2.95F)
			.build(new ResourceLocation(LegendsAwakenMod.MOD_ID, "stalker").toString())
		);
	
	public static final RegistryObject<EntityType<EyeOfCthulhuEntity>> EYE_OF_CTHULHU = ENTITIES.register("eye_of_cthulhu", () -> EntityType.Builder.<EyeOfCthulhuEntity>of(EyeOfCthulhuEntity::new, MobCategory.MONSTER)
			.sized(5.0F, 5.0F)
			.build(new ResourceLocation(LegendsAwakenMod.MOD_ID, "eye_of_cthulhu").toString())
		);
	
	
	
	
	
	public static final RegistryObject<EntityType<AmethystProjectileEntity>> AMETHYST_PROJECTILE = ENTITIES.register("amethyst_projectile", 
			() -> EntityType.Builder.<AmethystProjectileEntity>of(AmethystProjectileEntity::new, MobCategory.MISC)
			.sized(0.3F, 0.3F)
			.build(new ResourceLocation(LegendsAwakenMod.MOD_ID, "amethyst_projectile").toString())
		);
	
	public static final RegistryObject<EntityType<HellfireBulletProjectileEntity>> HELLFIRE_BULLET_PROJECTILE = ENTITIES.register("hellfire_bullet_projectile", 
			() -> EntityType.Builder.<HellfireBulletProjectileEntity>of(HellfireBulletProjectileEntity::new, MobCategory.MISC)
			.sized(0.15F, 0.15F)
			.build(new ResourceLocation(LegendsAwakenMod.MOD_ID, "hellfire_bullet_projectile").toString())
		);
	
	public static final RegistryObject<EntityType<MythrilArrowProjectileEntity>> MYTHRIL_ARROW = ENTITIES.register("mythril_arrow_projectile", 
			() -> EntityType.Builder.<MythrilArrowProjectileEntity>of(MythrilArrowProjectileEntity::new, MobCategory.MISC)
			.sized(0.5F, 0.5F)
			.clientTrackingRange(4)
			.updateInterval(20)
			.build(new ResourceLocation(LegendsAwakenMod.MOD_ID, "mythril_arrow_projectile").toString())
		);
	
	public static final RegistryObject<EntityType<TitaniteArrowProjectileEntity>> TITANITE_ARROW = ENTITIES.register("titanite_arrow_projectile", 
			() -> EntityType.Builder.<TitaniteArrowProjectileEntity>of(TitaniteArrowProjectileEntity::new, MobCategory.MISC)
			.sized(0.5F, 0.5F)
			.clientTrackingRange(4)
			.updateInterval(20)
			.build(new ResourceLocation(LegendsAwakenMod.MOD_ID, "titanite_arrow_projectile").toString())
		);
	
	 public static void register(IEventBus eventBus) {
	        ENTITIES.register(eventBus);
	    }

}
