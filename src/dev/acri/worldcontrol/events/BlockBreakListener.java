package dev.acri.worldcontrol.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

import dev.acri.worldcontrol.utils.StorageManager;

public class BlockBreakListener implements Listener{
	
	@EventHandler
	public void onBlockBreak(BlockBreakEvent e) {
		if(!StorageManager.getFromWorld(e.getPlayer().getWorld()).isBuildEnabled())
		if(!e.getPlayer().hasPermission("worldcontrol.player.build.bypass") && !e.getPlayer().isOp()) {
			e.setCancelled(true);
		}
	}

}
