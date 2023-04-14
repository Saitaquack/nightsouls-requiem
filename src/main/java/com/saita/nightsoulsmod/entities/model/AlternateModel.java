package com.saita.nightsoulsmod.entities.model;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.saita.nightsoulsmod.entities.entity.AlternateEntity;

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;

public class AlternateModel <T extends AlternateEntity> extends EntityModel<T> {
	
	private final ModelRenderer Body;
	private final ModelRenderer head;
	private final ModelRenderer topChest;
	private final ModelRenderer topChest_r1;
	private final ModelRenderer bottomChest;
	private final ModelRenderer rightArm;
	private final ModelRenderer rightArm_r1;
	private final ModelRenderer leftArm;
	private final ModelRenderer leftArm_r1;
	private final ModelRenderer rightLeg;
	private final ModelRenderer leftLeg;

	public AlternateModel() {
        
		textureWidth = 64;
		textureHeight = 64;

		Body = new ModelRenderer(this);
		Body.setRotationPoint(0.0F, 24.0F, 0.0F);
		

		head = new ModelRenderer(this);
		head.setRotationPoint(0.0F, -68.0F, -9.0F);
		Body.addChild(head);
		head.setTextureOffset(2, 24).addBox(-8.0F, -17.0F, -6.0F, 16.0F, 18.0F, 12.0F, 0.0F, false);

		topChest = new ModelRenderer(this);
		topChest.setRotationPoint(0.0F, 0.0F, 0.0F);
		Body.addChild(topChest);
		

		topChest_r1 = new ModelRenderer(this);
		topChest_r1.setRotationPoint(0.0F, 0.0F, 0.0F);
		topChest.addChild(topChest_r1);
		setRotationAngle(topChest_r1, 0.5236F, 0.0F, 0.0F);
		topChest_r1.setTextureOffset(-20, 0).addBox(-6.0F, -64.0F, 23.0F, 12.0F, 21.0F, 6.0F, 0.0F, false);

		bottomChest = new ModelRenderer(this);
		bottomChest.setRotationPoint(0.0F, 0.0F, 0.0F);
		Body.addChild(bottomChest);
		bottomChest.setTextureOffset(-20, 0).addBox(-6.0F, -53.0F, -3.0F, 12.0F, 21.0F, 6.0F, 0.0F, false);

		rightArm = new ModelRenderer(this);
		rightArm.setRotationPoint(0.0F, 0.0F, 0.0F);
		Body.addChild(rightArm);
		

		rightArm_r1 = new ModelRenderer(this);
		rightArm_r1.setRotationPoint(0.0F, 0.0F, 0.0F);
		rightArm.addChild(rightArm_r1);
		setRotationAngle(rightArm_r1, -0.4363F, 0.0F, 0.0F);
		rightArm_r1.setTextureOffset(40, 0).addBox(-12.0F, -59.0F, -37.0F, 6.0F, 52.0F, 6.0F, 0.0F, true);

		leftArm = new ModelRenderer(this);
		leftArm.setRotationPoint(0.0F, 0.0F, 0.0F);
		Body.addChild(leftArm);
		

		leftArm_r1 = new ModelRenderer(this);
		leftArm_r1.setRotationPoint(0.0F, 0.0F, 0.0F);
		leftArm.addChild(leftArm_r1);
		setRotationAngle(leftArm_r1, -0.4363F, 0.0F, 0.0F);
		leftArm_r1.setTextureOffset(40, 0).addBox(6.0F, -59.0F, -37.0F, 6.0F, 52.0F, 6.0F, 0.0F, false);

		rightLeg = new ModelRenderer(this);
		rightLeg.setRotationPoint(-5.0F, -32.0F, -1.0F);
		Body.addChild(rightLeg);
		rightLeg.setTextureOffset(0, 0).addBox(-1.0F, 0.0F, -1.0F, 3.0F, 32.0F, 3.0F, 0.0F, false);

		leftLeg = new ModelRenderer(this);
		leftLeg.setRotationPoint(5.0F, -32.0F, -1.0F);
		Body.addChild(leftLeg);
		leftLeg.setTextureOffset(0, -3).addBox(-2.0F, 0.0F, -1.0F, 3.0F, 32.0F, 3.0F, 0.0F, false);

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