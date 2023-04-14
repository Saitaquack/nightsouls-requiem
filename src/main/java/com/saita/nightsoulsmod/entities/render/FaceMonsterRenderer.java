package com.saita.nightsoulsmod.entities.render;

import com.saita.nightsoulsmod.NightSoulsMod;
import com.saita.nightsoulsmod.entities.entity.FaceMonsterEntity;
import com.saita.nightsoulsmod.entities.model.FaceMonsterModel;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class FaceMonsterRenderer extends MobRenderer<FaceMonsterEntity, FaceMonsterModel<FaceMonsterEntity>>
{
    protected static final ResourceLocation TEXTURE =
            new ResourceLocation(NightSoulsMod.MOD_ID, "textures/entity/face_monster.png");

    public FaceMonsterRenderer(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new FaceMonsterModel<>(), 0.5F);
    }

    @Override
    public ResourceLocation getEntityTexture(FaceMonsterEntity entity) {
        return TEXTURE;
    }
    
}