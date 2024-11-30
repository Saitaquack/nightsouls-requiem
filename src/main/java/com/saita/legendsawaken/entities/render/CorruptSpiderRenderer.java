package com.saita.legendsawaken.entities.render;

import com.saita.legendsawaken.LegendsAwakenMod;

import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.SpiderRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.monster.Spider;

public class CorruptSpiderRenderer extends SpiderRenderer<Spider> {

	public CorruptSpiderRenderer(Context p_174401_) {
		super(p_174401_);

	}

	private static final ResourceLocation TEXTURE = new ResourceLocation(LegendsAwakenMod.MOD_ID, "textures/entity/corrupt_spider.png");
	
	@Override
	public ResourceLocation getTextureLocation(Spider entity) {
		return TEXTURE;
	}

}
