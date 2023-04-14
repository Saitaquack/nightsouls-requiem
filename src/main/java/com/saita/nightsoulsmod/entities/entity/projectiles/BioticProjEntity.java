package com.saita.nightsoulsmod.entities.entity.projectiles;

import com.saita.nightsoulsmod.init.ItemInit;
import com.saita.nightsoulsmod.init.NightSoulsEntityTypes;
import com.saita.nightsoulsmod.init.SoundInit;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.ProjectileItemEntity;
import net.minecraft.item.Item;
import net.minecraft.network.IPacket;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.EntityRayTraceResult;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;

public class BioticProjEntity extends ProjectileItemEntity {


	public BioticProjEntity(EntityType<BioticProjEntity> type, World world) {
		super(type, world);
	}
	
	public BioticProjEntity(LivingEntity entity, World world) {
		super(NightSoulsEntityTypes.BIOTIC_PROJ.get(), entity, world);
	}
	
	public BioticProjEntity(double x, double y, double z, World world) {
		super(NightSoulsEntityTypes.BIOTIC_PROJ.get(), x, y, z, world);
	}

	@Override
	protected Item getDefaultItem() {
		return ItemInit.BIOTIC_PROJECTILE.get().asItem();
	}

	@Override
	public IPacket<?> createSpawnPacket() {
		return NetworkHooks.getEntitySpawningPacket(this);
	}

	@Override
	protected void onImpact(RayTraceResult result) {

		if(result.getType() == RayTraceResult.Type.ENTITY) {

			Entity entity = ((EntityRayTraceResult)result).getEntity();

			if(entity.getEntity().getType() != EntityType.PLAYER && entity.getEntity().getType() != EntityType.VILLAGER)
			{
				entity.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getShooter()), 24.0F);
				entity.playSound(SoundInit.BIOTIC_RIFLE_DAMAGE.get(), 1.0F, 1.0F);
			}	
			else
			{
				LivingEntity player = (LivingEntity)entity;
				player.heal(9);
				entity.playSound(SoundInit.BIOTIC_RIFLE_HEAL.get(), 1.0F, 1.0F);
			}
			
			if(!world.isRemote) {
				this.remove();
			}

		}
		
		if(result.getType() == RayTraceResult.Type.BLOCK) {
				
			if(!world.isRemote) {
				this.remove();
			}
		}
		

		if(result.getType() == RayTraceResult.Type.MISS) {
	

			if(!world.isRemote) {
				this.remove();
			}
		
		}
	  }
	
	
}
