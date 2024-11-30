package com.saita.legendsawaken.entities.render.projectiles;

import com.saita.legendsawaken.LegendsAwakenMod;
import com.saita.legendsawaken.entities.projectiles.MythrilArrowProjectileEntity;

import net.minecraft.client.renderer.entity.ArrowRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.resources.ResourceLocation;

public class MythrilArrowRenderer extends ArrowRenderer<MythrilArrowProjectileEntity>{

	public MythrilArrowRenderer(Context context) {
		super(context);
	
	}

	@Override
	public ResourceLocation getTextureLocation(MythrilArrowProjectileEntity pEntity) {
		return new ResourceLocation(LegendsAwakenMod.MOD_ID, "textures/entity/projectiles/mythril_arrow.png");
	}

}
