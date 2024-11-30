package com.saita.legendsawaken.entities.render;

import com.saita.legendsawaken.LegendsAwakenMod;
import com.saita.legendsawaken.entities.mobs.WendigoEntity;
import com.saita.legendsawaken.entities.models.WendigoModel;

import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class WendigoRenderer extends MobRenderer<WendigoEntity, WendigoModel<WendigoEntity>>{
	
	private static final ResourceLocation TEXTURE = new ResourceLocation(LegendsAwakenMod.MOD_ID, "textures/entity/wendigo.png");

	public WendigoRenderer(Context context) {
		super(context, new WendigoModel<>(context.bakeLayer(WendigoModel.LAYER_LOCATION)), 0.75F);
		
	}

	@Override
	public ResourceLocation getTextureLocation(WendigoEntity entity) {
		return TEXTURE;
	}

}
