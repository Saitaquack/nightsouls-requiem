package com.saita.legendsawaken.entities.models;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.saita.legendsawaken.LegendsAwakenMod;
import com.saita.legendsawaken.entities.mobs.DemonEyeEntity;

import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;

public class DemonEyeModel<T extends DemonEyeEntity> extends EntityModel<T> {
	
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(LegendsAwakenMod.MOD_ID, "demon_eye_entity"), "main");

	private final ModelParts parts;

	public DemonEyeModel(ModelPart root) {
		ModelPart body = root.getChild("Body");
		ModelPart tentacles = body.getChild("Tentacles");
		ModelPart tentacle1 = tentacles.getChild("Tentacle1");
		ModelPart tentacle2 = tentacles.getChild("Tentacle2");
		ModelPart tentacle3 = tentacles.getChild("Tentacle3");
		ModelPart tentacle4 = tentacles.getChild("Tentacle4");
		ModelPart tentacle5 = tentacles.getChild("Tentacle5");
		ModelPart tentacle6 = tentacles.getChild("Tentacle6");
		
		this.parts = new ModelParts(body, tentacles, tentacle1, tentacle2, tentacle3, tentacle4, tentacle5, tentacle6);
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Body = partdefinition.addOrReplaceChild("Body", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		Body.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(0, 0).addBox(-6.0F, -13.0F, -7.0F, 12.0F, 12.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition Tentacles = Body.addOrReplaceChild("Tentacles", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		Tentacles.addOrReplaceChild("Tentacle4", CubeListBuilder.create().texOffs(71, 1).addBox(2.0F, -4.0F, 4.0F, 1.0F, 1.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(-4.0F, -3.0F, 0.0F));
		Tentacles.addOrReplaceChild("Tentacle3", CubeListBuilder.create().texOffs(71, 2).addBox(1.0F, -7.0F, 4.0F, 1.0F, 1.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));
		Tentacles.addOrReplaceChild("Tentacle2", CubeListBuilder.create().texOffs(55, 12).addBox(-4.0F, -4.0F, 4.0F, 1.0F, 1.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		Tentacles.addOrReplaceChild("Tentacle1", CubeListBuilder.create().texOffs(73, 2).addBox(3.0F, -4.0F, 4.0F, 1.0F, 1.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));
		Tentacles.addOrReplaceChild("Tentacle5", CubeListBuilder.create().texOffs(62, 6).addBox(3.0F, -5.0F, 4.0F, 1.0F, 1.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -6.0F, 0.0F));
		Tentacles.addOrReplaceChild("Tentacle6", CubeListBuilder.create().texOffs(53, 1).addBox(2.0F, -5.0F, 4.0F, 1.0F, 1.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(-6.0F, -6.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 95, 24);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		  this.parts.tentacle2().xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 0.2F * limbSwingAmount;
		  this.parts.tentacle3().xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 0.2F * limbSwingAmount;
		  this.parts.tentacle6().xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 0.2F * limbSwingAmount;
		  
		  this.parts.tentacle1().xRot = Mth.cos(limbSwing * 0.6662F) * 0.2F * limbSwingAmount;
		  this.parts.tentacle4().xRot = Mth.cos(limbSwing * 0.6662F) * 0.2F * limbSwingAmount;
		  this.parts.tentacle5().xRot = Mth.cos(limbSwing * 0.6662F) * 0.2F * limbSwingAmount;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		this.parts.body().render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
	
	private record ModelParts(ModelPart body, ModelPart tentacles, ModelPart tentacle1, ModelPart tentacle2, ModelPart tentacle3, ModelPart tentacle4, ModelPart tentacle5, ModelPart tentacle6) {
		
	}
}