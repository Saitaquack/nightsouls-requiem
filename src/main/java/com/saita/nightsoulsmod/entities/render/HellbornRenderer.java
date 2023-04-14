package com.saita.nightsoulsmod.entities.render;

import com.saita.nightsoulsmod.NightSoulsMod;
import com.saita.nightsoulsmod.entities.entity.HellbornEntity;
import com.saita.nightsoulsmod.entities.model.HellbornModel;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class HellbornRenderer extends MobRenderer<HellbornEntity, HellbornModel<HellbornEntity>>
{
    protected static final ResourceLocation TEXTURE =
            new ResourceLocation(NightSoulsMod.MOD_ID, "textures/entity/hellborn.png");

    public HellbornRenderer(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new HellbornModel<>(), 0.5F);
    }

    @Override
    public ResourceLocation getEntityTexture(HellbornEntity entity) {
        return TEXTURE;
    }
    
}