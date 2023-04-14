package com.saita.nightsoulsmod.entities.render;

import com.saita.nightsoulsmod.NightSoulsMod;
import com.saita.nightsoulsmod.entities.entity.EyeOfCthulhuEntity;
import com.saita.nightsoulsmod.entities.model.EyeOfCthulhuModel;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class EyeOfCthulhuRenderer extends MobRenderer<EyeOfCthulhuEntity, EyeOfCthulhuModel<EyeOfCthulhuEntity>>
{
    protected static final ResourceLocation TEXTURE =
            new ResourceLocation(NightSoulsMod.MOD_ID, "textures/entity/eye_of_cthulhu.png");

    public EyeOfCthulhuRenderer(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new EyeOfCthulhuModel<>(), 5.0F);
    }

    @Override
    public ResourceLocation getEntityTexture(EyeOfCthulhuEntity entity) {
        return TEXTURE;
    }
    
}