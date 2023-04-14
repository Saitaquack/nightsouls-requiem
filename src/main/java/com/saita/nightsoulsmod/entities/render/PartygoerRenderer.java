package com.saita.nightsoulsmod.entities.render;

import com.saita.nightsoulsmod.NightSoulsMod;
import com.saita.nightsoulsmod.entities.entity.PartygoerEntity;
import com.saita.nightsoulsmod.entities.model.PartygoerModel;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class PartygoerRenderer extends MobRenderer<PartygoerEntity, PartygoerModel<PartygoerEntity>>
{
    protected static final ResourceLocation TEXTURE =
            new ResourceLocation(NightSoulsMod.MOD_ID, "textures/entity/partygoer.png");

    public PartygoerRenderer(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new PartygoerModel<>(), 0.75F);
    }

    @Override
    public ResourceLocation getEntityTexture(PartygoerEntity entity) {
        return TEXTURE;
    }
    
}