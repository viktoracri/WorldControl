package dev.acri.worldcontrol.events;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

import dev.acri.worldcontrol.utils.StorageManager;

public class PlayerInteractListener implements Listener{
	
	@EventHandler
	public void onPlayerInteract(PlayerInteractEvent e) {
		if(!e.getPlayer().hasPermission("worldcontrol.player.crafting.bypass") && !e.getPlayer().isOp()) 
			if(!StorageManager.getFromWorld(e.getPlayer().getWorld()).isCraftingEnabled()) 
				if(e.getClickedBlock().getType() == Material.WORKBENCH) {
					e.getPlayer().sendMessage("§cCrafting is disabled");
					e.setCancelled(true);
				}
		
		
		
	}

}
