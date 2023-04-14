package com.saita.nightsoulsmod.entities.model;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.saita.nightsoulsmod.entities.entity.PartygoerEntity;

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;

public class PartygoerModel <T extends PartygoerEntity> extends EntityModel<T> {
	
	private final ModelRenderer Body;
	private final ModelRenderer head;
	private final ModelRenderer chest;
	private final ModelRenderer rightArm;
	private final ModelRenderer rightArm_r1;
	private final ModelRenderer leftLeg;
	private final ModelRenderer rightLeg;
	private final ModelRenderer leftArm;
	private final ModelRenderer leftArm_r1;

	public PartygoerModel() {
		
		textureWidth = 80;
		textureHeight = 80;

		Body = new ModelRenderer(this);
		Body.setRotationPoint(-5.0F, 2.0F, 0.0F);
		

		head = new ModelRenderer(this);
		head.setRotationPoint(5.0F, -14.0F, 0.0F);
		Body.addChild(head);
		head.setTextureOffset(0, 0).addBox(-5.0F, -10.0F, -5.0F, 10.0F, 10.0F, 10.0F, 0.0F, false);

		chest = new ModelRenderer(this);
		chest.setRotationPoint(5.0F, -2.0F, 0.0F);
		Body.addChild(chest);
		chest.setTextureOffset(42, 25).addBox(-5.0F, -12.0F, -2.0F, 10.0F, 18.0F, 4.0F, 0.0F, true);

		rightArm = new ModelRenderer(this);
		rightArm.setRotationPoint(13.0F, -12.0F, 0.0F);
		Body.addChild(rightArm);
		

		rightArm_r1 = new ModelRenderer(this);
		rightArm_r1.setRotationPoint(-8.0F, 34.0F, 0.0F);
		rightArm.addChild(rightArm_r1);
		setRotationAngle(rightArm_r1, -0.2182F, 0.0F, 0.0F);
		rightArm_r1.setTextureOffset(20, 51).addBox(5.0F, -35.0F, -10.0F, 6.0F, 24.0F, 5.0F, 0.0F, true);

		leftLeg = new ModelRenderer(this);
		leftLeg.setRotationPoint(3.0F, 5.0F, 0.0F);
		Body.addChild(leftLeg);
		leftLeg.setTextureOffset(0, 25).addBox(-3.0F, -1.0F, -2.0F, 5.0F, 18.0F, 4.0F, 0.0F, false);

		rightLeg = new ModelRenderer(this);
		rightLeg.setRotationPoint(7.0F, 5.0F, 0.0F);
		Body.addChild(rightLeg);
		rightLeg.setTextureOffset(0, 25).addBox(-2.1F, -1.0F, -2.0F, 5.0F, 18.0F, 4.0F, 0.0F, true);

		leftArm = new ModelRenderer(this);
		leftArm.setRotationPoint(-3.0F, -12.0F, 0.0F);
		Body.addChild(leftArm);
		

		leftArm_r1 = new ModelRenderer(this);
		leftArm_r1.setRotationPoint(8.0F, 34.0F, 0.0F);
		leftArm.addChild(leftArm_r1);
		setRotationAngle(leftArm_r1, -0.2182F, 0.0F, 0.0F);
		leftArm_r1.setTextureOffset(20, 50).addBox(-11.0F, -35.0F, -10.0F, 6.0F, 24.0F, 5.0F, 0.0F, false);
	}
	

	@Override
	public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn,
			float red, float green, float blue, float alpha) {
		Body.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
		
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