package dev.acri.worldcontrol.utils;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.configuration.file.FileConfiguration;

import dev.acri.worldcontrol.Main;

public class ConfigManager {
	
	public static void loadConfigsToStorage(){
		
		for(World w : Bukkit.getWorlds()) {
			OptionsStorage OS = new OptionsStorage(w);
			
			OS.setBorderSize((int)Bukkit.getWorlds().get(0).getWorldBorder().getSize());
			
			FileConfiguration config = Main.getInstance().getConfig();
			if(config.isConfigurationSection(w.getName())){
				OS.setPvpEnabled(config.getBoolean(w.getName() + ".pvpEnabled"));
				OS.setBuildEnabled(config.getBoolean(w.getName() + ".buildEnabled"));
				OS.setCraftingEnabled(config.getBoolean(w.getName() + ".craftingEnabled"));
				OS.setRegenEnabled(config.getBoolean(w.getName() + ".regenEnabled"));
				OS.setFreezeEnabled(config.getBoolean(w.getName() + ".freezeEnabled"));
				OS.setChatEnabled(config.getBoolean(w.getName() + ".chatEnabled"));
				OS.setInvincibilityEnabled(config.getBoolean(w.getName() + ".invincibilityEnabled"));
				OS.setExtremeDifficultyEnabled(config.getBoolean(w.getName() + ".extremeDifficultyEnabled"));
			}
			
			StorageManager.addStorage(OS);
		}
	}
	
	public static void saveStorageToConfigs() {

		for(World w : Bukkit.getWorlds()) {
			OptionsStorage os = StorageManager.getFromWorld(w);
			
			FileConfiguration config = Main.getInstance().getConfig();
			
			config.set(w.getName() + ".pvpEnabled", os.isPvpEnabled());
			config.set(w.getName() + ".buildEnabled", os.isBuildEnabled());
			config.set(w.getName() + ".craftingEnabled", os.isCraftingEnabled());
			config.set(w.getName() + ".regenEnabled", os.isRegenEnabled());
			config.set(w.getName() + ".freezeEnabled", os.isFreezeEnabled());
			config.set(w.getName() + ".chatEnabled", os.isChatEnabled());
			config.set(w.getName() + ".invincibilityEnabled", os.isInvincibilityEnabled());
			config.set(w.getName() + ".extremeDifficultyEnabled", os.isExtremeDifficultyEnabled());
			
			Main.getInstance().saveConfig();
			
		}
	}
	
	
}
