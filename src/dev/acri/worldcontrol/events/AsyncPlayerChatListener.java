package dev.acri.worldcontrol.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import dev.acri.worldcontrol.utils.StorageManager;

public class AsyncPlayerChatListener implements Listener{
	
	@EventHandler
	public void onAsyncPlayerChat(AsyncPlayerChatEvent e) {
		if(!StorageManager.getFromWorld(e.getPlayer().getWorld()).isChatEnabled()) {
			if(!e.getPlayer().hasPermission("worldcontrol.player.chat.bypass") && !e.getPlayer().isOp()) {
				e.setCancelled(true);
				e.getPlayer().sendMessage("§cChat is disabled");
			}
		}
	}

}
