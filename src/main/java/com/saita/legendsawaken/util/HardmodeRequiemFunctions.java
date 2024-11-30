package com.saita.legendsawaken.util;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;

public class HardmodeRequiemFunctions {
	
	public static boolean isHardmode(ServerLevel level) {
					
		LegendsAwakenSavedData savedData = LegendsAwakenSavedData.get(level);
		
		if(savedData.getValue() > 0) {
			return true;
		} else {
			return false;
		}		
		
	}
	
	public static boolean isNotHardmode(ServerLevel level) {
		
		LegendsAwakenSavedData savedData = LegendsAwakenSavedData.get(level);
		
		if(savedData.getValue() == 0) {
			return true;
		} else {
			return false;
		}		
		
	}
	
	public static boolean isRequiem(ServerLevel level) {
		
		LegendsAwakenSavedData savedData = LegendsAwakenSavedData.get(level);
		
		if(savedData.getValue() > 1) {
			return true;
		} else {
			return false;
		}		
		
	}
	
	public static boolean isNotRequiem(ServerLevel level) {
		
		LegendsAwakenSavedData savedData = LegendsAwakenSavedData.get(level);
		
		if(savedData.getValue() <= 1) {
			return true;
		} else {
			return false;
		}		
		
	}
	
	public static void setHardmode(ServerLevel level) {
		
		LegendsAwakenSavedData savedData = LegendsAwakenSavedData.get(level);
		CompoundTag tag = new CompoundTag();
		
		savedData.setValue(1);
		savedData.save(tag);	
		
	}
	
	public static void removeHardmode(ServerLevel level) {
		
		LegendsAwakenSavedData savedData = LegendsAwakenSavedData.get(level);
		CompoundTag tag = new CompoundTag();
		
		savedData.setValue(0);
		savedData.save(tag);	
		
	}
	
	public static void setRequiem(ServerLevel level) {
		
		LegendsAwakenSavedData savedData = LegendsAwakenSavedData.get(level);
		CompoundTag tag = new CompoundTag();
		
		savedData.setValue(2);
		savedData.save(tag);	
		
	}

}
