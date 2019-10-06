package dev.acri.worldcontrol.commands;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import dev.acri.worldcontrol.inventory.InventoryManager;
import dev.acri.worldcontrol.utils.Messager;

public class ControlCommand implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if(!(sender instanceof Player)) {
			sender.sendMessage("§cThis command is only executable by players.");
			return true;
		}
		
		if(!sender.hasPermission("worldcontrol.use")) {
			sender.sendMessage("§cYou do not have permission.");
			return true;
		}
		
		Player p = (Player) sender;
		InventoryManager manager = new InventoryManager();
		
		if(args.length == 0)
			p.openInventory(manager.getControlInventory(p.getWorld()));
		else if(Bukkit.getWorld(args[0]) == null) {
			Messager.sendMessageWithSound(p, "§cInvalid world name: §7" + args[0], Sound.BLOCK_NOTE_BASS);
		}else {
			p.openInventory(manager.getControlInventory(Bukkit.getWorld(args[0])));
		}
		
		
		
		return true;
	}

}
