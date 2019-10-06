package dev.acri.worldcontrol.utils;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.World;

public class StorageManager {
	
	private static List<OptionsStorage> storage = new ArrayList<OptionsStorage>(); 
	
	public static void addWorld(World w) {
		storage.add(new OptionsStorage(w));
	}
	
	public static void addStorage(OptionsStorage OS) {
		storage.add(OS);
	}
	
	public static List<OptionsStorage> getStorage(){
		return storage;
	}
	
	public static OptionsStorage getFromWorld(World w){
		for(OptionsStorage st : storage) {
			if(st.getWorld().equals(w))
				return st;
		}
		return null;
	}
	
	public static OptionsStorage getFromWorld(String w){
		for(OptionsStorage st : storage) {
			if(st.getWorld().getName().equals(w))
				return st;
		}
		return null;
	}

}
