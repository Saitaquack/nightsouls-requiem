package com.saita.nightsoulsmod.entities.render;

import com.saita.nightsoulsmod.NightSoulsMod;
import com.saita.nightsoulsmod.entities.entity.DemonEyeEntity;
import com.saita.nightsoulsmod.entities.model.DemonEyeModel;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class DemonEyeRenderer extends MobRenderer<DemonEyeEntity, DemonEyeModel<DemonEyeEntity>>
{
    protected static final ResourceLocation TEXTURE =
            new ResourceLocation(NightSoulsMod.MOD_ID, "textures/entity/demon_eye.png");

    public DemonEyeRenderer(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new DemonEyeModel<>(), 0.75F);
    }

    @Override
    public ResourceLocation getEntityTexture(DemonEyeEntity entity) {
        return TEXTURE;
    }
    
}