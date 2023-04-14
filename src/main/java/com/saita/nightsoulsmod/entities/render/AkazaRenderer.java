package com.saita.nightsoulsmod.entities.render;

import com.saita.nightsoulsmod.NightSoulsMod;
import com.saita.nightsoulsmod.entities.entity.AkazaEntity;
import com.saita.nightsoulsmod.entities.model.AkazaModel;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class AkazaRenderer extends MobRenderer<AkazaEntity, AkazaModel<AkazaEntity>>
{
    protected static final ResourceLocation TEXTURE =
            new ResourceLocation(NightSoulsMod.MOD_ID, "textures/entity/akaza.png");

    public AkazaRenderer(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new AkazaModel<>(), 0.5F);
    }

    @Override
    public ResourceLocation getEntityTexture(AkazaEntity entity) {
        return TEXTURE;
    }
    
}