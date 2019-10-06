package dev.acri.worldcontrol.events;

import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityRegainHealthEvent;

import dev.acri.worldcontrol.utils.StorageManager;

public class EntityRegainHealthListener implements Listener{
	
	@EventHandler
	public void onEntityRegainHealth(EntityRegainHealthEvent e) {
		
		if(e.getEntityType() == EntityType.PLAYER && !StorageManager.getFromWorld(((Player)e.getEntity()).getWorld()).isRegenEnabled())
			if(!((Player) e.getEntity()).hasPermission("worldcontrol.player.regen.bypass") && !((Player) e.getEntity()).isOp()) {
				e.setCancelled(true);
			}
	}

}
