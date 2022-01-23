package com.saita.nightsoulsmod.entities.render;

import com.saita.nightsoulsmod.NightSoulsMod;
import com.saita.nightsoulsmod.entities.entity.PaladinEntity;
import com.saita.nightsoulsmod.entities.model.PaladinModel;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class PaladinRenderer extends MobRenderer<PaladinEntity, PaladinModel<PaladinEntity>>
{
    protected static final ResourceLocation TEXTURE =
            new ResourceLocation(NightSoulsMod.MOD_ID, "textures/entity/paladin.png");

    public PaladinRenderer(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new PaladinModel<>(), 0.5F);
    }

    @Override
    public ResourceLocation getEntityTexture(PaladinEntity entity) {
        return TEXTURE;
    }
    
}