package com.saita.nightsoulsmod.entities.model;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.saita.nightsoulsmod.entities.entity.SpazmatismEntity;

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;

public class SpazmatismModel <T extends SpazmatismEntity> extends EntityModel<T> {
	
	private final ModelRenderer Body;
	private final ModelRenderer Head;
	private final ModelRenderer Tentacles;
	private final ModelRenderer Tentacle2;
	private final ModelRenderer Tentacle4;
	private final ModelRenderer Tentacle1;
	private final ModelRenderer Tentacle3;
	private final ModelRenderer Tentacle5;
	private final ModelRenderer Tentacle6;

	public SpazmatismModel() {
		textureWidth = 475;
		textureHeight = 120;

		Body = new ModelRenderer(this);
		Body.setRotationPoint(0.0F, 24.0F, 0.0F);
		

		Head = new ModelRenderer(this);
		Head.setRotationPoint(16.0F, 0.0F, -5.0F);
		Body.addChild(Head);
		Head.setTextureOffset(0, 0).addBox(-46.0F, -65.0F, -25.0F, 60.0F, 60.0F, 60.0F, 0.0F, false);

		Tentacles = new ModelRenderer(this);
		Tentacles.setRotationPoint(0.0F, 0.0F, 0.0F);
		Body.addChild(Tentacles);
		

		Tentacle2 = new ModelRenderer(this);
		Tentacle2.setRotationPoint(-4.0F, -3.0F, 0.0F);
		Tentacles.addChild(Tentacle2);
		Tentacle2.setTextureOffset(365, 0).addBox(-16.0F, -17.0F, 25.0F, 5.0F, 5.0F, 50.0F, 0.0F, false);

		Tentacle4 = new ModelRenderer(this);
		Tentacle4.setRotationPoint(0.0F, 0.0F, 0.0F);
		Tentacles.addChild(Tentacle4);
		Tentacle4.setTextureOffset(365, 65).addBox(-10.0F, -35.0F, 25.0F, 5.0F, 5.0F, 50.0F, 0.0F, false);

		Tentacle1 = new ModelRenderer(this);
		Tentacle1.setRotationPoint(0.0F, 0.0F, 0.0F);
		Tentacles.addChild(Tentacle1);
		Tentacle1.setTextureOffset(365, 65).addBox(15.0F, -20.0F, 25.0F, 5.0F, 5.0F, 50.0F, 0.0F, false);

		Tentacle3 = new ModelRenderer(this);
		Tentacle3.setRotationPoint(0.0F, 0.0F, 0.0F);
		Tentacles.addChild(Tentacle3);
		Tentacle3.setTextureOffset(365, 0).addBox(5.0F, -35.0F, 25.0F, 5.0F, 5.0F, 50.0F, 0.0F, false);

		Tentacle5 = new ModelRenderer(this);
		Tentacle5.setRotationPoint(0.0F, -6.0F, 0.0F);
		Tentacles.addChild(Tentacle5);
		Tentacle5.setTextureOffset(265, 54).addBox(15.0F, -49.0F, 25.0F, 5.0F, 5.0F, 50.0F, 0.0F, false);

		Tentacle6 = new ModelRenderer(this);
		Tentacle6.setRotationPoint(-6.0F, -6.0F, 0.0F);
		Tentacles.addChild(Tentacle6);
		Tentacle6.setTextureOffset(265, 5).addBox(-14.0F, -49.0F, 25.0F, 5.0F, 5.0F, 50.0F, 0.0F, false);
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		Body.render(matrixStack, buffer, packedLight, packedOverlay);
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