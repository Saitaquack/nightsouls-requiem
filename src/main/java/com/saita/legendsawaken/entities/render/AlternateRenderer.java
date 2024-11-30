package com.saita.legendsawaken.entities.render;

import com.saita.legendsawaken.LegendsAwakenMod;
import com.saita.legendsawaken.entities.mobs.AlternateEntity;
import com.saita.legendsawaken.entities.models.AlternateModel;

import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class AlternateRenderer extends MobRenderer<AlternateEntity, AlternateModel<AlternateEntity>>{
	
	private static final ResourceLocation TEXTURE = new ResourceLocation(LegendsAwakenMod.MOD_ID, "textures/entity/alternate.png");

	public AlternateRenderer(Context context) {
		super(context, new AlternateModel<>(context.bakeLayer(AlternateModel.LAYER_LOCATION)), 1.0F);
		
	}

	@Override
	public ResourceLocation getTextureLocation(AlternateEntity entity) {
		return TEXTURE;
	}

}
