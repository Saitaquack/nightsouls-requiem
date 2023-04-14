package com.saita.nightsoulsmod.entities.render;

import com.saita.nightsoulsmod.NightSoulsMod;
import com.saita.nightsoulsmod.entities.entity.SpazmatismEntity;
import com.saita.nightsoulsmod.entities.model.SpazmatismModel;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class SpazmatismRenderer extends MobRenderer<SpazmatismEntity, SpazmatismModel<SpazmatismEntity>>
{
    protected static final ResourceLocation TEXTURE =
            new ResourceLocation(NightSoulsMod.MOD_ID, "textures/entity/spazmatism.png");

    public SpazmatismRenderer(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new SpazmatismModel<>(), 5.0F);
    }

    @Override
    public ResourceLocation getEntityTexture(SpazmatismEntity entity) {
        return TEXTURE;
    }
    
}