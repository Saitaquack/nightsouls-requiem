package com.saita.nightsoulsmod.entities.render;

import com.saita.nightsoulsmod.NightSoulsMod;
import com.saita.nightsoulsmod.entities.entity.StargazerEntity;
import com.saita.nightsoulsmod.entities.model.StargazerModel;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class StargazerRenderer extends MobRenderer<StargazerEntity, StargazerModel<StargazerEntity>>
{
    protected static final ResourceLocation TEXTURE =
            new ResourceLocation(NightSoulsMod.MOD_ID, "textures/entity/stargazer.png");

    public StargazerRenderer(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new StargazerModel<>(), 0.5F);
    }

    @Override
    public ResourceLocation getEntityTexture(StargazerEntity entity) {
        return TEXTURE;
    }
    
}