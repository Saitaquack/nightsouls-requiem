package com.saita.legendsawaken.entities.render;

import com.saita.legendsawaken.LegendsAwakenMod;
import com.saita.legendsawaken.entities.mobs.WerewolfEntity;
import com.saita.legendsawaken.entities.models.WerewolfModel;

import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class WerewolfRenderer extends MobRenderer<WerewolfEntity, WerewolfModel<WerewolfEntity>>{
	
	private static final ResourceLocation TEXTURE = new ResourceLocation(LegendsAwakenMod.MOD_ID, "textures/entity/werewolf.png");

	public WerewolfRenderer(Context context) {
		super(context, new WerewolfModel<>(context.bakeLayer(WerewolfModel.LAYER_LOCATION)), 0.7F);
		
	}

	@Override
	public ResourceLocation getTextureLocation(WerewolfEntity entity) {
		return TEXTURE;
	}

}
