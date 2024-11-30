package com.saita.legendsawaken.entities.render;

import com.saita.legendsawaken.LegendsAwakenMod;
import com.saita.legendsawaken.entities.mobs.DemonEyeEntity;
import com.saita.legendsawaken.entities.models.DemonEyeModel;

import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class DemonEyeRenderer extends MobRenderer<DemonEyeEntity, DemonEyeModel<DemonEyeEntity>>{
	
	private static final ResourceLocation TEXTURE = new ResourceLocation(LegendsAwakenMod.MOD_ID, "textures/entity/demon_eye.png");

	public DemonEyeRenderer(Context context) {
		super(context, new DemonEyeModel<>(context.bakeLayer(DemonEyeModel.LAYER_LOCATION)), 0.75F);
		
	}

	@Override
	public ResourceLocation getTextureLocation(DemonEyeEntity entity) {
		return TEXTURE;
	}

}
