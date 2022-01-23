package com.saita.nightsoulsmod.entities.render;

import com.saita.nightsoulsmod.NightSoulsMod;
import com.saita.nightsoulsmod.entities.entity.HellfireServantEntity;
import com.saita.nightsoulsmod.entities.model.HellfireServantModel;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class HellfireServantRenderer extends MobRenderer<HellfireServantEntity, HellfireServantModel<HellfireServantEntity>>
{
    protected static final ResourceLocation TEXTURE =
            new ResourceLocation(NightSoulsMod.MOD_ID, "textures/entity/hellfire_servant.png");

    public HellfireServantRenderer(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new HellfireServantModel<>(), 0.5F);
    }

    @Override
    public ResourceLocation getEntityTexture(HellfireServantEntity entity) {
        return TEXTURE;
    }
    
}