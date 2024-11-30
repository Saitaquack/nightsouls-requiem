package com.saita.legendsawaken.entities.models;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.saita.legendsawaken.LegendsAwakenMod;
import com.saita.legendsawaken.entities.mobs.StalkerEntity;

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

public class StalkerModel<T extends StalkerEntity> extends EntityModel<T> {
	
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(LegendsAwakenMod.MOD_ID, "stalker_entity"), "main");
	
	private final ModelParts parts;

	public StalkerModel(ModelPart root) {
		
		ModelPart body = root.getChild("Body");
		ModelPart head = body.getChild("head");
		ModelPart chest = body.getChild("chest");
		ModelPart limbs = body.getChild("limbs");
		ModelPart leftLeg = body.getChild("leftLeg");
		ModelPart rightLeg = body.getChild("rightLeg");
		
		ModelPart limb1 = limbs.getChild("limb1_r1");
		ModelPart limb2 = limbs.getChild("limb2_r1");
		ModelPart limb3 = limbs.getChild("limb3_r1");
		ModelPart limb4 = limbs.getChild("limb4_r1");
		ModelPart limb5 = limbs.getChild("limb5_r1");
		ModelPart limb6 = limbs.getChild("limb6_r1");
		
		this.parts = new ModelParts(body, head, chest, limbs, leftLeg, rightLeg, limb1, limb2, limb3, limb4, limb5, limb6);
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Body = partdefinition.addOrReplaceChild("Body", CubeListBuilder.create(), PartPose.offset(-5.0F, 2.0F, -1.0F));

		Body.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 16).addBox(-6.0F, -12.0F, -6.0F, 12.0F, 12.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offset(5.0F, -28.0F, 0.0F));
		Body.addOrReplaceChild("chest", CubeListBuilder.create().texOffs(0, 40).addBox(-6.0F, -26.0F, -2.0F, 12.0F, 29.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(5.0F, -2.0F, 0.0F));

		PartDefinition limbs = Body.addOrReplaceChild("limbs", CubeListBuilder.create(), PartPose.offset(5.0F, 22.0F, 1.0F));
		
		limbs.addOrReplaceChild("limb6_r1", CubeListBuilder.create().texOffs(0, 0).addBox(-35.0F, -3.0F, -2.0F, 35.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.0F, -43.0F, 1.0F, 0.0F, -0.6981F, -0.3491F));
		limbs.addOrReplaceChild("limb5_r1", CubeListBuilder.create().texOffs(0, 8).addBox(0.0F, -3.0F, -2.0F, 35.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.0F, -43.0F, 1.0F, 0.0F, 0.6981F, 0.3491F));
		limbs.addOrReplaceChild("limb4_r1", CubeListBuilder.create().texOffs(36, 16).addBox(-20.0F, -2.0F, -2.0F, 20.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.0F, -38.0F, 1.0F, 0.0F, -0.1745F, -0.2094F));
		limbs.addOrReplaceChild("limb3_r1", CubeListBuilder.create().texOffs(36, 22).addBox(-1.0F, -2.0F, -2.0F, 20.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.0F, -38.0F, 1.0F, 0.0F, 0.1745F, 0.2094F));
		limbs.addOrReplaceChild("limb2_r1", CubeListBuilder.create().texOffs(34, 40).addBox(-19.0F, -2.0F, -2.0F, 20.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-7.0F, -30.0F, 1.0F, 0.0F, -0.3491F, -0.5236F));
		limbs.addOrReplaceChild("limb1_r1", CubeListBuilder.create().texOffs(34, 46).addBox(-1.0F, -2.0F, -2.0F, 20.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.0F, -30.0F, 1.0F, 0.0F, 0.3491F, 0.5236F));

		Body.addOrReplaceChild("leftLeg", CubeListBuilder.create().texOffs(46, 52).addBox(-2.0F, 0.0F, -1.0F, 3.0F, 21.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(1.0F, 1.0F, 0.0F));
		Body.addOrReplaceChild("rightLeg", CubeListBuilder.create().texOffs(34, 52).addBox(-1.0F, 0.0F, -1.0F, 3.0F, 21.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(9.0F, 1.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}
	
	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.parts.head().yRot = netHeadYaw * Mth.DEG_TO_RAD;
		this.parts.head().xRot = headPitch * Mth.DEG_TO_RAD;
		
		this.parts.leftLeg().xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
		this.parts.rightLeg().xRot = Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount;
		
		this.parts.limb1().zRot = 0.1F * Mth.sin(ageInTicks * 0.1F + 1.0F + 0.4F);
		this.parts.limb2().zRot = 0.1F * Mth.sin(ageInTicks * 0.1F + 2.0F + 0.4F);
		this.parts.limb3().zRot = 0.1F * Mth.sin(ageInTicks * 0.1F + 3.0F + 0.4F);
		this.parts.limb4().zRot = 0.1F * Mth.sin(ageInTicks * 0.1F + 4.0F + 0.4F);
		this.parts.limb5().zRot = 0.1F * Mth.sin(ageInTicks * 0.1F + 5.0F + 0.4F);
		this.parts.limb6().zRot = 0.1F * Mth.sin(ageInTicks * 0.1F + 6.0F + 0.4F);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		this.parts.body().render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
	
	private record ModelParts(ModelPart body, ModelPart head, ModelPart chest, ModelPart limbs, ModelPart leftLeg, ModelPart rightLeg, ModelPart limb1, ModelPart limb2, ModelPart limb3, ModelPart limb4, ModelPart limb5, ModelPart limb6) {
		
	}
}