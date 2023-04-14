package com.saita.nightsoulsmod.entities.model;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.saita.nightsoulsmod.entities.entity.DemonEyeEntity;

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;

public class DemonEyeModel <T extends DemonEyeEntity> extends EntityModel<T> {
	
	private final ModelRenderer Body;
	private final ModelRenderer Head;
	private final ModelRenderer Tentacles;
	private final ModelRenderer Tentacle4;
	private final ModelRenderer Tentacle3;
	private final ModelRenderer Tentacle2;
	private final ModelRenderer Tentacle1;
	private final ModelRenderer Tentacle5;
	private final ModelRenderer Tentacle6;

	public DemonEyeModel() {
		
		textureWidth = 95;
 	    textureHeight = 24;
 	    Body = new ModelRenderer(this);
 		Body.setRotationPoint(0.0F, 24.0F, 0.0F);
 			
 		Head = new ModelRenderer(this);
 		Head.setRotationPoint(0.0F, 0.0F, 0.0F);
 		Body.addChild(Head);
 		Head.setTextureOffset(0, 0).addBox(-6.0F, -13.0F, -7.0F, 12.0F, 12.0F, 12.0F, 0.0F, false);

 		Tentacles = new ModelRenderer(this);
 		Tentacles.setRotationPoint(0.0F, 0.0F, 0.0F);
 		Body.addChild(Tentacles);
 		

 		Tentacle4 = new ModelRenderer(this);
 		Tentacle4.setRotationPoint(-4.0F, -3.0F, 0.0F);
 		Tentacles.addChild(Tentacle4);
 		Tentacle4.setTextureOffset(71, 1).addBox(2.0F, -4.0F, 4.0F, 1.0F, 1.0F, 10.0F, 0.0F, false);

 		Tentacle3 = new ModelRenderer(this);
 		Tentacle3.setRotationPoint(0.0F, 0.0F, 0.0F);
 		Tentacles.addChild(Tentacle3);
 		Tentacle3.setTextureOffset(71, 2).addBox(1.0F, -7.0F, 4.0F, 1.0F, 1.0F, 10.0F, 0.0F, false);

 		Tentacle2 = new ModelRenderer(this);
 		Tentacle2.setRotationPoint(0.0F, 0.0F, 0.0F);
 		Tentacles.addChild(Tentacle2);
 		Tentacle2.setTextureOffset(55, 12).addBox(-4.0F, -4.0F, 4.0F, 1.0F, 1.0F, 10.0F, 0.0F, false);

 		Tentacle1 = new ModelRenderer(this);
 		Tentacle1.setRotationPoint(0.0F, 0.0F, 0.0F);
 		Tentacles.addChild(Tentacle1);
 		Tentacle1.setTextureOffset(73, 2).addBox(3.0F, -4.0F, 4.0F, 1.0F, 1.0F, 10.0F, 0.0F, false);

 		Tentacle5 = new ModelRenderer(this);
 		Tentacle5.setRotationPoint(0.0F, -6.0F, 0.0F);
 		Tentacles.addChild(Tentacle5);
 		Tentacle5.setTextureOffset(62, 6).addBox(3.0F, -5.0F, 4.0F, 1.0F, 1.0F, 10.0F, 0.0F, false);

 		Tentacle6 = new ModelRenderer(this);
 		Tentacle6.setRotationPoint(-6.0F, -6.0F, 0.0F);
 		Tentacles.addChild(Tentacle6);
 		Tentacle6.setTextureOffset(53, 1).addBox(2.0F, -5.0F, 4.0F, 1.0F, 1.0F, 10.0F, 0.0F, false);


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
		
        this.Tentacle3.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 0.2F * limbSwingAmount;
        this.Tentacle2.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 0.2F * limbSwingAmount;
        this.Tentacle6.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 0.2F * limbSwingAmount;
        
        this.Tentacle1.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 0.2F * limbSwingAmount;
        this.Tentacle4.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 0.2F * limbSwingAmount;
        this.Tentacle5.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 0.2F * limbSwingAmount;

	}
	
}