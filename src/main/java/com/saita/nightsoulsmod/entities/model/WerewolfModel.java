package com.saita.nightsoulsmod.entities.model;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.saita.nightsoulsmod.entities.entity.WerewolfEntity;

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;

public class WerewolfModel <T extends WerewolfEntity> extends EntityModel<T> {
	
	private final ModelRenderer Werewolf;
	private final ModelRenderer arms;
	private final ModelRenderer leftArm;
	private final ModelRenderer cube_r1;
	private final ModelRenderer cube_r2;
	private final ModelRenderer cube_r3;
	private final ModelRenderer rightArm;
	private final ModelRenderer cube_r4;
	private final ModelRenderer cube_r5;
	private final ModelRenderer cube_r6;
	private final ModelRenderer legs;
	private final ModelRenderer rightLeg;
	private final ModelRenderer cube_r7;
	private final ModelRenderer cube_r8;
	private final ModelRenderer cube_r9;
	private final ModelRenderer leftLeg;
	private final ModelRenderer cube_r10;
	private final ModelRenderer cube_r11;
	private final ModelRenderer cube_r12;
	private final ModelRenderer torso;
	private final ModelRenderer cube_r13;
	private final ModelRenderer cube_r14;
	private final ModelRenderer cube_r15;
	private final ModelRenderer cube_r16;
	private final ModelRenderer cube_r17;
	private final ModelRenderer head;
	private final ModelRenderer cube_r18;
	private final ModelRenderer cube_r19;
	private final ModelRenderer tooth;
	private final ModelRenderer cube_r20;
	private final ModelRenderer claws;
	private final ModelRenderer cube_r21;
	
	public WerewolfModel() {
		textureWidth = 128;
		textureHeight = 128;

		Werewolf = new ModelRenderer(this);
		Werewolf.setRotationPoint(0.0F, 24.0F, 0.0F);
		

		arms = new ModelRenderer(this);
		arms.setRotationPoint(-4.5F, -15.5F, 4.0F);
		Werewolf.addChild(arms);
		

		leftArm = new ModelRenderer(this);
		leftArm.setRotationPoint(5.5F, 1.148F, -0.2284F);
		arms.addChild(leftArm);
		

		cube_r1 = new ModelRenderer(this);
		cube_r1.setRotationPoint(6.5F, 5.852F, -13.2716F);
		leftArm.addChild(cube_r1);
		setRotationAngle(cube_r1, -0.3927F, 0.0F, 0.0F);
		cube_r1.setTextureOffset(0, 19).addBox(-0.75F, -3.5F, -1.25F, 1.0F, 6.0F, 4.0F, 0.0F, false);

		cube_r2 = new ModelRenderer(this);
		cube_r2.setRotationPoint(8.0F, 0.0F, -10.0F);
		leftArm.addChild(cube_r2);
		setRotationAngle(cube_r2, -0.3927F, 0.0F, 0.0F);
		cube_r2.setTextureOffset(17, 65).addBox(-2.5F, -7.5F, -1.75F, 3.0F, 11.0F, 3.0F, 0.0F, false);

		cube_r3 = new ModelRenderer(this);
		cube_r3.setRotationPoint(8.5F, -11.4692F, -6.3317F);
		leftArm.addChild(cube_r3);
		setRotationAngle(cube_r3, -0.3927F, 0.0F, 0.0F);
		cube_r3.setTextureOffset(0, 50).addBox(-3.5F, -4.5F, -2.0F, 4.0F, 10.0F, 6.0F, 0.0F, false);

		rightArm = new ModelRenderer(this);
		rightArm.setRotationPoint(0.0F, 0.0F, 0.0F);
		arms.addChild(rightArm);
		

		cube_r4 = new ModelRenderer(this);
		cube_r4.setRotationPoint(13.5F, 1.148F, -10.2284F);
		rightArm.addChild(cube_r4);
		setRotationAngle(cube_r4, -0.3927F, 0.0F, 0.0F);
		cube_r4.setTextureOffset(38, 60).addBox(-18.5F, -7.5F, -1.75F, 3.0F, 11.0F, 3.0F, 0.0F, false);

		cube_r5 = new ModelRenderer(this);
		cube_r5.setRotationPoint(12.0F, 7.0F, -13.5F);
		rightArm.addChild(cube_r5);
		setRotationAngle(cube_r5, -0.3927F, 0.0F, 0.0F);
		cube_r5.setTextureOffset(0, 0).addBox(-15.75F, -3.5F, -1.25F, 1.0F, 6.0F, 4.0F, 0.0F, false);

		cube_r6 = new ModelRenderer(this);
		cube_r6.setRotationPoint(14.0F, -10.3212F, -6.56F);
		rightArm.addChild(cube_r6);
		setRotationAngle(cube_r6, -0.3927F, 0.0F, 0.0F);
		cube_r6.setTextureOffset(38, 44).addBox(-19.5F, -4.5F, -2.0F, 4.0F, 10.0F, 6.0F, 0.0F, false);

		legs = new ModelRenderer(this);
		legs.setRotationPoint(-8.0F, -8.0F, 8.0F);
		Werewolf.addChild(legs);
		

		rightLeg = new ModelRenderer(this);
		rightLeg.setRotationPoint(4.0F, -8.0F, 0.0F);
		legs.addChild(rightLeg);
		rightLeg.setTextureOffset(62, 8).addBox(-1.0F, 15.0454F, -5.5628F, 3.0F, 1.0F, 5.0F, 0.0F, false);

		cube_r7 = new ModelRenderer(this);
		cube_r7.setRotationPoint(0.5F, 13.5F, 0.25F);
		rightLeg.addChild(cube_r7);
		setRotationAngle(cube_r7, -0.3927F, 0.0F, 0.0F);
		cube_r7.setTextureOffset(0, 36).addBox(-1.5F, -3.5F, -2.0F, 3.0F, 6.0F, 2.0F, 0.0F, false);

		cube_r8 = new ModelRenderer(this);
		cube_r8.setRotationPoint(0.5F, 10.5F, -2.5F);
		rightLeg.addChild(cube_r8);
		setRotationAngle(cube_r8, -0.3927F, 0.0F, 0.0F);
		cube_r8.setTextureOffset(49, 4).addBox(-1.5F, -2.5F, -3.5F, 3.0F, 3.0F, 6.0F, 0.0F, false);

		cube_r9 = new ModelRenderer(this);
		cube_r9.setRotationPoint(7.5F, 0.5F, -3.0F);
		rightLeg.addChild(cube_r9);
		setRotationAngle(cube_r9, -0.3927F, 0.0F, 0.0F);
		cube_r9.setTextureOffset(20, 50).addBox(-9.5F, -2.5F, 0.0F, 5.0F, 11.0F, 4.0F, 0.0F, false);

		leftLeg = new ModelRenderer(this);
		leftLeg.setRotationPoint(12.0F, -8.0F, 0.0F);
		legs.addChild(leftLeg);
		leftLeg.setTextureOffset(64, 29).addBox(-2.0F, 15.0454F, -5.5628F, 3.0F, 1.0F, 5.0F, 0.0F, false);

		cube_r10 = new ModelRenderer(this);
		cube_r10.setRotationPoint(-0.5F, 13.5F, 0.25F);
		leftLeg.addChild(cube_r10);
		setRotationAngle(cube_r10, -0.3927F, 0.0F, 0.0F);
		cube_r10.setTextureOffset(0, 66).addBox(-1.5F, -3.5F, -2.0F, 3.0F, 6.0F, 2.0F, 0.0F, false);

		cube_r11 = new ModelRenderer(this);
		cube_r11.setRotationPoint(-0.5F, 10.5F, -2.5F);
		leftLeg.addChild(cube_r11);
		setRotationAngle(cube_r11, -0.3927F, 0.0F, 0.0F);
		cube_r11.setTextureOffset(58, 42).addBox(-1.5F, -2.5F, -3.5F, 3.0F, 3.0F, 6.0F, 0.0F, false);

		cube_r12 = new ModelRenderer(this);
		cube_r12.setRotationPoint(-0.5F, 0.5F, -3.0F);
		leftLeg.addChild(cube_r12);
		setRotationAngle(cube_r12, -0.3927F, 0.0F, 0.0F);
		cube_r12.setTextureOffset(54, 56).addBox(-2.5F, -2.5F, 0.0F, 5.0F, 11.0F, 4.0F, 0.0F, false);

		torso = new ModelRenderer(this);
		torso.setRotationPoint(0.0F, 0.0F, 0.0F);
		Werewolf.addChild(torso);
		torso.setTextureOffset(0, 36).addBox(-5.0F, -24.0678F, -4.9677F, 10.0F, 2.0F, 12.0F, 0.0F, false);

		cube_r13 = new ModelRenderer(this);
		cube_r13.setRotationPoint(0.0F, -12.785F, 17.0345F);
		torso.addChild(cube_r13);
		setRotationAngle(cube_r13, -0.7854F, 0.0F, 0.0F);
		cube_r13.setTextureOffset(32, 37).addBox(-1.25F, -0.125F, -2.0F, 2.0F, 1.0F, 5.0F, 0.0F, false);

		cube_r14 = new ModelRenderer(this);
		cube_r14.setRotationPoint(0.0F, -15.5F, 9.5F);
		torso.addChild(cube_r14);
		setRotationAngle(cube_r14, -0.3927F, 0.0F, 0.0F);
		cube_r14.setTextureOffset(35, 0).addBox(-1.25F, -1.5F, -1.5F, 2.0F, 2.0F, 8.0F, 0.0F, false);

		cube_r15 = new ModelRenderer(this);
		cube_r15.setRotationPoint(0.0F, -27.7926F, -2.8357F);
		torso.addChild(cube_r15);
		setRotationAngle(cube_r15, 0.3927F, 0.0F, 0.0F);
		cube_r15.setTextureOffset(0, 0).addBox(-6.0F, -3.2074F, -4.5F, 12.0F, 8.0F, 11.0F, 0.0F, false);

		cube_r16 = new ModelRenderer(this);
		cube_r16.setRotationPoint(0.0F, -27.2059F, 1.7858F);
		torso.addChild(cube_r16);
		setRotationAngle(cube_r16, -0.7854F, 0.0F, 0.0F);
		cube_r16.setTextureOffset(0, 19).addBox(-7.0F, -3.7074F, -3.5F, 14.0F, 7.0F, 10.0F, 0.0F, false);

		cube_r17 = new ModelRenderer(this);
		cube_r17.setRotationPoint(0.5F, -19.0F, 5.5F);
		torso.addChild(cube_r17);
		setRotationAngle(cube_r17, 0.3927F, 0.0F, 0.0F);
		cube_r17.setTextureOffset(41, 14).addBox(-5.5F, -5.0F, -1.5F, 10.0F, 10.0F, 5.0F, 0.0F, false);

		head = new ModelRenderer(this);
		head.setRotationPoint(0.0F, -27.0F, -5.0F);
		Werewolf.addChild(head);
		head.setTextureOffset(41, 29).addBox(-4.0F, -4.0F, -7.3357F, 8.0F, 6.0F, 7.0F, 0.0F, false);
		head.setTextureOffset(61, 0).addBox(-2.0F, 0.0F, -12.3357F, 4.0F, 2.0F, 5.0F, 0.0F, false);

		cube_r18 = new ModelRenderer(this);
		cube_r18.setRotationPoint(4.125F, -3.5F, -4.0F);
		head.addChild(cube_r18);
		setRotationAngle(cube_r18, 0.7854F, 0.0F, 0.0F);
		cube_r18.setTextureOffset(35, 2).addBox(-0.125F, 0.0F, -0.5F, 0.0F, 2.0F, 4.0F, 0.0F, false);
		cube_r18.setTextureOffset(29, 67).addBox(-8.625F, 0.0F, -0.5F, 0.0F, 2.0F, 4.0F, 0.0F, false);

		cube_r19 = new ModelRenderer(this);
		cube_r19.setRotationPoint(0.0F, 3.4574F, -7.8357F);
		head.addChild(cube_r19);
		setRotationAngle(cube_r19, 0.7854F, 0.0F, 0.0F);
		cube_r19.setTextureOffset(73, 1).addBox(-2.0F, -0.4574F, -3.5F, 4.0F, 1.0F, 6.0F, 0.0F, false);

		tooth = new ModelRenderer(this);
		tooth.setRotationPoint(1.0F, 12.648F, 8.7716F);
		head.addChild(tooth);
		tooth.setTextureOffset(24, 80).addBox(0.75F, -11.1418F, -20.8046F, 0.0F, 2.0F, 1.0F, 0.0F, false);
		tooth.setTextureOffset(21, 80).addBox(-2.5F, -11.1418F, -20.8046F, 0.0F, 2.0F, 1.0F, 0.0F, false);
		tooth.setTextureOffset(21, 80).addBox(-2.5F, -12.1418F, -18.3046F, 0.0F, 2.0F, 1.0F, 0.0F, false);
		tooth.setTextureOffset(21, 80).addBox(-2.5F, -11.6418F, -19.5546F, 0.0F, 2.0F, 1.0F, 0.0F, false);
		tooth.setTextureOffset(21, 80).addBox(0.75F, -12.1418F, -18.3046F, 0.0F, 2.0F, 1.0F, 0.0F, false);
		tooth.setTextureOffset(21, 80).addBox(0.75F, -11.6418F, -19.5546F, 0.0F, 2.0F, 1.0F, 0.0F, false);

		cube_r20 = new ModelRenderer(this);
		cube_r20.setRotationPoint(0.5F, -8.648F, -18.5216F);
		tooth.addChild(cube_r20);
		setRotationAngle(cube_r20, 0.7854F, 0.0F, 0.0F);
		cube_r20.setTextureOffset(11, 80).addBox(0.0F, -0.5F, -1.25F, 0.0F, 2.0F, 1.0F, 0.0F, false);
		cube_r20.setTextureOffset(11, 80).addBox(0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r20.setTextureOffset(11, 80).addBox(0.0F, 0.25F, 1.25F, 0.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r20.setTextureOffset(11, 80).addBox(-3.25F, 0.25F, 1.25F, 0.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r20.setTextureOffset(11, 80).addBox(-3.25F, 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r20.setTextureOffset(11, 80).addBox(-3.25F, -0.5F, -1.25F, 0.0F, 2.0F, 1.0F, 0.0F, false);

		claws = new ModelRenderer(this);
		claws.setRotationPoint(-8.0F, -8.0F, 8.0F);
		Werewolf.addChild(claws);
		

		cube_r21 = new ModelRenderer(this);
		cube_r21.setRotationPoint(15.125F, 2.5F, -17.25F);
		claws.addChild(cube_r21);
		setRotationAngle(cube_r21, -0.3927F, 0.0F, 0.0F);
		cube_r21.setTextureOffset(8, 80).addBox(-14.125F, -0.5F, 0.25F, 0.0F, 3.0F, 1.0F, 0.0F, false);
		cube_r21.setTextureOffset(7, 80).addBox(-14.125F, -0.5F, -1.0F, 0.0F, 3.0F, 1.0F, 0.0F, false);
		cube_r21.setTextureOffset(6, 80).addBox(-14.125F, -0.5F, -2.25F, 0.0F, 3.0F, 1.0F, 0.0F, false);
		cube_r21.setTextureOffset(6, 80).addBox(-0.125F, -0.5F, -2.25F, 0.0F, 3.0F, 1.0F, 0.0F, false);
		cube_r21.setTextureOffset(7, 80).addBox(-0.125F, -0.5F, -1.0F, 0.0F, 3.0F, 1.0F, 0.0F, false);
		cube_r21.setTextureOffset(8, 80).addBox(-0.125F, -0.5F, 0.25F, 0.0F, 3.0F, 1.0F, 0.0F, false);
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		Werewolf.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
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
        this.rightLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
        this.leftLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;

		
	}
	
}