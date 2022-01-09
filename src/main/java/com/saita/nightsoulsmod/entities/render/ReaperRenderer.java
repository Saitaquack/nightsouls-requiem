package com.saita.nightsoulsmod.entities.render;

import com.saita.nightsoulsmod.NightSoulsMod;
import com.saita.nightsoulsmod.entities.entity.ReaperEntity;
import com.saita.nightsoulsmod.entities.model.ReaperModel;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class ReaperRenderer extends MobRenderer<ReaperEntity, ReaperModel<ReaperEntity>>
{
    protected static final ResourceLocation TEXTURE =
            new ResourceLocation(NightSoulsMod.MOD_ID, "textures/entity/reaper.png");

    public ReaperRenderer(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new ReaperModel<>(), 0.5F);
    }

    @Override
    public ResourceLocation getEntityTexture(ReaperEntity entity) {
        return TEXTURE;
    }
    
}