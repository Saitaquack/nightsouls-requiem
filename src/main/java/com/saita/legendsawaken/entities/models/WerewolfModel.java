package com.saita.legendsawaken.entities.models;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.saita.legendsawaken.LegendsAwakenMod;
import com.saita.legendsawaken.entities.mobs.WerewolfEntity;

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

public class WerewolfModel<T extends WerewolfEntity> extends EntityModel<T> {
	
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(LegendsAwakenMod.MOD_ID, "werewolf_entity"), "main");

	private final ModelParts parts;

	public WerewolfModel(ModelPart root) {
		ModelPart body = root.getChild("Body");
		ModelPart head = body.getChild("head");
		ModelPart legs = body.getChild("legs");
		ModelPart leftLeg = legs.getChild("leftLeg");
		ModelPart rightLeg = legs.getChild("rightLeg");
		
		this.parts = new ModelParts(body, head, legs, leftLeg, rightLeg);
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Body = partdefinition.addOrReplaceChild("Body", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));
		PartDefinition arms = Body.addOrReplaceChild("arms", CubeListBuilder.create(), PartPose.offset(-4.5F, -15.5F, 4.0F));
		PartDefinition leftArm = arms.addOrReplaceChild("leftArm", CubeListBuilder.create(), PartPose.offset(5.5F, 1.148F, -0.2284F));

		leftArm.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(0, 19).addBox(-0.75F, -3.5F, -1.25F, 1.5F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.5F, 5.852F, -13.2716F, -0.3927F, 0.0F, 0.0F));
		leftArm.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(17, 64).addBox(-2.5F, -7.5F, -1.75F, 3.0F, 11.0F, 3.5F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.0F, 0.0F, -10.0F, -0.3927F, 0.0F, 0.0F));
		leftArm.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(0, 50).addBox(-3.5F, -4.5F, -2.0F, 4.0F, 10.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.5F, -11.4692F, -6.3317F, -0.3927F, 0.0F, 0.0F));

		PartDefinition rightArm = arms.addOrReplaceChild("rightArm", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));
		rightArm.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(38, 59).addBox(-18.5F, -7.5F, -1.75F, 3.0F, 11.0F, 3.5F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(13.5F, 1.148F, -10.2284F, -0.3927F, 0.0F, 0.0F));
		rightArm.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(0, 0).addBox(-15.75F, -3.5F, -1.25F, 1.5F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(12.0F, 7.0F, -13.5F, -0.3927F, 0.0F, 0.0F));
		rightArm.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(38, 44).addBox(-19.5F, -4.5F, -2.0F, 4.0F, 10.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(14.0F, -10.3212F, -6.56F, -0.3927F, 0.0F, 0.0F));

		PartDefinition legs = Body.addOrReplaceChild("legs", CubeListBuilder.create(), PartPose.offset(-8.0F, -8.0F, 8.0F));
		PartDefinition rightLeg = legs.addOrReplaceChild("rightLeg", CubeListBuilder.create().texOffs(62, 8).addBox(-1.0F, 15.0454F, -5.5628F, 3.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(4.0F, -8.0F, 0.0F));

		rightLeg.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(0, 36).addBox(-1.5F, -3.5F, -2.0F, 3.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 13.5F, 0.25F, -0.3927F, 0.0F, 0.0F));
		rightLeg.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(49, 4).addBox(-1.5F, -2.5F, -3.5F, 3.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 10.5F, -2.5F, -0.3927F, 0.0F, 0.0F));
		 rightLeg.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(20, 50).addBox(-9.5F, -2.5F, 0.0F, 5.0F, 11.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.5F, 0.5F, -3.0F, -0.3927F, 0.0F, 0.0F));

		PartDefinition leftLeg = legs.addOrReplaceChild("leftLeg", CubeListBuilder.create().texOffs(64, 29).addBox(-2.0F, 15.0454F, -5.5628F, 3.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(12.0F, -8.0F, 0.0F));
		leftLeg.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(0, 66).addBox(-1.5F, -3.5F, -2.0F, 3.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, 13.5F, 0.25F, -0.3927F, 0.0F, 0.0F));
		leftLeg.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(58, 42).addBox(-1.5F, -2.5F, -3.5F, 3.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, 10.5F, -2.5F, -0.3927F, 0.0F, 0.0F));
		leftLeg.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(54, 56).addBox(-2.5F, -2.5F, 0.0F, 5.0F, 11.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, 0.5F, -3.0F, -0.3927F, 0.0F, 0.0F));

		PartDefinition torso = Body.addOrReplaceChild("torso", CubeListBuilder.create().texOffs(0, 36).addBox(-5.0F, -24.0678F, -4.9677F, 10.0F, 2.9149F, 12.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));
		torso.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(40, 51).addBox(-1.25F, -0.125F, -2.0F, 2.5F, 1.5F, 5.9655F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -12.785F, 17.0345F, -0.7854F, 0.0F, 0.0F));
		torso.addOrReplaceChild("cube_r14", CubeListBuilder.create().texOffs(35, 0).addBox(-1.25F, -1.5F, -1.5F, 2.5F, 2.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -15.5F, 9.5F, -0.3927F, 0.0F, 0.0F));
		torso.addOrReplaceChild("cube_r15", CubeListBuilder.create().texOffs(0, 0).addBox(-6.0F, -3.2074F, -4.5F, 12.0F, 8.4149F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -27.7926F, -2.8357F, 0.3927F, 0.0F, 0.0F));
		torso.addOrReplaceChild("cube_r16", CubeListBuilder.create().texOffs(0, 19).addBox(-7.0F, -3.7074F, -3.5F, 14.0F, 7.4149F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -27.2059F, 1.7858F, -0.7854F, 0.0F, 0.0F));
		torso.addOrReplaceChild("cube_r17", CubeListBuilder.create().texOffs(41, 14).addBox(-5.5F, -5.0F, -1.5F, 10.0F, 10.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, -19.0F, 5.5F, 0.3927F, 0.0F, 0.0F));

		PartDefinition head = Body.addOrReplaceChild("head", CubeListBuilder.create().texOffs(41, 29).addBox(-4.0F, -4.0F, -7.3357F, 8.0F, 6.4149F, 7.0F, new CubeDeformation(0.0F))
		.texOffs(61, 0).addBox(-2.0F, 0.0F, -12.3357F, 4.0F, 2.4149F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -27.0F, -5.0F));
		
		head.addOrReplaceChild("cube_r18", CubeListBuilder.create().texOffs(35, 2).addBox(-0.125F, 0.0F, -0.5F, 0.5F, 2.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(29, 67).addBox(-8.625F, 0.0F, -0.5F, 0.5F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.125F, -3.5F, -4.0F, 0.7854F, 0.0F, 0.0F));

		head.addOrReplaceChild("cube_r19", CubeListBuilder.create().texOffs(73, 1).addBox(-2.0F, -0.4574F, -3.5F, 4.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.4574F, -7.8357F, 0.7854F, 0.0F, 0.0F));

		PartDefinition teeths = head.addOrReplaceChild("teeths", CubeListBuilder.create().texOffs(24, 80).addBox(0.75F, -11.1418F, -20.8046F, 0.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(21, 80).addBox(-2.5F, -11.1418F, -20.8046F, 0.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(21, 80).addBox(-2.5F, -12.1418F, -18.3046F, 0.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(21, 80).addBox(-2.5F, -11.6418F, -19.5546F, 0.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(21, 80).addBox(0.75F, -12.1418F, -18.3046F, 0.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(21, 80).addBox(0.75F, -11.6418F, -19.5546F, 0.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(1.0F, 12.648F, 8.7716F));

		teeths.addOrReplaceChild("cube_r20", CubeListBuilder.create().texOffs(11, 80).addBox(0.0F, -0.5F, -1.25F, 0.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(11, 80).addBox(0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(11, 80).addBox(0.0F, 0.25F, 1.25F, 0.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(11, 80).addBox(-3.25F, 0.25F, 1.25F, 0.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(11, 80).addBox(-3.25F, 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(11, 80).addBox(-3.25F, -0.5F, -1.25F, 0.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, -8.648F, -18.5216F, 0.7854F, 0.0F, 0.0F));

		PartDefinition claws = Body.addOrReplaceChild("claws", CubeListBuilder.create(), PartPose.offset(-8.0F, -8.0F, 8.0F));

		 claws.addOrReplaceChild("cube_r21", CubeListBuilder.create().texOffs(8, 80).addBox(-14.125F, -0.5F, 0.25F, 0.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(7, 80).addBox(-14.125F, -0.5F, -1.0F, 0.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(6, 80).addBox(-14.125F, -0.5F, -2.25F, 0.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(6, 80).addBox(-0.125F, -0.5F, -2.25F, 0.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(7, 80).addBox(-0.125F, -0.5F, -1.0F, 0.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(8, 80).addBox(-0.125F, -0.5F, 0.25F, 0.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(15.125F, 2.5F, -17.25F, -0.3927F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 128, 128);
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
	
	private record ModelParts(ModelPart body, ModelPart head, ModelPart legs, ModelPart leftLeg, ModelPart rightLeg) {
		
	}
}