package com.saita.nightsoulsmod.entities.render;

import com.saita.nightsoulsmod.NightSoulsMod;
import com.saita.nightsoulsmod.entities.entity.RealityWalkerEntity;
import com.saita.nightsoulsmod.entities.model.RealityWalkerModel;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class RealityWalkerRenderer extends MobRenderer<RealityWalkerEntity, RealityWalkerModel<RealityWalkerEntity>>
{
    protected static final ResourceLocation TEXTURE =
            new ResourceLocation(NightSoulsMod.MOD_ID, "textures/entity/reality_walker.png");

    public RealityWalkerRenderer(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new RealityWalkerModel<>(), 0.5F);
    }

    @Override
    public ResourceLocation getEntityTexture(RealityWalkerEntity entity) {
        return TEXTURE;
    }
    
}