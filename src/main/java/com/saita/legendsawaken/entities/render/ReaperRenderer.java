package com.saita.legendsawaken.entities.render;

import com.saita.legendsawaken.LegendsAwakenMod;
import com.saita.legendsawaken.entities.mobs.ReaperEntity;
import com.saita.legendsawaken.entities.models.ReaperModel;

import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class ReaperRenderer extends MobRenderer<ReaperEntity, ReaperModel<ReaperEntity>>{
	
	private static final ResourceLocation TEXTURE = new ResourceLocation(LegendsAwakenMod.MOD_ID, "textures/entity/reaper.png");

	public ReaperRenderer(Context context) {
		super(context, new ReaperModel<>(context.bakeLayer(ReaperModel.LAYER_LOCATION)), 0.5F);
		
	}

	@Override
	public ResourceLocation getTextureLocation(ReaperEntity entity) {
		return TEXTURE;
	}

}
