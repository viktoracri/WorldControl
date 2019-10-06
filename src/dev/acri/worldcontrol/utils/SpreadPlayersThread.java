package dev.acri.worldcontrol.utils;

import org.bukkit.Bukkit;
import org.bukkit.World;

public class SpreadPlayersThread extends Thread{
	
	private World w;
	
	public SpreadPlayersThread(World w) {
		this.w = w;
	}
	
	public void run() {
		try {
			
			Bukkit.broadcastMessage("§cSpreading all players in §b10 seconds§c...");
			Thread.sleep(5000l);
			Bukkit.broadcastMessage("§cSpreading all players in §b5 seconds§c...");
			Thread.sleep(1000l);
			Bukkit.broadcastMessage("§cSpreading all players in §b4 seconds§c...");
			Thread.sleep(1000l);
			Bukkit.broadcastMessage("§cSpreading all players in §b3 seconds§c...");
			Thread.sleep(1000l);
			Bukkit.broadcastMessage("§cSpreading all players in §b2 seconds§c...");
			Thread.sleep(1000l);
			Bukkit.broadcastMessage("§cSpreading all players in §b1 second§c...");
			Thread.sleep(1000l);
			Bukkit.broadcastMessage("§cSpreading all players");
			
			Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "spreadplayers " + w.getWorldBorder().getCenter().getBlockX() + " " + w.getWorldBorder().getCenter().getBlockZ() + " " + (w.getWorldBorder().getSize() / 20) + " " + (int)(w.getWorldBorder().getSize() / 2) + " false @a");
			
			
		} catch (InterruptedException e) {e.printStackTrace();}
		
		
		
	}

}
