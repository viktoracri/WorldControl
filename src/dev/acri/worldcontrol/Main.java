package dev.acri.worldcontrol;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import dev.acri.worldcontrol.commands.ControlCommand;
import dev.acri.worldcontrol.events.AsyncPlayerChatListener;
import dev.acri.worldcontrol.events.BlockBreakListener;
import dev.acri.worldcontrol.events.BlockPlaceListener;
import dev.acri.worldcontrol.events.EntityDamageByEntityListener;
import dev.acri.worldcontrol.events.EntityDamageListener;
import dev.acri.worldcontrol.events.EntityRegainHealthListener;
import dev.acri.worldcontrol.events.EntitySpawnListener;
import dev.acri.worldcontrol.events.InventoryClickListener;
import dev.acri.worldcontrol.events.PlayerInteractListener;
import dev.acri.worldcontrol.events.PlayerMoveListener;
import dev.acri.worldcontrol.inventory.InventoryManager;
import dev.acri.worldcontrol.utils.ConfigManager;
import dev.acri.worldcontrol.utils.Metrics;

public class Main extends JavaPlugin{
	
	private static Main instance;
	
	
	@Override
	public void onEnable() {
		Main.instance = this;
		
		this.saveDefaultConfig();
		
		getCommand("control").setExecutor(new ControlCommand());
		Bukkit.getPluginManager().registerEvents(new InventoryClickListener(), this);
		Bukkit.getPluginManager().registerEvents(new PlayerInteractListener(), this);
		Bukkit.getPluginManager().registerEvents(new EntityDamageByEntityListener(), this);
		Bukkit.getPluginManager().registerEvents(new BlockBreakListener(), this);
		Bukkit.getPluginManager().registerEvents(new BlockPlaceListener(), this);
		Bukkit.getPluginManager().registerEvents(new EntityRegainHealthListener(), this);
		Bukkit.getPluginManager().registerEvents(new PlayerMoveListener(), this);
		Bukkit.getPluginManager().registerEvents(new AsyncPlayerChatListener(), this);
		Bukkit.getPluginManager().registerEvents(new EntityDamageListener(), this);
		Bukkit.getPluginManager().registerEvents(new EntitySpawnListener(), this);
		
		
		ConfigManager.loadConfigsToStorage();

		InventoryManager.startRunnable();
		
		new Metrics(this);
		
	}
	
	@Override
	public void onDisable() {
		ConfigManager.saveStorageToConfigs();
		
	}
	
	public static Main getInstance() {
		return instance;
	}

}
