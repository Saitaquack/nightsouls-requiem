package com.saita.legendsawaken.entities.models;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.saita.legendsawaken.LegendsAwakenMod;
import com.saita.legendsawaken.entities.mobs.PartygoerEntity;

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

public class PartygoerModel<T extends PartygoerEntity> extends EntityModel<T> {
	
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(LegendsAwakenMod.MOD_ID, "partygoer_entity"), "main");

	private final ModelParts parts;

	public PartygoerModel(ModelPart root) {
		ModelPart body = root.getChild("Body");
		ModelPart head = body.getChild("head");
		ModelPart leftLeg = body.getChild("leftLeg");
		ModelPart rightLeg = body.getChild("rightLeg");
		
		this.parts = new ModelParts(body, head, leftLeg, rightLeg);
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Body = partdefinition.addOrReplaceChild("Body", CubeListBuilder.create(), PartPose.offset(-5.0F, 2.0F, 0.0F));

		Body.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(-5.0F, -10.0F, -5.0F, 10.0F, 10.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(5.0F, -14.0F, 0.0F));
		Body.addOrReplaceChild("chest", CubeListBuilder.create().texOffs(42, 25).mirror().addBox(-5.0F, -12.0F, -2.0F, 10.0F, 18.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(5.0F, -2.0F, 0.0F));

		PartDefinition rightArm = Body.addOrReplaceChild("rightArm", CubeListBuilder.create(), PartPose.offset(13.0F, -12.0F, 0.0F));
		rightArm.addOrReplaceChild("rightArm_r1", CubeListBuilder.create().texOffs(20, 51).mirror().addBox(5.0F, -35.0F, -10.0F, 6.0F, 24.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-8.0F, 34.0F, 0.0F, -0.2182F, 0.0F, 0.0F));
		Body.addOrReplaceChild("leftLeg", CubeListBuilder.create().texOffs(0, 25).addBox(-3.0F, -1.0F, -2.0F, 5.0F, 18.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(3.0F, 5.0F, 0.0F));
		Body.addOrReplaceChild("rightLeg", CubeListBuilder.create().texOffs(0, 25).mirror().addBox(-2.1F, -1.0F, -2.0F, 5.0F, 18.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(7.0F, 5.0F, 0.0F));

		PartDefinition leftArm = Body.addOrReplaceChild("leftArm", CubeListBuilder.create(), PartPose.offset(-3.0F, -12.0F, 0.0F));
		leftArm.addOrReplaceChild("leftArm_r1", CubeListBuilder.create().texOffs(20, 50).addBox(-11.0F, -35.0F, -10.0F, 6.0F, 24.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.0F, 34.0F, 0.0F, -0.2182F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 80, 80);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.parts.head().yRot = netHeadYaw * Mth.DEG_TO_RAD;
		this.parts.head().xRot = headPitch * Mth.DEG_TO_RAD;
		
		this.parts.leftLeg().xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
		this.parts.rightLeg().xRot = Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		this.parts.body().render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
	
	private record ModelParts(ModelPart body, ModelPart head, ModelPart leftLeg, ModelPart rightLeg) {
		
	}
}