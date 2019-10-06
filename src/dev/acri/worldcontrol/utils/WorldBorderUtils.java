package dev.acri.worldcontrol.utils;

import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.WorldBorder;
import org.bukkit.entity.Player;

public class WorldBorderUtils {
	
	public void increaseWorldBorder(Player p, int blocks) {
		WorldBorder border = p.getWorld().getWorldBorder();
		
		if(border.getSize() > 10000000)
			return;
		
		Messager.sendMessageWithSound(p, "The World Border is now expanding to *§b"  + (int)(StorageManager.getFromWorld(p.getWorld()).getBorderSize() + blocks) + " blocks§a.", Sound.ENTITY_CHICKEN_EGG);
		border.setSize(StorageManager.getFromWorld(p.getWorld()).getBorderSize() + blocks, 5);
		StorageManager.getFromWorld(p.getWorld()).setBorderSize(StorageManager.getFromWorld(p.getWorld()).getBorderSize() + blocks);
		
	}
	
	public void decreaseWorldBorder(Player p, int blocks) {
		WorldBorder border =  p.getWorld().getWorldBorder();
		
		if(border.getSize() > 10000000)
			return;
		
		if(StorageManager.getFromWorld(p.getWorld()).getBorderSize() < blocks) {
			border.setSize(1, 5);
			StorageManager.getFromWorld(p.getWorld()).setBorderSize(1);
			Messager.sendMessageWithSound(p, "§aThe World Border's size was set to §b1 block§a.", Sound.ENTITY_CHICKEN_EGG);

		}else {
			Messager.sendMessageWithSound(p, "§aThe World Border is now shrinking to §b" + (int)(StorageManager.getFromWorld(p.getWorld()).getBorderSize() - blocks) + " blocks§a.", Sound.ENTITY_CHICKEN_EGG);
			border.setSize(StorageManager.getFromWorld(p.getWorld()).getBorderSize() - blocks, 5);
			StorageManager.getFromWorld(p.getWorld()).setBorderSize(StorageManager.getFromWorld(p.getWorld()).getBorderSize() - blocks);
			
			}
		
		
	}
	
	public void setBorderCenter(World world, Location loc) {
		world.getWorldBorder().setCenter(loc);
	}

	public void resetWorldBorder(World world) {
		world.getWorldBorder().reset();
		
	}

	public void setDefaultBorder(Player p) {
		StorageManager.getFromWorld(p.getWorld()).setBorderSize(500);
		setBorderCenter(p.getWorld(), p.getLocation());
		p.getWorld().getWorldBorder().setSize(500);
		
		p.sendMessage("§aWorld Border enabled with a range of §b500 blocks§a around your position.");
	}
	
	
}
