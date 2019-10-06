package dev.acri.worldcontrol.events;

import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import dev.acri.worldcontrol.utils.StorageManager;

public class EntityDamageByEntityListener implements Listener{
	
	 @EventHandler
	 public void onEntityDamageByEntity(EntityDamageByEntityEvent e) {
		 if(e.getDamager().getType() == EntityType.PLAYER && e.getEntityType() == EntityType.PLAYER)
			 if(!((Player)e.getDamager()).hasPermission("worldcontrol.player.pvp.bypass") && !((Player)e.getDamager()).isOp())
				 if(!StorageManager.getFromWorld(((Player)e.getDamager()).getWorld()).isPvpEnabled()) {
					 e.setCancelled(true);
					 ((Player)e.getDamager()).sendMessage("§cPVP is disabled.");
				 }
		
	 }

}
