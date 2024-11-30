package com.saita.legendsawaken.util;

import javax.annotation.Nonnull;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.saveddata.SavedData;
import net.minecraft.world.level.storage.DimensionDataStorage;

public class LegendsAwakenSavedData extends SavedData {
	
	private int value = 0;
	
	@Nonnull
	public static LegendsAwakenSavedData get(Level level) {
		if(level.isClientSide) {
			throw new RuntimeException("Tried to get ModSavedData client side !");
		}
		
		DimensionDataStorage storage = level.getServer().overworld().getDataStorage();
		return storage.computeIfAbsent(LegendsAwakenSavedData::load, LegendsAwakenSavedData::create, "legends-awaken-saved-data");
		
	}
	
	public int getValue() {
		return this.value;
	}

	public void setValue(int value) {
		if(value == 0 || value == 1 || value == 2) {
			this.value = value;
			this.setDirty();
		}
		else {
			throw new RuntimeException("Illegal setValue value. Value should be equal to 0, 1 or 2.");
		}
		
		
	}
	
	public static LegendsAwakenSavedData create() {
		return new LegendsAwakenSavedData();
	}
	
	public static LegendsAwakenSavedData load(CompoundTag tag) {
		LegendsAwakenSavedData data = create();
		int value = tag.getInt("hardmodevalue");
		data.value = value;
		return data;
	}
	
	@Override
	public CompoundTag save(CompoundTag tag) {
		tag.putInt("hardmodevalue", value);
		return tag;
	}
	
	

}
