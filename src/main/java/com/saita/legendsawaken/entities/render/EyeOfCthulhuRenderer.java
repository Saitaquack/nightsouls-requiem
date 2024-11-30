package com.saita.legendsawaken.entities.render;

import com.saita.legendsawaken.LegendsAwakenMod;
import com.saita.legendsawaken.entities.mobs.EyeOfCthulhuEntity;
import com.saita.legendsawaken.entities.models.EyeOfCthulhuModel;

import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class EyeOfCthulhuRenderer extends MobRenderer<EyeOfCthulhuEntity, EyeOfCthulhuModel<EyeOfCthulhuEntity>>{
	
	private static final ResourceLocation TEXTURE = new ResourceLocation(LegendsAwakenMod.MOD_ID, "textures/entity/eye_of_cthulhu.png");

	public EyeOfCthulhuRenderer(Context context) {
		super(context, new EyeOfCthulhuModel<>(context.bakeLayer(EyeOfCthulhuModel.LAYER_LOCATION)), 5.0F);
		
	}

	@Override
	public ResourceLocation getTextureLocation(EyeOfCthulhuEntity entity) {
		return TEXTURE;
	}

}
