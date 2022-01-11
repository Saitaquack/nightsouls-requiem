package com.saita.nightsoulsmod.entities.render;

import com.saita.nightsoulsmod.NightSoulsMod;
import com.saita.nightsoulsmod.entities.entity.PsychoEntity;
import com.saita.nightsoulsmod.entities.model.PsychoModel;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class PsychoRenderer extends MobRenderer<PsychoEntity, PsychoModel<PsychoEntity>>
{
    protected static final ResourceLocation TEXTURE =
            new ResourceLocation(NightSoulsMod.MOD_ID, "textures/entity/psycho.png");

    public PsychoRenderer(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new PsychoModel<>(), 0.5F);
    }

    @Override
    public ResourceLocation getEntityTexture(PsychoEntity entity) {
        return TEXTURE;
    }
    
}