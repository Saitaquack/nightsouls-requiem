package com.saita.legendsawaken.events;

import com.saita.legendsawaken.LegendsAwakenMod;
import com.saita.legendsawaken.entities.models.*;
import com.saita.legendsawaken.entities.render.*;
import com.saita.legendsawaken.entities.render.projectiles.*;
import com.saita.legendsawaken.init.EntityInit;

import net.minecraft.client.renderer.entity.ThrownItemRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent.RegisterLayerDefinitions;
import net.minecraftforge.client.event.EntityRenderersEvent.RegisterRenderers;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@Mod.EventBusSubscriber(modid = LegendsAwakenMod.MOD_ID, bus = Bus.MOD, value = Dist.CLIENT)
public class ClientModEvents {
	
	@SubscribeEvent
	public static void registerRenderers(RegisterRenderers event) {
		//Mobs
		event.registerEntityRenderer(EntityInit.CORRUPT_ZOMBIE.get(), CorruptZombieRenderer::new);
		event.registerEntityRenderer(EntityInit.CORRUPT_SPIDER.get(), CorruptSpiderRenderer::new);
		event.registerEntityRenderer(EntityInit.WEREWOLF.get(), WerewolfRenderer::new);
		event.registerEntityRenderer(EntityInit.REAPER.get(), ReaperRenderer::new);
		event.registerEntityRenderer(EntityInit.WENDIGO.get(), WendigoRenderer::new);
		event.registerEntityRenderer(EntityInit.ALTERNATE.get(), AlternateRenderer::new);
		event.registerEntityRenderer(EntityInit.PARTYGOER.get(), PartygoerRenderer::new);
		event.registerEntityRenderer(EntityInit.DEMON_EYE.get(), DemonEyeRenderer::new);
		event.registerEntityRenderer(EntityInit.STALKER.get(), StalkerRenderer::new);
		
		event.registerEntityRenderer(EntityInit.EYE_OF_CTHULHU.get(), EyeOfCthulhuRenderer::new);
		
		//Projectiles
		event.registerEntityRenderer(EntityInit.AMETHYST_PROJECTILE.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(EntityInit.MYTHRIL_ARROW.get(), MythrilArrowRenderer::new);
		event.registerEntityRenderer(EntityInit.TITANITE_ARROW.get(), TitaniteArrowRenderer::new);
		event.registerEntityRenderer(EntityInit.HELLFIRE_BULLET_PROJECTILE.get(), ThrownItemRenderer::new);
	}
	
	@SubscribeEvent
	public static void registerLayersDefintions(RegisterLayerDefinitions event) {
		
		event.registerLayerDefinition(CorruptZombieModel.LAYER_LOCATION, CorruptZombieModel::createBodyLayer);
		event.registerLayerDefinition(CorruptSpiderModel.LAYER_LOCATION, CorruptSpiderModel::createBodyLayer);
		event.registerLayerDefinition(WerewolfModel.LAYER_LOCATION, WerewolfModel::createBodyLayer);
		event.registerLayerDefinition(ReaperModel.LAYER_LOCATION, ReaperModel::createBodyLayer);
		event.registerLayerDefinition(WendigoModel.LAYER_LOCATION, WendigoModel::createBodyLayer);
		event.registerLayerDefinition(AlternateModel.LAYER_LOCATION, AlternateModel::createBodyLayer);
		event.registerLayerDefinition(PartygoerModel.LAYER_LOCATION, PartygoerModel::createBodyLayer);
		event.registerLayerDefinition(DemonEyeModel.LAYER_LOCATION, DemonEyeModel::createBodyLayer);
		event.registerLayerDefinition(StalkerModel.LAYER_LOCATION, StalkerModel::createBodyLayer);
		
		event.registerLayerDefinition(EyeOfCthulhuModel.LAYER_LOCATION, EyeOfCthulhuModel::createBodyLayer);
	}

}
