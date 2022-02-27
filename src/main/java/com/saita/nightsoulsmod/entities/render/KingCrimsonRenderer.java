package com.saita.nightsoulsmod.entities.render;

import com.saita.nightsoulsmod.NightSoulsMod;
import com.saita.nightsoulsmod.entities.entity.KingCrimsonEntity;
import com.saita.nightsoulsmod.entities.model.KingCrimsonModel;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class KingCrimsonRenderer extends MobRenderer<KingCrimsonEntity, KingCrimsonModel<KingCrimsonEntity>>
{
    protected static final ResourceLocation TEXTURE =
            new ResourceLocation(NightSoulsMod.MOD_ID, "textures/entity/king_crimson.png");

    public KingCrimsonRenderer(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new KingCrimsonModel<>(), 0.5F);
    }

    @Override
    public ResourceLocation getEntityTexture(KingCrimsonEntity entity) {
        return TEXTURE;
    }
    
}