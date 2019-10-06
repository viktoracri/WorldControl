package dev.acri.worldcontrol.events;

import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

import dev.acri.worldcontrol.utils.StorageManager;

public class EntityDamageListener implements Listener{
	
	@EventHandler
	public void onEntityDamage(EntityDamageEvent e) {
		if(e.getEntityType() == EntityType.PLAYER) {
			Player p = (Player) e.getEntity();
			if(StorageManager.getFromWorld(p.getWorld()).isInvincibilityEnabled() && !p.hasPermission("worldcontrol.player.invincibility.bypass") && !p.isOp()) {
				e.setCancelled(true);
			}
		}
		
		
	}

}
