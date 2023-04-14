package com.saita.nightsoulsmod.entities.render;

import com.saita.nightsoulsmod.NightSoulsMod;
import com.saita.nightsoulsmod.entities.entity.RetinazerEntity;
import com.saita.nightsoulsmod.entities.model.RetinazerModel;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class RetinazerRenderer extends MobRenderer<RetinazerEntity, RetinazerModel<RetinazerEntity>>
{
    protected static final ResourceLocation TEXTURE =
            new ResourceLocation(NightSoulsMod.MOD_ID, "textures/entity/retinazer.png");

    public RetinazerRenderer(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new RetinazerModel<>(), 5.0F);
    }

    @Override
    public ResourceLocation getEntityTexture(RetinazerEntity entity) {
        return TEXTURE;
    }
    
}