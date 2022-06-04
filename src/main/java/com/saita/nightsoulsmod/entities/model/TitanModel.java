package com.saita.nightsoulsmod.entities.model;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.saita.nightsoulsmod.entities.entity.TitanEntity;

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;

public class TitanModel <T extends TitanEntity> extends EntityModel<T> {
	
	private final ModelRenderer Body;
	private final ModelRenderer chest;
	private final ModelRenderer chest_r1;
	private final ModelRenderer leftArm;
	private final ModelRenderer leftArm_r1;
	private final ModelRenderer rightArm;
	private final ModelRenderer rightArm_r1;
	private final ModelRenderer leftLeg;
	private final ModelRenderer rightLeg;
	private final ModelRenderer head;
	private final ModelRenderer head_r1;

	public TitanModel() {
		textureWidth = 384;
		textureHeight = 384;

		Body = new ModelRenderer(this);
		Body.setRotationPoint(0.0F, 24.0F, 0.0F);
		

		chest = new ModelRenderer(this);
		chest.setRotationPoint(0.0F, -95.0F, 0.0F);
		Body.addChild(chest);
		

		chest_r1 = new ModelRenderer(this);
		chest_r1.setRotationPoint(0.0F, -12.368F, 8.8648F);
		chest.addChild(chest_r1);
		setRotationAngle(chest_r1, 0.0436F, 0.0F, 0.0F);
		chest_r1.setTextureOffset(96, 96).addBox(-24.0F, -36.0F, -12.0F, 48.0F, 72.0F, 24.0F, 0.0F, true);

		leftArm = new ModelRenderer(this);
		leftArm.setRotationPoint(-24.0F, -88.0F, 12.0F);
		Body.addChild(leftArm);
		setRotationAngle(leftArm, -1.2217F, 0.0F, 0.0F);
		

		leftArm_r1 = new ModelRenderer(this);
		leftArm_r1.setRotationPoint(-13.0F, 5.3851F, -24.7753F);
		leftArm.addChild(leftArm_r1);
		setRotationAngle(leftArm_r1, 0.6981F, 0.0F, 0.0F);
		leftArm_r1.setTextureOffset(240, 96).addBox(-11.0F, -36.0F, -12.0F, 24.0F, 72.0F, 24.0F, 0.0F, false);

		rightArm = new ModelRenderer(this);
		rightArm.setRotationPoint(24.0F, -88.0F, 13.0F);
		Body.addChild(rightArm);
		setRotationAngle(rightArm, -1.2217F, 0.0F, 0.0F);
		

		rightArm_r1 = new ModelRenderer(this);
		rightArm_r1.setRotationPoint(13.0F, 5.3851F, -25.7753F);
		rightArm.addChild(rightArm_r1);
		setRotationAngle(rightArm_r1, 0.6981F, 0.0F, 0.0F);
		rightArm_r1.setTextureOffset(240, 96).addBox(-13.0F, -36.0F, -12.0F, 24.0F, 72.0F, 24.0F, 0.0F, true);

		leftLeg = new ModelRenderer(this);
		leftLeg.setRotationPoint(-11.0F, -70.0F, 7.0F);
		Body.addChild(leftLeg);
		leftLeg.setTextureOffset(96, 288).addBox(-13.0F, -2.0F, -8.0F, 24.0F, 72.0F, 24.0F, 0.0F, false);

		rightLeg = new ModelRenderer(this);
		rightLeg.setRotationPoint(8.0F, -70.0F, 7.0F);
		Body.addChild(rightLeg);
		rightLeg.setTextureOffset(96, 288).addBox(-8.0F, -2.0F, -8.0F, 24.0F, 72.0F, 24.0F, 0.0F, true);

		head = new ModelRenderer(this);
		head.setRotationPoint(0.0F, -145.0F, 6.0F);
		Body.addChild(head);
		

		head_r1 = new ModelRenderer(this);
		head_r1.setRotationPoint(0.0F, -22.5157F, -3.1312F);
		head.addChild(head_r1);
		setRotationAngle(head_r1, 0.1309F, 0.0F, 0.0F);
		head_r1.setTextureOffset(0, 0).addBox(-24.0F, -24.0F, -24.0F, 48.0F, 48.0F, 48.0F, 0.0F, false);
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
        this.rightLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 0.7F * limbSwingAmount;
        this.leftLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 0.7F * limbSwingAmount;
        
	}
	
}