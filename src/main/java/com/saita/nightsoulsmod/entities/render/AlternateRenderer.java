package com.saita.nightsoulsmod.entities.render;

import com.saita.nightsoulsmod.NightSoulsMod;
import com.saita.nightsoulsmod.entities.entity.AlternateEntity;
import com.saita.nightsoulsmod.entities.model.AlternateModel;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class AlternateRenderer extends MobRenderer<AlternateEntity, AlternateModel<AlternateEntity>>
{
    protected static final ResourceLocation TEXTURE =
            new ResourceLocation(NightSoulsMod.MOD_ID, "textures/entity/alternate.png");

    public AlternateRenderer(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new AlternateModel<>(), 1.0F);
    }

    @Override
    public ResourceLocation getEntityTexture(AlternateEntity entity) {
        return TEXTURE;
    }
    
}