package com.saita.legendsawaken.entities.render;

import com.saita.legendsawaken.LegendsAwakenMod;
import com.saita.legendsawaken.entities.mobs.StalkerEntity;
import com.saita.legendsawaken.entities.models.StalkerModel;

import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class StalkerRenderer extends MobRenderer<StalkerEntity, StalkerModel<StalkerEntity>>{
	
	private static final ResourceLocation TEXTURE = new ResourceLocation(LegendsAwakenMod.MOD_ID, "textures/entity/stalker.png");

	public StalkerRenderer(Context context) {
		super(context, new StalkerModel<>(context.bakeLayer(StalkerModel.LAYER_LOCATION)), 1.0F);
		
	}

	@Override
	public ResourceLocation getTextureLocation(StalkerEntity entity) {
		return TEXTURE;
	}

}
