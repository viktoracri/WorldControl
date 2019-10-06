package dev.acri.worldcontrol.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import dev.acri.worldcontrol.utils.StorageManager;

public class PlayerMoveListener implements Listener{
	
	@EventHandler
	public void onPlayerMove(PlayerMoveEvent e) {
		if(StorageManager.getFromWorld(e.getPlayer().getWorld()).isFreezeEnabled()) {
			if(!e.getPlayer().hasPermission("worldcontrol.player.freeze.bypass") && !e.getPlayer().isOp()) {
				e.setCancelled(true);
			}
		}
		
	}

}
