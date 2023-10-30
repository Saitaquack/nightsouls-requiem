package com.saita.nightsoulsmod.entities.model;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.saita.nightsoulsmod.entities.entity.WindigoEntity;

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;

public class WindigoModel <T extends WindigoEntity> extends EntityModel<T> {
	
	private final ModelRenderer body;
	private final ModelRenderer cube_r1;
	private final ModelRenderer cube_r2;
	private final ModelRenderer cube_r3;
	private final ModelRenderer cube_r4;
	private final ModelRenderer cube_r5;
	private final ModelRenderer cube_r6;
	private final ModelRenderer cube_r7;
	private final ModelRenderer cube_r8;
	private final ModelRenderer cube_r9;
	private final ModelRenderer cube_r10;
	private final ModelRenderer cube_r11;
	private final ModelRenderer cube_r12;
	private final ModelRenderer cube_r13;
	private final ModelRenderer cube_r14;
	private final ModelRenderer cube_r15;
	private final ModelRenderer cube_r16;
	private final ModelRenderer cube_r17;
	private final ModelRenderer head;
	private final ModelRenderer cube_r18;
	private final ModelRenderer cube_r19;
	private final ModelRenderer cube_r20;
	private final ModelRenderer cube_r21;
	private final ModelRenderer cube_r22;
	private final ModelRenderer cube_r23;
	private final ModelRenderer cube_r24;
	private final ModelRenderer jaw;
	private final ModelRenderer cube_r25;
	private final ModelRenderer left_arm;
	private final ModelRenderer cube_r26;
	private final ModelRenderer cube_r27;
	private final ModelRenderer left_arm_down;
	private final ModelRenderer cube_r28;
	private final ModelRenderer cube_r29;
	private final ModelRenderer cube_r30;
	private final ModelRenderer cube_r31;
	private final ModelRenderer left_finger1;
	private final ModelRenderer cube_r32;
	private final ModelRenderer left_finger3;
	private final ModelRenderer cube_r33;
	private final ModelRenderer left_finger2;
	private final ModelRenderer cube_r34;
	private final ModelRenderer big_finger_left;
	private final ModelRenderer cube_r35;
	private final ModelRenderer right_arm;
	private final ModelRenderer cube_r36;
	private final ModelRenderer cube_r37;
	private final ModelRenderer right_arm_down;
	private final ModelRenderer cube_r38;
	private final ModelRenderer cube_r39;
	private final ModelRenderer cube_r40;
	private final ModelRenderer cube_r41;
	private final ModelRenderer big_finger_right;
	private final ModelRenderer cube_r42;
	private final ModelRenderer right_finger2;
	private final ModelRenderer cube_r43;
	private final ModelRenderer right_finger3;
	private final ModelRenderer cube_r44;
	private final ModelRenderer right_finger1;
	private final ModelRenderer cube_r45;
	private final ModelRenderer right_leg;
	private final ModelRenderer cube_r46;
	private final ModelRenderer cube_r47;
	private final ModelRenderer cube_r48;
	private final ModelRenderer cube_r49;
	private final ModelRenderer right_leg_down;
	private final ModelRenderer cube_r50;
	private final ModelRenderer cube_r51;
	private final ModelRenderer cube_r52;
	private final ModelRenderer right_foot;
	private final ModelRenderer cube_r53;
	private final ModelRenderer cube_r54;
	private final ModelRenderer cube_r55;
	private final ModelRenderer left_leg;
	private final ModelRenderer cube_r56;
	private final ModelRenderer cube_r57;
	private final ModelRenderer cube_r58;
	private final ModelRenderer cube_r59;
	private final ModelRenderer left_leg_down;
	private final ModelRenderer cube_r60;
	private final ModelRenderer cube_r61;
	private final ModelRenderer left_foot;
	private final ModelRenderer cube_r62;
	private final ModelRenderer cube_r63;
	private final ModelRenderer cube_r64;

	public WindigoModel() {
		textureWidth = 128;
		textureHeight = 128;

		textureWidth = 128;
		textureHeight = 128;

		body = new ModelRenderer(this);
		body.setRotationPoint(0.0F, 0.0896F, 2.6876F);
		

		cube_r1 = new ModelRenderer(this);
		cube_r1.setRotationPoint(0.0F, -7.6113F, -1.2221F);
		body.addChild(cube_r1);
		setRotationAngle(cube_r1, 0.3927F, 0.0F, 0.0F);
		cube_r1.setTextureOffset(0, 95).addBox(-3.8F, -2.9F, -2.8F, 7.6F, 7.8F, 6.6F, 0.25F, false);

		cube_r2 = new ModelRenderer(this);
		cube_r2.setRotationPoint(0.0F, -16.5555F, -6.7034F);
		body.addChild(cube_r2);
		setRotationAngle(cube_r2, 0.3927F, 0.0F, 0.0F);
		cube_r2.setTextureOffset(0, 0).addBox(-8.8F, 0.0F, -5.8F, 17.6F, 0.0F, 15.6F, 0.0F, false);

		cube_r3 = new ModelRenderer(this);
		cube_r3.setRotationPoint(0.0F, -16.7289F, 3.4796F);
		body.addChild(cube_r3);
		setRotationAngle(cube_r3, 1.3963F, 0.0F, 0.0F);
		cube_r3.setTextureOffset(0, 35).addBox(-5.8F, -6.2F, 1.8F, 11.6F, 6.8F, 0.0F, 0.0F, false);

		cube_r4 = new ModelRenderer(this);
		cube_r4.setRotationPoint(0.0F, -16.5555F, -6.7034F);
		body.addChild(cube_r4);
		setRotationAngle(cube_r4, 0.8727F, 0.0F, 0.0F);
		cube_r4.setTextureOffset(0, 0).addBox(-8.8F, 0.0F, -7.8F, 17.6F, 0.0F, 15.6F, 0.0F, false);

		cube_r5 = new ModelRenderer(this);
		cube_r5.setRotationPoint(0.0F, -15.0494F, 4.1347F);
		body.addChild(cube_r5);
		setRotationAngle(cube_r5, 0.9599F, 0.0F, 0.0F);
		cube_r5.setTextureOffset(90, 29).addBox(-5.8F, -6.9F, 0.9F, 11.6F, 6.8F, 0.1F, 0.0F, false);

		cube_r6 = new ModelRenderer(this);
		cube_r6.setRotationPoint(0.0F, -11.7109F, 3.7256F);
		body.addChild(cube_r6);
		setRotationAngle(cube_r6, 0.6109F, 0.0F, 0.0F);
		cube_r6.setTextureOffset(41, 85).addBox(-5.8F, -7.4F, 0.25F, 11.6F, 9.8F, 0.0F, 0.0F, false);

		cube_r7 = new ModelRenderer(this);
		cube_r7.setRotationPoint(0.0F, -13.493F, -2.4245F);
		body.addChild(cube_r7);
		setRotationAngle(cube_r7, 0.3927F, 0.0F, 0.0F);
		cube_r7.setTextureOffset(26, 25).addBox(-4.8F, -3.4F, -5.25F, 9.6F, 6.8F, 10.5F, 0.25F, false);

		cube_r8 = new ModelRenderer(this);
		cube_r8.setRotationPoint(4.3295F, -12.1729F, -2.473F);
		body.addChild(cube_r8);
		setRotationAngle(cube_r8, 0.3806F, -0.0992F, 0.2427F);
		cube_r8.setTextureOffset(32, 50).addBox(-1.8F, -4.9F, -5.2F, 3.6F, 9.8F, 10.0F, 0.25F, false);

		cube_r9 = new ModelRenderer(this);
		cube_r9.setRotationPoint(-4.3295F, -12.1729F, -2.473F);
		body.addChild(cube_r9);
		setRotationAngle(cube_r9, 0.3806F, 0.0992F, -0.2427F);
		cube_r9.setTextureOffset(58, 55).addBox(-1.8F, -4.9F, -5.2F, 3.6F, 9.8F, 10.0F, 0.25F, false);

		cube_r10 = new ModelRenderer(this);
		cube_r10.setRotationPoint(0.0F, -17.1392F, -6.5662F);
		body.addChild(cube_r10);
		setRotationAngle(cube_r10, 0.9599F, 0.0F, 0.0F);
		cube_r10.setTextureOffset(48, 41).addBox(-3.8F, -0.9F, -4.8F, 7.6F, 5.8F, 9.6F, 0.25F, false);

		cube_r11 = new ModelRenderer(this);
		cube_r11.setRotationPoint(0.0F, -1.5963F, -0.3446F);
		body.addChild(cube_r11);
		setRotationAngle(cube_r11, -0.2618F, 0.0F, 0.0F);
		cube_r11.setTextureOffset(80, 13).addBox(-2.8F, -0.4F, -2.5F, 5.6F, 8.8F, 5.3F, 0.5F, false);

		cube_r12 = new ModelRenderer(this);
		cube_r12.setRotationPoint(-4.3295F, -12.1729F, -2.473F);
		body.addChild(cube_r12);
		setRotationAngle(cube_r12, 0.3806F, 0.0992F, -0.2427F);
		cube_r12.setTextureOffset(0, 64).addBox(-1.8F, -4.9F, -5.2F, 3.6F, 9.8F, 10.0F, 0.0F, false);

		cube_r13 = new ModelRenderer(this);
		cube_r13.setRotationPoint(4.3295F, -12.1729F, -2.473F);
		body.addChild(cube_r13);
		setRotationAngle(cube_r13, 0.3806F, -0.0992F, 0.2427F);
		cube_r13.setTextureOffset(64, 21).addBox(-1.8F, -4.9F, -5.2F, 3.6F, 9.8F, 10.0F, 0.0F, false);

		cube_r14 = new ModelRenderer(this);
		cube_r14.setRotationPoint(0.0F, -17.1392F, -6.5662F);
		body.addChild(cube_r14);
		setRotationAngle(cube_r14, 0.9599F, 0.0F, 0.0F);
		cube_r14.setTextureOffset(0, 50).addBox(-3.8F, -0.9F, -4.8F, 7.6F, 5.8F, 9.6F, 0.0F, false);

		cube_r15 = new ModelRenderer(this);
		cube_r15.setRotationPoint(0.0F, -7.6113F, -1.2221F);
		body.addChild(cube_r15);
		setRotationAngle(cube_r15, 0.3927F, 0.0F, 0.0F);
		cube_r15.setTextureOffset(67, 0).addBox(-3.8F, -2.9F, -2.8F, 7.6F, 7.8F, 6.6F, 0.0F, false);

		cube_r16 = new ModelRenderer(this);
		cube_r16.setRotationPoint(0.0F, -9.6663F, -2.5172F);
		body.addChild(cube_r16);
		setRotationAngle(cube_r16, 0.3927F, 0.0F, 0.0F);
		cube_r16.setTextureOffset(39, 5).addBox(-4.8F, -6.9F, -3.7F, 9.6F, 6.8F, 10.5F, 0.0F, false);

		cube_r17 = new ModelRenderer(this);
		cube_r17.setRotationPoint(0.0F, -1.5963F, -0.3446F);
		body.addChild(cube_r17);
		setRotationAngle(cube_r17, -0.2618F, 0.0F, 0.0F);
		cube_r17.setTextureOffset(21, 80).addBox(-2.8F, -3.4F, -2.5F, 5.6F, 8.8F, 5.3F, 0.0F, false);

		head = new ModelRenderer(this);
		head.setRotationPoint(0.0F, -15.015F, -7.8792F);
		body.addChild(head);
		

		cube_r18 = new ModelRenderer(this);
		cube_r18.setRotationPoint(0.0F, -5.8153F, -1.1603F);
		head.addChild(cube_r18);
		setRotationAngle(cube_r18, 1.6581F, 0.0F, 0.0F);
		cube_r18.setTextureOffset(0, 22).addBox(-1.9F, -7.6F, -0.2F, 3.8F, 5.0F, 2.0F, 0.25F, false);
		cube_r18.setTextureOffset(0, 29).addBox(-1.7F, -7.4F, -2.2F, 3.4F, 4.8F, 2.0F, 0.24F, false);
		cube_r18.setTextureOffset(39, 113).addBox(-1.9F, -7.6F, -0.2F, 3.8F, 5.0F, 2.0F, 0.0F, false);

		cube_r19 = new ModelRenderer(this);
		cube_r19.setRotationPoint(0.0F, -13.7936F, 1.8929F);
		head.addChild(cube_r19);
		setRotationAngle(cube_r19, 0.8576F, 0.3751F, -0.3069F);
		cube_r19.setTextureOffset(0, 15).addBox(-0.4488F, 3.0459F, -4.8F, 13.6F, 0.0F, 10.6F, 0.0F, false);

		cube_r20 = new ModelRenderer(this);
		cube_r20.setRotationPoint(0.0F, -13.7936F, 1.8929F);
		head.addChild(cube_r20);
		setRotationAngle(cube_r20, 0.8576F, -0.3751F, 0.3069F);
		cube_r20.setTextureOffset(0, 25).addBox(-13.1512F, 3.0459F, -4.8F, 13.6F, 0.0F, 10.6F, 0.0F, false);

		cube_r21 = new ModelRenderer(this);
		cube_r21.setRotationPoint(0.0F, -14.6421F, -2.0669F);
		head.addChild(cube_r21);
		setRotationAngle(cube_r21, 1.2774F, -0.4623F, 0.1339F);
		cube_r21.setTextureOffset(0, 41).addBox(-12.1512F, 3.0459F, -4.8F, 12.6F, 0.0F, 9.6F, 0.0F, false);

		cube_r22 = new ModelRenderer(this);
		cube_r22.setRotationPoint(0.0F, -14.6421F, -2.0669F);
		head.addChild(cube_r22);
		setRotationAngle(cube_r22, 1.2774F, 0.4623F, -0.1339F);
		cube_r22.setTextureOffset(24, 41).addBox(-0.4488F, 3.0459F, -4.8F, 12.6F, 0.0F, 9.6F, 0.0F, false);

		cube_r23 = new ModelRenderer(this);
		cube_r23.setRotationPoint(0.0F, -5.7979F, -1.3595F);
		head.addChild(cube_r23);
		setRotationAngle(cube_r23, 1.6581F, 0.0F, 0.0F);
		cube_r23.setTextureOffset(74, 48).addBox(-2.8F, -2.4F, -2.8F, 5.6F, 6.8F, 7.0F, 0.25F, false);
		cube_r23.setTextureOffset(66, 74).addBox(-2.8F, -2.4F, -2.8F, 5.6F, 6.8F, 7.0F, 0.0F, false);

		cube_r24 = new ModelRenderer(this);
		cube_r24.setRotationPoint(0.0F, -4.6018F, -0.5216F);
		head.addChild(cube_r24);
		setRotationAngle(cube_r24, 0.5236F, 0.0F, 0.0F);
		cube_r24.setTextureOffset(49, 106).addBox(-1.8F, -0.9F, -3.3F, 3.6F, 5.8F, 4.6F, 0.0F, false);

		jaw = new ModelRenderer(this);
		jaw.setRotationPoint(0.0F, -3.495F, -2.2318F);
		head.addChild(jaw);
		setRotationAngle(jaw, 0.3927F, 0.0F, 0.0F);
		

		cube_r25 = new ModelRenderer(this);
		cube_r25.setRotationPoint(0.0F, 0.3302F, -0.7368F);
		jaw.addChild(cube_r25);
		setRotationAngle(cube_r25, 2.0071F, 0.0F, 0.0F);
		cube_r25.setTextureOffset(0, 15).addBox(-2.3F, -5.3676F, -0.9173F, 4.6F, 6.4F, 1.6F, 0.25F, false);
		cube_r25.setTextureOffset(73, 112).addBox(-2.3F, -5.3676F, 0.2827F, 4.6F, 5.4F, 2.0F, -0.001F, false);
		cube_r25.setTextureOffset(0, 64).addBox(-2.3F, -5.3676F, -0.9173F, 4.6F, 6.4F, 1.6F, 0.0F, false);

		left_arm = new ModelRenderer(this);
		left_arm.setRotationPoint(5.7955F, -11.6318F, -2.6094F);
		body.addChild(left_arm);
		

		cube_r26 = new ModelRenderer(this);
		cube_r26.setRotationPoint(-0.5423F, -0.7836F, 0.4502F);
		left_arm.addChild(cube_r26);
		setRotationAngle(cube_r26, 0.504F, 0.0596F, 0.6273F);
		cube_r26.setTextureOffset(93, 0).addBox(-0.0653F, -3.5605F, -3.1827F, 5.6F, 5.8F, 5.6F, 0.5F, false);
		cube_r26.setTextureOffset(91, 46).addBox(5.5347F, -2.5605F, -2.1827F, 7.6F, 3.8F, 4.6F, 0.25F, false);

		cube_r27 = new ModelRenderer(this);
		cube_r27.setRotationPoint(-0.5423F, -0.7836F, 0.4502F);
		left_arm.addChild(cube_r27);
		setRotationAngle(cube_r27, 0.504F, 0.0596F, 0.6273F);
		cube_r27.setTextureOffset(105, 84).addBox(5.5347F, -2.5605F, -2.1827F, 7.6F, 3.8F, 3.6F, 0.0F, false);
		cube_r27.setTextureOffset(55, 96).addBox(-0.0653F, -3.5605F, -3.1827F, 5.6F, 5.8F, 5.6F, 0.0F, false);

		left_arm_down = new ModelRenderer(this);
		left_arm_down.setRotationPoint(10.1617F, 6.3477F, -0.6784F);
		left_arm.addChild(left_arm_down);
		

		cube_r28 = new ModelRenderer(this);
		cube_r28.setRotationPoint(4.6846F, 4.7172F, -2.6254F);
		left_arm_down.addChild(cube_r28);
		setRotationAngle(cube_r28, 0.9853F, -0.954F, -0.2939F);
		cube_r28.setTextureOffset(54, 21).addBox(-1.5F, -1.5F, -3.5F, 3.0F, 3.0F, 7.0F, 0.25F, false);

		cube_r29 = new ModelRenderer(this);
		cube_r29.setRotationPoint(1.874F, 1.2139F, -0.2115F);
		left_arm_down.addChild(cube_r29);
		setRotationAngle(cube_r29, 0.9853F, -0.954F, -0.2939F);
		cube_r29.setTextureOffset(100, 10).addBox(-3.0F, -2.0F, -1.5F, 4.0F, 4.0F, 5.0F, 0.25F, false);

		cube_r30 = new ModelRenderer(this);
		cube_r30.setRotationPoint(4.6846F, 4.7172F, -2.6254F);
		left_arm_down.addChild(cube_r30);
		setRotationAngle(cube_r30, 0.9853F, -0.954F, -0.2939F);
		cube_r30.setTextureOffset(78, 93).addBox(-1.5F, -1.5F, -3.5F, 3.0F, 3.0F, 7.0F, 0.0F, false);

		cube_r31 = new ModelRenderer(this);
		cube_r31.setRotationPoint(1.874F, 1.2139F, -0.2115F);
		left_arm_down.addChild(cube_r31);
		setRotationAngle(cube_r31, 0.9853F, -0.954F, -0.2939F);
		cube_r31.setTextureOffset(31, 104).addBox(-3.0F, -1.9F, -1.5F, 4.0F, 4.0F, 5.0F, 0.0F, false);

		left_finger1 = new ModelRenderer(this);
		left_finger1.setRotationPoint(7.1396F, 6.1272F, -5.2056F);
		left_arm_down.addChild(left_finger1);
		

		cube_r32 = new ModelRenderer(this);
		cube_r32.setRotationPoint(1.4F, 0.2F, 0.5F);
		left_finger1.addChild(cube_r32);
		setRotationAngle(cube_r32, 1.1814F, -0.8998F, 0.0596F);
		cube_r32.setTextureOffset(71, 33).addBox(-1.2815F, -0.539F, -6.5072F, 0.0F, 4.0F, 7.0F, 0.0F, false);

		left_finger3 = new ModelRenderer(this);
		left_finger3.setRotationPoint(8.4215F, 6.0781F, -3.2279F);
		left_arm_down.addChild(left_finger3);
		

		cube_r33 = new ModelRenderer(this);
		cube_r33.setRotationPoint(0.1181F, 0.2491F, -1.4778F);
		left_finger3.addChild(cube_r33);
		setRotationAngle(cube_r33, 1.7118F, -0.9509F, -0.5957F);
		cube_r33.setTextureOffset(16, 57).addBox(1.2185F, -0.539F, -6.5072F, 0.0F, 4.0F, 7.0F, 0.0F, false);

		left_finger2 = new ModelRenderer(this);
		left_finger2.setRotationPoint(7.9628F, 6.0356F, -4.5964F);
		left_arm_down.addChild(left_finger2);
		

		cube_r34 = new ModelRenderer(this);
		cube_r34.setRotationPoint(0.5768F, 0.2916F, -0.1092F);
		left_finger2.addChild(cube_r34);
		setRotationAngle(cube_r34, 1.4653F, -0.954F, -0.2939F);
		cube_r34.setTextureOffset(48, 48).addBox(-0.1815F, -0.539F, -6.5072F, 0.0F, 4.0F, 7.0F, 0.0F, false);

		big_finger_left = new ModelRenderer(this);
		big_finger_left.setRotationPoint(3.7821F, 4.9626F, -2.7775F);
		left_arm_down.addChild(big_finger_left);
		

		cube_r35 = new ModelRenderer(this);
		cube_r35.setRotationPoint(-2.0F, 0.0F, 0.0F);
		big_finger_left.addChild(cube_r35);
		setRotationAngle(cube_r35, 0.7922F, 1.0258F, -0.6008F);
		cube_r35.setTextureOffset(23, 42).addBox(1.7722F, 0.1797F, -8.0944F, 0.0F, 4.0F, 8.0F, 0.0F, false);

		right_arm = new ModelRenderer(this);
		right_arm.setRotationPoint(-6.0556F, -11.5394F, -2.6094F);
		body.addChild(right_arm);
		

		cube_r36 = new ModelRenderer(this);
		cube_r36.setRotationPoint(0.8023F, -0.876F, 0.4502F);
		right_arm.addChild(cube_r36);
		setRotationAngle(cube_r36, 0.504F, -0.0596F, -0.6273F);
		cube_r36.setTextureOffset(91, 93).addBox(-13.1347F, -2.5605F, -2.1827F, 7.6F, 3.8F, 4.6F, 0.25F, false);
		cube_r36.setTextureOffset(44, 118).addBox(-5.5347F, -3.5605F, -3.1827F, 5.6F, 5.8F, 5.6F, 0.5F, false);

		cube_r37 = new ModelRenderer(this);
		cube_r37.setRotationPoint(0.8023F, -0.876F, 0.4502F);
		right_arm.addChild(cube_r37);
		setRotationAngle(cube_r37, 0.504F, -0.0596F, -0.6273F);
		cube_r37.setTextureOffset(35, 94).addBox(-5.5347F, -3.5605F, -3.1827F, 5.6F, 5.8F, 5.6F, 0.0F, false);
		cube_r37.setTextureOffset(104, 53).addBox(-13.1347F, -2.5605F, -2.1827F, 7.6F, 3.8F, 3.6F, 0.0F, false);

		right_arm_down = new ModelRenderer(this);
		right_arm_down.setRotationPoint(-9.9017F, 6.2552F, -1.6784F);
		right_arm.addChild(right_arm_down);
		

		cube_r38 = new ModelRenderer(this);
		cube_r38.setRotationPoint(-1.874F, 1.2139F, 0.7885F);
		right_arm_down.addChild(cube_r38);
		setRotationAngle(cube_r38, 0.9853F, 0.954F, 0.2939F);
		cube_r38.setTextureOffset(0, 119).addBox(-1.0F, -2.0F, -1.5F, 4.0F, 4.0F, 5.0F, 0.25F, false);

		cube_r39 = new ModelRenderer(this);
		cube_r39.setRotationPoint(-4.6846F, 4.7172F, -1.6254F);
		right_arm_down.addChild(cube_r39);
		setRotationAngle(cube_r39, 0.9853F, 0.954F, 0.2939F);
		cube_r39.setTextureOffset(91, 54).addBox(-1.5F, -1.5F, -3.5F, 3.0F, 3.0F, 7.0F, 0.25F, false);

		cube_r40 = new ModelRenderer(this);
		cube_r40.setRotationPoint(-4.6846F, 4.7172F, -1.6254F);
		right_arm_down.addChild(cube_r40);
		setRotationAngle(cube_r40, 0.9853F, 0.954F, 0.2939F);
		cube_r40.setTextureOffset(93, 19).addBox(-1.5F, -1.5F, -3.5F, 3.0F, 3.0F, 7.0F, 0.0F, false);

		cube_r41 = new ModelRenderer(this);
		cube_r41.setRotationPoint(-1.874F, 1.2139F, 0.7885F);
		right_arm_down.addChild(cube_r41);
		setRotationAngle(cube_r41, 0.9853F, 0.954F, 0.2939F);
		cube_r41.setTextureOffset(70, 103).addBox(-1.0F, -1.9F, -1.5F, 4.0F, 4.0F, 5.0F, 0.0F, false);

		big_finger_right = new ModelRenderer(this);
		big_finger_right.setRotationPoint(-4.1194F, 5.7501F, -2.9792F);
		right_arm_down.addChild(big_finger_right);
		

		cube_r42 = new ModelRenderer(this);
		cube_r42.setRotationPoint(2.3374F, -0.7875F, 1.2016F);
		big_finger_right.addChild(cube_r42);
		setRotationAngle(cube_r42, 0.7922F, -1.0258F, 0.6008F);
		cube_r42.setTextureOffset(36, 13).addBox(-1.7722F, 0.1797F, -8.0944F, 0.0F, 4.0F, 8.0F, 0.0F, false);

		right_finger2 = new ModelRenderer(this);
		right_finger2.setRotationPoint(-7.5396F, 6.3272F, -3.7056F);
		right_arm_down.addChild(right_finger2);
		

		cube_r43 = new ModelRenderer(this);
		cube_r43.setRotationPoint(-1.0F, 0.0F, 0.0F);
		right_finger2.addChild(cube_r43);
		setRotationAngle(cube_r43, 1.4653F, 0.954F, 0.2939F);
		cube_r43.setTextureOffset(23, 47).addBox(0.1815F, -0.539F, -6.5072F, 0.0F, 4.0F, 7.0F, 0.0F, false);

		right_finger3 = new ModelRenderer(this);
		right_finger3.setRotationPoint(-8.5396F, 6.3272F, -3.7056F);
		right_arm_down.addChild(right_finger3);
		

		cube_r44 = new ModelRenderer(this);
		cube_r44.setRotationPoint(0.0F, 0.0F, 0.0F);
		right_finger3.addChild(cube_r44);
		setRotationAngle(cube_r44, 1.7118F, 0.9509F, 0.5957F);
		cube_r44.setTextureOffset(0, 4).addBox(-1.2185F, -0.539F, -6.5072F, 0.0F, 4.0F, 7.0F, 0.0F, false);

		right_finger1 = new ModelRenderer(this);
		right_finger1.setRotationPoint(-7.0812F, 6.6007F, -3.7787F);
		right_arm_down.addChild(right_finger1);
		

		cube_r45 = new ModelRenderer(this);
		cube_r45.setRotationPoint(-1.4584F, -0.2735F, 0.073F);
		right_finger1.addChild(cube_r45);
		setRotationAngle(cube_r45, 1.1814F, 0.8998F, -0.0596F);
		cube_r45.setTextureOffset(0, 0).addBox(1.2815F, -0.539F, -6.5072F, 0.0F, 4.0F, 7.0F, 0.0F, false);

		right_leg = new ModelRenderer(this);
		right_leg.setRotationPoint(-3.275F, 2.2971F, -0.3639F);
		body.addChild(right_leg);
		

		cube_r46 = new ModelRenderer(this);
		cube_r46.setRotationPoint(3.325F, 2.2652F, -3.9622F);
		right_leg.addChild(cube_r46);
		setRotationAngle(cube_r46, -0.7854F, 0.0F, 0.0F);
		cube_r46.setTextureOffset(0, 83).addBox(-7.85F, -7.5F, -1.6F, 5.0F, 7.8F, 5.6F, 0.25F, false);

		cube_r47 = new ModelRenderer(this);
		cube_r47.setRotationPoint(3.325F, 2.1237F, -3.8208F);
		right_leg.addChild(cube_r47);
		setRotationAngle(cube_r47, -0.7854F, 0.0F, 0.0F);
		cube_r47.setTextureOffset(85, 110).addBox(-7.35F, -1.5F, -0.6F, 4.1F, 4.8F, 3.6F, 0.5F, false);

		cube_r48 = new ModelRenderer(this);
		cube_r48.setRotationPoint(3.325F, 2.2652F, -3.9622F);
		right_leg.addChild(cube_r48);
		setRotationAngle(cube_r48, -0.7854F, 0.0F, 0.0F);
		cube_r48.setTextureOffset(85, 35).addBox(-7.85F, -7.5F, -1.6F, 5.0F, 6.8F, 5.6F, 0.0F, false);

		cube_r49 = new ModelRenderer(this);
		cube_r49.setRotationPoint(3.325F, 2.1237F, -3.8208F);
		right_leg.addChild(cube_r49);
		setRotationAngle(cube_r49, -0.7854F, 0.0F, 0.0F);
		cube_r49.setTextureOffset(110, 97).addBox(-7.35F, -1.5F, -0.6F, 4.1F, 4.8F, 3.6F, 0.0F, false);

		right_leg_down = new ModelRenderer(this);
		right_leg_down.setRotationPoint(-2.155F, 5.5752F, -4.7225F);
		right_leg.addChild(right_leg_down);
		

		cube_r50 = new ModelRenderer(this);
		cube_r50.setRotationPoint(5.48F, -0.0648F, -0.0681F);
		right_leg_down.addChild(cube_r50);
		setRotationAngle(cube_r50, 0.1745F, 0.0F, 0.0F);
		cube_r50.setTextureOffset(109, 44).addBox(-7.35F, -1.9F, -1.8F, 4.1F, 3.8F, 3.6F, 0.25F, false);

		cube_r51 = new ModelRenderer(this);
		cube_r51.setRotationPoint(5.48F, -0.0648F, -0.0681F);
		right_leg_down.addChild(cube_r51);
		setRotationAngle(cube_r51, 0.1745F, 0.0F, 0.0F);
		cube_r51.setTextureOffset(99, 113).addBox(-7.35F, -1.9F, -1.8F, 4.1F, 3.8F, 3.6F, -0.001F, false);

		cube_r52 = new ModelRenderer(this);
		cube_r52.setRotationPoint(10.93F, 4.5014F, 3.7622F);
		right_leg_down.addChild(cube_r52);
		setRotationAngle(cube_r52, 2.4435F, 0.0F, 0.0F);
		cube_r52.setTextureOffset(103, 104).addBox(-12.6F, -0.9874F, -0.3395F, 3.6F, 3.8F, 6.6F, -0.01F, false);

		right_foot = new ModelRenderer(this);
		right_foot.setRotationPoint(-0.07F, 4.8011F, 5.5551F);
		right_leg_down.addChild(right_foot);
		right_foot.setTextureOffset(59, 111).addBox(-1.5F, 8.2371F, -5.1563F, 3.0F, 3.0F, 4.0F, 0.0F, false);
		right_foot.setTextureOffset(109, 60).addBox(-1.5F, 8.2371F, -5.1563F, 3.0F, 3.0F, 4.0F, 0.25F, false);

		cube_r53 = new ModelRenderer(this);
		cube_r53.setRotationPoint(0.0F, -0.2258F, 0.2143F);
		right_foot.addChild(cube_r53);
		setRotationAngle(cube_r53, 1.1345F, 0.0F, 0.0F);
		cube_r53.setTextureOffset(0, 46).addBox(-1.3F, -0.2977F, -9.7681F, 2.6F, 3.3F, 2.6F, 0.25F, false);

		cube_r54 = new ModelRenderer(this);
		cube_r54.setRotationPoint(0.0F, -0.2258F, 0.2143F);
		right_foot.addChild(cube_r54);
		setRotationAngle(cube_r54, 1.309F, 0.0F, 0.0F);
		cube_r54.setTextureOffset(98, 64).addBox(-1.0F, -1.4252F, -7.8988F, 2.0F, 3.0F, 7.6F, 0.25F, false);
		cube_r54.setTextureOffset(100, 74).addBox(-1.0F, -1.4252F, -7.8988F, 2.0F, 3.0F, 7.6F, 0.0F, false);

		cube_r55 = new ModelRenderer(this);
		cube_r55.setRotationPoint(0.0F, -0.2258F, 0.2143F);
		right_foot.addChild(cube_r55);
		setRotationAngle(cube_r55, 1.8326F, 0.0F, 0.0F);
		cube_r55.setTextureOffset(106, 19).addBox(-2.0F, -2.6176F, -1.673F, 4.0F, 4.0F, 3.6F, 0.25F, false);
		cube_r55.setTextureOffset(112, 26).addBox(-2.0F, -2.6176F, -1.673F, 4.0F, 4.0F, 3.6F, 0.0F, false);

		left_leg = new ModelRenderer(this);
		left_leg.setRotationPoint(3.525F, 2.2971F, -0.3639F);
		body.addChild(left_leg);
		

		cube_r56 = new ModelRenderer(this);
		cube_r56.setRotationPoint(-3.475F, 2.1237F, -3.8208F);
		left_leg.addChild(cube_r56);
		setRotationAngle(cube_r56, -0.7854F, 0.0F, 0.0F);
		cube_r56.setTextureOffset(109, 90).addBox(3.25F, -1.5F, -0.6F, 4.1F, 4.8F, 3.6F, 0.5F, false);

		cube_r57 = new ModelRenderer(this);
		cube_r57.setRotationPoint(-3.475F, 2.2652F, -3.9622F);
		left_leg.addChild(cube_r57);
		setRotationAngle(cube_r57, -0.7854F, 0.0F, 0.0F);
		cube_r57.setTextureOffset(83, 69).addBox(2.75F, -7.5F, -1.6F, 5.0F, 7.8F, 5.6F, 0.25F, false);

		cube_r58 = new ModelRenderer(this);
		cube_r58.setRotationPoint(-3.475F, 2.2652F, -3.9622F);
		left_leg.addChild(cube_r58);
		setRotationAngle(cube_r58, -0.7854F, 0.0F, 0.0F);
		cube_r58.setTextureOffset(85, 82).addBox(2.75F, -7.5F, -1.6F, 5.0F, 6.8F, 5.6F, 0.0F, false);

		cube_r59 = new ModelRenderer(this);
		cube_r59.setRotationPoint(-3.475F, 2.1237F, -3.8208F);
		left_leg.addChild(cube_r59);
		setRotationAngle(cube_r59, -0.7854F, 0.0F, 0.0F);
		cube_r59.setTextureOffset(111, 74).addBox(3.25F, -1.5F, -0.6F, 4.1F, 4.8F, 3.6F, 0.0F, false);

		left_leg_down = new ModelRenderer(this);
		left_leg_down.setRotationPoint(1.875F, 5.8119F, -4.1866F);
		left_leg.addChild(left_leg_down);
		

		cube_r60 = new ModelRenderer(this);
		cube_r60.setRotationPoint(0.0F, 0.0F, 0.0F);
		left_leg_down.addChild(cube_r60);
		setRotationAngle(cube_r60, 0.1745F, 0.0F, 0.0F);
		cube_r60.setTextureOffset(113, 7).addBox(-2.1F, -2.3018F, -2.3425F, 4.1F, 3.8F, 3.6F, 0.25F, false);
		cube_r60.setTextureOffset(25, 113).addBox(-2.1F, -2.3018F, -2.3425F, 4.1F, 3.8F, 3.6F, -0.001F, false);

		cube_r61 = new ModelRenderer(this);
		cube_r61.setRotationPoint(0.0F, 0.0F, 0.0F);
		left_leg_down.addChild(cube_r61);
		setRotationAngle(cube_r61, 2.4435F, 0.0F, 0.0F);
		cube_r61.setTextureOffset(105, 35).addBox(-1.9F, -2.1806F, -5.5523F, 3.6F, 3.8F, 6.6F, -0.01F, false);

		left_foot = new ModelRenderer(this);
		left_foot.setRotationPoint(0.1F, 4.5105F, 4.472F);
		left_leg_down.addChild(left_foot);
		left_foot.setTextureOffset(113, 0).addBox(-1.5F, 8.291F, -4.6091F, 3.0F, 3.0F, 4.0F, 0.0F, false);
		left_foot.setTextureOffset(0, 108).addBox(-1.5F, 8.291F, -4.6091F, 3.0F, 3.0F, 4.0F, 0.25F, false);

		cube_r62 = new ModelRenderer(this);
		cube_r62.setRotationPoint(-0.1F, -4.5105F, -4.472F);
		left_foot.addChild(cube_r62);
		setRotationAngle(cube_r62, 1.309F, 0.0F, 0.0F);
		cube_r62.setTextureOffset(78, 118).addBox(-0.9F, 4.7529F, -10.735F, 2.0F, 3.0F, 7.6F, 0.25F, false);
		cube_r62.setTextureOffset(91, 100).addBox(-0.9F, 4.7529F, -10.735F, 2.0F, 3.0F, 7.6F, 0.0F, false);

		cube_r63 = new ModelRenderer(this);
		cube_r63.setRotationPoint(-0.1F, -4.5105F, -4.472F);
		left_foot.addChild(cube_r63);
		setRotationAngle(cube_r63, 1.1345F, 0.0F, 0.0F);
		cube_r63.setTextureOffset(0, 41).addBox(-1.2F, 6.279F, -11.4885F, 2.6F, 3.3F, 2.6F, 0.25F, false);

		cube_r64 = new ModelRenderer(this);
		cube_r64.setRotationPoint(-0.1F, -4.5105F, -4.472F);
		left_foot.addChild(cube_r64);
		setRotationAngle(cube_r64, 1.8326F, 0.0F, 0.0F);
		cube_r64.setTextureOffset(0, 0).addBox(-1.9F, 1.3146F, -7.2183F, 4.0F, 4.0F, 3.6F, 0.25F, false);
		cube_r64.setTextureOffset(11, 112).addBox(-1.9F, 1.3146F, -7.2183F, 4.0F, 4.0F, 3.6F, 0.0F, false);
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		body.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	@Override
	public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks,
			float netHeadYaw, float headPitch) {
		
		this.head.rotateAngleX = headPitch * ((float)Math.PI / 180F);
        this.head.rotateAngleY = netHeadYaw * ((float)Math.PI / 180F);
        this.right_leg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
        this.left_leg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
        this.right_arm.rotateAngleX = MathHelper.cos(limbSwing * 0.33F + (float)Math.PI) * 1.4F * limbSwingAmount;
        this.left_arm.rotateAngleX = MathHelper.cos(limbSwing * 0.33F) * 1.4F * limbSwingAmount;
	}
}