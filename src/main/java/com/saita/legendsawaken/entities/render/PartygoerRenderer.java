package com.saita.legendsawaken.entities.render;

import com.saita.legendsawaken.LegendsAwakenMod;
import com.saita.legendsawaken.entities.mobs.PartygoerEntity;
import com.saita.legendsawaken.entities.models.PartygoerModel;

import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class PartygoerRenderer extends MobRenderer<PartygoerEntity, PartygoerModel<PartygoerEntity>>{
	
	private static final ResourceLocation TEXTURE = new ResourceLocation(LegendsAwakenMod.MOD_ID, "textures/entity/partygoer.png");

	public PartygoerRenderer(Context context) {
		super(context, new PartygoerModel<>(context.bakeLayer(PartygoerModel.LAYER_LOCATION)), 0.75F);
		
	}

	@Override
	public ResourceLocation getTextureLocation(PartygoerEntity entity) {
		return TEXTURE;
	}

}
