package com.saita.nightsoulsmod.entities.render;

import com.saita.nightsoulsmod.NightSoulsMod;
import com.saita.nightsoulsmod.entities.entity.TitanEntity;
import com.saita.nightsoulsmod.entities.model.TitanModel;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class TitanRenderer extends MobRenderer<TitanEntity, TitanModel<TitanEntity>>
{
    protected static final ResourceLocation TEXTURE =
            new ResourceLocation(NightSoulsMod.MOD_ID, "textures/entity/titan.png");

    public TitanRenderer(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new TitanModel<>(), 2.0F);
    }

    @Override
    public ResourceLocation getEntityTexture(TitanEntity entity) {
        return TEXTURE;
    }
    
}