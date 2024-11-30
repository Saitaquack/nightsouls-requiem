package com.saita.legendsawaken.entities.models;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.saita.legendsawaken.LegendsAwakenMod;
import com.saita.legendsawaken.entities.mobs.AlternateEntity;

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

public class AlternateModel<T extends AlternateEntity> extends EntityModel<T> {
	
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(LegendsAwakenMod.MOD_ID, "alternate_entity"), "main");

	private final ModelParts parts;

	public AlternateModel(ModelPart root) {
		ModelPart body = root.getChild("Body");
		ModelPart head = body.getChild("head");
		ModelPart leftLeg = body.getChild("leftLeg");
		ModelPart rightLeg = body.getChild("rightLeg");
		
		this.parts = new ModelParts(body, head, leftLeg, rightLeg);
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Body = partdefinition.addOrReplaceChild("Body", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		Body.addOrReplaceChild("head", CubeListBuilder.create().texOffs(2, 24).addBox(-8.0F, -17.0F, -6.0F, 16.0F, 18.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -68.0F, -9.0F));

		PartDefinition topChest = Body.addOrReplaceChild("topChest", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		topChest.addOrReplaceChild("topChest_r1", CubeListBuilder.create().texOffs(-20, 0).addBox(-6.0F, -64.0F, 23.0F, 12.0F, 21.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.5236F, 0.0F, 0.0F));
		Body.addOrReplaceChild("bottomChest", CubeListBuilder.create().texOffs(-20, 0).addBox(-6.0F, -53.0F, -3.0F, 12.0F, 21.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition rightArm = Body.addOrReplaceChild("rightArm", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		rightArm.addOrReplaceChild("rightArm_r1", CubeListBuilder.create().texOffs(40, 0).mirror().addBox(-12.0F, -59.0F, -37.0F, 6.0F, 52.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.4363F, 0.0F, 0.0F));

		PartDefinition leftArm = Body.addOrReplaceChild("leftArm", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		leftArm.addOrReplaceChild("leftArm_r1", CubeListBuilder.create().texOffs(40, 0).addBox(6.0F, -59.0F, -37.0F, 6.0F, 52.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.4363F, 0.0F, 0.0F));
		Body.addOrReplaceChild("rightLeg", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, 0.0F, -1.0F, 3.0F, 32.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(-5.0F, -32.0F, -1.0F));
		Body.addOrReplaceChild("leftLeg", CubeListBuilder.create().texOffs(0, -3).addBox(-2.0F, 0.0F, -1.0F, 3.0F, 32.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(5.0F, -32.0F, -1.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
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