package com.saita.legendsawaken.init;

import com.saita.legendsawaken.LegendsAwakenMod;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.levelgen.structure.Structure;

public class TagsInit {
	
	public static class Blocks{
		
		  public static final TagKey<Block> NEEDS_MYTHRIL_TOOL = tag("needs_mythril_tool");
		  public static final TagKey<Block> NEEDS_INFERNAL_TOOL = tag("needs_infernal_tool");	  
		  public static final TagKey<Block> NEEDS_TITANITE_TOOL = tag("needs_titanite_tool");	  
		  
		  private static TagKey<Block> tag(String name) {
	          return BlockTags.create(new ResourceLocation(LegendsAwakenMod.MOD_ID, name));
	      }
	}   
	
	public static class Structures {
		
		public static final TagKey<Structure> THE_ABYSS = tag("the_abyss");

		private static TagKey<Structure> tag(String name){
			return TagKey.create(Registries.STRUCTURE, new ResourceLocation(LegendsAwakenMod.MOD_ID, name));
		}		
		
	}

}
