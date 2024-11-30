package com.saita.legendsawaken.entities.render.projectiles;

import com.saita.legendsawaken.LegendsAwakenMod;
import com.saita.legendsawaken.entities.projectiles.TitaniteArrowProjectileEntity;

import net.minecraft.client.renderer.entity.ArrowRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.resources.ResourceLocation;

public class TitaniteArrowRenderer extends ArrowRenderer<TitaniteArrowProjectileEntity>{

	public TitaniteArrowRenderer(Context context) {
		super(context);
	
	}

	@Override
	public ResourceLocation getTextureLocation(TitaniteArrowProjectileEntity pEntity) {
		return new ResourceLocation(LegendsAwakenMod.MOD_ID, "textures/entity/projectiles/titanite_arrow.png");
	}

}
