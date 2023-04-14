package com.saita.nightsoulsmod.entities.render;

import com.saita.nightsoulsmod.NightSoulsMod;
import com.saita.nightsoulsmod.entities.entity.WerewolfEntity;
import com.saita.nightsoulsmod.entities.model.WerewolfModel;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class WerewolfRenderer extends MobRenderer<WerewolfEntity, WerewolfModel<WerewolfEntity>>
{
    protected static final ResourceLocation TEXTURE =
            new ResourceLocation(NightSoulsMod.MOD_ID, "textures/entity/werewolf.png");

    public WerewolfRenderer(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new WerewolfModel<>(), 0.7F);
    }

    @Override
    public ResourceLocation getEntityTexture(WerewolfEntity entity) {
        return TEXTURE;
    }
    
}