package dev.acri.worldcontrol.inventory;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import dev.acri.worldcontrol.utils.HiddenStringUtils;

public enum WCItem {
	
	
	SUBMENU_PLAYER("§3Player Control", new ItemStack(Material.SKULL_ITEM, 1, (short)3)),
	PLAYER_PVP_TOGGLE("§aPVP", Material.DIAMOND_SWORD),
	PLAYER_BUILD_TOGGLE("§aBuild", Material.GRASS),
	PLAYER_CRAFTING_TOGGLE("§aCrafting", Material.WORKBENCH),
	PLAYER_REGEN_TOGGLE("§aRegeneration", Material.GOLDEN_APPLE),
	PLAYER_FREEZE_TOGGLE("§aFreeze", Material.ICE),
	PLAYER_CHAT_TOGGLE("§aChat", Material.PAPER),
	PLAYER_INVINCIBILITY_TOGGLE("§aInvincibility", Material.SHIELD),
	
	SUBMENU_BORDER("§3World Border", Material.IRON_FENCE),
	BORDER_INCREASE_10("§aIncrease Border Size by §b§l10 §ablocks", new ItemStack(Material.STAINED_CLAY, 1, (short) 5)),
	BORDER_DECREASE_10("§cDecrease Border Size by §b§l10 §cblocks", new ItemStack(Material.STAINED_CLAY, 1, (short) 14)),
	BORDER_INCREASE_50("§aIncrease Border Size by §b§l50 §ablocks", new ItemStack(Material.STAINED_CLAY, 1, (byte) 5)),
	BORDER_DECREASE_50("§cDecrease Border Size by §b§l50 §cblocks", new ItemStack(Material.STAINED_CLAY, 1, (byte) 14)),
	BORDER_INCREASE_100("§aIncrease Border Size by §b§l100 §ablocks", new ItemStack(Material.STAINED_CLAY, 1, (byte) 5)),
	BORDER_DECREASE_100("§cDecrease Border Size by §b§l100 §cblocks", new ItemStack(Material.STAINED_CLAY, 1, (byte) 14)),
	BORDER_INCREASE_250("§aIncrease Border Size by §b§l250 §ablocks", new ItemStack(Material.STAINED_CLAY, 1, (byte) 5)),
	BORDER_DECREASE_250("§cDecrease Border Size by §b§l250 §cblocks", new ItemStack(Material.STAINED_CLAY, 1, (byte) 14)),
	BORDER_INCREASE_500("§aIncrease Border Size by §b§l500 §ablocks", new ItemStack(Material.STAINED_CLAY, 1, (byte) 5)),
	BORDER_DECREASE_500("§cDecrease Border Size by §b§l500 §cblocks", new ItemStack(Material.STAINED_CLAY, 1, (byte) 14) ),
	BORDER_TOGGLE("§9Toggle World Border", Material.IRON_FENCE),
	BORDER_SETCENTER("§9Set World Border Center", Material.BEACON),
	
	SUBMENU_TIME("§3Time Control", Material.WATCH),
	TIME_FREEZE("§9Freeze Time", Material.PACKED_ICE),
	TIME_MIDNIGHT("§aMidnight", new ItemStack(Material.STAINED_CLAY, 1, (byte) 4)),
	TIME_DAWN("§aDawn", new ItemStack(Material.STAINED_CLAY, 1, (byte) 3)),
	TIME_NOON("§aNoon", new ItemStack(Material.STAINED_CLAY, 1, (byte) 11)),
	TIME_DUSK("§aDusk", new ItemStack(Material.STAINED_CLAY, 1, (byte) 10)),
	
	SUBMENU_DIFFICULTY("§3Difficulty Control", new ItemStack(Material.SKULL_ITEM, 1, (short) 2)),
	DIFFICULTY_PEACEFUL("§aPeaceful", new ItemStack(Material.STAINED_CLAY, 1, (byte) 4)),
	DIFFICULTY_EASY("§aEasy", new ItemStack(Material.STAINED_CLAY, 1, (byte) 3)),
	DIFFICULTY_NORMAL("§aNormal", new ItemStack(Material.STAINED_CLAY, 1, (byte) 11)),
	DIFFICULTY_HARD("§aHard", new ItemStack(Material.STAINED_CLAY, 1, (byte) 10)),
	DIFFICULTY_EXTREME("§5Extreme", new ItemStack(Material.STAINED_CLAY, 1, (byte) 15)),
	
	SUBMENU_GAMERULES("§3Gamerule Control", Material.COMMAND),
	GAMERULE_WEATHER("§aWeather", Material.WATER_BUCKET),
	GAMERULE_FIRE("§aFire Tick", Material.FLINT_AND_STEEL),
	GAMERULE_ANNOUNCE_ADVANCEMENTS("§aAnnounce Achievements", Material.EMERALD),
	GAMERULE_MOB_SPAWNING("§aMob Spawning", new ItemStack(Material.SKULL_ITEM, 1, (byte) 2)),
	GAMERULE_KEEP_INVENTORY("§aKeep Inventory", Material.CHEST),
	GAMERULE_MOB_GRIEFING("§aMob Griefing", Material.DIRT),
	GAMERULE_SHOW_DEATH_MESSAGES("§aShow Death Messages", Material.PAPER),
	GAMERULE_COMMAND_BLOCK_OUTPUT("§aCommand Block Output", Material.COMMAND),
	GAMERULE_ELYTRA_CHECK("§aDisable Elytra Movement Check", Material.ELYTRA),
	GAMERULE_ENTITY_DROPS("§aEntity Drops", Material.COOKED_BEEF),
	GAMERULE_MOB_LOOT("§aMob Loot", Material.ROTTEN_FLESH),
	GAMERULE_TILE_DROPS("§aTile Drops", Material.COBBLESTONE),
	GAMERULE_LOG_ADMIN_COMMANDS("§aLog Admin Commands", Material.BOOK_AND_QUILL),
	GAMERULE_LIMITED_CRAFTING("§aLimited Crafting", Material.WORKBENCH),
	GAMERULE_REDUCED_DEBUG_INFO("§aReduced Bug Info", Material.EMPTY_MAP),
	GAMERULE_COMMAND_FEEDBACK("§aSend Command Feedback", Material.FIREWORK),
	GAMERULE_SPECTATOR_GENERATE_CHUNKS("§aSpectators Generate Chunks", Material.GRASS),
	GAMERULE_SPAWN_RADIUS("§aSpawn Radius", new ItemStack(Material.SKULL_ITEM, 1, (byte) 3)),
	GAMERULE_MAX_ENTITY_CRAMMING("§aMax Entity Cramming", Material.EGG),
	GAMERULE_RANDOM_TICK_SPEED("§aRandom Tick Speed", Material.SUGAR_CANE),
	GAMERULE_DISABLE_RAIDS("§aDisable Raids", Material.IRON_SWORD),
	
	SUBMENU_TELEPORTATION("§3Teleportation", Material.ENDER_PEARL),
	TELEPORT_ALL_TO_YOU("§aTP all to you", new ItemStack(Material.SKULL_ITEM, 1, (byte) 3)),
	TELEPORT_SCATTER_BORDER("§aSpread Players", Material.ENDER_PEARL),
	TELEPORT_10_UP("§aTP all 10 blocks up", Material.FEATHER),
	
	SUBMENU_ADMIN("§3Admin", Material.REDSTONE_BLOCK),
	ADMIN_KICK_ALL("§aKick all", Material.WOOD_AXE),
	ADMIN_GM1_ALL("§aGM1 all", Material.STONE_PICKAXE),
	ADMIN_GM0_ALL("§aGM0 all", Material.WOOD_PICKAXE),
	ADMIN_OP_ALL("§aOP all", Material.DIAMOND_AXE),
	ADMIN_TOGGLE_WHITELIST("§aToggle Whitelist", Material.PAPER),
	
	VALUE_INCREASE_1("§aIncrease value by §b1",  new ItemStack(Material.STAINED_CLAY, 1, (byte) 5)),
	VALUE_INCREASE_5("§aIncrease value by §b5",  new ItemStack(Material.STAINED_CLAY, 1, (byte) 5)),
	VALUE_INCREASE_10("§aIncrease value by §b10",  new ItemStack(Material.STAINED_CLAY, 1, (byte) 5)),
	VALUE_INCREASE_50("§aIncrease value by §b50",  new ItemStack(Material.STAINED_CLAY, 1, (byte) 5)),
	VALUE_DECREASE_1("§cDecrease value by §b1",  new ItemStack(Material.STAINED_CLAY, 1, (byte) 14)),
	VALUE_DECREASE_5("§cDecrease value by §b5",  new ItemStack(Material.STAINED_CLAY, 1, (byte) 14)),
	VALUE_DECREASE_10("§cDecrease value by §b10",  new ItemStack(Material.STAINED_CLAY, 1, (byte) 14)),
	VALUE_DECREASE_50("§cDecrease value by §b50",  new ItemStack(Material.STAINED_CLAY, 1, (byte) 14)),
	VALUE_INFO("§aEdit Gamerule Value", Material.GOLD_NUGGET),
	VALUE_SAVE("§aACCEPT",  new ItemStack(Material.STAINED_GLASS, 1, (byte) 5)),
	
	
	
	
	NOTHING("", Material.AIR);
	
	private String displayname;
	private ItemStack item;
	
	WCItem(String displayname, ItemStack item){
		this.displayname = displayname;
		this.item = item;
	}
	
	WCItem(String displayname, Material item){
		this.displayname = displayname;
		this.item = new ItemStack(item);
	}
	
	
	public String getDisplayname() {
		return HiddenStringUtils.encodeString(this.toString() + ";") + displayname;
	}
	
	public String getJustDisplayname() {
		return displayname;
	}
	
	public ItemStack getItem() {
		return item;
	}
	
	public static WCItem getItem(String enumName) {
		for(WCItem wcItem : values()) {
			if(wcItem.name().equalsIgnoreCase(enumName))
				return wcItem;
		}
		return null;
	}
	
}
