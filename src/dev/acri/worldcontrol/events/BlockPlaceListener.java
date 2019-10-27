package dev.acri.worldcontrol.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

import dev.acri.worldcontrol.utils.StorageManager;

public class BlockPlaceListener implements Listener{
	
	@EventHandler
	public void onBlockPlace(BlockPlaceEvent e) {
		if(!StorageManager.getFromWorld(e.getPlayer().getWorld()).isBuildEnabled())
			if(!e.getPlayer().hasPermission("worldcontrol.player.build.bypass") && !e.getPlayer().isOp()) {
				e.setCancelled(true);
			}
	}

}
