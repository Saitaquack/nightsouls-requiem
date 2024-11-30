package com.saita.legendsawaken.entities.models;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.saita.legendsawaken.LegendsAwakenMod;
import com.saita.legendsawaken.entities.mobs.WendigoEntity;

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

public class WendigoModel<T extends WendigoEntity> extends EntityModel<T> {
	
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(LegendsAwakenMod.MOD_ID, "wendigo_entity"), "main");

	private final ModelParts parts;

	public WendigoModel(ModelPart root) {
		ModelPart body = root.getChild("body");
		ModelPart head = body.getChild("head");
		ModelPart leftArm = body.getChild("left_arm");
		ModelPart rightArm = body.getChild("right_arm");
		ModelPart leftLeg = body.getChild("left_leg");
		ModelPart rightLeg = body.getChild("right_leg");	
		
		this.parts = new ModelParts(body, head, leftArm, rightArm, leftLeg, rightLeg);
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0896F, 2.6876F));

		body.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(0, 95).addBox(-3.8F, -2.9F, -2.8F, 7.6F, 7.8F, 6.6F, new CubeDeformation(0.25F)), PartPose.offsetAndRotation(0.0F, -7.6113F, -1.2221F, 0.3927F, 0.0F, 0.0F));
		body.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(0, 0).addBox(-8.8F, 0.0F, -5.8F, 17.6F, 0.0F, 15.6F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -16.5555F, -6.7034F, 0.3927F, 0.0F, 0.0F));
		body.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(0, 35).addBox(-5.8F, -6.2F, 1.8F, 11.6F, 6.8F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -16.7289F, 3.4796F, 1.3963F, 0.0F, 0.0F));
		body.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(0, 0).addBox(-8.8F, 0.0F, -7.8F, 17.6F, 0.0F, 15.6F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -16.5555F, -6.7034F, 0.8727F, 0.0F, 0.0F));
		body.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(90, 29).addBox(-5.8F, -6.9F, 0.9F, 11.6F, 6.8F, 0.1F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -15.0494F, 4.1347F, 0.9599F, 0.0F, 0.0F));
		body.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(41, 85).addBox(-5.8F, -7.4F, 0.25F, 11.6F, 9.8F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -11.7109F, 3.7256F, 0.6109F, 0.0F, 0.0F));
		body.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(26, 25).addBox(-4.8F, -3.4F, -5.25F, 9.6F, 6.8F, 10.5F, new CubeDeformation(0.25F)), PartPose.offsetAndRotation(0.0F, -13.493F, -2.4245F, 0.3927F, 0.0F, 0.0F));
		body.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(32, 50).addBox(-1.8F, -4.9F, -5.2F, 3.6F, 9.8F, 10.0F, new CubeDeformation(0.25F)), PartPose.offsetAndRotation(4.3295F, -12.1729F, -2.473F, 0.3806F, -0.0992F, 0.2427F));
		body.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(58, 55).addBox(-1.8F, -4.9F, -5.2F, 3.6F, 9.8F, 10.0F, new CubeDeformation(0.25F)), PartPose.offsetAndRotation(-4.3295F, -12.1729F, -2.473F, 0.3806F, 0.0992F, -0.2427F));
		body.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(48, 41).addBox(-3.8F, -0.9F, -4.8F, 7.6F, 5.8F, 9.6F, new CubeDeformation(0.25F)), PartPose.offsetAndRotation(0.0F, -17.1392F, -6.5662F, 0.9599F, 0.0F, 0.0F));
		body.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(80, 13).addBox(-2.8F, -0.4F, -2.5F, 5.6F, 8.8F, 5.3F, new CubeDeformation(0.5F)), PartPose.offsetAndRotation(0.0F, -1.5963F, -0.3446F, -0.2618F, 0.0F, 0.0F));
		body.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(0, 64).addBox(-1.8F, -4.9F, -5.2F, 3.6F, 9.8F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.3295F, -12.1729F, -2.473F, 0.3806F, 0.0992F, -0.2427F));
		body.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(64, 21).addBox(-1.8F, -4.9F, -5.2F, 3.6F, 9.8F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.3295F, -12.1729F, -2.473F, 0.3806F, -0.0992F, 0.2427F));
		body.addOrReplaceChild("cube_r14", CubeListBuilder.create().texOffs(0, 50).addBox(-3.8F, -0.9F, -4.8F, 7.6F, 5.8F, 9.6F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -17.1392F, -6.5662F, 0.9599F, 0.0F, 0.0F));
		body.addOrReplaceChild("cube_r15", CubeListBuilder.create().texOffs(67, 0).addBox(-3.8F, -2.9F, -2.8F, 7.6F, 7.8F, 6.6F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -7.6113F, -1.2221F, 0.3927F, 0.0F, 0.0F));
		body.addOrReplaceChild("cube_r16", CubeListBuilder.create().texOffs(39, 5).addBox(-4.8F, -6.9F, -3.7F, 9.6F, 6.8F, 10.5F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -9.6663F, -2.5172F, 0.3927F, 0.0F, 0.0F));
		body.addOrReplaceChild("cube_r17", CubeListBuilder.create().texOffs(21, 80).addBox(-2.8F, -3.4F, -2.5F, 5.6F, 8.8F, 5.3F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.5963F, -0.3446F, -0.2618F, 0.0F, 0.0F));

		PartDefinition head = body.addOrReplaceChild("head", CubeListBuilder.create(), PartPose.offset(0.0F, -15.015F, -7.8792F));

		head.addOrReplaceChild("cube_r18", CubeListBuilder.create().texOffs(0, 22).addBox(-1.9F, -7.6F, -0.2F, 3.8F, 5.0F, 2.0F, new CubeDeformation(0.25F))
		.texOffs(0, 29).addBox(-1.7F, -7.4F, -2.2F, 3.4F, 4.8F, 2.0F, new CubeDeformation(0.24F))
		.texOffs(39, 113).addBox(-1.9F, -7.6F, -0.2F, 3.8F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -5.8153F, -1.1603F, 1.6581F, 0.0F, 0.0F));

		head.addOrReplaceChild("cube_r19", CubeListBuilder.create().texOffs(0, 15).addBox(-0.4488F, 3.0459F, -4.8F, 13.6F, 0.0F, 10.6F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -13.7936F, 1.8929F, 0.8576F, 0.3751F, -0.3069F));
		head.addOrReplaceChild("cube_r20", CubeListBuilder.create().texOffs(0, 25).addBox(-13.1512F, 3.0459F, -4.8F, 13.6F, 0.0F, 10.6F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -13.7936F, 1.8929F, 0.8576F, -0.3751F, 0.3069F));
		head.addOrReplaceChild("cube_r21", CubeListBuilder.create().texOffs(0, 41).addBox(-12.1512F, 3.0459F, -4.8F, 12.6F, 0.0F, 9.6F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -14.6421F, -2.0669F, 1.2774F, -0.4623F, 0.1339F));
		head.addOrReplaceChild("cube_r22", CubeListBuilder.create().texOffs(24, 41).addBox(-0.4488F, 3.0459F, -4.8F, 12.6F, 0.0F, 9.6F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -14.6421F, -2.0669F, 1.2774F, 0.4623F, -0.1339F));

		head.addOrReplaceChild("cube_r23", CubeListBuilder.create().texOffs(74, 48).addBox(-2.8F, -2.4F, -2.8F, 5.6F, 6.8F, 7.0F, new CubeDeformation(0.25F))
		.texOffs(66, 74).addBox(-2.8F, -2.4F, -2.8F, 5.6F, 6.8F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -5.7979F, -1.3595F, 1.6581F, 0.0F, 0.0F));

		head.addOrReplaceChild("cube_r24", CubeListBuilder.create().texOffs(49, 106).addBox(-1.8F, -0.9F, -3.3F, 3.6F, 5.8F, 4.6F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.6018F, -0.5216F, 0.5236F, 0.0F, 0.0F));

		PartDefinition jaw = head.addOrReplaceChild("jaw", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -3.495F, -2.2318F, 0.3927F, 0.0F, 0.0F));

		jaw.addOrReplaceChild("cube_r25", CubeListBuilder.create().texOffs(0, 15).addBox(-2.3F, -5.3676F, -0.9173F, 4.6F, 6.4F, 1.6F, new CubeDeformation(0.25F))
		.texOffs(73, 112).addBox(-2.3F, -5.3676F, 0.2827F, 4.6F, 5.4F, 2.0F, new CubeDeformation(-0.001F))
		.texOffs(0, 64).addBox(-2.3F, -5.3676F, -0.9173F, 4.6F, 6.4F, 1.6F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.3302F, -0.7368F, 2.0071F, 0.0F, 0.0F));

		PartDefinition left_arm = body.addOrReplaceChild("left_arm", CubeListBuilder.create(), PartPose.offset(5.7955F, -11.6318F, -2.6094F));

		left_arm.addOrReplaceChild("cube_r26", CubeListBuilder.create().texOffs(93, 0).addBox(-0.0653F, -3.5605F, -3.1827F, 5.6F, 5.8F, 5.6F, new CubeDeformation(0.5F))
		.texOffs(91, 46).addBox(5.5347F, -2.5605F, -2.1827F, 7.6F, 3.8F, 4.6F, new CubeDeformation(0.25F)), PartPose.offsetAndRotation(-0.5423F, -0.7836F, 0.4502F, 0.504F, 0.0596F, 0.6273F));

		left_arm.addOrReplaceChild("cube_r27", CubeListBuilder.create().texOffs(105, 84).addBox(5.5347F, -2.5605F, -2.1827F, 7.6F, 3.8F, 3.6F, new CubeDeformation(0.0F))
		.texOffs(55, 96).addBox(-0.0653F, -3.5605F, -3.1827F, 5.6F, 5.8F, 5.6F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5423F, -0.7836F, 0.4502F, 0.504F, 0.0596F, 0.6273F));

		PartDefinition left_arm_down = left_arm.addOrReplaceChild("left_arm_down", CubeListBuilder.create(), PartPose.offset(10.1617F, 6.3477F, -0.6784F));

		left_arm_down.addOrReplaceChild("cube_r28", CubeListBuilder.create().texOffs(54, 21).addBox(-1.5F, -1.5F, -3.5F, 3.0F, 3.0F, 7.0F, new CubeDeformation(0.25F)), PartPose.offsetAndRotation(4.6846F, 4.7172F, -2.6254F, 0.9853F, -0.954F, -0.2939F));
		left_arm_down.addOrReplaceChild("cube_r29", CubeListBuilder.create().texOffs(100, 10).addBox(-3.0F, -2.0F, -1.5F, 4.0F, 4.0F, 5.0F, new CubeDeformation(0.25F)), PartPose.offsetAndRotation(1.874F, 1.2139F, -0.2115F, 0.9853F, -0.954F, -0.2939F));
		left_arm_down.addOrReplaceChild("cube_r30", CubeListBuilder.create().texOffs(78, 93).addBox(-1.5F, -1.5F, -3.5F, 3.0F, 3.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.6846F, 4.7172F, -2.6254F, 0.9853F, -0.954F, -0.2939F));
		left_arm_down.addOrReplaceChild("cube_r31", CubeListBuilder.create().texOffs(31, 104).addBox(-3.0F, -1.9F, -1.5F, 4.0F, 4.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.874F, 1.2139F, -0.2115F, 0.9853F, -0.954F, -0.2939F));

		PartDefinition left_finger1 = left_arm_down.addOrReplaceChild("left_finger1", CubeListBuilder.create(), PartPose.offset(7.1396F, 6.1272F, -5.2056F));

		left_finger1.addOrReplaceChild("cube_r32", CubeListBuilder.create().texOffs(71, 33).addBox(-1.2815F, -0.539F, -6.5072F, 0.0F, 4.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.4F, 0.2F, 0.5F, 1.1814F, -0.8998F, 0.0596F));

		PartDefinition left_finger3 = left_arm_down.addOrReplaceChild("left_finger3", CubeListBuilder.create(), PartPose.offset(8.4215F, 6.0781F, -3.2279F));

		left_finger3.addOrReplaceChild("cube_r33", CubeListBuilder.create().texOffs(16, 57).addBox(1.2185F, -0.539F, -6.5072F, 0.0F, 4.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.1181F, 0.2491F, -1.4778F, 1.7118F, -0.9509F, -0.5957F));

		PartDefinition left_finger2 = left_arm_down.addOrReplaceChild("left_finger2", CubeListBuilder.create(), PartPose.offset(7.9628F, 6.0356F, -4.5964F));

		left_finger2.addOrReplaceChild("cube_r34", CubeListBuilder.create().texOffs(48, 48).addBox(-0.1815F, -0.539F, -6.5072F, 0.0F, 4.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5768F, 0.2916F, -0.1092F, 1.4653F, -0.954F, -0.2939F));

		PartDefinition big_finger_left = left_arm_down.addOrReplaceChild("big_finger_left", CubeListBuilder.create(), PartPose.offset(3.7821F, 4.9626F, -2.7775F));

		big_finger_left.addOrReplaceChild("cube_r35", CubeListBuilder.create().texOffs(23, 42).addBox(1.7722F, 0.1797F, -8.0944F, 0.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, 0.0F, 0.0F, 0.7922F, 1.0258F, -0.6008F));

		PartDefinition right_arm = body.addOrReplaceChild("right_arm", CubeListBuilder.create(), PartPose.offset(-6.0556F, -11.5394F, -2.6094F));

		right_arm.addOrReplaceChild("cube_r36", CubeListBuilder.create().texOffs(91, 93).addBox(-13.1347F, -2.5605F, -2.1827F, 7.6F, 3.8F, 4.6F, new CubeDeformation(0.25F))
		.texOffs(44, 118).addBox(-5.5347F, -3.5605F, -3.1827F, 5.6F, 5.8F, 5.6F, new CubeDeformation(0.5F)), PartPose.offsetAndRotation(0.8023F, -0.876F, 0.4502F, 0.504F, -0.0596F, -0.6273F));

		right_arm.addOrReplaceChild("cube_r37", CubeListBuilder.create().texOffs(35, 94).addBox(-5.5347F, -3.5605F, -3.1827F, 5.6F, 5.8F, 5.6F, new CubeDeformation(0.0F))
		.texOffs(104, 53).addBox(-13.1347F, -2.5605F, -2.1827F, 7.6F, 3.8F, 3.6F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.8023F, -0.876F, 0.4502F, 0.504F, -0.0596F, -0.6273F));

		PartDefinition right_arm_down = right_arm.addOrReplaceChild("right_arm_down", CubeListBuilder.create(), PartPose.offset(-9.9017F, 6.2552F, -1.6784F));

		right_arm_down.addOrReplaceChild("cube_r38", CubeListBuilder.create().texOffs(0, 119).addBox(-1.0F, -2.0F, -1.5F, 4.0F, 4.0F, 5.0F, new CubeDeformation(0.25F)), PartPose.offsetAndRotation(-1.874F, 1.2139F, 0.7885F, 0.9853F, 0.954F, 0.2939F));
		right_arm_down.addOrReplaceChild("cube_r39", CubeListBuilder.create().texOffs(91, 54).addBox(-1.5F, -1.5F, -3.5F, 3.0F, 3.0F, 7.0F, new CubeDeformation(0.25F)), PartPose.offsetAndRotation(-4.6846F, 4.7172F, -1.6254F, 0.9853F, 0.954F, 0.2939F));
		right_arm_down.addOrReplaceChild("cube_r40", CubeListBuilder.create().texOffs(93, 19).addBox(-1.5F, -1.5F, -3.5F, 3.0F, 3.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.6846F, 4.7172F, -1.6254F, 0.9853F, 0.954F, 0.2939F));
		right_arm_down.addOrReplaceChild("cube_r41", CubeListBuilder.create().texOffs(70, 103).addBox(-1.0F, -1.9F, -1.5F, 4.0F, 4.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.874F, 1.2139F, 0.7885F, 0.9853F, 0.954F, 0.2939F));

		PartDefinition big_finger_right = right_arm_down.addOrReplaceChild("big_finger_right", CubeListBuilder.create(), PartPose.offset(-4.1194F, 5.7501F, -2.9792F));

		big_finger_right.addOrReplaceChild("cube_r42", CubeListBuilder.create().texOffs(36, 13).addBox(-1.7722F, 0.1797F, -8.0944F, 0.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.3374F, -0.7875F, 1.2016F, 0.7922F, -1.0258F, 0.6008F));

		PartDefinition right_finger2 = right_arm_down.addOrReplaceChild("right_finger2", CubeListBuilder.create(), PartPose.offset(-7.5396F, 6.3272F, -3.7056F));

		right_finger2.addOrReplaceChild("cube_r43", CubeListBuilder.create().texOffs(23, 47).addBox(0.1815F, -0.539F, -6.5072F, 0.0F, 4.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, 0.0F, 0.0F, 1.4653F, 0.954F, 0.2939F));

		PartDefinition right_finger3 = right_arm_down.addOrReplaceChild("right_finger3", CubeListBuilder.create(), PartPose.offset(-8.5396F, 6.3272F, -3.7056F));

		right_finger3.addOrReplaceChild("cube_r44", CubeListBuilder.create().texOffs(0, 4).addBox(-1.2185F, -0.539F, -6.5072F, 0.0F, 4.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 1.7118F, 0.9509F, 0.5957F));

		PartDefinition right_finger1 = right_arm_down.addOrReplaceChild("right_finger1", CubeListBuilder.create(), PartPose.offset(-7.0812F, 6.6007F, -3.7787F));

		right_finger1.addOrReplaceChild("cube_r45", CubeListBuilder.create().texOffs(0, 0).addBox(1.2815F, -0.539F, -6.5072F, 0.0F, 4.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.4584F, -0.2735F, 0.073F, 1.1814F, 0.8998F, -0.0596F));

		PartDefinition right_leg = body.addOrReplaceChild("right_leg", CubeListBuilder.create(), PartPose.offset(-3.275F, 2.2971F, -0.3639F));

		right_leg.addOrReplaceChild("cube_r46", CubeListBuilder.create().texOffs(0, 83).addBox(-7.85F, -7.5F, -1.6F, 5.0F, 7.8F, 5.6F, new CubeDeformation(0.25F)), PartPose.offsetAndRotation(3.325F, 2.2652F, -3.9622F, -0.7854F, 0.0F, 0.0F));

		right_leg.addOrReplaceChild("cube_r47", CubeListBuilder.create().texOffs(85, 110).addBox(-7.35F, -1.5F, -0.6F, 4.1F, 4.8F, 3.6F, new CubeDeformation(0.5F)), PartPose.offsetAndRotation(3.325F, 2.1237F, -3.8208F, -0.7854F, 0.0F, 0.0F));
		right_leg.addOrReplaceChild("cube_r48", CubeListBuilder.create().texOffs(85, 35).addBox(-7.85F, -7.5F, -1.6F, 5.0F, 6.8F, 5.6F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.325F, 2.2652F, -3.9622F, -0.7854F, 0.0F, 0.0F));
		right_leg.addOrReplaceChild("cube_r49", CubeListBuilder.create().texOffs(110, 97).addBox(-7.35F, -1.5F, -0.6F, 4.1F, 4.8F, 3.6F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.325F, 2.1237F, -3.8208F, -0.7854F, 0.0F, 0.0F));

		PartDefinition right_leg_down = right_leg.addOrReplaceChild("right_leg_down", CubeListBuilder.create(), PartPose.offset(-2.155F, 5.5752F, -4.7225F));

		right_leg_down.addOrReplaceChild("cube_r50", CubeListBuilder.create().texOffs(109, 44).addBox(-7.35F, -1.9F, -1.8F, 4.1F, 3.8F, 3.6F, new CubeDeformation(0.25F)), PartPose.offsetAndRotation(5.48F, -0.0648F, -0.0681F, 0.1745F, 0.0F, 0.0F));
		right_leg_down.addOrReplaceChild("cube_r51", CubeListBuilder.create().texOffs(99, 113).addBox(-7.35F, -1.9F, -1.8F, 4.1F, 3.8F, 3.6F, new CubeDeformation(-0.001F)), PartPose.offsetAndRotation(5.48F, -0.0648F, -0.0681F, 0.1745F, 0.0F, 0.0F));
		right_leg_down.addOrReplaceChild("cube_r52", CubeListBuilder.create().texOffs(103, 104).addBox(-12.6F, -0.9874F, -0.3395F, 3.6F, 3.8F, 6.6F, new CubeDeformation(-0.01F)), PartPose.offsetAndRotation(10.93F, 4.5014F, 3.7622F, 2.4435F, 0.0F, 0.0F));

		PartDefinition right_foot = right_leg_down.addOrReplaceChild("right_foot", CubeListBuilder.create().texOffs(59, 111).addBox(-1.5F, 8.2371F, -5.1563F, 3.0F, 3.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(109, 60).addBox(-1.5F, 8.2371F, -5.1563F, 3.0F, 3.0F, 4.0F, new CubeDeformation(0.25F)), PartPose.offset(-0.07F, 4.8011F, 5.5551F));

		right_foot.addOrReplaceChild("cube_r53", CubeListBuilder.create().texOffs(0, 46).addBox(-1.3F, -0.2977F, -9.7681F, 2.6F, 3.3F, 2.6F, new CubeDeformation(0.25F)), PartPose.offsetAndRotation(0.0F, -0.2258F, 0.2143F, 1.1345F, 0.0F, 0.0F));

		right_foot.addOrReplaceChild("cube_r54", CubeListBuilder.create().texOffs(98, 64).addBox(-1.0F, -1.4252F, -7.8988F, 2.0F, 3.0F, 7.6F, new CubeDeformation(0.25F))
		.texOffs(100, 74).addBox(-1.0F, -1.4252F, -7.8988F, 2.0F, 3.0F, 7.6F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.2258F, 0.2143F, 1.309F, 0.0F, 0.0F));

		right_foot.addOrReplaceChild("cube_r55", CubeListBuilder.create().texOffs(106, 19).addBox(-2.0F, -2.6176F, -1.673F, 4.0F, 4.0F, 3.6F, new CubeDeformation(0.25F))
		.texOffs(112, 26).addBox(-2.0F, -2.6176F, -1.673F, 4.0F, 4.0F, 3.6F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.2258F, 0.2143F, 1.8326F, 0.0F, 0.0F));

		PartDefinition left_leg = body.addOrReplaceChild("left_leg", CubeListBuilder.create(), PartPose.offset(3.525F, 2.2971F, -0.3639F));

		left_leg.addOrReplaceChild("cube_r56", CubeListBuilder.create().texOffs(109, 90).addBox(3.25F, -1.5F, -0.6F, 4.1F, 4.8F, 3.6F, new CubeDeformation(0.5F)), PartPose.offsetAndRotation(-3.475F, 2.1237F, -3.8208F, -0.7854F, 0.0F, 0.0F));
		left_leg.addOrReplaceChild("cube_r57", CubeListBuilder.create().texOffs(83, 69).addBox(2.75F, -7.5F, -1.6F, 5.0F, 7.8F, 5.6F, new CubeDeformation(0.25F)), PartPose.offsetAndRotation(-3.475F, 2.2652F, -3.9622F, -0.7854F, 0.0F, 0.0F));
		left_leg.addOrReplaceChild("cube_r58", CubeListBuilder.create().texOffs(85, 82).addBox(2.75F, -7.5F, -1.6F, 5.0F, 6.8F, 5.6F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.475F, 2.2652F, -3.9622F, -0.7854F, 0.0F, 0.0F));
		left_leg.addOrReplaceChild("cube_r59", CubeListBuilder.create().texOffs(111, 74).addBox(3.25F, -1.5F, -0.6F, 4.1F, 4.8F, 3.6F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.475F, 2.1237F, -3.8208F, -0.7854F, 0.0F, 0.0F));

		PartDefinition left_leg_down = left_leg.addOrReplaceChild("left_leg_down", CubeListBuilder.create(), PartPose.offset(1.875F, 5.8119F, -4.1866F));

		left_leg_down.addOrReplaceChild("cube_r60", CubeListBuilder.create().texOffs(113, 7).addBox(-2.1F, -2.3018F, -2.3425F, 4.1F, 3.8F, 3.6F, new CubeDeformation(0.25F))
		.texOffs(25, 113).addBox(-2.1F, -2.3018F, -2.3425F, 4.1F, 3.8F, 3.6F, new CubeDeformation(-0.001F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.1745F, 0.0F, 0.0F));

		left_leg_down.addOrReplaceChild("cube_r61", CubeListBuilder.create().texOffs(105, 35).addBox(-1.9F, -2.1806F, -5.5523F, 3.6F, 3.8F, 6.6F, new CubeDeformation(-0.01F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 2.4435F, 0.0F, 0.0F));

		PartDefinition left_foot = left_leg_down.addOrReplaceChild("left_foot", CubeListBuilder.create().texOffs(113, 0).addBox(-1.5F, 8.291F, -4.6091F, 3.0F, 3.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(0, 108).addBox(-1.5F, 8.291F, -4.6091F, 3.0F, 3.0F, 4.0F, new CubeDeformation(0.25F)), PartPose.offset(0.1F, 4.5105F, 4.472F));

		left_foot.addOrReplaceChild("cube_r62", CubeListBuilder.create().texOffs(78, 118).addBox(-0.9F, 4.7529F, -10.735F, 2.0F, 3.0F, 7.6F, new CubeDeformation(0.25F))
		.texOffs(91, 100).addBox(-0.9F, 4.7529F, -10.735F, 2.0F, 3.0F, 7.6F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.1F, -4.5105F, -4.472F, 1.309F, 0.0F, 0.0F));

		left_foot.addOrReplaceChild("cube_r63", CubeListBuilder.create().texOffs(0, 41).addBox(-1.2F, 6.279F, -11.4885F, 2.6F, 3.3F, 2.6F, new CubeDeformation(0.25F)), PartPose.offsetAndRotation(-0.1F, -4.5105F, -4.472F, 1.1345F, 0.0F, 0.0F));

		left_foot.addOrReplaceChild("cube_r64", CubeListBuilder.create().texOffs(0, 0).addBox(-1.9F, 1.3146F, -7.2183F, 4.0F, 4.0F, 3.6F, new CubeDeformation(0.25F))
		.texOffs(11, 112).addBox(-1.9F, 1.3146F, -7.2183F, 4.0F, 4.0F, 3.6F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.1F, -4.5105F, -4.472F, 1.8326F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.parts.head().yRot = netHeadYaw * Mth.DEG_TO_RAD;
		this.parts.head().xRot = headPitch * Mth.DEG_TO_RAD;
		
		this.parts.leftLeg().xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
		this.parts.rightLeg().xRot = Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount;
		
		this.parts.rightArm().xRot = Mth.cos(limbSwing * 0.33F + (float)Math.PI) * 1.4F * limbSwingAmount;
        this.parts.leftArm().xRot = Mth.cos(limbSwing * 0.33F) * 1.4F * limbSwingAmount;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		this.parts.body().render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
	
	private record ModelParts(ModelPart body, ModelPart head, ModelPart leftArm, ModelPart rightArm, ModelPart leftLeg, ModelPart rightLeg) {
		
	}
}