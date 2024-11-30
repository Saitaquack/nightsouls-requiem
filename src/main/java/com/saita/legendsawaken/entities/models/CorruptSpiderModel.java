package com.saita.legendsawaken.entities.models;

import com.saita.legendsawaken.LegendsAwakenMod;
import com.saita.legendsawaken.entities.mobs.CorruptSpiderEntity;

import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.SpiderModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.resources.ResourceLocation;

public class CorruptSpiderModel<T extends CorruptSpiderEntity> extends SpiderModel<T> {
	
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(LegendsAwakenMod.MOD_ID, "corrupt_spider_entity"), "main");

	public CorruptSpiderModel(ModelPart p_171090_) {
		super(p_171090_);
	}
	
	public static LayerDefinition createBodyLayer() {
		
		return LayerDefinition.create(HumanoidModel.createMesh(CubeDeformation.NONE, 0.0F), 64, 64);
	}
	
}