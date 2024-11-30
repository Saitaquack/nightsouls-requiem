package com.saita.legendsawaken.entities.render;

import com.saita.legendsawaken.LegendsAwakenMod;

import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.ZombieRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.monster.Zombie;

public class CorruptZombieRenderer extends ZombieRenderer {

	public CorruptZombieRenderer(EntityRendererProvider.Context p_174456_) {
	      this(p_174456_, ModelLayers.ZOMBIE, ModelLayers.ZOMBIE_INNER_ARMOR, ModelLayers.ZOMBIE_OUTER_ARMOR);
	   }

   public CorruptZombieRenderer(EntityRendererProvider.Context p_174458_, ModelLayerLocation p_174459_, ModelLayerLocation p_174460_, ModelLayerLocation p_174461_) {
      super(p_174458_);
   }

	private static final ResourceLocation TEXTURE = new ResourceLocation(LegendsAwakenMod.MOD_ID, "textures/entity/corrupt_zombie.png");
	
	@Override
	public ResourceLocation getTextureLocation(Zombie entity) {
		return TEXTURE;
	}

}
