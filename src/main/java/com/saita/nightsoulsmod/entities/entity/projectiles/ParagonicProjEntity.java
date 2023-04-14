package com.saita.nightsoulsmod.entities.entity.projectiles;

import com.saita.nightsoulsmod.init.ItemInit;
import com.saita.nightsoulsmod.init.NightSoulsEntityTypes;

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

public class ParagonicProjEntity extends ProjectileItemEntity {


	public ParagonicProjEntity(EntityType<ParagonicProjEntity> type, World world) {
		super(type, world);
	}
	
	public ParagonicProjEntity(LivingEntity entity, World world) {
		super(NightSoulsEntityTypes.PARAGONIC_PROJ.get(), entity, world);
	}
	
	public ParagonicProjEntity(double x, double y, double z, World world) {
		super(NightSoulsEntityTypes.PARAGONIC_PROJ.get(), x, y, z, world);
	}

	@Override
	protected Item getDefaultItem() {
		return ItemInit.PARAGONIC_PROJECTILE.get().asItem();
	}

	@Override
	public IPacket<?> createSpawnPacket() {
		return NetworkHooks.getEntitySpawningPacket(this);
	}

	@Override
	protected void onImpact(RayTraceResult result) {

		if(result.getType() == RayTraceResult.Type.ENTITY) {

			Entity entity = ((EntityRayTraceResult)result).getEntity();

			entity.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getShooter()), 65.0F);
			

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
