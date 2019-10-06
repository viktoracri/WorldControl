package dev.acri.worldcontrol.events;

import org.bukkit.Bukkit;
import org.bukkit.Difficulty;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryAction;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerTeleportEvent.TeleportCause;
import org.bukkit.inventory.ItemStack;

import dev.acri.worldcontrol.inventory.InventoryManager;
import dev.acri.worldcontrol.inventory.WCItem;
import dev.acri.worldcontrol.utils.HiddenStringUtils;
import dev.acri.worldcontrol.utils.Messager;
import dev.acri.worldcontrol.utils.SpreadPlayersThread;
import dev.acri.worldcontrol.utils.StorageManager;
import dev.acri.worldcontrol.utils.WorldBorderUtils;

public class InventoryClickListener implements Listener{
	
	InventoryManager invManager = new InventoryManager();
	WorldBorderUtils borderUtils = new WorldBorderUtils();
	
	@EventHandler
	public void onPlayerInventoryClick(InventoryClickEvent e) {
		
		Player p = (Player) e.getWhoClicked();
		ItemStack currentItem = e.getCurrentItem();
		ClickType clickType = e.getClick();
		InventoryAction invAction = e.getAction();
		String title = e.getView().getTitle();
		
		if(e.getClickedInventory() == null) {
			return ;
		}
		
		if(currentItem.getType().equals(Material.AIR))
			return;
		
		if(currentItem == null)
			return;
		
		
		boolean isMenu = false;

		
		if(e.getInventory().getItem(4) != null) {
			if(e.getInventory().getItem(4).getType() == Material.BOOK) {
				if(e.getInventory().getItem(4).hasItemMeta()) {
					if(HiddenStringUtils.extractHiddenString(e.getInventory().getItem(4).getItemMeta().getDisplayName()).contains("menu;")) {
						isMenu = true;
					}
				}
			}
		}
		
		if(isMenu) {
			
			World w = Bukkit.getWorld(HiddenStringUtils.extractHiddenString(e.getInventory().getItem(4).getItemMeta().getDisplayName()).split(";")[1]);
			
			if(!HiddenStringUtils.hasHiddenString(currentItem.getItemMeta().getDisplayName()))
				return;
			
			WCItem item = WCItem.getItem(HiddenStringUtils.extractHiddenString(currentItem.getItemMeta().getDisplayName()).split(";")[0]);
			if(item != null) {
				if(item == WCItem.SUBMENU_PLAYER) {
					p.openInventory(invManager.getPlayerControlInventory(w));
				}
				
				else if(item == WCItem.PLAYER_PVP_TOGGLE) {
					StorageManager.getFromWorld(p.getWorld()).setPvpEnabled(!StorageManager.getFromWorld(p.getWorld()).isPvpEnabled());
					p.openInventory(invManager.getPlayerControlInventory(w));
				}else if(item == WCItem.PLAYER_BUILD_TOGGLE) {
					StorageManager.getFromWorld(p.getWorld()).setBuildEnabled(!StorageManager.getFromWorld(p.getWorld()).isBuildEnabled());
					p.openInventory(invManager.getPlayerControlInventory(w));
				}else if(item == WCItem.PLAYER_REGEN_TOGGLE) {
					StorageManager.getFromWorld(p.getWorld()).setRegenEnabled(!StorageManager.getFromWorld(p.getWorld()).isRegenEnabled());
					p.openInventory(invManager.getPlayerControlInventory(w));
				}else if(item == WCItem.PLAYER_CRAFTING_TOGGLE) {
					StorageManager.getFromWorld(p.getWorld()).setCraftingEnabled(!StorageManager.getFromWorld(p.getWorld()).isCraftingEnabled());
					p.openInventory(invManager.getPlayerControlInventory(w));
				}else if(item == WCItem.PLAYER_FREEZE_TOGGLE) {
					StorageManager.getFromWorld(p.getWorld()).setFreezeEnabled(!StorageManager.getFromWorld(p.getWorld()).isFreezeEnabled());
					p.openInventory(invManager.getPlayerControlInventory(w));
				}else if(item == WCItem.PLAYER_CHAT_TOGGLE) {
					StorageManager.getFromWorld(p.getWorld()).setChatEnabled(!StorageManager.getFromWorld(p.getWorld()).isChatEnabled());
					p.openInventory(invManager.getPlayerControlInventory(w));
				}else if(item == WCItem.PLAYER_INVINCIBILITY_TOGGLE) {
					StorageManager.getFromWorld(p.getWorld()).setInvincibilityEnabled(!StorageManager.getFromWorld(p.getWorld()).isInvincibilityEnabled());
					p.openInventory(invManager.getPlayerControlInventory(w));
				}
				
				
				else if(item == WCItem.SUBMENU_BORDER) {
					p.openInventory(invManager.getBorderControlInventory(w));
				}
				
				else if(item == WCItem.BORDER_INCREASE_10) {
					borderUtils.increaseWorldBorder(p, 10);
					p.openInventory(invManager.getBorderControlInventory(w));
				}else if(item == WCItem.BORDER_INCREASE_50) {
					borderUtils.increaseWorldBorder(p, 50);
					p.openInventory(invManager.getBorderControlInventory(w));
				}else if(item == WCItem.BORDER_INCREASE_100) {
					borderUtils.increaseWorldBorder(p, 100);
					p.openInventory(invManager.getBorderControlInventory(w));
				}else if(item == WCItem.BORDER_INCREASE_250) {
					borderUtils.increaseWorldBorder(p, 250);
					p.openInventory(invManager.getBorderControlInventory(w));
				}else if(item == WCItem.BORDER_INCREASE_500) {
					borderUtils.increaseWorldBorder(p, 500);
					p.openInventory(invManager.getBorderControlInventory(w));
				}
				else if(item == WCItem.BORDER_DECREASE_10) {
					borderUtils.decreaseWorldBorder(p, 10);
					p.openInventory(invManager.getBorderControlInventory(w));
				}else if(item == WCItem.BORDER_DECREASE_50) {
					borderUtils.decreaseWorldBorder(p, 50);
					p.openInventory(invManager.getBorderControlInventory(w));
				}else if(item == WCItem.BORDER_DECREASE_100) {
					borderUtils.decreaseWorldBorder(p, 100);
					p.openInventory(invManager.getBorderControlInventory(w));
				}else if(item == WCItem.BORDER_DECREASE_250) {
					borderUtils.decreaseWorldBorder(p, 250);
					p.openInventory(invManager.getBorderControlInventory(w));
				}else if(item == WCItem.BORDER_DECREASE_500) {
					borderUtils.decreaseWorldBorder(p, 500);
					p.openInventory(invManager.getBorderControlInventory(w));
				}
				else if(item == WCItem.BORDER_TOGGLE) {
					if(w.getWorldBorder().getSize() < 1000000) {
						borderUtils.resetWorldBorder(p.getWorld());
						p.openInventory(invManager.getBorderControlInventory(w));
						Messager.sendMessageWithSound(p, "§cThe World Border has been turned off.", Sound.ENTITY_CHICKEN_EGG);
					}else {
						borderUtils.setDefaultBorder(p);
						p.openInventory(invManager.getBorderControlInventory(w));
						Messager.sendMessageWithSound(p, "§aThe World Border has been turned on.", Sound.ENTITY_CHICKEN_EGG);
					}	
				}else if(item == WCItem.BORDER_SETCENTER) {
					borderUtils.setBorderCenter(p.getWorld(), p.getLocation());
					Messager.sendMessageWithSound(p, "The World Border has been centered at your position.", Sound.ENTITY_CHICKEN_EGG);
				}
				
				else if(item == WCItem.SUBMENU_TIME) {
					p.openInventory(invManager.getTimeControlInventory(w));
				}else if(item == WCItem.TIME_MIDNIGHT) {
					w.setTime(18000);
					Messager.sendMessageWithSound(p, "The Time was set to §b0:00", Sound.ENTITY_CHICKEN_EGG);
					p.openInventory(invManager.getTimeControlInventory(w));
				}else if(item == WCItem.TIME_DAWN) {
					w.setTime(0);
					Messager.sendMessageWithSound(p, "The Time was set to §b6:00", Sound.ENTITY_CHICKEN_EGG);
					p.openInventory(invManager.getTimeControlInventory(w));
				}else if(item == WCItem.TIME_NOON) {
					w.setTime(6000);
					Messager.sendMessageWithSound(p, "The Time was set to §b12:00", Sound.ENTITY_CHICKEN_EGG);
					p.openInventory(invManager.getTimeControlInventory(w));
				}else if(item == WCItem.TIME_DUSK) {
					w.setTime(12000);
					Messager.sendMessageWithSound(p, "The Time was set to §b18:00", Sound.ENTITY_CHICKEN_EGG);
					p.openInventory(invManager.getTimeControlInventory(w));
				}else if(item == WCItem.TIME_FREEZE) {
					w.setGameRuleValue("doDaylightCycle", (!Boolean.parseBoolean(w.getGameRuleValue("doDaylightCycle"))) + "");
					if(w.getGameRuleValue("doDaylightCycle").equalsIgnoreCase("true"))
						Messager.sendMessageWithSound(p, "Time Freeze has been turned on.", Sound.ENTITY_CHICKEN_EGG);
					else Messager.sendMessageWithSound(p, "§cTime Freeze has been turned off.", Sound.ENTITY_CHICKEN_EGG);
					p.openInventory(invManager.getTimeControlInventory(w));
				}
				
				else if(item == WCItem.SUBMENU_DIFFICULTY) {
					p.openInventory(invManager.getDifficultyControlInventory(w));
				}else if(item == WCItem.DIFFICULTY_PEACEFUL) {
					w.setDifficulty(Difficulty.PEACEFUL);
					p.openInventory(invManager.getDifficultyControlInventory(w));
					Messager.sendMessageWithSound(p, "The Difficulty was set to §bPeaceful", Sound.ENTITY_CHICKEN_EGG);
				}else if(item == WCItem.DIFFICULTY_EASY) {
					w.setDifficulty(Difficulty.EASY);
					p.openInventory(invManager.getDifficultyControlInventory(w));
					Messager.sendMessageWithSound(p, "The Difficulty was set to §bEasy", Sound.ENTITY_CHICKEN_EGG);
				}else if(item == WCItem.DIFFICULTY_NORMAL) {
					w.setDifficulty(Difficulty.NORMAL);
					p.openInventory(invManager.getDifficultyControlInventory(w));
					Messager.sendMessageWithSound(p, "The Difficulty was set to §bNormal", Sound.ENTITY_CHICKEN_EGG);
				}else if(item == WCItem.DIFFICULTY_HARD) {
					w.setDifficulty(Difficulty.HARD);
					p.openInventory(invManager.getDifficultyControlInventory(w));
					Messager.sendMessageWithSound(p, "The Difficulty was set to §bHard", Sound.ENTITY_CHICKEN_EGG);
				}else if(item == WCItem.DIFFICULTY_EXTREME) {
					StorageManager.getFromWorld(w).setExtremeDifficultyEnabled(!StorageManager.getFromWorld(w).isExtremeDifficultyEnabled());
					if(StorageManager.getFromWorld(w).isExtremeDifficultyEnabled())
						Messager.sendMessageWithSound(p, "§5EXTREME §amode has been turned on.", Sound.ENTITY_CHICKEN_EGG);
					else Messager.sendMessageWithSound(p, "§5EXTREME §cmode has been turned off.", Sound.ENTITY_CHICKEN_EGG);
					p.openInventory(invManager.getDifficultyControlInventory(w));
				}
				
				else if(item == WCItem.SUBMENU_GAMERULES) {
					p.openInventory(invManager.getGameruleControlInventory(w));
				}else if(item == WCItem.GAMERULE_FIRE) {
					w.setGameRuleValue("doFireTick", (!Boolean.parseBoolean(w.getGameRuleValue("doFireTick"))) + "");
					p.openInventory(invManager.getGameruleControlInventory(w));
				}else if(item == WCItem.GAMERULE_MOB_GRIEFING) {
					w.setGameRuleValue("mobGriefing", (!Boolean.parseBoolean(w.getGameRuleValue("mobGriefing"))) + "");
					p.openInventory(invManager.getGameruleControlInventory(w));
				}else if(item == WCItem.GAMERULE_ANNOUNCE_ADVANCEMENTS) {
					w.setGameRuleValue("announceAdvancements", (!Boolean.parseBoolean(w.getGameRuleValue("announceAdvancements"))) + "");
					p.openInventory(invManager.getGameruleControlInventory(w));
				}else if(item == WCItem.GAMERULE_MOB_SPAWNING) {
					w.setGameRuleValue("doMobSpawning", (!Boolean.parseBoolean(w.getGameRuleValue("doMobSpawning"))) + "");
					p.openInventory(invManager.getGameruleControlInventory(w));
				}else if(item == WCItem.GAMERULE_WEATHER) {
					w.setGameRuleValue("doWeatherCycle", (!Boolean.parseBoolean(w.getGameRuleValue("doWeatherCycle"))) + "");
					p.openInventory(invManager.getGameruleControlInventory(w));
				}else if(item == WCItem.GAMERULE_KEEP_INVENTORY) {
					w.setGameRuleValue("keepInventory", (!Boolean.parseBoolean(w.getGameRuleValue("keepInventory"))) + "");
					p.openInventory(invManager.getGameruleControlInventory(w));
				}else if(item == WCItem.GAMERULE_SHOW_DEATH_MESSAGES) {
					w.setGameRuleValue("showDeathMessages", (!Boolean.parseBoolean(w.getGameRuleValue("showDeathMessages"))) + "");
					p.openInventory(invManager.getGameruleControlInventory(w));
				}
				
				else if(item == WCItem.SUBMENU_TELEPORTATION) {
					p.openInventory(invManager.getTeleportationControlInventory(w));
				}else if(item == WCItem.TELEPORT_SCATTER_BORDER) {
					if(w.getWorldBorder().getSize() < 1000000) {
						p.closeInventory();
						SpreadPlayersThread spt = new SpreadPlayersThread(w);
						spt.start();
					}
				}else if(item == WCItem.TELEPORT_ALL_TO_YOU) {
					for(Player target : Bukkit.getOnlinePlayers()) {
						target.teleport(p, TeleportCause.COMMAND);
					}
					Messager.sendMessageWithSound(p, "All players were teleported to you.", Sound.ENTITY_CHICKEN_EGG);
				}else if(item == WCItem.TELEPORT_10_UP) {
					for(Player all : Bukkit.getOnlinePlayers()) {
						Location loc = all.getLocation();
						loc.setY(loc.getY() + 10);
						all.teleport(loc);
					}
					Messager.sendMessageWithSound(p, "All players has been successfully annoyed.", Sound.ENTITY_CHICKEN_EGG);
				}
				
				else if(item == WCItem.SUBMENU_ADMIN) {
					p.openInventory(invManager.getAdminControlInventory(w));
				}else if(item == WCItem.ADMIN_KICK_ALL) {
					for(Player all : Bukkit.getOnlinePlayers()) {
						if(!all.hasPermission("worldcontrol.admin.kickall.bypass") && !all.isOp()) {
							all.kickPlayer("Thou hast been gekicked");
						}
					}
					p.closeInventory();
					Messager.sendMessageWithSound(p, "All players has been kicked.", Sound.ENTITY_CHICKEN_EGG);
				}else if(item == WCItem.ADMIN_GM1_ALL) {
					for(Player all : Bukkit.getOnlinePlayers()) {
						all.setGameMode(GameMode.CREATIVE);
					}
					p.closeInventory();
					Messager.sendMessageWithSound(p, "All players has been given Bob the Builder-powers", Sound.ENTITY_CHICKEN_EGG);
				}else if(item == WCItem.ADMIN_OP_ALL) {
					for(Player all : Bukkit.getOnlinePlayers()) {
						all.setOp(true);
					}
					p.closeInventory();
					Messager.sendMessageWithSound(p, "Say goodbye to your server.", Sound.ENTITY_CHICKEN_EGG);
				}
				
				
			}else {
				if(HiddenStringUtils.extractHiddenString(currentItem.getItemMeta().getDisplayName()).equalsIgnoreCase("back;"))
					p.openInventory(invManager.getControlInventory(w));
				
				
			}
			
			
			
			e.setCancelled(true);
		}
		
		
	}

}