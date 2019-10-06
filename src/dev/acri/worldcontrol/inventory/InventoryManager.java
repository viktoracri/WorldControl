package dev.acri.worldcontrol.inventory;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitRunnable;

import dev.acri.worldcontrol.Main;
import dev.acri.worldcontrol.utils.HiddenStringUtils;
import dev.acri.worldcontrol.utils.ItemStackUtils;
import dev.acri.worldcontrol.utils.StorageManager;

public class InventoryManager {
	
	DecimalFormat numFormat = new DecimalFormat("###.0");
	
	public Inventory getControlInventory(World w) {
		Inventory inv = Bukkit.createInventory(null, 54, "WorldControl");
		
		for(int i = 45; i < 54; i++) {
			ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 7);
			ItemMeta meta = item.getItemMeta();
			meta.setDisplayName("§7");
			item.setItemMeta(meta);
			inv.setItem(i, item);
		}
		
		for(int i = 0; i < 9; i++) {
			ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 7);
			ItemMeta meta = item.getItemMeta();
			meta.setDisplayName("§7");
			item.setItemMeta(meta);
			inv.setItem(i, item);
		}
		
		
		
		List<String> lore = new ArrayList<String>();
	
		lore.add("§8» §7Current World: §b" + w.getName());
		lore.add("§7");
		lore.add("§8» §7Plugin by §aViktoracri");
		lore.add("§8» §7Discord: §9Viktoracri#0556");
		
		inv.setItem(4, ItemStackUtils.getItemStack(Material.BOOK, HiddenStringUtils.encodeString("menu;" + w.getName() + ";") + "§aWorldControl", lore));
		lore.clear();
		
		
		lore.add("§7Control what the players can do,");
		lore.add("§7among other values");
		lore.add("§7");
		lore.add("§a» §7Click to open menu");
		
		inv.setItem(12, ItemStackUtils.getItemStack(WCItem.SUBMENU_PLAYER.getItem(), WCItem.SUBMENU_PLAYER.getDisplayname(), lore));
		lore.clear();
		
		lore.add("§7Toggle the World Border, control its");
		lore.add("§7size and its center position.");
		lore.add("§7");
		lore.add("§a» §7Click to open menu");
		
		inv.setItem(14, ItemStackUtils.getItemStack(WCItem.SUBMENU_BORDER.getItem().getType(), WCItem.SUBMENU_BORDER.getDisplayname(), lore));
		lore.clear();
		
		lore.add("§7Control the time in your current");
		lore.add("§7world.");
		lore.add("§7");
		lore.add("§a» §7Click to open menu");
		
		inv.setItem(20, ItemStackUtils.getItemStack(WCItem.SUBMENU_TIME.getItem().getType(), WCItem.SUBMENU_TIME.getDisplayname(), lore));
		lore.clear();
		
		lore.add("§7Choose the global difficulty.");
		lore.add("§7");
		lore.add("§a» §7Click to open menu");
		
		inv.setItem(22, ItemStackUtils.getItemStack(WCItem.SUBMENU_DIFFICULTY.getItem(), WCItem.SUBMENU_DIFFICULTY.getDisplayname(), lore));
		lore.clear();
		
		lore.add("§7Control some of the essential gamerules");
		lore.add("§7in your world.");
		lore.add("§7");
		lore.add("§a» §7Click to open menu");
		
		inv.setItem(24, ItemStackUtils.getItemStack(WCItem.SUBMENU_GAMERULES.getItem().getType(), WCItem.SUBMENU_GAMERULES.getDisplayname(), lore));
		lore.clear();
		
		lore.add("§7Teleportation is a magical thing only");
		lore.add("§7accessible through the gods of Minecraft...");
		lore.add("§7");
		lore.add("§a» §7Click to open menu");
		
		inv.setItem(30, ItemStackUtils.getItemStack(WCItem.SUBMENU_TELEPORTATION.getItem().getType(), WCItem.SUBMENU_TELEPORTATION.getDisplayname(), lore));
		lore.clear();
		
		lore.add("§7Admin related. Do not touch unless");
		lore.add("§7you know what you're doing.");
		lore.add("§7");
		lore.add("§a» §7Click to open menu");
		
		inv.setItem(32, ItemStackUtils.getItemStack(WCItem.SUBMENU_ADMIN.getItem().getType(), WCItem.SUBMENU_ADMIN.getDisplayname(), lore));
		lore.clear();
		
		
		return inv;
	}
	
	public Inventory getPlayerControlInventory(World w) {
		Inventory inv = Bukkit.createInventory(null, 27, "Player");
		List<String> lore = new ArrayList<String>();
		
		lore.add("§7Control what the players can do,");
		lore.add("§7among other values");
		
		inv.setItem(4, ItemStackUtils.getItemStack(Material.BOOK, HiddenStringUtils.encodeString("menu;" + w.getName() + ";") + "§3Player Control", lore));
		lore.clear();
		
		lore.add("§a» §7Click to go back");
		inv.setItem(18, ItemStackUtils.getItemStack(Material.ARROW, HiddenStringUtils.encodeString("back;") + "§eGo Back", lore));
		lore.clear();
		
		
		if(StorageManager.getFromWorld(w).isPvpEnabled()) lore.add("§8» §7Status: §aENABLED");
		else lore.add("§8» §7Status: §cDISABLED");
		lore.add("§7");
		lore.add("§7This will disable all damage done by ");
		lore.add("§7players to other players");
		lore.add("§8§m                 ");
		lore.add("§a» §7Click to toggle");
		
		inv.setItem(10, ItemStackUtils.getItemStack(WCItem.PLAYER_PVP_TOGGLE.getItem().getType(), WCItem.PLAYER_PVP_TOGGLE.getDisplayname(), lore));
		lore.clear();
		
		if(StorageManager.getFromWorld(w).isBuildEnabled()) lore.add("§8» §7Status: §aENABLED");
		else lore.add("§8» §7Status: §cDISABLED");
		lore.add("§7");
		lore.add("§7This will disable all placing and ");
		lore.add("§7breaking of blocks");
		lore.add("§8§m                 ");
		lore.add("§a» §7Click to toggle");
		
		inv.setItem(11, ItemStackUtils.getItemStack(WCItem.PLAYER_BUILD_TOGGLE.getItem().getType(), WCItem.PLAYER_BUILD_TOGGLE.getDisplayname(), lore));
		lore.clear();
		
		if(StorageManager.getFromWorld(w).isCraftingEnabled()) lore.add("§8» §7Status: §aENABLED");
		else lore.add("§8» §7Status: §cDISABLED");
		lore.add("§7");
		lore.add("§7Disable the use of crafting tables");
		lore.add("§8§m                 ");
		lore.add("§a» §7Click to toggle");
		
		inv.setItem(12, ItemStackUtils.getItemStack(WCItem.PLAYER_CRAFTING_TOGGLE.getItem().getType(), WCItem.PLAYER_CRAFTING_TOGGLE.getDisplayname(), lore));
		lore.clear();
		
		if(StorageManager.getFromWorld(w).isRegenEnabled()) lore.add("§8» §7Status: §aENABLED");
		else lore.add("§8» §7Status: §cDISABLED");
		lore.add("§7");
		lore.add("§7Toggle natural regeneration. Regeneration");
		lore.add("§7from golden apples and potions still works.");
		lore.add("§8§m                 ");
		lore.add("§a» §7Click to toggle");
		
		inv.setItem(13, ItemStackUtils.getItemStack(WCItem.PLAYER_REGEN_TOGGLE.getItem().getType(), WCItem.PLAYER_REGEN_TOGGLE.getDisplayname(), lore));
		lore.clear();
		
		if(StorageManager.getFromWorld(w).isFreezeEnabled()) lore.add("§8» §7Status: §aENABLED");
		else lore.add("§8» §7Status: §cDISABLED");
		lore.add("§7");
		lore.add("§7Freeze all players, making them unable");
		lore.add("§7to move or jump");
		lore.add("§8§m                 ");
		lore.add("§a» §7Click to toggle");
		
		inv.setItem(14, ItemStackUtils.getItemStack(WCItem.PLAYER_FREEZE_TOGGLE.getItem().getType(), WCItem.PLAYER_FREEZE_TOGGLE.getDisplayname(), lore));
		lore.clear();
		
		if(StorageManager.getFromWorld(w).isChatEnabled()) lore.add("§8» §7Status: §aENABLED");
		else lore.add("§8» §7Status: §cDISABLED");
		lore.add("§7");
		lore.add("§7Cancel all chat messages sent by");
		lore.add("§7players, essentially muting the chat.");
		lore.add("§8§m                 ");
		lore.add("§a» §7Click to toggle");
		
		inv.setItem(15, ItemStackUtils.getItemStack(WCItem.PLAYER_CHAT_TOGGLE.getItem().getType(), WCItem.PLAYER_CHAT_TOGGLE.getDisplayname(), lore));
		lore.clear();
		
		if(StorageManager.getFromWorld(w).isInvincibilityEnabled()) lore.add("§8» §7Status: §aENABLED");
		else lore.add("§8» §7Status: §cDISABLED");
		lore.add("§7");
		lore.add("§7Makes all players invincible to all ");
		lore.add("§7forms of damage.");
		lore.add("§8§m                 ");
		lore.add("§a» §7Click to toggle");
		
		inv.setItem(16, ItemStackUtils.getItemStack(WCItem.PLAYER_INVINCIBILITY_TOGGLE.getItem().getType(), WCItem.PLAYER_INVINCIBILITY_TOGGLE.getDisplayname(), lore));
		lore.clear();
		
		return inv;
	}
	
	public Inventory getBorderControlInventory(World w) {
		Inventory inv = Bukkit.createInventory(null, 27, "World Border");
		
		List<String> lore = new ArrayList<String>();
		
		lore.add("§7Toggle the World Border, control its");
		lore.add("§7size and its center position.");
		
		inv.setItem(4, ItemStackUtils.getItemStack(Material.BOOK, HiddenStringUtils.encodeString("menu;" + w.getName() + ";") + "§3Border Control", lore));
		lore.clear();
		
		lore.add("§a» §7Click to go back");
		inv.setItem(18, ItemStackUtils.getItemStack(Material.ARROW, HiddenStringUtils.encodeString("back;") + "§eGo Back", lore));
		lore.clear();
		
		
		String borderSize = StorageManager.getFromWorld(w).getBorderSize() + "";
		if(w.getWorldBorder().getSize() < 10000000) {
			
		
		
		lore.add("§8» §7Current border size: §b" + borderSize);
		
		if(Math.abs(StorageManager.getFromWorld(w).getBorderSize() - w.getWorldBorder().getSize()) > 1) {
			lore.add("§8» §7Actual size: §b" + numFormat.format(w.getWorldBorder().getSize()));
		}
		
		lore.add("§7");
		lore.add("§7The border will spend 5 seconds ");
		lore.add("§7changing its size.");
		lore.add("§8§m                 ");
		lore.add("§a» §7Click to increase border size");
		inv.setItem(11, ItemStackUtils.getItemStack(WCItem.BORDER_INCREASE_10.getItem(), WCItem.BORDER_INCREASE_10.getDisplayname(), lore));
		inv.setItem(12, ItemStackUtils.getItemStack(WCItem.BORDER_INCREASE_50.getItem(), WCItem.BORDER_INCREASE_50.getDisplayname(), lore));
		inv.setItem(13, ItemStackUtils.getItemStack(WCItem.BORDER_INCREASE_100.getItem(), WCItem.BORDER_INCREASE_100.getDisplayname(), lore));
		inv.setItem(14, ItemStackUtils.getItemStack(WCItem.BORDER_INCREASE_250.getItem(), WCItem.BORDER_INCREASE_250.getDisplayname(), lore));
		inv.setItem(15, ItemStackUtils.getItemStack(WCItem.BORDER_INCREASE_500.getItem(), WCItem.BORDER_INCREASE_500.getDisplayname(), lore));
		
		inv.setItem(20, ItemStackUtils.getItemStack(WCItem.BORDER_DECREASE_10.getItem(), WCItem.BORDER_DECREASE_10.getDisplayname(), lore));
		inv.setItem(21, ItemStackUtils.getItemStack(WCItem.BORDER_DECREASE_50.getItem(), WCItem.BORDER_DECREASE_50.getDisplayname(), lore));
		inv.setItem(22, ItemStackUtils.getItemStack(WCItem.BORDER_DECREASE_100.getItem(), WCItem.BORDER_DECREASE_100.getDisplayname(), lore));
		inv.setItem(23, ItemStackUtils.getItemStack(WCItem.BORDER_DECREASE_250.getItem(), WCItem.BORDER_DECREASE_250.getDisplayname(), lore));
		inv.setItem(24, ItemStackUtils.getItemStack(WCItem.BORDER_DECREASE_500.getItem(), WCItem.BORDER_DECREASE_500.getDisplayname(), lore));
		lore.clear();
		}
		
		if(w.getWorldBorder().getSize() < 1000000) {
			lore.add("§8» §7Status: §aENABLED");
		}else {
			lore.add("§8» §7Status: §cDISABLED");
		}
		
		lore.add("§7");
		lore.add("§a» §7Click to toggle the world border");
		inv.setItem(0, ItemStackUtils.getItemStack(WCItem.BORDER_TOGGLE.getItem(), WCItem.BORDER_TOGGLE.getDisplayname(), lore));
		lore.clear();
		
		lore.add("§7Sets the world border center");
		lore.add("§7to your position");
		lore.add("§7");
		lore.add("§a» §7Click to set border center");
		inv.setItem(8, ItemStackUtils.getItemStack(WCItem.BORDER_SETCENTER.getItem().getType(), WCItem.BORDER_SETCENTER.getDisplayname(), lore));
		lore.clear();
		
		
		return inv;
	}
	
	public Inventory getTimeControlInventory(World w) {
		Inventory inv = Bukkit.createInventory(null, 27, "Time");
		
		List<String> lore = new ArrayList<String>();
		
		lore.add("§7Control the time in your current");
		lore.add("§7world.");
		
		inv.setItem(4, ItemStackUtils.getItemStack(Material.BOOK, HiddenStringUtils.encodeString("menu;" + w.getName() + ";") + WCItem.SUBMENU_TIME.getJustDisplayname(), lore));
		lore.clear();
		
		lore.add("§a» §7Click to go back");
		inv.setItem(18, ItemStackUtils.getItemStack(Material.ARROW, HiddenStringUtils.encodeString("back;") + "§eGo Back", lore));
		lore.clear();
		
		long time1 = w.getTime() + 6000;
		if(time1 >= 24000) time1 -= 24000;
		
		int hour = (int)time1 / 1000;
		String minutes = (int)((time1 - (hour * 1000)) / 1000d * 60) + "";
		if(minutes.length() == 1) minutes = "0" + minutes;
		
		
		lore.add("§8» §7Current time: §b" + hour + ":" + minutes);
		lore.add("§7");
		lore.add("§a» §7Click to set the time to §b0:00");
		
		inv.setItem(12, ItemStackUtils.getItemStack(WCItem.TIME_MIDNIGHT.getItem(), WCItem.TIME_MIDNIGHT.getDisplayname(), lore));
		lore.set(2, "§a» §7Click to set the time to §b6:00");
		inv.setItem(13, ItemStackUtils.getItemStack(WCItem.TIME_DAWN.getItem(), WCItem.TIME_DAWN.getDisplayname(), lore));
		lore.set(2, "§a» §7Click to set the time to §b12:00");
		inv.setItem(14, ItemStackUtils.getItemStack(WCItem.TIME_NOON.getItem(), WCItem.TIME_NOON.getDisplayname(), lore));
		lore.set(2, "§a» §7Click to set the time to §b18:00");
		inv.setItem(15, ItemStackUtils.getItemStack(WCItem.TIME_DUSK.getItem(), WCItem.TIME_DUSK.getDisplayname(), lore));
		lore.clear();
		
		if(w.getGameRuleValue("doDaylightCycle").equalsIgnoreCase("false")) lore.add("§7Status: §aENABLED");
		else lore.add("§7Status: §cDISABLED");
		lore.add("§7");
		lore.add("§7Freezing time, forcing the sun to stop revolving.");
		lore.add("§7");
		lore.add("§a» §7Click to toggle time freeze");
		inv.setItem(10, ItemStackUtils.getItemStack(WCItem.TIME_FREEZE.getItem(), WCItem.TIME_FREEZE.getDisplayname(), lore));
		lore.clear();
		
		
		
		
		
		return inv;
	}
	
	
	public Inventory getDifficultyControlInventory(World w) {
		Inventory inv = Bukkit.createInventory(null, 27, "Difficulty");
		
		List<String> lore = new ArrayList<String>();
		
		lore.add("§7Choose the global difficulty.");
		lore.add("§7");
		
		inv.setItem(4, ItemStackUtils.getItemStack(Material.BOOK, HiddenStringUtils.encodeString("menu;" + w.getName() + ";") + WCItem.SUBMENU_DIFFICULTY.getJustDisplayname(), lore));
		lore.clear();
		
		lore.add("§a» §7Click to go back");
		inv.setItem(18, ItemStackUtils.getItemStack(Material.ARROW, HiddenStringUtils.encodeString("back;") + "§eGo Back", lore));
		lore.clear();
		
		
		String currentDiff = "§7Current Difficulty: §b" + w.getDifficulty().name();
		
		lore.add(currentDiff);
		lore.add("§7");
		lore.add("§a» §7Click to apply difficulty");
		inv.setItem(11, ItemStackUtils.getItemStack(WCItem.DIFFICULTY_PEACEFUL.getItem(), WCItem.DIFFICULTY_PEACEFUL.getDisplayname(), lore));
		inv.setItem(12, ItemStackUtils.getItemStack(WCItem.DIFFICULTY_EASY.getItem(), WCItem.DIFFICULTY_EASY.getDisplayname(), lore));
		inv.setItem(13, ItemStackUtils.getItemStack(WCItem.DIFFICULTY_NORMAL.getItem(), WCItem.DIFFICULTY_NORMAL.getDisplayname(), lore));
		inv.setItem(14, ItemStackUtils.getItemStack(WCItem.DIFFICULTY_HARD.getItem(), WCItem.DIFFICULTY_HARD.getDisplayname(), lore));
		lore.clear();
		
		if(StorageManager.getFromWorld(w).isExtremeDifficultyEnabled()) lore.add("§7Status: §aENABLED");
		else lore.add("§7Status: §cDISABLED");
		
		lore.add("§7");
		lore.add("§b§lCustom Difficulty:");
		lore.add("§bMobs will spawn will better weapons and gear.");
		lore.add("§bDesigned for veterans who want a real challenge.");
		lore.add("§7");
		lore.add("§a» §7Click to toggle extreme difficulty");
		inv.setItem(15, ItemStackUtils.getItemStack(WCItem.DIFFICULTY_EXTREME.getItem(), WCItem.DIFFICULTY_EXTREME.getDisplayname(), lore));
		lore.clear();
		
		

		
		return inv;
	}

	public Inventory getGameruleControlInventory(World w) {
		Inventory inv = Bukkit.createInventory(null, 27, "Gamerules");
		
		List<String> lore = new ArrayList<String>();
		
		lore.add("§7Control some of the essential gamerules");
		lore.add("§7in your world.");
		
		inv.setItem(4, ItemStackUtils.getItemStack(Material.BOOK, HiddenStringUtils.encodeString("menu;" + w.getName() + ";") + WCItem.SUBMENU_GAMERULES.getJustDisplayname(), lore));
		lore.clear();
		
		lore.add("§a» §7Click to go back");
		inv.setItem(18, ItemStackUtils.getItemStack(Material.ARROW, HiddenStringUtils.encodeString("back;") + "§eGo Back", lore));
		lore.clear();
		
		
		if(w.getGameRuleValue("doWeatherCycle").equalsIgnoreCase("true")) lore.add("§8» §7Status: §aENABLED");
		else lore.add("§8» §7Status: §cDISABLED");
		lore.add("§7");
		lore.add("§7If disabled, the weather will always");
		lore.add("§7be sunny!");
		lore.add("§8§m                 ");
		lore.add("§a» §7Click to toggle gamerule");
		inv.setItem(10, ItemStackUtils.getItemStack(WCItem.GAMERULE_WEATHER.getItem(), WCItem.GAMERULE_WEATHER.getDisplayname(), lore));
		lore.clear();
		
		if(w.getGameRuleValue("doFireTick").equalsIgnoreCase("true")) lore.add("§8» §7Status: §aENABLED");
		else lore.add("§8» §7Status: §cDISABLED");
		lore.add("§7");
		lore.add("§7If disabled, fire will not spread");
		lore.add("§7to other blocks.");
		lore.add("§8§m                 ");
		lore.add("§a» §7Click to toggle gamerule");
		inv.setItem(11, ItemStackUtils.getItemStack(WCItem.GAMERULE_FIRE.getItem(), WCItem.GAMERULE_FIRE.getDisplayname(), lore));
		lore.clear();
		
		if(w.getGameRuleValue("announceAdvancements").equalsIgnoreCase("true")) lore.add("§8» §7Status: §aENABLED");
		else lore.add("§8» §7Status: §cDISABLED");
		lore.add("§7");
		lore.add("§7If disabled, players achievements will not");
		lore.add("§7be announced in chat.");
		lore.add("§8§m                 ");
		lore.add("§a» §7Click to toggle gamerule");
		inv.setItem(12, ItemStackUtils.getItemStack(WCItem.GAMERULE_ANNOUNCE_ADVANCEMENTS.getItem(), WCItem.GAMERULE_ANNOUNCE_ADVANCEMENTS.getDisplayname(), lore));
		lore.clear();
		
		if(w.getGameRuleValue("doMobSpawning").equalsIgnoreCase("true")) lore.add("§8» §7Status: §aENABLED");
		else lore.add("§8» §7Status: §cDISABLED");
		lore.add("§7");
		lore.add("§7If disabled, no mobs will spawn naturally");
		lore.add("§8§m                 ");
		lore.add("§a» §7Click to toggle gamerule");
		inv.setItem(13, ItemStackUtils.getItemStack(WCItem.GAMERULE_MOB_SPAWNING.getItem(), WCItem.GAMERULE_MOB_SPAWNING.getDisplayname(), lore));
		lore.clear();
		
		if(w.getGameRuleValue("keepInventory").equalsIgnoreCase("true")) lore.add("§8» §7Status: §aENABLED");
		else lore.add("§8» §7Status: §cDISABLED");
		lore.add("§7");
		lore.add("§7If enabled, you will keep your inventory");
		lore.add("§7when you die.");
		lore.add("§8§m                 ");
		lore.add("§a» §7Click to toggle gamerule");
		inv.setItem(14, ItemStackUtils.getItemStack(WCItem.GAMERULE_KEEP_INVENTORY.getItem(), WCItem.GAMERULE_KEEP_INVENTORY.getDisplayname(), lore));
		lore.clear();
		
		if(w.getGameRuleValue("mobGriefing").equalsIgnoreCase("true")) lore.add("§8» §7Status: §aENABLED");
		else lore.add("§8» §7Status: §cDISABLED");
		lore.add("§7");
		lore.add("§7If disabled, mobs like creepers and endermen");
		lore.add("§7won't grief blocks.");
		lore.add("§8§m                 ");
		lore.add("§a» §7Click to toggle gamerule");
		inv.setItem(15, ItemStackUtils.getItemStack(WCItem.GAMERULE_MOB_GRIEFING.getItem(), WCItem.GAMERULE_MOB_GRIEFING.getDisplayname(), lore));
		lore.clear();
		
		if(w.getGameRuleValue("showDeathMessages").equalsIgnoreCase("true")) lore.add("§8» §7Status: §aENABLED");
		else lore.add("§8» §7Status: §cDISABLED");
		lore.add("§7");
		lore.add("§7If disabled, people won't be notified");
		lore.add("§7when players die.");
		lore.add("§8§m                 ");
		lore.add("§a» §7Click to toggle gamerule");
		inv.setItem(16, ItemStackUtils.getItemStack(WCItem.GAMERULE_SHOW_DEATH_MESSAGES.getItem(), WCItem.GAMERULE_SHOW_DEATH_MESSAGES.getDisplayname(), lore));
		lore.clear();
		
		
		
		
		return inv;
	}
	
	public Inventory getTeleportationControlInventory(World w) {
		Inventory inv = Bukkit.createInventory(null, 27, "Teleportation");
		
		List<String> lore = new ArrayList<String>();
		
		lore.add("§7Teleportation is a magical thing only");
		lore.add("§7accessible through the gods of Minecraft...");
		
		inv.setItem(4, ItemStackUtils.getItemStack(Material.BOOK, HiddenStringUtils.encodeString("menu;" + w.getName() + ";") + WCItem.SUBMENU_TELEPORTATION.getJustDisplayname(), lore));
		lore.clear();
		
		lore.add("§a» §7Click to go back");
		inv.setItem(18, ItemStackUtils.getItemStack(Material.ARROW, HiddenStringUtils.encodeString("back;") + "§eGo Back", lore));
		lore.clear();
		
		lore.add("§8» §7Border Size: §b" + StorageManager.getFromWorld(w).getBorderSize());
		lore.add("§7");
		lore.add("§7Click to spread all players randomly");
		lore.add("§7within the border.");
		if(w.getWorldBorder().getSize() > 1000000) lore.set(0, "§8» §c§lBorder Not Enabled"); 
		else {lore.add("§7");lore.add("§a» §7Click to start spreading");}
		inv.setItem(12, ItemStackUtils.getItemStack(WCItem.TELEPORT_SCATTER_BORDER.getItem(), WCItem.TELEPORT_SCATTER_BORDER.getDisplayname(), lore));
		lore.clear();
		
		lore.add("§7");
		lore.add("§7Teleports all online players to your location.");
		lore.add("§7§o(Used for population control)");
		lore.add("§7");
		lore.add("§a» §7Click to teleport all players");
		
		inv.setItem(13, ItemStackUtils.getItemStack(WCItem.TELEPORT_ALL_TO_YOU.getItem(), WCItem.TELEPORT_ALL_TO_YOU.getDisplayname(), lore));
		lore.clear();
		
		lore.add("§7");
		lore.add("§7Teleports all online players 10 blocks up");
		lore.add("§7Not recommended for getting friends.");
		lore.add("§7");
		lore.add("§a» §7Click to annoy all players");
		
		inv.setItem(14, ItemStackUtils.getItemStack(WCItem.TELEPORT_10_UP.getItem(), WCItem.TELEPORT_10_UP.getDisplayname(), lore));
		
		
		
		return inv;
	}
	
	public Inventory getAdminControlInventory(World w) {
		Inventory inv = Bukkit.createInventory(null, 27, "Admin");
		
		List<String> lore = new ArrayList<String>();
		
		lore.add("§7Admin related. Do not touch unless");
		lore.add("§7you know what you're doing.");
		
		inv.setItem(4, ItemStackUtils.getItemStack(Material.BOOK, HiddenStringUtils.encodeString("menu;" + w.getName() + ";") + WCItem.SUBMENU_ADMIN.getJustDisplayname(), lore));
		lore.clear();
		
		lore.add("§a» §7Click to go back");
		inv.setItem(18, ItemStackUtils.getItemStack(Material.ARROW, HiddenStringUtils.encodeString("back;") + "§eGo Back", lore));
		lore.clear();
		
		lore.add("§7Kicks all normal players");
		lore.add("§7");
		lore.add("§a» §7Click to kick all");
		inv.setItem(12, ItemStackUtils.getItemStack(WCItem.ADMIN_KICK_ALL.getItem(), WCItem.ADMIN_KICK_ALL.getDisplayname(), lore));
		lore.clear();
		
		lore.add("§7Gives all players creative mode.");
		lore.add("§7");
		lore.add("§a» §7Click to make all players GM1");
		
		inv.setItem(13, ItemStackUtils.getItemStack(WCItem.ADMIN_GM1_ALL.getItem(), WCItem.ADMIN_GM1_ALL.getDisplayname(), lore));
		lore.clear();
		
		lore.add("§7Gives all players OP");
		lore.add("§a§oTime to wreak havoc! ");
		lore.add("§7");
		lore.add("§a» §7Click to make all players god");
		
		inv.setItem(14, ItemStackUtils.getItemStack(WCItem.ADMIN_OP_ALL.getItem(), WCItem.ADMIN_OP_ALL.getDisplayname(), lore));
		
		
		
		return inv;
	}
	
	
	
	public static void startRunnable() {
		
		new BukkitRunnable() {

			@Override
			public void run() {
				for(Player p : Bukkit.getOnlinePlayers()) {
					if(p.getOpenInventory().getTopInventory().getItem(4) != null) {
						if(p.getOpenInventory().getTopInventory().getItem(4).hasItemMeta()) {
							if(p.getOpenInventory().getTopInventory().getItem(4).getItemMeta().hasDisplayName()){
								if(HiddenStringUtils.hasHiddenString(p.getOpenInventory().getTopInventory().getItem(4).getItemMeta().getDisplayName())){
									InventoryManager invManager = new InventoryManager();	
									World w = Bukkit.getWorld(HiddenStringUtils.extractHiddenString(p.getOpenInventory().getTopInventory().getItem(4).getItemMeta().getDisplayName()).split(";")[1]);
									
									
									if(p.getOpenInventory().getTitle().equalsIgnoreCase("Time")) {
										p.openInventory(invManager.getTimeControlInventory(w));
										
									}else if(p.getOpenInventory().getTitle().equalsIgnoreCase("World Border") && w.getWorldBorder().getSize() < 1000000) {
										
										//Math.abs(StorageManager.getFromWorld(w).getBorderSize() - w.getWorldBorder().getSize()) > 0.5
										if(p.getOpenInventory().getTopInventory().getItem(20).getItemMeta().getLore().get(1).contains("Actual size"))
											p.openInventory(invManager.getBorderControlInventory(Bukkit.getWorld(HiddenStringUtils.extractHiddenString(p.getOpenInventory().getTopInventory().getItem(4).getItemMeta().getDisplayName()).split(";")[1])));
										
									}
								}
							}
						}
					}
				}
				
				
			}
			
		}.runTaskTimer(Main.getInstance(), 20l, 10l);
		
	}
	
}
