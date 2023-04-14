package com.saita.nightsoulsmod.entities.render;

import com.saita.nightsoulsmod.NightSoulsMod;
import com.saita.nightsoulsmod.entities.entity.WindigoEntity;
import com.saita.nightsoulsmod.entities.model.WindigoModel;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class WindigoRenderer extends MobRenderer<WindigoEntity, WindigoModel<WindigoEntity>>
{
    protected static final ResourceLocation TEXTURE =
            new ResourceLocation(NightSoulsMod.MOD_ID, "textures/entity/windigo.png");

    public WindigoRenderer(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new WindigoModel<>(), 0.75F);
    }

    @Override
    public ResourceLocation getEntityTexture(WindigoEntity entity) {
        return TEXTURE;
    }
    
}