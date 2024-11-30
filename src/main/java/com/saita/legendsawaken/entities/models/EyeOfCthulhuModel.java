package com.saita.legendsawaken.entities.models;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.saita.legendsawaken.LegendsAwakenMod;
import com.saita.legendsawaken.entities.mobs.EyeOfCthulhuEntity;

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

public class EyeOfCthulhuModel<T extends EyeOfCthulhuEntity> extends EntityModel<T> {
	
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(LegendsAwakenMod.MOD_ID, "eye_of_cthulhu_entity"), "main");

	private final ModelParts parts;

	public EyeOfCthulhuModel(ModelPart root) {
		ModelPart body = root.getChild("Body");
		ModelPart head = body.getChild("Head");
		ModelPart tentacles = body.getChild("Tentacles");
		ModelPart tentacle1 = tentacles.getChild("Tentacle1");
		ModelPart tentacle2 = tentacles.getChild("Tentacle2");
		ModelPart tentacle3 = tentacles.getChild("Tentacle3");
		ModelPart tentacle4 = tentacles.getChild("Tentacle4");
		ModelPart tentacle5 = tentacles.getChild("Tentacle5");
		ModelPart tentacle6 = tentacles.getChild("Tentacle6");
		
		this.parts = new ModelParts(body, head, tentacles, tentacle1, tentacle2, tentacle3, tentacle4, tentacle5, tentacle6);
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Body = partdefinition.addOrReplaceChild("Body", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		Body.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(0, 0).addBox(-46.0F, -65.0F, -25.0F, 60.0F, 60.0F, 60.0F, new CubeDeformation(0.0F)), PartPose.offset(16.0F, 0.0F, -5.0F));

		PartDefinition Tentacles = Body.addOrReplaceChild("Tentacles", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));
		
		Tentacles.addOrReplaceChild("Tentacle2", CubeListBuilder.create().texOffs(365, 0).addBox(-16.0F, -17.0F, 25.0F, 5.0F, 5.0F, 50.0F, new CubeDeformation(0.0F)), PartPose.offset(-4.0F, -3.0F, 0.0F));
		Tentacles.addOrReplaceChild("Tentacle4", CubeListBuilder.create().texOffs(365, 65).addBox(-10.0F, -35.0F, 25.0F, 5.0F, 5.0F, 50.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));
		Tentacles.addOrReplaceChild("Tentacle1", CubeListBuilder.create().texOffs(365, 65).addBox(15.0F, -20.0F, 25.0F, 5.0F, 5.0F, 50.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));
		Tentacles.addOrReplaceChild("Tentacle3", CubeListBuilder.create().texOffs(365, 0).addBox(5.0F, -35.0F, 25.0F, 5.0F, 5.0F, 50.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));
		Tentacles.addOrReplaceChild("Tentacle5", CubeListBuilder.create().texOffs(265, 54).addBox(15.0F, -49.0F, 25.0F, 5.0F, 5.0F, 50.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -6.0F, 0.0F));
		Tentacles.addOrReplaceChild("Tentacle6", CubeListBuilder.create().texOffs(265, 5).addBox(-14.0F, -49.0F, 25.0F, 5.0F, 5.0F, 50.0F, new CubeDeformation(0.0F)), PartPose.offset(-6.0F, -6.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 475, 120);
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
	
	private record ModelParts(ModelPart body, ModelPart head, ModelPart tentacles, ModelPart tentacle1, ModelPart tentacle2, ModelPart tentacle3, ModelPart tentacle4, ModelPart tentacle5, ModelPart tentacle6) {
		
	}
}